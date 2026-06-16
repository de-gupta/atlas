package de.gupta.atlas.domain.model.builder.result;


import de.gupta.validation.aegis.api.validation.result.ValidationResult;
import de.gupta.validation.aegis.api.validation.result.ValidationResultFactory;

public final class BuilderResultFactory
{
	public static <Model> BuilderResult<Model> success(final ValidationResult validation, final Model validatedModel)
	{
		return new SuccessfulBuilderResult<>(validation, validatedModel);
	}

	public static <Model> BuilderResult<Model> success(final Model validatedModel)
	{
		return new SuccessfulBuilderResult<>(ValidationResultFactory.success(), validatedModel);
	}

	public static <Model> BuilderResult<Model> failure(final ValidationResult validation)
	{
		return new FailedBuilderResult<>(validation);
	}

	public static <Model> BuilderResult<Model> failure()
	{
		return new FailedBuilderResult<>(ValidationResultFactory.failure());
	}

	private BuilderResultFactory()
	{
	}
}