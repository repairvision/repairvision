package org.sidiff.repair.history.generator.reports.util;

import java.util.LinkedList;
import java.util.List;

public class UMLUtil {
	
	public static List<String> getCharacterizingMessageFragments() {
		List<String> res = new LinkedList<String>();
		res.add("Not all the members of namespace");
		res.add("is not owned by a namespace, but it has visibility");
		res.add("has an optional, loop, break, assertion, or negative interaction operator but does not have exactly one operand.");
		res.add("with 0 values must have at least 1 values");
		res.add("The start and finish of execution specification");
		res.add("must be a feature of the context classifier of the behavior");
		res.add("The required feature 'start'");
		res.add("The required feature 'action'");
		res.add("The required feature 'source'");
		res.add("The required feature 'target'");
		res.add("The required feature 'event'");
		res.add("The required feature 'operation'");

		return res;
	}
}
