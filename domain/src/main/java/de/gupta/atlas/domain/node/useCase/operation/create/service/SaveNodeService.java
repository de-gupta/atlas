package de.gupta.atlas.domain.node.useCase.operation.create.service;

import de.gupta.atlas.domain.node.useCase.identification.identified.IdentifiedModel;
import de.gupta.validation.aegis.api.validation.outcome.Outcome;

import java.util.Collection;

public interface SaveNodeService<CreationInput, ID, ResponseProjection>
{
	Outcome<IdentifiedModel<ID, ResponseProjection>> save(final CreationInput input);

	Outcome<Collection<IdentifiedModel<ID, ResponseProjection>>> saveAll(final Collection<CreationInput> input);
}