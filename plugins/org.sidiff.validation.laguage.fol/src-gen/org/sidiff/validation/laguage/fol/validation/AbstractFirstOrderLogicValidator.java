/*
 * generated by Xtext 2.17.0
 */
package org.sidiff.validation.laguage.fol.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractFirstOrderLogicValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage.eINSTANCE);
		return result;
	}
}
