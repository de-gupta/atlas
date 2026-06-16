package de.gupta.atlas.domain.model.builder.result;

import de.gupta.aletheia.functional.Unfolding;
import de.gupta.commons.utility.exception.ExceptionHelper;
import de.gupta.validation.aegis.api.validation.result.ValidationResult;

import java.util.Optional;

record SuccessfulBuilderResult<Model>(ValidationResult validation, Model validatedModel)
		implements BuilderResult<Model>
{
	public SuccessfulBuilderResult
	{
		Unfolding.beckon(validation)
		         .discern(ValidationResult::isValid,
						 ExceptionHelper.iaeFrom("Validation must be valid for a success result"));
	}

	@Override
	public Optional<Model> model()
	{
		return Optional.of(validatedModel);
	}
}