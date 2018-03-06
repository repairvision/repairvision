package org.sidiff.editrule.recognition.pattern.graph;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.editrule.recognition.pattern.domain.Domain;
import org.sidiff.editrule.recognition.pattern.graph.path.MatchingPath;
import org.sidiff.graphpattern.Association;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternFactory;

public class ChangePatternRemoveReference extends ChangePatternReference  {

	public ChangePatternRemoveReference(ActionEdge edge) {
		super(edge);
		
		this.changeNodePattern.setType(SymmetricPackage.eINSTANCE.getRemoveReference());
		this.changeNodePattern.setName(edge.getEditRuleEdge().getType().getName());
		this.changeType = changeNodePattern.getType();
		
		// change-pattern:
		EdgePattern srcEdge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		srcEdge.setType(SymmetricPackage.eINSTANCE.getRemoveReference_Src());
		srcEdge.setSource(changeNodePattern);
		srcEdge.setTarget(edge.getEdgePatternA().getSource());
		
		EdgePattern tgtEdge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		tgtEdge.setType(SymmetricPackage.eINSTANCE.getRemoveReference_Tgt());
		tgtEdge.setSource(changeNodePattern);
		tgtEdge.setTarget(edge.getEdgePatternA().getTarget());
		
		Association typeAssociation = GraphpatternFactory.eINSTANCE.createAssociation();
		typeAssociation.setSource(changeNodePattern);
		typeAssociation.setTarget(edge.getEdgePatternA());
		
		// helper data:
		this.metaModelType = edge.getEditRuleEdge().getType();
		this.actionGraph = edge.getActionGraph();
	}
	
	@Override
	public void searchPaths(MatchingPath path, Change change) {
		
		//// Match Remove-Reference-Pattern /////
		
		// mark change:
		Domain.get(changeNodePattern).mark(change);
		
		// mark opposite change:
		if (edge.getOpposite() != null) {
			assert (edge.getOpposite().getChange() != null);
			Change oppositeChange = getActionGraph().getChangeIndex().getOppositeChange(change);
			assert (oppositeChange != null);
			
			Domain.get(edge.getOpposite().getChange().getChangeNodePattern()).mark(oppositeChange);
		}
		
		// TODO: Optionally: Check <<preserve>> edges between source and target!
		
		// evaluate parallel edge changes:
		for (ActionEdge parallelEdge : edge.getSource().getIncident(edge.getTarget())) {
			if ((parallelEdge != edge) && (parallelEdge != edge.getOpposite())) {
				edge.getChange().doEvaluationStep(edge.getSource(), edge.getTarget());
			}
		}
		
		///// Match remaining graph pattern ////
		
		// search context element (source):
		edge.getSource().addMatchContextA(((RemoveReference) change).getSrc());
		path.add(edge.getSource());
		
		// search context element (target):
		edge.getTarget().addMatchContextA(((RemoveReference) change).getTgt());
		path.add(edge.getTarget());
		
		// search paths (source):
		edge.getSource().searchPaths(this, path);
		edge.getTarget().searchPaths(this, path);
	}

	@Override
	public void doEvaluationStep(ActionNode stepSource, ActionNode stepTarget) {
//		System.out.println("Match Action: " + this);
		
		// Model-Element (target) <- Change 
		Iterator<? extends EObject> matchedA = Domain.get(stepSource.getNodePatternA()).getSearchedMatchIterator();
		
		while (matchedA.hasNext()) {
			EReference changeReference = (stepSource == edge.getSource()) 
					? SymmetricPackage.eINSTANCE.getRemoveReference_Src()
					: SymmetricPackage.eINSTANCE.getRemoveReference_Tgt();
			
			Iterator<RemoveReference> changes = getActionGraph().getChangeIndex().getLocalChanges(
					matchedA.next(), changeReference, RemoveReference.class);
			
			while (changes.hasNext()) {
				// Model-Element -> Change 
				RemoveReference removeReference = changes.next();
//				System.out.println("    Match: " + removeReference);
				
				if (removeReference.getType() == edge.getEditRuleEdge().getType()) {
					Domain.get(changeNodePattern).mark(removeReference);

					// Change -> Model-Element
					if (stepSource == edge.getSource()) {
						edge.getTarget().addMatchContextA(removeReference.getTgt());
					} else {
						edge.getSource().addMatchContextA(removeReference.getSrc());
					}
				}
			}
		}
	}
}
