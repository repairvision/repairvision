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
    	return "ConstraintRuleBase";
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

// Entry rule entryRuleConstraintRuleBase
entryRuleConstraintRuleBase returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConstraintRuleBaseRule()); }
	iv_ruleConstraintRuleBase=ruleConstraintRuleBase
	{ $current=$iv_ruleConstraintRuleBase.current; }
	EOF;

// Rule ConstraintRuleBase
ruleConstraintRuleBase returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='domain'
		{
			newLeafNode(otherlv_0, grammarAccess.getConstraintRuleBaseAccess().getDomainKeyword_0());
		}
		(
			(
				lv_domain_1_0=RULE_STRING
				{
					newLeafNode(lv_domain_1_0, grammarAccess.getConstraintRuleBaseAccess().getDomainSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConstraintRuleBaseRule());
					}
					setWithLastConsumed(
						$current,
						"domain",
						lv_domain_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getConstraintRuleBaseAccess().getConstraintsConstraintParserRuleCall_2_0());
				}
				lv_constraints_2_0=ruleConstraint
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConstraintRuleBaseRule());
					}
					add(
						$current,
						"constraints",
						lv_constraints_2_0,
						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Constraint");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleConstraint
entryRuleConstraint returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConstraintRule()); }
	iv_ruleConstraint=ruleConstraint
	{ $current=$iv_ruleConstraint.current; }
	EOF;

// Rule Constraint
ruleConstraint returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='context'
		{
			newLeafNode(otherlv_0, grammarAccess.getConstraintAccess().getContextKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getConstraintAccess().getVariableVariableParserRuleCall_1_0());
				}
				lv_variable_1_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConstraintRule());
					}
					set(
						$current,
						"variable",
						lv_variable_1_0,
						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=':'
		{
			newLeafNode(otherlv_2, grammarAccess.getConstraintAccess().getColonKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getConstraintAccess().getFormulaFormulaParserRuleCall_3_0());
				}
				lv_formula_3_0=ruleFormula
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConstraintRule());
					}
					set(
						$current,
						"formula",
						lv_formula_3_0,
						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
					afterParserOrEnumRuleCall();
				}
			)
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
	(
		{
			newCompositeNode(grammarAccess.getTermAccess().getVariableParserRuleCall_0());
		}
		this_Variable_0=ruleVariable
		{
			$current = $this_Variable_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTermAccess().getFunctionParserRuleCall_1());
		}
		this_Function_1=ruleFunction
		{
			$current = $this_Function_1.current;
			afterParserOrEnumRuleCall();
		}
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
			(
				lv_type_0_0=RULE_ID
				{
					newLeafNode(lv_type_0_0, grammarAccess.getVariableAccess().getTypeIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getVariableRule());
					}
					setWithLastConsumed(
						$current,
						"type",
						lv_type_0_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getVariableRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
	)
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
		newCompositeNode(grammarAccess.getFunctionAccess().getGetTermParserRuleCall());
	}
	this_GetTerm_0=ruleGetTerm
	{
		$current = $this_GetTerm_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleGetTerm
entryRuleGetTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGetTermRule()); }
	iv_ruleGetTerm=ruleGetTerm
	{ $current=$iv_ruleGetTerm.current; }
	EOF;

// Rule GetTerm
ruleGetTerm returns [EObject current=null]
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
					grammarAccess.getGetTermAccess().getGetTermAction_0(),
					$current);
			}
		)
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getGetTermRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getGetTermAccess().getNameVariableCrossReference_1_0());
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getGetTermAccess().getFeatureGetParserRuleCall_2_0());
				}
				lv_feature_2_0=ruleGet
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getGetTermRule());
					}
					set(
						$current,
						"feature",
						lv_feature_2_0,
						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Get");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
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
		otherlv_0='.'
		{
			newLeafNode(otherlv_0, grammarAccess.getGetAccess().getFullStopKeyword_0());
		}
		(
			(
				(
					lv_type_1_0=RULE_ID
					{
						newLeafNode(lv_type_1_0, grammarAccess.getGetAccess().getTypeIDTerminalRuleCall_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getGetRule());
						}
						setWithLastConsumed(
							$current,
							"type",
							lv_type_1_0,
							"org.eclipse.xtext.common.Terminals.ID");
					}
				)
			)
			otherlv_2='::'
			{
				newLeafNode(otherlv_2, grammarAccess.getGetAccess().getColonColonKeyword_1_1());
			}
		)?
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getGetRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0());
				}
				ruleFeature
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getGetAccess().getNextGetParserRuleCall_3_0());
				}
				lv_next_4_0=ruleGet
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getGetRule());
					}
					set(
						$current,
						"next",
						lv_next_4_0,
						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Get");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;

// Entry rule entryRuleFeature
entryRuleFeature returns [String current=null]:
	{ newCompositeNode(grammarAccess.getFeatureRule()); }
	iv_ruleFeature=ruleFeature
	{ $current=$iv_ruleFeature.current.getText(); }
	EOF;

// Rule Feature
ruleFeature returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_ID_0=RULE_ID
	{
		$current.merge(this_ID_0);
	}
	{
		newLeafNode(this_ID_0, grammarAccess.getFeatureAccess().getIDTerminalRuleCall());
	}
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
		newCompositeNode(grammarAccess.getFormulaAccess().getEqualityParserRuleCall());
	}
	this_Equality_0=ruleEquality
	{
		$current = $this_Equality_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleEquality
entryRuleEquality returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEqualityRule()); }
	iv_ruleEquality=ruleEquality
	{ $current=$iv_ruleEquality.current; }
	EOF;

// Rule Equality
ruleEquality returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getEqualityAccess().getBinaryFormulaParserRuleCall_0());
		}
		this_BinaryFormula_0=ruleBinaryFormula
		{
			$current = $this_BinaryFormula_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0(),
						$current);
				}
			)
			otherlv_2='='
			{
				newLeafNode(otherlv_2, grammarAccess.getEqualityAccess().getEqualsSignKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEqualityAccess().getRightBinaryFormulaParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleBinaryFormula
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEqualityRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.sidiff.validation.laguage.fol.FirstOrderLogic.BinaryFormula");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
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
			newCompositeNode(grammarAccess.getAndAccess().getGreaterParserRuleCall_0());
		}
		this_Greater_0=ruleGreater
		{
			$current = $this_Greater_0.current;
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
						newCompositeNode(grammarAccess.getAndAccess().getRightGreaterParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleGreater
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAndRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.sidiff.validation.laguage.fol.FirstOrderLogic.Greater");
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

// Entry rule entryRulePredicate
entryRulePredicate returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPredicateRule()); }
	iv_rulePredicate=rulePredicate
	{ $current=$iv_rulePredicate.current; }
	EOF;

// Rule Predicate
rulePredicate returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getPredicateAccess().getIsEmptyParserRuleCall());
	}
	this_IsEmpty_0=ruleIsEmpty
	{
		$current = $this_IsEmpty_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleIsEmpty
entryRuleIsEmpty returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIsEmptyRule()); }
	iv_ruleIsEmpty=ruleIsEmpty
	{ $current=$iv_ruleIsEmpty.current; }
	EOF;

// Rule IsEmpty
ruleIsEmpty returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='isEmpty('
		{
			newLeafNode(otherlv_0, grammarAccess.getIsEmptyAccess().getIsEmptyKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getIsEmptyRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getIsEmptyAccess().getTermTermCrossReference_1_0());
				}
			)
		)
		otherlv_2=')'
		{
			newLeafNode(otherlv_2, grammarAccess.getIsEmptyAccess().getRightParenthesisKeyword_2());
		}
	)
;

// Entry rule entryRuleGreater
entryRuleGreater returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGreaterRule()); }
	iv_ruleGreater=ruleGreater
	{ $current=$iv_ruleGreater.current; }
	EOF;

// Rule Greater
ruleGreater returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getGreaterAccess().getGreaterEqualParserRuleCall_0());
		}
		this_GreaterEqual_0=ruleGreaterEqual
		{
			$current = $this_GreaterEqual_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getGreaterAccess().getGreaterLeftAction_1_0(),
						$current);
				}
			)
			otherlv_2='>'
			{
				newLeafNode(otherlv_2, grammarAccess.getGreaterAccess().getGreaterThanSignKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getGreaterAccess().getRightGreaterEqualParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleGreaterEqual
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getGreaterRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.sidiff.validation.laguage.fol.FirstOrderLogic.GreaterEqual");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleGreaterEqual
entryRuleGreaterEqual returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGreaterEqualRule()); }
	iv_ruleGreaterEqual=ruleGreaterEqual
	{ $current=$iv_ruleGreaterEqual.current; }
	EOF;

// Rule GreaterEqual
ruleGreaterEqual returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getGreaterEqualAccess().getSmallerParserRuleCall_0());
		}
		this_Smaller_0=ruleSmaller
		{
			$current = $this_Smaller_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getGreaterEqualAccess().getGreaterEqualLeftAction_1_0(),
						$current);
				}
			)
			otherlv_2='>='
			{
				newLeafNode(otherlv_2, grammarAccess.getGreaterEqualAccess().getGreaterThanSignEqualsSignKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getGreaterEqualAccess().getRightSmallerParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleSmaller
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getGreaterEqualRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.sidiff.validation.laguage.fol.FirstOrderLogic.Smaller");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleSmaller
entryRuleSmaller returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSmallerRule()); }
	iv_ruleSmaller=ruleSmaller
	{ $current=$iv_ruleSmaller.current; }
	EOF;

// Rule Smaller
ruleSmaller returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getSmallerAccess().getSmallerEqualParserRuleCall_0());
		}
		this_SmallerEqual_0=ruleSmallerEqual
		{
			$current = $this_SmallerEqual_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getSmallerAccess().getSmallerLeftAction_1_0(),
						$current);
				}
			)
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getSmallerAccess().getLessThanSignKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSmallerAccess().getRightSmallerEqualParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleSmallerEqual
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSmallerRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.sidiff.validation.laguage.fol.FirstOrderLogic.SmallerEqual");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleSmallerEqual
entryRuleSmallerEqual returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSmallerEqualRule()); }
	iv_ruleSmallerEqual=ruleSmallerEqual
	{ $current=$iv_ruleSmallerEqual.current; }
	EOF;

// Rule SmallerEqual
ruleSmallerEqual returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getSmallerEqualAccess().getPrimaryParserRuleCall_0());
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
						grammarAccess.getSmallerEqualAccess().getSmallerEqualLeftAction_1_0(),
						$current);
				}
			)
			otherlv_2='<='
			{
				newLeafNode(otherlv_2, grammarAccess.getSmallerEqualAccess().getLessThanSignEqualsSignKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSmallerEqualAccess().getRightPrimaryParserRuleCall_1_2_0());
					}
					lv_right_3_0=rulePrimary
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSmallerEqualRule());
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
					newCompositeNode(grammarAccess.getForAllAccess().getNameVariableParserRuleCall_2_0());
				}
				lv_name_2_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getForAllRule());
					}
					set(
						$current,
						"name",
						lv_name_2_0,
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
					newCompositeNode(grammarAccess.getExistsAccess().getNameVariableParserRuleCall_2_0());
				}
				lv_name_2_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getExistsRule());
					}
					set(
						$current,
						"name",
						lv_name_2_0,
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
			newCompositeNode(grammarAccess.getPrimaryAccess().getPredicateParserRuleCall_3());
		}
		this_Predicate_5=rulePredicate
		{
			$current = $this_Predicate_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPrimaryAccess().getConstantParserRuleCall_4());
		}
		this_Constant_6=ruleConstant
		{
			$current = $this_Constant_6.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleConstant
entryRuleConstant returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConstantRule()); }
	iv_ruleConstant=ruleConstant
	{ $current=$iv_ruleConstant.current; }
	EOF;

// Rule Constant
ruleConstant returns [EObject current=null]
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
						grammarAccess.getConstantAccess().getIntConstantAction_0_0(),
						$current);
				}
			)
			(
				(
					lv_value_1_0=RULE_INT
					{
						newLeafNode(lv_value_1_0, grammarAccess.getConstantAccess().getValueINTTerminalRuleCall_0_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getConstantRule());
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
						grammarAccess.getConstantAccess().getStringConstantAction_1_0(),
						$current);
				}
			)
			(
				(
					lv_value_3_0=RULE_STRING
					{
						newLeafNode(lv_value_3_0, grammarAccess.getConstantAccess().getValueSTRINGTerminalRuleCall_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getConstantRule());
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
						grammarAccess.getConstantAccess().getBoolConstantAction_2_0(),
						$current);
				}
			)
			(
				(
					(
						lv_value_5_1='true'
						{
							newLeafNode(lv_value_5_1, grammarAccess.getConstantAccess().getValueTrueKeyword_2_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getConstantRule());
							}
							setWithLastConsumed($current, "value", lv_value_5_1, null);
						}
						    |
						lv_value_5_2='false'
						{
							newLeafNode(lv_value_5_2, grammarAccess.getConstantAccess().getValueFalseKeyword_2_1_0_1());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getConstantRule());
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
						grammarAccess.getConstantAccess().getVariableRefAction_3_0(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getConstantRule());
						}
					}
					otherlv_7=RULE_ID
					{
						newLeafNode(otherlv_7, grammarAccess.getConstantAccess().getVariableVariableCrossReference_3_1_0());
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
