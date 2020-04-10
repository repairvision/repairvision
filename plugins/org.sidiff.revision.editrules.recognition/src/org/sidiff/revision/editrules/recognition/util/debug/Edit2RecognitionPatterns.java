package org.sidiff.revision.editrules.recognition.util.debug;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sidiff.graphpattern.DependencyGraph;
import org.sidiff.graphpattern.DependencyNode;
import org.sidiff.graphpattern.NodePattern;

public class Edit2RecognitionPatterns {
	
	private List<Edit2RecognitionPattern> patterns = new ArrayList<>();
	
	public List<Edit2RecognitionPattern> getPatterns() {
		return patterns;
	}

	public void setPatterns(List<Edit2RecognitionPattern> patterns) {
		this.patterns = patterns;
	}
	

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		
		Set<Edit2RecognitionPattern> atomic = new HashSet<>();  
		
		// Print atomic patterns:
		if (!patterns.isEmpty()) {
			DependencyGraph graph = patterns.get(0).getRecognitionPattern().get(0).getNode().getGraph().getDependencyGraph();
			
			for (DependencyNode dependencyNode : graph.getNodes()) {
				string.append("================================================================================\n");
				string.append("Atomic Pattern:\n");
				string.append("================================================================================\n");
				
				for (NodePattern node : dependencyNode.getNodes()) {
					for (Edit2RecognitionPattern edit2RecognitionPattern : patterns) {
						for (NodePatternWithDomain nodeWithDomain : edit2RecognitionPattern.getRecognitionPattern()) {
							if (nodeWithDomain.getNode() == node) {
								if (!atomic.contains(edit2RecognitionPattern)) {
									string.append(edit2RecognitionPattern.toString(patterns.indexOf(edit2RecognitionPattern)));
									atomic.add(edit2RecognitionPattern);
								}
							}
						}
					}
				}
				
				string.append("================================================================================\n");
			}
		}
		
		for (Edit2RecognitionPattern edit2RecognitionPattern : patterns) {
			if (!atomic.contains(edit2RecognitionPattern)) {
				string.append(edit2RecognitionPattern.toString(patterns.indexOf(edit2RecognitionPattern)));
			}
		}
		
		return string.toString();
	}
}
