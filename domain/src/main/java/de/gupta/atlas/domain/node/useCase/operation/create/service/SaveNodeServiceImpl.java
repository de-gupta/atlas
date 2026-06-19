package de.gupta.atlas.domain.node.useCase.operation.create.service;

import de.gupta.atlas.domain.node.useCase.identification.identified.IdentifiedModel;
import de.gupta.validation.aegis.api.validation.validation.outcome.ValidationOutcome;

import java.util.Collection;
import java.util.List;

public class SaveNodeServiceImpl<CreationInput, ID, ResponseProjection>
		implements SaveNodeService<CreationInput, ID, ResponseProjection>
{
	@Override
	public ValidationOutcome<IdentifiedModel<ID, ResponseProjection>> save(final CreationInput input)
	{
		return saveAll(List.of(input)).map(projections -> projections.stream().findFirst().orElseThrow(
				() -> new IllegalStateException("No models were saved")));
	}

	@Override
	public ValidationOutcome<Collection<IdentifiedModel<ID, ResponseProjection>>> saveAll(
			final Collection<CreationInput> input)
	{
		return null;
	}
}