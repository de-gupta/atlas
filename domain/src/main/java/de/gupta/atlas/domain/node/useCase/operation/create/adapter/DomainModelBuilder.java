package de.gupta.atlas.domain.node.useCase.operation.create.adapter;

import de.gupta.atlas.domain.node.model.BaseDomainModel;
import de.gupta.validation.aegis.api.validation.validation.outcome.ValidationOutcome;

public interface DomainModelBuilder<DomainModel extends BaseDomainModel, CreationInput>
{
	ValidationOutcome<DomainModel> build(final CreationInput input);
}