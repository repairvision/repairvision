package org.sidiff.reverseengineering.java.transformation.uml.rules;

import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;

public class VariableToParameter extends JavaToUML<SingleVariableDeclaration, Operation, Parameter> {

	@Override
	public void apply(SingleVariableDeclaration javaNode) {
		Parameter umlParameter = umlFactory.createParameter();
		umlParameter.setName(javaNode.getName().getIdentifier());
		trafo.createModelElement(javaNode, umlParameter);
	}

	@Override
	public void apply(Operation modelContainer, Parameter modelNode) {
		modelContainer.getOwnedParameters().add(modelNode);
	}

	@Override
	public void link(SingleVariableDeclaration variableDeclaration, Parameter umlParameter) throws ClassNotFoundException {
		Type type = trafo.resolveBinding(variableDeclaration.getType().resolveBinding(), umlPackage.getType());
		umlParameter.setType((Type) type);
	}

}
