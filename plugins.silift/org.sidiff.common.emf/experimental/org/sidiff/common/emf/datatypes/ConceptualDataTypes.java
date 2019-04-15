//TODO kann rausfliegen, wird derzeit aber in SEV (PG2009) benutzt
package org.sidiff.common.emf.datatypes;

@Deprecated
public abstract class ConceptualDataTypes {

	// Numeric (0-99)
	public static final int FLOAT = 0;
	public static final int DOUBLE = 1;

	public static final int SHORT = 10;
	public static final int INTEGER = 11;
	public static final int LONG = 12;

	public static final int BIG_DECIMAL = 20;
	public static final int BIG_INTEGER = 21;

	// String 
	public static final int STRING = 100;
	public static final int CHARACTER = 101;
	
	// Boolean
	public static final int BOOLEAN = 200;
	
	// Date 
	public static final int DATE = 300;
	
	// Byte
	public static final int BYTE = 400;
	public static final int BYTE_ARRAY = 401;
}
