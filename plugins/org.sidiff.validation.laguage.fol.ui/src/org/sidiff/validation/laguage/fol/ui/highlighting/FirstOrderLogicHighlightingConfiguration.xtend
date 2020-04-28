package org.sidiff.validation.laguage.fol.ui.highlighting

import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.RGB
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor

class FirstOrderLogicHighlightingConfiguration extends DefaultHighlightingConfiguration {

	public static val VARIABLE_ID = "fol.variable"
	public static val GET_ID = "fol.get"
	public static val BOOLEAN_OPERATOR_ID = "fol.boolean.operator.formula"
	public static val FUNCTION_ID = "fol.function.formula"
	public static val QUANTIFIER_ID = "fol.quantifier.formula"
	public static val CONSTANT_ID = NUMBER_ID // reuse existing
	
	public static val FUNCTION_COLOR = new RGB(0, 46, 120)
	public static val VARIABLE_COLOR = new RGB(106, 62, 62)
	
	override configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor)
		acceptor.acceptDefaultHighlighting(VARIABLE_ID, "Variable", createVariableTextStyle())
		acceptor.acceptDefaultHighlighting(GET_ID, "Navigation Expression", createGetTextStyle())
		acceptor.acceptDefaultHighlighting(BOOLEAN_OPERATOR_ID, "Boolean Operator", createBooleanOperatorTextStyle())
		acceptor.acceptDefaultHighlighting(FUNCTION_ID, "Function", createFunctionTextStyle())
		acceptor.acceptDefaultHighlighting(QUANTIFIER_ID, "Quantifier", createQuantifierTextStyle())
	}
	
	def createVariableTextStyle() {
		val textStyle = defaultTextStyle().copy()	
		textStyle.setStyle(SWT.ITALIC)
		textStyle.setColor(VARIABLE_COLOR)
		return textStyle
	}
	
	def createGetTextStyle() {
		val textStyle = defaultTextStyle().copy()	
		textStyle.setStyle(SWT.ITALIC)
		return textStyle
	}
	
	def createBooleanOperatorTextStyle() {
		val textStyle = keywordTextStyle().copy()
		textStyle.setStyle(SWT.ITALIC.bitwiseOr(SWT.BOLD))
		textStyle.setColor(FUNCTION_COLOR)
		return textStyle;
	}
	
	def createFunctionTextStyle() {
		val textStyle = keywordTextStyle().copy()
		textStyle.setStyle(SWT.NONE)
		textStyle.setColor(FUNCTION_COLOR)
		return textStyle;
	}
	
	def createQuantifierTextStyle() {
		val textStyle = keywordTextStyle().copy()
		textStyle.setStyle(SWT.ITALIC.bitwiseOr(SWT.BOLD))
		textStyle.setColor(FUNCTION_COLOR)
		return textStyle;
	}
}
