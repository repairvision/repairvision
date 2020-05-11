package org.sidiff.revision.repair.history.evaluation.report;

public class RecognitionLog extends AbstractLog {
	
	public static final String NAME = "runtime";
	
	public static final String COL_CHANGE_COUNT_SUM = "Change Count (Sum)";
	
	public static final String COL_CHANGE_NODE_COUNT = "Change Node Count";
	
	public static final String COL_TIME_MATCHING_TIME = "[Time (ms)] Matching Time";

	@Override
	public String[] getHeader() {
		return new String[] { COL_CHANGE_COUNT_SUM, COL_CHANGE_NODE_COUNT, COL_TIME_MATCHING_TIME };
	}
}
