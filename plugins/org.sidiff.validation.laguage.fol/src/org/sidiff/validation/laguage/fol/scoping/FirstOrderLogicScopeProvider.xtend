/*
 * generated by Xtext 2.10.0
 */
package org.sidiff.validation.laguage.fol.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.Scopes
import org.sidiff.validation.laguage.fol.converter.FeatureNameToEStructuralFeature
import org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage
import org.sidiff.validation.laguage.fol.firstOrderLogic.Get

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class FirstOrderLogicScopeProvider extends AbstractFirstOrderLogicScopeProvider {

	override getScope(EObject context, EReference reference) {
		
		if (context instanceof Get) {
			if (reference == FirstOrderLogicPackage.eINSTANCE.get_Name) {
				return Scopes::scopeFor(FeatureNameToEStructuralFeature.getClass(context).EAllStructuralFeatures)
			}
		}
		
		super.getScope(context, reference)
	}
}
