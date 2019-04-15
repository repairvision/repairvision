package org.sidiff.common.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * A topological sorter sorts a collection according to a function
 * which returns, for each element, which elements proceed/succeed it.
 * @author Robert Müller
 * @param <T> the type of the elements
 */
public class TopologicalSorter<T> {

	private Function<T,Stream<T>> topologyFunction;
	private boolean proceeding;

	private Set<T> vertices; // the remaining vertices to visit
	private LinkedList<T> sorted; // the sorted list
	private Set<T> sortedSet; // set of sorted vertices for more efficient contains operation
	private Set<T> visited; // vertices visited, to detect cycles

	/**
	 * Creates a new sorter.
	 * @param vertices the vertices to sort
	 * @param topologyFunction function that returns the context element's proceeding/succeeding elements
	 * @param proceeding <code>true</code>/<code>false</code> whether the function returns the proceeding/succeeding elements
	 */
	public TopologicalSorter(Collection<T> vertices, Function<T,Stream<T>> topologyFunction, boolean proceeding) {
		this.vertices = new LinkedHashSet<>(vertices);
		this.topologyFunction = Objects.requireNonNull(topologyFunction);
		this.proceeding = proceeding;
	}

	public List<T> sort() {
		this.sorted = new LinkedList<T>();
		this.visited = new HashSet<>();
		this.sortedSet = new HashSet<>();
		while(!vertices.isEmpty()) {
			visit(vertices.stream().findAny().get());
		}
		return sorted;
	}

	protected void visit(T vertex) {
		if(visited.contains(vertex) || sortedSet.contains(vertex)) {
			return;
		}

		visited.add(vertex);
		topologyFunction.apply(vertex).forEachOrdered(this::visit);
		visited.remove(vertex);

		vertices.remove(vertex);
		if(proceeding) {
			sorted.add(vertex);
		} else {
			sorted.push(vertex);
		}
		sortedSet.add(vertex);
	}
}