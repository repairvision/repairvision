package org.sidiff.consistency.graphpattern.matcher;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.GraphPattern;

public interface IPatternMatchingEngineFactory {

	/**
	 * Creates an <strong>initialized</strong> pattern matching engine.
	 * 
	 * @param graphpattern
	 *            The graph pattern definition.
	 * @param targetModels
	 *            All target model resources.
	 * @return The <strong>initialized</strong> pattern matching engine.
	 */
	IPatternMatchingEngine createPatternMatchingEngine(GraphPattern graphpattern, ResourceSet targetModels);
}
