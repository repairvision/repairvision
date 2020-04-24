package org.sidiff.validation.laguage.fol.ide.highlighting

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.swt.SWT
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor

class FirstOrderLogicHighlightingConfiguration extends DefaultHighlightingConfiguration {

	public static val VARIABLE_ID = "fol.variable"
	public static val CONSTANT_ID = NUMBER_ID // reuse existing
	
	override configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor)
		acceptor.acceptDefaultHighlighting(VARIABLE_ID, "Variable or Reference", createVariableTextStyle());
	}

	def createVariableTextStyle() {
		val textStyle = defaultTextStyle().copy();
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}
}
