package org.sidiff.consistency.graphpattern.sandbox;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;

import org.sidiff.consistency.graphpattern.sandbox.graph.Example;
import org.sidiff.consistency.graphpattern.sandbox.graph.Match;
import org.sidiff.consistency.graphpattern.sandbox.io.ReadGraphs;
import org.sidiff.consistency.graphpattern.sandbox.io.WriteVisualization;

public class Main {

	public static void main(String[] args) {
		
		Example example = ReadGraphs.readExample("D:\\Workspace\\SiLift\\org.sidiff.consistency.graphpattern.sandbox\\examples\\M001.graph");
		String viz = WriteVisualization.writeVisualization("M001", example, new Match());
		
		try {
			File file = new File("D:\\Workspace\\SiLift\\org.sidiff.consistency.graphpattern.sandbox\\examples\\M001.graph.dot");
			Files.write(file.toPath(), Collections.singleton(viz));
			System.out.println("Visualization: " + file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
