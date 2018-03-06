package org.sidiff.editrule.recognition.scope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.GraphElement;

public class RepairScope {
	
	private Map<GraphElement, List<EObject>> scope;
	
	public Set<GraphElement> getChanges() {
		return scope.keySet();
	}
	
	public void add(GraphElement change, EObject scopeElement) {
		if (scope == null) {
			scope = new HashMap<>();
		}
		
		if (!scope.containsKey(change)) {
			scope.put(change, new ArrayList<>());
		}
		
		
		List<EObject> scopeElements = scope.get(change);
		
		if (!scopeElements.contains(scopeElement)) {
			scopeElements.add(scopeElement);
		}
	}
	
	public List<EObject> get(GraphElement graphElement) {
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
