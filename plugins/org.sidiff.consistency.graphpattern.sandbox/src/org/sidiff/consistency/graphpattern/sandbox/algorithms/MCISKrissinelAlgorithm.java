package org.sidiff.consistency.graphpattern.sandbox.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.sidiff.consistency.graphpattern.sandbox.graph.Example;
import org.sidiff.consistency.graphpattern.sandbox.graph.Match;
import org.sidiff.consistency.graphpattern.sandbox.graph.Node;

public class MCISKrissinelAlgorithm implements IMatchingEngine {

	private Example example;
	
	private List<Match> matchings = new ArrayList<Match>();
	
	/**
	 * G1: (partial) Pattern
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
		Node[][] M = new Node[example.getPatternGraph().size()][example.getWorkingGraph().size()];
		int[] L = new int[example.getPatternGraph().size()];
	}
	
	@Override
	public List<Match> getMatches(Example example) {
		this.example = example;
		
		this.V = new LinkedList<>(example.getPatternGraph());
		this.W = new LinkedList<>(example.getWorkingGraph());
		VMM D = new VMM();
		
		initialize(D);
		System.out.println(printVMM(D));
		backtrack(D);
		
		return matchings;
	}
	
	private void initialize(VMM D) {
		for (Node vi : V) {
			int i = vi.getIndex();
			int k = 0;
			
			for (Node wj : W) {
				if (nodeCompare(wj, vi)) {
					D.M[i][k] = wj;
					k = k + 1;
				}
			}
			
			D.L[i] = k;
		}
	}
	
	private void backtrack(VMM D) {
		
		if (extendable(D)) {
			Node vi = pickVertex(D);
			Node[] Z = getMappableVertices(vi, D);
			
			for (Node wj : Z) {
				X.addLast(vi);
				Y.addLast(wj);
				
				VMM D1 = refine(D);
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
	
	private Node pickVertex(VMM D) {
		
		// Pick the vertex with the minimal number of candidates:
		Node vimin = null;
		int Li = Integer.MAX_VALUE;
		
		for (Node vi : V) {
			if (!X.contains(vi)) {
				int Lj = D.L[vi.getIndex()];
				
				if ((Lj > 0) && (Lj < Li)) {
					vimin = vi;
					Li = Lj;
				}
			}
		}
		
		return vimin;
	}
	
	private Node[] getMappableVertices(Node vi, VMM D) {
		int i = vi.getIndex();
		return Arrays.copyOf(D.M[i], D.L[i]);
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
				
				// Filer only nodes (vi) that are adjacent to the last assigned node (xq):
				if (vi.isAdjacent(xq)) {
					int l = 0;
					
					for (int j = 0; j < D.L[i]; j++) {
						Node wj = D.M[i][j];
						
						if (edgeCompare(vi, xq, wj, yq)) {
							T[i][l] = wj;
							l = l + 1; 
						}
					}
					
					N[i] = l;
				} else {
					
					// Copy old matrix:
					N[i] = D.L[i];
					T[i] = D.M[i];
				}
			}
		}
		
		return D1;
	}

	private boolean nodeCompare(Node xi, Node yi) {
		return (xi.getLabel() == yi);
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
	
	public String printVMM(VMM D) {
		StringBuffer print = new StringBuffer();
		
		for (int i = 0; i < D.L.length; ++i) {
			
			// Pattern-Node:
			Node vi = example.getPatternGraph().get(i);
			
			print.append(vi);
			appendFill(print, vi + "", 3);
			print.append(" | ");
			
			// Match:
			String yiName = ""; 
			
			for (Node yi : Y) {
				if (yi.getLabel() == vi) {
					yiName = yi.getName();
					break;
				}
			}
			
			print.append(yiName);
			appendFill(print, yiName, 3);
			print.append(" | ");
			
			// Size:
			print.append(D.L[i]);
			appendFill(print, D.L[i] + "", 3);
			print.append(" | ");

			// Matrix:
			Node[] mappable = D.M[i];
			
			for (Node node : mappable) {
				if (node != null) {
					print.append(node + " ");
					appendFill(print, node.toString(), 7);
				}
			}
			
			print.append("\n");
		}
		
		return print.toString();
	}
	
	private void appendFill(StringBuffer print, String s, int length) {
		for (int j = (length - s.length()); j > 0; --j) {
			print.append(" ");
		}
	}
}
