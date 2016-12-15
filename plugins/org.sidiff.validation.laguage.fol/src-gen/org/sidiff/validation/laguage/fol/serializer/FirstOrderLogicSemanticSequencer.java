/*
 * generated by Xtext 2.10.0
 */
package org.sidiff.validation.laguage.fol.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.sidiff.validation.laguage.fol.firstOrderLogic.And;
import org.sidiff.validation.laguage.fol.firstOrderLogic.BoolConstant;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Constraint;
import org.sidiff.validation.laguage.fol.firstOrderLogic.ConstraintRuleBase;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Exists;
import org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage;
import org.sidiff.validation.laguage.fol.firstOrderLogic.ForAll;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Get;
import org.sidiff.validation.laguage.fol.firstOrderLogic.GetTerm;
import org.sidiff.validation.laguage.fol.firstOrderLogic.If;
import org.sidiff.validation.laguage.fol.firstOrderLogic.IntConstant;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Not;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Or;
import org.sidiff.validation.laguage.fol.firstOrderLogic.StringConstant;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Variable;
import org.sidiff.validation.laguage.fol.firstOrderLogic.VariableRef;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Xor;
import org.sidiff.validation.laguage.fol.services.FirstOrderLogicGrammarAccess;

@SuppressWarnings("all")
public class FirstOrderLogicSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private FirstOrderLogicGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == FirstOrderLogicPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case FirstOrderLogicPackage.AND:
				sequence_And(context, (And) semanticObject); 
				return; 
			case FirstOrderLogicPackage.BOOL_CONSTANT:
				sequence_TerminalExpression(context, (BoolConstant) semanticObject); 
				return; 
			case FirstOrderLogicPackage.CONSTRAINT:
				sequence_Constraint(context, (Constraint) semanticObject); 
				return; 
			case FirstOrderLogicPackage.CONSTRAINT_RULE_BASE:
				sequence_ConstraintRuleBase(context, (ConstraintRuleBase) semanticObject); 
				return; 
			case FirstOrderLogicPackage.EXISTS:
				sequence_Exists(context, (Exists) semanticObject); 
				return; 
			case FirstOrderLogicPackage.FOR_ALL:
				sequence_ForAll(context, (ForAll) semanticObject); 
				return; 
			case FirstOrderLogicPackage.GET:
				sequence_Get(context, (Get) semanticObject); 
				return; 
			case FirstOrderLogicPackage.GET_TERM:
				sequence_GetTerm(context, (GetTerm) semanticObject); 
				return; 
			case FirstOrderLogicPackage.IF:
				sequence_If(context, (If) semanticObject); 
				return; 
			case FirstOrderLogicPackage.INT_CONSTANT:
				sequence_TerminalExpression(context, (IntConstant) semanticObject); 
				return; 
			case FirstOrderLogicPackage.NOT:
				sequence_Not(context, (Not) semanticObject); 
				return; 
			case FirstOrderLogicPackage.OR:
				sequence_Or(context, (Or) semanticObject); 
				return; 
			case FirstOrderLogicPackage.STRING_CONSTANT:
				sequence_TerminalExpression(context, (StringConstant) semanticObject); 
				return; 
			case FirstOrderLogicPackage.VARIABLE:
				sequence_Variable(context, (Variable) semanticObject); 
				return; 
			case FirstOrderLogicPackage.VARIABLE_REF:
				sequence_TerminalExpression(context, (VariableRef) semanticObject); 
				return; 
			case FirstOrderLogicPackage.XOR:
				sequence_Xor(context, (Xor) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Formula returns And
	 *     BinaryFormula returns And
	 *     If returns And
	 *     If.If_1_0 returns And
	 *     Xor returns And
	 *     Xor.Xor_1_0 returns And
	 *     Or returns And
	 *     Or.Or_1_0 returns And
	 *     And returns And
	 *     And.And_1_0 returns And
	 *     Primary returns And
	 *
	 * Constraint:
	 *     (left=And_And_1_0 right=Primary)
	 */
	protected void sequence_And(ISerializationContext context, And semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.AND__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.AND__LEFT));
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.AND__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.AND__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAndAccess().getAndLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAndAccess().getRightPrimaryParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ConstraintRuleBase returns ConstraintRuleBase
	 *
	 * Constraint:
	 *     (domain=STRING constraints+=Constraint)
	 */
	protected void sequence_ConstraintRuleBase(ISerializationContext context, ConstraintRuleBase semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Constraint returns Constraint
	 *
	 * Constraint:
	 *     (variable=Variable formula=Formula)
	 */
	protected void sequence_Constraint(ISerializationContext context, Constraint semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.CONSTRAINT__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.CONSTRAINT__VARIABLE));
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.CONSTRAINT__FORMULA) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.CONSTRAINT__FORMULA));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConstraintAccess().getVariableVariableParserRuleCall_1_0(), semanticObject.getVariable());
		feeder.accept(grammarAccess.getConstraintAccess().getFormulaFormulaParserRuleCall_3_0(), semanticObject.getFormula());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns Exists
	 *     BinaryFormula returns Exists
	 *     If returns Exists
	 *     If.If_1_0 returns Exists
	 *     Xor returns Exists
	 *     Xor.Xor_1_0 returns Exists
	 *     Or returns Exists
	 *     Or.Or_1_0 returns Exists
	 *     And returns Exists
	 *     And.And_1_0 returns Exists
	 *     Quantifier returns Exists
	 *     Exists returns Exists
	 *     Primary returns Exists
	 *
	 * Constraint:
	 *     (name=Variable iteration=Term formula=Formula)
	 */
	protected void sequence_Exists(ISerializationContext context, Exists semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.QUANTIFIER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.QUANTIFIER__NAME));
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.QUANTIFIER__ITERATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.QUANTIFIER__ITERATION));
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.QUANTIFIER__FORMULA) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.QUANTIFIER__FORMULA));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getExistsAccess().getNameVariableParserRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getExistsAccess().getIterationTermParserRuleCall_4_0(), semanticObject.getIteration());
		feeder.accept(grammarAccess.getExistsAccess().getFormulaFormulaParserRuleCall_6_0(), semanticObject.getFormula());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns ForAll
	 *     BinaryFormula returns ForAll
	 *     If returns ForAll
	 *     If.If_1_0 returns ForAll
	 *     Xor returns ForAll
	 *     Xor.Xor_1_0 returns ForAll
	 *     Or returns ForAll
	 *     Or.Or_1_0 returns ForAll
	 *     And returns ForAll
	 *     And.And_1_0 returns ForAll
	 *     Quantifier returns ForAll
	 *     ForAll returns ForAll
	 *     Primary returns ForAll
	 *
	 * Constraint:
	 *     (name=Variable iteration=Term formula=Formula)
	 */
	protected void sequence_ForAll(ISerializationContext context, ForAll semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.QUANTIFIER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.QUANTIFIER__NAME));
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.QUANTIFIER__ITERATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.QUANTIFIER__ITERATION));
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.QUANTIFIER__FORMULA) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.QUANTIFIER__FORMULA));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getForAllAccess().getNameVariableParserRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getForAllAccess().getIterationTermParserRuleCall_4_0(), semanticObject.getIteration());
		feeder.accept(grammarAccess.getForAllAccess().getFormulaFormulaParserRuleCall_6_0(), semanticObject.getFormula());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Term returns GetTerm
	 *     Function returns GetTerm
	 *     GetTerm returns GetTerm
	 *
	 * Constraint:
	 *     (name=[Variable|ID] feature=Get?)
	 */
	protected void sequence_GetTerm(ISerializationContext context, GetTerm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Get returns Get
	 *
	 * Constraint:
	 *     (type=ID? name=[EStructuralFeature|Feature] next=Get?)
	 */
	protected void sequence_Get(ISerializationContext context, Get semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns If
	 *     BinaryFormula returns If
	 *     If returns If
	 *     If.If_1_0 returns If
	 *     Xor returns If
	 *     Xor.Xor_1_0 returns If
	 *     Or returns If
	 *     Or.Or_1_0 returns If
	 *     And returns If
	 *     And.And_1_0 returns If
	 *     Primary returns If
	 *
	 * Constraint:
	 *     (left=If_If_1_0 right=Xor)
	 */
	protected void sequence_If(ISerializationContext context, If semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.IF__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.IF__LEFT));
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.IF__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.IF__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIfAccess().getIfLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getIfAccess().getRightXorParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns Not
	 *     BinaryFormula returns Not
	 *     If returns Not
	 *     If.If_1_0 returns Not
	 *     Xor returns Not
	 *     Xor.Xor_1_0 returns Not
	 *     Or returns Not
	 *     Or.Or_1_0 returns Not
	 *     And returns Not
	 *     And.And_1_0 returns Not
	 *     UnaryFormula returns Not
	 *     Not returns Not
	 *     Primary returns Not
	 *
	 * Constraint:
	 *     not=Formula
	 */
	protected void sequence_Not(ISerializationContext context, Not semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.NOT__NOT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.NOT__NOT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNotAccess().getNotFormulaParserRuleCall_2_0(), semanticObject.getNot());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns Or
	 *     BinaryFormula returns Or
	 *     If returns Or
	 *     If.If_1_0 returns Or
	 *     Xor returns Or
	 *     Xor.Xor_1_0 returns Or
	 *     Or returns Or
	 *     Or.Or_1_0 returns Or
	 *     And returns Or
	 *     And.And_1_0 returns Or
	 *     Primary returns Or
	 *
	 * Constraint:
	 *     (left=Or_Or_1_0 right=And)
	 */
	protected void sequence_Or(ISerializationContext context, Or semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.OR__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.OR__LEFT));
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.OR__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.OR__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOrAccess().getOrLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns BoolConstant
	 *     BinaryFormula returns BoolConstant
	 *     If returns BoolConstant
	 *     If.If_1_0 returns BoolConstant
	 *     Xor returns BoolConstant
	 *     Xor.Xor_1_0 returns BoolConstant
	 *     Or returns BoolConstant
	 *     Or.Or_1_0 returns BoolConstant
	 *     And returns BoolConstant
	 *     And.And_1_0 returns BoolConstant
	 *     Primary returns BoolConstant
	 *     TerminalExpression returns BoolConstant
	 *
	 * Constraint:
	 *     (value='true' | value='false')
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, BoolConstant semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns IntConstant
	 *     BinaryFormula returns IntConstant
	 *     If returns IntConstant
	 *     If.If_1_0 returns IntConstant
	 *     Xor returns IntConstant
	 *     Xor.Xor_1_0 returns IntConstant
	 *     Or returns IntConstant
	 *     Or.Or_1_0 returns IntConstant
	 *     And returns IntConstant
	 *     And.And_1_0 returns IntConstant
	 *     Primary returns IntConstant
	 *     TerminalExpression returns IntConstant
	 *
	 * Constraint:
	 *     value=INT
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, IntConstant semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.INT_CONSTANT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.INT_CONSTANT__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getValueINTTerminalRuleCall_0_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns StringConstant
	 *     BinaryFormula returns StringConstant
	 *     If returns StringConstant
	 *     If.If_1_0 returns StringConstant
	 *     Xor returns StringConstant
	 *     Xor.Xor_1_0 returns StringConstant
	 *     Or returns StringConstant
	 *     Or.Or_1_0 returns StringConstant
	 *     And returns StringConstant
	 *     And.And_1_0 returns StringConstant
	 *     Primary returns StringConstant
	 *     TerminalExpression returns StringConstant
	 *
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, StringConstant semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.STRING_CONSTANT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.STRING_CONSTANT__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getValueSTRINGTerminalRuleCall_1_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns VariableRef
	 *     BinaryFormula returns VariableRef
	 *     If returns VariableRef
	 *     If.If_1_0 returns VariableRef
	 *     Xor returns VariableRef
	 *     Xor.Xor_1_0 returns VariableRef
	 *     Or returns VariableRef
	 *     Or.Or_1_0 returns VariableRef
	 *     And returns VariableRef
	 *     And.And_1_0 returns VariableRef
	 *     Primary returns VariableRef
	 *     TerminalExpression returns VariableRef
	 *
	 * Constraint:
	 *     variable=[Variable|ID]
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, VariableRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.VARIABLE_REF__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.VARIABLE_REF__VARIABLE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getVariableVariableIDTerminalRuleCall_3_1_0_1(), semanticObject.getVariable());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Variable returns Variable
	 *
	 * Constraint:
	 *     (type=ID name=ID)
	 */
	protected void sequence_Variable(ISerializationContext context, Variable semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.VARIABLE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.VARIABLE__TYPE));
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.VARIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.VARIABLE__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVariableAccess().getTypeIDTerminalRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns Xor
	 *     BinaryFormula returns Xor
	 *     If returns Xor
	 *     If.If_1_0 returns Xor
	 *     Xor returns Xor
	 *     Xor.Xor_1_0 returns Xor
	 *     Or returns Xor
	 *     Or.Or_1_0 returns Xor
	 *     And returns Xor
	 *     And.And_1_0 returns Xor
	 *     Primary returns Xor
	 *
	 * Constraint:
	 *     (left=Xor_Xor_1_0 right=Or)
	 */
	protected void sequence_Xor(ISerializationContext context, Xor semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.XOR__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.XOR__LEFT));
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.XOR__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.XOR__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXorAccess().getXorLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getXorAccess().getRightOrParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
}
