/*
 * generated by Xtext 2.10.0
 */
grammar InternalFirstOrderLogic;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.sidiff.validation.laguage.fol.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.sidiff.validation.laguage.fol.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.sidiff.validation.laguage.fol.services.FirstOrderLogicGrammarAccess;

}

@parser::members {

 	private FirstOrderLogicGrammarAccess grammarAccess;

    public InternalFirstOrderLogicParser(TokenStream input, FirstOrderLogicGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "ConsistencyRule";
   	}

   	@Override
   	protected FirstOrderLogicGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleConsistencyRule
entryRuleConsistencyRule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConsistencyRuleRule()); }
	iv_ruleConsistencyRule=ruleConsistencyRule
	{ $current=$iv_ruleConsistencyRule.current; }
	EOF;

// Rule ConsistencyRule
ruleConsistencyRule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='context'
		{
			newLeafNode(otherlv_0, grammarAccess.getConsistencyRuleAccess().getContextKeyword_0());
		}
		(
			(
				lv_type_1_0=RULE_ID
				{
					newLeafNode(lv_type_1_0, grammarAccess.getConsistencyRuleAccess().getTypeIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConsistencyRuleRule());
					}
					setWithLastConsumed(
						$current,
						"type",
						lv_type_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getConsistencyRuleAccess().getVariableVariableParserRuleCall_2_0());
				}
				lv_variable_2_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConsistencyRuleRule());
					}
					set(
						$current,
						"variable",
						lv_variable_2_0,
						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=':'
		{
			newLeafNode(otherlv_3, grammarAccess.getConsistencyRuleAccess().getColonKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getConsistencyRuleAccess().getFormulaFormulaParserRuleCall_4_0());
				}
				lv_formula_4_0=ruleFormula
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConsistencyRuleRule());
					}
					set(
						$current,
						"formula",
						lv_formula_4_0,
						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleVariable
entryRuleVariable returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVariableRule()); }
	iv_ruleVariable=ruleVariable
	{ $current=$iv_ruleVariable.current; }
	EOF;

// Rule Variable
ruleVariable returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_name_0_0=RULE_ID
			{
				newLeafNode(lv_name_0_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getVariableRule());
				}
				setWithLastConsumed(
					$current,
					"name",
					lv_name_0_0,
					"org.eclipse.xtext.common.Terminals.ID");
			}
		)
	)
;

// Entry rule entryRuleTerm
entryRuleTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTermRule()); }
	iv_ruleTerm=ruleTerm
	{ $current=$iv_ruleTerm.current; }
	EOF;

// Rule Term
ruleTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getTermAccess().getFunctionParserRuleCall());
	}
	this_Function_0=ruleFunction
	{
		$current = $this_Function_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleFunction
entryRuleFunction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFunctionRule()); }
	iv_ruleFunction=ruleFunction
	{ $current=$iv_ruleFunction.current; }
	EOF;

// Rule Function
ruleFunction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getFunctionAccess().getGetParserRuleCall());
	}
	this_Get_0=ruleGet
	{
		$current = $this_Get_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleGet
entryRuleGet returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGetRule()); }
	iv_ruleGet=ruleGet
	{ $current=$iv_ruleGet.current; }
	EOF;

// Rule Get
ruleGet returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getGetAccess().getVariableParserRuleCall_0());
		}
		this_Variable_0=ruleVariable
		{
			$current = $this_Variable_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getGetAccess().getGetContextAction_1_0(),
						$current);
				}
			)
			otherlv_2='.'
			{
				newLeafNode(otherlv_2, grammarAccess.getGetAccess().getFullStopKeyword_1_1());
			}
			(
				(
					lv_feature_3_0=RULE_ID
					{
						newLeafNode(lv_feature_3_0, grammarAccess.getGetAccess().getFeatureIDTerminalRuleCall_1_2_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getGetRule());
						}
						setWithLastConsumed(
							$current,
							"feature",
							lv_feature_3_0,
							"org.eclipse.xtext.common.Terminals.ID");
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleFormula
entryRuleFormula returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFormulaRule()); }
	iv_ruleFormula=ruleFormula
	{ $current=$iv_ruleFormula.current; }
	EOF;

// Rule Formula
ruleFormula returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getFormulaAccess().getBinaryFormulaParserRuleCall());
	}
	this_BinaryFormula_0=ruleBinaryFormula
	{
		$current = $this_BinaryFormula_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleBinaryFormula
entryRuleBinaryFormula returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBinaryFormulaRule()); }
	iv_ruleBinaryFormula=ruleBinaryFormula
	{ $current=$iv_ruleBinaryFormula.current; }
	EOF;

// Rule BinaryFormula
ruleBinaryFormula returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getBinaryFormulaAccess().getIfParserRuleCall());
	}
	this_If_0=ruleIf
	{
		$current = $this_If_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleIf
entryRuleIf returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIfRule()); }
	iv_ruleIf=ruleIf
	{ $current=$iv_ruleIf.current; }
	EOF;

// Rule If
ruleIf returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getIfAccess().getXorParserRuleCall_0());
		}
		this_Xor_0=ruleXor
		{
			$current = $this_Xor_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getIfAccess().getIfLeftAction_1_0(),
						$current);
				}
			)
			otherlv_2='implies'
			{
				newLeafNode(otherlv_2, grammarAccess.getIfAccess().getImpliesKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getIfAccess().getRightXorParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleXor
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getIfRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.sidiff.validation.laguage.fol.FirstOrderLogic.Xor");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleXor
entryRuleXor returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXorRule()); }
	iv_ruleXor=ruleXor
	{ $current=$iv_ruleXor.current; }
	EOF;

// Rule Xor
ruleXor returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXorAccess().getOrParserRuleCall_0());
		}
		this_Or_0=ruleOr
		{
			$current = $this_Or_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
						$current);
				}
			)
			otherlv_2='xor'
			{
				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getXorKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getXorAccess().getRightOrParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleOr
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXorRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.sidiff.validation.laguage.fol.FirstOrderLogic.Or");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOr
entryRuleOr returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOrRule()); }
	iv_ruleOr=ruleOr
	{ $current=$iv_ruleOr.current; }
	EOF;

// Rule Or
ruleOr returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0());
		}
		this_And_0=ruleAnd
		{
			$current = $this_And_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
						$current);
				}
			)
			otherlv_2='or'
			{
				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getOrKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleAnd
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOrRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.sidiff.validation.laguage.fol.FirstOrderLogic.And");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleAnd
entryRuleAnd returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAndRule()); }
	iv_ruleAnd=ruleAnd
	{ $current=$iv_ruleAnd.current; }
	EOF;

// Rule And
ruleAnd returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAndAccess().getPrimaryParserRuleCall_0());
		}
		this_Primary_0=rulePrimary
		{
			$current = $this_Primary_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
						$current);
				}
			)
			otherlv_2='and'
			{
				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAndKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getAndAccess().getRightPrimaryParserRuleCall_1_2_0());
					}
					lv_right_3_0=rulePrimary
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAndRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.sidiff.validation.laguage.fol.FirstOrderLogic.Primary");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleUnaryFormula
entryRuleUnaryFormula returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUnaryFormulaRule()); }
	iv_ruleUnaryFormula=ruleUnaryFormula
	{ $current=$iv_ruleUnaryFormula.current; }
	EOF;

// Rule UnaryFormula
ruleUnaryFormula returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getUnaryFormulaAccess().getNotParserRuleCall());
	}
	this_Not_0=ruleNot
	{
		$current = $this_Not_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleNot
entryRuleNot returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNotRule()); }
	iv_ruleNot=ruleNot
	{ $current=$iv_ruleNot.current; }
	EOF;

// Rule Not
ruleNot returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getNotAccess().getNotAction_0(),
					$current);
			}
		)
		otherlv_1='not('
		{
			newLeafNode(otherlv_1, grammarAccess.getNotAccess().getNotKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getNotAccess().getNotFormulaParserRuleCall_2_0());
				}
				lv_not_2_0=ruleFormula
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNotRule());
					}
					set(
						$current,
						"not",
						lv_not_2_0,
						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getNotAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleQuantifier
entryRuleQuantifier returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getQuantifierRule()); }
	iv_ruleQuantifier=ruleQuantifier
	{ $current=$iv_ruleQuantifier.current; }
	EOF;

// Rule Quantifier
ruleQuantifier returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getQuantifierAccess().getForAllParserRuleCall_0());
		}
		this_ForAll_0=ruleForAll
		{
			$current = $this_ForAll_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getQuantifierAccess().getExistsParserRuleCall_1());
		}
		this_Exists_1=ruleExists
		{
			$current = $this_Exists_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleForAll
entryRuleForAll returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getForAllRule()); }
	iv_ruleForAll=ruleForAll
	{ $current=$iv_ruleForAll.current; }
	EOF;

// Rule ForAll
ruleForAll returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getForAllAccess().getForAllAction_0(),
					$current);
			}
		)
		otherlv_1='forAll('
		{
			newLeafNode(otherlv_1, grammarAccess.getForAllAccess().getForAllKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getForAllAccess().getBoundedVariableParserRuleCall_2_0());
				}
				lv_bounded_2_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getForAllRule());
					}
					set(
						$current,
						"bounded",
						lv_bounded_2_0,
						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='in'
		{
			newLeafNode(otherlv_3, grammarAccess.getForAllAccess().getInKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getForAllAccess().getIterationTermParserRuleCall_4_0());
				}
				lv_iteration_4_0=ruleTerm
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getForAllRule());
					}
					set(
						$current,
						"iteration",
						lv_iteration_4_0,
						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5=':'
		{
			newLeafNode(otherlv_5, grammarAccess.getForAllAccess().getColonKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getForAllAccess().getFormulaFormulaParserRuleCall_6_0());
				}
				lv_formula_6_0=ruleFormula
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getForAllRule());
					}
					set(
						$current,
						"formula",
						lv_formula_6_0,
						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7=')'
		{
			newLeafNode(otherlv_7, grammarAccess.getForAllAccess().getRightParenthesisKeyword_7());
		}
	)
;

// Entry rule entryRuleExists
entryRuleExists returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExistsRule()); }
	iv_ruleExists=ruleExists
	{ $current=$iv_ruleExists.current; }
	EOF;

// Rule Exists
ruleExists returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getExistsAccess().getExistsAction_0(),
					$current);
			}
		)
		otherlv_1='exists('
		{
			newLeafNode(otherlv_1, grammarAccess.getExistsAccess().getExistsKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getExistsAccess().getBoundedVariableParserRuleCall_2_0());
				}
				lv_bounded_2_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getExistsRule());
					}
					set(
						$current,
						"bounded",
						lv_bounded_2_0,
						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='in'
		{
			newLeafNode(otherlv_3, grammarAccess.getExistsAccess().getInKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getExistsAccess().getIterationTermParserRuleCall_4_0());
				}
				lv_iteration_4_0=ruleTerm
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getExistsRule());
					}
					set(
						$current,
						"iteration",
						lv_iteration_4_0,
						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5=':'
		{
			newLeafNode(otherlv_5, grammarAccess.getExistsAccess().getColonKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getExistsAccess().getFormulaFormulaParserRuleCall_6_0());
				}
				lv_formula_6_0=ruleFormula
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getExistsRule());
					}
					set(
						$current,
						"formula",
						lv_formula_6_0,
						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7=')'
		{
			newLeafNode(otherlv_7, grammarAccess.getExistsAccess().getRightParenthesisKeyword_7());
		}
	)
;

// Entry rule entryRulePrimary
entryRulePrimary returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimaryRule()); }
	iv_rulePrimary=rulePrimary
	{ $current=$iv_rulePrimary.current; }
	EOF;

// Rule Primary
rulePrimary returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='('
			{
				newLeafNode(otherlv_0, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0());
			}
			{
				newCompositeNode(grammarAccess.getPrimaryAccess().getFormulaParserRuleCall_0_1());
			}
			this_Formula_1=ruleFormula
			{
				$current = $this_Formula_1.current;
				afterParserOrEnumRuleCall();
			}
			otherlv_2=')'
			{
				newLeafNode(otherlv_2, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2());
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getPrimaryAccess().getUnaryFormulaParserRuleCall_1());
		}
		this_UnaryFormula_3=ruleUnaryFormula
		{
			$current = $this_UnaryFormula_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPrimaryAccess().getQuantifierParserRuleCall_2());
		}
		this_Quantifier_4=ruleQuantifier
		{
			$current = $this_Quantifier_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPrimaryAccess().getTerminalExpressionParserRuleCall_3());
		}
		this_TerminalExpression_5=ruleTerminalExpression
		{
			$current = $this_TerminalExpression_5.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTerminalExpression
entryRuleTerminalExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTerminalExpressionRule()); }
	iv_ruleTerminalExpression=ruleTerminalExpression
	{ $current=$iv_ruleTerminalExpression.current; }
	EOF;

// Rule TerminalExpression
ruleTerminalExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getTerminalExpressionAccess().getIntConstantAction_0_0(),
						$current);
				}
			)
			(
				(
					lv_value_1_0=RULE_INT
					{
						newLeafNode(lv_value_1_0, grammarAccess.getTerminalExpressionAccess().getValueINTTerminalRuleCall_0_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTerminalExpressionRule());
						}
						setWithLastConsumed(
							$current,
							"value",
							lv_value_1_0,
							"org.eclipse.xtext.common.Terminals.INT");
					}
				)
			)
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getTerminalExpressionAccess().getStringConstantAction_1_0(),
						$current);
				}
			)
			(
				(
					lv_value_3_0=RULE_STRING
					{
						newLeafNode(lv_value_3_0, grammarAccess.getTerminalExpressionAccess().getValueSTRINGTerminalRuleCall_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTerminalExpressionRule());
						}
						setWithLastConsumed(
							$current,
							"value",
							lv_value_3_0,
							"org.eclipse.xtext.common.Terminals.STRING");
					}
				)
			)
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getTerminalExpressionAccess().getBoolConstantAction_2_0(),
						$current);
				}
			)
			(
				(
					(
						lv_value_5_1='true'
						{
							newLeafNode(lv_value_5_1, grammarAccess.getTerminalExpressionAccess().getValueTrueKeyword_2_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getTerminalExpressionRule());
							}
							setWithLastConsumed($current, "value", lv_value_5_1, null);
						}
						    |
						lv_value_5_2='false'
						{
							newLeafNode(lv_value_5_2, grammarAccess.getTerminalExpressionAccess().getValueFalseKeyword_2_1_0_1());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getTerminalExpressionRule());
							}
							setWithLastConsumed($current, "value", lv_value_5_2, null);
						}
					)
				)
			)
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getTerminalExpressionAccess().getVariableRefAction_3_0(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTerminalExpressionRule());
						}
					}
					otherlv_7=RULE_ID
					{
						newLeafNode(otherlv_7, grammarAccess.getTerminalExpressionAccess().getVariableVariableCrossReference_3_1_0());
					}
				)
			)
		)
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
