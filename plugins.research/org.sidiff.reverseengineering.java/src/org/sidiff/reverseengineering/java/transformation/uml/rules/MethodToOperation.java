package org.sidiff.reverseengineering.java.transformation.uml.rules;


import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.OperationOwner;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.sidiff.reverseengineering.java.util.JavaASTUtil;

public class MethodToOperation extends JavaToUML<MethodDeclaration, OperationOwner, Operation> {
	
	@Override
	public void apply(MethodDeclaration methodDeclaration) {
		Operation umlOperation = createOperation(methodDeclaration);
		trafo.createModelElement(methodDeclaration, umlOperation);
	}

	public Operation createOperation(MethodDeclaration methodDeclaration) {
		Operation umlOperation = umlFactory.createOperation();
		umlOperation.setName(methodDeclaration.getName().getIdentifier());
		rules.javaToUMLHelper.setVisibility(umlOperation, methodDeclaration);
		
		if (methodDeclaration.getJavadoc() != null) {
			rules.javaToUMLHelper.createJavaDocComment(umlOperation, methodDeclaration.getJavadoc());
		}
		return umlOperation;
	}

	@Override
	public void apply(OperationOwner modelContainer, Operation modelNode) {
		modelContainer.getOwnedOperations().add(modelNode);
	}

	@Override
	public void link(MethodDeclaration methodDeclaration, Operation operation) throws ClassNotFoundException {
		Type returnType = methodDeclaration.getReturnType2();
		
		if (!JavaASTUtil.isPrimitiveType(returnType, PrimitiveType.VOID)) {
			Parameter umlReturnParameter = rules.variableToParameter.createParameter(null);
			umlReturnParameter.setDirection(ParameterDirectionKind.RETURN_LITERAL);
			
			rules.variableToParameter.setParameterType(umlReturnParameter, returnType);
			operation.getOwnedParameters().add(0, umlReturnParameter);
		}
	}
}
