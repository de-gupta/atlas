package de.gupta.atlas.domain.node.model.builder;


import de.gupta.aletheia.functional.Unfolding;
import de.gupta.atlas.domain.node.model.BaseDomainModel;
import de.gupta.atlas.domain.node.model.builder.result.BuilderResult;
import de.gupta.atlas.domain.node.model.builder.result.BuilderResultFactory;
import de.gupta.validation.aegis.api.validation.result.ValidationResult;
import de.gupta.validation.aegis.api.validator.Validatable;

public abstract class AbstractModelBuilder<DomainModel extends BaseDomainModel> implements ModelBuilder<DomainModel>
{
	@Override
	public final BuilderResult<DomainModel> build()
	{
		setOptionalFieldsToDefaultValues();
		DomainModel domainModel = doBuild();
		return Unfolding.beckon(domainModel)
		                .metamorphose(Validatable::validate)
		                .coronate(ValidationResult::isValid, v -> BuilderResultFactory.success(v, domainModel),
								BuilderResultFactory::failure);
	}

	protected void setOptionalFieldsToDefaultValues()
	{
	}

	protected abstract DomainModel doBuild();
}