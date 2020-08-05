package org.sidiff.revision.editrules.generation.constructors;

import static org.sidiff.graphpattern.profile.constraints.util.ConstraintProfileUtil.isCondition;
import static org.sidiff.graphpattern.profile.constraints.util.ConstraintProfileUtil.isNegativeCondition;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isCreate;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isDelete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BooleanSupplier;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.csp.generic.ICSPSolver;
import org.sidiff.graphpattern.csp.generic.IConstraintSatisfactionProblem;
import org.sidiff.graphpattern.csp.generic.impl.CSPSolver;
import org.sidiff.graphpattern.csp.generic.impl.ConstraintSatisfactionProblem;
import org.sidiff.graphpattern.csp.generic.impl.Variable;
import org.sidiff.graphpattern.edit.util.LabelServices;
import org.sidiff.graphpattern.tools.csp.GraphPatternMatch;
import org.sidiff.graphpattern.tools.csp.GraphPatternMatchings;
import org.sidiff.graphpattern.tools.csp.NodePatternDomain;
import org.sidiff.graphpattern.tools.csp.NodePatternDomain.EdgeMatching;
import org.sidiff.graphpattern.tools.csp.NodePatternVariable;
import org.sidiff.revision.common.emf.MetaModelUtil;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.editrules.generation.constructors.util.EditRuleCollector;
import org.sidiff.revision.editrules.generation.filter.IEditRuleFilter;
import org.sidiff.revision.editrules.generation.generator.GraphPatternEditRuleGenerator;
import org.sidiff.revision.editrules.generation.generator.util.GraphPatternGeneratorUtil;

public class RelocationEditRuleConstructor implements IEditRuleConstructor {

	public static final String RELOCATION_EDGES_PATTERN_NAME = "RELOCATION_EDGES";

	private Pattern relocationEdges;

	private Map<EReference, List<EdgePattern>> relocationEdgesIndex;

	public RelocationEditRuleConstructor(Bundle patternBundle) {
		this.relocationEdges = getRelocationEdges(patternBundle);
	}

	@Override
	public void construct(Pattern patterns, List<IEditRuleFilter> filter, EditRuleCollector editRules) {

		// Compare each graph pattern with itself:
		for (GraphPattern graphPattern : patterns.getAllGraphPatterns()) {
			generateRelocationRules(graphPattern, filter, editRules);
		}
	}

	private void generateRelocationRules(GraphPattern graphPattern, List<IEditRuleFilter> filter,
			EditRuleCollector editRules) {

		List<EdgePattern> relocatableEdges = getMatches(graphPattern.getNodes());

//		if (graphPattern.getName().contains("Multiplicity-Many Bidirectional Reference")) {
//			System.out.println(graphPattern.getName());
//		}

		// NOTE: Generate only rules that synchronize two relocations:
		if (relocatableEdges.size() >= 2) {

			// Context nodes:
			List<NodePattern> contextNodes = new ArrayList<>();

			// Content nodes:
			List<NodePattern> contentNodes = new ArrayList<>();

			for (NodePattern node : graphPattern.getNodes()) {

				// Is not negative conditional node?
				if (!isNegativeCondition(node)) {

					// Is contained node?
					if (GraphPatternGeneratorUtil.isContext(node)) {
						contextNodes.add(node); // partially matched
					} else {
						if (!isCondition(node)) { // *
							// pre-/ and post-condition graphs will be matched independently (non injective)
							// as application condition of the transformation rule, which is the most
							// general condition, i.e., it is not necessary to generate all partial
							// matchings between the none context exist-nodes.

							contentNodes.add(node); // fully matched
						}
					}
				}
			}

			// NOTE[Filter]: Keep content structure, i.e. relocations only between content
			// and context.
			for (Iterator<EdgePattern> iterator = relocatableEdges.iterator(); iterator.hasNext();) {
				EdgePattern relocatableEdge = iterator.next();

				BooleanSupplier contextToContent = () -> contextNodes.contains(relocatableEdge.getSource())
						&& contentNodes.contains(relocatableEdge.getTarget());
				BooleanSupplier contentToContext = () -> contentNodes.contains(relocatableEdge.getSource())
						&& contextNodes.contains(relocatableEdge.getTarget());

				if (!(contextToContent.getAsBoolean() || contentToContext.getAsBoolean())) {
					iterator.remove();
				}
			}

			if (relocatableEdges.size() >= 2) {
				generateRelocationRules(graphPattern, relocatableEdges, contextNodes, contentNodes, filter, editRules);
			}
		}
	}

	private void generateRelocationRules(GraphPattern graphPattern, List<EdgePattern> relocatableEdges,
			List<NodePattern> contextNodes, List<NodePattern> contentNodes, List<IEditRuleFilter> filter,
			EditRuleCollector editRules) {

		// Setup matching problem (graph pattern with itself):
		int size = contextNodes.size() + contentNodes.size();

		IConstraintSatisfactionProblem<NodePattern, NodePattern> problem = new ConstraintSatisfactionProblem<>(size);
//		problem.setMinimumSolutionSize(contentNodes.size());	// NOTE: consider all context mappings
//		problem.setMaximumSolutionSize(size);
		problem.setMinimumSolutionSize(size - 2);				// NOTE: consider all pairs of unmapped context nodes
		problem.setMaximumSolutionSize(size - 2);
		problem.setSearchInjectiveSolutions(true);

		// Partial matching of context:
		// - node types equal
		// - match all incoming/outgoing edges
		// - edge with equal type (not structural)
		// - NOTE: necessary, not sufficient -> we only allow changes on relocatable
		// edges
		// - matching of relocatable edges is optional
		for (NodePattern contextNode : contextNodes) {
			NodePatternDomain domain = new NodePatternDomain(
					contextNode, 
					Collections.singletonList(contextNode), 		// NOTE: map node only to itself instead of all contextNodes 
					EdgeMatching.TOTAL_BIJECTIVE,
					EdgeMatching.TOTAL_BIJECTIVE, 
					(edge) -> relocatableEdges.contains(edge));
			Variable<NodePattern, NodePattern> variable = new NodePatternVariable(contextNode, domain, true, false, false);
			problem.addVariable(variable);
		}

		// Full matching of content:
		// - node types equal
		// - match all incoming/outgoing edges
		// - edge with equal type (not structural)
		// - NOTE: necessary, not sufficient -> we only allow changes on relocatable
		// edges
		// - matching of relocatable edges is optional
		for (NodePattern contentNode : contentNodes) {
			NodePatternDomain domain = new NodePatternDomain(
					contentNode,
					Collections.singletonList(contentNode),			 // NOTE: use pre-match instead of all contentNodes 
					EdgeMatching.TOTAL_BIJECTIVE,
					EdgeMatching.TOTAL_BIJECTIVE, 
					(edge) -> relocatableEdges.contains(edge));
			Variable<NodePattern, NodePattern> variable = new NodePatternVariable(contentNode, domain, false, true, false);
			problem.addVariable(variable);
		}

		GraphPatternMatchings matchings = new GraphPatternMatchings(graphPattern, graphPattern);
		ICSPSolver<NodePattern, NodePattern> solver = new CSPSolver<>(problem, matchings);
		solver.run();

		// Generate edit rules:
		List<GraphPatternEditRuleGenerator> relocationEditOperations = new ArrayList<>();
		String name = "Relocation: " + graphPattern.getName();

		for (GraphPatternMatch match : matchings.getMatches()) {
			GraphPatternEditRuleGenerator editRuleGenerator = new GraphPatternEditRuleGenerator(
					matchings.getSubjectGraph(), matchings.getValueGraph(), match.getMatch());
			editRuleGenerator.generate(matchings.getSubjectGraph().getNodes(), matchings.getValueGraph().getNodes());

			Pattern editOperation = editRuleGenerator.getEditOperation();
			GraphPattern editRule = editRuleGenerator.getEditRule();

			if (checkRelocationEditRule(editOperation, editRuleGenerator.getTracePreGraph2EditGraph(),
					editRuleGenerator.getTracePostGraph2EditGraph())) {

				if (!IEditRuleFilter.filter(filter, editOperation, editRule, editRules.getRulebase())) {
					GraphPatternGeneratorUtil.removePseudoResourceNode(editRule);
					relocationEditOperations.add(editRuleGenerator);
				} else {
					System.err.println(
							"INFO: Filtered edit rule [" + matchings.getMatches().indexOf(match) + "]: " + name);
				}
			}
		}

		// Add new edit rules:
		int counter = 0;

		for (GraphPatternEditRuleGenerator generated : relocationEditOperations) {

			if (relocationEditOperations.size() > 1) {
				generated.setName(name + " (" + ++counter + ")");
			} else {
				generated.setName(name);
			}

			editRules.add(graphPattern, generated.getEditOperation());
		}
	}

	/**
	 * Edit operation: - contains at least two relocations - i.e. at least 4
	 * relocatable edges - contains only edge changes - no changes on nodes or
	 * attributes - or none relocatable edges
	 */
	private boolean checkRelocationEditRule(Pattern editOperation, Map<NodePattern, NodePattern> tracePreGraph2EditRule,
			Map<NodePattern, NodePattern> tracePostGraph2EditRule) {

		// Contains at least two relocations?
		int relocatableEdgesCount = 0;

		// Contains only changes on relocatable edges?
		for (GraphPattern graph : editOperation.getGraphs()) {
			relocatableEdgesCount += getRelocationCount(getMatches(graph.getNodes()));

			// Contains no node/attribute changes?
			for (NodePattern node : graph.getNodes()) {
				if (node.getStereotypes().contains(delete) || node.getStereotypes().contains(create)) {
					return false;
				}
				for (AttributePattern attribute : node.getAttributes()) {
					if (attribute.getStereotypes().contains(delete) || attribute.getStereotypes().contains(create)) {
						return false;
					}
				}
			}
		}

		// Need at least two relocations for synchronization edit rule!
		return relocatableEdgesCount >= 2;
	}

	protected boolean isRelocation(EdgePattern editRuleEdge, Map<NodePattern, NodePattern> tracePreGraph2EditRule,
			Map<NodePattern, NodePattern> tracePostGraph2EditRule) {

		// NOTE: A relocation happens only between a mapped node
		// and a none mapped node of the pre- and post-graph!
		if (isRelocatableEdge(editRuleEdge)) {
			NodePattern editRuleSource = editRuleEdge.getSource();
			NodePattern editRuleTarget = editRuleEdge.getTarget();

			boolean editRuleSourceMapped = tracePreGraph2EditRule.containsValue(editRuleSource)
					&& tracePostGraph2EditRule.containsValue(editRuleSource);

			boolean editRuleTargetMapped = tracePreGraph2EditRule.containsValue(editRuleTarget)
					&& tracePostGraph2EditRule.containsValue(editRuleTarget);

			if ((editRuleSourceMapped && !editRuleTargetMapped) || (!editRuleSourceMapped && editRuleTargetMapped)) {
				return true;
			}
		}

		return false;
	}

	public Pattern getRelocationEdges() {
		return relocationEdges;
	}

	public Map<EReference, List<EdgePattern>> getRelocationEdgesIndex() {

		if (relocationEdgesIndex == null) {
			this.relocationEdgesIndex = getRelocationEdgesIndex(relocationEdges);
		}

		return relocationEdgesIndex;
	}

	private int getRelocationCount(List<EdgePattern> edges) {
		Set<EdgePattern> relocations = new HashSet<>(edges);

		// count only pairs of create/delete edges with the same type and source node ->
		// remove unpaired:
		for (Iterator<EdgePattern> iterator = relocations.iterator(); iterator.hasNext();) {
			EdgePattern edgePatternA = iterator.next();

			if (isCreate(edgePatternA) || isDelete(edgePatternA)) {
				EdgePattern edgePatternB = getRelocationEdgePair(relocations, edgePatternA);

				if (edgePatternB == null) {
					iterator.remove();
				}
			} else {
				iterator.remove();
			}
		}

		// count only one edge of opposites -> remove one opposite:
		for (Iterator<EdgePattern> iterator = relocations.iterator(); iterator.hasNext();) {
			EdgePattern edgePattern = iterator.next();

			if (relocations.contains(edgePattern.getOpposite())) {
				iterator.remove();
			}
		}

		assert ((relocations.size() % 2) == 0);
		return relocations.size() / 2;
	}

	private EdgePattern getRelocationEdgePair(Set<EdgePattern> edges, EdgePattern edge) {

		// create/delete edges with the same type and source node:
		for (EdgePattern otherEdge : edges) {
			if (otherEdge != edge) {
				if ((isCreate(edge) && isDelete(otherEdge)) || (isCreate(otherEdge) && isDelete(edge))) {
					if ((edge.getSource() == otherEdge.getSource()) && (edge.getTarget() != otherEdge.getTarget())) {
						return otherEdge;
					}
				}
			}
		}

		return null;
	}

	private List<EdgePattern> getMatches(List<NodePattern> nodes) {
		List<EdgePattern> matches = new ArrayList<>();

		for (NodePattern node : nodes) {
			for (EdgePattern edge : node.getOutgoings()) {
				if (isRelocatableEdge(edge)) {
					matches.add(edge);
				}
			}
		}

		return matches;
	}

	private boolean isRelocatableEdge(EdgePattern toBeMatched) {

		if (toBeMatched != null) {

			// Edge is relocatable...
			if (isRelocatableReference(toBeMatched.getSource().getType(), toBeMatched.getType(),
					toBeMatched.getTarget().getType())) {
				return true;
			}

			// ...or its opposite:
			if (isRelocatableReference(toBeMatched.getTarget().getType(), toBeMatched.getType().getEOpposite(),
					toBeMatched.getSource().getType())) {
				return true;
			}
		}

		return false;
	}

	private boolean isRelocatableReference(EClass source, EReference reference, EClass target) {
		List<EdgePattern> potentialMatches = getRelocationEdgesIndex().get(reference);

		if (potentialMatches != null) {
			for (EdgePattern potentialMatch : potentialMatches) {
				boolean sourceMatch = MetaModelUtil.isAssignableTo(source, potentialMatch.getSource().getType());
				boolean targetMatch = MetaModelUtil.isAssignableTo(target, potentialMatch.getTarget().getType());

				if (sourceMatch && targetMatch) {
					return true;
				}
			}
		}

		return false;
	}

	private static Map<EReference, List<EdgePattern>> getRelocationEdgesIndex(Pattern relocationEdges) {
		Map<EReference, List<EdgePattern>> relocationEdgesIndex = new HashMap<>();

		for (GraphPattern graphPattern : relocationEdges.getAllGraphPatterns()) {
			EdgePattern relocationEdge = null;

			// NOTE: Assert exactly one edge per graph pattern:
			for (NodePattern node : graphPattern.getNodes()) {
				if (!node.getOutgoings().isEmpty()) {
					relocationEdge = node.getOutgoings().get(0);
				}
			}

			List<EdgePattern> relocationGraphPatterns = relocationEdgesIndex.get(relocationEdge.getType());

			if (relocationGraphPatterns == null) {
				relocationGraphPatterns = new ArrayList<>(1);
				relocationEdgesIndex.put(relocationEdge.getType(), relocationGraphPatterns);
			}

			relocationGraphPatterns.add(relocationEdge);
		}

		return relocationEdgesIndex;
	}

	public static Pattern getRelocationEdges(Bundle editRuleBundle) {
		return editRuleBundle.getPattern(RELOCATION_EDGES_PATTERN_NAME);
	}

	public static Pattern initializeRelocationEdges(Bundle editRuleBundle) {

		// Initialize new relocation edges pattern container:
		Pattern relocationEdgesPattern = GraphpatternFactory.eINSTANCE.createPattern();
		relocationEdgesPattern.setName(RELOCATION_EDGES_PATTERN_NAME);
		editRuleBundle.getPatterns().add(relocationEdgesPattern);

		// Search all EReferences in the meta-mode(s):
		for (EPackage ePackage : editRuleBundle.getDomains()) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;

					for (EReference eReference : eClass.getEReferences()) {
						if (!DocumentType.isUnconsideredStructualFeature(eReference)) {

							// Create new relocation edge pattern:
							GraphPattern relocationEdge = GraphpatternFactory.eINSTANCE.createGraphPattern();

							// Source
							NodePattern source = GraphpatternFactory.eINSTANCE.createNodePattern();
							source.setType(eClass);
							relocationEdge.getNodes().add(source);

							// Target
							NodePattern target = GraphpatternFactory.eINSTANCE.createNodePattern();
							target.setType((EClass) eReference.getEType());
							relocationEdge.getNodes().add(target);

							// Edge
							EdgePattern edge = GraphpatternFactory.eINSTANCE.createEdgePattern();
							edge.setType(eReference);
							edge.setSource(source);
							edge.setTarget(target);

							// Add to collection:
							relocationEdge.setName(LabelServices.getLabel(edge));
							relocationEdgesPattern.getGraphs().add(relocationEdge);
						}
					}
				}
			}
		}

		return relocationEdgesPattern;
	}
}
