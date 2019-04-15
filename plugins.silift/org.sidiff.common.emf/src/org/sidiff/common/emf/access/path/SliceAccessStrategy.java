package org.sidiff.common.emf.access.path;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * API-Marker-Interface that indicates the Path-Access-Strategy that creates lists of targets 
 * of each path step 
 *
 */
public interface SliceAccessStrategy extends PathEvaluationStrategy<List<Collection<EObject>>> {
	//Marker Interface
}
