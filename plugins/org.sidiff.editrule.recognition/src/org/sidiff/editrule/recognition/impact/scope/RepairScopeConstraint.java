package org.sidiff.editrule.recognition.impact.scope;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.pattern.domain.Domain;
import org.sidiff.graphpattern.NodePattern;

public class RepairScopeConstraint {

	private Map<Domain, GraphElement> domains = new LinkedHashMap<>();
	
	private RepairScope repairScope;
	
	public RepairScopeConstraint(RepairScope repairScope, RecognitionPattern recognitionPattern) {
		this.repairScope = repairScope;
		
		// Create map from change/repair action to domain: 
		for (GraphElement change : repairScope.getChanges()) {
			if (change instanceof Edge) {
				
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
		
		// Search for scope:
		for (Entry<Domain, GraphElement> domain : domains.entrySet()) {
			if (domain.getKey().containsAny(repairScope.get(domain.getValue()))) {
				return true;
			}
		}
		
		return false;
	}
}
