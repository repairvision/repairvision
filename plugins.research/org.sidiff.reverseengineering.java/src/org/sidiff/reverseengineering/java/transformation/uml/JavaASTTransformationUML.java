package org.sidiff.reverseengineering.java.transformation.uml;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.sidiff.reverseengineering.java.transformation.JavaASTTransformation;

/**
 * Implementation of a Java AST to a UML model transformation.
 * 
 * @author Manuel Ohrndorf
 */
public class JavaASTTransformationUML extends JavaASTTransformation {
	
	private UMLFactory umlFactory = UMLFactory.eINSTANCE;
	
	private UMLPackage umlPackage = UMLPackage.eINSTANCE;
	
	private boolean linker = false;
	
	@Override
	public void apply(CompilationUnit javaAST) {
       	
		// Create model graph nodes:
    	javaAST.accept(this);
		
    	// Create model graph edges:
		this.linker = true;
		javaAST.accept(this);
	}

	@Override
	public boolean visit(TypeDeclaration node) {
		if (!linker) {
			Class umlClass = umlFactory.createClass();
			umlClass.setName(node.getName().getIdentifier());
			createRootModelElement(node, umlClass);
		} else {
			Class umlClass = (Class) getModelElement(node);
					
			for (MethodDeclaration method : node.getMethods()) {
				Operation umlOperation = (Operation) getModelElement(method);
				umlClass.getOwnedOperations().add(umlOperation);
			}
		}
		return true;
	}
	
	@Override
	public boolean visit(MethodDeclaration node) {
		if (!linker) {
			Operation umlOperation = umlFactory.createOperation();
			umlOperation.setName(node.getName().getIdentifier());
			createModelElement(node, umlOperation);
		} else {
			Operation umlOperation = (Operation) getModelElement(node);
			
			for (Object parameter : node.parameters()) {
				if (parameter instanceof SingleVariableDeclaration) {
					Parameter umlParameter = (Parameter) getModelElement((SingleVariableDeclaration) parameter);
					umlOperation.getOwnedParameters().add(umlParameter);
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean visit(SingleVariableDeclaration node) {
		if (!linker) {
			Parameter umlParameter = umlFactory.createParameter();
			umlParameter.setName(node.getName().getIdentifier());
			createModelElement(node, umlParameter);
		} else {
			try {
				Parameter umlParameter = (Parameter) getModelElement(node);
				Type type = resolveBinding(node.getType().resolveBinding(), umlPackage.getType());
				umlParameter.setType((Type) type);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
