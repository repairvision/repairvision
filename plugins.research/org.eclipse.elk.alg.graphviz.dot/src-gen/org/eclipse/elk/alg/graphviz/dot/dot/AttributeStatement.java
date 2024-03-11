/**
 * Copyright (c) 2016 Kiel University and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.elk.alg.graphviz.dot.dot;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.elk.alg.graphviz.dot.dot.AttributeStatement#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.elk.alg.graphviz.dot.dot.AttributeStatement#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.elk.alg.graphviz.dot.dot.DotPackage#getAttributeStatement()
 * @model
 * @generated
 */
public interface AttributeStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.elk.alg.graphviz.dot.dot.AttributeType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.eclipse.elk.alg.graphviz.dot.dot.AttributeType
   * @see #setType(AttributeType)
   * @see org.eclipse.elk.alg.graphviz.dot.dot.DotPackage#getAttributeStatement_Type()
   * @model
   * @generated
   */
  AttributeType getType();

  /**
   * Sets the value of the '{@link org.eclipse.elk.alg.graphviz.dot.dot.AttributeStatement#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.eclipse.elk.alg.graphviz.dot.dot.AttributeType
   * @see #getType()
   * @generated
   */
  void setType(AttributeType value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.elk.alg.graphviz.dot.dot.Attribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.elk.alg.graphviz.dot.dot.DotPackage#getAttributeStatement_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

} // AttributeStatement
