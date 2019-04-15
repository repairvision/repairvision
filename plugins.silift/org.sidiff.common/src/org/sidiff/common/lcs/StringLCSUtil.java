package org.sidiff.common.lcs;

/**
 * Represents an implementation of the LCS algorithm which works with strings.<br />
 * This class uses the {@link LCSUtil}.
 * 
 */
public class StringLCSUtil {
	
	/**
	 * Private constructor to prevent instantiation
	 */
	private StringLCSUtil() { }
	
	
	/**
	 * Compares two strings and calculates the length of the longest common subsequence.
	 * 
	 * @param stringA The string A
	 * @param stringB The string B
	 * @return Returns the relative length of the longest common subsequence.
	 */
	public static float compareStringConsideringCase(String stringA, String stringB)
	{
		if (stringA == null && stringB == null)
			return 1.0f;
		else if (stringA == null || stringB == null)
			return 0.0f;
		else if (stringA.equals(stringB))
			return 1.0f;
		else {
			int lcs = LCSUtil.compareSequenceByEqualSubsequence(stringA, stringB, new StringLCSSequenceAccessorEqualSubsequence());
			return (float) lcs / Math.max(stringA.length(), stringB.length());
		}
	}
	
	/**
	 * Compares two strings and calculates the length of the longest common subsequence
	 * ignoring strings' cases.
	 * 
	 * @param stringA The string A
	 * @param stringB The string B
	 * @return Returns the relative length of the longest common subsequence found 
	 */
	public static float compareStringIgnoringCase(String stringA, String stringB)
	{
		if (stringA == null && stringB == null)
			return 1.0f;
		else if (stringA == null || stringB == null)
			return 0.0f;
		else if (stringA.equals(stringB))
			return 1.0f;
		else {
			float lcs = LCSUtil.compareSequenceByEqualSubsequence(stringA, stringB, new StringLCSSequenceAccessorEqualIgnoreCaseSubsequence());
			return (float) lcs / Math.max(stringA.length(), stringB.length());
		}
	}
	
	
	/**
	 * This is an implementation of the {@link LCSSequenceAccessorEqualSubsequence} interface
	 * to allow LCS algorithm to access and compare Strings on basis of equality.
	 * 
	 * @author Thomas Bender
	 */
	private static final class StringLCSSequenceAccessorEqualSubsequence implements LCSSequenceAccessorEqualSubsequence<String,Character>
	{
		@Override
		public Character get (String sequence, int index) {
			  return new Character (sequence.charAt(index));
		}
		
		@Override
		public int size (String sequence) {
			return ((String) sequence).length();
		}
		
		@Override
		public boolean areEqual (Character itemA, Character itemB) {
			return itemA.equals (itemB);
		}
	}
	
	/**
	 * This is an implementation of the {@link LCSSequenceAccessorEqualSubsequence} interface
	 * to allow LCS algorithm to access and compare Strings on basis of equality ignoring strings' cases.
	 * 
	 * @author Sven Wenzel
	 */
	private static final class StringLCSSequenceAccessorEqualIgnoreCaseSubsequence implements LCSSequenceAccessorEqualSubsequence<String,Character>
	{
		@Override
		public Character get (String sequence, int index) {
			  return new Character (sequence.charAt(index));
		}
		
		@Override
		public int size (String sequence) {
			return ((String) sequence).length();
		}
		
		@Override
		public boolean areEqual (Character itemA, Character itemB) {
			return itemA.equals(itemB) || Character.toLowerCase(itemA) == Character.toLowerCase(itemB);
		}
	}

}
