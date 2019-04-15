package org.sidiff.common.emf.access.path;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * API-Marker-Interface that indicates the Path-Access-Strategy that creates node sequences regarding
 * the given Path. There are no guarantee about the order of the sequences. 
 * 
 */
public interface PathsAccessStrategy extends PathEvaluationStrategy<Collection<List<EObject>>>{
	//Marker Interface
}
