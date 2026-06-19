package de.gupta.atlas.domain.node.model.builder;


import de.gupta.validation.aegis.api.validation.outcome.Outcome;

@FunctionalInterface
public interface ModelBuilder<Model>
{
	Outcome<Model> build();
}