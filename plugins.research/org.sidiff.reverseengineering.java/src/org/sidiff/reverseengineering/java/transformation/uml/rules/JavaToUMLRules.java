package org.sidiff.reverseengineering.java.transformation.uml.rules;

import org.sidiff.reverseengineering.java.transformation.uml.JavaASTTransformationUML;

public class JavaToUMLRules {
	
	public ClassToClass classToClass;
	
	public MethodToOperation methodToOperation;
	
	public VariableToParameter variableToParameter;
	
	public JavaToUMLRules() {
		this.classToClass = new ClassToClass();
		this.methodToOperation = new MethodToOperation();
		this.variableToParameter = new VariableToParameter();
	}

	public void init(JavaASTTransformationUML trafo) {
		this.classToClass.setTransformation(trafo);
		this.methodToOperation.setTransformation(trafo);
		this.variableToParameter.setTransformation(trafo);
	}
}
