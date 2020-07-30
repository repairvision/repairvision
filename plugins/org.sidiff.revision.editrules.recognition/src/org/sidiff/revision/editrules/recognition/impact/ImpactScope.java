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
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.common.utilities.emf.MetaModelUtil;
import org.sidiff.validation.constraint.impact.ImpactAnalysis;
import org.sidiff.validation.constraint.impact.util.GraphActionImpactUtil;

public class ImpactScope {
	
	private Map<GraphElement, List<EObject>> repairScope;
	
	private ImpactAnalysis impact;

	public ImpactScope(Collection<? extends GraphElement> changes, ImpactAnalysis impact) {
		
		this.impact = impact;
		this.repairScope = new HashMap<>();

		for (GraphElement change : changes) {

			// Abstract repairs consider only edges and attributes:
			if (change instanceof Edge) {
				EClass sourceContextType = ((Edge) change).getSource().getType();
				boolean strictContextType = GraphActionImpactUtil.isStrictMatchingType(((Edge) change).getSource());

				// Delete:
				if (change.getGraph().isLhs()) {
					buildScopeOnDelete(sourceContextType, (Edge) change, strictContextType);
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
				boolean strictContextType = GraphActionImpactUtil.isStrictMatchingType(((Attribute) change).getNode());
				
				buildScopeOnModify(contextType, (Attribute) change, strictContextType);
			}
			
			else if (change instanceof Node) {
				EClass objectType = ((Node) change).getType();
				boolean strictObjectType = GraphActionImpactUtil.isStrictMatchingType((Node) change);

				// Delete:
				if (change.getGraph().isLhs()) {
					buildScopeOnDelete(objectType, (Node) change, strictObjectType);
				}

				// Create:
				else if (change.getGraph().isRhs()) {
					buildScopeOnCreate(objectType, (Node) change, strictObjectType);
				}

				else {
					assert false : "We should never get here...!";
				}
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
	
	private void buildScopeOnCreate(EClass objectType, Node change, boolean strict) {
		for (EObject contextElement : impact.getScope()) {
			EClass repairContextType = contextElement.eClass();
			
			if (!strict || objectType.equals(repairContextType)) {
				if (strict || MetaModelUtil.isAssignableTo(repairContextType, objectType)) {
					if (contextElement.eContainingFeature() == getContainingReference(change)) {
						if (impact.onCreate(contextElement)) {
							add(change, contextElement);
						}
					}
				}
			}
		}
	}

	private void buildScopeOnDelete(EClass objectType, Node change, boolean strict) {
		for (EObject contextElement : impact.getScope()) {
			EClass repairContextType = contextElement.eClass();
			
			if (!strict || objectType.equals(repairContextType)) {
				if (strict || MetaModelUtil.isAssignableTo(repairContextType, objectType)) {
					if (contextElement.eContainmentFeature() == getContainingReference(change)) {
						if (impact.onDelete(contextElement)) {
							add(change, contextElement);
						}
					}
				}
			}
		}
	}
	
	private EReference getContainingReference(Node change) {
		for (Edge incomingEdge : change.getIncoming()) {
			if (incomingEdge.getType().isContainment()) {
				return incomingEdge.getType();
			}
		}
		return null;
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
