package org.sidiff.reverseengineering.java.transformation.uml.rules;

import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Class;

public class MethodToOperation extends JavaToUML<MethodDeclaration, Class, Operation> {

	@Override
	public void apply(MethodDeclaration javaNode) {
		Operation umlOperation = umlFactory.createOperation();
		umlOperation.setName(javaNode.getName().getIdentifier());
		trafo.createModelElement(javaNode, umlOperation);
	}

	@Override
	public void apply(Class modelContainer, Operation modelNode) {
		modelContainer.getOwnedOperations().add(modelNode);
	}

	@Override
	public void link(MethodDeclaration javaNode, Operation modelNode) {
	}
}
