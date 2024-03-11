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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.elk.alg.graphviz.dot.dot.Port#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.elk.alg.graphviz.dot.dot.Port#getCompass_pt <em>Compass pt</em>}</li>
 * </ul>
 *
 * @see org.eclipse.elk.alg.graphviz.dot.dot.DotPackage#getPort()
 * @model
 * @generated
 */
public interface Port extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.elk.alg.graphviz.dot.dot.DotPackage#getPort_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.elk.alg.graphviz.dot.dot.Port#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Compass pt</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Compass pt</em>' attribute.
   * @see #setCompass_pt(String)
   * @see org.eclipse.elk.alg.graphviz.dot.dot.DotPackage#getPort_Compass_pt()
   * @model
   * @generated
   */
  String getCompass_pt();

  /**
   * Sets the value of the '{@link org.eclipse.elk.alg.graphviz.dot.dot.Port#getCompass_pt <em>Compass pt</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Compass pt</em>' attribute.
   * @see #getCompass_pt()
   * @generated
   */
  void setCompass_pt(String value);

} // Port
