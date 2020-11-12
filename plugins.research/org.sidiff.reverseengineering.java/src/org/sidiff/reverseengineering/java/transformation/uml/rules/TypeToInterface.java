package org.sidiff.reverseengineering.java.transformation.uml.rules;

import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;

public class TypeToInterface extends JavaToUML<TypeDeclaration, Package, Interface> {

	@Override
	public void apply(TypeDeclaration typeDeclaration) {
		Interface umlInterface = createInterface(typeDeclaration);
		
		if (typeDeclaration.getJavadoc() != null) {
			rules.javaToUMLHelper.createJavaDocComment(umlInterface, typeDeclaration.getJavadoc());
		}
		
		trafo.createRootModelElement(typeDeclaration, umlInterface);
	}
	
	public Interface createInterface(TypeDeclaration javaNode) {
		Interface umlInterface = umlFactory.createInterface();
		umlInterface.setName(javaNode.getName().getIdentifier());
		return umlInterface;
	}

	@Override
	public void apply(Package modelContainer, Interface modelNode) {
		// Containment will be created by JavaASTProjectModelUML
	}

	@Override
	public void link(TypeDeclaration typeDeclaration, Interface umlInterface) throws ClassNotFoundException {
		
		// extends:
		for (Object javaInterface : typeDeclaration.superInterfaceTypes()) {
			if (javaInterface instanceof Type) {
				rules.typeToClass.createGeneralization(typeDeclaration, (Type) javaInterface, umlInterface);
			}
		}
	}

}
