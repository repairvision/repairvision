package org.sidiff.difference.symmetric.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.sidiff.common.collections.CollectionView;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;

/**
 * Some utility-functions for analyzing (lifted) model differences.
 */
public class DifferenceAnalysisUtil {

	/**
	 * Calculates the difference of contained atomic changes in all semantic
	 * change sets (SCS) in A to all SCS in B.
	 * 
	 * @param changeSetsA
	 *            the SCS collection A.
	 * @param changeSetsB
	 *            the SCS collection B.
	 * @return (atomic changes in A) - (atomic changes in B) for A is bigger
	 *         than B OR (atomic changes in B) - (atomic changes in A) for B is
	 *         bigger than A.
	 */
	public static Set<Change> getRemainingChanges(Collection<SemanticChangeSet> changeSetsA,
			Collection<SemanticChangeSet> changeSetsB) {
		Set<Change> aChanges = new HashSet<Change>();
		Set<Change> bChanges = new HashSet<Change>();

		// Collect all atomic changes of the semantic change sets
		for (SemanticChangeSet csA : changeSetsA) {
			aChanges.addAll(csA.getChanges());
		}

		for (SemanticChangeSet csB : changeSetsB) {
			bChanges.addAll(csB.getChanges());
		}

		// Return (bigger set - smaller set)
		if (aChanges.size() > bChanges.size()) {
			aChanges.removeAll(bChanges);
			return aChanges;
		} else {
			bChanges.removeAll(aChanges);
			return bChanges;
		}
	}

	/**
	 * Returns all atomic changes which are not covered by semantic change sets.
	 * 
	 * @param difference
	 *            the difference containing atomic changes and semantic change
	 *            sets.
	 * @return all atomic changes which are not covered by semantic change sets.
	 */
	public static List<Change> getRemainingChanges(SymmetricDifference difference) {		
		Collection<SemanticChangeSet> allSCSs = getAllSemanticChangeSets(difference);
		List<Change> res = new LinkedList<Change>(difference.getChanges());
		for (Iterator<Change> iterator = res.iterator(); iterator.hasNext();) {
			Change change = iterator.next();
			for (SemanticChangeSet scs : allSCSs) {
				if (scs.getChanges().contains(change) && difference.getChangeSets().contains(scs)) {
					iterator.remove();
					break;
				}
			}
		}

		return res;
	}

	/**
	 * Calculates the difference of contained atomic changes in the difference
	 * to all atomic changes in B.
	 * 
	 * @param difference
	 *            the difference containing atomic changes.
	 * @param changeSetsB
	 *            SCS collection B.
	 * @return (atomic changes in difference) - (atomic changes in B) for
	 *         difference atomic change count is bigger than B OR (atomic
	 *         changes in B) - (atomic changes in difference) for B is bigger
	 *         than difference.
	 */
	public static Set<Change> getRemainingChanges(SymmetricDifference difference,
			Collection<SemanticChangeSet> changeSetsB) {
		Set<Change> aChanges = new HashSet<Change>();
		Set<Change> bChanges = new HashSet<Change>();

		// Collect all atomic changes of the semantic change sets
		aChanges.addAll(difference.getChanges());

		for (SemanticChangeSet csB : changeSetsB) {
			bChanges.addAll(csB.getChanges());
		}

		// Return (bigger SCS - smaller SCS)
		if (aChanges.size() > bChanges.size()) {
			aChanges.removeAll(bChanges);
			return aChanges;
		} else {
			bChanges.removeAll(aChanges);
			return bChanges;
		}
	}

	/**
	 * Tests if the given SCS is fully or partially overlaid by the SCS
	 * collection.
	 * 
	 * @param cs
	 *            the SCS that will be tested against the SCS collection.
	 * @param changeSets
	 *            the SCS collection the given SCS will be tested against.
	 * @return <code>true</code> if the SCS is (only) partially overlaid by the
	 *         SCS collection. <code>false</code> if the SCS is fully overlaid
	 *         by the SCS collection.
	 */
	public static boolean isPartiallyOverlaid(SemanticChangeSet cs, Collection<SemanticChangeSet> changeSets) {
		Set<Change> overlappingChanges = new HashSet<Change>();

		for (SemanticChangeSet csComp : changeSets) {
			overlappingChanges.addAll(getOverlappingChanges(cs, csComp));
		}

		if (overlappingChanges.containsAll(cs.getChanges())) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Compares to semantic change sets (SCS) by their containing atomic
	 * changes.
	 * 
	 * @param csA
	 *            the SCS A.
	 * @param csB
	 *            the SCS B.
	 * @return true if A and B are equal; false otherwise.
	 */
	public static boolean isEqual(SemanticChangeSet csA, SemanticChangeSet csB) {
		int i = getOverlapping(csA, csB);

		if (i == csA.getChanges().size() && (i == csB.getChanges().size())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the subset of the given set of semantic change sets (SCS)
	 * "changeSets" which are equal to the given SCS "cs". Two SCS are equal if
	 * the cover the same low-level changes. If no equal elements are found, an
	 * empty set of SCS is returned.
	 * 
	 * @param cs
	 *            the SCS that will be tested against the SCS collection.
	 * @param changeSets
	 *            the SCS collection the given SCS will be tested against.
	 * @return true if there is an equal SCS in the collection; false otherwise.
	 */
	public static Collection<SemanticChangeSet> getEqual(SemanticChangeSet cs, Collection<SemanticChangeSet> changeSets) {
		Collection<SemanticChangeSet> res = new LinkedList<SemanticChangeSet>();
		for (SemanticChangeSet csComp : changeSets) {
			if (csComp == cs) {
				continue;
			}
			if (isEqual(cs, csComp)) {
				res.add(csComp);
			}
		}
		return res;
	}

	/**
	 * Partitions a set of semantic change sets (SCS). The classification
	 * criterion for the partitioning is whether two SCS are equal. Two SCS are
	 * equal if they cover the same low-level changes.
	 * 
	 * @param changeSets
	 *            the SCS collection that is to be classified.
	 * @return A partitioning of "changeSets". Each subset contains SCS which
	 *         are equal, i.e. cover the same low-level changes.
	 */
	public static Collection<List<SemanticChangeSet>> classifyEqual(Collection<SemanticChangeSet> changeSets) {
		Collection<List<SemanticChangeSet>> res = new ArrayList<List<SemanticChangeSet>>(changeSets.size());
		for (SemanticChangeSet scs : changeSets) {

			// do we already have a bucket for this scs
			boolean bucketExisting = false;
			for (List<SemanticChangeSet> bucket : res) {
				if (isEqual(scs, bucket.get(0))) {
					bucket.add(scs);
					bucketExisting = true;
				}
			}

			if (!bucketExisting) {
				// no bucket so far
				List<SemanticChangeSet> bucket = new LinkedList<SemanticChangeSet>();
				bucket.add(scs);
				res.add(bucket);
			}
		}

		return res;
	}

	/**
	 * Search for all semantic change sets (SCS) in the collection which are
	 * overlapping with the given SCS.
	 * 
	 * @param cs
	 *            the SCS that will be tested against the collection.
	 * @param changeSets
	 *            the collection the given SCS will be tested against.
	 * @return
	 */
	public static Set<SemanticChangeSet> getOverlappingChangeSets(SemanticChangeSet cs,
			Collection<SemanticChangeSet> changeSets) {
		Set<SemanticChangeSet> overlapping = new HashSet<SemanticChangeSet>();

		for (SemanticChangeSet csComp : changeSets) {
			if ((csComp != cs) && (isOverlapping(cs, csComp))) {
				overlapping.add(csComp);
			}
		}
		return overlapping;
	}

	/**
	 * Returns all atomic changes which are in semantic change set (SCS) A and
	 * also in SCS B.
	 * 
	 * @param csA
	 *            the SCS A.
	 * @param csB
	 *            the SCS B.
	 * @return the overlapping atomic changes.
	 */
	public static Set<Change> getOverlappingChanges(SemanticChangeSet csA, SemanticChangeSet csB) {
		Set<Change> overlapping = new HashSet<Change>();

		for (Change changeA : csA.getChanges()) {
			if (csB.getChanges().contains(changeA)) {
				overlapping.add(changeA);
			}
		}
		return overlapping;
	}

	/**
	 * Counts all overlapping atomic changes of semantic change set (SCS) A and
	 * B.
	 * 
	 * @param csA
	 *            the SCS A.
	 * @param csB
	 *            the SCS B.
	 * @return the count of all overlapping atomic changes.
	 */
	public static int getOverlapping(SemanticChangeSet csA, SemanticChangeSet csB) {
		int i = 0;

		for (Change changeA : csA.getChanges()) {
			if (csB.getChanges().contains(changeA)) {
				i++;
			}
		}
		return i;
	}

	/**
	 * Indicates if semantic change set (SCS) A has overlapping atomic changes
	 * with SCS B.
	 * 
	 * @param csA
	 *            the SCS A.
	 * @param csB
	 *            the SCS B.
	 * @return true if there are overlapping atomic changes; false otherwise.
	 */
	public static boolean isOverlapping(SemanticChangeSet csA, SemanticChangeSet csB) {
		int i = getOverlapping(csA, csB);

		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Indicates if semantic change set (SCS) has overlapping atomic change.
	 * 
	 * @param scs
	 *            the set of SCS to check
	 * @return true if there are overlapping atomic changes; false otherwise.
	 */
	public static boolean hasOverlapping(Set<SemanticChangeSet> scs) {
		for (SemanticChangeSet cs : scs) {
			for (SemanticChangeSet csComp : scs) {
				if ((cs != csComp) && (isOverlapping(cs, csComp))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Indicates if semantic change set (SCS) A is partially overlapping with
	 * SCS B. That means SCS A is no subset or superset of SCS B and vice versa.
	 * 
	 * @param csA
	 *            the SCS A.
	 * @param csB
	 *            the SCS B.
	 * @return true if SCS A is partially overlapping with SCS B; false
	 *         otherwise.
	 */
	public static boolean isPartiallyOverlapping(SemanticChangeSet csA, SemanticChangeSet csB) {
		int i = getOverlapping(csA, csB);

		if ((i > 0) && (csA.getChanges().size() - i != 0) && (csB.getChanges().size() - i != 0)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Indicates if the given semantic change set (SCS) A has a partially
	 * overlapping SCS B in the collection. That means SCS A is no subset or
	 * superset of SCS B and vice versa.
	 * 
	 * @param cs
	 *            the SCS A which will be tested against the SCS collection.
	 * @param changeSets
	 *            the SCS collection SCS A will be tested against.
	 * @return true if SCS A is partially overlapping with any SCS in the
	 *         collection; false otherwise.
	 */
	public static boolean hasPartiallyOverlapping(SemanticChangeSet cs, Collection<SemanticChangeSet> changeSets) {
		for (SemanticChangeSet csComp : changeSets) {
			if ((cs != csComp) && isPartiallyOverlapping(cs, csComp)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Indicates that the inner semantic change set (SCS) is a proper (or
	 * strict) subset of the outer SCS.
	 * 
	 * @param innerCS
	 *            the inner SCS.
	 * @param outerCS
	 *            the outer SCS.
	 * @return true if the inner SCS is a proper subset of the outer SCS; false
	 *         otherwise.
	 */
	public static boolean isProperlyNested(SemanticChangeSet innerCS, SemanticChangeSet outerCS) {
		if (outerCS.getChanges().containsAll(innerCS.getChanges())
				&& innerCS.getChanges().size() != outerCS.getChanges().size()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Indicates that the given semantic change set (SCS) has a proper (or
	 * strict) subset in the given SCS collection.
	 * 
	 * @param cs
	 *            the SCS that will be tested against the SCS collection.
	 * @param changeSets
	 *            the SCS collection the given SCS will be tested against.
	 * @return true if the given SCS has a proper (or strict) subset in the
	 *         given SCS collection; false otherwise.
	 */
	public static boolean isProperlyNested(SemanticChangeSet cs, Collection<SemanticChangeSet> changeSets) {
		for (SemanticChangeSet csComp : changeSets) {
			if ((cs != csComp) && isProperlyNested(cs, csComp)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <p>
	 * Analysis the difference structure of all Semantic-Change-Sets (SCS). SCS
	 * are compared on bases of low-level changes. A pair of SCS can either be:
	 * sub and supersets of each other, partially overlapping, overlaying or not
	 * overlapping. The structure will be saved in the difference model.
	 * </p>
	 * 
	 * <p>
	 * The algorithm can also be used to update an existing structure.
	 * </p>
	 * 
	 * @param difference
	 *            the difference to analyze.
	 */
	public static void analyzeDifferenceStructure(SymmetricDifference difference) {
		Collection<SemanticChangeSet> changeSets = getAllSemanticChangeSets(difference);

		for (SemanticChangeSet cs : changeSets) {
			boolean isNotOverlapping = true;

			// Find overlapping
			for (SemanticChangeSet csComp : changeSets) {
				if ((cs != csComp) && isOverlapping(cs, csComp)) {
					isNotOverlapping = false;

					if (isEqual(cs, csComp)) {
						if (!cs.getOverlayings().contains(csComp)) {
							// Overlaying
							cs.getOverlayings().add(csComp);
						}
					} else if (isPartiallyOverlapping(cs, csComp)) {
						if (!cs.getPartiallyOverlappings().contains(csComp)) {
							// Partially
							cs.getPartiallyOverlappings().add(csComp);
						}
					} else {
						if (isProperlyNested(cs, csComp)) {
							if (!cs.getSupersets().contains(csComp)) {
								// CS-Comp is superset of CS
								cs.getSupersets().add(csComp);
							}
						} else if (isProperlyNested(csComp, cs)) {
							if (!cs.getSubsets().contains(csComp)) {
								// CS-Comp is subset of CS
								cs.getSubsets().add(csComp);
							}
						} else {
							assert false : "Set structure analysis failed!";
						}
					}
				}
			}

			// No overlapping SCS found?
			if (isNotOverlapping) {
				if (!difference.getNotOverlappings().contains(cs)) {
					difference.getNotOverlappings().add(cs);
				}
			}
		}
	}

	/**
	 * Prints the difference structure of all Semantic-Change-Sets.
	 * 
	 * @param difference
	 *            the difference of the structure.
	 * @return a String listing the structure.
	 */
	public static String printDifferenceStructure(SymmetricDifference difference) {
		StringBuffer print = new StringBuffer();

		print.append("Not Overlappings:\n\n");

		for (SemanticChangeSet cs : difference.getNotOverlappings()) {
			print.append("  ").append(cs.getName()).append("\n");
		}

		print.append("\nStructure by Semantic-Change-Set:\n");

		Collection<SemanticChangeSet> changeSets = new HashSet<SemanticChangeSet>();
		changeSets.addAll(difference.getChangeSets());
		changeSets.addAll(difference.getUnusedChangeSets());

		for (SemanticChangeSet cs : changeSets) {

			print.append("\n").append(cs.getName()).append("\n");

			if (cs.getOverlayings().size() > 0) {
				print.append("\n  Overlayings:\n");

				for (SemanticChangeSet csOverlaying : cs.getOverlayings()) {
					print.append("    ").append(csOverlaying.getName()).append("\n");
				}
			}

			if (cs.getPartiallyOverlappings().size() > 0) {
				print.append("\n  Partially Overlappings:\n");

				for (SemanticChangeSet csPartiallyOverlapping : cs.getPartiallyOverlappings()) {
					print.append("    ").append(csPartiallyOverlapping.getName()).append("\n");
				}
			}

			if (cs.getSubsets().size() > 0) {
				print.append("\n  Subsets:\n");

				for (SemanticChangeSet csSubset : cs.getSubsets()) {
					print.append("    ").append(csSubset.getName()).append("\n");
				}

			}

			if (cs.getSupersets().size() > 0) {
				print.append("\n  Supersets:\n");

				for (SemanticChangeSet csSuperset : cs.getSupersets()) {
					print.append("    ").append(csSuperset.getName()).append("\n");
				}
			}
		}

		return print.toString();
	}

	/**
	 * Creates a view of the collections of used and unused change sets.
	 * 
	 * @param difference
	 *            the difference containing the semantic change sets.
	 * @return all semantic change sets of the difference.
	 * 
	 * @see CollectionView#combine(Collection...)
	 */
	@SuppressWarnings("unchecked")
	public static Collection<SemanticChangeSet> getAllSemanticChangeSets(SymmetricDifference difference) {
		return CollectionView.combine(difference.getChangeSets(), difference.getUnusedChangeSets());
	}

	/**
	 * Returns the greatest SCS of the given collection.
	 * 
	 * @param changeSets
	 *            a SCS collection to search.
	 * @return the SCS containing the greatest number of changes.
	 */
	public static SemanticChangeSet getGreatest(Collection<SemanticChangeSet> changeSets) {

		SemanticChangeSet greatestCS = null;
		ChangeSetPriorityComparator comp = new ChangeSetPriorityComparator();

		for (SemanticChangeSet cs : changeSets) {
			if ((greatestCS == null) || (cs.getChanges().size() > greatestCS.getChanges().size())) {
				greatestCS = cs;
			} else if (cs.getChanges().size() == greatestCS.getChanges().size()) {
				if (comp.compare(cs, greatestCS) > 0) {
					greatestCS = cs;
				}
			}
		}

		return greatestCS;
	}
}
