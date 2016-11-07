package org.sidiff.consistency.graphpattern.sandbox.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.sidiff.consistency.graphpattern.sandbox.graph.Example;
import org.sidiff.consistency.graphpattern.sandbox.graph.Node;

public class ReadGraphs {

	public static Example readExample(String examplePath) {
		Example example = new Example();
		List<Node> graph = null;

		try {
			File file = new File(examplePath);
			
			for (Object readLine : Files.lines(file.toPath()).toArray()) {
				String line = (String) readLine;
				
				if (line.contains("pattern:")) {
					graph = example.getPatternGraph();
				} else if (line.contains("working:")) {
					graph = example.getWorkingGraph();
				} else if (line.contains("-")) {
					// A-B
					String[] edge = line.split("-");
					Node a;
					Node b;
					
					// A
					if (edge[0].contains(":")) {
						// X:A
						String[] labeledNode = edge[0].split(":");
						a = new Node(labeledNode[1], example.getPatternGraphNode(labeledNode[0]));
						graph.add(a);
					} else {
						a = new Node(edge[0]);
						graph.add(a);
					}
					
					// B
					if (edge[1].contains(":")) {
						// X:A
						String[] labeledNode = edge[1].split(":");
						b = new Node(labeledNode[1], example.getPatternGraphNode(labeledNode[0]));
						graph.add(b);
					} else {
						b = new Node(edge[1]);
						graph.add(b);
					}
					
					a.addAdjacent(b);
					b.addAdjacent(a);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return example;
	}
}
