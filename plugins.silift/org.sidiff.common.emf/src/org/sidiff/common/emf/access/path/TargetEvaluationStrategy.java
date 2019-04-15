package org.sidiff.common.emf.access.path;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

/**
 * API-Marker-Interface that indicates the 'natural' Path-Access-Strategy that computes the Target
 * Objects addressed by the given Path.
 *
 */
public interface TargetEvaluationStrategy extends PathEvaluationStrategy<Collection<EObject>>{
	//Marker Interface
}
