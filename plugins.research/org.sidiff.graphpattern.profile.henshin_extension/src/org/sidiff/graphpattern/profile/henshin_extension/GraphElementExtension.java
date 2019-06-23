/**
 */
package org.sidiff.graphpattern.profile.henshin_extension;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Element Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension#getSubgraphs <em>Subgraphs</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionPackage#getGraphElementExtension()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface GraphElementExtension extends EObject {
	/**
	 * Returns the value of the '<em><b>Subgraphs</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.profile.henshin_extension.SubGraph}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.profile.henshin_extension.SubGraph#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subgraphs</em>' reference list.
	 * @see org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionPackage#getGraphElementExtension_Subgraphs()
	 * @see org.sidiff.graphpattern.profile.henshin_extension.SubGraph#getElements
	 * @model opposite="elements"
	 * @generated
	 */
	EList<SubGraph> getSubgraphs();

} // GraphElementExtension
