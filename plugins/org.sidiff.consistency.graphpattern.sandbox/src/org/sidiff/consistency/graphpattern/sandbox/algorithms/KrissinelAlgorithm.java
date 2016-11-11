package org.sidiff.consistency.graphpattern.sandbox.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.sidiff.consistency.graphpattern.sandbox.graph.Example;
import org.sidiff.consistency.graphpattern.sandbox.graph.Match;
import org.sidiff.consistency.graphpattern.sandbox.graph.Node;

public class KrissinelAlgorithm implements IMatchingEngine {

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
	
	private int nmax = 0;
	
	/**
	 * Minimal size of common sub-graphs to be found.
	 */
	private int n0 = 1;
	
	private class VMM {
		// TODO: W.size() => size per slot
		Node[][] M = new Node[V.size()][W.size()];
		int[] L = new int[V.size()];
	}
	
	@Override
	public List<Match> getMatches(Example example) {
		this.V = new LinkedList<>(example.getPatternGraph());
		this.W = new LinkedList<>(example.getWorkingGraph());
		VMM D = new VMM();
		
		initialize(D);
		backtrack(D);
		
		return matchings;
	}
	
	private void initialize(VMM D) {
		for (Node vi : V) {
			int i = vi.getIndex();
			int k = 0;
			
			for (Node wj : W) {
				if (nodeCompare(wj, vi)) {
					k = k + 1;
					D.M[i][k] = wj;
				}
			}
			
			D.L[i] = k;
		}
	}
	
	private void backtrack(VMM D) {
		
		if (extendable(D)) {
			Node vi = pickVertex();
			Node[] Z = getMappableVertices(vi, D);
			
			for (Node wj : Z) {
				X.addLast(vi);
				Y.addLast(wj);
				
				VMM D1  = refine(D);
				backtrack(D1);
				
				X.removeLast();
				Y.removeLast();
			}
			
			V.remove(vi);
			backtrack(D);
			V.add(vi);
		} else {
			nmax = Math.max(nmax, X.size());
			output();
		}
	}
	
	private boolean extendable(VMM D) {
		int q = X.size();
		int s = X.size();
		
		for (Node vi : V) {
			int i = vi.getIndex();
			
			if (!X.contains(vi)) {
				int Li = D.L[i];
				
				if (Li > 0) {
					s = s + 1;
				}
			}
		}
		
		if ((s >= Math.max(n0, nmax)) && (s > q)) {
			return true;
		} else {
			return false;
		}
	}
	
	// TODO: ...
	private Node pickVertex() {
		
		for (Node vi : V) {
			if (!X.contains(vi)) {
				return vi;
			}
		}
		
		return null;
	}
	
	private Node[] getMappableVertices(Node vi, VMM D) {
		int i = vi.getIndex();
		return Arrays.copyOf(D.M[i], D.L[i] + 1);
	}
	
	private VMM refine(VMM D) {
		VMM D1 = new VMM();
		Node[][] T = D1.M;
		int[] N = D1.L;
		
		// last/new added node:
		// int q = X.size(); 
		
		Node xq = X.getLast();
		Node yq = Y.getLast();
		
		for (Node vi : V) {
			int i = vi.getIndex();
			
			// All nodes that have not yet been assigned:
			if (!X.contains(vi)) {
				int l = 0;
				
				for (int j = 0; j < D.L[i]; j++) {
					Node DMij = D.M[i][j];
					
					if (edgeCompare(vi, xq, DMij, yq)) {
						l = l + 1;
						T[i][l] = DMij;
					}
				}
				N[i] = l;
			}
		}
		
		return D1;
	}

	private boolean nodeCompare(Node xi, Node yi) {
		return (yi.getLabel() == xi);
	}
	
	private boolean edgeCompare(Node xi, Node xj, Node yi, Node yj) {
		assert nodeCompare(xi, yi) && nodeCompare(xj, yj); 
		return xi.isAdjacent(xj) && yi.isAdjacent(yj);
	}
	
	private void output() {
		Match newMatch = new Match();
		newMatch.setMatch(new ArrayList<>(Y));
		matchings.add(newMatch);
	}
}
