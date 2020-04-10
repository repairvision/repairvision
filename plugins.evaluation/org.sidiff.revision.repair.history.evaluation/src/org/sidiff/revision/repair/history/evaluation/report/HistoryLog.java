package org.sidiff.revision.repair.history.evaluation.report;

public class HistoryLog extends AbstractLog {
	
	public static final String NAME = "history";
	
	public static final String COL_HISTORY = "History";
	
	public static final String COL_VERSIONS = "Versions";
	
	public static final String COL_INCONSISTENT_VERSIONS = "Inconsistent Versions";
	
	public static final String COL_AVG_ELEMENTS = "Avg. Elements";
	
	public static final String COL_INCONSISTENCY_TRACES = "Inconsistency Traces";
	
	public static final String COL_RESOLVED_INOCONSISTENCY_TRACES = "Resolved Inconsistency Traces";
	
	public static final String COL_SUPPORTED_RESOLEVED_INCONSISTENCY_TRACES = "Supported Resolved Inconsistency Traces";
	
	public static final String COL_ANNOTATION_COMPLEX_REPAIRS = "[Annotation] Complex Repairs";
	
	public static final String COL_ANNOTATION_OBSERVABLE_COMPLEX_REPAIRS = "[Annotation] Observable Complex Repairs";
	
	public static final String COL_ANNOTATION_SINGLE_CHANGE_REPAIRS = "[Annotation] Single Change Repairs";
	
	public static final String COL_ANNOTATION_UNDO_REPAIRS = "[Annotation] Undo Repairs";
	
	@Override
	public String[] getHeader() {
		return new String[] { COL_HISTORY, COL_VERSIONS, COL_INCONSISTENT_VERSIONS, COL_AVG_ELEMENTS,
				COL_INCONSISTENCY_TRACES, COL_RESOLVED_INOCONSISTENCY_TRACES,
				COL_SUPPORTED_RESOLEVED_INCONSISTENCY_TRACES, COL_ANNOTATION_COMPLEX_REPAIRS,
				COL_ANNOTATION_OBSERVABLE_COMPLEX_REPAIRS, COL_ANNOTATION_SINGLE_CHANGE_REPAIRS,
				COL_ANNOTATION_UNDO_REPAIRS };
	}
}
