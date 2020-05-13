package org.sidiff.revision.editrules.recognition.pattern.graph;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.graphpattern.Association;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.DifferencePackage;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;
import org.sidiff.revision.editrules.recognition.pattern.graph.path.MatchingPath;

public class ChangePatternAddReference extends ChangePatternReference {

	public ChangePatternAddReference(ActionEdge edge) {
		super(edge);
		
		this.changeNodePattern.setType(DifferencePackage.eINSTANCE.getAddReference());
		this.changeNodePattern.setName(edge.getEditRuleEdge().getType().getName());
		this.changeType = changeNodePattern.getType();
		
		// change-pattern:
		EdgePattern srcEdge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		srcEdge.setType(DifferencePackage.eINSTANCE.getAddReference_Src());
		srcEdge.setSource(changeNodePattern);
		srcEdge.setTarget(edge.getEdgePatternB().getSource());
		
		EdgePattern tgtEdge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		tgtEdge.setType(DifferencePackage.eINSTANCE.getAddReference_Tgt());
		tgtEdge.setSource(changeNodePattern);
		tgtEdge.setTarget(edge.getEdgePatternB().getTarget());
		
		Association typeAssociation = GraphpatternFactory.eINSTANCE.createAssociation();
		typeAssociation.setSource(changeNodePattern);
		typeAssociation.setTarget(edge.getEdgePatternB());
		
		// helper data:
		this.metaModelType = edge.getEditRuleEdge().getType();
		this.actionGraph = edge.getActionGraph();
	}
	
	@Override
	public boolean addChange(Change change) {
		boolean context = edge.getSource().canMatchContextB(((AddReference) change).getSrc());
		context &= edge.getTarget().canMatchContextB(((AddReference) change).getTgt());
		
		if (context) {
			return super.addChange(change);
		}
		
		return false;
	}
	
	@Override
	public void searchPaths(MatchingPath path, Change change) {
		
		//// Match Add-Reference-Pattern /////
		AddReference addReference = (AddReference) change;
		
		// mark change:
		Domain.get(changeNodePattern).mark(addReference);
		
		// evaluate parallel edge changes:
		searchParallelChangePatternReferences(addReference);
		
		///// Match remaining graph pattern ////
		
		// search context element (source):
		edge.getSource().addMatchContextB(addReference.getSrc());
		
		// search context element (target):
		edge.getTarget().addMatchContextB(addReference.getTgt());
		
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
		
		Iterator<? extends EObject> matchedB = Domain.get(stepSource.getNodePatternB()).getSearchedMatchIterator();
		
		while (matchedB.hasNext()) {
			EReference changeReference = (stepSource == edge.getSource()) 
					? DifferencePackage.eINSTANCE.getAddReference_Src()
					: DifferencePackage.eINSTANCE.getAddReference_Tgt();
			
			Iterator<AddReference> changes = actionGraph.getRevision().getDifference().getLocalChanges(
					matchedB.next(), changeReference, AddReference.class);
			
			while (changes.hasNext()) {
				
				// Model-Element -> Change 
				AddReference addReference = changes.next();
//				System.out.println("    Match: " + addReference);
				
				if (addReference.getType() == edge.getEditRuleEdge().getType()) {
					
					// Mark the change if it is in search space:
					boolean isMarked = Domain.get(changeNodePattern).mark(addReference);
					
					// Change -> Model-Element
					if (isMarked) {
						if (stepSource == edge.getSource()) {
							edge.getTarget().addMatchContextB(addReference.getTgt());
						} else {
							edge.getSource().addMatchContextB(addReference.getSrc());
						}
					}
				}
			}
		}
	}
}
