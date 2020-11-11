package org.sidiff.reverseengineering.java.transformation.uml.rules;

import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;

public class ClassToClass extends JavaToUML<TypeDeclaration, Package, Class> {

	@Override
	public void apply(TypeDeclaration javaNode) {
		Class umlClass = umlFactory.createClass();
		umlClass.setName(javaNode.getName().getIdentifier());
		trafo.createRootModelElement(javaNode, umlClass);
	}

	@Override
	public void apply(Package modelContainer, Class modelNode) {
		// Containment will be created by JavaASTProjectModelUML
	}

	@Override
	public void link(TypeDeclaration javaNode, Class modelNode) {
	}

}
