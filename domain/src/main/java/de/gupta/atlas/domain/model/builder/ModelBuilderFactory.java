package de.gupta.atlas.domain.model.builder;

public interface ModelBuilderFactory<Model, V extends ModelBuilder<? extends Model>>
{
	V builder();
}