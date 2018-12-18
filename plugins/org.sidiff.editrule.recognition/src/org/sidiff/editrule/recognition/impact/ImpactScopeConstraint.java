package org.sidiff.editrule.recognition.impact;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.pattern.domain.Domain;
import org.sidiff.graphpattern.NodePattern;

public class ImpactScopeConstraint {

	public static final ImpactScopeConstraint DUMMY = new ImpactScopeConstraint() {
		
		@Override
		public boolean test() {
			return true;
		}
	};
	
	private Map<Domain, Set<EObject>> domains = new LinkedHashMap<>();
	
	@SuppressWarnings("unused")
	private ImpactScope repairScope; // NOTE: For debugging...
	
	protected ImpactScopeConstraint() {
	}
	
	public ImpactScopeConstraint(ImpactScope repairScope, RecognitionPattern recognitionPattern) {
		this.repairScope = repairScope;
		
		// Create map from change/repair action to domain: 
		for (GraphElement change : repairScope.getChanges()) {
			List<EObject> scope = repairScope.get(change);
			
			if (change instanceof Edge) {
				
				// Source:
				NodePattern repairSourceContext = recognitionPattern.getEdgeTrace().get(change).getEdgePatternB().getSource();
				addScopeToDomain(Domain.get(repairSourceContext), scope);
				
				// Target (repair which deletes the context element of a validation):
				NodePattern repairTargetContext = recognitionPattern.getEdgeTrace().get(change).getEdgePatternB().getTarget();
				addScopeToDomain(Domain.get(repairTargetContext), scope);
			} else if (change instanceof Attribute) {
				Node node = ChangePatternUtil.tryLHS(((Attribute) change).getNode());
				NodePattern repairContext = recognitionPattern.getNodeTrace().get(node).getNodePatternB();
				addScopeToDomain(Domain.get(repairContext), scope);
			}
		}
	}
	
	private void addScopeToDomain(Domain domain, List<EObject> scope) {
		Set<EObject> allScopes = domains.get(domain);
		
		if (allScopes == null) {
			allScopes = new HashSet<>();
			domains.put(domain, allScopes);
		}
		
		allScopes.addAll(scope);
	}
	
	public boolean test() {
		
		// Search for scope:
		for (Entry<Domain, Set<EObject>> domain : domains.entrySet()) {
			if (domain.getKey().containsAny(domain.getValue())) {
				return true;
			}
		}
		
		return false;
	}
}
