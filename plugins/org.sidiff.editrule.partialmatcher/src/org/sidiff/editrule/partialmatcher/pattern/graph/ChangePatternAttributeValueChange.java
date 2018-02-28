package org.sidiff.editrule.partialmatcher.pattern.graph;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.henshin.view.AttributePair;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.editrule.partialmatcher.pattern.domain.Domain;
import org.sidiff.editrule.partialmatcher.util.LiftingGraphIndex;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternFactory;

public class ChangePatternAttributeValueChange extends ChangePattern {

	protected ActionNode node;
	
	protected AttributePair attribute;
	
	protected LiftingGraphIndex changeIndex;
	
	// TODO: ActionAttribute!
	public ChangePatternAttributeValueChange(ActionNode node, AttributePair attribute) {
		this.node = node;
		this.attribute = attribute;
		
		this.changeNodePattern = GraphpatternFactory.eINSTANCE.createNodePattern();
		this.changeNodePattern.setName(node.getEditRuleNode().getType().getName());
		this.changeNodePattern.setType(SymmetricPackage.eINSTANCE.getAttributeValueChange());
		
		EdgePattern srcEdge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		srcEdge.setType(SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjA());
		srcEdge.setSource(changeNodePattern);
		srcEdge.setTarget(node.getNodePatternA());
		
		EdgePattern tgtEdge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		tgtEdge.setType(SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjB());
		tgtEdge.setSource(changeNodePattern);
		tgtEdge.setTarget(node.getNodePatternB());
		
		// TODO: Association to the node with type StructuralFeature/Attribute
		
		this.changeType = changeNodePattern.getType();
		this.metaModelType = attribute.getRhsAttribute().getType();
		this.changeIndex = node.getActionGraph().getChangeIndex();
	}
	
	public AttributePair getAttribute() {
		return attribute;
	}
	
	@Override
	public void searchPaths(MatchingPath path, Change change) {
		
		// mark change:
		Domain.get(changeNodePattern).mark(change);
		
		// search context elements:
		Domain.get(node.getNodePatternA()).addSearchedMatch(((AttributeValueChange) change).getObjA());
		Domain.get(node.getNodePatternB()).addSearchedMatch(((AttributeValueChange) change).getObjB());
		Domain.get(node.getCorrespondence()).addSearchedMatch(
				changeIndex.getCorrespondenceB(((AttributeValueChange) change).getObjB()));
		
		// search paths:
		node.searchPaths(this, node, path);
	}

	public void doEvaluationStep() {
//		System.out.println("Match Action: " + this);
		
		// Model-Element (target) <- Change 
		Iterator<? extends EObject> matchedB = Domain.get(node.getNodePatternB()).getSearchedMatchIterator();
		
		while (matchedB.hasNext()) {
			Iterator<AttributeValueChange> changes = changeIndex.getLocalChanges(matchedB.next(), 
					SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjB(), AttributeValueChange.class);
			
			changes.forEachRemaining(attributeValueChange -> {
				Domain.get(changeNodePattern).mark(attributeValueChange);
			});
		}
	}
}
