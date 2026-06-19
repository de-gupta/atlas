package de.gupta.atlas.domain.node.useCase.operation.create.service;

import de.gupta.atlas.domain.node.useCase.identification.identified.IdentifiedModel;
import de.gupta.validation.aegis.api.validation.outcome.Outcome;

import java.util.Collection;
import java.util.List;

public class SaveNodeServiceImpl<CreationInput, ID, ResponseProjection>
		implements SaveNodeService<CreationInput, ID, ResponseProjection>
{
	@Override
	public Outcome<IdentifiedModel<ID, ResponseProjection>> save(final CreationInput input)
	{
		return saveAll(List.of(input)).map(projections -> projections.stream().findFirst().orElseThrow(
				() -> new IllegalStateException("No models were saved")));
	}

	@Override
	public Outcome<Collection<IdentifiedModel<ID, ResponseProjection>>> saveAll(final Collection<CreationInput> input)
	{
		return null;
	}
}