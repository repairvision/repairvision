package org.sidiff.consistency.graphpattern.sandbox.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.sidiff.consistency.graphpattern.sandbox.graph.Example;
import org.sidiff.consistency.graphpattern.sandbox.graph.Match;
import org.sidiff.consistency.graphpattern.sandbox.graph.Node;

// TODO: subdivision graph -> atomic matching of edge nodes!
public class MCCSKrissinelAlgorithm implements IMatchingEngine {

	private static boolean DEBUG = false;
	
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

	// FIXME: Filter sub matchings...
	// Knoten entfernen -> Einträge in der Matrix lassen
	// -> Expandable True -> Pick Node False
	private boolean newMatch = false; 

	/**
	 * Minimal size of common sub-graphs to be found.
	 */
	private int n0 = 1;

	private class VMM {
		// TODO: W.size() => size per slot
		Node[][] M = new Node[example.getPatternGraph().size()][example.getWorkingGraph().size()];
		int[] L = new int[example.getPatternGraph().size()];
		
		public void trim() {
			for (int i = 0; i < M.length; ++i) {
				M[i] = Arrays.copyOf(M[i], L[i]);
			}
		}
		
		public boolean validateSize() {
			for (int i = 0; i < M.length; ++i) {
				int size = 0;

				for (int j = 0; j < M[i].length; ++j) {
					if (M[i][j] != null) {
						++size;
					}
				}

				if (size != L[i]) {
					return false;
				}
			}
			return true;
		}
	}

	@Override
	public List<Match> getMatches(Example example) {
		this.example = example;

		this.V = new LinkedList<>(example.getPatternGraph());
		this.W = new LinkedList<>(example.getWorkingGraph());
		VMM D = new VMM();

		initialize(D);
		D.trim();
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

			if (vi != null) {
				Node[] Z = getMappableVertices(vi, D);

				for (Node wj : Z) {
					X.addLast(vi);
					Y.addLast(wj);
					newMatch = true;

					VMM D1 = refine(D);
					backtrack(D1);

					X.removeLast();
					Y.removeLast();
					newMatch = false;
				}

				 V.remove(vi);
				
				 VMM D1 = refine(D, vi);
				 backtrack(D1);
				
				 V.add(vi);
			} else {
				if (newMatch) {
					newMatch = false;
					output();
				}
			}
		} else {
			if (newMatch) {
				newMatch = false;
				output();
			}
		}
	}

	private boolean extendable(VMM D) {
		int q = X.size(); // actual match size
		int s = X.size(); // actual match size + free mappable nodes

		for (Node vi : V) {
			int i = vi.getIndex();

			// All nodes that have not yet been assigned:
			if (!X.contains(vi)) {
				// Count of mappable nodes for vi:
				int Li = D.L[i];

				if (Li > 0) {
					s = s + 1;
				}
			}
		}

		// s > q => extendible
		// s >= n0 => potentially extendible to match greater (or equal) then required minimum
		if ((s >= n0) && (s > q)) {
			return true;
		} else {
			return false;
		}
	}

	private Node pickVertex(VMM D) {

		// Pick the vertex with the minimal number of candidates:
		Node vimin = null;
		int Li = Integer.MAX_VALUE;

		for (Node xi : X) {
			for (Node vi : xi.getAdjacent()) {

				// All nodes that have not yet been assigned:
				if (!X.contains(vi)) {
					int Lj = D.L[vi.getIndex()];

					if ((Lj > 0) && (Lj < Li)) {
						vimin = vi;
						Li = Lj;
					}
				}
			}
		}

		// FIXME: Find minimum...
		if (X.isEmpty()) {
			return V.get(0);
		}

		return vimin;
	}

	private Node[] getMappableVertices(Node vi, VMM D) {
		int i = vi.getIndex();
		return Arrays.copyOf(D.M[i], D.L[i]);
	}

	private VMM refine(VMM D, Node vi) {

		// Remove vi from matrix:
		int i = vi.getIndex();

		// Update all nodes that are adjacent to vi:
		for (Node wi : D.M[i]) {
			if (wi != null) {

				// wi adjacent to all remaining vi?
				if (isInduced(vi, wi)) {	// FIXME: Test necessary?
					for (Node adjacent : vi.getAdjacent()) {
						if (V.contains(adjacent)) {
							int q = 0;

							for (int j = 0; j < D.M[adjacent.getIndex()].length; ++j) {
								Node mappable = D.M[adjacent.getIndex()][j];
								D.M[adjacent.getIndex()][j] = null;

								if (mappable != null) {
									if (!wi.getAdjacent().contains(mappable)) {
										D.M[adjacent.getIndex()][q] = mappable;
										q = q + 1;
									}
								}
							}

							D.L[adjacent.getIndex()] = q;
						}
					}
				}
			}
		}

		D.L[i] = 0;
		D.M[i] = new Node[0];

		// TEST:
		if (DEBUG) {
			if (!D.validateSize()) {
				System.err.println("Matrix Size Invalid!");
			}
		}

		return D;
	}
	
	private boolean isInduced(Node vi, Node wi) {
		for (Node adjacent : vi.getAdjacent()) {
			if (V.contains(adjacent)) {
				boolean induced = false;

				for (Node wiAdj : wi.getAdjacent()) {
					if (wiAdj.getLabel() == adjacent) {
						induced = true;
						break;
					}
				}
				
				if (!induced) {
					return false;
				}
			}
		}
		return true;
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

				// Filer all nodes (vi) that are adjacent to the last assigned
				// node (xq):
				// => induced sub-graph matching!
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
					T[i] = Arrays.copyOf(D.M[i], N[i]);
					;
				}
			}
		}

		// TEST:
		if (DEBUG) {
			if (!D.validateSize()) {
				System.err.println("Matrix Size Invalid!");
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
			appendFill(print, vi + "", 5);
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
			appendFill(print, yiName, 5);
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
					appendFill(print, node.toString(), 10);
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
