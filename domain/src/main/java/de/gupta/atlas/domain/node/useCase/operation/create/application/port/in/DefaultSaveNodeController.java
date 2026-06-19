package de.gupta.atlas.domain.node.useCase.operation.create.application.port.in;

import de.gupta.atlas.domain.node.useCase.identification.identified.IdentifiedModel;
import de.gupta.atlas.domain.node.useCase.operation.create.service.SaveNodeService;
import de.gupta.validation.aegis.api.validation.validation.outcome.ValidationOutcome;

import java.util.Collection;

final class DefaultSaveNodeController<CreationInput, ID, ResponseProjection>
		implements SaveNodeController<CreationInput, ID, ResponseProjection>
{
	private final SaveNodeService<CreationInput, ID, ResponseProjection> saveNodeService;

	@Override
	public ValidationOutcome<IdentifiedModel<ID, ResponseProjection>> save(final CreationInput input)
	{
		return saveNodeService.save(input);
	}

	@Override
	public ValidationOutcome<Collection<IdentifiedModel<ID, ResponseProjection>>> saveAll(
			final Collection<CreationInput> input)
	{
		return saveNodeService.saveAll(input);
	}

	DefaultSaveNodeController(final SaveNodeService<CreationInput, ID, ResponseProjection> saveNodeService)
	{
		this.saveNodeService = saveNodeService;
	}
}