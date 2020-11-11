package org.sidiff.reverseengineering.java.transformation.uml;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.OperationOwner;
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
		
		this.rules.cleanUp();
	}
	
	@Override
	public boolean visit(EnumDeclaration enumDeclaration) {
		if (!linker) {
			if (enumDeclaration.isPackageMemberTypeDeclaration()) {
				rules.enumToEnumeration.apply(enumDeclaration);
			} else if (enumDeclaration.getParent() instanceof TypeDeclaration) {
				rules.enumToEnumerationInner.apply(enumDeclaration);
			}
		} else {
			Enumeration umlEnum = getModelElement(enumDeclaration);
			
			if (umlEnum != null) {
				Enumeration umlEnumeration = getModelElement(enumDeclaration);

				if (umlEnumeration != null) {
					for (Object enumConstant : enumDeclaration.enumConstants()) {
						if (enumConstant instanceof EnumConstantDeclaration) {
							EnumerationLiteral umlEnumerationLiteral = getModelElement((EnumConstantDeclaration) enumConstant);
							rules.enumConstantToEnumerationLiteral.apply(umlEnumeration, umlEnumerationLiteral);
						}
					}
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean visit(EnumConstantDeclaration enumConstantDeclaration) {
		if (!linker) {
			rules.enumConstantToEnumerationLiteral.apply(enumConstantDeclaration);
		}
		return true;
	}
	
	@Override
	public boolean visit(TypeDeclaration typeDeclaration) {
		if (!linker) {
			if (typeDeclaration.isPackageMemberTypeDeclaration()) {
				if (typeDeclaration.isInterface()) {
					rules.typeToInterface.apply(typeDeclaration);
				} else {
					rules.typeToClass.apply(typeDeclaration);
				}
			} else if (typeDeclaration.getParent() instanceof TypeDeclaration) {
				if (typeDeclaration.isInterface()) {
					rules.typeToInterfaceInner.apply(typeDeclaration);
				} else {
					rules.typeToClassInner.apply(typeDeclaration);
				}
			}
		} else {
			Classifier umlClassifier = getModelElement(typeDeclaration);
			
			if (umlClassifier != null) {
				
				// inner types:
				for (Object bodyDeclaration : typeDeclaration.bodyDeclarations()) {
					if (bodyDeclaration instanceof TypeDeclaration) {
						TypeDeclaration innerTypeDeclaration = (TypeDeclaration) bodyDeclaration;
						
						if (innerTypeDeclaration.isInterface()) {
							Interface umlNestedInterface = getModelElement((TypeDeclaration) innerTypeDeclaration);
							rules.typeToInterfaceInner.apply(umlClassifier, umlNestedInterface);
						} else {
							Class umlNestedClass = getModelElement((TypeDeclaration) innerTypeDeclaration);
							rules.typeToClassInner.apply(umlClassifier, umlNestedClass);
						}
					} else if (bodyDeclaration instanceof EnumDeclaration) {
						EnumDeclaration innerTypeDeclaration = (EnumDeclaration) bodyDeclaration;
						Enumeration umlNestedEnum = getModelElement((EnumDeclaration) innerTypeDeclaration);
						rules.enumToEnumerationInner.apply(umlClassifier, umlNestedEnum);
					}
				}
				
				// methods:
				for (MethodDeclaration method : typeDeclaration.getMethods()) {
					Operation umlOperation = getModelElement(method);
					rules.methodToOperation.apply((OperationOwner) umlClassifier, umlOperation);
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean visit(MethodDeclaration methodDeclaration) {
		if (!linker) {
			rules.methodToOperation.apply(methodDeclaration);
		} else {
			Operation umlOperation = getModelElement(methodDeclaration);
			
			if (umlOperation != null) {
				for (Object parameter : methodDeclaration.parameters()) {
					if (parameter instanceof SingleVariableDeclaration) {
						Parameter umlParameter = getModelElement((SingleVariableDeclaration) parameter);
						rules.variableToParameter.apply(umlOperation, umlParameter);
					}
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
				Parameter umlParameter = getModelElement(variableDeclaration);
				
				if (umlParameter != null) {
					rules.variableToParameter.link(variableDeclaration, umlParameter);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
