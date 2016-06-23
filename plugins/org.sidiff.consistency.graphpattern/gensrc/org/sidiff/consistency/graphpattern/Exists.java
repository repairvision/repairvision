/**
 */
package org.sidiff.consistency.graphpattern;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exists</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.Exists#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.Exists#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getExists()
 * @model
 * @generated
 */
public interface Exists extends Quantifier {

	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(int)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getExists_LowerBound()
	 * @model default="1"
	 * @generated
	 */
	int getLowerBound();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.Exists#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(int value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' attribute.
	 * @see #setUpperBound(int)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getExists_UpperBound()
	 * @model default="-1"
	 * @generated
	 */
	int getUpperBound();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.Exists#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(int value);
} // Exists
