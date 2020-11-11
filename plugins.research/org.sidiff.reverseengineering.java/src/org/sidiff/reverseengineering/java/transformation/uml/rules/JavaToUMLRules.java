package org.sidiff.reverseengineering.java.transformation.uml.rules;

import java.util.ArrayList;
import java.util.List;

import org.sidiff.reverseengineering.java.transformation.uml.JavaASTTransformationUML;

public class JavaToUMLRules {
	
	private List<JavaToUML<?,?,?>> transformations;
	
	public EnumToEnumeration enumToEnumeration;
	
	public EnumToEnumerationInner enumToEnumerationInner;
	
	public EnumConstantToEnumerationLiteral enumConstantToEnumerationLiteral;
	
	public TypeToClass typeToClass;
	
	public TypeToClassInner typeToClassInner;
	
	public TypeToInterface typeToInterface;
	
	public TypeToInterfaceInner typeToInterfaceInner;
	
	public MethodToOperation methodToOperation;
	
	public VariableToParameter variableToParameter;
	
	public JavaToUMLRules() {
		this.transformations = new ArrayList<>();
		
		this.enumToEnumeration = add(new EnumToEnumeration());
		this.enumToEnumerationInner = add(new EnumToEnumerationInner());
		this.enumConstantToEnumerationLiteral = add(new EnumConstantToEnumerationLiteral());
		this.typeToClass = add(new TypeToClass());
		this.typeToClassInner = add(new TypeToClassInner());
		this.typeToInterface = add(new TypeToInterface());
		this.typeToInterfaceInner = add(new TypeToInterfaceInner());
		this.methodToOperation = add(new MethodToOperation());
		this.variableToParameter = add(new VariableToParameter());
	}
	
	protected <T extends JavaToUML<?, ?, ?>> T add(T transformation) {
		this.transformations.add(transformation);
		return transformation;
	}

	public void init(JavaASTTransformationUML trafo) {
		for (JavaToUML<?, ?, ?> javaToUML : transformations) {
			javaToUML.init(trafo, this);
		}
	}
	
	public void cleanUp() {
		for (JavaToUML<?, ?, ?> javaToUML : transformations) {
			javaToUML.cleanUp();
		}
	}
	
	public List<JavaToUML<?,?,?>> getTransformations() {
		return transformations;
	}
}
