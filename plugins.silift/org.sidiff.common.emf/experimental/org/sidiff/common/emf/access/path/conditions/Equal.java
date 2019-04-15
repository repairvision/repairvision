//TODO Review, Asserts, Doku
package org.sidiff.common.emf.access.path.conditions;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.path.impl.EMFPathStepImpl;

public class Equal extends EMFCondition {

	String value1 = null;
	String value2 = null;
	public Equal(String argumentString) {
		super(argumentString);
		String[] values = argumentString.split(";");
		value1 = values[0];
		value2 = values[1];
	}

	@Override
	public void initCondition(EMFPathStepImpl step) {
	}

	@Override
	public boolean select(EObject item) {
		return value1.equals(value2);
	}

}
