package de.gupta.atlas.domain.model.builder.result;


import de.gupta.validation.aegis.api.validation.result.ValidationResult;

import java.util.Optional;

public sealed interface BuilderResult<Model> permits FailedBuilderResult, SuccessfulBuilderResult
{
	ValidationResult validation();

	Optional<Model> model();
}