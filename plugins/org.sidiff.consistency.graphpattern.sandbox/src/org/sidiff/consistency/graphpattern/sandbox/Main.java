package org.sidiff.consistency.graphpattern.sandbox;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
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
		String viz = WriteVisualization.writeVisualization(name, example, new Match());
		
		long start = System.currentTimeMillis();
		
		IMatchingEngine engine = new KrissinelBasicAlgorithm();
		List<Match> matchings = engine.getMatches(example);
		
		System.out.println("Matching Time: " +  ((double) (System.currentTimeMillis() - start)) / 1000 + "s");
		System.out.println("Matches Found: " + matchings.size());
		
		try {
			File file = new File(base + name + ".graph.dot");
			Files.write(file.toPath(), Collections.singleton(viz));
			System.out.println("Visualization: " + file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
