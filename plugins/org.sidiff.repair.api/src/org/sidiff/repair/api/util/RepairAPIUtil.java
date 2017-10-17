package org.sidiff.repair.api.util;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.henshin.model.Action;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;

public class RepairAPIUtil {

	public static URI getDifferenceURI(URI modelA, URI modelB) {
		return URI.createURI(
				modelA.trimFileExtension().toString() + "_to_" +
				modelB.trimFileExtension().appendFileExtension(".symmetric").lastSegment());
	}
	
	public static URI getRecognitionRuleURI(URI editRule, String fileExtension) {
		return editRule.trimSegments(1).appendSegment("rr_" + editRule.lastSegment())
				.trimFileExtension().appendFileExtension(fileExtension);
	}
	
	public static int countOfNodeChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Node) {
				++count;
			}
		}
		
		return count;
	}
	
	public static int countOfNodeCreateChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Node) {
				if (((Node) graphElement).getAction().getType().equals(Action.Type.CREATE)) {
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static int countOfNodeDeleteChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Node) {
				if (((Node) graphElement).getAction().getType().equals(Action.Type.DELETE)) {
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static int countOfEdgeChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Edge) {
				++count;
			}
		}
		
		return count;
	}
	
	public static int countOfEdgeCreateChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Edge) {
				if (((Edge) graphElement).getAction().getType().equals(Action.Type.CREATE)) {
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static int countOfEdgeDeleteChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Edge) {
				if (((Edge) graphElement).getAction().getType().equals(Action.Type.DELETE)) {
					++count;
				}
			}
		}
		
		return count;
	}
}
