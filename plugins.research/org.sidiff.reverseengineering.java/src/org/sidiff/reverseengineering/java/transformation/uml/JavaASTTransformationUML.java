package org.sidiff.reverseengineering.java.transformation.uml;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.sidiff.reverseengineering.java.transformation.JavaASTTransformation;
import org.sidiff.reverseengineering.java.transformation.uml.rules.JavaToUMLRules;

/**
 * Implementation of a Java AST to a UML model transformation.
 * 
 * @author Manuel Ohrndorf
 */
public class JavaASTTransformationUML extends JavaASTTransformation {
	
	private boolean linker = false;
	
	private JavaToUMLRules rules;
	
	public JavaASTTransformationUML(JavaToUMLRules rules) {
		this.rules = rules;
	}
	
	@Override
	public void apply(CompilationUnit javaAST) {
		this.rules.init(this);
       	
		// Create model graph nodes:
    	javaAST.accept(this);
		
    	// Create model graph edges:
		this.linker = true;
		javaAST.accept(this);
	}

	@Override
	public boolean visit(TypeDeclaration typeDeclaration) {
		if (!linker) {
			rules.classToClass.apply(typeDeclaration);
		} else {
			Class umlClass = (Class) getModelElement(typeDeclaration);
					
			for (MethodDeclaration method : typeDeclaration.getMethods()) {
				Operation umlOperation = (Operation) getModelElement(method);
				rules.methodToOperation.apply(umlClass, umlOperation);
			}
		}
		return true;
	}
	
	@Override
	public boolean visit(MethodDeclaration methodDeclaration) {
		if (!linker) {
			rules.methodToOperation.apply(methodDeclaration);
		} else {
			Operation umlOperation = (Operation) getModelElement(methodDeclaration);
			
			for (Object parameter : methodDeclaration.parameters()) {
				if (parameter instanceof SingleVariableDeclaration) {
					Parameter umlParameter = (Parameter) getModelElement((SingleVariableDeclaration) parameter);
					rules.variableToParameter.apply(umlOperation, umlParameter);
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean visit(SingleVariableDeclaration variableDeclaration) {
		if (!linker) {
			rules.variableToParameter.apply(variableDeclaration);
		} else {
			try {
				Parameter umlParameter = (Parameter) getModelElement(variableDeclaration);
				rules.variableToParameter.link(variableDeclaration, umlParameter);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
