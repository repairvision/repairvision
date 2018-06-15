package org.sidiff.editrule.recognition.scope;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.pattern.domain.Domain;
import org.sidiff.graphpattern.NodePattern;

public class RepairScopeConstraint {

	private Map<Domain, GraphElement> domains = new HashMap<>();
	
	private RepairScope scope;
	
	public RepairScopeConstraint(RepairScope scope, RecognitionPattern recognitionPattern) {
		this.scope = scope;
		
		// Create map from change/repair action to domain: 
		for (GraphElement change : scope.getChanges()) {
			if (change instanceof Node) {
				NodePattern repairContext = recognitionPattern.getNodeTrace().get(change).getNodePatternB();
				domains.put(Domain.get(repairContext), change);
			} else if (change instanceof Edge) {
				
				// Source:
				NodePattern repairSourceContext = recognitionPattern.getEdgeTrace().get(change).getEdgePatternB().getSource();
				domains.put(Domain.get(repairSourceContext), change);
				
				// Target (repair which deletes the context element of a validation):
				NodePattern repairTargetContext = recognitionPattern.getEdgeTrace().get(change).getEdgePatternB().getTarget();
				domains.put(Domain.get(repairTargetContext), change);
			} else if (change instanceof Attribute) {
				Node node = ChangePatternUtil.tryLHS(((Attribute) change).getNode());
				NodePattern repairContext = recognitionPattern.getNodeTrace().get(node).getNodePatternB();
				domains.put(Domain.get(repairContext), change);
			}
		}
	}
	
	public boolean test() {
		
		for (Domain domain : domains.keySet()) {
			GraphElement change = domains.get(domain);
			
			// Search for scope:
			for (EObject scopeElement : scope.get(change)) {
				if (domain.contains(scopeElement)) {
					return true;
				}
			}
		}
		
		return false;
	}
}
