package org.sidiff.revision.compare.matching.impl;

import java.util.Iterator;

import org.sidiff.revision.compare.MatchExists;
import org.sidiff.revision.compare.matching.Candidate;
import org.sidiff.revision.compare.matching.CandidateList;
import org.sidiff.revision.configuration.Factory;

/**
 * A double linked ({@link CandidateImpl}) implementation of
 * {@link CandidateList}.
 * 
 * @author Manuel Ohrndorf
 */
public class CandidateListImpl implements CandidateList {

	/**
	 * The candidate wrapper factory.
	 */
	protected Factory<CandidateImpl> factoryCandidate;

	protected int size = 0;

	protected CandidateImpl first;

	protected CandidateImpl last;

	/**
	 * @param factoryCandidate {@link #factoryCandidate}
	 */
	public CandidateListImpl(Factory<CandidateImpl> factoryCandidate) {
		this.factoryCandidate = factoryCandidate;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Candidate add(Candidate candidate) {
		CandidateImpl candidateLinked = (CandidateImpl) candidate;

		if (last == null) {
			assert (first == null);

			candidateLinked.previous = null;
			candidateLinked.next = null;

			last = candidateLinked;
			first = candidateLinked;
		} else {
			candidateLinked.previous = last;
			candidateLinked.next = null;

			last.next = candidateLinked;
			last = candidateLinked;
		}

		++size;
		return candidateLinked;
	}

	@Override
	public Candidate add(Object element) {
		CandidateImpl elementLinked = factoryCandidate.create();
		elementLinked.element = element;
		return add(elementLinked);
	}

	@Override
	public Candidate addBefore(Candidate newCandidate, Candidate contained) {
		CandidateImpl containedLinked = (CandidateImpl) contained;
		CandidateImpl newCandidateLinked = (CandidateImpl) newCandidate;

		if (containedLinked == first) {
			newCandidateLinked.previous = null;
			newCandidateLinked.next = first;

			containedLinked.previous = newCandidateLinked;

			first = newCandidateLinked;
		} else {
			newCandidateLinked.next = containedLinked;
			newCandidateLinked.previous = containedLinked.previous;

			containedLinked.previous.next = newCandidateLinked;
			containedLinked.previous = newCandidateLinked;
		}

		++size;
		return newCandidateLinked;
	}

	@Override
	public Candidate addBefore(Object element, Candidate contained) {
		CandidateImpl elementLinked = factoryCandidate.create();
		elementLinked.element = element;
		return addBefore(elementLinked, contained);
	}

	@Override
	public boolean remove(Candidate candidate) {
		CandidateImpl candidateLinked = (CandidateImpl) candidate;

		if (first == candidateLinked) {
			first = candidateLinked.next;
		} else {
			candidateLinked.previous.next = candidateLinked.next;
		}

		if (last == candidateLinked) {
			last = candidateLinked.previous;
		} else {
			candidateLinked.next.previous = candidateLinked.previous;
		}

		--size;
		return true;
	}

	protected class CandidateIterator implements Iterator<Candidate> {

		CandidateImpl pointer;

		@Override
		public Candidate next() {
			if (pointer != null) {
				pointer = pointer.next;
			} else {
				pointer = first;
			}
			return pointer;
		}

		@Override
		public boolean hasNext() {
			if (pointer != null) {
				return pointer.next != null;
			} else {
				return (first != null);
			}
		}

		@Override
		public void remove() {
			pointer = pointer.previous;

			if (pointer != null) {
				CandidateListImpl.this.remove(pointer.next);
			} else {
				CandidateListImpl.this.remove(first);
			}
		}
	}

	@Override
	public Iterator<Candidate> iterator() {
		return new CandidateIterator();
	}

	protected class SynchronizingCandidateIterator extends CandidateIterator {

		MatchExists match;

		boolean synchronize;

		public SynchronizingCandidateIterator(MatchExists match, boolean synchronize) {
			this.match = match;
			this.synchronize = synchronize;
		}

		@Override
		public boolean hasNext() {
			while (super.hasNext()) {
				if (match.exists(pointer.getElement())) {
					if (synchronize) {
						remove();
					} else {
						next();
					}
				} else {
					return true;
				}
			}
			return false;
		}
	}

	@Override
	public Iterator<Candidate> iterator(MatchExists match, boolean synchronize) {
		return new SynchronizingCandidateIterator(match, synchronize);
	}
}
