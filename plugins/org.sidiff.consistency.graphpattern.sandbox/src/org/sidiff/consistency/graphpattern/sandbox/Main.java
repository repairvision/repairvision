package org.sidiff.consistency.graphpattern.sandbox;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.sidiff.consistency.graphpattern.sandbox.algorithms.IMatchingEngine;
import org.sidiff.consistency.graphpattern.sandbox.algorithms.KrissinelAlgorithm2;
import org.sidiff.consistency.graphpattern.sandbox.graph.Example;
import org.sidiff.consistency.graphpattern.sandbox.graph.Match;
import org.sidiff.consistency.graphpattern.sandbox.graph.Node;
import org.sidiff.consistency.graphpattern.sandbox.io.ReadGraphs;
import org.sidiff.consistency.graphpattern.sandbox.io.WriteVisualization;

public class Main {

	private static String base = "D:\\Workspace\\SiLift\\org.sidiff.consistency.graphpattern.sandbox\\examples\\";

	private static String name = "M004";

	public static void main(String[] args) {

		// Load example:
		Example example = ReadGraphs.readExample(base + name + ".graph");

		// Calculate matching:
		long start = System.currentTimeMillis();

		IMatchingEngine engine = new KrissinelAlgorithm2();
		List<Match> matchings = engine.getMatches(example);

		System.out.println("Matching Time: " + ((double) (System.currentTimeMillis() - start)) / 1000 + "s");
		System.out.println("Matches Found: " + matchings.size());

		// Visualize:
		String viz = WriteVisualization.writeVisualization(name, example, Match.getMaxMatch(matchings));
		String path = base + name + ".graph.dot";
		WriteVisualization.saveVisualization(viz, path);

		// All matches:
		List<Match> postprocessedMatches = new ArrayList<>(matchings.size());
		
		for (int i = 0; i < matchings.size(); i++) {
			Match match = matchings.get(i);
			
			// Remove possible sub-matchings:
			int subMatch = getSubMatch(postprocessedMatches, match);
			
			if (subMatch != -1) {
				postprocessedMatches.remove(subMatch);
			}
			
			// Add new matching:
			if (getSuperMatch(postprocessedMatches, match) == -1) {
				postprocessedMatches.add(match);
			}
		}
		
		for (int i = 0; i < postprocessedMatches.size(); i++) {
			Match match = postprocessedMatches.get(i);
			
			System.out.println(match.getMatch());

			viz = WriteVisualization.writeVisualization(name, example, match);
			DecimalFormat numbering = new DecimalFormat("000");
			path = base + name + ".graph_" + numbering.format(i) + ".dot";
			WriteVisualization.saveVisualization(viz, path);
		}

		System.out.println("Visualization (" + postprocessedMatches.size() + "): " + path);

	}
	
	private static int getSuperMatch(List<Match> superMatchings, Match subMatch) {
		for (int i = 0; i < superMatchings.size(); i++) {
			Match superMatch = superMatchings.get(i);
			
			if (isSubmatch(superMatch, subMatch)) {
				return i;
			}
		}
		return -1;
	}
	
	private static int getSubMatch(List<Match> subMatchings, Match superMatch) {
		for (int i = 0; i < subMatchings.size(); i++) {
			Match subMatch = subMatchings.get(i);
			
			if (isSubmatch(superMatch, subMatch)) {
				return i;
			}
		}
		return -1;
	}
	
	private static boolean isSubmatch(Match superMatch, Match subMatch) {
		for (Node subNode : subMatch.getMatch()) {
			if (!superMatch.getMatch().contains(subNode)) {
				return false;
			}
		}
		return true;
	}

}
