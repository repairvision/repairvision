/**
 */
package org.sidiff.completion.ui.codebricks.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.completion.ui.codebricks.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage
 * @generated
 */
public class CodebricksAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CodebricksPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodebricksAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CodebricksPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodebricksSwitch<Adapter> modelSwitch =
		new CodebricksSwitch<Adapter>() {
			@Override
			public Adapter caseCodebricks(Codebricks object) {
				return createCodebricksAdapter();
			}
			@Override
			public Adapter caseCodebrick(Codebrick object) {
				return createCodebrickAdapter();
			}
			@Override
			public Adapter caseBrick(Brick object) {
				return createBrickAdapter();
			}
			@Override
			public Adapter caseTemplatePlaceholderBrick(TemplatePlaceholderBrick object) {
				return createTemplatePlaceholderBrickAdapter();
			}
			@Override
			public Adapter caseObjectPlaceholderBrick(ObjectPlaceholderBrick object) {
				return createObjectPlaceholderBrickAdapter();
			}
			@Override
			public Adapter caseTextBrick(TextBrick object) {
				return createTextBrickAdapter();
			}
			@Override
			public Adapter caseIndentBrick(IndentBrick object) {
				return createIndentBrickAdapter();
			}
			@Override
			public Adapter caseLineBreakBrick(LineBreakBrick object) {
				return createLineBreakBrickAdapter();
			}
			@Override
			public Adapter caseViewableBrick(ViewableBrick object) {
				return createViewableBrickAdapter();
			}
			@Override
			public Adapter caseBlankBrick(BlankBrick object) {
				return createBlankBrickAdapter();
			}
			@Override
			public Adapter caseComposedBrick(ComposedBrick object) {
				return createComposedBrickAdapter();
			}
			@Override
			public Adapter caseStyledBrick(StyledBrick object) {
				return createStyledBrickAdapter();
			}
			@Override
			public Adapter caseValuePlaceholderBrick(ValuePlaceholderBrick object) {
				return createValuePlaceholderBrickAdapter();
			}
			@Override
			public Adapter casePlaceholderBrick(PlaceholderBrick object) {
				return createPlaceholderBrickAdapter();
			}
			@Override
			public Adapter casePOJOCodebrickView(POJOCodebrickView object) {
				return createPOJOCodebrickViewAdapter();
			}
			@Override
			public Adapter caseCodebrickView(CodebrickView object) {
				return createCodebrickViewAdapter();
			}
			@Override
			public Adapter caseObjectDomainPolicy(ObjectDomainPolicy object) {
				return createObjectDomainPolicyAdapter();
			}
			@Override
			public Adapter caseValueDomainPolicy(ValueDomainPolicy object) {
				return createValueDomainPolicyAdapter();
			}
			@Override
			public Adapter caseCollapsibleBrick(CollapsibleBrick object) {
				return createCollapsibleBrickAdapter();
			}
			@Override
			public Adapter caseResetTemplatePlaceholderBrick(ResetTemplatePlaceholderBrick object) {
				return createResetTemplatePlaceholderBrickAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.Codebricks <em>Codebricks</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.Codebricks
	 * @generated
	 */
	public Adapter createCodebricksAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.Codebrick <em>Codebrick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.Codebrick
	 * @generated
	 */
	public Adapter createCodebrickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.Brick <em>Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.Brick
	 * @generated
	 */
	public Adapter createBrickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick <em>Template Placeholder Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick
	 * @generated
	 */
	public Adapter createTemplatePlaceholderBrickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick <em>Object Placeholder Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick
	 * @generated
	 */
	public Adapter createObjectPlaceholderBrickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.TextBrick <em>Text Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.TextBrick
	 * @generated
	 */
	public Adapter createTextBrickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.IndentBrick <em>Indent Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.IndentBrick
	 * @generated
	 */
	public Adapter createIndentBrickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.LineBreakBrick <em>Line Break Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.LineBreakBrick
	 * @generated
	 */
	public Adapter createLineBreakBrickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.ViewableBrick <em>Viewable Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.ViewableBrick
	 * @generated
	 */
	public Adapter createViewableBrickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.BlankBrick <em>Blank Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.BlankBrick
	 * @generated
	 */
	public Adapter createBlankBrickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.ComposedBrick <em>Composed Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.ComposedBrick
	 * @generated
	 */
	public Adapter createComposedBrickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.StyledBrick <em>Styled Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.StyledBrick
	 * @generated
	 */
	public Adapter createStyledBrickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick <em>Value Placeholder Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick
	 * @generated
	 */
	public Adapter createValuePlaceholderBrickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.PlaceholderBrick <em>Placeholder Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.PlaceholderBrick
	 * @generated
	 */
	public Adapter createPlaceholderBrickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.POJOCodebrickView <em>POJO Codebrick View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.POJOCodebrickView
	 * @generated
	 */
	public Adapter createPOJOCodebrickViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.CodebrickView <em>Codebrick View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.CodebrickView
	 * @generated
	 */
	public Adapter createCodebrickViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.ObjectDomainPolicy <em>Object Domain Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.ObjectDomainPolicy
	 * @generated
	 */
	public Adapter createObjectDomainPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.ValueDomainPolicy <em>Value Domain Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.ValueDomainPolicy
	 * @generated
	 */
	public Adapter createValueDomainPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.CollapsibleBrick <em>Collapsible Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.CollapsibleBrick
	 * @generated
	 */
	public Adapter createCollapsibleBrickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.completion.ui.codebricks.ResetTemplatePlaceholderBrick <em>Reset Template Placeholder Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.completion.ui.codebricks.ResetTemplatePlaceholderBrick
	 * @generated
	 */
	public Adapter createResetTemplatePlaceholderBrickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CodebricksAdapterFactory
