package org.sidiff.revision.editrules.recognition.pattern.graph;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.graphpattern.Association;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.DifferencePackage;
import org.sidiff.revision.difference.RemoveReference;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;
import org.sidiff.revision.editrules.recognition.pattern.graph.path.MatchingPath;

public class ChangePatternRemoveReference extends ChangePatternReference  {

	public ChangePatternRemoveReference(ActionEdge edge) {
		super(edge);
		
		this.changeNodePattern.setType(DifferencePackage.eINSTANCE.getRemoveReference());
		this.changeNodePattern.setName(edge.getEditRuleEdge().getType().getName());
		this.changeType = changeNodePattern.getType();
		
		// change-pattern:
		EdgePattern srcEdge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		srcEdge.setType(DifferencePackage.eINSTANCE.getRemoveReference_Src());
		srcEdge.setSource(changeNodePattern);
		srcEdge.setTarget(edge.getEdgePatternA().getSource());
		
		EdgePattern tgtEdge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		tgtEdge.setType(DifferencePackage.eINSTANCE.getRemoveReference_Tgt());
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
	public boolean addChange(Change change) {
		boolean context = edge.getSource().canMatchContextA(((RemoveReference) change).getSrc());
		context &= edge.getTarget().canMatchContextA(((RemoveReference) change).getTgt());
		
		if (context) {
			return super.addChange(change);
		}
		
		return false;
	}
	
	@Override
	public void searchPaths(MatchingPath path, Change change) {
		
		//// Match Remove-Reference-Pattern /////
		RemoveReference removeReference = (RemoveReference) change;
		
		// mark change:
		Domain.get(changeNodePattern).mark(change);
		
		// TODO: Optionally: Check <<preserve>> edges between source and target!
		
		// evaluate parallel edge changes:
		searchParallelChangePatternReferences(removeReference);
		
		///// Match remaining graph pattern ////
		
		// search context element (source):
		edge.getSource().addMatchContextA(removeReference.getSrc());
		
		// search context element (target):
		edge.getTarget().addMatchContextA(removeReference.getTgt());
		
		// search paths (source):
		path.add(edge.getSource());
		edge.getTarget().searchPaths(this, path);
		path.remove(edge.getSource());
		
		path.add(edge.getTarget());
		edge.getSource().searchPaths(this, path);
		path.remove(edge.getTarget());
	}

	@Override
	public void doEvaluationStep(ActionNode stepSource, ActionNode stepTarget) {
//		System.out.println("Match Action: " + this);
		
		// Model-Element (target) <- Change 
		Iterator<? extends EObject> matchedA = Domain.get(stepSource.getNodePatternA()).getSearchedMatchIterator();
		
		while (matchedA.hasNext()) {
			EReference changeReference = (stepSource == edge.getSource()) 
					? DifferencePackage.eINSTANCE.getRemoveReference_Src()
					: DifferencePackage.eINSTANCE.getRemoveReference_Tgt();
			
			Iterator<RemoveReference> changes = actionGraph.getRevision().getDifference().getLocalChanges(
					matchedA.next(), changeReference, RemoveReference.class);
			
			while (changes.hasNext()) {
				// Model-Element -> Change 
				RemoveReference removeReference = changes.next();
//				System.out.println("    Match: " + removeReference);
				
				if (removeReference.getType() == edge.getEditRuleEdge().getType()) {
					
					// Mark the change if it is in search space:
					boolean isMarked = Domain.get(changeNodePattern).mark(removeReference);

					// Change -> Model-Element
					if (isMarked) {
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
}
