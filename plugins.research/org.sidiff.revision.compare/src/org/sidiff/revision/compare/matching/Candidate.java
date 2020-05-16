package org.sidiff.revision.compare.matching;

/**
 * Represents a candidate in a {@link CandidateList}
 * 
 * @author Manuel Ohrndorf
 */
public interface Candidate {

	/**
	 * @return The element represented by this candidate.
	 */
	Object getElement();

	/**
	 * @param element The element represented by this candidate.
	 */
	void setElement(Object element);
}
