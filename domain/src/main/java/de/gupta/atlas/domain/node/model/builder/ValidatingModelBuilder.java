package de.gupta.atlas.domain.node.model.builder;


import de.gupta.aletheia.functional.Unfolding;
import de.gupta.atlas.domain.node.model.BaseDomainModel;
import de.gupta.validation.aegis.api.validation.validation.outcome.OutcomeFactory;
import de.gupta.validation.aegis.api.validation.validation.outcome.ValidationOutcome;
import de.gupta.validation.aegis.api.validation.validation.policy.ValidationPolicy;
import de.gupta.validation.aegis.api.validation.validation.policy.ValidationPolicyFactory;
import de.gupta.validation.aegis.api.validation.validator.Validatable;

public abstract class ValidatingModelBuilder<DomainModel extends BaseDomainModel> implements ModelBuilder<DomainModel>
{
	@Override
	public final ValidationOutcome<DomainModel> build()
	{
		setOptionalFieldsToDefaultValues();
		DomainModel domainModel = doBuild();
		return Unfolding.beckon(domainModel)
		                .metamorphose(Validatable::validate)
		                .coronate(result -> OutcomeFactory.outcome(domainModel, result, policy()));
	}

	protected void setOptionalFieldsToDefaultValues()
	{
	}

	protected abstract DomainModel doBuild();

	protected ValidationPolicy policy()
	{
		return ValidationPolicyFactory.withAtMostLowSeverity();
	}
}