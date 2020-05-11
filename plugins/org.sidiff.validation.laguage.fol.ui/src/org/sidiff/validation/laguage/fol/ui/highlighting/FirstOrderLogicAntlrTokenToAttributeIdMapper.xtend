package org.sidiff.validation.laguage.fol.ui.highlighting

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper

class FirstOrderLogicAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {
	
	override protected calculateId(String tokenName, int tokenType) {

		if(tokenName.equals("'or'")) {
			return FirstOrderLogicHighlightingConfiguration.BOOLEAN_OPERATOR_ID;
		}
		if(tokenName.equals("'and'")) {
			return FirstOrderLogicHighlightingConfiguration.BOOLEAN_OPERATOR_ID;
		}
		if(tokenName.equals("'implies'")) {
			return FirstOrderLogicHighlightingConfiguration.BOOLEAN_OPERATOR_ID;
		}
		if(tokenName.equals("'xor'")) {
			return FirstOrderLogicHighlightingConfiguration.BOOLEAN_OPERATOR_ID;
		}
		if(tokenName.equals("'='")) {
			return FirstOrderLogicHighlightingConfiguration.BOOLEAN_OPERATOR_ID;
		}
		if(tokenName.equals("'not'")) {
			return FirstOrderLogicHighlightingConfiguration.BOOLEAN_OPERATOR_ID;
		}
		if(tokenName.matches("'is.*?'")) {
			return FirstOrderLogicHighlightingConfiguration.FUNCTION_ID;
		}
		if(tokenName.matches("'get.*?'")) {
			return FirstOrderLogicHighlightingConfiguration.FUNCTION_ID;
		}
		if(tokenName.matches("'as.*?'")) {
			return FirstOrderLogicHighlightingConfiguration.FUNCTION_ID;
		}
		if(tokenName.equals("'size'")) {
			return FirstOrderLogicHighlightingConfiguration.FUNCTION_ID;
		}
		if(tokenName.equals("'indexOf'")) {
			return FirstOrderLogicHighlightingConfiguration.FUNCTION_ID;
		}
		if(tokenName.equals("'concatenate'")) {
			return FirstOrderLogicHighlightingConfiguration.FUNCTION_ID;
		}
		if(tokenName.equals("'capitalize'")) {
			return FirstOrderLogicHighlightingConfiguration.FUNCTION_ID;
		}
		if(tokenName.equals("'forAll'")) {
			return FirstOrderLogicHighlightingConfiguration.QUANTIFIER_ID;
		}
		if(tokenName.equals("'exists'")) {
			return FirstOrderLogicHighlightingConfiguration.QUANTIFIER_ID;
		}
		if(tokenName.equals("'in'")) {
			return FirstOrderLogicHighlightingConfiguration.QUANTIFIER_ID;
		}
		
		super.calculateId(tokenName, tokenType)
	}
	
}