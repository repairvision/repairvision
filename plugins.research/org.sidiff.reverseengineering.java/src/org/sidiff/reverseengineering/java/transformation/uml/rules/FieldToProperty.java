package org.sidiff.reverseengineering.java.transformation.uml.rules;

import java.util.logging.Level;

import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.LiteralSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.sidiff.reverseengineering.java.Activator;

public class FieldToProperty extends JavaToUML<FieldDeclaration, Classifier, Property> {

	@Override
	public void apply(FieldDeclaration fieldDeclaration) {
		if ((fieldDeclaration.fragments().size() == 1) 
				&& (fieldDeclaration.fragments().get(0) instanceof VariableDeclarationFragment)) {
			
			VariableDeclarationFragment declarationFragment = (VariableDeclarationFragment) fieldDeclaration.fragments().get(0);
			Property umlProperty = createProperty(fieldDeclaration, declarationFragment);
			
			trafo.createModelElement(fieldDeclaration, umlProperty);
		} else {
			if (Activator.getLogger().isLoggable(Level.FINE)) {
				Activator.getLogger().log(Level.FINE, "Unkown field declaration: " + fieldDeclaration);
			}
		}
		
	}
	
	public Property createProperty(FieldDeclaration fieldDeclaration, VariableDeclarationFragment declarationFragment) {
		Property umlProperty = umlFactory.createProperty();
		umlProperty.setName(declarationFragment.getName().getIdentifier());
		rules.javaToUMLHelper.setModifiers(umlProperty, fieldDeclaration);
		
		// default value:
		LiteralSpecification defaultValue = rules.javaToUMLHelper.createLiteralValue(declarationFragment.getInitializer(), false);
		
		if (defaultValue != null) {
			umlProperty.setDefaultValue(defaultValue);
		}
		
		// Encode initialization with mulitplicities:
		// NOTE: 1 is default value...
//		if (declarationFragment.getInitializer() != null) {
//			umlProperty.setLower(1);
//		}
		
		// Encode arrays with multiplicities:
		if (fieldDeclaration.getType().isArrayType()) {
			umlProperty.setUpper(-1);
		}
		
		if (fieldDeclaration.getJavadoc() != null) {
			rules.javaToUMLHelper.createJavaDocComment(umlProperty, fieldDeclaration.getJavadoc());
		}
		
		return umlProperty;
	}

	@Override
	public void apply(Classifier modelContainer, Property modelNode) {
		if (modelContainer instanceof StructuredClassifier) {
			((StructuredClassifier) modelContainer).getOwnedAttributes().add(modelNode);
		} else if (modelContainer instanceof Interface) {
			((Interface) modelContainer).getOwnedAttributes().add(modelNode);
		}
	}

	@Override
	public void link(FieldDeclaration javaNode, Property umlProperty) throws ClassNotFoundException {
		setPropertyType(umlProperty, javaNode.getType());
	}
	
	public void setPropertyType(Property umlProperty, org.eclipse.jdt.core.dom.Type javaType) throws ClassNotFoundException {
		rules.javaToUMLHelper.setType(umlProperty, javaType);
		rules.javaToUMLHelper.encodeArrayType(umlProperty, javaType);
	}

}
