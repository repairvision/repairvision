package org.sidiff.consistency.common.java;

public class StringPrinter {

	protected StringBuffer string = new StringBuffer();

	public void print(Object object) {
		string.append(object.toString());
	}
	
	public void print(int indent, Object object) {
		printIndent(indent);
		print(object);
	}
	
	public void println(Object object) {
		string.append(object.toString() + "\n");
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
