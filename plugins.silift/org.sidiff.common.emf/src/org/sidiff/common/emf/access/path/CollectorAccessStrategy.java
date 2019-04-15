package org.sidiff.common.emf.access.path;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

/**
 * API-Marker-Interface that indicates the Path-Access-Strategy that collects 
 * all "on way" nodes in a single set.
 * There are no guarantee about the nodes order. 
 */
public interface CollectorAccessStrategy extends PathEvaluationStrategy<Collection<EObject>>{
	// Marker Interface
}
