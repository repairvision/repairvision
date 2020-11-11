package org.sidiff.reverseengineering.java.transformation.uml.rules;

import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;

public class TypeToClass extends JavaToUML<TypeDeclaration, Package, Class> {

	@Override
	public void apply(TypeDeclaration typeDeclaration) {
		Class umlClass = createClass(typeDeclaration);
		trafo.createRootModelElement(typeDeclaration, umlClass);
		
		if (typeDeclaration.getJavadoc() != null) {
			createJavaDocComment(umlClass, typeDeclaration.getJavadoc());
		}
	}

	public Class createClass(TypeDeclaration javaNode) {
		Class umlClass = umlFactory.createClass();
		umlClass.setName(javaNode.getName().getIdentifier());
		return umlClass;
	}

	@Override
	public void apply(Package modelContainer, Class modelNode) {
		// Containment will be created by JavaASTProjectModelUML
	}

	@Override
	public void link(TypeDeclaration javaNode, Class modelNode) {
	}

}
