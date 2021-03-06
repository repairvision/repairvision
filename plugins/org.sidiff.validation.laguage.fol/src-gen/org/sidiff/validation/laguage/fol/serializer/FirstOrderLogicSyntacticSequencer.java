/*
 * generated by Xtext 2.21.0
 */
package org.sidiff.validation.laguage.fol.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.sidiff.validation.laguage.fol.services.FirstOrderLogicGrammarAccess;

@SuppressWarnings("all")
public class FirstOrderLogicSyntacticSequencer extends AbstractSyntacticSequencer {

	protected FirstOrderLogicGrammarAccess grammarAccess;
	protected AbstractElementAlias match_BooleanExpression_LeftParenthesisKeyword_0_0_a;
	protected AbstractElementAlias match_BooleanExpression_LeftParenthesisKeyword_0_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (FirstOrderLogicGrammarAccess) access;
		match_BooleanExpression_LeftParenthesisKeyword_0_0_a = new TokenAlias(true, true, grammarAccess.getBooleanExpressionAccess().getLeftParenthesisKeyword_0_0());
		match_BooleanExpression_LeftParenthesisKeyword_0_0_p = new TokenAlias(true, false, grammarAccess.getBooleanExpressionAccess().getLeftParenthesisKeyword_0_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_BooleanExpression_LeftParenthesisKeyword_0_0_a.equals(syntax))
				emit_BooleanExpression_LeftParenthesisKeyword_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_BooleanExpression_LeftParenthesisKeyword_0_0_p.equals(syntax))
				emit_BooleanExpression_LeftParenthesisKeyword_0_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'exists' '(' name=Variable
	 *     (rule start) (ambiguity) 'forAll' '(' name=Variable
	 *     (rule start) (ambiguity) 'isEmpty' '(' term=Term
	 *     (rule start) (ambiguity) 'isEqual' '(' left=Term
	 *     (rule start) (ambiguity) 'isGreater' '(' left=Term
	 *     (rule start) (ambiguity) 'isGreaterEqual' '(' left=Term
	 *     (rule start) (ambiguity) 'isInstanceOf' '(' term=Term
	 *     (rule start) (ambiguity) 'isSmaller' '(' left=Term
	 *     (rule start) (ambiguity) 'isSmallerEqual' '(' left=Term
	 *     (rule start) (ambiguity) 'isValueLiteralOf' '(' term=Term
	 *     (rule start) (ambiguity) 'not' '(' not=Formula
	 *     (rule start) (ambiguity) value=BOOLEAN
	 *     (rule start) (ambiguity) {And.left=}
	 *     (rule start) (ambiguity) {If.left=}
	 *     (rule start) (ambiguity) {Iff.left=}
	 *     (rule start) (ambiguity) {Or.left=}
	 *     (rule start) (ambiguity) {Xor.left=}
	 */
	protected void emit_BooleanExpression_LeftParenthesisKeyword_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) {And.left=}
	 *     (rule start) (ambiguity) {If.left=}
	 *     (rule start) (ambiguity) {Iff.left=}
	 *     (rule start) (ambiguity) {Or.left=}
	 *     (rule start) (ambiguity) {Xor.left=}
	 */
	protected void emit_BooleanExpression_LeftParenthesisKeyword_0_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
