package org.sidiff.reverseengineering.java.transformation.uml;

import org.eclipse.jdt.core.dom.IBinding;
import org.sidiff.reverseengineering.java.transformation.JavaASTBindingTranslator;
import org.sidiff.reverseengineering.java.util.JavaASTUtil;

/**
 * Maps Java AST bindings to UML XMI object ID bindings.
 * 
 * @author Manuel Ohrndorf
 */
public class JavaASTBindingTranslatorUML extends JavaASTBindingTranslator {
	
	public JavaASTBindingTranslatorUML() {
		super();
	}

	@Override
	public String getBindingKey(String projectName, IBinding binding) {
		binding = JavaASTUtil.arrayTypeErasure(binding);
		binding = JavaASTUtil.genericTypeErasure(binding);
		return super.getBindingKey(projectName, binding);
	}
}
