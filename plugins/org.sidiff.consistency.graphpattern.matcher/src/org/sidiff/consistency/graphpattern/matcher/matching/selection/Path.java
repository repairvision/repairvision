package org.sidiff.consistency.graphpattern.matcher.matching.selection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.NodePattern;

public class Path {
	
	protected PathSegment position;
	
	protected class PathSegment {
		PathSegment previous;
		NodePattern node;
		Collection<EObject> match;
	}
	
	protected Iterator<PathSegment> iterator() {
		return new Iterator<PathSegment>() {
			PathSegment it = position;
			
			@Override
			public PathSegment next() {
				it = it.previous;
				return it;
			}
			
			@Override
			public boolean hasNext() {
				return (it.previous != null);
			}
		};
	}
	
	protected PathSegment getPathSegment(NodePattern node) {
		
		for (Iterator<PathSegment> iterator = iterator(); iterator.hasNext();) {
			PathSegment pathSegment = iterator.next();
			
			if (pathSegment.node == node) {
				return pathSegment;
			}
		}
		return null;
	}
	
	protected Path() {
	}
	
	public Path(NodePattern initialSegment, Collection<EObject> match) {
		position = new PathSegment();
		position.node = initialSegment;
		position.match = match;
	}
	
	public NodePattern getPosition() {
		return position.node;
	}
	
	public Collection<EObject> getLastMatch() {
		return position.match;
	}
	
	public void append(NodePattern segment, Collection<EObject> match) {
		PathSegment next = new PathSegment();
		next.previous = position;
		next.node = segment;
		next.match = match;
		
		position = next;
	}
	
	public Collection<EObject> getMatch(NodePattern segment) {
		PathSegment pathSegment = getPathSegment(segment);
		return (pathSegment != null) ? pathSegment.match : Collections.emptyList();
	}
	
	public boolean contains(NodePattern segment) {
		return (getPathSegment(segment) != null);
	}
	
	public Path fork() {
		Path clonedPath = new Path();
		clonedPath.position = position;
		return clonedPath;
	}
}
