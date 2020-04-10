package org.sidiff.revision.repair.history.evaluation.report;

public class InconsistenciesLog extends AbstractLog {
	
	public static final String NAME = "inconsistencies";
	
	public static final String COL_INCONSISTENCY = "Inconsistency";
	
	public static final String COL_CONTEXT_ELEMENT = "Context Element";
	
	public static final String COL_CONTEXT_TYPE = "Context Type";
	
	public static final String COL_HISTORY = "History";
	
	public static final String COL_HISTORICAL_VERSION = "Historical Version (consistent)";
	
	public static final String COL_INTRODUCED_VERSION = "Introduced Version (inconsistent)";
	
	public static final String COL_CURRENT_VERSION = "Current Version (inconsistent)";
	
	public static final String COL_RESOLVED_VERSION = "Resolved Version (consistent)";
	
	public static final String COL_TIME_LOAD_CALCULATE_REVISION = "[Time (ms)] Load/Calculate Revision";
	
	public static final String COL_CHANGE_COUNT = "Change Count (Historical->Actual)";
	
	public static final String COL_INCONSISTENCIES = "Inconsistencies";
	
	public static final String COL_TIME_RECOGNITION = "[Time (ms)] Recognition Time";
	
	public static final String COL_TIME_COMPLEMENT_MATCHING = "[Time (ms)] Complement Matching";
	
	public static final String COL_POTENTIAL_EDIT_RULES = "Potential Edit Rules";
	
	public static final String COL_COMPLEMENTS = "Complements (Repairs)";
	
	public static final String COL_COMPLEMENT_MATCHINGS = "Complement Matchings";
	
	public static final String COL_HISTORICALLY_OBSERVABLE_REPAIRS = "Historically Observable Repairs (HOR)";
	
	public static final String COL_HISTORICALLY_OBSERVABLE_UNDOS = "Historically Observable Undos (HOU)";
	
	public static final String COL_RANKING_OF_BEST_HOR = "Ranking of Best HOR";
	
	public static final String COL_BEST_HOR_IS_UNDO = "True if best HOR is an undo; false otherwise";

	public static final String COL_REPAIR_MATCHINGS_FOR_BEST_HOR = "Repair Matchings for Best HOR";
	
	public static final String COL_HISTORICAL_CHANGES_OF_BEST_HOR = "Historic Changes of Best HOR";
	
	public static final String COL_COMPLEMENTING_CHANGES_OF_BEST_HOR = "Complementing Changes of Best HOR";
	
	public static final String COL_UNBOUND_PARAMETERS_OF_BEST_HOR = "Unbound Parameters of Best HOR";
	
	public static final String COL_COUNT_OF_REPAIR_TREES = "Count of Repair Trees";

	public static final String COL_COUNT_OF_REPAIR_ACTIONS = "Count of Repair Actions";
	
	@Override
	public String[] getHeader() {
		return new String[] { COL_INCONSISTENCY, COL_CONTEXT_ELEMENT, COL_CONTEXT_TYPE, COL_HISTORY,
				COL_HISTORICAL_VERSION, COL_INTRODUCED_VERSION, COL_CURRENT_VERSION, COL_CURRENT_VERSION,
				COL_RESOLVED_VERSION, COL_TIME_LOAD_CALCULATE_REVISION, COL_CHANGE_COUNT, COL_INCONSISTENCIES,
				COL_TIME_RECOGNITION, COL_TIME_COMPLEMENT_MATCHING, COL_POTENTIAL_EDIT_RULES, COL_COMPLEMENTS,
				COL_COMPLEMENT_MATCHINGS, COL_HISTORICALLY_OBSERVABLE_REPAIRS, COL_RANKING_OF_BEST_HOR,
				COL_BEST_HOR_IS_UNDO, COL_REPAIR_MATCHINGS_FOR_BEST_HOR, COL_HISTORICAL_CHANGES_OF_BEST_HOR,
				COL_COMPLEMENTING_CHANGES_OF_BEST_HOR, COL_UNBOUND_PARAMETERS_OF_BEST_HOR, COL_COUNT_OF_REPAIR_TREES,
				COL_COUNT_OF_REPAIR_ACTIONS };
	}
}
