package org.sidiff.revision.editrules.recognition.impact;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.sidiff.consistency.common.emf.MetaModelUtil;
import org.sidiff.revision.editrules.recognition.revision.RevisionGraph;
import org.sidiff.validation.constraint.impact.ImpactAnalysis;

public class ImpactScope {
	
	private Map<GraphElement, List<EObject>> repairScope;
	
	private ImpactAnalysis impact;

	public ImpactScope(Collection<? extends GraphElement> changes, ImpactAnalysis impact) {
		
		this.impact = impact;
		this.repairScope = new HashMap<>();

		for (GraphElement change : changes) {

			// Abstract repairs consider only edges and attributes:
			if (change instanceof Edge) {
				EReference referenceType = ((Edge) change).getType();
				EClass sourceContextType = ((Edge) change).getSource().getType();
				boolean strictContextType = RevisionGraph.isStrictMatchingType(((Edge) change).getSource());

				// Delete:
				if (change.getGraph().isLhs()) {
					buildScopeOnDelete(sourceContextType, (Edge) change, strictContextType);
					
					// Repair which deletes the context element of a validation:
					if (referenceType.isContainment() && (referenceType.getEOpposite() == null)) {
						EClass targetContextType = ((Edge) change).getTarget().getType();
						boolean strictTargetContextType = RevisionGraph.isStrictMatchingType(((Edge) change).getTarget());
						
						buildScopeOnDelete(targetContextType, (Edge) change, strictTargetContextType);
					}
				}

				// Create:
				else if (change.getGraph().isRhs()) {
					buildScopeOnCreate(sourceContextType, (Edge) change, strictContextType);
				}

				else {
					assert false : "We should never get here...!";
				}
			}
			
			else if (change instanceof Attribute) {
				EClass contextType = ((Attribute) change).getNode().getType();
				boolean strictContextType = RevisionGraph.isStrictMatchingType(((Attribute) change).getNode());
				
				buildScopeOnModify(contextType, (Attribute) change, strictContextType);
			}
		}
	}
	
	private void buildScopeOnCreate(EClass contextType, Edge change, boolean strict) {
		for (EObject contextElement : impact.getScope()) {
			EClass repairContextType = contextElement.eClass();
			
			if (!strict || contextType.equals(repairContextType)) {
				if (strict || MetaModelUtil.isAssignableTo(repairContextType, contextType)) {
					if (impact.onCreate(contextElement, change.getType())) {
						add(change, contextElement);
					}
				}
			}
		}
	}
	
	private void buildScopeOnDelete(EClass contextType, Edge change, boolean strict) {
		for (EObject contextElement : impact.getScope()) {
			EClass repairContextType = contextElement.eClass();
			
			if (!strict || contextType.equals(repairContextType)) {
				if (strict || MetaModelUtil.isAssignableTo(repairContextType, contextType)) {
					if (impact.onDelete(contextElement, change.getType())) {
						add(change, contextElement);
					}
				}
			}
		}
	}
	
	private void buildScopeOnModify(EClass contextType, Attribute change, boolean strict) {
		for (EObject contextElement : impact.getScope()) {
			EClass repairContextType = contextElement.eClass();
			
			if (!strict || contextType.equals(repairContextType)) {
				if (strict || MetaModelUtil.isAssignableTo(repairContextType, contextType)) {
					if (impact.onModify(contextElement, change.getType())) {
						add(change, contextElement);
					}
				}
			}
		}
	}
	
	public Set<GraphElement> getChanges() {
		return repairScope.keySet();
	}
	
	private void add(GraphElement change, EObject scopeElement) {
		if (!repairScope.containsKey(change)) {
			repairScope.put(change, new ArrayList<>());
		}
		
		
		List<EObject> scopeElements = repairScope.get(change);
		
		if (!scopeElements.contains(scopeElement)) {
			scopeElements.add(scopeElement);
		}
	}
	
	public List<EObject> get(GraphElement graphElement) {
		return repairScope.getOrDefault(graphElement, Collections.emptyList());
	}
	
	public boolean isEmpty() {
		return (repairScope == null) || (repairScope.isEmpty());
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		for (GraphElement change : repairScope.keySet()) {
			string.append("<<" + change.getAction() + ">> " + change + ":\n");
			
			for (EObject scopeElement : repairScope.get(change)) {
				string.append("  " + scopeElement + "\n");
			}
		}
		
		return string.toString();
	}
}
