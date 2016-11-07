package org.sidiff.consistency.graphpattern.sandbox.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.sidiff.consistency.graphpattern.sandbox.graph.Example;
import org.sidiff.consistency.graphpattern.sandbox.graph.Node;

public class ReadGraphs {

	public static Example readExample(String examplePath) {
		Example example = new Example();

		try {
			File file = new File(examplePath);
			
			Files.lines(file.toPath()).forEach(line -> {
				
				if (line.contains("-")) {
					// A-B
					String[] edge = line.split("-");
					Node a;
					Node b;
					
					// A
					if (edge[0].contains(":")) {
						// X:A
						String[] labeledNode = edge[0].split(":");
						String workingNodeName = labeledNode[0].trim();
						String patternNodeName = labeledNode[1].trim();
						
						a = example.getWorklingGraphNode(workingNodeName);
						
						if (a == null) {
							a = new Node(workingNodeName, example.getPatternGraphNode(patternNodeName));
							example.addWorkingGraphNode(a);
						}
					} else {
						String patternNodeName = edge[0].trim();
						a = example.getPatternGraphNode(patternNodeName);
						
						if (a == null) {
							a = new Node(patternNodeName);
							example.addPatternGraphNode(a);
						}
					}
					
					// B
					if (edge[1].contains(":")) {
						// X:A
						String[] labeledNode = edge[1].split(":");
						String workingNodeName = labeledNode[0].trim();
						String patternNodeName = labeledNode[1].trim();
						
						b = example.getWorklingGraphNode(workingNodeName);
						
						if (b == null) {
							b = new Node(workingNodeName, example.getPatternGraphNode(patternNodeName));
							example.addWorkingGraphNode(b);
						}
					} else {
						String patternNodeName = edge[1].trim();
						b = example.getPatternGraphNode(patternNodeName);
						
						if (b == null) {
							b = new Node(patternNodeName);
							example.addPatternGraphNode(b);
						}
					}
					
					a.addAdjacent(b);
					b.addAdjacent(a);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return example;
	}
}
