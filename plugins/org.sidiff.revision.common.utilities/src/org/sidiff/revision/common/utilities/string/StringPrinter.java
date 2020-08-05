package org.sidiff.revision.common.utilities.string;

public class StringPrinter {
	
	public static final String HORIZONTAL_SEPERATOR_01 = 
			  "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" 
			+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
			+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
			+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
			+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
			+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" 
			+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
			+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
			+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
			+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550";

	protected StringBuffer string = new StringBuffer();

	public void print(Object object) {
		string.append(object.toString());
	}
	
	public void print(int indent, Object object) {
		printIndent(indent);
		print(object);
	}
	
	public void println(Object object) {
		if (object != null) {
			string.append(object.toString() + "\n");
		} else {
			string.append("null");
		}
	}
	
	public void println(int indent, Object object) {
		printIndent(indent);
		println(object);
	}
	
	public String toString() {
		return string.toString();
	}
	
	private void printIndent(int indent) {
		for (int i = 0; i < indent; i++) {
			string.append(" ");
		}
	}
}
