/**
 */
package org.sidiff.revision.changes;

import java.util.Iterator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Set</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sidiff.revision.changes.ChangesPackage#getChangeSet()
 * @model abstract="true"
 * @generated
 */
public interface ChangeSet extends ChangeContext {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.sidiff.revision.changes.ChangeIterator"
	 * @generated
	 */
	Iterator<Change> getChanges();

} // ChangeSet
