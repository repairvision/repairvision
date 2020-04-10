package org.sidiff.revision.editrules.generation.decompose.dependencies;

public class DependencyNode<T> {

    private T target;

	public DependencyNode(T target) {
		this.target = target;
	}

	public String getName() {
		return target.toString();
	}
	
	public T getTarget() {
		return target;
	}

	@Override
	public String toString() {
		return getName();
	}
}
