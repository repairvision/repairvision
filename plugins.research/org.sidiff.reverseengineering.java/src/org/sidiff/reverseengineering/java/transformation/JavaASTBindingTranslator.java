package org.sidiff.reverseengineering.java.transformation;

import org.eclipse.jdt.core.dom.IBinding;

/**
 * Maps Java AST bindings to EMF XMI object ID bindings.
 * 
 * @author Manuel Ohrndorf
 */
public class JavaASTBindingTranslator {

	/**
	 * @param projectName The name of the containing project
	 * @param binding The Java AST binding.
	 * @return The corresponding unique binding key.
	 */
	public String getBindingKey(String projectName, IBinding binding) {
		
		// Include project in namespace.
		String bindingKey = projectName + "/" + binding.getKey();
		
		// Characters <> from Java generic are not allowed as XML attributes.
		bindingKey = bindingKey.replaceAll("[<>]", "/");
		
		return bindingKey;
	}
}
