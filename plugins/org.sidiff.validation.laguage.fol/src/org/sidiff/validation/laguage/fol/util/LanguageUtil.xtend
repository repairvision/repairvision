package org.sidiff.validation.laguage.fol.util

import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage
import org.sidiff.validation.laguage.fol.firstOrderLogic.BoolConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.Capitalize
import org.sidiff.validation.laguage.fol.firstOrderLogic.Classifier
import org.sidiff.validation.laguage.fol.firstOrderLogic.Concatenate
import org.sidiff.validation.laguage.fol.firstOrderLogic.DataType
import org.sidiff.validation.laguage.fol.firstOrderLogic.Get
import org.sidiff.validation.laguage.fol.firstOrderLogic.GetContainer
import org.sidiff.validation.laguage.fol.firstOrderLogic.IndexOf
import org.sidiff.validation.laguage.fol.firstOrderLogic.IntConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.Size
import org.sidiff.validation.laguage.fol.firstOrderLogic.StringConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.Term
import org.sidiff.validation.laguage.fol.firstOrderLogic.VariableRef

class LanguageUtil {
	
	def static EStructuralFeature getVariableReferenceTarget(VariableRef ref) {
		var lastGet = ref.get

		while (lastGet !== null && lastGet.next !== null) {
			lastGet = lastGet.next
		}

		if (lastGet !== null) {
			return lastGet.name
		}
		
		return null
	}
	
	def static EClassifier getResultType(Term term) {
		if (term instanceof VariableRef) {
			var ref = LanguageUtil.getVariableReferenceTarget(term);
			
			if (ref !== null) {
				return ref.EType
			}
		}
		return getRawResultType(term)
	}
	
	def static EClassifier getRawResultType(EObject term) {
		switch(term) {
			BoolConstant: EcorePackage::eINSTANCE.EBoolean	
			Capitalize, Concatenate, StringConstant: EcorePackage::eINSTANCE.EString	
			Size, IntConstant, IndexOf: EcorePackage::eINSTANCE.EInt
			Classifier: EcorePackage::eINSTANCE.EClassifier
			DataType: EcorePackage::eINSTANCE.EDataType
			VariableRef: term.name.type
			GetContainer: EcorePackage::eINSTANCE.EObject
			Get: term.name.EType
			default: null
		}
	}
}
