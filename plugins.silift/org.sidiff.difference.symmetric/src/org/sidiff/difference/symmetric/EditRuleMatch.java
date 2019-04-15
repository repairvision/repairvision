/**
 */
package org.sidiff.difference.symmetric;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edit Rule Match</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.difference.symmetric.EditRuleMatch#getNodeOccurrencesA <em>Node Occurrences A</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.EditRuleMatch#getNodeOccurrencesB <em>Node Occurrences B</em>}</li>
 * </ul>
 *
 * @see org.sidiff.difference.symmetric.SymmetricPackage#getEditRuleMatch()
 * @model
 * @generated
 */
public interface EditRuleMatch extends EObject {
	/**
	 * Returns the value of the '<em><b>Node Occurrences A</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.sidiff.difference.symmetric.EObjectSet},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Occurrences A</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Occurrences A</em>' map.
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getEditRuleMatch_NodeOccurrencesA()
	 * @model mapType="org.sidiff.difference.symmetric.EString2EObjectSetMap<org.eclipse.emf.ecore.EString, org.sidiff.difference.symmetric.EObjectSet>"
	 * @generated
	 */
	EMap<String, EObjectSet> getNodeOccurrencesA();

	/**
	 * Returns the value of the '<em><b>Node Occurrences B</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.sidiff.difference.symmetric.EObjectSet},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Occurrences B</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Occurrences B</em>' map.
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getEditRuleMatch_NodeOccurrencesB()
	 * @model mapType="org.sidiff.difference.symmetric.EString2EObjectSetMap<org.eclipse.emf.ecore.EString, org.sidiff.difference.symmetric.EObjectSet>"
	 * @generated
	 */
	EMap<String, EObjectSet> getNodeOccurrencesB();

} // EditRuleMatch
