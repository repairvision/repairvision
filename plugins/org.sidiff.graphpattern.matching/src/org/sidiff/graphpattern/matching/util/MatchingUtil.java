package org.sidiff.graphpattern.matching.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.sidiff.consistency.graphpattern.EObjectList;
import org.sidiff.consistency.graphpattern.GraphpatternFactory;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.graphpattern.matching.IMatchGenerator;
import org.sidiff.graphpattern.matching.IMatching;

/**
 * Convenience functions for the generated matches.
 * 
 * @author Manuel Ohrndorf
 */
public class MatchingUtil {

	/**
	 * Represents all empty matches.
	 */
	public static final EObject EMPTY_MATCH = new EObjectImpl() {

		public String toString() {
			return "empty match";
		}

	};

	/**
	 * @return A list matches for each node of the graph (index of
	 *         {@link IMatchGenerator#getGraphPattern()}).
	 * @see MatchingUtil#EMPTY_MATCH
	 */
	public static EObjectList createMatching(IMatchGenerator<? extends IMatching> matchGenerator, IMatching matching) {
		EObjectList graphPatternMatching = GraphpatternFactory.eINSTANCE.createEObjectList();
		int count = 0;
		
		for (NodePattern node : matchGenerator.getGraphPattern()) {
			EObjectList nodeMatching = GraphpatternFactory.eINSTANCE.createEObjectList();
			nodeMatching.setLabel("Node Matching");
			++count;

			matching.getMatch(node).forEachRemaining(match -> {
				if (match != null) {
					nodeMatching.getContent().add(match);
				}
			});

			if (nodeMatching.getContent().size() == 1) {
				graphPatternMatching.getContent().add(nodeMatching.getContent().get(0));
			}

			else if (nodeMatching.getContent().isEmpty()) {
				graphPatternMatching.getContent().add(EMPTY_MATCH);
				--count;
			}

			else {
				graphPatternMatching.getContent().add(nodeMatching);
			}
		}

		graphPatternMatching.setLabel("Matching [" + count + "/" + matchGenerator.getGraphPattern().size() + "]");
		return graphPatternMatching;
	}
}
