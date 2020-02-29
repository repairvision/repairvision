/**
 */
package org.sidiff.graphpattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.Parameter#getPattern <em>Pattern</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getParameter()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='TheNameOfTheParameterIsNotUnique'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot TheNameOfTheParameterIsNotUnique='not(self.pattern.parameters-&gt;exists(p |p &lt;&gt; self and p.name = self.name))'"
 * @generated
 */
public interface Parameter extends PatternElement {
	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.Pattern#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' container reference.
	 * @see #setPattern(Pattern)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getParameter_Pattern()
	 * @see org.sidiff.graphpattern.Pattern#getParameters
	 * @model opposite="parameters" transient="false"
	 * @generated
	 */
	Pattern getPattern();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.Parameter#getPattern <em>Pattern</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' container reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(Pattern value);

} // Parameter
