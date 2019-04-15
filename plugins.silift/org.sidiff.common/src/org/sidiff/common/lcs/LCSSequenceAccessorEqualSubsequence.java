package org.sidiff.common.lcs;


/**
 * This interface is derived from {@link LCSSequenceAccessor} and is used to
 * gives a client the possibility to implement an access class for {@link LCSUtil}
 * using .
 * 
 * @author Thomas Bender
 */
public interface LCSSequenceAccessorEqualSubsequence<T,X> extends LCSSequenceAccessor<T,X>
{
	
	/**
	 * Compares two objects to be equal
	 * @param objectA The object A
	 * @param objectB The object B
	 * @return Returns <code>true</code> if objects equal, otherwise <code>false</code>.
	 */
	public boolean areEqual(X objectA, X objectB);
	
}
