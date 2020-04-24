package org.sidiff.validation.laguage.fol.util

import java.util.Collection
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.sidiff.validation.laguage.fol.firstOrderLogic.BoolConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.Capitalize
import org.sidiff.validation.laguage.fol.firstOrderLogic.Concatenate
import org.sidiff.validation.laguage.fol.firstOrderLogic.Constraint
import org.sidiff.validation.laguage.fol.firstOrderLogic.ConstraintLibrary
import org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage
import org.sidiff.validation.laguage.fol.firstOrderLogic.Get
import org.sidiff.validation.laguage.fol.firstOrderLogic.GetClosure
import org.sidiff.validation.laguage.fol.firstOrderLogic.GetContainer
import org.sidiff.validation.laguage.fol.firstOrderLogic.GetContainments
import org.sidiff.validation.laguage.fol.firstOrderLogic.IndexOf
import org.sidiff.validation.laguage.fol.firstOrderLogic.IntConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.MetaConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.Quantifier
import org.sidiff.validation.laguage.fol.firstOrderLogic.ReferenceBase
import org.sidiff.validation.laguage.fol.firstOrderLogic.Select
import org.sidiff.validation.laguage.fol.firstOrderLogic.Size
import org.sidiff.validation.laguage.fol.firstOrderLogic.StringConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.Term
import org.sidiff.validation.laguage.fol.firstOrderLogic.VariableRef

import static extension org.sidiff.validation.laguage.fol.util.FolLanguageUtil.*

class ScopeUtil {

	def static Collection<EClassifier> getAllClassifiers(EObject grammarContext) {
		val ConstraintLibrary rulebase = EcoreUtil2.getContainerOfType(grammarContext, ConstraintLibrary)
		if (rulebase !== null) {
			return rulebase.imports
				.map[domain].map[trim]
				.map[EPackage.Registry.INSTANCE.getEPackage(it)]
				.flatMap[EClassifiers].toSet
		}
		return emptySet
	}

	def static EClassifier getRawResultType(EObject term) {
		switch(term) {
			BoolConstant: return EcorePackage::eINSTANCE.EBoolean	
			Capitalize, Concatenate, StringConstant: return EcorePackage::eINSTANCE.EString	
			Size, IntConstant, IndexOf: return EcorePackage::eINSTANCE.EInt
			MetaConstant: {
				if(term.literalOrFeature !== null) {
					return term.literalOrFeature.eClass
				}
				return term.classifier.eClass
			}
			VariableRef: term.name.type
			Select: term.name.type
			GetClosure: term.variable.type
			GetContainer, GetContainments: EcorePackage::eINSTANCE.EObject
			Get: term.name.EType
			default: null
		}
	}

	def static EClassifier getResultType(Term term) {
		if(term instanceof ReferenceBase) {
			var lastGet = term.lastGet
			// skip empty / invalid gets
			while(lastGet !== null && lastGet.name === null) {
				lastGet = lastGet.parentGet
			}
			if(lastGet !== null) {
				return lastGet.name.EType
			}
		}
		return getRawResultType(term)
	}

	def static Collection<EClass> getAllSubTypes(EObject context, EClass type) {
		return getAllClassifiers(context)
			.filter(EClass)
			.filter[EcoreUtil2.isAssignableFrom(type, it)]
			.toSet
	}

	def static IScope getAllReferenceableVariables(EObject grammarContext) {
		if(grammarContext === null) {
			return IScope::NULLSCOPE
		}
		val container = grammarContext.eContainer
		switch(container) {
			Constraint: return Scopes::scopeFor(#[container.variable])
			GetClosure: {
				// Variable of GetClosure is only usable in the Iteration-Term
				if(grammarContext.eContainmentFeature == FirstOrderLogicPackage::eINSTANCE.getClosure_Iteration) {
					return Scopes::scopeFor(#[container.variable], getAllReferenceableVariables(container))				
				}
			}
			Quantifier: {
				// Variable of Quantifier (Exists, ForAll) can only be used in its Formula
				if(grammarContext.eContainmentFeature == FirstOrderLogicPackage::eINSTANCE.quantifier_Formula) {
					return Scopes::scopeFor(#[container.name], getAllReferenceableVariables(container))				
				}
			}
			Select: {
				// Variable of Select can only be used in its Formula
				if(grammarContext.eContainmentFeature == FirstOrderLogicPackage::eINSTANCE.select_Formula) {
					return Scopes::scopeFor(#[container.name], getAllReferenceableVariables(container))
				}
			}
		}
		return getAllReferenceableVariables(container);
	}
}
