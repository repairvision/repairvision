package org.sidiff.revision.editrules.project.builder.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.profile.constraints.util.ConstraintProfileUtil;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.editrules.project.RuleBasePlugin;

public class RuleBaseBuilderUtils {

	public static String getEditRuleFolder() {
		return RuleBasePlugin.EDIT_RULE_FOLDER + "/";
	}

	public static String getExampleFolder() {
		return RuleBasePlugin.EXAMPLE_FOLDER + "/";
	}

	public static String getExampleFolder(Bundle patternBundle) {
		return RuleBasePlugin.EXAMPLE_FOLDER + "/" + patternBundle.getName();
	}

	public static String getPatternPath(Pattern pattern) {
		StringBuilder patternPath = new StringBuilder();
		patternPath.append(pattern.getName());
		patternPath.append("/");

		while (pattern.eContainer() instanceof Pattern) {
			pattern = (Pattern) pattern.eContainer();
			patternPath.insert(0, "/");
			patternPath.insert(0, pattern.getName());
		}

		return patternPath.toString();
	}

	public static void createEditRuleFolders(IProject project, IProgressMonitor monitor) throws CoreException {
		WorkbenchUtil.createFolder(project, getEditRuleFolder(), monitor);
	}

	public static void createExampleFolders(Bundle patternBundle, IProject project, IProgressMonitor monitor)
			throws CoreException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 2);

		String exampleFolder = getExampleFolder();
		WorkbenchUtil.createFolder(project, exampleFolder, subMonitor.split(1));

		// Convert Constraint-Pattern tree to folder structure:
		for (EObject element : (Iterable<EObject>) () -> patternBundle.eResource().getAllContents()) {
			if (element instanceof Pattern) {
				if ((element instanceof Bundle) || ConstraintProfileUtil.isConstraint((Pattern) element)) {
					String patternFolder = getPatternPath((Pattern) element);
					WorkbenchUtil.createFolder(project, exampleFolder + patternFolder, subMonitor.split(1));
				}
			}
		}
	}
}
