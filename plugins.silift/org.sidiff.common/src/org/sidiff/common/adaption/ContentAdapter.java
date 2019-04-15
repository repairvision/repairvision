package org.sidiff.common.adaption;

/**
 * Helper class for adapted collections.
 * This class computes the adapter objects for the elements of a collection.
 *  
 * @param <A> type of unadapted elements
 * @param <B> type of adapted elements
 */
public interface ContentAdapter<A,B> {

	public B adapt(A adaptable);
	public A unadapt(B adapted);
	
}
