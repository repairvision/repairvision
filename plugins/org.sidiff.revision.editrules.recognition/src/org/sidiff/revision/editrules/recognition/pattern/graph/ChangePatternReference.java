package org.sidiff.revision.editrules.recognition.pattern.graph;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.RemoveReference;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;

public abstract class ChangePatternReference extends ChangePattern  {
	
	protected ActionEdge edge;
	
	public ChangePatternReference(ActionEdge edge) {
		this.edge = edge;
		this.changeNodePattern = GraphpatternFactory.eINSTANCE.createNodePattern();
	}
	
	public ActionEdge getEdge() {
		return edge;
	}
	
	protected void searchParallelChangePatternReferences(Change changeReference) {
		EObject changeSrc = getChangeReferenceSource(changeReference);
		EObject changeTgt = getChangeReferenceTarget(changeReference);
		
		for (ActionEdge parallelEdge : edge.getSource().getIncident(edge.getTarget())) {
			if ((parallelEdge != edge) && (parallelEdge.getChange() != null)) {
				Domain changeDomain = Domain.get(parallelEdge.getChange().getChangeNodePattern());
				
				for (EObject parallelChange : (Iterable<EObject>) () -> changeDomain.iterator()) {
					EObject parallelChangeSrc = getChangeReferenceSource(parallelChange);
					EObject parallelChangeTgt = getChangeReferenceTarget(parallelChange);
					
					if (parallelEdge.getSource() == edge.getSource()) {
						if ((changeSrc == parallelChangeSrc) && (changeTgt == parallelChangeTgt))  {
							changeDomain.mark(parallelChange);
						}
					} else {
						assert parallelEdge.getSource() == edge.getTarget();
						
						if ((changeSrc == parallelChangeTgt) && (changeTgt == parallelChangeSrc))  {
							changeDomain.mark(parallelChange);
						}
					}
				}
			}
		}
	}
	
	private EObject getChangeReferenceSource(EObject changeReference) {
		assert changeReference instanceof Change;
		return (changeReference instanceof AddReference) 
				? ((AddReference) changeReference).getSrc()
				: ((RemoveReference) changeReference).getSrc();
	}

	private EObject getChangeReferenceTarget(EObject changeReference) {
		assert changeReference instanceof Change;
		return (changeReference instanceof AddReference) 
				? ((AddReference) changeReference).getTgt()
				: ((RemoveReference) changeReference).getTgt();
	}
	
	public abstract void doEvaluationStep(ActionNode stepSource, ActionNode stepTarget);
	
	@Override
	public String toString() {
		return "ChangeReference[" + edge.toString() + "]";
	}
}

