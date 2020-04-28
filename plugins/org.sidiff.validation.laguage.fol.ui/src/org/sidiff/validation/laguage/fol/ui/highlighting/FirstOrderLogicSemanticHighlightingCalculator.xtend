package org.sidiff.validation.laguage.fol.ui.highlighting

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.util.CancelIndicator
import org.sidiff.validation.laguage.fol.firstOrderLogic.BoolConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.ClassifierConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.DataTypeConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage
import org.sidiff.validation.laguage.fol.firstOrderLogic.Get
import org.sidiff.validation.laguage.fol.firstOrderLogic.IntConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.StringConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.Variable
import org.sidiff.validation.laguage.fol.firstOrderLogic.VariableRef
import org.sidiff.validation.laguage.fol.firstOrderLogic.FeatureConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.Domain

class FirstOrderLogicSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {

	override protected boolean highlightElement(EObject object,
			IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {

		switch(object) {
			
			Domain:{
				acceptor.highlightFeature(object,
					FirstOrderLogicPackage.eINSTANCE.domain_Domain,
					FirstOrderLogicHighlightingConfiguration.CONSTANT_ID)
				return false
			}
			
			Variable: {
				acceptor.highlightFeature(object,
					FirstOrderLogicPackage.eINSTANCE.variable_Name,
					FirstOrderLogicHighlightingConfiguration.VARIABLE_ID)
				acceptor.highlightFeature(object,
					FirstOrderLogicPackage.eINSTANCE.variable_Type,
					FirstOrderLogicHighlightingConfiguration.CONSTANT_ID)
				return false
			}
			
			VariableRef: {
				acceptor.highlightFeature(object,
					FirstOrderLogicPackage.eINSTANCE.variableRef_Name,
					FirstOrderLogicHighlightingConfiguration.VARIABLE_ID)
				return false
			}
			
			Get: {
				acceptor.highlightFeature(object,
					FirstOrderLogicPackage.eINSTANCE.get_Name,
					FirstOrderLogicHighlightingConfiguration.GET_ID)
				highlightFeature(acceptor, object,
					FirstOrderLogicPackage.eINSTANCE.get_Type,
					FirstOrderLogicHighlightingConfiguration.GET_ID)
				return false
			}
			
			IntConstant: {
				acceptor.highlightFeature(object,
					FirstOrderLogicPackage.eINSTANCE.intConstant_Value,
					FirstOrderLogicHighlightingConfiguration.CONSTANT_ID)
				return false
			}
			
			BoolConstant: {
				acceptor.highlightFeature(object,
					FirstOrderLogicPackage.eINSTANCE.boolConstant_Value,
					FirstOrderLogicHighlightingConfiguration.CONSTANT_ID)
				return false
			}
			
			StringConstant: {
				acceptor.highlightFeature(object,
					FirstOrderLogicPackage.eINSTANCE.stringConstant_Value,
					FirstOrderLogicHighlightingConfiguration.CONSTANT_ID)
				return false
			}
			
			FeatureConstant: {
				acceptor.highlightNode(NodeModelUtils.getNode(object),
					FirstOrderLogicHighlightingConfiguration.CONSTANT_ID)
				return false
			}
			
			ClassifierConstant: {
				acceptor.highlightNode(NodeModelUtils.getNode(object),
					FirstOrderLogicHighlightingConfiguration.CONSTANT_ID)
				return false
			}
			
			DataTypeConstant: {
				acceptor.highlightNode(NodeModelUtils.getNode(object),
					FirstOrderLogicHighlightingConfiguration.CONSTANT_ID)
				return false
			}
			
			default: false
		}
		
	}
}
