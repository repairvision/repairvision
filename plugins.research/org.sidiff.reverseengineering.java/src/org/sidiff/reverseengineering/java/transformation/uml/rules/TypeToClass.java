package org.sidiff.reverseengineering.java.transformation.uml.rules;

import java.util.logging.Level;

import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Package;
import org.sidiff.reverseengineering.java.Activator;

public class TypeToClass extends JavaToUML<TypeDeclaration, Package, Class> {

	@Override
	public void apply(TypeDeclaration typeDeclaration) {
		Class umlClass = createClass(typeDeclaration);
		trafo.createRootModelElement(typeDeclaration, umlClass);
	}

	public Class createClass(TypeDeclaration typeDeclaration) {
		Class umlClass = umlFactory.createClass();
		umlClass.setName(typeDeclaration.getName().getIdentifier());
		rules.javaToUMLHelper.setModifiers(umlClass, typeDeclaration);
		
		if (typeDeclaration.getJavadoc() != null) {
			rules.javaToUMLHelper.createJavaDocComment(umlClass, typeDeclaration.getJavadoc());
		}
		
		// Create classifier behavior for operation behavior modeling:
		// TODO: Method invocations
//		createClassifierBehavior(umlClass);
		
		return umlClass;
	}
	
	public void createClassifierBehavior(Class umlClass) {
		FunctionBehavior umlFunctionBehavior = umlFactory.createFunctionBehavior();
		umlFunctionBehavior.setName(umlClass.getName());
		umlClass.setClassifierBehavior(umlFunctionBehavior);
	}

	@Override
	public void apply(Package modelContainer, Class modelNode) {
		// Containment will be created by JavaASTProjectModelUML
	}

	@Override
	public void link(TypeDeclaration typeDeclaration, Class umlClass) throws ClassNotFoundException {
		
		// extends:
		createGeneralization(typeDeclaration, typeDeclaration.getSuperclassType(), umlClass);
		
		// implements:
		createInterfaces(typeDeclaration, umlClass);
	}

	public void createGeneralization(TypeDeclaration typeDeclaration, Type superType, Classifier umlClassifier) throws ClassNotFoundException {
		if (superType != null) {
			Classifier umlSuperTypeProxy = trafo.resolveBindingProxy(superType.resolveBinding(), umlPackage.getClassifier());
			
			if (umlSuperTypeProxy != null) {
				Generalization umlGeneralization = umlFactory.createGeneralization();
				umlGeneralization.setSpecific(umlClassifier);
				umlGeneralization.setGeneral(umlSuperTypeProxy);
				umlClassifier.getGeneralizations().add(umlGeneralization);
			} else {
				if (Activator.getLogger().isLoggable(Level.FINE)) {
					Activator.getLogger().log(Level.FINE, "Super type not found: " + typeDeclaration);
				}
			}
		}
	}

	public void createInterfaces(TypeDeclaration typeDeclaration, Class umlClass) throws ClassNotFoundException {
		if (typeDeclaration.superInterfaceTypes() != null) {
			for (Object javaInterface : typeDeclaration.superInterfaceTypes()) {
				
				if (javaInterface instanceof Type) {
					Type javaInterfaceType = (Type) javaInterface;
					ITypeBinding umlInterfaceBinding = javaInterfaceType.resolveBinding();
	
					Interface umlInterfaceProxy = trafo.resolveBindingProxy(umlInterfaceBinding, umlPackage.getInterface());
					
					if (umlInterfaceProxy != null) {
						InterfaceRealization umlInterfaceRealization = umlFactory.createInterfaceRealization();
						umlInterfaceRealization.setName(umlInterfaceBinding.getName());
						umlInterfaceRealization.setContract(umlInterfaceProxy);
						umlInterfaceRealization.setImplementingClassifier(umlClass);
						umlClass.getInterfaceRealizations().add(umlInterfaceRealization);
					} else {
						if (Activator.getLogger().isLoggable(Level.FINE)) {
							Activator.getLogger().log(Level.FINE, "Interface not found: " + typeDeclaration);
						}
					}
				}
			}
		}
	}

}
