package org.sidiff.graphpattern.matcher.lifting.atomics;

import java.util.ArrayList;

import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matching.selection.AtomicPattern;
import org.sidiff.graphpattern.matching.selection.Move;

public class AtomicCorrespondencePattern extends AtomicPattern {

	public AtomicCorrespondencePattern(NodePattern modelStartNode, EdgePattern incomingCorrespondence) {
		NodePattern correspondence = incomingCorrespondence.getSource();

		// Initialize pattern:
		nodes = new ArrayList<>(3);
		borderNodes = new ArrayList<>(1);
		evaluation = new ArrayList<>(2);

		// Nodes and evaluation:
		nodes.add(modelStartNode);
		evaluation.add(new Move(modelStartNode, incomingCorrespondence, correspondence));
		nodes.add(correspondence);

		for (EdgePattern outgoing : correspondence.getOutgoings()) {
			NodePattern modelNode = outgoing.getTarget();

			if (modelNode != modelStartNode) {
				evaluation.add(new Move(correspondence, outgoing, modelNode));
				nodes.add(modelNode);
				borderNodes.add(modelNode);
			}
		}
	}
}
