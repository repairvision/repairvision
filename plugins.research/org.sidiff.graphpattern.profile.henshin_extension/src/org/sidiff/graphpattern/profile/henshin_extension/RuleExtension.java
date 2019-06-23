/**
 */
package org.sidiff.graphpattern.profile.henshin_extension;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.henshin.model.Rule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.profile.henshin_extension.RuleExtension#getSubgraphs <em>Subgraphs</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionPackage#getRuleExtension()
 * @model
 * @generated
 */
public interface RuleExtension extends Rule {
	/**
	 * Returns the value of the '<em><b>Subgraphs</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.profile.henshin_extension.SubGraph}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subgraphs</em>' containment reference list.
	 * @see org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionPackage#getRuleExtension_Subgraphs()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<SubGraph> getSubgraphs();

} // RuleExtension
