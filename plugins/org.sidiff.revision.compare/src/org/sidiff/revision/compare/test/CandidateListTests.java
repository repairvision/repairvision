package org.sidiff.revision.compare.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;
import org.sidiff.revision.compare.matching.Candidate;
import org.sidiff.revision.compare.matching.CandidateList;
import org.sidiff.revision.compare.matching.impl.CandidateListImpl;
import org.sidiff.revision.compare.matching.impl.CandidateImpl;
import org.sidiff.revision.configuration.Factory;

/**
 * Unit tests for the comparable matching plugin.
 * 
 * @author Manuel Ohrndorf
 */
public class CandidateListTests {
	
	public Factory<CandidateList> factoryCandidateList;

	public CandidateListTests() {
		this.factoryCandidateList = () -> new CandidateListImpl(() -> new CandidateImpl());
	}
	
	@Test
	public void testEmptyCandidateList() {
		CandidateList candidateList = factoryCandidateList.create();
		assertTrue(candidateList.isEmpty());
		assertEquals(0, candidateList.size());
		assertFalse(candidateList.iterator().hasNext());
	}
	
	@Test
	public void testAddToCandidateList() {
		CandidateList candidateList = factoryCandidateList.create();
		
		String[] elements = {"A", "B", "C", "D", "E", "F"};
		
		candidateList.add(elements[0]);
		candidateList.add(elements[1]);
		candidateList.add(elements[2]);
		candidateList.add(elements[3]);
		candidateList.add(elements[4]);
		candidateList.add(elements[5]);
		
		assertFalse(candidateList.isEmpty());
		assertEquals(6, candidateList.size());
		
		int i = 0;
		
		for (Candidate candidate : candidateList) {
			assertEquals(elements[i], candidate.getElement());
			i++;
		}
		
		assertEquals(6, i);
	}
	
	@Test
	public void testAddBeforeToCandidateList() {
		CandidateList candidateList = factoryCandidateList.create();
		
		String[] elements = {"A", "B", "C", "D", "E", "F"};
		
		// add:
		// A
		Candidate element1 = candidateList.add(elements[1]);	// B
		// C
		// D
		Candidate element4 = candidateList.add(elements[4]);	// E
		candidateList.add(elements[5]);							// F
		
		// add before:
		Candidate element3 = candidateList.addBefore(elements[3], element4);	// D before E
		candidateList.addBefore(elements[2], element3);							// C before D
		candidateList.addBefore(elements[0], element1);							// A before B
		
		assertFalse(candidateList.isEmpty());
		assertEquals(6, candidateList.size());
		
		int i = 0;
		
		for (Candidate candidate : candidateList) {
			assertEquals(elements[i], candidate.getElement());
			i++;
		}
	}
	
	@Test
	public void testRemoveAtEndCandidateList() {
		CandidateList candidateList = factoryCandidateList.create();
		
		String[] elements = {"A", "B", "C", "D", "E", "F"};
		
		candidateList.add(elements[0]);
		candidateList.add(elements[1]);
		candidateList.add(elements[2]);	// remove
		candidateList.add(elements[3]);	// ...
		candidateList.add(elements[4]);	// ...
		candidateList.add(elements[5]); // ...
		
		assertFalse(candidateList.isEmpty());
		assertEquals(6, candidateList.size());
		
		// remove:
		int i = 0;
		
		for (Iterator<Candidate> iterator = candidateList.iterator(); iterator.hasNext();) {
			Candidate candidate = iterator.next();
			assertNotNull(candidate);
			
			if (i >= 2) {
				iterator.remove();
			}
			
			i++;
		}
		
		// check:
		assertFalse(candidateList.isEmpty());
		assertEquals(2, candidateList.size());
		
		i = 0;
		
		for (Candidate candidate : candidateList) {
			assertEquals(elements[i], candidate.getElement());
			i++;
		}
	}
	
	@Test
	public void testRemoveAtBeginCandidateList() {
		CandidateList candidateList = factoryCandidateList.create();
		
		String[] elements = {"A", "B", "C", "D", "E", "F"};
		
		candidateList.add(elements[0]); // remove
		candidateList.add(elements[1]); // ...
		candidateList.add(elements[2]);	
		candidateList.add(elements[3]);
		candidateList.add(elements[4]);
		candidateList.add(elements[5]);
		
		assertFalse(candidateList.isEmpty());
		assertEquals(6, candidateList.size());
		
		// remove:
		int i = 0;
		
		for (Iterator<Candidate> iterator = candidateList.iterator(); iterator.hasNext();) {
			Candidate candidate = iterator.next();
			assertNotNull(candidate);
			
			if ((i >= 0) && (i <= 1)) {
				iterator.remove();
			}
			
			i++;
		}
		
		// check:
		assertFalse(candidateList.isEmpty());
		assertEquals(4, candidateList.size());
		
		i = 2;
		
		for (Candidate candidate : candidateList) {
			assertEquals(elements[i], candidate.getElement());
			i++;
		}
	}
	
	@Test
	public void testRemoveAllCandidateList() {
		CandidateList candidateList = factoryCandidateList.create();
		
		String[] elements = {"A", "B", "C", "D", "E", "F"};
		
		candidateList.add(elements[0]);
		candidateList.add(elements[1]);
		candidateList.add(elements[2]);	
		candidateList.add(elements[3]);
		candidateList.add(elements[4]);
		candidateList.add(elements[5]);
		
		assertFalse(candidateList.isEmpty());
		assertEquals(6, candidateList.size());
		
		// remove:
		for (Iterator<Candidate> iterator = candidateList.iterator(); iterator.hasNext();) {
			Candidate candidate = iterator.next();
			assertNotNull(candidate);
			iterator.remove();
		}
		
		// check:
		assertTrue(candidateList.isEmpty());
		assertEquals(0, candidateList.size());
		assertFalse(candidateList.iterator().hasNext());
		
		// add again:
		candidateList.add(elements[0]);
		candidateList.add(elements[1]);
		candidateList.add(elements[2]);
		
		// check:
		assertFalse(candidateList.isEmpty());
		assertEquals(3, candidateList.size());

		int i = 0;

		for (Candidate candidate : candidateList) {
			assertEquals(elements[i], candidate.getElement());
			i++;
		}
	}
}
