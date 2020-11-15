package org.sidiff.reverseengineering.java.transformation.uml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.logging.Level;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.OperationOwner;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.sidiff.reverseengineering.java.Activator;
import org.sidiff.reverseengineering.java.transformation.JavaASTTransformation;
import org.sidiff.reverseengineering.java.transformation.uml.rulebase.JavaToUMLRules;
import org.sidiff.reverseengineering.java.util.JavaASTUtil;

/**
 * Implementation of a Java AST to a UML model transformation.
 * 
 * @author Manuel Ohrndorf
 */
public class JavaASTTransformationUML extends JavaASTTransformation {
	
	private boolean linker = false;
	
	private boolean includeMethodBodies = true;
	
	private JavaToUMLRules rules;
	
	private TreeMap<Integer, EObject> lineToModel = new TreeMap<>();
	
	public JavaASTTransformationUML(JavaToUMLRules rules, boolean includeMethodBodies) {
		this.rules = rules;
		this.includeMethodBodies = includeMethodBodies;
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
		this.rules.getTransformations().forEach(rule -> rule.finalizing(getRootModelElements()));
		
		// Clean up resources:
		this.rules.cleanUp();
	}
	
	public boolean isIncludeMethodBodies() {
		return includeMethodBodies;
	}
	
	public void setIncludeMethodBodies(boolean includeMethodBodies) {
		this.includeMethodBodies = includeMethodBodies;
	}
	
	@Override
	public boolean visit(EnumDeclaration enumDeclaration) {
		if (!linker) {
			if (enumDeclaration.isPackageMemberTypeDeclaration()) {
				rules.enumToEnumeration.apply(enumDeclaration);
			} else if (enumDeclaration.getParent() instanceof AbstractTypeDeclaration) {
				// class, interface, annotation
				rules.enumToEnumerationInner.apply(enumDeclaration);
			}
		} else {
			Enumeration umlEnumeration = getModelElement(enumDeclaration);
			
			if (umlEnumeration != null) {
				for (Object enumConstant : enumDeclaration.enumConstants()) {
					if (enumConstant instanceof EnumConstantDeclaration) {
						EnumerationLiteral umlEnumerationLiteral = getModelElement((EnumConstantDeclaration) enumConstant);
						rules.enumConstantToEnumerationLiteral.apply(umlEnumeration, umlEnumerationLiteral);
					}
				}
				
				// log line mapping: enum
				traceLineToModelElement(JavaASTUtil.getLastLine(getJavaAST(), enumDeclaration), umlEnumeration);
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
	public boolean visit(AnnotationTypeDeclaration annotationTypeDeclaration) {
		if (!linker) {
			if (annotationTypeDeclaration.isPackageMemberTypeDeclaration()) {
				rules.annotationTypeToInterface.apply(annotationTypeDeclaration);
			} else {
				rules.annotationTypeToInterfaceInner.apply(annotationTypeDeclaration);
			}
		} else {
			Interface umlAnnotationInterface = getModelElement(annotationTypeDeclaration);
			
			if (umlAnnotationInterface != null) {
				// properties:
				for (Object bodyDeclaration : annotationTypeDeclaration.bodyDeclarations()) {

					// fields:
					if (bodyDeclaration instanceof FieldDeclaration) {
						for (Object fieldDeclarationFragment : ((FieldDeclaration) bodyDeclaration).fragments()) {
							if (fieldDeclarationFragment instanceof VariableDeclarationFragment) {
								Property umlProperty = getModelElement((VariableDeclarationFragment) fieldDeclarationFragment);
								
								if (umlProperty != null) {
									rules.fieldToProperty.apply(umlAnnotationInterface, umlProperty);
								}
							}
						}
					}
					
					// methods:
					if (bodyDeclaration instanceof AnnotationTypeMemberDeclaration) {
						Operation annotationOperation = getModelElement((AnnotationTypeMemberDeclaration) bodyDeclaration);
						
						if (annotationOperation != null) {
							rules.annotationTypeMemberToOperation.apply(umlAnnotationInterface, annotationOperation);
						}
					}
					
					// enumeration:
					if (bodyDeclaration instanceof EnumDeclaration) {
						Enumeration annotationEnumeration = getModelElement((EnumDeclaration) bodyDeclaration);
						
						if (annotationEnumeration != null) {
							rules.enumToEnumerationInner.apply(umlAnnotationInterface, annotationEnumeration);
						}
					}
				}
				
				// log line mapping: @interface
				if (!annotationTypeDeclaration.bodyDeclarations().isEmpty()) {
					// Assume class declaration end where the first body statement begins:
					traceLineToModelElement(JavaASTUtil.getFirstLine(getJavaAST(), (ASTNode) annotationTypeDeclaration.bodyDeclarations().get(0)) - 1, umlAnnotationInterface);
					traceLineToModelElement(JavaASTUtil.getLastLine(getJavaAST(), annotationTypeDeclaration), umlAnnotationInterface); // tail
				} else {
					traceLineToModelElement(JavaASTUtil.getLastLine(getJavaAST(), annotationTypeDeclaration), umlAnnotationInterface);
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean visit(AnnotationTypeMemberDeclaration memberDeclaration) {
		if (!linker) {
			rules.annotationTypeMemberToOperation.apply(memberDeclaration);
		} else {
			Operation annotationOperation = getModelElement(memberDeclaration);
			
			if (annotationOperation != null) {
				try {
					rules.annotationTypeMemberToOperation.link(memberDeclaration, annotationOperation);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				// log line mapping: @interface operation
				traceLineToModelElement(JavaASTUtil.getLastLine(getJavaAST(), memberDeclaration), annotationOperation);
			}
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
					
					// method invocations:
					if (includeMethodBodies) {
						rules.typeToClassWithInteraction.apply(typeDeclaration);
					}
				}
			} else if (typeDeclaration.getParent() instanceof TypeDeclaration) {
				if (typeDeclaration.isInterface()) {
					rules.typeToInterfaceInner.apply(typeDeclaration);
				} else {
					rules.typeToClassInner.apply(typeDeclaration);
					
					// method invocations:
					if (includeMethodBodies) {
						rules.typeToClassWithInteraction.apply(typeDeclaration);
					}
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
							Interface umlNestedInterface = getModelElement(innerTypeDeclaration);
							rules.typeToInterfaceInner.apply(umlClassifier, umlNestedInterface);
						} else {
							Class umlNestedClass = getModelElement(innerTypeDeclaration);
							rules.typeToClassInner.apply(umlClassifier, umlNestedClass);
						}
					} else if (bodyDeclaration instanceof EnumDeclaration) {
						EnumDeclaration innerTypeDeclaration = (EnumDeclaration) bodyDeclaration;
						Enumeration umlNestedEnum = getModelElement(innerTypeDeclaration);
						rules.enumToEnumerationInner.apply(umlClassifier, umlNestedEnum);
					} else if (bodyDeclaration instanceof AnnotationTypeDeclaration) {
						AnnotationTypeDeclaration innerTypeDeclaration = (AnnotationTypeDeclaration) bodyDeclaration;
						Interface umlNestedAnnotationInterface = getModelElement(innerTypeDeclaration);
						rules.annotationTypeToInterfaceInner.apply(umlClassifier, umlNestedAnnotationInterface);
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
					
					if (umlOperation != null) {
						rules.methodToOperation.apply((OperationOwner) umlClassifier, umlOperation);
					}
					
					// method body:
					if (includeMethodBodies && (umlClassifier instanceof Class)) {
						Class umlClass = (Class) umlClassifier; // only classes have method bodies...
						Behavior classBehavior = umlClass.getClassifierBehavior();
						FunctionBehavior operationBehavior = getModelElement(method.getBody());
						
						if ((operationBehavior != null) && (classBehavior != null)) {
							rules.blockToFunctionBehavior.apply(classBehavior, operationBehavior);
						}
					}
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
			
			// log line mapping: root/inner class/interface
			if (!typeDeclaration.bodyDeclarations().isEmpty()) {
				// Assume class declaration end where the first body statement begins:
				traceLineToModelElement(JavaASTUtil.getFirstLine(getJavaAST(), (ASTNode) typeDeclaration.bodyDeclarations().get(0)) - 1, umlClassifier);
				traceLineToModelElement(JavaASTUtil.getLastLine(getJavaAST(), typeDeclaration), umlClassifier); // tail
			} else {
				traceLineToModelElement(JavaASTUtil.getLastLine(getJavaAST(), typeDeclaration), umlClassifier);
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
			// For example: public String a1, a2, a3;
			for (Object fieldDeclarationFragment : fieldDeclaration.fragments()) {
				if (fieldDeclarationFragment instanceof VariableDeclarationFragment) {
					Property umlProperty = getModelElement((VariableDeclarationFragment) fieldDeclarationFragment);

					if (umlProperty != null) {
						try {
							rules.fieldToProperty.link((VariableDeclarationFragment) fieldDeclarationFragment, umlProperty);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}

						// log line mapping: property
						traceLineToModelElement(JavaASTUtil.getLastLine(getJavaAST(), (ASTNode) fieldDeclarationFragment), umlProperty);
					}
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
				
				// log line mapping: operation
				traceLineToModelElement(JavaASTUtil.getLastLine(getJavaAST(), methodDeclaration), umlOperation);
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

	@Override
	public boolean visit(Block block) {
		
		// Skip method bodies!
		if (!includeMethodBodies) {
			return false;
		}
		
		if (!linker) {
			if (block.getParent() instanceof MethodDeclaration) {
				rules.blockToFunctionBehavior.apply(block);
			}
		} else {
			FunctionBehavior operationBehavior = getModelElement(block);
			
			if (operationBehavior != null) {
				try {
					rules.blockToFunctionBehavior.link(block, operationBehavior);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}
	
	@Override
	public boolean visit(MethodInvocation methodInvocation) {
		
		// Skip method invocations!
		if (!includeMethodBodies) {
			return false;
		}
		
		if (isInScope(methodInvocation)) {
			if (!linker) {
				rules.methodInvocationToCallOperationAction.apply(methodInvocation);
			} else {
				CallOperationAction callOperation = getModelElement(methodInvocation);
				FunctionBehavior operationBehavior = getParentModelElement(methodInvocation, UMLPackage.eINSTANCE.getFunctionBehavior());
				
				if ((operationBehavior != null) && (callOperation != null)) {
					rules.methodInvocationToCallOperationAction.apply(operationBehavior, callOperation);
					
					try {
						rules.methodInvocationToCallOperationAction.link(methodInvocation, callOperation);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return true;
	}

	public boolean isInScope(MethodInvocation methodInvocation) {
		String projectName = null;
		ITypeBinding methodDeclaringBinding = null;
		
		try {
			IMethodBinding methodBinding = methodInvocation.resolveMethodBinding();
			
			if (methodBinding.getJavaElement() != null) {
				methodDeclaringBinding =  methodBinding.getDeclaringClass();
				projectName = methodDeclaringBinding.getJavaElement().getJavaProject().getProject().getName();
			}
		} catch (Throwable t) {
			return false;
		}
		
		if ((projectName != null) && (methodDeclaringBinding != null)) {
			return getBindingResolver().isInScope(projectName, methodDeclaringBinding);
		}
		
		return false;
	}

	public List<EObject> getModelElementsByLine(Iterable<Integer> lines) {
		if (lineToModel.isEmpty()) {
			return Collections.emptyList();
		}
		
		List<EObject> modelElements = new ArrayList<>();
		
		for (Integer line : lines) {
			Entry<Integer, EObject> lineMatch = lineToModel.ceilingEntry(line);
			
			if (lineMatch != null) {
				modelElements.add(lineMatch.getValue());
			} else {
				// assign space after last operation/declaration to the class
				modelElements.add(lineToModel.firstEntry().getValue());
			}
		}
		
		return modelElements;
	}
	
	protected void traceLineToModelElement(int lastLine, EObject modelElement) {
		if ((modelElement != null) && !lineToModel.containsKey(lastLine)) {
			if ((modelElement.eContainer() != null) || (getRootModelElements().contains(modelElement))) {
				this.lineToModel.put(lastLine, modelElement);
			} else {
				if (Activator.getLogger().isLoggable(Level.FINE)) {
					Activator.getLogger().log(Level.FINE, "Model element is not contained in a resource: " + modelElement);
				}
			}
		}
	}

	public String dumpLineToModelElement() {
		StringBuilder dump = new StringBuilder();
		
		for (Entry<Integer, EObject> lineEntry : lineToModel.entrySet()) {
			dump.append(lineEntry.getKey());
			dump.append(": ");
			dump.append(lineEntry.getValue());
			dump.append("\n");
		}
		
		return dump.toString();
	}
}
