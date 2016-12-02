package org.sidiff.graphpattern.wgraph.construction.tools.paths;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.graphpattern.wgraph.construction.tools.paths.DFSOutgoingPathIterator.DFSPath;

/**
 * Iterates through all simple paths (non-cyclic) from a start node by DFS.
 * 
 * @author Manuel Ohrndorf
 */
public class DFSOutgoingPathIterator implements Iterator<DFSPath> {

	protected DFSPath path;

	public class DFSPath {

		protected NodePattern basePosition;

		protected int baseSegmentIndex = 0;

		protected Stack<EdgePattern> segments = new Stack<>();

		protected Set<NodePattern> nodes = new HashSet<>();

		protected Stack<Iterator<EdgePattern>> traceOutgoings = new Stack<>();

		protected NodePattern position;

		protected NodePattern start;

		public DFSPath(NodePattern start) {
			this.position = start;
			this.start = start;

			this.basePosition = start;

			// Initialize iteration:
			traceOutgoings.add(start.getOutgoings().iterator());
			nodes.add(start);
		}

		public List<EdgePattern> getFullPath() {
			return Collections.unmodifiableList(segments);
		}

		public EdgePattern getFullPathSegment(int index) {
			return segments.get(index);
		}

		public NodePattern getFullPathStart() {
			return start;
		}

		public int getFullPathSize() {
			return segments.size();
		}

		public boolean isFullPathEmpty() {
			return segments.isEmpty();
		}

		public EdgePattern getNewPathSegment(int index) {
			return segments.get(baseSegmentIndex + index);
		}

		public int getNewPathOffset() {
			return baseSegmentIndex;
		}

		public NodePattern getNewPathStart() {
			return basePosition;
		}

		public int getNewPathSize() {
			return segments.size() - baseSegmentIndex;
		}

		public boolean isNewPathEmpty() {
			return (getNewPathSize() == 0);
		}

		public boolean contains(NodePattern node) {
			return nodes.contains(node);
		}
		
		@Override
		public String toString() {
			StringBuffer print = new StringBuffer(); 
			
			for (EdgePattern edge : segments) {
				print.append("[" + edge.getSource().getName());
				print.append(":" + edge.getSource().getType().getName() + "]");
				print.append(" - " + edge.getType().getName() + " -> ");
				print.append("[" + edge.getTarget().getName());
				print.append(":" + edge.getTarget().getType().getName() + "]\n");
			}
			
			return print.toString();
		}
	}

	public DFSOutgoingPathIterator(NodePattern start) {
		this.path = new DFSPath(start);
	}

	@Override
	public boolean hasNext() {
		return !path.traceOutgoings.isEmpty();
	}

	@Override
	public DFSPath next() {

		// Set initial base path:
		path.baseSegmentIndex = path.segments.size();
		path.basePosition = path.position;

		// Set to true if a transition was possible!
		boolean isNewPath = false;

		while (!path.traceOutgoings.isEmpty()) {
			Iterator<EdgePattern> nextEdges = path.traceOutgoings.peek();

			// Iterate outgoings:
			if (nextEdges.hasNext()) {
				EdgePattern nextOutgoing = nextEdges.next();
				NodePattern nextTarget = nextOutgoing.getTarget();

				// Only non-cyclic paths:
				if (!path.contains(nextTarget) 
						&& isValidOutgoingEdge(nextOutgoing)
						&& isValidNode(nextTarget)) {

					path.segments.add(nextOutgoing);

					path.position = nextTarget;
					path.nodes.add(nextTarget);
					path.traceOutgoings.add(nextTarget.getOutgoings().iterator());

					isNewPath = true;
				}
			} else {

				// Still backtracking or new path?
				if (isNewPath) {
					isNewPath = false;
					break;
				}

				// All edges processed...
				path.traceOutgoings.pop();

				// Step back:
				if (path.position != path.start) {

					// Update path:
					EdgePattern lastEdge = path.segments.pop();

					// Update position:
					if (lastEdge.getTarget() == path.position) {
						// Last -> Position:
						path.nodes.remove(path.position);
						path.position = lastEdge.getSource();
					} else {
						// Last <- Position
						path.nodes.remove(path.position);
						path.position = lastEdge.getTarget();
					}

					// Update initial base path:
					if (path.segments.size() < path.baseSegmentIndex) {
						path.baseSegmentIndex = path.segments.size();
						path.basePosition = path.position;
					}

					assert (path.traceOutgoings.size() == path.nodes.size());
					assert ((path.position == path.start) 
							|| ((path.segments.peek().getSource() == path.position) 
									|| (path.segments.peek().getTarget() == path.position)));
				}
			}
		}

		return path;
	}

	protected boolean isValidNode(NodePattern node) {
		return true;
	}

	protected boolean isValidIncomingEdge(EdgePattern incoming) {
		return true;
	}

	protected boolean isValidOutgoingEdge(EdgePattern outgoing) {
		return true;
	}

	public NodePattern getStart() {
		return path.start;
	}
}
