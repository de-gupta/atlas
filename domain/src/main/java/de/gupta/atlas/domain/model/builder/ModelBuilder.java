package de.gupta.atlas.domain.model.builder;


import de.gupta.atlas.domain.model.builder.result.BuilderResult;

public interface ModelBuilder<Model>
{
	BuilderResult<Model> build();
}