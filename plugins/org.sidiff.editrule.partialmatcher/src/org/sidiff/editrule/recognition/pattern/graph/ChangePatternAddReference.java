package org.sidiff.editrule.recognition.pattern.graph;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.editrule.recognition.pattern.domain.Domain;
import org.sidiff.editrule.recognition.pattern.graph.path.MatchingPath;
import org.sidiff.graphpattern.Association;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternFactory;

public class ChangePatternAddReference extends ChangePatternReference {

	public ChangePatternAddReference(ActionEdge edge) {
		super(edge);
		
		this.changeNodePattern.setType(SymmetricPackage.eINSTANCE.getAddReference());
		this.changeNodePattern.setName(edge.getEditRuleEdge().getType().getName());
		this.changeType = changeNodePattern.getType();
		
		// change-pattern:
		EdgePattern srcEdge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		srcEdge.setType(SymmetricPackage.eINSTANCE.getAddReference_Src());
		srcEdge.setSource(changeNodePattern);
		srcEdge.setTarget(edge.getEdgePatternB().getSource());
		
		EdgePattern tgtEdge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		tgtEdge.setType(SymmetricPackage.eINSTANCE.getAddReference_Tgt());
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
	public void searchPaths(MatchingPath path, Change change) {
		
		//// Match Add-Reference-Pattern /////
		
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
		edge.getSource().addMatchContextB(((AddReference) change).getSrc());
		path.add(edge.getSource());
		
		// search context element (target):
		edge.getTarget().addMatchContextB(((AddReference) change).getTgt());
		path.add(edge.getTarget());
		
		// search paths (source):
		edge.getSource().searchPaths(this, path);
		edge.getTarget().searchPaths(this, path);
	}

	@Override
	public void doEvaluationStep(ActionNode stepSource, ActionNode stepTarget) {
//		System.out.println("Match Action: " + this);
		
		Iterator<? extends EObject> matchedB = Domain.get(stepSource.getNodePatternB()).getSearchedMatchIterator();
		
		while (matchedB.hasNext()) {
			EReference changeReference = (stepSource == edge.getSource()) 
					? SymmetricPackage.eINSTANCE.getAddReference_Src()
					: SymmetricPackage.eINSTANCE.getAddReference_Tgt();
			
			Iterator<AddReference> changes = getActionGraph().getChangeIndex().getLocalChanges(
					matchedB.next(), changeReference, AddReference.class);
			
			while (changes.hasNext()) {
				
				// Model-Element -> Change 
				AddReference addReference = changes.next();
//				System.out.println("    Match: " + addReference);
				
				if (addReference.getType() == edge.getEditRuleEdge().getType()) {
					Domain.get(changeNodePattern).mark(addReference);
					
					// Change -> Model-Element
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
