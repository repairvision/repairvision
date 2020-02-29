/**
 */
package org.sidiff.graphpattern.profile.henshin_extension;

import org.eclipse.emf.common.util.EList;
import org.sidiff.graphpattern.PatternElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.profile.henshin_extension.SubGraph#getSubgraphs <em>Subgraphs</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.profile.henshin_extension.SubGraph#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionPackage#getSubGraph()
 * @model
 * @generated
 */
public interface SubGraph extends PatternElement {
	/**
	 * Returns the value of the '<em><b>Subgraphs</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.profile.henshin_extension.SubGraph}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subgraphs</em>' containment reference list.
	 * @see org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionPackage#getSubGraph_Subgraphs()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<SubGraph> getSubgraphs();

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension#getSubgraphs <em>Subgraphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionPackage#getSubGraph_Elements()
	 * @see org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension#getSubgraphs
	 * @model opposite="subgraphs"
	 * @generated
	 */
	EList<GraphElementExtension> getElements();

} // SubGraph
