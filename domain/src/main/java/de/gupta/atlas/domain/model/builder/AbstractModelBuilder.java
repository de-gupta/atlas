package de.gupta.atlas.domain.model.builder;


import de.gupta.aletheia.functional.Unfolding;
import de.gupta.atlas.domain.model.builder.result.BuilderResult;
import de.gupta.atlas.domain.model.builder.result.BuilderResultFactory;
import de.gupta.validation.aegis.api.validation.result.ValidationResult;
import de.gupta.validation.aegis.api.validator.Validatable;

public abstract class AbstractModelBuilder<Model extends Validatable> implements ModelBuilder<Model>
{
	@Override
	public final BuilderResult<Model> build()
	{
		setOptionalFieldsToDefaultValues();
		Model model = doBuild();
		return Unfolding.beckon(model)
		                .metamorphose(Validatable::validate)
		                .coronate(ValidationResult::isValid, v -> BuilderResultFactory.success(v, model),
								BuilderResultFactory::failure);
	}

	protected void setOptionalFieldsToDefaultValues()
	{
	}

	protected abstract Model doBuild();
}