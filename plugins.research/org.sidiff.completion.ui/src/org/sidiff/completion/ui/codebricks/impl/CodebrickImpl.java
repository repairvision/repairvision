/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.completion.ui.codebricks.Brick;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.IndentBrick;
import org.sidiff.completion.ui.codebricks.LineBreakBrick;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ViewableBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Codebrick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.CodebrickImpl#getBricks <em>Bricks</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.CodebrickImpl#getCodebricks <em>Codebricks</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.CodebrickImpl#getAllBricks <em>All Bricks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CodebrickImpl extends MinimalEObjectImpl.Container implements Codebrick {
	/**
	 * The cached value of the '{@link #getBricks() <em>Bricks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBricks()
	 * @generated
	 * @ordered
	 */
	protected EList<Brick> bricks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodebrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.CODEBRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Brick> getBricks() {
		if (bricks == null) {
			bricks = new EObjectContainmentEList<Brick>(Brick.class, this, CodebricksPackage.CODEBRICK__BRICKS);
		}
		return bricks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Codebricks getCodebricks() {
		Codebricks codebricks = basicGetCodebricks();
		return codebricks != null && codebricks.eIsProxy() ? (Codebricks)eResolveProxy((InternalEObject)codebricks) : codebricks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Codebricks basicGetCodebricks() {
		EObject container = eContainer();
		
		if (container instanceof Codebricks) {
			return (Codebricks) container;
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Brick> getAllBricks() {
		EList<Brick> allBricks = new BasicEList<>();
		
		eAllContents().forEachRemaining(e -> {
			if (e instanceof Brick) {
				allBricks.add((Brick) e);
			}
		});
		
		return allBricks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public int caluclateColumns() {
		int columns = 1;
		
		// Find maximum of indents per line:
		int columnsInRow = 1;
		
		for (Brick brick : getBricks()) {
			if (brick instanceof LineBreakBrick) {
				if (columnsInRow > columns) {
					columns = columnsInRow;
					columnsInRow = 1;
				}
			} else if (brick instanceof IndentBrick) {
				++columnsInRow;
			}
		}
		
		return columns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public int calculateRows() {
		int rows = 1;
		
		// Count line breaks:
		for (Brick brick : getBricks()) {
			if (brick instanceof LineBreakBrick) {
				++rows;
			}
		}
		
		return rows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodebricksPackage.CODEBRICK__BRICKS:
				return ((InternalEList<?>)getBricks()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodebricksPackage.CODEBRICK__BRICKS:
				return getBricks();
			case CodebricksPackage.CODEBRICK__CODEBRICKS:
				if (resolve) return getCodebricks();
				return basicGetCodebricks();
			case CodebricksPackage.CODEBRICK__ALL_BRICKS:
				return getAllBricks();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CodebricksPackage.CODEBRICK__BRICKS:
				getBricks().clear();
				getBricks().addAll((Collection<? extends Brick>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CodebricksPackage.CODEBRICK__BRICKS:
				getBricks().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CodebricksPackage.CODEBRICK__BRICKS:
				return bricks != null && !bricks.isEmpty();
			case CodebricksPackage.CODEBRICK__CODEBRICKS:
				return basicGetCodebricks() != null;
			case CodebricksPackage.CODEBRICK__ALL_BRICKS:
				return !getAllBricks().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CodebricksPackage.CODEBRICK___CALCULATE_ROWS:
				return calculateRows();
			case CodebricksPackage.CODEBRICK___CALUCLATE_COLUMNS:
				return caluclateColumns();
		}
		return super.eInvoke(operationID, arguments);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		
		for (Brick brick : getBricks()) {
			if (brick instanceof ViewableBrick) {
				string.append(((ViewableBrick) brick).getText());
				string.append("\n");
				
				if (brick instanceof TemplatePlaceholderBrick) {
					for (ViewableBrick choice : ((TemplatePlaceholderBrick) brick).getChoice()) {
						string.append("  choice: ");
						string.append(choice.getText());
					}
				}
			} else {
				string.append(brick.toString());
				string.append("\n");
			}
		}
		
		return string.toString();
	}

} //CodebrickImpl
