package de.gupta.atlas.domain.model.builder.result;

import de.gupta.aletheia.functional.Unfolding;
import de.gupta.commons.utility.exception.ExceptionHelper;
import de.gupta.validation.aegis.api.validation.result.ValidationResult;

import java.util.Optional;

record FailedBuilderResult<Model>(ValidationResult validation) implements BuilderResult<Model>
{
	public FailedBuilderResult
	{
		Unfolding.beckon(validation)
		         .interdict(ValidationResult::isValid,
				         ExceptionHelper.iaeFrom("Validation must be invalid for a failure result"));
	}

	@Override
	public Optional<Model> model()
	{
		return Optional.empty();
	}
}