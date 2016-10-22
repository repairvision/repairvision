package org.sidiff.consistency.repair.lifting.cpo.util;

import java.util.HashSet;
import java.util.Set;

import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.util.ChangeSetPriorityComparator;
import org.sidiff.difference.symmetric.util.DifferenceAnalysisUtil;

public class PostProcessingUtil {

	public static void removeSubChangeSets(SymmetricDifference difference) {
		DifferenceAnalysisUtil.analyzeDifferenceStructure(difference);
		Set<SemanticChangeSet> nestedCS = new HashSet<SemanticChangeSet>();

		for (SemanticChangeSet cs : difference.getChangeSets()) {
			nestedCS.addAll(cs.getSubsets());
		}
		
		// Remove all nested:
		difference.getChangeSets().removeAll(nestedCS);
	}
	
	public static void removeDuplicatedChangeSets(SymmetricDifference difference) {
		Set<SemanticChangeSet> toBeRemoved = new HashSet<>();
		
		// FIXME: This should normally be done on the graph level.
		// Heuristic: Keep the EO with less application conditions.
		// => results (mostly) in the super set of possible CPOxEO embeddings.
		ChangeSetPriorityComparator comp = new ChangeSetPriorityComparator();
		
		for (SemanticChangeSet cs : difference.getChangeSets()) {
			if (!toBeRemoved.contains(cs)) {
				SemanticChangeSet mostCommon = cs;
				
				for (SemanticChangeSet overlaying : cs.getOverlayings()) {
					toBeRemoved.add(overlaying);
					
					if (comp.compare(overlaying, mostCommon) < 0) {
						mostCommon = overlaying;
					}
				}

				toBeRemoved.remove(mostCommon);
			}
		}
		
		// Remove all duplicated change sets:
		difference.getChangeSets().removeAll(toBeRemoved);
		
		if (DebugUtil.isActive) {
			for (SemanticChangeSet removed : toBeRemoved) {
				LogUtil.log(LogEvent.WARNING, "EO duplicate removed: " + removed.getName());
			}
		}
	}
}
