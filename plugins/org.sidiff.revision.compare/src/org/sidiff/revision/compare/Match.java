package org.sidiff.revision.compare;

/**
 * Maintains the matching between two models A and B. Please note, model A and B
 * can also contain the same objects (or be the same physical models), which are
 * not necessarily corresponding.
 * 
 * @author Manuel Ohrndorf
 */
public interface Match {

	/**
	 * @param elementA A model element of model A.
	 * @param elementB A model element of model B.
	 * @return <code>true</code> if a new match was added; <code>false</code>
	 *         otherwise.
	 */
	boolean add(Object elementA, Object elementB);

	/**
	 * @param elementA A model element of model A.
	 * @param elementB A model element of model B.
	 * @return <code>true</code> if the match is removed; <code>false</code>
	 *         otherwise.
	 */
	boolean remove(Object elementA, Object elementB);

	/**
	 * @param elementA A model element of model A.
	 * @param elementB A model element of model B.
	 * @return <code>true</code> if a matching between the given elements exists;
	 *         <code>false</code> otherwise.
	 */
	boolean contains(Object elementA, Object elementB);

	/**
	 * @param elementB A model element of model B.
	 * @return The corresponding model element of model A; or <code>null</code> if
	 *         no matching exists.
	 */
	<E> E getInA(E elementB);

	/**
	 * @param elementA A model element of model A.
	 * @return The corresponding model element of model B; or <code>null</code> if
	 *         no matching exists.
	 */
	<E> E getInB(E elementA);
}
