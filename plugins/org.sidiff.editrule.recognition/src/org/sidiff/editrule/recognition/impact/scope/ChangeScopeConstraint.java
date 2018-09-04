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

public class ChangeScopeConstraint {

	/**
	 * change domain -> change action: 
	 */
	private Map<Domain, GraphElement> domains = new LinkedHashMap<>();
	
	private ChangeScope changeScope;
	
	public ChangeScopeConstraint(ChangeScope changeScope, RecognitionPattern recognitionPattern) {
		this.changeScope = changeScope;
		
		// Create map from change/repair action to domain: 
		for (GraphElement change : changeScope.getChanges()) {
			if (change instanceof Edge) {
				
				// Source:
				NodePattern referenceChangeNode_source = recognitionPattern.getEdgeTrace().get(change).getChange().getChangeNodePattern();
				domains.put(Domain.get(referenceChangeNode_source), change);
				
				// Target (repair which deletes the context element of a validation):
				NodePattern referenceChangeNode_target = recognitionPattern.getEdgeTrace().get(change).getChange().getChangeNodePattern();
				domains.put(Domain.get(referenceChangeNode_target), change);
			} else if (change instanceof Attribute) {
				Node node = ChangePatternUtil.tryLHS(((Attribute) change).getNode());
				NodePattern attributeValueChangeNode = recognitionPattern.getNodeTrace().get(node).getChange().getChangeNodePattern();
				domains.put(Domain.get(attributeValueChangeNode), change);
			}
		}
	}
	
	public boolean test() {
		
		// Search for scope:
		for (Entry<Domain, GraphElement> domain : domains.entrySet()) {
			if (domain.getKey().containsAny(changeScope.get(domain.getValue()))) {
				return true;
			}
		}
		
		return false;
	}
	
}
