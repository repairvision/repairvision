package org.sidiff.editrule.recognition.impact.scope;

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
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.editrule.recognition.util.MatchingHelper;
import org.sidiff.history.revision.IRevision;
import org.sidiff.validation.constraint.impact.ImpactAnalysis;

public class ChangeScope {
	
	private Map<GraphElement, List<Change>> scope;
	
	private ImpactAnalysis impact;
	
	private IRevision revision;

	public ChangeScope(Collection<GraphElement> changes, ImpactAnalysis impact, IRevision revision) {
		this.impact = impact;
		this.revision = revision;
		this.scope = new HashMap<>();
		
		for (GraphElement change : changes) {

			// Abstract repairs consider only edges and attributes:
			if (change instanceof Edge) {
				EReference referenceType = ((Edge) change).getType();
				EClass sourceContextType = ((Edge) change).getSource().getType();
				boolean strictContextType = MatchingHelper.isStrictMatchingType(((Edge) change).getSource());

				// Delete:
				if (change.getGraph().isLhs()) {
					buildScopeOnDelete(sourceContextType, (Edge) change, strictContextType);
					
					// Repair which deletes the context element of a validation:
					if (referenceType.isContainment() && (referenceType.getEOpposite() == null)) {
						EClass targetContextType = ((Edge) change).getTarget().getType();
						boolean strictTargetContextType = MatchingHelper.isStrictMatchingType(((Edge) change).getTarget());
						
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
				boolean strictContextType = MatchingHelper.isStrictMatchingType(((Attribute) change).getNode());
				
				buildScopeOnModify(contextType, (Attribute) change, strictContextType);
			}
		}
	}
	
	
	private void buildScopeOnCreate(EClass contextType, Edge changeAction, boolean strict) {
		
		// NOTE: The impact is calculated on model B -> create changes are related to model B.
		for (EObject contextElement : impact.getScope()) {
			EClass repairContextType = contextElement.eClass();
			
			if (!strict || contextType.equals(repairContextType)) {
				if (strict || MetaModelUtil.isAssignableTo(repairContextType, contextType)) {
					if (impact.onCreate(contextElement, changeAction.getType())) {
						
						revision.getDifference()
								.getReferenceChanges(contextElement, changeAction.getType())
								.forEachRemaining(change -> {
									if (change instanceof AddReference) {
										add(changeAction, change);
									}
								});
					}
				}
			}
		}
	}
	
	private void buildScopeOnDelete(EClass contextType, Edge changeAction, boolean strict) {
		
		// NOTE: The impact is calculated on model B -> delete changes are related to model A.
		for (EObject contextElement : impact.getScope()) {
			EClass repairContextType = contextElement.eClass();

			if (!strict || contextType.equals(repairContextType)) {
				if (strict || MetaModelUtil.isAssignableTo(repairContextType, contextType)) {
					if (impact.onDelete(contextElement, changeAction.getType())) {
						EObject contextElementInB = revision.getDifference().getCorrespondingObjectInA(contextElement);

						if (contextElementInB != null) {
							revision.getDifference()
							.getReferenceChanges(contextElementInB, changeAction.getType())
							.forEachRemaining(change -> {
								if (change instanceof RemoveReference) {
									add(changeAction, change);
								}
							});
						}
					}
				}
			}
		}
	}
	
	private void buildScopeOnModify(EClass contextType, Attribute changeAction, boolean strict) {
		for (EObject contextElement : impact.getScope()) {
			EClass repairContextType = contextElement.eClass();
			
			if (!strict || contextType.equals(repairContextType)) {
				if (strict || MetaModelUtil.isAssignableTo(repairContextType, contextType)) {
					if (impact.onModify(contextElement, changeAction.getType())) {
						Change change = revision.getDifference().getAttributeChange(contextElement, changeAction.getType());
						
						if (change != null) {
							add(changeAction, change);
						}
					}
				}
			}
		}
	}
	
	public Set<GraphElement> getChanges() {
		return scope.keySet();
	}
	
	public void add(GraphElement changeAction, Change change) {
		if (!scope.containsKey(changeAction)) {
			scope.put(changeAction, new ArrayList<>());
		}
		
		List<Change> scopeElements = scope.get(changeAction);
		
		if (!scopeElements.contains(change)) {
			scopeElements.add(change);
		}
	}
	
	public List<Change> get(GraphElement graphElement) {
		return scope.getOrDefault(graphElement, Collections.emptyList());
	}
	
	public boolean isEmpty() {
		return (scope == null) || (scope.isEmpty());
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		for (GraphElement change : scope.keySet()) {
			string.append("<<" + change.getAction() + ">> " + change + ":\n");
			
			for (EObject scopeElement : scope.get(change)) {
				string.append("  " + scopeElement + "\n");
			}
		}
		
		return string.toString();
	}
}
