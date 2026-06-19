package de.gupta.atlas.domain.node.useCase.operation.create.application.port.in;

import de.gupta.atlas.domain.node.useCase.identification.identified.IdentifiedModel;
import de.gupta.validation.aegis.api.validation.validation.outcome.ValidationOutcome;

import java.util.Collection;

public interface SaveNodeController<CreationInput, ID, ResponseProjection>
{
	ValidationOutcome<IdentifiedModel<ID, ResponseProjection>> save(final CreationInput input);

	ValidationOutcome<Collection<IdentifiedModel<ID, ResponseProjection>>> saveAll(
			final Collection<CreationInput> input);
}