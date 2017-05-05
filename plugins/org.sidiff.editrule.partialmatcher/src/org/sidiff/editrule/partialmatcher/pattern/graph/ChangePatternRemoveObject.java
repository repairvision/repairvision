package org.sidiff.editrule.partialmatcher.pattern.graph;

import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.editrule.partialmatcher.pattern.domain.Domain;
import org.sidiff.editrule.partialmatcher.util.LiftingGraphIndex;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternFactory;

public class ChangePatternRemoveObject extends ChangePatternObject {

	protected LiftingGraphIndex changeIndex;
	
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
		this.changeIndex = node.getActionGraph().getChangeIndex();
	}
	
	@Override
	public void searchPaths(Change change) {
		
		// mark change:
		Domain.get(changeNodePattern).mark(change);
		
		// search context element:
		node.addMatchContextA(((RemoveObject) change).getObj());
		
		// search paths:
		node.searchPaths(this, node, new HashSet<>());
	}

	@Override
	public void doEvaluationStep() {
//		System.out.println("Match Action: " + this);
		
		// Model-Element <- Change 
		Iterator<? extends EObject> matchedA = Domain.get(node.getNodePatternA()).getSearchedMatchIterator();
		
		while (matchedA.hasNext()) {
			Iterator<AddObject> changes = changeIndex.getLocalChanges(matchedA.next(), 
					SymmetricPackage.eINSTANCE.getRemoveObject_Obj(), AddObject.class);
			
			changes.forEachRemaining(removeObject -> {
				Domain.get(changeNodePattern).mark(removeObject);
			});
		}
	}
}
