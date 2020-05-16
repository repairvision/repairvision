package org.sidiff.revision.compare.matching;

import java.util.Iterator;

import org.sidiff.revision.compare.MatchExists;

/**
 * A list of candidates that are unmachted.
 * 
 * @author Manuel Ohrndorf
 */
public interface CandidateList extends Iterable<Candidate> {

	/**
	 * @return The number of candidates in this list.
	 */
	int size();

	/**
	 * @return {@code true} if this collection contains no elements
	 */
	boolean isEmpty();

	/**
	 * @param candidate A element as candidate.
	 * @return The element wrapped as candidate.
	 */
	Candidate add(Object element);

	/**
	 * @param candidate A candidate representing an element.
	 * @return The element wrapped as candidate.
	 */
	Candidate add(Candidate candidate);

	/**
	 * @param element   A element as candidate (before).
	 * @param contained A contained element as candidate (after).
	 * @return The element wrapped as candidate.
	 */
	Candidate addBefore(Object element, Candidate contained);

	/**
	 * @param newCandidate A candidate representing an element.
	 * @param contained    A contained element as candidate (after).
	 * @return The element wrapped as candidate.
	 */
	Candidate addBefore(Candidate newCandidate, Candidate contained);

	/**
	 * @param candidate Element to be removed from this collection, if present.
	 * @return {@code true} if an element was removed.
	 */
	boolean remove(Candidate candidate);

	/**
	 * Iterator that only return unmatched candidates.
	 * 
	 * @param match       To check for already matched elements.
	 * @param synchronize {@code true} to remove already matched elements during the
	 *                    iteration on the candidate list.
	 * @return An iterator over unmatched candidates.
	 */
	Iterator<Candidate> iterator(MatchExists match, boolean synchronize);
}
