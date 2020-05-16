package org.sidiff.revision.compare.matching.impl;

import org.sidiff.revision.compare.matching.Candidate;

/**
 * A linked node implementation of {@link Candidate}.
 * 
 * @author Manuel Ohrndorf
 */
public class CandidateImpl implements Candidate {

	protected CandidateImpl previous;
	
	protected CandidateImpl next;
	
	protected Object element;

	public Candidate getPrevious() {
		return previous;
	}

	public void setPrevious(CandidateImpl previous) {
		this.previous = previous;
	}

	public Candidate getNext() {
		return next;
	}

	public void setNext(CandidateImpl next) {
		this.next = next;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}
}
