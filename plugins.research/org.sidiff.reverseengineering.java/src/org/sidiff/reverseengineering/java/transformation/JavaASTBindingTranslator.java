package org.sidiff.reverseengineering.java.transformation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.core.dom.IBinding;

/**
 * Maps Java AST bindings to EMF XMI object ID bindings.
 * 
 * @author Manuel Ohrndorf
 */
public class JavaASTBindingTranslator {
	
	private Pattern genericParameter = Pattern.compile("(.*?)(<.*?>)(.*?)");

	/**
	 * @param projectName The name of the containing project
	 * @param binding The Java AST binding.
	 * @return The corresponding unique binding key.
	 */
	public String getBindingKey(String projectName, IBinding binding) {
		return getBindingKey(projectName, binding.getKey());
	}
	
	/**
	 * @param projectName The name of the containing project
	 * @param binding The Java AST binding.
	 * @return The corresponding unique binding key.
	 */
	public String getBindingKey(String projectName, String bindingKey) {
		
		// Include project in namespace.
		String uniqueBindingKey = projectName + "/" + bindingKey;
		
		// Characters <> from Java generic are not allowed as XML attributes.
		// Generic are not needed for a unique key -> remove <E>.
		Matcher matcher = genericParameter.matcher(uniqueBindingKey);
		uniqueBindingKey = matcher.replaceAll("$1$3");
		
		return uniqueBindingKey;
	}
}
