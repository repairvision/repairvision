package org.sidiff.revision.impact.analysis;

/**
 * A container for potential impact scopes/analysis.
 * 
 * @author Manuel Ohrndorf
 */
public interface ImpactAnalyzes {
	
	/**
	 * @return Interface to get all elements that are in the impact scope.
	 */
	ImpactScope getImpactScope();

	/**
	 * @return Interface for testing changes on specific model elements for impact.
	 */
	ImpactAnalysis getImpactAnalysis();
	
	/**
	 * @return Interface for querying model elements by specific changes.
	 */
	PotentialImpactScope getPotentialImpactScope();
	
	/**
	 * @return Interface for testing specific changes for impact.
	 */
	PotentialImpactAnalysis getPotentialImpactAnalysis();

}