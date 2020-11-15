package org.sidiff.reverseengineering.java.transformation.uml;

import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.OperationOwner;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.sidiff.reverseengineering.java.transformation.JavaASTTransformation;
import org.sidiff.reverseengineering.java.transformation.uml.rulebase.JavaToUMLRules;

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
	public void apply() {
		this.rules.init(this);
       	
		// Create model graph nodes:
    	getJavaAST().accept(this);
		
    	// Create model graph edges:
		this.linker = true;
		getJavaAST().accept(this);
		
		// Finalize model graph:
		// TODO Method invocations
//		this.rules.javaToUMLHelper.finalize(getRootModelElements());
		
		// Clean up resources:
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
				
				// properties:
				for (FieldDeclaration fieldDeclaration : typeDeclaration.getFields()) {

					// For example: public String a1, a2, a3;
					for (Object fieldDeclarationFragment : fieldDeclaration.fragments()) {
						if (fieldDeclarationFragment instanceof VariableDeclarationFragment) {
							Property umlProperty = getModelElement((VariableDeclarationFragment) fieldDeclarationFragment);
							
							if (umlProperty != null) {
								rules.fieldToProperty.apply(umlClassifier, umlProperty);
							}
						}
					}
				}
				
				// methods:
				for (MethodDeclaration method : typeDeclaration.getMethods()) {
					Operation umlOperation = getModelElement(method);
					rules.methodToOperation.apply((OperationOwner) umlClassifier, umlOperation);
					
					// TODO Method invocations
//					// method body:
//					if (umlClassifier instanceof Class) {
//						Class umlClass = (Class) umlClassifier; // only classes have method bodies...
//						Behavior classBehavior = umlClass.getClassifierBehavior();
//						FunctionBehavior operationBehavior = getModelElement(method.getBody());
//						
//						if ((operationBehavior != null) && (classBehavior != null)) {
//							rules.blockToFunctionBehavior.apply(classBehavior, operationBehavior);
//						}
//					}
				}
				
				// super types and interfaces:
				try {
					if (typeDeclaration.isPackageMemberTypeDeclaration()) {
						if (umlClassifier instanceof Class) {
							rules.typeToClass.link(typeDeclaration, (Class) umlClassifier);
						} else if (umlClassifier instanceof Interface) {
							rules.typeToInterface.link(typeDeclaration, (Interface) umlClassifier);
						}
					} else if (typeDeclaration.getParent() instanceof TypeDeclaration) {
						if (umlClassifier instanceof Class) {
							rules.typeToClassInner.link(typeDeclaration, (Class) umlClassifier);
						} else if (umlClassifier instanceof Interface) {
							rules.typeToInterfaceInner.link(typeDeclaration, (Interface) umlClassifier);
						}
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean visit(FieldDeclaration fieldDeclaration) {
		if (!linker) {
			
			// For example: public String a1, a2, a3;
			for (Object fieldDeclarationFragment : fieldDeclaration.fragments()) {
				if (fieldDeclarationFragment instanceof VariableDeclarationFragment) {
					rules.fieldToProperty.apply((VariableDeclarationFragment) fieldDeclarationFragment);
				}
			}
		} else {
			try {
				// For example: public String a1, a2, a3;
				for (Object fieldDeclarationFragment : fieldDeclaration.fragments()) {
					if (fieldDeclarationFragment instanceof VariableDeclarationFragment) {
						Property umlProperty = getModelElement((VariableDeclarationFragment) fieldDeclarationFragment);
						
						if (umlProperty != null) {
							rules.fieldToProperty.link((VariableDeclarationFragment) fieldDeclarationFragment, umlProperty);
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
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
				
				// in parameter:
				for (Object parameter : methodDeclaration.parameters()) {
					if (parameter instanceof SingleVariableDeclaration) {
						Parameter umlParameter = getModelElement((SingleVariableDeclaration) parameter);
						rules.variableToParameter.apply(umlOperation, umlParameter);
					}
				}
				
				// return parameter:
				try {
					rules.methodToOperation.link(methodDeclaration, umlOperation);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
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

	// TODO Method invocations
//	@Override
//	public boolean visit(Block block) {
//		if (!linker) {
//			if (block.getParent() instanceof MethodDeclaration) {
//				rules.blockToFunctionBehavior.apply(block);
//			}
//		} else {
//			FunctionBehavior operationBehavior = getModelElement(block);
//			
//			if (operationBehavior != null) {
//				try {
//					rules.blockToFunctionBehavior.link(block, operationBehavior);
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		return true;
//	}
//	
//	@Override
//	public boolean visit(MethodInvocation methodInvocation) {
//		if (!linker) {
//			rules.methodInvocationToCallOperationAction.apply(methodInvocation);
//		} else {
//			CallOperationAction callOperation = getModelElement(methodInvocation);
//			FunctionBehavior operationBehavior = getParentModelElement(methodInvocation, UMLPackage.eINSTANCE.getFunctionBehavior());
//			
//			if ((operationBehavior != null) && (callOperation != null)) {
//				rules.methodInvocationToCallOperationAction.apply(operationBehavior, callOperation);
//				
//				try {
//					rules.methodInvocationToCallOperationAction.link(methodInvocation, callOperation);
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return true;
//	}
}
