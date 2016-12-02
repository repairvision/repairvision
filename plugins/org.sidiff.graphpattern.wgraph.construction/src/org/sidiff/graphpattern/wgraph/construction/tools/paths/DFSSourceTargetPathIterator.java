package org.sidiff.graphpattern.wgraph.construction.tools.paths;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.graphpattern.wgraph.construction.tools.paths.DFSSourceTargetPathIterator.DFSPath;

/**
 * Iterates through all simple paths (non-cyclic) from a start (to an target) node by DFS.
 * 
 * @author Manuel Ohrndorf
 */
public class DFSSourceTargetPathIterator implements Iterator<DFSPath> {

	protected DFSPath path;

	public class DFSPath {

		protected NodePattern basePosition;

		protected int baseSegmentIndex = 0;

		protected Stack<EdgePattern> segments = new Stack<>();

		protected Set<NodePattern> nodes = new HashSet<>();

		protected Stack<Iterator<EdgePattern>> traceOutgoings = new Stack<>();

		protected Stack<Iterator<EdgePattern>> traceIncomings = new Stack<>();

		protected NodePattern position;

		protected NodePattern start;

		protected NodePattern target;

		public DFSPath(NodePattern start, NodePattern target) {
			this.position = start;
			this.start = start;
			this.target = target;

			this.basePosition = start;

			// Initialize iteration:
			traceOutgoings.add(start.getOutgoings().iterator());
			traceIncomings.add(start.getIncomings().iterator());

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

		public NodePattern getPathTarget() {
			return target;
		}

		public boolean contains(NodePattern node) {
			return nodes.contains(node);
		}
	}

	public DFSSourceTargetPathIterator(NodePattern start, NodePattern target) {
		this.path = new DFSPath(start, target);
	}

	public DFSSourceTargetPathIterator(NodePattern start) {
		this(start, null);
	}

	@Override
	public boolean hasNext() {
		return !path.traceIncomings.isEmpty();
	}

	@Override
	public DFSPath next() {

		// Remove last path segment to the target node:
		if ((path.target != null) && !path.segments.isEmpty()) {

			assert ((path.segments.peek().getSource() == path.target) 
					|| (path.segments.peek().getTarget() == path.target));

			path.segments.pop();
		}

		// Set initial base path:
		path.baseSegmentIndex = path.segments.size();
		path.basePosition = path.position;

		// Set to true if a transition was possible!
		boolean isNewPath = false;

		while (!path.traceIncomings.isEmpty()) {
			Iterator<EdgePattern> nextEdges = path.traceOutgoings.peek();

			// Iterate outgoings (first):
			if (nextEdges.hasNext()) {
				EdgePattern nextOutgoing = nextEdges.next();
				NodePattern nextTarget = nextOutgoing.getTarget();

				// Only non-cyclic paths:
				if (!path.contains(nextTarget) 
						&& isValidOutgoingEdge(nextOutgoing)
						&& isValidNode(nextTarget)) {

					path.segments.add(nextOutgoing);
					isNewPath = true;

					// Target reached?
					if (nextTarget == path.target) {
						break;
					} else {
						path.position = nextTarget;
						path.nodes.add(nextTarget);
						path.traceOutgoings.add(nextTarget.getOutgoings().iterator());
						path.traceIncomings.add(nextTarget.getIncomings().iterator());
					}
				}
			} else {
				nextEdges = path.traceIncomings.peek();

				if (nextEdges.hasNext()) {
					EdgePattern nextIncoming = nextEdges.next();
					NodePattern nextTarget = nextIncoming.getSource();

					// Only new (non-opposite) non-cyclic paths:
					if ((nextIncoming.getOpposite() == null) 
							&& !path.contains(nextTarget)
							&& isValidIncomingEdge(nextIncoming)
							&& isValidNode(nextTarget)) {

						path.segments.add(nextIncoming);
						isNewPath = true;

						// Target reached?
						if (nextTarget == path.target) {
							break;
						} else {
							path.position = nextTarget;
							path.nodes.add(nextTarget);
							path.traceOutgoings.add(nextTarget.getOutgoings().iterator());
							path.traceIncomings.add(nextTarget.getIncomings().iterator());
						}
					}
				} else {

					// Still backtracking or new path?
					if (isNewPath) {
						isNewPath = false;

						/// No target -> all paths:
						if (path.target == null) {
							break;
						}
					}

					// All edges processed...
					path.traceOutgoings.pop();
					path.traceIncomings.pop();

					assert (path.traceIncomings.size() == path.traceOutgoings.size());

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

						assert ((path.traceIncomings.size() == path.nodes.size()) 
								&& (path.traceOutgoings.size() == path.nodes.size()));
						assert ((path.position == path.start) 
								|| ((path.segments.peek().getSource() == path.position) 
										|| (path.segments.peek().getTarget() == path.position)));
					}
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

	public NodePattern getTarget() {
		return path.target;
	}
}