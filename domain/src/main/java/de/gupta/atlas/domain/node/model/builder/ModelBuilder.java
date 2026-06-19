package de.gupta.atlas.domain.node.model.builder;


import de.gupta.validation.aegis.api.validation.validation.outcome.ValidationOutcome;

@FunctionalInterface
public interface ModelBuilder<Model>
{
	ValidationOutcome<Model> build();
}