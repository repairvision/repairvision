package org.sidiff.consistency.repair.lifting.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.matching.partial.NodeMatching;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricFactory;

public class DebuggingHelper {

	public List<SemanticChangeSet> filterDuplicates(List<SemanticChangeSet> repairChangeSets) {
		List<SemanticChangeSet> min_repairChangeSets = new ArrayList<>();

		for (SemanticChangeSet repairChangeSet : repairChangeSets) {
			boolean containsEqual = false;

			for (SemanticChangeSet min_repairChangeSet : min_repairChangeSets) {
				boolean isEqual = true;

				// Compare changes:
				for (Change change : repairChangeSet.getChanges()) {
					for (Change min_change : min_repairChangeSet.getChanges()) {
						if (change != min_change) {
							isEqual = false;
							break;
						}
					}

					if (!isEqual) {
						break;
					}
				}

				if (isEqual) {
					containsEqual = true;
					break;
				}
			}

			if (!containsEqual) {
				min_repairChangeSets.add(repairChangeSet);
			}

		}

		return min_repairChangeSets;
	}

	public SemanticChangeSet createChangeSet(Map<NodePattern, NodeMatching> matching)  {
		SemanticChangeSet repairChangeSet = SymmetricFactory.eINSTANCE.createSemanticChangeSet();

		for (Entry<NodePattern, NodeMatching> match : matching.entrySet()) {
			if (match.getValue().getMatch() != null) {
				repairChangeSet.getChanges().add((Change) match.getValue().getMatch());
			}
		}

		return repairChangeSet;
	}
}
