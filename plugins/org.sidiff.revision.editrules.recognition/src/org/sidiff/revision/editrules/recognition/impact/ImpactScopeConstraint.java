package org.sidiff.revision.editrules.recognition.impact;

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
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.revision.editrules.impact.graph.GraphActionImpactScope;
import org.sidiff.revision.editrules.recognition.pattern.RecognitionPattern;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;

public class ImpactScopeConstraint {

	public static final ImpactScopeConstraint DUMMY = new ImpactScopeConstraint() {
		
		@Override
		public boolean test() {
			return true;
		}
	};
	
	private Map<Domain, Set<EObject>> domains = new LinkedHashMap<>();
	
	@SuppressWarnings("unused")
	private GraphActionImpactScope repairScope; // NOTE: For debugging...
	
	protected ImpactScopeConstraint() {
	}
	
	public ImpactScopeConstraint(GraphActionImpactScope graphActionImpactScope, RecognitionPattern recognitionPattern) {
		this.repairScope = graphActionImpactScope;
		
		// Create map from change/repair action to domain: 
		for (GraphElement change : graphActionImpactScope.getChanges()) {
			List<EObject> scope = graphActionImpactScope.get(change);
			
			if (change instanceof Edge) {
				NodePattern repairSourceContext = recognitionPattern.getEdgeTrace().get(change).getEdgePatternB().getSource();
				addScopeToDomain(Domain.get(repairSourceContext), scope);
			} else if (change instanceof Attribute) {
				Node node = HenshinRuleAnalysisUtil.tryLHS(((Attribute) change).getNode());
				NodePattern repairContext = recognitionPattern.getNodeTrace().get(node).getNodePatternB();
				addScopeToDomain(Domain.get(repairContext), scope);
			} else if (change instanceof Node) {
				Node node = HenshinRuleAnalysisUtil.tryLHS((Node) change);
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
