package org.sidiff.reverseengineering.java.transformation.uml.rules;

import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.sidiff.reverseengineering.java.util.JavaASTUtil;

public class VariableToParameter extends JavaToUML<SingleVariableDeclaration, Operation, Parameter> {

	@Override
	public void apply(SingleVariableDeclaration variableDeclaration) {
		Parameter umlParameter = createParameter(variableDeclaration.getName().getIdentifier());
		trafo.createModelElement(variableDeclaration, umlParameter);
	}
	
	public Parameter createParameter(String name) {
		Parameter umlParameter = umlFactory.createParameter();
		umlParameter.setName(name);
		return umlParameter;
	}

	@Override
	public void apply(Operation modelContainer, Parameter modelNode) {
		modelContainer.getOwnedParameters().add(modelNode);
	}

	@Override
	public void link(SingleVariableDeclaration variableDeclaration, Parameter umlParameter) throws ClassNotFoundException {
		setParameterType(umlParameter, variableDeclaration.getType());
	}

	public void setParameterType(Parameter umlParameter, org.eclipse.jdt.core.dom.Type javaType) throws ClassNotFoundException {
		
		// Erase generic types -> most concrete bindable type:
		ITypeBinding variableType = JavaASTUtil.genericTypeErasure(javaType.resolveBinding());
		
		// Encode arrays with multiplicities:
		if (variableType.isArray()) {
			variableType = JavaASTUtil.arrayTypeErasure(variableType);
			umlParameter.setUpper(-1);
		}
		
		// Resolce and set type:
		Type type = trafo.resolveBinding(variableType, umlPackage.getType());
		umlParameter.setType((Type) type);
	}

}
