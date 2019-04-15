/**
 */
package org.sidiff.matching.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gradual Correspondence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.matching.model.GradualCorrespondence#getSimilarity <em>Similarity</em>}</li>
 * </ul>
 *
 * @see org.sidiff.matching.model.MatchingModelPackage#getGradualCorrespondence()
 * @model
 * @generated
 */
public interface GradualCorrespondence extends Correspondence {
	/**
	 * Returns the value of the '<em><b>Similarity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Similarity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Similarity</em>' attribute.
	 * @see #setSimilarity(float)
	 * @see org.sidiff.matching.model.MatchingModelPackage#getGradualCorrespondence_Similarity()
	 * @model required="true"
	 * @generated
	 */
	float getSimilarity();

	/**
	 * Sets the value of the '{@link org.sidiff.matching.model.GradualCorrespondence#getSimilarity <em>Similarity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Similarity</em>' attribute.
	 * @see #getSimilarity()
	 * @generated
	 */
	void setSimilarity(float value);

} // GradualCorrespondence
