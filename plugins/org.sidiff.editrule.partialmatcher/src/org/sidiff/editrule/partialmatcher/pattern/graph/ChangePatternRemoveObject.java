package org.sidiff.editrule.partialmatcher.pattern.graph;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.editrule.partialmatcher.pattern.domain.Domain;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternFactory;

public class ChangePatternRemoveObject extends ChangePatternObject {

	public ChangePatternRemoveObject(ActionNode node) {
		super(node);
		
		this.changeNodePattern.setType(SymmetricPackage.eINSTANCE.getRemoveObject());
		this.changeNodePattern.setName(node.getEditRuleNode().getType().getName());
		this.changeType = changeNodePattern.getType();
		
		EdgePattern objEdge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		objEdge.setType(SymmetricPackage.eINSTANCE.getRemoveObject_Obj());
		objEdge.setSource(changeNodePattern);
		objEdge.setTarget(node.getNodePatternA());
		
		this.metaModelType = node.getEditRuleNode().getType();
		this.actionGraph = node.getActionGraph();
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
			Iterator<RemoveObject> changes = getActionGraph().getChangeIndex().getLocalChanges(
					matchedA.next(), SymmetricPackage.eINSTANCE.getRemoveObject_Obj(), RemoveObject.class);
			
			changes.forEachRemaining(removeObject -> {
				Domain.get(changeNodePattern).mark(removeObject);
			});
		}
	}
}
