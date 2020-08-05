/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.sidiff.validation.ocl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.*;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.evaluation.EvaluationVisitorDecorator;
import org.eclipse.ocl.pivot.util.Visitable;
import org.sidiff.revision.common.ui.workbench.InfoConsole;

/**
 * A decorator for evaluation visitors that is installed when evaluation tracing
 * is enabled, to trace interim evaluation results to the console.
 */
public class TracingOCLEvaluationVisitor extends EvaluationVisitorDecorator implements EvaluationVisitor.EvaluationVisitorExtension {

	/**
	 * Initializes me with the visitor whose evaluation I trace to the console.
	 *
	 * @param decorated a real evaluation visitor
	 */
	public TracingOCLEvaluationVisitor(EvaluationVisitor.@NonNull EvaluationVisitorExtension decorated) {
		super(decorated);
	}
	
	public EvaluationVisitorExtension getUndecorated() {
		return (EvaluationVisitorExtension) delegate;
	}

	protected @Nullable Object trace(@NonNull Visitable expression, @Nullable Object value) {
		try {
			InfoConsole.printInfo("Evaluate: " + expression); //$NON-NLS-1$
			InfoConsole.printInfo("Result  : " + //$NON-NLS-1$
					(value == null ? TypeId.OCL_INVALID_NAME : String.valueOf(value)));
		} catch (Exception e) {
			// tracing must not interfere with evaluation
		} catch (AssertionError e) {
			// tracing must not interfere with evaluation
		}

		return value;
	}
	
	protected @Nullable Object traceUndecorated(@NonNull Visitable expression, @Nullable Object value) {
		try {
			InfoConsole.printInfo("Undecorated Evaluation: " + expression); //$NON-NLS-1$
			InfoConsole.printInfo("Undecorated Result  : " + //$NON-NLS-1$
					(value == null ? TypeId.OCL_INVALID_NAME : String.valueOf(value)));
		} catch (Exception e) {
			// tracing must not interfere with evaluation
		} catch (AssertionError e) {
			// tracing must not interfere with evaluation
		}

		return value;
	}
	
	@Override
	@Deprecated
	public @NonNull Executor getExecutor() {
		return ((EvaluationVisitor.EvaluationVisitorExtension)delegate).getExecutor();
	}
	
	@Override
	public @Nullable Object visit(@NonNull Visitable visitable) {
		return traceUndecorated(visitable, ((EvaluationVisitor.EvaluationVisitorExtension)delegate).visit(visitable));
	}

	@Override
	public Object visiting(@NonNull Visitable visitable) {
		return trace(visitable, delegate.visiting(visitable));
	}

	@Override
	public Object visitAnnotation(@NonNull Annotation visitable) {
		return trace(visitable, delegate.visitAnnotation(visitable));
	}

	@Override
	public Object visitAnyType(@NonNull AnyType visitable) {
		return trace(visitable, delegate.visitAnyType(visitable));
	}

	@Override
	public Object visitAssociationClass(@NonNull AssociationClass visitable) {
		return trace(visitable, delegate.visitAssociationClass(visitable));
	}

	@Override
	public Object visitAssociationClassCallExp(
			@NonNull AssociationClassCallExp visitable) {
		return trace(visitable, delegate.visitAssociationClassCallExp(visitable));
	}

	@Override
	public Object visitBagType(@NonNull BagType visitable) {
		return trace(visitable, delegate.visitBagType(visitable));
	}

	@Override
	public Object visitBehavior(@NonNull Behavior visitable) {
		return trace(visitable, delegate.visitBehavior(visitable));
	}

	@Override
	public Object visitBooleanLiteralExp(@NonNull BooleanLiteralExp visitable) {
		return trace(visitable, delegate.visitBooleanLiteralExp(visitable));
	}

	@Override
	public Object visitCallExp(@NonNull CallExp visitable) {
		return trace(visitable, delegate.visitCallExp(visitable));
	}

	@Override
	public Object visitCallOperationAction(
			@NonNull CallOperationAction visitable) {
		return trace(visitable, delegate.visitCallOperationAction(visitable));
	}

	@Override
	public Object visitClass(org.eclipse.ocl.pivot.@NonNull Class visitable) {
		return trace(visitable, delegate.visitClass(visitable));
	}

	@Override
	public Object visitCollectionItem(@NonNull CollectionItem visitable) {
		return trace(visitable, delegate.visitCollectionItem(visitable));
	}

	@Override
	public Object visitCollectionLiteralExp(
			@NonNull CollectionLiteralExp visitable) {
		return trace(visitable, delegate.visitCollectionLiteralExp(visitable));
	}

	@Override
	public Object visitCollectionLiteralPart(
			@NonNull CollectionLiteralPart visitable) {
		return trace(visitable, delegate.visitCollectionLiteralPart(visitable));
	}

	@Override
	public Object visitCollectionRange(@NonNull CollectionRange visitable) {
		return trace(visitable, delegate.visitCollectionRange(visitable));
	}

	@Override
	public Object visitCollectionType(@NonNull CollectionType visitable) {
		return trace(visitable, delegate.visitCollectionType(visitable));
	}

	@Override
	public Object visitComment(@NonNull Comment visitable) {
		return trace(visitable, delegate.visitComment(visitable));
	}

	@Override
	public Object visitCompleteClass(@NonNull CompleteClass visitable) {
		return trace(visitable, delegate.visitCompleteClass(visitable));
	}

	@Override
	public Object visitCompleteEnvironment(
			@NonNull CompleteEnvironment visitable) {
		return trace(visitable, delegate.visitCompleteEnvironment(visitable));
	}

	@Override
	public Object visitCompleteModel(@NonNull CompleteModel visitable) {
		return trace(visitable, delegate.visitCompleteModel(visitable));
	}

	@Override
	public Object visitCompletePackage(@NonNull CompletePackage visitable) {
		return trace(visitable, delegate.visitCompletePackage(visitable));
	}

	@Override
	public Object visitConnectionPointReference(
			@NonNull ConnectionPointReference visitable) {
		return trace(visitable, delegate.visitConnectionPointReference(visitable));
	}

	@Override
	public Object visitConstraint(@NonNull Constraint visitable) {
		return trace(visitable, delegate.visitConstraint(visitable));
	}

	@Override
	public Object visitDataType(@NonNull DataType visitable) {
		return trace(visitable, delegate.visitDataType(visitable));
	}

	@Override
	public Object visitDetail(@NonNull Detail visitable) {
		return trace(visitable, delegate.visitDetail(visitable));
	}

	@Override
	public Object visitDynamicBehavior(@NonNull DynamicBehavior visitable) {
		return trace(visitable, delegate.visitDynamicBehavior(visitable));
	}

	@Override
	public Object visitDynamicElement(@NonNull DynamicElement visitable) {
		return trace(visitable, delegate.visitDynamicElement(visitable));
	}

	@Override
	public Object visitDynamicProperty(@NonNull DynamicProperty visitable) {
		return trace(visitable, delegate.visitDynamicProperty(visitable));
	}

	@Override
	public Object visitDynamicType(@NonNull DynamicType visitable) {
		return trace(visitable, delegate.visitDynamicType(visitable));
	}

	@Override
	public Object visitDynamicValueSpecification(
			@NonNull DynamicValueSpecification visitable) {
		return trace(visitable, delegate.visitDynamicValueSpecification(visitable));
	}

	@Override
	public Object visitElement(@NonNull Element visitable) {
		return trace(visitable, delegate.visitElement(visitable));
	}

	@Override
	public Object visitElementExtension(@NonNull ElementExtension visitable) {
		return trace(visitable, delegate.visitElementExtension(visitable));
	}

	@Override
	public Object visitEnumLiteralExp(@NonNull EnumLiteralExp visitable) {
		return trace(visitable, delegate.visitEnumLiteralExp(visitable));
	}

	@Override
	public Object visitEnumeration(@NonNull Enumeration visitable) {
		return trace(visitable, delegate.visitEnumeration(visitable));
	}

	@Override
	public Object visitEnumerationLiteral(@NonNull EnumerationLiteral visitable) {
		return trace(visitable, delegate.visitEnumerationLiteral(visitable));
	}

	@Override
	public Object visitExpressionInOCL(@NonNull ExpressionInOCL visitable) {
		return trace(visitable, delegate.visitExpressionInOCL(visitable));
	}

	@Override
	public Object visitFeature(@NonNull Feature visitable) {
		return trace(visitable, delegate.visitFeature(visitable));
	}

	@Override
	public Object visitFeatureCallExp(@NonNull FeatureCallExp visitable) {
		return trace(visitable, delegate.visitFeatureCallExp(visitable));
	}

	@Override
	public Object visitFinalState(@NonNull FinalState visitable) {
		return trace(visitable, delegate.visitFinalState(visitable));
	}

	@Override
	public Object visitIfExp(@NonNull IfExp visitable) {
		return trace(visitable, delegate.visitIfExp(visitable));
	}

	@Override
	public Object visitImport(@NonNull Import visitable) {
		return trace(visitable, delegate.visitImport(visitable));
	}

	@Override
	public Object visitInstanceSpecification(
			@NonNull InstanceSpecification visitable) {
		return trace(visitable, delegate.visitInstanceSpecification(visitable));
	}

	@Override
	public Object visitIntegerLiteralExp(@NonNull IntegerLiteralExp visitable) {
		return trace(visitable, delegate.visitIntegerLiteralExp(visitable));
	}

	@Override
	public Object visitInvalidLiteralExp(@NonNull InvalidLiteralExp visitable) {
		return trace(visitable, delegate.visitInvalidLiteralExp(visitable));
	}

	@Override
	public Object visitInvalidType(@NonNull InvalidType visitable) {
		return trace(visitable, delegate.visitInvalidType(visitable));
	}

	@Override
	public Object visitIterableType(@NonNull IterableType visitable) {
		return trace(visitable, delegate.visitIterableType(visitable));
	}

	@Override
	public Object visitIterateExp(@NonNull IterateExp visitable) {
		return trace(visitable, delegate.visitIterateExp(visitable));
	}

	@Override
	public Object visitIteration(@NonNull Iteration visitable) {
		return trace(visitable, delegate.visitIteration(visitable));
	}

	@Override
	public Object visitIteratorExp(@NonNull IteratorExp visitable) {
		return trace(visitable, delegate.visitIteratorExp(visitable));
	}

	@Override
	public Object visitIteratorVariable(@NonNull IteratorVariable visitable) {
		return trace(visitable, delegate.visitIteratorVariable(visitable));
	}

	@Override
	public Object visitLambdaType(@NonNull LambdaType visitable) {
		return trace(visitable, delegate.visitLambdaType(visitable));
	}

	@Override
	public Object visitLanguageExpression(@NonNull LanguageExpression visitable) {
		return trace(visitable, delegate.visitLanguageExpression(visitable));
	}

	@Override
	public Object visitLetExp(@NonNull LetExp visitable) {
		return trace(visitable, delegate.visitLetExp(visitable));
	}

	@Override
	public Object visitLetVariable(@NonNull LetVariable visitable) {
		return trace(visitable, delegate.visitLetVariable(visitable));
	}

	@Override
	public Object visitLibrary(@NonNull Library visitable) {
		return trace(visitable, delegate.visitLibrary(visitable));
	}

	@Override
	public Object visitLiteralExp(@NonNull LiteralExp visitable) {
		return trace(visitable, delegate.visitLiteralExp(visitable));
	}

	@Override
	public Object visitLoopExp(@NonNull LoopExp visitable) {
		return trace(visitable, delegate.visitLoopExp(visitable));
	}

	@Override
	public Object visitMapLiteralExp(@NonNull MapLiteralExp visitable) {
		return trace(visitable, delegate.visitMapLiteralExp(visitable));
	}

	@Override
	public Object visitMapLiteralPart(@NonNull MapLiteralPart visitable) {
		return trace(visitable, delegate.visitMapLiteralPart(visitable));
	}

	@Override
	public Object visitMapType(@NonNull MapType visitable) {
		return trace(visitable, delegate.visitMapType(visitable));
	}

	@Override
	public Object visitMessageExp(@NonNull MessageExp visitable) {
		return trace(visitable, delegate.visitMessageExp(visitable));
	}

	@Override
	public Object visitMessageType(@NonNull MessageType visitable) {
		return trace(visitable, delegate.visitMessageType(visitable));
	}

	@Override
	public Object visitModel(@NonNull Model visitable) {
		return trace(visitable, delegate.visitModel(visitable));
	}

	@Override
	public Object visitNamedElement(@NonNull NamedElement visitable) {
		return trace(visitable, delegate.visitNamedElement(visitable));
	}

	@Override
	public Object visitNamespace(@NonNull Namespace visitable) {
		return trace(visitable, delegate.visitNamespace(visitable));
	}

	@Override
	public Object visitNavigationCallExp(@NonNull NavigationCallExp visitable) {
		return trace(visitable, delegate.visitNavigationCallExp(visitable));
	}

	@Override
	public Object visitNullLiteralExp(@NonNull NullLiteralExp visitable) {
		return trace(visitable, delegate.visitNullLiteralExp(visitable));
	}

	@Override
	public Object visitNumericLiteralExp(@NonNull NumericLiteralExp visitable) {
		return trace(visitable, delegate.visitNumericLiteralExp(visitable));
	}

	@Override
	public Object visitOCLExpression(@NonNull OCLExpression visitable) {
		return trace(visitable, delegate.visitOCLExpression(visitable));
	}

	@Override
	public Object visitOperation(@NonNull Operation visitable) {
		return trace(visitable, delegate.visitOperation(visitable));
	}

	@Override
	public Object visitOperationCallExp(@NonNull OperationCallExp visitable) {
		return trace(visitable, delegate.visitOperationCallExp(visitable));
	}

	@Override
	public Object visitOppositePropertyCallExp(
			@NonNull OppositePropertyCallExp visitable) {
		return trace(visitable, delegate.visitOppositePropertyCallExp(visitable));
	}

	@Override
	public Object visitOrderedSetType(@NonNull OrderedSetType visitable) {
		return trace(visitable, delegate.visitOrderedSetType(visitable));
	}

	@Override
	public Object visitOrphanCompletePackage(
			@NonNull OrphanCompletePackage visitable) {
		return trace(visitable, delegate.visitOrphanCompletePackage(visitable));
	}

	@Override
	public Object visitPackage(@NonNull Package visitable) {
		return trace(visitable, delegate.visitPackage(visitable));
	}

	@Override
	public Object visitParameter(@NonNull Parameter visitable) {
		return trace(visitable, delegate.visitParameter(visitable));
	}

	@Override
	public Object visitParameterVariable(@NonNull ParameterVariable visitable) {
		return trace(visitable, delegate.visitParameterVariable(visitable));
	}

	@Override
	public Object visitPrecedence(@NonNull Precedence visitable) {
		return trace(visitable, delegate.visitPrecedence(visitable));
	}

	@Override
	public Object visitPrimitiveCompletePackage(
			@NonNull PrimitiveCompletePackage visitable) {
		return trace(visitable, delegate.visitPrimitiveCompletePackage(visitable));
	}

	@Override
	public Object visitPrimitiveLiteralExp(
			@NonNull PrimitiveLiteralExp visitable) {
		return trace(visitable, delegate.visitPrimitiveLiteralExp(visitable));
	}

	@Override
	public Object visitPrimitiveType(@NonNull PrimitiveType visitable) {
		return trace(visitable, delegate.visitPrimitiveType(visitable));
	}

	@Override
	public Object visitProfile(@NonNull Profile visitable) {
		return trace(visitable, delegate.visitProfile(visitable));
	}

	@Override
	public Object visitProfileApplication(@NonNull ProfileApplication visitable) {
		return trace(visitable, delegate.visitProfileApplication(visitable));
	}

	@Override
	public Object visitProperty(@NonNull Property visitable) {
		return trace(visitable, delegate.visitProperty(visitable));
	}

	@Override
	public Object visitPropertyCallExp(@NonNull PropertyCallExp visitable) {
		return trace(visitable, delegate.visitPropertyCallExp(visitable));
	}

	@Override
	public Object visitPseudostate(@NonNull Pseudostate visitable) {
		return trace(visitable, delegate.visitPseudostate(visitable));
	}

	@Override
	public Object visitRealLiteralExp(@NonNull RealLiteralExp visitable) {
		return trace(visitable, delegate.visitRealLiteralExp(visitable));
	}

	@Override
	public Object visitRegion(@NonNull Region visitable) {
		return trace(visitable, delegate.visitRegion(visitable));
	}

	@Override
	public Object visitResultVariable(@NonNull ResultVariable visitable) {
		return trace(visitable, delegate.visitResultVariable(visitable));
	}

	@Override
	public Object visitSelfType(@NonNull SelfType visitable) {
		return trace(visitable, delegate.visitSelfType(visitable));
	}

	@Override
	public Object visitSendSignalAction(@NonNull SendSignalAction visitable) {
		return trace(visitable, delegate.visitSendSignalAction(visitable));
	}

	@Override
	public Object visitSequenceType(@NonNull SequenceType visitable) {
		return trace(visitable, delegate.visitSequenceType(visitable));
	}

	@Override
	public Object visitSetType(@NonNull SetType visitable) {
		return trace(visitable, delegate.visitSetType(visitable));
	}

	@Override
	public Object visitShadowExp(@NonNull ShadowExp visitable) {
		return trace(visitable, delegate.visitShadowExp(visitable));
	}

	@Override
	public Object visitShadowPart(@NonNull ShadowPart visitable) {
		return trace(visitable, delegate.visitShadowPart(visitable));
	}

	@Override
	public Object visitSignal(@NonNull Signal visitable) {
		return trace(visitable, delegate.visitSignal(visitable));
	}

	@Override
	public Object visitSlot(@NonNull Slot visitable) {
		return trace(visitable, delegate.visitSlot(visitable));
	}

	@Override
	public Object visitStandardLibrary(@NonNull StandardLibrary visitable) {
		return trace(visitable, delegate.visitStandardLibrary(visitable));
	}

	@Override
	public Object visitState(@NonNull State visitable) {
		return trace(visitable, delegate.visitState(visitable));
	}

	@Override
	public Object visitStateExp(@NonNull StateExp visitable) {
		return trace(visitable, delegate.visitStateExp(visitable));
	}

	@Override
	public Object visitStateMachine(@NonNull StateMachine visitable) {
		return trace(visitable, delegate.visitStateMachine(visitable));
	}

	@Override
	public Object visitStereotype(@NonNull Stereotype visitable) {
		return trace(visitable, delegate.visitStereotype(visitable));
	}

	@Override
	public Object visitStereotypeExtender(@NonNull StereotypeExtender visitable) {
		return trace(visitable, delegate.visitStereotypeExtender(visitable));
	}

	@Override
	public Object visitStringLiteralExp(@NonNull StringLiteralExp visitable) {
		return trace(visitable, delegate.visitStringLiteralExp(visitable));
	}

	@Override
	public Object visitTemplateBinding(@NonNull TemplateBinding visitable) {
		return trace(visitable, delegate.visitTemplateBinding(visitable));
	}

	@Override
	public Object visitTemplateParameter(@NonNull TemplateParameter visitable) {
		return trace(visitable, delegate.visitTemplateParameter(visitable));
	}

	@Override
	public Object visitTemplateParameterSubstitution(
			@NonNull TemplateParameterSubstitution visitable) {
		return trace(visitable, delegate.visitTemplateParameterSubstitution(visitable));
	}

	@Override
	public Object visitTemplateSignature(@NonNull TemplateSignature visitable) {
		return trace(visitable, delegate.visitTemplateSignature(visitable));
	}

	@Override
	public Object visitTemplateableElement(
			@NonNull TemplateableElement visitable) {
		return trace(visitable, delegate.visitTemplateableElement(visitable));
	}

	@Override
	public Object visitTransition(@NonNull Transition visitable) {
		return trace(visitable, delegate.visitTransition(visitable));
	}

	@Override
	public Object visitTrigger(@NonNull Trigger visitable) {
		return trace(visitable, delegate.visitTrigger(visitable));
	}

	@Override
	public Object visitTupleLiteralExp(@NonNull TupleLiteralExp visitable) {
		return trace(visitable, delegate.visitTupleLiteralExp(visitable));
	}

	@Override
	public Object visitTupleLiteralPart(@NonNull TupleLiteralPart visitable) {
		return trace(visitable, delegate.visitTupleLiteralPart(visitable));
	}

	@Override
	public Object visitTupleType(@NonNull TupleType visitable) {
		return trace(visitable, delegate.visitTupleType(visitable));
	}

	@Override
	public Object visitType(@NonNull Type visitable) {
		return trace(visitable, delegate.visitType(visitable));
	}

	@Override
	public Object visitTypeExp(@NonNull TypeExp visitable) {
		return trace(visitable, delegate.visitTypeExp(visitable));
	}

	@Override
	public Object visitTypedElement(@NonNull TypedElement visitable) {
		return trace(visitable, delegate.visitTypedElement(visitable));
	}

	@Override
	public Object visitUnlimitedNaturalLiteralExp(
			@NonNull UnlimitedNaturalLiteralExp visitable) {
		return trace(visitable, delegate.visitUnlimitedNaturalLiteralExp(visitable));
	}

	@Override
	public Object visitUnspecifiedValueExp(
			@NonNull UnspecifiedValueExp visitable) {
		return trace(visitable, delegate.visitUnspecifiedValueExp(visitable));
	}

	@Override
	public Object visitValueSpecification(@NonNull ValueSpecification visitable) {
		return trace(visitable, delegate.visitValueSpecification(visitable));
	}

	@Override
	public Object visitVariable(@NonNull Variable visitable) {
		return trace(visitable, delegate.visitVariable(visitable));
	}

	@Override
	public Object visitVariableDeclaration(
			@NonNull VariableDeclaration visitable) {
		return trace(visitable, delegate.visitVariableDeclaration(visitable));
	}

	@Override
	public Object visitVariableExp(@NonNull VariableExp visitable) {
		return trace(visitable, delegate.visitVariableExp(visitable));
	}

	@Override
	public Object visitVertex(@NonNull Vertex visitable) {
		return trace(visitable, delegate.visitVertex(visitable));
	}

	@Override
	public Object visitVoidType(@NonNull VoidType visitable) {
		return trace(visitable, delegate.visitVoidType(visitable));
	}

	@Override
	public Object visitWildcardType(@NonNull WildcardType visitable) {
		return trace(visitable, delegate.visitWildcardType(visitable));
	}
}
