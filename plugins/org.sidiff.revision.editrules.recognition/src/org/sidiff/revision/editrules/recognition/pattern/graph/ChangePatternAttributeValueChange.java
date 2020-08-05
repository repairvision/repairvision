package org.sidiff.revision.editrules.recognition.pattern.graph;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.revision.common.henshin.pairs.AttributePair;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.DifferencePackage;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;
import org.sidiff.revision.editrules.recognition.pattern.graph.path.MatchingPath;

public class ChangePatternAttributeValueChange extends ChangePattern {

	protected ActionNode node;
	
	protected AttributePair attribute;
	
	@Override
	public boolean addChange(Change change) {
		boolean context = node.canMatchContextA(((AttributeValueChange) change).getObjA());
//		context &= node.canMatchContextB(((AttributeValueChange) change).getObjB()); // NOTE: Is already synchronized!
		
		if (context) {
			return super.addChange(change);
		}
		
		return false;
	}
	
	// TODO: ActionAttribute!
	public ChangePatternAttributeValueChange(ActionNode node, AttributePair attribute) {
		this.node = node;
		this.attribute = attribute;
		
		this.changeNodePattern = GraphpatternFactory.eINSTANCE.createNodePattern();
		this.changeNodePattern.setName(node.getEditRuleNode().getType().getName());
		this.changeNodePattern.setType(DifferencePackage.eINSTANCE.getAttributeValueChange());
		
		EdgePattern srcEdge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		srcEdge.setType(DifferencePackage.eINSTANCE.getAttributeValueChange_ObjA());
		srcEdge.setSource(changeNodePattern);
		srcEdge.setTarget(node.getNodePatternA());
		
		EdgePattern tgtEdge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		tgtEdge.setType(DifferencePackage.eINSTANCE.getAttributeValueChange_ObjB());
		tgtEdge.setSource(changeNodePattern);
		tgtEdge.setTarget(node.getNodePatternB());
		
		// TODO: Association to the node with type StructuralFeature/Attribute
		
		this.changeType = changeNodePattern.getType();
		this.metaModelType = attribute.getRhsAttribute().getType();
		this.actionGraph = node.getActionGraph();
	}
	
	public AttributePair getAttribute() {
		return attribute;
	}
	
	@Override
	public void searchPaths(MatchingPath path, Change change) {
		
		//// Match Attribute-Value-Change-Pattern ////
		
		// mark change:
		Domain.get(changeNodePattern).mark(change);
		
		// search context elements:
		node.addMatchContextA(((AttributeValueChange) change).getObjA());
//		node.addMatchContextB(((AttributeValueChange) change).getObjB()); // NOTE: Is already synchronized!

		///// Match remaining graph pattern ////
		
		// search paths:
		node.searchPaths(this, path);
	}

	public void doEvaluationStep() {
//		System.out.println("Match Action: " + this);
		
		// Model-Element (target) <- Change 
		Iterator<? extends EObject> matchedB = Domain.get(node.getNodePatternB()).getSearchedMatchIterator();
		
		while (matchedB.hasNext()) {
			Iterator<AttributeValueChange> changes = actionGraph.getRevision().getDifference().getLocalChanges(
					matchedB.next(), DifferencePackage.eINSTANCE.getAttributeValueChange_ObjB(), AttributeValueChange.class);
			
			changes.forEachRemaining(attributeValueChange -> {
				Domain.get(changeNodePattern).mark(attributeValueChange);
			});
		}
	}
}
