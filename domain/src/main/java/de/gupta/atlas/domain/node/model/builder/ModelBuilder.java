package de.gupta.atlas.domain.node.model.builder;


import de.gupta.atlas.domain.node.model.builder.result.BuilderResult;

public interface ModelBuilder<Model>
{
	BuilderResult<Model> build();
}