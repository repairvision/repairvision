package org.sidiff.validation.constraint.api.library.util;

import java.util.ArrayList;
import java.util.List;

import org.sidiff.repair.validation.IConstraint;
import org.sidiff.validation.constraint.api.library.IConstraintLibrary;

public class ConstraintLibraryUtil {

	public static List<IConstraint> getConsistencyRules(List<IConstraintLibrary> libraries) {
		List<IConstraint> constraints = new ArrayList<>();
		
		for (IConstraintLibrary library : libraries) {
			constraints.addAll(library.getConstraints());
		}
		
		return constraints;
	}
	
	public static IConstraint getConsistencyRule(List<IConstraintLibrary> libraries, String name) {
		for (IConstraintLibrary library : libraries) {
			return library.getConstraint(name);
		}
		return null;
	}
}
