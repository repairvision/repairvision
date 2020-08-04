package org.sidiff.revision.api.util;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;

public interface IMatching {

	List<GraphElement> getChanges();

	Iterator<EObject> getMatches(Node node);

}