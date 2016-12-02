package org.sidiff.graphpattern.matcher.lifting.engine.partial;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NavigableDataStore;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.graphpattern.matcher.lifting.engine.LiftingEngine;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphDomainMap;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphIndex;
import org.sidiff.graphpattern.wgraph.util.WGraph;

public abstract class PartialLiftingEngine extends LiftingEngine {
	
	protected PartialWorkingGraphConstructor workingGraphConstructor;
	
	public PartialLiftingEngine(List<NodePattern> graphPattern, ResourceSet targetModels, 
			LiftingGraphIndex changeIndex, LiftingGraphDomainMap changeDomainMap) {
		super(graphPattern, targetModels, changeIndex, changeDomainMap);
		
		this.workingGraphConstructor = new PartialWorkingGraphConstructor(targetModels, changeIndex, changeDomainMap);
	}
	
	@Override
	public void start() {
		
		// Precalculate type nodes:
		calculateTypeNodes(variableNodeDomains);
		
		// Calculate matchings:
		super.start();
	}
	
	private void calculateTypeNodes(Map<NodePattern, Collection<EObject>> variableNodeDomains) {
		
		// TODO: Calculate type-nodes: Other solution -> pre-match or type-nodes as variables (-> path target)?
		for (NodePattern changeNode : variableNodes) {
			Iterator<EObject> matches = variableNodeDomains.get(changeNode).iterator();
			NavigableDataStore changeNodeDS = WGraph.getDataStore(changeNode.getEvaluation());
			
			while (matches.hasNext()) {
				EObject changeMatch = matches.next();
				
				if (changeMatch instanceof RemoveReference) {
					EdgePattern typeEdge = changeNode.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveReference_Type());
					NodePattern typeNode = typeEdge.getTarget();
					NavigableDataStore typeNodeDS = WGraph.getDataStore(typeNode.getEvaluation());
					EObject typeMatch = ((RemoveReference) changeMatch).getType();
					
					typeNodeDS.addMatch(typeMatch);
					typeNodeDS.addRemoteMatch(typeMatch, changeMatch, typeEdge);
					changeNodeDS.addRemoteMatch(changeMatch, typeMatch, typeEdge);
				}
				
				if (changeMatch instanceof AddReference) {
					EdgePattern typeEdge = changeNode.getOutgoing(SymmetricPackage.eINSTANCE.getAddReference_Type());
					NodePattern typeNode = typeEdge.getTarget();
					NavigableDataStore typeNodeDS = WGraph.getDataStore(typeNode.getEvaluation());
					EObject typeMatch = ((AddReference) changeMatch).getType();
					
					typeNodeDS.addMatch(typeMatch);
					typeNodeDS.addRemoteMatch(typeMatch, changeMatch, typeEdge);
					changeNodeDS.addRemoteMatch(changeMatch, typeMatch, typeEdge);
				}
				
				if (changeMatch instanceof AttributeValueChange) {
					EdgePattern typeEdge = changeNode.getOutgoing(SymmetricPackage.eINSTANCE.getAttributeValueChange_Type());
					NodePattern typeNode = typeEdge.getTarget();
					NavigableDataStore typeNodeDS = WGraph.getDataStore(typeNode.getEvaluation());
					EObject typeMatch = ((AttributeValueChange) changeMatch).getType();
					
					typeNodeDS.addMatch(typeMatch);
					typeNodeDS.addRemoteMatch(typeMatch, changeMatch, typeEdge);
					changeNodeDS.addRemoteMatch(changeMatch, typeMatch, typeEdge);
				}
			}
		}
	}
	
	@Override
	public PartialWorkingGraphConstructor getWorkingGraphConstructor() {
		return workingGraphConstructor;
	}
}
