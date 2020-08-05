package org.sidiff.revision.editrules.impact.graph;

import static org.sidiff.revision.common.henshin.HenshinChangesUtil.isStrictMatchingType;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.getContainingReference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.revision.impact.analysis.PotentialImpactScope;

public class GraphActionImpactScope {
	
	private Map<GraphElement, List<EObject>> impactScope;
	
	/**
	 * Indexes all changes and their model elements with potential impact.
	 * 
	 * @param changes The set of changes to test.
	 * @param impact  The impact analysis to test against.
	 */
	public GraphActionImpactScope(Collection<? extends GraphElement> changes, PotentialImpactScope impact) {
		this.impactScope = new HashMap<>();

		for (GraphElement change : changes) {

			// Abstract repairs consider only edges and attributes:
			if (change instanceof Edge) {
				EClass sourceContextType = ((Edge) change).getSource().getType();
				boolean strictContextType = isStrictMatchingType(((Edge) change).getSource());

				// Delete:
				if (change.getGraph().isLhs()) {
					impact.onDeleteReference(sourceContextType, ((Edge) change).getType(), strictContextType)
							.forEachRemaining(elementInScope -> add(change, elementInScope));
				}

				// Create:
				else if (change.getGraph().isRhs()) {
					impact.onCreateReference(sourceContextType, ((Edge) change).getType(), strictContextType)
							.forEachRemaining(elementInScope -> add(change, elementInScope));
				}

				else {
					assert false : "Edge is not a change!";
				}
			}
			
			else if (change instanceof Attribute) {
				EClass contextType = ((Attribute) change).getNode().getType();
				boolean strictContextType = isStrictMatchingType(((Attribute) change).getNode());
				
				impact.onModifyAttribute(contextType, ((Attribute) change).getType(), strictContextType)
						.forEachRemaining(elementInScope -> add(change, elementInScope));
			}
			
			else if (change instanceof Node) {
				EClass objectType = ((Node) change).getType();
				boolean strictObjectType = isStrictMatchingType((Node) change);

				// Delete:
				if (change.getGraph().isLhs()) {
					impact.onDeleteObject(getContainingReference((Node) change), objectType, strictObjectType)
							.forEachRemaining(elementInScope -> add(change, elementInScope));
				}

				// Create:
				else if (change.getGraph().isRhs()) {
					impact.onCreateObject(getContainingReference((Node) change), objectType, strictObjectType)
							.forEachRemaining(elementInScope -> add(change, elementInScope));
				}

				else {
					assert false : "Node is not a change!";
				}
			}
		}
	}
	
	private void add(GraphElement change, EObject scopeElement) {
		if (!impactScope.containsKey(change)) {
			impactScope.put(change, new ArrayList<>());
		}
		
		
		List<EObject> scopeElements = impactScope.get(change);
		
		if (!scopeElements.contains(scopeElement)) {
			scopeElements.add(scopeElement);
		}
	}

	public Set<GraphElement> getChanges() {
		return impactScope.keySet();
	}
	
	public List<EObject> get(GraphElement graphElement) {
		return impactScope.getOrDefault(graphElement, Collections.emptyList());
	}
	
	public boolean isEmpty() {
		return (impactScope == null) || (impactScope.isEmpty());
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		for (GraphElement change : impactScope.keySet()) {
			string.append("<<" + change.getAction() + ">> " + change + ":\n");
			
			for (EObject scopeElement : impactScope.get(change)) {
				string.append("  " + scopeElement + "\n");
			}
		}
		
		return string.toString();
	}
}
