package org.sidiff.consistency.repair.lifting.engine.partial;

import static org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper.getDataStore;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NavigableDataStore;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.Visitor;
import org.sidiff.consistency.graphpattern.matcher.tools.paths.IPathRestriction;
import org.sidiff.consistency.graphpattern.matcher.wgraph.IConstraintTester;
import org.sidiff.consistency.graphpattern.matcher.wgraph.partial.LocalEvaluationMatcher;
import org.sidiff.consistency.graphpattern.matcher.wgraph.partial.LocalEvaluationPathAnalyser;
import org.sidiff.consistency.repair.lifting.engine.LiftingEngine;
import org.sidiff.consistency.repair.lifting.matching.LiftingConstraintTester;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphDomainMap;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphIndex;
import org.sidiff.consistency.repair.lifting.util.RecognitionRuleUtil;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricPackage;

public class PartialLiftingEngine extends LiftingEngine {

	private IPathRestriction pathRestriction;
	
	private LocalEvaluationPathAnalyser localEvaluation;
	
	private IConstraintTester constraintTester;
	
	public PartialLiftingEngine(List<NodePattern> graphPattern, ResourceSet targetModels, 
			LiftingGraphIndex changeIndex, LiftingGraphDomainMap changeDomainMap) {
		super(graphPattern, targetModels, changeIndex, changeDomainMap);
	}

	@Override
	public void initialize(Map<NodePattern, Collection<EObject>> variableNodeDomains) {
		super.initialize(variableNodeDomains);
		
		// Create path restrictions:
		pathRestriction = createPathRestriction();
		
		// Calculate local evaluation:
		localEvaluation =  new LocalEvaluationPathAnalyser(variableNodes, pathRestriction);
		
		// Create constraint tester:
		constraintTester = new LiftingConstraintTester(getMatchingHelper());
		
		// Precalculate type nodes:
		calculateTypeNodes(variableNodeDomains);
	}
	
	private void calculateTypeNodes(Map<NodePattern, Collection<EObject>> variableNodeDomains) {
		
		// TODO: Calculate type-nodes: Other solution -> pre-match or type-nodes as variables (-> path target)?
		for (NodePattern changeNode : variableNodes) {
			Iterator<EObject> matches = variableNodeDomains.get(changeNode).iterator();
			NavigableDataStore changeNodeDS = getDataStore(changeNode.getEvaluation());
			
			while (matches.hasNext()) {
				EObject changeMatch = matches.next();
				
				if (changeMatch instanceof RemoveReference) {
					EdgePattern typeEdge = changeNode.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveReference_Type());
					NodePattern typeNode = typeEdge.getTarget();
					NavigableDataStore typeNodeDS = getDataStore(typeNode.getEvaluation());
					EObject typeMatch = ((RemoveReference) changeMatch).getType();
					
					typeNodeDS.addMatch(typeMatch);
					typeNodeDS.addRemoteMatch(typeMatch, changeMatch, typeEdge);
					changeNodeDS.addRemoteMatch(changeMatch, typeMatch, typeEdge);
				}
				
				if (changeMatch instanceof AddReference) {
					EdgePattern typeEdge = changeNode.getOutgoing(SymmetricPackage.eINSTANCE.getAddReference_Type());
					NodePattern typeNode = typeEdge.getTarget();
					NavigableDataStore typeNodeDS = getDataStore(typeNode.getEvaluation());
					EObject typeMatch = ((AddReference) changeMatch).getType();
					
					typeNodeDS.addMatch(typeMatch);
					typeNodeDS.addRemoteMatch(typeMatch, changeMatch, typeEdge);
					changeNodeDS.addRemoteMatch(changeMatch, typeMatch, typeEdge);
				}
				
				if (changeMatch instanceof AttributeValueChange) {
					EdgePattern typeEdge = changeNode.getOutgoing(SymmetricPackage.eINSTANCE.getAttributeValueChange_Type());
					NodePattern typeNode = typeEdge.getTarget();
					NavigableDataStore typeNodeDS = getDataStore(typeNode.getEvaluation());
					EObject typeMatch = ((AttributeValueChange) changeMatch).getType();
					
					typeNodeDS.addMatch(typeMatch);
					typeNodeDS.addRemoteMatch(typeMatch, changeMatch, typeEdge);
					changeNodeDS.addRemoteMatch(changeMatch, typeMatch, typeEdge);
				}
			}
		}

	}
	
	private IPathRestriction createPathRestriction() {
		return new IPathRestriction() {
			
			@Override
			public boolean isRestrictedOutgoing(EdgePattern edge) {
				
				// Evaluate only local changes -> block paths at the type-node:
				if ((edge.getType() == SymmetricPackage.eINSTANCE.getRemoveReference_Type())
						|| (edge.getType() == SymmetricPackage.eINSTANCE.getAddReference_Type())
						|| (edge.getType() == SymmetricPackage.eINSTANCE.getAttributeValueChange())) {
					return true;
				}
				
				return false;
			}
			
			@Override
			public boolean isRestrictedIncoming(EdgePattern edge) {
				return false;
			}
		};
	}
	
	public Map<NodePattern, Collection<EObject>> calculateChangeNodes(SymmetricDifference difference) {
		Map<NodePattern, Collection<EObject>> changeDomains = new LinkedHashMap<>();
		
		// Collect the matchings of the change nodes:
		for (NodePattern changeNode : getChangeNodePatterns()) {
			EClass changeType = changeNode.getType();
			EObject changeDomainType = RecognitionRuleUtil.getChangeType(changeNode);
			
			changeDomains.put(changeNode, changeDomainMap.getChangeDomain(changeType, changeDomainType));
		}

		return changeDomains;
	}

	@Override
	public Visitor createVisitor() {
		return new LocalEvaluationMatcher(this, localEvaluation.getLocalEvaluations(), pathRestriction);
//		return new PartialMatchNeighborsVisitor(matchingHelper);
	}
	
	@Override
	public IConstraintTester getConstraintTester() {
		return constraintTester;
	}
}
