package org.sidiff.common.lcs;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to calculate the length of the longest common subsequence of two sequences
 */
public class LCSUtil {

	/**
	 * Berechnet die laengste gemeinsame Subsequenz zwischen den Objekten a und b. Der Parameter util stellt eine Hilfsklasse zur Verfuegung, welche die Methoden int size(Object seq) und Object get(Object seq, int index) fuer die Parameter a und b
	 * implementiert Algorithmus nach "The Greedy LCS/SES Algorithm" aus "An O(ND) Difference Algorithm and Ist Variations" von Eugene W. Myers, Seite 6.
	 * 
	 * @param sequenceA
	 *            The sequence A
	 * @param sequenceB
	 *            The sequence B
	 * @param accessor
	 *            The accessor class containing methods to retrieve and compare elements
	 * @return The calculated lcs value if exists; Otherwise -1.
	 */
	public static <T, X> int compareSequenceByEqualSubsequence(T sequenceA, T sequenceB, LCSSequenceAccessorEqualSubsequence<T, X> accessor) {
		int n = accessor.size(sequenceA);
		int m = accessor.size(sequenceB);
		int max = m + n;

		// Enthält den jeweiligen am weitesten reichenden Endpunkt für die Diagonale
		// und wird dynamisch berechnet
		int[] v = new int[2 * max + 1];
		v[1 + max] = 0;

		// Greedy Algorithmus, anfangend bei einem 0-Pfad wird der kürzeste Weg gesucht
		for (int d = 0; d <= max; d++) {
			// Ein d-Pfad kann nur ueber Diagonalen von -d, -d+2... d-2, d laufen
			for (int k = -d; k <= d; k = k + 2) {
				int x;
				int y;
				if (k == -d || (k != d && v[(k - 1) + max] < v[k + 1 + max])) {
					// nach unten gehen
					x = v[k + 1 + max];
				} else {
					// nach rechts gehen
					x = v[k - 1 + max] + 1;
				}
				// y lässt sich aus x und k berechnen
				y = x - k;
				// Die Diagonale wir weitmöglichst durchlaufen (wird auch Snake genannt)
				while (x < n && y < m && accessor.areEqual(accessor.get(sequenceA, x), accessor.get(sequenceB, y))) {
					x = x + 1;
					y = y + 1;
				}
				// v aktualisieren
				v[k + max] = x;

				// Ziel erreicht??
				if (x >= n && y >= m) {
					int lcs = (m + n - d) / 2;
					return lcs;
				}
			}
		}
		return -1;
	}

	/**
	 * Works like <code>compareSequenceByEqualSubsequence</code> with the difference that not the equality of the longest subsequence is necessary. In this case a similarity about the given threshold is sufficient.
	 * 
	 * @param sequenceA
	 *            The sequence A
	 * @param sequenceB
	 *            The sequence B
	 * @param accessor
	 *            The accessor class containing methods to retrieve and compare elements
	 * @param threshold
	 *            The threshold indicating the necessary similarity which to elements must have to be detected as adequate equal
	 * @return The sequences' similarity if similarity detected; Otherwise -1.
	 */
	@SuppressWarnings("unchecked")
	public static float compareSequenceBySimilarSubsequence(Object sequenceA, Object sequenceB, LCSSequenceAccessorSimilarSubsequence accessor, float threshold) {
		int n = accessor.size(sequenceA);
		int m = accessor.size(sequenceB);
		int max = m + n;
		ArrayList<Object>[] commonSubSeq = new ArrayList[2 * max + 1];
		for (int i = 0; i < commonSubSeq.length; i++) {
			commonSubSeq[i] = new ArrayList<Object>();
		}
		// enthält den jeweiligen am weitesten reichenden Endpunkt für die Diagonale
		// und wird dynamisch berechnet
		int[] v = new int[2 * max + 1];
		v[1 + max] = 0;
		// Greedy Algorithmus, anfangend bei einem 0-Pfad wird der kuerzeste Weg gesucht
		for (int d = 0; d <= max; d++) {
			// Ein d-Pfad kann nur ueber Diagonalen von -d, -d+2... d-2, d
			// laufen
			for (int k = -d; k <= d; k = k + 2) {
				int oldDiag = 0;
				int x;
				int y;
				if (k == -d || (k != d && v[(k - 1) + max] < v[k + 1 + max])) {
					// nach unten gehen
					oldDiag = k + 1;
					x = v[k + 1 + max];
				} else {
					// nach rechts gehen
					oldDiag = k - 1;
					x = v[k - 1 + max] + 1;
				}
				// y lässt sich aus x und k berechnen
				y = x - k;
				// Die Diagonale wir weitmöglichst durchlaufen (wird auch Snake genannt)
				ArrayList<Object> snake = new ArrayList<Object>();
				while (x < n && y < m && accessor.getSimilarity(accessor.get(sequenceA, x), accessor.get(sequenceB, y)) >= threshold) {
					snake.add(accessor.get(sequenceA, x));
					snake.add(accessor.get(sequenceB, y));
					x = x + 1;
					y = y + 1;
				}
				// v aktualisieren
				v[k + max] = x;

				// in commonSubSeq jeweils die Diagonalenpunkte merken,
				// um später die LCS zu bestimmen
				commonSubSeq[k + max].clear();
				commonSubSeq[k + max].addAll(commonSubSeq[oldDiag + max]);
				commonSubSeq[k + max].addAll(snake);

				// Ziel erreicht??
				if (x >= n && y >= m) {

					float lcs = 0;
					Object[] objSequence = commonSubSeq[k + max].toArray();
					for (int i = 0; i < objSequence.length; i += 2) {
						lcs += accessor.getSimilarity(objSequence[i], objSequence[i + 1]);
					}

					return lcs;
				}

			}
		}
		return -1;
	}

	/**
	 * Test method
	 * @param args
	 */
	@Deprecated
	public static void main(String[] args) {
		String[] stringsA = { "A", "A", "A" };
		String[] stringsB = { "A", "A", "a" };

		List<String> listA = new ArrayList<String>();
		List<String> listB = new ArrayList<String>();
		for (int i = 0; i < stringsA.length; i++) {
			listA.add(stringsA[i]);
		}
		for (int i = 0; i < stringsB.length; i++) {
			listB.add(stringsB[i]);
		}

		float lcs_1 = compareSequenceByEqualSubsequence(listA, listB, new LCSSequenceAccessorEqualSubsequence<List<String>, String>() {
			@Override
			public boolean areEqual(String objectA, String objectB) {
				return objectA.equals(objectB);
			}

			@Override
			public String get(List<String> sequence, int index) {
				return (String) sequence.get(index);
			}

			@Override
			public int size(List<String> sequence) {
				return sequence.size();
			}
		});

		float lcs_2 = 0.0f;
		for (int i = 0; i < 10000000; i++) {
			lcs_2 = compareSequenceBySimilarSubsequence(listA, listB, new LCSSequenceAccessorSimilarSubsequence<List<String>, String>() {

				@Override
				public String get(List<String> sequence, int index) {
					return (String) sequence.get(index);
				}

				@Override
				public int size(List<String> sequence) {
					return sequence.size();
				}

				@Override
				public float getSimilarity(String itemA, String itemB) {
					if (itemA.equals(itemB)) {
						return 1.0f;
					} else if (itemA.equalsIgnoreCase(itemB)) {
						return 0.8f;
					} else {
						return 0.0f;
					}
				}
			}, 0.5f);
		}

		System.out.println(lcs_1);
		System.out.println(lcs_2);
	}
}