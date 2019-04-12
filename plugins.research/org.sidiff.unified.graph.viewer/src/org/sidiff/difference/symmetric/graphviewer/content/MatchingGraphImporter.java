package org.sidiff.difference.symmetric.graphviewer.content;

import java.util.Iterator;

public interface MatchingGraphImporter {
	
	public Iterator<MatchingNode> getNodes();
	
	public Iterator<MatchingEdge> getEdges();
}
