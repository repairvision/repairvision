package org.sidiff.revision.editrules.recognition.dependencies;

import org.sidiff.graphpattern.DependencyNode;
import org.sidiff.graphpattern.GraphPattern;

public class DependencyCalculation {

	public static void findIndependent(GraphPattern graphPattern) {
		
		// Search all dependencies with none outgoing dependencies:
		for (DependencyNode dependency : graphPattern.getDependencyGraph().getNodes()) {
			if (dependency.getOutgoings().isEmpty()) {
				graphPattern.getDependencyGraph().getIndependent().add(dependency);
			}
		}
	}
}
