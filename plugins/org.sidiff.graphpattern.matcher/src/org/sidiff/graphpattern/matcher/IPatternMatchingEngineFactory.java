package org.sidiff.graphpattern.matcher;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.matching.IMatching;

/**
 * Creates a new matching engine. Used to register new engines to the extension
 * point: <code>org.sidiff.graphpattern.matcher.factory</code>
 * 
 * @author Manuel Ohrndorf
 */
public interface IPatternMatchingEngineFactory<M extends IMatching> {

	/**
	 * Creates an <strong>initialized</strong> pattern matching engine.
	 * 
	 * @param graphpattern
	 *            The graph pattern definition.
	 * @param targetModels
	 *            All target model resources.
	 * @return The <strong>initialized</strong> pattern matching engine.
	 */
	IPatternMatchingEngine<M> createPatternMatchingEngine(GraphPattern graphpattern, ResourceSet targetModels);
}
