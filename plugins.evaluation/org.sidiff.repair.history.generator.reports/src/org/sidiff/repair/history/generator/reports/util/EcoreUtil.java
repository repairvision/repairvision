package org.sidiff.repair.history.generator.reports.util;

import java.util.LinkedList;
import java.util.List;

public class EcoreUtil {
	
	public static List<String> getCharacterizingMessageFragments() {
		List<String> res = new LinkedList<String>();

		// keep defects to completely ignore such defect models
		res.add("contains an unresolved proxy");
		res.add("contains a dangling reference");

		// reasonable
		res.add("do not refer to each other");
		res.add("The opposite of the opposite may not be a reference different from this on");
		res.add("The opposite may not be its own opposit");
		res.add("The opposite must be a feature of the reference's typ");
		res.add("The typed element must have a typ");
		res.add("cannot both be IDs");
		res.add("There may not be two features named");
		res.add("There may not be two enumerators named");
		res.add("There may not be two enumerators with literal value");
		res.add("There may not be two type parameters named");
		res.add("There may not be two parameters named");
		res.add("There may not be two packages named");
		res.add("There may not be two classifiers named");
		res.add("There may not be two packages with namespace URI");
		res.add("is not transient so it must have a data type that is serializable");
		res.add("A class that is an interface must also be abstract");
		res.add("An operation with void return type must have an upper bound of 1 not");
		res.add("A container reference must have upper bound of 1 not");
		res.add("The opposite of a transient reference must be transient if it is proxy resolvin");
		res.add("The opposite of a containment reference must not be a containment referenc");
		res.add("A containment or bidirectional reference must be unique if its upper bound is different from");
		res.add("The generic attribute type must not refer to a clas");
		res.add("The generic reference type must not refer to a data typ");
		res.add("A generic type can't refer to both a type parameter and a classifie");
		res.add("A generic super type must refer to a clas");
		res.add("A generic type in this context must refer to a classifier or a type paramete");
		res.add("A generic type may have bounds only when used as a type argumen");
		res.add("A generic type must not have both a lower and an upper boun");
		res.add("A generic type with bounds must not also refer to a type parameter or classifie");
		res.add("A generic type may have arguments only if it refers to a classifie");
		res.add("type argument(s) to match the number of type parameter(s) of the classifier");
		res.add("is not a valid substitution for type parameter");
		res.add("argument(s) when the classifier has");
		res.add("A generic type may only refer to a type parameter that is in scop");
		res.add("cannot be used in this context");
		res.add("The generic super types at index");
		res.add("The generic super types instantiate");
		res.add("must be less than or equal to the upper bound");
		res.add("that requires instances to be contained elsewhere cannot be populated");
		res.add("with the same signature as an accessor method for feature");
		res.add("There may not be two operations");
		res.add("A class may not be a super type of itsel");

		return res;
	}
}
