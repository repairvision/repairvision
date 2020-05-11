package org.sidiff.validation.constraint.project.registry.util;

import java.util.ArrayList;
import java.util.List;

import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.project.registry.IConstraintLibrary;

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
