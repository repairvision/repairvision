package org.sidiff.consistency.graphpattern.sandbox.algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.sidiff.consistency.graphpattern.sandbox.graph.Example;
import org.sidiff.consistency.graphpattern.sandbox.graph.Match;
import org.sidiff.consistency.graphpattern.sandbox.graph.Node;

public class KrissinelBasicAlgorithm implements IMatchingEngine {

	private List<Match> matchings = new ArrayList<Match>();
	
	/**
	 * G1: Pattern
	 */
	private LinkedList<Node> V;
	
	/**
	 * G2: Working Graph
	 */
	private LinkedList<Node> W;
	
	/**
	 * Mapped Pattern 
	 */
	private LinkedList<Node> X = new LinkedList<>();
	
	/**
	 * Matching
	 */
	private LinkedList<Node> Y = new LinkedList<>();
	
	@Override
	public List<Match> getMatches(Example example) {
		this.V = new LinkedList<>(example.getPatternGraph());
		this.W = new LinkedList<>(example.getWorkingGraph());
		
		backtrack();
		
		return matchings;
	}
	
	private void backtrack() {
		
		if (extendable()) {
			Node vi = pickVertex();
			List<Node> Z = getMappableVertices(vi);
			
			for (Node wj : Z) {
				X.addLast(vi);
				Y.addLast(wj);
				
				backtrack();
				
				X.remove(vi);
				Y.remove(wj);
				
//				X.removeLast();
//				Y.removeLast();
			}
			
			V.remove(vi);
			backtrack();
			V.add(vi);
		} else {
			output();
		}
	}
	
	private boolean extendable() {
		return (X.size() != V.size()) && (Y.size() != W.size());
	}
	
	private Node pickVertex() {
		
		for (Node vi : V) {
			if (!X.contains(vi)) {
				return vi;
			}
		}
		
		return null;
	}
	
	private List<Node> getMappableVertices(Node vi) {
		List<Node> mappable = new LinkedList<>(W);
		mappable.removeAll(Y);
		
		for (Iterator<Node> iterator = mappable.iterator(); iterator.hasNext();) {
			Node wj = iterator.next();
			
			if (wj.getLabel() != vi) {
				iterator.remove();
			}
		}
		
		return mappable;
	}
	
	private void output() {
		Match newMatch = new Match();
		newMatch.setMatch(new ArrayList<>(Y));
		matchings.add(newMatch);
	}
}
