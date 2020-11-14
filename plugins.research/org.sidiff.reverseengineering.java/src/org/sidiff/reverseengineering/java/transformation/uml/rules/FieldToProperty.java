package org.sidiff.reverseengineering.java.transformation.uml.rules;

import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.LiteralSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;

public class FieldToProperty extends JavaToUML<VariableDeclarationFragment, Classifier, Property> {

	@Override
	public void apply(VariableDeclarationFragment fieldDeclaration) {
		Property umlProperty = createProperty(fieldDeclaration, fieldDeclaration);
		trafo.createModelElement(fieldDeclaration, umlProperty);
	}
	
	public Property createProperty(VariableDeclarationFragment fieldDeclarationFragment, VariableDeclarationFragment declarationFragment) {
		if (fieldDeclarationFragment.getParent() instanceof FieldDeclaration) {
			FieldDeclaration fieldDeclaration = (FieldDeclaration) fieldDeclarationFragment.getParent();
			
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
//			if (declarationFragment.getInitializer() != null) {
//				umlProperty.setLower(1);
//			}
			
			// Encode arrays with multiplicities:
			if (fieldDeclaration.getType().isArrayType()) {
				umlProperty.setUpper(-1);
			}
			
			if (fieldDeclaration.getJavadoc() != null) {
				rules.javaToUMLHelper.createJavaDocComment(umlProperty, fieldDeclaration.getJavadoc());
			}
			
			return umlProperty;
		}
		
		return null;
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
	public void link(VariableDeclarationFragment variableDeclarationFragment, Property umlProperty) throws ClassNotFoundException {
		if (variableDeclarationFragment.getParent() instanceof FieldDeclaration) {
			setPropertyType(umlProperty, ((FieldDeclaration) variableDeclarationFragment.getParent()).getType());
		}
	}
	
	public void setPropertyType(Property umlProperty, org.eclipse.jdt.core.dom.Type javaType) throws ClassNotFoundException {
		rules.javaToUMLHelper.setType(umlProperty, javaType);
		rules.javaToUMLHelper.encodeArrayType(umlProperty, javaType);
	}

}
