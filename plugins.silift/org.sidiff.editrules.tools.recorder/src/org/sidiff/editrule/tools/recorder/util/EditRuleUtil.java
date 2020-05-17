package org.sidiff.editrule.tools.recorder.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;

public class EditRuleUtil {
	
	public static Set<EPackage> getImports(Module editRule) {
		Set<EPackage> imports = new HashSet<>();
		
		editRule.eAllContents().forEachRemaining(element -> {
			if (element instanceof Node) {
				imports.add(((Node) element).getType().getEPackage());
			}
		});
		
		return imports;
	}
}
