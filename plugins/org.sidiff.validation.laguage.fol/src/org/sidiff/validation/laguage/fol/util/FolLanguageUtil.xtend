package org.sidiff.validation.laguage.fol.util

import org.sidiff.validation.laguage.fol.firstOrderLogic.Get
import org.sidiff.validation.laguage.fol.firstOrderLogic.ReferenceBase

class FolLanguageUtil {

	/**
	 * Returns the last Get of the given ReferenceBase, or <code>null</code> if none.
	 * @param ref the reference base
	 * @return last Get, <code>null</code> if none
	 */
	static def Get lastGet(ReferenceBase ref) {
		var get = ref.get
		if(get === null) {
			return null
		}
		while(get.next !== null) {
			get = get.next
		}
		return get
	}

	/**
	 * Returns the Get containing the given Get, or <code>null</code> if none.
	 * @param get the Get
	 * @return parent Get, <code>null</code> if none
	 */
	static def Get parentGet(Get get) {
		if(get.eContainer instanceof Get) {
			return get.eContainer as Get
		}
		return null
	}
}