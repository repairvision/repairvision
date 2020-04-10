package org.sidiff.revision.repair.history.evaluation.report;

public class EditRulesLog extends AbstractLog {

	public static final String NAME = "editrules";
	
	public static final String COL_ALL_EDIT_RULES = "Edit Rules (All)";

	public static final String COL_AVG_NODE_EDGE_CHANGES = "Avg. Node/Edge Changes";

	public static final String COL_AVG_ATTRIBUTE_CHANGES = "Avg. Attribute Changes";

	@Override
	public String[] getHeader() {
		return new String[] { COL_ALL_EDIT_RULES, COL_AVG_NODE_EDGE_CHANGES, COL_AVG_ATTRIBUTE_CHANGES };
	}
}
