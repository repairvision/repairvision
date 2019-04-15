package org.sidiff.common.lcs;


/**
 * This interface is derived from {@link LCSSequenceAccessor} and is used to
 * gives a client the possibility to implement an access class for {@link LCSUtil}
 * using the compare method which is based on equality.
 * 
 * @author Thomas Bender
 */
public interface LCSSequenceAccessorSimilarSubsequence<T,X> extends LCSSequenceAccessor<T,X>
{

	/**
	 * Compares two objects to be equal
	 * @param itemA The object A
	 * @param itemB The object B
	 * @return Returns <code>true</code> if objects equal, otherwise <code>false</code>.
	 */
	public float getSimilarity(X itemA, X itemB);
	
}