package org.sidiff.revision.editrules.generation.decompose.dependencies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DependencyOrdering<T> {

	/**
	 * This function gets an unordered list and a list of dependencies as input and
	 * sorts the list based on partial ordering It finally results absolute ordering
	 * which is deterministic
	 * 
	 * @param unordered    The unordered list to be sorted by the dependencies.
	 * @param dependencies The dependencies (of the partial ordering) between the
	 *                     nodes in the ordered list.
	 */
	public void deterministicOrdering(List<DependencyNode<T>> unordered, List<Dependency<T>> dependencies) {

		Collections.sort(dependencies, new Comparator<Dependency<T>>() {

			@Override
			public int compare(Dependency<T> dependency1, Dependency<T> dependency2) {
				String s1 = dependency1.getPredecessor().getName() + "->" + dependency1.getSuccessor().getName();
				String s2 = dependency2.getPredecessor().getName() + "->" + dependency2.getSuccessor().getName();

				return s1.compareTo(s2);
			}
		});

		Collections.sort(unordered, new Comparator<DependencyNode<T>>() {

			@Override
			public int compare(DependencyNode<T> node1, DependencyNode<T> node2) {
				return node1.getName().compareTo(node2.getName());
			}
		});

		boolean modified = true;
		
		while (modified) {
			modified = false;
			
			for (Dependency<T> dep : dependencies) {
				int predecessorPosition = unordered.indexOf(dep.getPredecessor());
				int successorPosition = unordered.indexOf(dep.getSuccessor());

				if (predecessorPosition > successorPosition) {
					unordered.remove(dep.getPredecessor());
					unordered.add(successorPosition, dep.getPredecessor());
					modified = true;
				}
			}
		}
	}

	public static void main(String args[]) {
		List<Dependency<String>> dependenciesList = new ArrayList<>();
	
		// List of Dependencies
		DependencyNode<String> c = new DependencyNode<>("C");
		DependencyNode<String> a = new DependencyNode<>("A");
		DependencyNode<String> x = new DependencyNode<>("X");
		DependencyNode<String> b = new DependencyNode<>("B");
		DependencyNode<String> d = new DependencyNode<>("D");
	
		Dependency<String> dep3 = new Dependency<>(a, c);
		Dependency<String> dep4 = new Dependency<>(a, b);
		Dependency<String> dep2 = new Dependency<>(c, d);
		Dependency<String> dep1 = new Dependency<>(x, c);
	
		dependenciesList.add(dep2);
		dependenciesList.add(dep4);
		dependenciesList.add(dep3);
		dependenciesList.add(dep1);
	
		// List of Unordered
		List<DependencyNode<String>> unorderedList = new ArrayList<>();
		unorderedList.add(c);
		unorderedList.add(a);
		unorderedList.add(x);
		unorderedList.add(b);
		unorderedList.add(d);
		
		new DependencyOrdering<String>().printDeterministicOrdering(unorderedList, dependenciesList);
	}

	public void printDeterministicOrdering(List<DependencyNode<T>> unorderedList, List<Dependency<T>> dependenciesList) {
		System.out.println("Dependency List:\n");
		printDependencyList(dependenciesList);
		
		System.out.println("\nInput List:\n");
		printDependencyNodes(unorderedList);
	
		DependencyOrdering<T> detOrdering = new DependencyOrdering<>();
		detOrdering.deterministicOrdering(unorderedList, dependenciesList);
		
		System.out.println("\nSorted List:\n");
		printDependencyNodes(unorderedList);
	}

	public void printDependencyNodes(List<DependencyNode<T>> unorderedList) {
		for (DependencyNode<T> n : unorderedList) {
			System.out.print(n.getName());
			
			if (n != unorderedList.get(unorderedList.size() - 1)) {
				System.out.print(" -> ");
			}
		}
		System.out.println();
	}

	public void printDependencyList(List<Dependency<T>> dependenciesList) {
		for (Dependency<T> dep : dependenciesList) {
			System.out.print(dep + "\n");
		}
	}

}
