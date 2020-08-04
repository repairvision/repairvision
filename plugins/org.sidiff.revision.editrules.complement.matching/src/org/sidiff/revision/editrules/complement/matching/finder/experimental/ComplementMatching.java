package org.sidiff.revision.editrules.complement.matching.finder.experimental;
//package org.sidiff.revision.repair.complement.peo.match;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//
//import org.eclipse.emf.henshin.interpreter.EGraph;
//import org.eclipse.emf.henshin.interpreter.Match;
//import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
//import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
//import org.eclipse.emf.henshin.model.Attribute;
//import org.eclipse.emf.henshin.model.Edge;
//import org.eclipse.emf.henshin.model.GraphElement;
//import org.eclipse.emf.henshin.model.Node;
//import org.eclipse.emf.henshin.model.Rule;
//import org.sidiff.revision.repair.complement.construction.ComplementRule;
//import org.sidiff.revision.repair.complement.peo.impact.GraphActionImpactUtil;
//import org.sidiff.validation.constraint.impact.ImpactAnalysis;
//import org.sidiff.validation.constraint.impact.ImpactAnalyzes;
//import org.sidiff.common.utilities.henshin.ChangePatternUtil;
//import org.sidiff.editrule.recognition.impact.ImpactScope;
//
//public class ComplementMatching {
//
//	/**
//	 * The complement rule.
//	 */
//	private ComplementRule complement;
//	
//	/**
//	 * The segmentation of independent graphs of the LHS.
//	 */
//	private List<Segment> segments;
//	
//	/**
//	 * A partial pre-matching for the complement rule.
//	 */
//	private Match partialMatch;
//	
//	/**
//	 * The independent matchings for the complement rule segments.
//	 */
//	private ArrayList<Match>[] matching;
//	
//	/**
//	 * Positive impact: The independent matchings for the complement rule segments.
//	 */
//	private ArrayList<Match>[] positiveImpactMatching;
//	
//	public class Segment extends ArrayList<Node> {
//		private static final long serialVersionUID = 1L;
//		
//		private boolean potentialPositiveImpact;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public ComplementMatching(ComplementRule complement, Match partialMatch, ImpactAnalyzes impact) {
//		this.complement = complement;
//		this.partialMatch = partialMatch;
//		this.segments = segmentation(complement, impact);
//		this.matching = new ArrayList[segments.size()];
//		this.positiveImpactMatching = new ArrayList[segments.size()];
//		
//		for (int i = 0; i < matching.length; i++) {
//			this.matching[i] = new ArrayList<Match>();
//		}
//		
//		for (int i = 0; i < positiveImpactMatching.length; i++) {
//			this.positiveImpactMatching[i] = new ArrayList<Match>();
//		}
//	}
//	
//	public List<Segment> getSegments() {
//		return segments;
//	}
//	
//	public List<Match> getMatching(Segment segment) {
//		return matching[segments.indexOf(segment)];
//	}
//	
//	public boolean isEmpty() {
//		for (int i = 0; i < matching.length; i++) {
//			if (!this.matching[i].isEmpty()) {
//				return false;
//			}
//		}
//		for (int i = 0; i < positiveImpactMatching.length; i++) {
//			if (!this.positiveImpactMatching[i].isEmpty()) {
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public int size() {
//		int size = 0;
//		
//		for (int i = 0; i < matching.length; i++) {
//			size *= (this.matching[i].size() + this.positiveImpactMatching[i].size());
//		}
//		
//		return size;
//	}
//	
//	public void match(EngineImpl engine, EGraph model, ImpactAnalyzes impact) {
//		
//		if (getSegments().size() == 1) {
//			segmentMatch(engine, model, impact, getSegments().get(0), true);
//		} else {
//			
//			// (1) Process segments with potential positive impact:
//			for (Segment segment : getSegments()) {
//				if (segment.potentialPositiveImpact) {
//					if (!segmentMatch(engine, model, impact, segment, requirePositiveImpact(segment))) {
//						return;
//					}
//				}
//			}
//			
//			if (positiveImpactMatchingSize() == 1) {
//				for (int i = 0; i < positiveImpactMatching.length; i++) {
//					if (!positiveImpactMatching[i].isEmpty()) {
//						matching[i] = new ArrayList<>(0);
//					}
//				}
//			}
//			
//			// (2) Process other segments:
//			for (Segment segment : getSegments()) {
//				if (!segment.potentialPositiveImpact) {
//					if (!segmentMatch(engine, model, impact, segment, false)) {
//						return;
//					}
//				}
//			}
//		}
//		
//		System.out.println("ComplementMatching.match()");
//	}
//	
//	private boolean requirePositiveImpact(Segment segment) {
//		
//		// Check if a segment with potential positive impact is not matched yet:
//		for (int i = segments.indexOf(segment) + 1; i < positiveImpactMatching.length; i++) {
//			if (segments.get(i).potentialPositiveImpact) {
//				return false;
//			}
//		}
//		
//		// Check if segment match with positive impact was already found:
//		for (int i = 0; i < segments.indexOf(segment); i++) {
//			if (!this.positiveImpactMatching[i].isEmpty()) {
//				return false;
//			}
//		}
//		
//		return true;
//	}
//	
//	private int positiveImpactMatchingSize() {
//		int size = 0;
//		
//		for (int i = 0; i < positiveImpactMatching.length; i++) {
//			if (!positiveImpactMatching[i].isEmpty()) {
//				++size;
//			}
//		}
//		
//		return size;
//	}
//
//	// TODO: Check the repair impact as user defined constraint in the Henshin CSP.  
//	private boolean segmentMatch(EngineImpl engine, EGraph model, ImpactAnalyzes impact, Segment segment, boolean requirePositiveImpact) {
//		
//		// Prepare segment pre-match by assigning static values from base match to other segments:
//		Match partialSegmentMatch = new MatchImpl(partialMatch, false);
//		
//		for (Segment otherSegment : getSegments()) {
//			if (otherSegment != segment) {
//				for (Node otherSegmentNode : otherSegment) {
//					partialSegmentMatch.setNodeTarget(otherSegmentNode, MatchImpl.DUMMY_NODE_TARGET);	// FIXME: Does not work with NACs
//				}
//			}
//		}
//		
//		// Start matching:
//		ArrayList<Match> matching = this.matching[segments.indexOf(segment)]; 
//		ArrayList<Match> positiveImpactMatching = this.positiveImpactMatching[segments.indexOf(segment)]; 
//		
//		Iterator<Match> matchFinder = engine.findMatches(complement.getComplementRule(), model, partialSegmentMatch).iterator();
//		
//		ImpactAnalysis currentImpactAnalysis = impact.getCurrentImpactAnalysis();
//		List<GraphElement> complementChanges = complement.getComplementingChanges();
//		
////		while (matchFinder.hasNext() && (complementPreMatches.size() < 1)) {
//		while (matchFinder.hasNext()) {
//			Match nextMatch = matchFinder.next();
//			boolean positiveImpact = segment.potentialPositiveImpact 
//					? GraphActionImpactUtil.real(currentImpactAnalysis, complementChanges, nextMatch)
//					: false;
//			
//			// Filter complement with match by impact:
//			if (!requirePositiveImpact || positiveImpact) {
//				if (positiveImpact) {
//					positiveImpactMatching.add(nextMatch);
//				} else {
//					matching.add(nextMatch);
//				}
//			}
//		}
//		
//		// At least one matching found?
//		if (matching.isEmpty() && positiveImpactMatching.isEmpty()) {
//			
//			// No matching possible!
//			for (int i = 0; i < this.matching.length; i++) {
//				this.matching[i].clear();
//			}
//			
//			return false;
//		} else {
//			
//			// Trim matching lists:
//			matching.trimToSize();
//			return true;
//		}
//	}
//	
//	private List<Segment> segmentation(ComplementRule complement, ImpactAnalyzes impact) {
//		List<Segment> segments = new ArrayList<>();
//		Set<Node> nodesInSegment = new HashSet<>();
//		
//		while (nodesInSegment.size() < complement.getComplementRule().getLhs().getNodes().size()) {
//			for (Node lhsNode : complement.getComplementRule().getLhs().getNodes()) {
//				if (!nodesInSegment.contains(lhsNode)) {
//					Segment segment = new Segment();
//					closure(nodesInSegment, segment, lhsNode);
//					segments.add(segment);
//				}
//			}
//		}
//		
//		for (Segment segment : segments) {
//			ImpactAnalysis currentImpactAnalysis = impact.getCurrentImpactAnalysis();
//			ImpactScope currentImpactScope = new ImpactScope(complement.getComplementingChanges(), currentImpactAnalysis);
//			
//			for (GraphElement impactElement : currentImpactScope.getChanges()) {
//				if (impactElement instanceof Edge) {
//					if (segment.contains(ChangePatternUtil.getLHS(((Edge) impactElement).getSource()))) {
//						segment.potentialPositiveImpact = true;
//						break;
//					}
//				} else if (impactElement instanceof Attribute) {
//					if (segment.contains(ChangePatternUtil.getLHS(((Attribute) impactElement).getNode()))) {
//						segment.potentialPositiveImpact = true;
//						break;
//					}
//				}
//			}
//		}
//		
//		return segments;
//	}
//
//	private void closure(Set<Node> nodesInSegment, Segment segment, Node lhsNode) {
//		nodesInSegment.add(lhsNode);
//		segment.add(lhsNode);
//		
//		// Outgoing:
//		for (Edge outgoing : lhsNode.getOutgoing()) {
//			if (!nodesInSegment.contains(outgoing.getTarget())) {
//				closure(nodesInSegment, segment, outgoing.getTarget());
//			}
//		}
//		
//		// Incoming:
//		for (Edge incoming : lhsNode.getIncoming()) {
//			if (!nodesInSegment.contains(incoming.getSource())) {
//				closure(nodesInSegment, segment, incoming.getSource());
//			}
//		}
//		
//		
//		// TODO: Parameter
//		// TODO: Multi-Rules
//	}
//}
