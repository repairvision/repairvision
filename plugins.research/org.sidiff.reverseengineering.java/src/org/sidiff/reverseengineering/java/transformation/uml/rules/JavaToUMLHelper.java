package org.sidiff.reverseengineering.java.transformation.uml.rules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralSpecification;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;
import org.sidiff.reverseengineering.java.transformation.uml.JavaASTTransformationUML;
import org.sidiff.reverseengineering.java.util.JavaASTUtil;

public class JavaToUMLHelper {
	
	protected static UMLFactory umlFactory = UMLFactory.eINSTANCE;
	
	protected static UMLPackage umlPackage = UMLPackage.eINSTANCE;
	
	protected JavaASTTransformationUML trafo;
	
	protected JavaToUMLRules rules;
	
	protected boolean umlCollectionEncoding = true;
	
	public void init(JavaASTTransformationUML trafo, JavaToUMLRules rules) {
		this.trafo = trafo;
		this.rules = rules;
	}
	
	public void cleanUp() {
		// avoids resource leaks
		this.trafo = null;
		this.rules = null;
	}
	
	public boolean isUmlCollectionEncoding() {
		return umlCollectionEncoding;
	}

	public void setUmlCollectionEncoding(boolean umlCollectionEncoding) {
		this.umlCollectionEncoding = umlCollectionEncoding;
	}
	
	public void finalize(List<EObject> rootElements) {
		for (EObject element : rootElements) {
			finalizeClass(element);
		}
	}

	protected void finalizeClass(EObject modelElement) {
		if (modelElement instanceof Class) {
			Class umlClass = (Class) modelElement;
			
			if (umlClass.getClassifierBehavior() != null) {
				for (Iterator<Behavior> behaviorIterator = umlClass.getClassifierBehavior().getOwnedBehaviors().iterator(); behaviorIterator.hasNext();) {
					Behavior operationBehavior = behaviorIterator.next();
					Interaction operationCalls = rules.blockToFunctionBehavior.getInteraction(operationBehavior);

					if (operationCalls.getActions().isEmpty()) {
						behaviorIterator.remove(); // clean up empty operation bodies
					} else {
						Set<Operation> calledOperations = new HashSet<>();

						for (Iterator<Action> actionIterator = operationCalls.getActions().iterator(); actionIterator.hasNext();) {
							Action operationCallAction = (Action) actionIterator.next();

							if (operationCallAction instanceof CallOperationAction) {
								Operation calledOperation = ((CallOperationAction) operationCallAction).getOperation();

								if (calledOperations.contains(calledOperation)) {
									actionIterator.remove(); // remove duplicated operation call
								} else {
									calledOperations.add(calledOperation);
								}
							}
						}
					}
				}
				
				if (umlClass.getClassifierBehavior().getOwnedBehaviors().isEmpty()) {
					// clean up classes without operation (calls)
					EcoreUtil.remove(umlClass.getClassifierBehavior());
				} 
			}

			// finalize nested classes:
			for (Classifier nestedClassifier : umlClass.getNestedClassifiers()) {
				finalizeClass(nestedClassifier);
			}
		}
	}

	public Comment createJavaDocComment(Element umlElement, Javadoc javadoc) {
		String javaDoc = JavaASTUtil.getJavaDoc(javadoc);
		Comment umlComment = umlFactory.createComment();
		umlComment.setBody(javaDoc);
		umlComment.getAnnotatedElements().add(umlElement);
		umlElement.getOwnedComments().add(umlComment);
		return umlComment;
	}
	
	public void setModifiers(EObject umlElement, BodyDeclaration javaBodyDeclaration) {
		setModifiers(umlElement, javaBodyDeclaration.getModifiers());
	}

	public void setModifiers(EObject umlElement, int modifiers) {
		
		if (umlElement instanceof Classifier) {
			((Classifier) umlElement).setIsAbstract(Modifier.isAbstract(modifiers));
			((Classifier) umlElement).setIsFinalSpecialization(Modifier.isFinal(modifiers));
			((Classifier) umlElement).setIsLeaf(Modifier.isFinal(modifiers));
		} else if (umlElement instanceof Operation) {
			((Operation) umlElement).setIsAbstract(Modifier.isAbstract(modifiers));
			((Operation) umlElement).setIsLeaf(Modifier.isFinal(modifiers));
			((Operation) umlElement).setIsStatic(Modifier.isStatic(modifiers));
		} else if (umlElement instanceof Property) {
			((Property) umlElement).setIsStatic(Modifier.isStatic(modifiers));
			((Property) umlElement).setIsLeaf(Modifier.isFinal(modifiers));
		}
		
		if (umlElement instanceof NamedElement) {
			setVisibility((NamedElement) umlElement, modifiers);
		}
	}
	
	protected void setVisibility(NamedElement umlElement, int modifiers) {
		if (Modifier.isPublic(modifiers)) {
			umlElement.setVisibility(VisibilityKind.PUBLIC_LITERAL);
		} else if (Modifier.isPrivate(modifiers)) {
			umlElement.setVisibility(VisibilityKind.PRIVATE_LITERAL);
		} else if (Modifier.isProtected(modifiers)) {
			umlElement.setVisibility(VisibilityKind.PROTECTED_LITERAL);
		} else {
			umlElement.setVisibility(VisibilityKind.PACKAGE_LITERAL);
		}
	}

	public void setType(TypedElement umlTypedElement, org.eclipse.jdt.core.dom.Type javaType) throws ClassNotFoundException {
		// Erase generic types -> most concrete bindable type:
		ITypeBinding originalBinding = javaType.resolveBinding();
		ITypeBinding typeBinding = JavaASTUtil.genericTypeErasure(originalBinding);
		typeBinding = JavaASTUtil.arrayTypeErasure(typeBinding);
		
		// For example List<String> -> String[0..*] {ordered=true, unique=false}:
		if (umlCollectionEncoding && (umlTypedElement instanceof MultiplicityElement)) {
			ITypeBinding collectionType = encodeCollectionType((MultiplicityElement) umlTypedElement, originalBinding, typeBinding);
			
			if (collectionType != null) {
				typeBinding = collectionType;
			}
		}
		
		// Resolve and set type:
		Type typeProxy = trafo.resolveBindingProxy(typeBinding, umlPackage.getType());
		umlTypedElement.setType(typeProxy);
	}
	
	public ITypeBinding encodeCollectionType(MultiplicityElement umlMultiplicityElement, ITypeBinding genericBinding, ITypeBinding erasedBinding) {
		
		// List<String> -> String[0..*] {ordered=true, unique=false}
		// Set<String> -> String[0..*] {ordered=false, unique=true}
		// LinkedHashSet<String>, TreeSet<String> -> String[0..*] {ordered=true, unique=true}
		// Raw Type List, Set -> Object[0..*] ...
		
		if (genericBinding.isParameterizedType() || genericBinding.isRawType()) {
			String qualifiedErasedTypeName = erasedBinding.getQualifiedName();

			if ((qualifiedErasedTypeName == null) || !qualifiedErasedTypeName.startsWith("java.util")) {
				return null;
			}

			if (qualifiedErasedTypeName.contains("List")) {
				ITypeBinding collectionType = getFirstTypeArgumentBinding(genericBinding);

				if (collectionType != null) {
					if (qualifiedErasedTypeName.equals(List.class.getCanonicalName())
							|| qualifiedErasedTypeName.equals(LinkedList.class.getCanonicalName())
							|| qualifiedErasedTypeName.equals(ArrayList.class.getCanonicalName())) {
						umlMultiplicityElement.setIsOrdered(true);
						umlMultiplicityElement.setIsUnique(false);
						umlMultiplicityElement.setLower(0);
						umlMultiplicityElement.setUpper(-1);
						return collectionType;
					}
				}
			}

			else if	(qualifiedErasedTypeName.contains("Set")) {
				ITypeBinding collectionType = getFirstTypeArgumentBinding(genericBinding);

				if (collectionType != null) {
					if (qualifiedErasedTypeName.equals(Set.class.getCanonicalName())
							|| qualifiedErasedTypeName.equals(HashSet.class.getCanonicalName())) {
						umlMultiplicityElement.setIsOrdered(false);
						umlMultiplicityElement.setIsUnique(true);
						umlMultiplicityElement.setLower(0);
						umlMultiplicityElement.setUpper(-1);
						return collectionType;
					} else if (qualifiedErasedTypeName.equals(TreeSet.class.getCanonicalName())
							|| qualifiedErasedTypeName.equals(LinkedHashSet.class.getCanonicalName())) {
						umlMultiplicityElement.setIsOrdered(true);
						umlMultiplicityElement.setIsUnique(true);
						umlMultiplicityElement.setLower(0);
						umlMultiplicityElement.setUpper(-1);
						return collectionType;
					}
				}
			}
		}
		
		return null;
	}
	
	protected ITypeBinding getFirstTypeArgumentBinding(ITypeBinding genericBinding) {
		if (genericBinding.isParameterizedType()) {
			ITypeBinding[] typeArguments = genericBinding.getTypeArguments();
			
			if ((typeArguments != null) && (typeArguments.length > 0)) {
				return typeArguments[0].getErasure();
			}
		} else if (genericBinding.isRawType()) {
			ITypeBinding typeDeclaration = genericBinding.getTypeDeclaration();
			
			if (typeDeclaration != null) {
				ITypeBinding[] typeParameters = typeDeclaration.getTypeParameters();
				
				if ((typeParameters != null) && (typeParameters.length > 0)) {
					return typeParameters[0].getErasure();
				}
			}
		}
		return null;
	}

	public void encodeArrayType(MultiplicityElement umlMultiplicityElement, org.eclipse.jdt.core.dom.Type javaType) {
		// Encode arrays with multiplicities:
		if (javaType.isArrayType()) {
			umlMultiplicityElement.setUpper(-1);
		}
	}

	public LiteralSpecification createLiteralValue(Expression expression, boolean convertNull) {
		
		if (expression != null) {
			String stringValue = expression.toString();
			
			switch (expression.getNodeType()) {
			case Expression.NULL_LITERAL:
				if (convertNull) {
					return umlFactory.createLiteralNull();
				} else {
					return null;
				}
			case Expression.BOOLEAN_LITERAL:
				LiteralBoolean valueBoolean = umlFactory.createLiteralBoolean();
				
				if (stringValue.equals("true")) {
					valueBoolean.setValue(true);
				} else if (stringValue.equals("false")) {
					valueBoolean.setValue(false);
				} else {
					return null;
				}
				
				return valueBoolean;
			case Expression.CHARACTER_LITERAL:
			case Expression.STRING_LITERAL:
				LiteralString valueCharacter = umlFactory.createLiteralString();
				// remove quotes 's' or "s"
				valueCharacter.setValue(stringValue.substring(1, stringValue.length() - 1));
				return valueCharacter;
			case Expression.NUMBER_LITERAL:
				try {
					if (stringValue.matches("[0-9]+")) {
						LiteralInteger valueInteger = umlFactory.createLiteralInteger();
						valueInteger.setValue(Integer.valueOf(stringValue));
						return valueInteger;
					} else {
						LiteralReal valueReal = umlFactory.createLiteralReal();
						valueReal.setValue(Double.valueOf(stringValue));
						return valueReal;
					}
				} catch (Exception e) {
					return null;
				}
			}
		}
		return null;
	}
}
