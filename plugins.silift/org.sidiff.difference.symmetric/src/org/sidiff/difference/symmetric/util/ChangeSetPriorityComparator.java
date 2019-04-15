package org.sidiff.difference.symmetric.util;

import java.util.Comparator;

import org.sidiff.difference.symmetric.SemanticChangeSet;

public class ChangeSetPriorityComparator implements Comparator<SemanticChangeSet> {

	@Override
	public int compare(SemanticChangeSet cs1, SemanticChangeSet cs2) {
		 assert(cs1.getChanges().size() == cs2.getChanges().size());
		
		 if (cs1.getPriority() != cs2.getPriority()){
			 return cs1.getPriority() - cs2.getPriority();
		 }
		 if (cs1.getNumberOfACs() != cs2.getNumberOfACs()){
			 return cs1.getNumberOfACs() - cs2.getNumberOfACs();
		 }
		 if (cs1.getRefinementLevel() != cs2.getRefinementLevel()){
			 return cs1.getRefinementLevel() - cs2.getRefinementLevel();
		 }
		 if (cs1.getNumberOfParams() != cs2.getNumberOfParams()){
			 return cs2.getNumberOfParams() - cs1.getNumberOfParams();
		 }
		 
		 return 0;
	}

}
