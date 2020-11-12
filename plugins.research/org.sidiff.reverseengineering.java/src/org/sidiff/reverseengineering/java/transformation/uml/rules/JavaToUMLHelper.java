package org.sidiff.reverseengineering.java.transformation.uml.rules;

import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralSpecification;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
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
	
	public void init(JavaASTTransformationUML trafo) {
		this.trafo = trafo;
	}
	
	public void cleanUp() {
		// avoids resource leaks
		this.trafo = null;
	}
	
	public Comment createJavaDocComment(Element umlElement, Javadoc javadoc) {
		String javaDoc = JavaASTUtil.getJavaDoc(javadoc);
		Comment umlComment = umlFactory.createComment();
		umlComment.setBody(javaDoc);
		umlComment.getAnnotatedElements().add(umlElement);
		umlElement.getOwnedComments().add(umlComment);
		return umlComment;
	}
	
	public void setVisibility(NamedElement umlElement, BodyDeclaration javaBodyDeclaration) {
		setVisibility(umlElement, javaBodyDeclaration.getModifiers());
	}
	
	public void setVisibility(NamedElement umlElement, int modifiers) {
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
		ITypeBinding variableType = JavaASTUtil.genericTypeErasure(javaType.resolveBinding());
		variableType = JavaASTUtil.arrayTypeErasure(variableType);
		
		// Resolve and set type:
		Type type = trafo.resolveBinding(variableType, umlPackage.getType());
		umlTypedElement.setType((Type) type);
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
