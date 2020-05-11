package org.sidiff.revision.editrules.generation.decompose.dependencies;

public class Dependency<T> {

	private DependencyNode<T> predecessor;

	private DependencyNode<T> successor;
	
	public Dependency() {
	}

	public Dependency(DependencyNode<T> predecessor, DependencyNode<T> successor) {
		this.predecessor = predecessor;
		this.successor = successor;
	}

	public DependencyNode<T> getPredecessor() {
		return predecessor;
	}
	public void setPredecessor(DependencyNode<T> predecessor) {
		this.predecessor = predecessor;
	}

	public DependencyNode<T> getSuccessor() {
		return successor;
	}
	public void setSuccessor(DependencyNode<T> successor) {
		this.successor = successor;
	}

	@Override
	public String toString() {
		return predecessor.getName()+ "->" + successor.getName();
	}

}
