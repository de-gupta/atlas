package de.gupta.atlas.domain.node.model.builder;

public interface ModelBuilderFactory<Model, V extends ModelBuilder<? extends Model>>
{
	V builder();
}