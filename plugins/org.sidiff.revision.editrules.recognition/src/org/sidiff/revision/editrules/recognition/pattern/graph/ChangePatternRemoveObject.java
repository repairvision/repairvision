package org.sidiff.revision.editrules.recognition.pattern.graph;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.DifferencePackage;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;
import org.sidiff.revision.editrules.recognition.pattern.graph.path.MatchingPath;

public class ChangePatternRemoveObject extends ChangePatternObject {

	public ChangePatternRemoveObject(ActionNode node) {
		super(node);
		
		this.changeNodePattern.setType(DifferencePackage.eINSTANCE.getRemoveObject());
		this.changeNodePattern.setName(node.getEditRuleNode().getType().getName());
		this.changeType = changeNodePattern.getType();
		
		EdgePattern objEdge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		objEdge.setType(DifferencePackage.eINSTANCE.getRemoveObject_Obj());
		objEdge.setSource(changeNodePattern);
		objEdge.setTarget(node.getNodePatternA());
		
		this.metaModelType = node.getEditRuleNode().getType();
		this.actionGraph = node.getActionGraph();
	}
	
	@Override
	public boolean addChange(Change change) {
		boolean context = node.canMatchContextA(((RemoveObject) change).getObj());
		
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
		node.addMatchContextA(((RemoveObject) change).getObj());
		
		///// Match remaining graph pattern ////
		
		// search paths:
		node.searchPaths(this, path);
	}

	@Override
	public void doEvaluationStep() {
//		System.out.println("Match Action: " + this);
		
		// Model-Element <- Change 
		Iterator<? extends EObject> matchedA = Domain.get(node.getNodePatternA()).getSearchedMatchIterator();
		
		while (matchedA.hasNext()) {
			Iterator<RemoveObject> changes = actionGraph.getRevision().getDifference().getLocalChanges(
					matchedA.next(), DifferencePackage.eINSTANCE.getRemoveObject_Obj(), RemoveObject.class);
			
			changes.forEachRemaining(removeObject -> {
				Domain.get(changeNodePattern).mark(removeObject);
			});
		}
	}
}
