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
import org.sidiff.validation.laguage.fol.firstOrderLogic.Equality;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Exists;
import org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage;
import org.sidiff.validation.laguage.fol.firstOrderLogic.ForAll;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Get;
import org.sidiff.validation.laguage.fol.firstOrderLogic.GetTerm;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Greater;
import org.sidiff.validation.laguage.fol.firstOrderLogic.GreaterEqual;
import org.sidiff.validation.laguage.fol.firstOrderLogic.If;
import org.sidiff.validation.laguage.fol.firstOrderLogic.IntConstant;
import org.sidiff.validation.laguage.fol.firstOrderLogic.IsEmpty;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Not;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Or;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Smaller;
import org.sidiff.validation.laguage.fol.firstOrderLogic.SmallerEqual;
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
				sequence_Constant(context, (BoolConstant) semanticObject); 
				return; 
			case FirstOrderLogicPackage.CONSTRAINT:
				sequence_Constraint(context, (Constraint) semanticObject); 
				return; 
			case FirstOrderLogicPackage.CONSTRAINT_RULE_BASE:
				sequence_ConstraintRuleBase(context, (ConstraintRuleBase) semanticObject); 
				return; 
			case FirstOrderLogicPackage.EQUALITY:
				sequence_Equality(context, (Equality) semanticObject); 
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
			case FirstOrderLogicPackage.GREATER:
				sequence_Greater(context, (Greater) semanticObject); 
				return; 
			case FirstOrderLogicPackage.GREATER_EQUAL:
				sequence_GreaterEqual(context, (GreaterEqual) semanticObject); 
				return; 
			case FirstOrderLogicPackage.IF:
				sequence_If(context, (If) semanticObject); 
				return; 
			case FirstOrderLogicPackage.INT_CONSTANT:
				sequence_Constant(context, (IntConstant) semanticObject); 
				return; 
			case FirstOrderLogicPackage.IS_EMPTY:
				sequence_IsEmpty(context, (IsEmpty) semanticObject); 
				return; 
			case FirstOrderLogicPackage.NOT:
				sequence_Not(context, (Not) semanticObject); 
				return; 
			case FirstOrderLogicPackage.OR:
				sequence_Or(context, (Or) semanticObject); 
				return; 
			case FirstOrderLogicPackage.SMALLER:
				sequence_Smaller(context, (Smaller) semanticObject); 
				return; 
			case FirstOrderLogicPackage.SMALLER_EQUAL:
				sequence_SmallerEqual(context, (SmallerEqual) semanticObject); 
				return; 
			case FirstOrderLogicPackage.STRING_CONSTANT:
				sequence_Constant(context, (StringConstant) semanticObject); 
				return; 
			case FirstOrderLogicPackage.VARIABLE:
				sequence_Variable(context, (Variable) semanticObject); 
				return; 
			case FirstOrderLogicPackage.VARIABLE_REF:
				sequence_Constant(context, (VariableRef) semanticObject); 
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
	 *     Equality returns And
	 *     Equality.Equality_1_0 returns And
	 *     BinaryFormula returns And
	 *     If returns And
	 *     If.If_1_0 returns And
	 *     Xor returns And
	 *     Xor.Xor_1_0 returns And
	 *     Or returns And
	 *     Or.Or_1_0 returns And
	 *     And returns And
	 *     And.And_1_0 returns And
	 *     Greater returns And
	 *     Greater.Greater_1_0 returns And
	 *     GreaterEqual returns And
	 *     GreaterEqual.GreaterEqual_1_0 returns And
	 *     Smaller returns And
	 *     Smaller.Smaller_1_0 returns And
	 *     SmallerEqual returns And
	 *     SmallerEqual.SmallerEqual_1_0 returns And
	 *     Primary returns And
	 *
	 * Constraint:
	 *     (left=And_And_1_0 right=Greater)
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
		feeder.accept(grammarAccess.getAndAccess().getRightGreaterParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns BoolConstant
	 *     Equality returns BoolConstant
	 *     Equality.Equality_1_0 returns BoolConstant
	 *     BinaryFormula returns BoolConstant
	 *     If returns BoolConstant
	 *     If.If_1_0 returns BoolConstant
	 *     Xor returns BoolConstant
	 *     Xor.Xor_1_0 returns BoolConstant
	 *     Or returns BoolConstant
	 *     Or.Or_1_0 returns BoolConstant
	 *     And returns BoolConstant
	 *     And.And_1_0 returns BoolConstant
	 *     Greater returns BoolConstant
	 *     Greater.Greater_1_0 returns BoolConstant
	 *     GreaterEqual returns BoolConstant
	 *     GreaterEqual.GreaterEqual_1_0 returns BoolConstant
	 *     Smaller returns BoolConstant
	 *     Smaller.Smaller_1_0 returns BoolConstant
	 *     SmallerEqual returns BoolConstant
	 *     SmallerEqual.SmallerEqual_1_0 returns BoolConstant
	 *     Primary returns BoolConstant
	 *     Constant returns BoolConstant
	 *
	 * Constraint:
	 *     (value='true' | value='false')
	 */
	protected void sequence_Constant(ISerializationContext context, BoolConstant semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns IntConstant
	 *     Equality returns IntConstant
	 *     Equality.Equality_1_0 returns IntConstant
	 *     BinaryFormula returns IntConstant
	 *     If returns IntConstant
	 *     If.If_1_0 returns IntConstant
	 *     Xor returns IntConstant
	 *     Xor.Xor_1_0 returns IntConstant
	 *     Or returns IntConstant
	 *     Or.Or_1_0 returns IntConstant
	 *     And returns IntConstant
	 *     And.And_1_0 returns IntConstant
	 *     Greater returns IntConstant
	 *     Greater.Greater_1_0 returns IntConstant
	 *     GreaterEqual returns IntConstant
	 *     GreaterEqual.GreaterEqual_1_0 returns IntConstant
	 *     Smaller returns IntConstant
	 *     Smaller.Smaller_1_0 returns IntConstant
	 *     SmallerEqual returns IntConstant
	 *     SmallerEqual.SmallerEqual_1_0 returns IntConstant
	 *     Primary returns IntConstant
	 *     Constant returns IntConstant
	 *
	 * Constraint:
	 *     value=INT
	 */
	protected void sequence_Constant(ISerializationContext context, IntConstant semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.INT_CONSTANT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.INT_CONSTANT__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConstantAccess().getValueINTTerminalRuleCall_0_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns StringConstant
	 *     Equality returns StringConstant
	 *     Equality.Equality_1_0 returns StringConstant
	 *     BinaryFormula returns StringConstant
	 *     If returns StringConstant
	 *     If.If_1_0 returns StringConstant
	 *     Xor returns StringConstant
	 *     Xor.Xor_1_0 returns StringConstant
	 *     Or returns StringConstant
	 *     Or.Or_1_0 returns StringConstant
	 *     And returns StringConstant
	 *     And.And_1_0 returns StringConstant
	 *     Greater returns StringConstant
	 *     Greater.Greater_1_0 returns StringConstant
	 *     GreaterEqual returns StringConstant
	 *     GreaterEqual.GreaterEqual_1_0 returns StringConstant
	 *     Smaller returns StringConstant
	 *     Smaller.Smaller_1_0 returns StringConstant
	 *     SmallerEqual returns StringConstant
	 *     SmallerEqual.SmallerEqual_1_0 returns StringConstant
	 *     Primary returns StringConstant
	 *     Constant returns StringConstant
	 *
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_Constant(ISerializationContext context, StringConstant semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.STRING_CONSTANT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.STRING_CONSTANT__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConstantAccess().getValueSTRINGTerminalRuleCall_1_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns VariableRef
	 *     Equality returns VariableRef
	 *     Equality.Equality_1_0 returns VariableRef
	 *     BinaryFormula returns VariableRef
	 *     If returns VariableRef
	 *     If.If_1_0 returns VariableRef
	 *     Xor returns VariableRef
	 *     Xor.Xor_1_0 returns VariableRef
	 *     Or returns VariableRef
	 *     Or.Or_1_0 returns VariableRef
	 *     And returns VariableRef
	 *     And.And_1_0 returns VariableRef
	 *     Greater returns VariableRef
	 *     Greater.Greater_1_0 returns VariableRef
	 *     GreaterEqual returns VariableRef
	 *     GreaterEqual.GreaterEqual_1_0 returns VariableRef
	 *     Smaller returns VariableRef
	 *     Smaller.Smaller_1_0 returns VariableRef
	 *     SmallerEqual returns VariableRef
	 *     SmallerEqual.SmallerEqual_1_0 returns VariableRef
	 *     Primary returns VariableRef
	 *     Constant returns VariableRef
	 *
	 * Constraint:
	 *     variable=[Variable|ID]
	 */
	protected void sequence_Constant(ISerializationContext context, VariableRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.VARIABLE_REF__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.VARIABLE_REF__VARIABLE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConstantAccess().getVariableVariableIDTerminalRuleCall_3_1_0_1(), semanticObject.getVariable());
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
	 *     Formula returns Equality
	 *     Equality returns Equality
	 *     Equality.Equality_1_0 returns Equality
	 *     BinaryFormula returns Equality
	 *     If returns Equality
	 *     If.If_1_0 returns Equality
	 *     Xor returns Equality
	 *     Xor.Xor_1_0 returns Equality
	 *     Or returns Equality
	 *     Or.Or_1_0 returns Equality
	 *     And returns Equality
	 *     And.And_1_0 returns Equality
	 *     Greater returns Equality
	 *     Greater.Greater_1_0 returns Equality
	 *     GreaterEqual returns Equality
	 *     GreaterEqual.GreaterEqual_1_0 returns Equality
	 *     Smaller returns Equality
	 *     Smaller.Smaller_1_0 returns Equality
	 *     SmallerEqual returns Equality
	 *     SmallerEqual.SmallerEqual_1_0 returns Equality
	 *     Primary returns Equality
	 *
	 * Constraint:
	 *     (left=Equality_Equality_1_0 right=BinaryFormula)
	 */
	protected void sequence_Equality(ISerializationContext context, Equality semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.EQUALITY__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.EQUALITY__LEFT));
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.EQUALITY__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.EQUALITY__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getEqualityAccess().getRightBinaryFormulaParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns Exists
	 *     Equality returns Exists
	 *     Equality.Equality_1_0 returns Exists
	 *     BinaryFormula returns Exists
	 *     If returns Exists
	 *     If.If_1_0 returns Exists
	 *     Xor returns Exists
	 *     Xor.Xor_1_0 returns Exists
	 *     Or returns Exists
	 *     Or.Or_1_0 returns Exists
	 *     And returns Exists
	 *     And.And_1_0 returns Exists
	 *     Greater returns Exists
	 *     Greater.Greater_1_0 returns Exists
	 *     GreaterEqual returns Exists
	 *     GreaterEqual.GreaterEqual_1_0 returns Exists
	 *     Smaller returns Exists
	 *     Smaller.Smaller_1_0 returns Exists
	 *     SmallerEqual returns Exists
	 *     SmallerEqual.SmallerEqual_1_0 returns Exists
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
	 *     Equality returns ForAll
	 *     Equality.Equality_1_0 returns ForAll
	 *     BinaryFormula returns ForAll
	 *     If returns ForAll
	 *     If.If_1_0 returns ForAll
	 *     Xor returns ForAll
	 *     Xor.Xor_1_0 returns ForAll
	 *     Or returns ForAll
	 *     Or.Or_1_0 returns ForAll
	 *     And returns ForAll
	 *     And.And_1_0 returns ForAll
	 *     Greater returns ForAll
	 *     Greater.Greater_1_0 returns ForAll
	 *     GreaterEqual returns ForAll
	 *     GreaterEqual.GreaterEqual_1_0 returns ForAll
	 *     Smaller returns ForAll
	 *     Smaller.Smaller_1_0 returns ForAll
	 *     SmallerEqual returns ForAll
	 *     SmallerEqual.SmallerEqual_1_0 returns ForAll
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
	 *     Formula returns GreaterEqual
	 *     Equality returns GreaterEqual
	 *     Equality.Equality_1_0 returns GreaterEqual
	 *     BinaryFormula returns GreaterEqual
	 *     If returns GreaterEqual
	 *     If.If_1_0 returns GreaterEqual
	 *     Xor returns GreaterEqual
	 *     Xor.Xor_1_0 returns GreaterEqual
	 *     Or returns GreaterEqual
	 *     Or.Or_1_0 returns GreaterEqual
	 *     And returns GreaterEqual
	 *     And.And_1_0 returns GreaterEqual
	 *     Greater returns GreaterEqual
	 *     Greater.Greater_1_0 returns GreaterEqual
	 *     GreaterEqual returns GreaterEqual
	 *     GreaterEqual.GreaterEqual_1_0 returns GreaterEqual
	 *     Smaller returns GreaterEqual
	 *     Smaller.Smaller_1_0 returns GreaterEqual
	 *     SmallerEqual returns GreaterEqual
	 *     SmallerEqual.SmallerEqual_1_0 returns GreaterEqual
	 *     Primary returns GreaterEqual
	 *
	 * Constraint:
	 *     (left=GreaterEqual_GreaterEqual_1_0 right=Smaller)
	 */
	protected void sequence_GreaterEqual(ISerializationContext context, GreaterEqual semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.GREATER_EQUAL__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.GREATER_EQUAL__LEFT));
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.GREATER_EQUAL__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.GREATER_EQUAL__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGreaterEqualAccess().getGreaterEqualLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getGreaterEqualAccess().getRightSmallerParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns Greater
	 *     Equality returns Greater
	 *     Equality.Equality_1_0 returns Greater
	 *     BinaryFormula returns Greater
	 *     If returns Greater
	 *     If.If_1_0 returns Greater
	 *     Xor returns Greater
	 *     Xor.Xor_1_0 returns Greater
	 *     Or returns Greater
	 *     Or.Or_1_0 returns Greater
	 *     And returns Greater
	 *     And.And_1_0 returns Greater
	 *     Greater returns Greater
	 *     Greater.Greater_1_0 returns Greater
	 *     GreaterEqual returns Greater
	 *     GreaterEqual.GreaterEqual_1_0 returns Greater
	 *     Smaller returns Greater
	 *     Smaller.Smaller_1_0 returns Greater
	 *     SmallerEqual returns Greater
	 *     SmallerEqual.SmallerEqual_1_0 returns Greater
	 *     Primary returns Greater
	 *
	 * Constraint:
	 *     (left=Greater_Greater_1_0 right=GreaterEqual)
	 */
	protected void sequence_Greater(ISerializationContext context, Greater semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.GREATER__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.GREATER__LEFT));
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.GREATER__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.GREATER__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGreaterAccess().getGreaterLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getGreaterAccess().getRightGreaterEqualParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns If
	 *     Equality returns If
	 *     Equality.Equality_1_0 returns If
	 *     BinaryFormula returns If
	 *     If returns If
	 *     If.If_1_0 returns If
	 *     Xor returns If
	 *     Xor.Xor_1_0 returns If
	 *     Or returns If
	 *     Or.Or_1_0 returns If
	 *     And returns If
	 *     And.And_1_0 returns If
	 *     Greater returns If
	 *     Greater.Greater_1_0 returns If
	 *     GreaterEqual returns If
	 *     GreaterEqual.GreaterEqual_1_0 returns If
	 *     Smaller returns If
	 *     Smaller.Smaller_1_0 returns If
	 *     SmallerEqual returns If
	 *     SmallerEqual.SmallerEqual_1_0 returns If
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
	 *     Formula returns IsEmpty
	 *     Equality returns IsEmpty
	 *     Equality.Equality_1_0 returns IsEmpty
	 *     BinaryFormula returns IsEmpty
	 *     If returns IsEmpty
	 *     If.If_1_0 returns IsEmpty
	 *     Xor returns IsEmpty
	 *     Xor.Xor_1_0 returns IsEmpty
	 *     Or returns IsEmpty
	 *     Or.Or_1_0 returns IsEmpty
	 *     And returns IsEmpty
	 *     And.And_1_0 returns IsEmpty
	 *     Predicate returns IsEmpty
	 *     IsEmpty returns IsEmpty
	 *     Greater returns IsEmpty
	 *     Greater.Greater_1_0 returns IsEmpty
	 *     GreaterEqual returns IsEmpty
	 *     GreaterEqual.GreaterEqual_1_0 returns IsEmpty
	 *     Smaller returns IsEmpty
	 *     Smaller.Smaller_1_0 returns IsEmpty
	 *     SmallerEqual returns IsEmpty
	 *     SmallerEqual.SmallerEqual_1_0 returns IsEmpty
	 *     Primary returns IsEmpty
	 *
	 * Constraint:
	 *     term=[Term|ID]
	 */
	protected void sequence_IsEmpty(ISerializationContext context, IsEmpty semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.IS_EMPTY__TERM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.IS_EMPTY__TERM));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIsEmptyAccess().getTermTermIDTerminalRuleCall_1_0_1(), semanticObject.getTerm());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns Not
	 *     Equality returns Not
	 *     Equality.Equality_1_0 returns Not
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
	 *     Greater returns Not
	 *     Greater.Greater_1_0 returns Not
	 *     GreaterEqual returns Not
	 *     GreaterEqual.GreaterEqual_1_0 returns Not
	 *     Smaller returns Not
	 *     Smaller.Smaller_1_0 returns Not
	 *     SmallerEqual returns Not
	 *     SmallerEqual.SmallerEqual_1_0 returns Not
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
	 *     Equality returns Or
	 *     Equality.Equality_1_0 returns Or
	 *     BinaryFormula returns Or
	 *     If returns Or
	 *     If.If_1_0 returns Or
	 *     Xor returns Or
	 *     Xor.Xor_1_0 returns Or
	 *     Or returns Or
	 *     Or.Or_1_0 returns Or
	 *     And returns Or
	 *     And.And_1_0 returns Or
	 *     Greater returns Or
	 *     Greater.Greater_1_0 returns Or
	 *     GreaterEqual returns Or
	 *     GreaterEqual.GreaterEqual_1_0 returns Or
	 *     Smaller returns Or
	 *     Smaller.Smaller_1_0 returns Or
	 *     SmallerEqual returns Or
	 *     SmallerEqual.SmallerEqual_1_0 returns Or
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
	 *     Formula returns SmallerEqual
	 *     Equality returns SmallerEqual
	 *     Equality.Equality_1_0 returns SmallerEqual
	 *     BinaryFormula returns SmallerEqual
	 *     If returns SmallerEqual
	 *     If.If_1_0 returns SmallerEqual
	 *     Xor returns SmallerEqual
	 *     Xor.Xor_1_0 returns SmallerEqual
	 *     Or returns SmallerEqual
	 *     Or.Or_1_0 returns SmallerEqual
	 *     And returns SmallerEqual
	 *     And.And_1_0 returns SmallerEqual
	 *     Greater returns SmallerEqual
	 *     Greater.Greater_1_0 returns SmallerEqual
	 *     GreaterEqual returns SmallerEqual
	 *     GreaterEqual.GreaterEqual_1_0 returns SmallerEqual
	 *     Smaller returns SmallerEqual
	 *     Smaller.Smaller_1_0 returns SmallerEqual
	 *     SmallerEqual returns SmallerEqual
	 *     SmallerEqual.SmallerEqual_1_0 returns SmallerEqual
	 *     Primary returns SmallerEqual
	 *
	 * Constraint:
	 *     (left=SmallerEqual_SmallerEqual_1_0 right=Primary)
	 */
	protected void sequence_SmallerEqual(ISerializationContext context, SmallerEqual semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.SMALLER_EQUAL__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.SMALLER_EQUAL__LEFT));
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.SMALLER_EQUAL__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.SMALLER_EQUAL__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSmallerEqualAccess().getSmallerEqualLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getSmallerEqualAccess().getRightPrimaryParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Formula returns Smaller
	 *     Equality returns Smaller
	 *     Equality.Equality_1_0 returns Smaller
	 *     BinaryFormula returns Smaller
	 *     If returns Smaller
	 *     If.If_1_0 returns Smaller
	 *     Xor returns Smaller
	 *     Xor.Xor_1_0 returns Smaller
	 *     Or returns Smaller
	 *     Or.Or_1_0 returns Smaller
	 *     And returns Smaller
	 *     And.And_1_0 returns Smaller
	 *     Greater returns Smaller
	 *     Greater.Greater_1_0 returns Smaller
	 *     GreaterEqual returns Smaller
	 *     GreaterEqual.GreaterEqual_1_0 returns Smaller
	 *     Smaller returns Smaller
	 *     Smaller.Smaller_1_0 returns Smaller
	 *     SmallerEqual returns Smaller
	 *     SmallerEqual.SmallerEqual_1_0 returns Smaller
	 *     Primary returns Smaller
	 *
	 * Constraint:
	 *     (left=Smaller_Smaller_1_0 right=SmallerEqual)
	 */
	protected void sequence_Smaller(ISerializationContext context, Smaller semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.SMALLER__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.SMALLER__LEFT));
			if (transientValues.isValueTransient(semanticObject, FirstOrderLogicPackage.Literals.SMALLER__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FirstOrderLogicPackage.Literals.SMALLER__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSmallerAccess().getSmallerLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getSmallerAccess().getRightSmallerEqualParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Term returns Variable
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
	 *     Equality returns Xor
	 *     Equality.Equality_1_0 returns Xor
	 *     BinaryFormula returns Xor
	 *     If returns Xor
	 *     If.If_1_0 returns Xor
	 *     Xor returns Xor
	 *     Xor.Xor_1_0 returns Xor
	 *     Or returns Xor
	 *     Or.Or_1_0 returns Xor
	 *     And returns Xor
	 *     And.And_1_0 returns Xor
	 *     Greater returns Xor
	 *     Greater.Greater_1_0 returns Xor
	 *     GreaterEqual returns Xor
	 *     GreaterEqual.GreaterEqual_1_0 returns Xor
	 *     Smaller returns Xor
	 *     Smaller.Smaller_1_0 returns Xor
	 *     SmallerEqual returns Xor
	 *     SmallerEqual.SmallerEqual_1_0 returns Xor
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
