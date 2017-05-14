package org.sidiff.editrule.partialmatcher.scope;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.common.henshin.ChangePatternUtil;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
import org.sidiff.editrule.partialmatcher.pattern.domain.Domain;
import org.sidiff.graphpattern.NodePattern;

public class RepairScopeConstraint {

	private Map<GraphElement, Domain> domains = new HashMap<>();
	
	private RepairScope scope;
	
	public RepairScopeConstraint(RepairScope scope, RecognitionPattern recognitionPattern) {
		this.scope = scope;
		
		// Create map from change/repair action to domain: 
		for (GraphElement change : scope.getChanges()) {
			if (change instanceof Node) {
				NodePattern repairContext = recognitionPattern.getNodeTrace().get(change).getNodePatternB();
				domains.put(change, Domain.get(repairContext));
			} else if (change instanceof Edge) {
				Edge edge = (Edge) change;
				
				if (edge.getType().isContainment() && (edge.getType().getEOpposite() == null)) {
					NodePattern repairContext = recognitionPattern.getEdgeTrace().get(change).getEdgePatternB().getTarget();
					domains.put(change, Domain.get(repairContext));
				} else {
					NodePattern repairContext = recognitionPattern.getEdgeTrace().get(change).getEdgePatternB().getSource();
					domains.put(change, Domain.get(repairContext));
				}
			} else if (change instanceof Attribute) {
				Node node = ChangePatternUtil.tryLHS(((Attribute) change).getNode());
				NodePattern repairContext = recognitionPattern.getNodeTrace().get(node).getNodePatternB();
				domains.put(change, Domain.get(repairContext));
			}
		}
	}

	public void addDomain(GraphElement change, Domain domain) {
		domains.put(change, domain);
	}
	
	public boolean test() {
		
		for (GraphElement change : domains.keySet()) {
			Domain domain = domains.get(change);
			
			// Search for scope:
			for (EObject scopeElement : scope.get(change)) {
				if (domain.containsMatch(scopeElement)) {
					return true;
				}
			}
		}
		
		return false;
	}
}
