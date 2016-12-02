package org.sidiff.graphpattern.matching.selection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.NodePattern;

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
	
	/**
	 * Append the given path segment and the match at the end of the path.
	 * 
	 * @param segment
	 *            The new path segment.
	 * @param match
	 *            The match of the new segment.
	 */
	public void append(NodePattern segment, Collection<EObject> match) { // FIXME: Set for merge!

		if (segment == position.node) {
			// Merge path end:
			assert (position.match != null);
			position.match.addAll(match);
		} else {
			// New path end:
			PathSegment next = new PathSegment();
			next.previous = position;
			next.node = segment;
			next.match = match;
			
			position = next;
		}
	}
	
	/**
	 * Inserts the given path segment and the match 
	 * before the actual position of this path.
	 * 
	 * @param segment
	 *            The new path segment.
	 * @param match
	 *            The match of the new segment.
	 */
	public void insert(NodePattern segment, Collection<EObject> match) {
		PathSegment insertion = new PathSegment();
		insertion.node = segment;
		insertion.match = match;
		
		// Relink:
		insertion.previous = position.previous;
		position.previous = insertion;
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
