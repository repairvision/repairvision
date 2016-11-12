package org.sidiff.consistency.graphpattern.sandbox;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.sidiff.consistency.graphpattern.sandbox.algorithms.IMatchingEngine;
import org.sidiff.consistency.graphpattern.sandbox.algorithms.KrissinelAlgorithm;
import org.sidiff.consistency.graphpattern.sandbox.graph.Example;
import org.sidiff.consistency.graphpattern.sandbox.graph.Match;
import org.sidiff.consistency.graphpattern.sandbox.graph.Node;
import org.sidiff.consistency.graphpattern.sandbox.io.ReadGraphs;
import org.sidiff.consistency.graphpattern.sandbox.io.WriteVisualization;

public class Main {

	private static String base = "D:\\Workspace\\SiLift\\org.sidiff.consistency.graphpattern.sandbox\\examples\\";

	private static String name = "M003";

	public static void main(String[] args) {

		// Load example:
		Example example = ReadGraphs.readExample(base + name + ".graph");

		// Calculate matching:
		long start = System.currentTimeMillis();

		IMatchingEngine engine = new KrissinelAlgorithm();
		List<Match> matchings = engine.getMatches(example);

		System.out.println("Matching Time: " + ((double) (System.currentTimeMillis() - start)) / 1000 + "s");
		System.out.println("Matches Found: " + matchings.size());

		// Visualize:
		String viz = WriteVisualization.writeVisualization(name, example, Match.getMaxMatch(matchings));
		String path = base + name + ".graph.dot";
		WriteVisualization.saveVisualization(viz, path);

		// All matches:
		List<Match> printedMatches = new ArrayList<>(matchings.size());
		
		for (int i = 0; i < matchings.size(); i++) {
			Match match = matchings.get(i);
			
			if (!containsSubMatch(printedMatches, match)) {
				printedMatches.add(match);
				DecimalFormat numbering = new DecimalFormat("000");
				
				viz = WriteVisualization.writeVisualization(name, example, matchings.get(i));
				path = base + name + ".graph_" + numbering.format(i) + ".dot";
				WriteVisualization.saveVisualization(viz, path);
			}
		}

		System.out.println("Visualization (" + printedMatches.size() + "): " + path);

	}
	
	private static boolean containsSubMatch(Collection<Match> superMatchings, Match subMatch) {
		for (Match superMatch : superMatchings) {
			if (isSubmatch(superMatch, subMatch)) {
				return true;
			}
		}
		return false;
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
