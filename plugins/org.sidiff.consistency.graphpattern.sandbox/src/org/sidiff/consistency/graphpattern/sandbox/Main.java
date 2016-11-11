package org.sidiff.consistency.graphpattern.sandbox;

import java.util.List;

import org.sidiff.consistency.graphpattern.sandbox.algorithms.IMatchingEngine;
import org.sidiff.consistency.graphpattern.sandbox.algorithms.KrissinelBasicAlgorithm;
import org.sidiff.consistency.graphpattern.sandbox.graph.Example;
import org.sidiff.consistency.graphpattern.sandbox.graph.Match;
import org.sidiff.consistency.graphpattern.sandbox.io.ReadGraphs;
import org.sidiff.consistency.graphpattern.sandbox.io.WriteVisualization;

public class Main {
	
	private static String base = "D:\\Workspace\\SiLift\\org.sidiff.consistency.graphpattern.sandbox\\examples\\";
	
	private static String name = "M003";

	public static void main(String[] args) {
		
		Example example = ReadGraphs.readExample(base + name + ".graph");
		
		long start = System.currentTimeMillis();
		
		IMatchingEngine engine = new KrissinelBasicAlgorithm();
		List<Match> matchings = engine.getMatches(example);
		
		System.out.println("Matching Time: " +  ((double) (System.currentTimeMillis() - start)) / 1000 + "s");
		System.out.println("Matches Found: " + matchings.size());
		
		String viz = WriteVisualization.writeVisualization(name, example, new Match());
		String path = base + name + ".graph.dot";
		WriteVisualization.saveVisualization(viz, path);

		System.out.println("Visualization: " + path);

	}

}
