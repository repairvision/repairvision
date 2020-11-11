package org.sidiff.reverseengineering.java.transformation.uml.rules;

import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.sidiff.reverseengineering.java.transformation.uml.JavaASTTransformationUML;

public abstract class JavaToUML<JN, UC, UN> {
	
	protected static UMLFactory umlFactory = UMLFactory.eINSTANCE;
	
	protected static UMLPackage umlPackage = UMLPackage.eINSTANCE;

	protected JavaASTTransformationUML trafo;

	public JavaASTTransformationUML getTransformation() {
		return trafo;
	}

	public void setTransformation(JavaASTTransformationUML trafo) {
		this.trafo = trafo;
	}
	
	/**
	 * Transforms the Java AST node to a corresponding model element (fragment).
	 * 
	 * @param javaNode The Java AST node.
	 */
	public abstract void apply(JN javaNode);
	
	/**
	 * Creates the containment of the model node.
	 * 
	 * @param modelContainer The model container.
	 * @param modelNode      The contained model element.
	 */
	public abstract void apply(UC modelContainer, UN modelNode);
	
	/**
	 * @param javaNode  The Java AST node.
	 * @param modelNode The corresponding model element.
	 * @throws ClassNotFoundException A type binding that could not be resolved.
	 */
	public abstract void link(JN javaNode, UN modelNode) throws ClassNotFoundException;
}
