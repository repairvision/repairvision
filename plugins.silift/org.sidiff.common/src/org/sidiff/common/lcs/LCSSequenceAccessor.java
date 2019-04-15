package org.sidiff.common.lcs;

/**
 * Gives the {@link LCSUtil} access to the specific data.<br />
 * <b>Note:</b> This interface is designed to be accessed package internally only.
 * Please use {@link LCSSequenceAccessorEqualSubsequence} or {@link LCSSequenceAccessorSimilarSubsequence}
 * for own implementations.
 * 
 */
interface LCSSequenceAccessor<T,X>
{
	/**
	 * Returns the size of the sequence which is to be applied to {@link LCSUtil}
	 * @param sequence The object which represents the sequence
	 */
	public int size(T sequence);

	/**
	 * Returns an specific element of the sequence which is to be applied to {@link LCSUtil}
	 * 
	 * @param sequence The object which represents the sequence
	 * @param index The element to retrieve
	 * @return
	 */
	public X get(T sequence, int index);
}
