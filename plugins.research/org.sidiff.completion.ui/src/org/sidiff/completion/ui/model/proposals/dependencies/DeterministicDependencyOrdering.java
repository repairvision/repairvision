package org.sidiff.completion.ui.model.proposals.dependencies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DeterministicDependencyOrdering {

	public static void main(String args[]) {
		

		List<Dependency> dependenciesList = new ArrayList<>();

		// List of Dependencies

		Node c = new Node("C");
		Node a = new Node("A");
		Node x = new Node("X");
		Node b = new Node("B");
		Node d = new Node("D");

		Dependency dep3 = new Dependency(a, c);
		Dependency dep4 = new Dependency(a, b);
		Dependency dep2 = new Dependency(c, d);
		Dependency dep1 = new Dependency(x, c);

		dependenciesList.add(dep2);
		dependenciesList.add(dep4);
		dependenciesList.add(dep3);
		dependenciesList.add(dep1);

		// List of Unordered
		List<Node> unOrderedList = new ArrayList<>();
		unOrderedList.add(c);
		unOrderedList.add(a);
		unOrderedList.add(x);
		unOrderedList.add(b);
		unOrderedList.add(d);
		
		System.out.println("Input Arraylist: \n");

		for (Dependency dep : dependenciesList) {
			System.out.print(dep + "\t");
		}

		DeterministicDependencyOrdering detOrdering = new DeterministicDependencyOrdering();
		detOrdering.deterministicOrdering(unOrderedList, dependenciesList);
		
		System.out.println("Final Arraylist: \n");
		
		for (Node n : unOrderedList) {
			System.out.print(n.getName() + "\t");
		}
	}

	/**
	 * This function gets an unordered list and a list of dependencies as input and
	 * sorts the list based on Partial Ordering It finally results absolute ordering
	 * which is deterministic
	 * 
	 * @param unOrdered    : Input Unordered List
	 * @param dependencies : Input dependencies
	 */
	public void deterministicOrdering(List<Node> unOrdered, List<Dependency> dependencies) {

		Collections.sort(dependencies, new Comparator<Dependency>() {

			@Override
			public int compare(Dependency dependency1, Dependency dependency2) {
				String s1 = dependency1.getPredecessor().getName() + "->" + dependency1.getSuccessor().getName();
				String s2 = dependency2.getPredecessor().getName() + "->" + dependency2.getSuccessor().getName();

				return s1.compareTo(s2);
			}
		});

		Collections.sort(unOrdered, new Comparator<Node>() {

			@Override
			public int compare(Node node1, Node node2) {
			
				return node1.getName().compareTo(node2.getName());
			}
		});

		boolean modified = true;
		while (modified) {
			modified = false;
			for (Dependency dep : dependencies) {
				int predecessorPosition = unOrdered.indexOf(dep.getPredecessor());
				int successorPosition = unOrdered.indexOf(dep.getSuccessor());

				if (predecessorPosition > successorPosition) {
					unOrdered.remove(dep.getPredecessor());
					unOrdered.add(successorPosition, dep.getPredecessor());
					modified = true;
				}
			}
		}

	}

}
