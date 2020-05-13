package org.sidiff.revision.editrules.recognition.pattern.graph;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.DifferencePackage;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;
import org.sidiff.revision.editrules.recognition.pattern.graph.path.MatchingPath;

public class ChangePatternAddObject extends ChangePatternObject {

	public ChangePatternAddObject(ActionNode node) {
		super(node);
		
		this.changeNodePattern.setType(DifferencePackage.eINSTANCE.getAddObject());
		this.changeNodePattern.setName(node.getEditRuleNode().getType().getName());
		this.changeType = changeNodePattern.getType();
		
		EdgePattern objEdge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		objEdge.setType(DifferencePackage.eINSTANCE.getAddObject_Obj());
		objEdge.setSource(changeNodePattern);
		objEdge.setTarget(node.getNodePatternB());
		
		this.metaModelType = node.getEditRuleNode().getType();
		this.actionGraph = node.getActionGraph();
	}
	
	@Override
	public boolean addChange(Change change) {
		boolean context = node.canMatchContextB(((AddObject) change).getObj());
		
		if (context) {
			return super.addChange(change);
		}
		
		return false;
	}
	
	@Override
	public void searchPaths(MatchingPath path, Change change) {
		
		//// Match Remove-Object-Pattern ////
		
		// mark change:
		Domain.get(changeNodePattern).mark(change);
		
		// search context element:
		node.addMatchContextB(((AddObject) change).getObj());
		
		///// Match remaining graph pattern ////
		
		// search paths:
		node.searchPaths(this, path);
	}

	@Override
	public void doEvaluationStep() {
//		System.out.println("Match Action: " + this);
		
		// Model-Element (target) <- Change 
		Iterator<? extends EObject> matchedB = Domain.get(node.getNodePatternB()).getSearchedMatchIterator();
		
		while (matchedB.hasNext()) {
			Iterator<AddObject> changes = actionGraph.getRevision().getDifference().getLocalChanges(
					matchedB.next(), DifferencePackage.eINSTANCE.getAddObject_Obj(), AddObject.class);
			
			changes.forEachRemaining(addObject -> {
				Domain.get(changeNodePattern).mark(addObject);
			});
		}
	}
}
