package org.sidiff.reverseengineering.java.util;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.PrimitiveType.Code;
import org.eclipse.jdt.core.dom.Type;

/**
 * Some convenient functions.
 * 
 * @author Manuel Ohrndorf
 */
public class JavaASTUtil {

	/**
	 * Searches for the outermost binding of a type binding, e.g., of inner classes.
	 * 
	 * @param astBinding A type binding.
	 * @return The binding of the outer type.
	 */
	public static ITypeBinding getOuterTypeBinding(ITypeBinding astBinding) {
		while ((astBinding != null) && astBinding.getDeclaringClass() != null) {
			astBinding = astBinding.getDeclaringClass();
		}
		return astBinding;
	}
	
	/**
	 * If the binding is an array type binding it returns the simple type of the
	 * array; returns the given binding otherwise.
	 * 
	 * @param astBinding A type binding.
	 * @return The unwrapped array type or the given binding.
	 */
	public static IBinding arrayTypeErasure(IBinding astBinding) {
		if (astBinding instanceof ITypeBinding) {
			return arrayTypeErasure((ITypeBinding) astBinding);
		}
		return astBinding;
	}
	
	/**
	 * If the binding is an array type binding it returns the simple type of the
	 * array; returns the given binding otherwise.
	 * 
	 * @param astBinding A type binding.
	 * @return The unwrapped array type or the given binding.
	 */
	public static ITypeBinding arrayTypeErasure(ITypeBinding astBinding) {
		if (((ITypeBinding) astBinding).isArray()) {
			return ((ITypeBinding) astBinding).getElementType();
		}
		return astBinding;
	}
	
	/**
	 * @param astBindin A type binding.
	 * @return The binding without generics; or the original binding.
	 */
	public static IBinding genericTypeErasure(IBinding astBinding) {
		if (astBinding instanceof ITypeBinding) {
			ITypeBinding typeBinding =  (ITypeBinding) astBinding;
					
			if (typeBinding.isParameterizedType() || typeBinding.isGenericType()) {
				astBinding = genericTypeErasure(typeBinding);
			}
		}
		return astBinding;
	}

	/**
	 * @param binding A Java AST binding.
	 * @return The erasure of this type binding.
	 */
	public static ITypeBinding genericTypeErasure(ITypeBinding binding) {
		return binding.getErasure();
	}
	
	/**
	 * @param type              The Java AST type node.
	 * @param primitiveTypeCode The code of the primitive type
	 *                          {@link PrimitiveType}.
	 * @return <code>true</code> if the given types are equal; <code>false</code>
	 *         otherwise.
	 */
	public static boolean isPrimitiveType(Type type, Code primitiveTypeCode) {
		if ((type != null) && (type instanceof PrimitiveType)) {
			return ((PrimitiveType) type).getPrimitiveTypeCode().equals(primitiveTypeCode);
		}
		return false;
	}
	
	/**
	 * Calculates the lines in the source code file for a node in the AST.
	 * 
	 * @param javaAST The source code's AST.
	 * @param node    A node in the AST.
	 * @return The corresponding start and end line of the AST node.
	 */
	public static int[] getLineRange(CompilationUnit javaAST, ASTNode node) {
		int startPosition = node.getStartPosition();
		int endPosition = startPosition + node.getLength();
		int startLine = javaAST.getLineNumber(startPosition);
		int endLine = javaAST.getLineNumber(endPosition);
		return new int[] { startLine, endLine };
	}
	
	/**
	 * @param javadoc The AST JavaDoc.
	 * @return The JavaDoc text without asterisk.
	 */
	public static String getJavaDoc(Javadoc javadoc) {
		String javaDoc = javadoc.toString().replaceAll("(?m)(^\\s*?\\*/)|(^\\s*?/\\**)|(^\\s*?\\*\\s?)", "");
		return javaDoc.trim();
	}
}
