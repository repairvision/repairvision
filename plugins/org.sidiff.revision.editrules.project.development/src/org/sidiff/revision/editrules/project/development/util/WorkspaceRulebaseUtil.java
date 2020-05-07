package org.sidiff.revision.editrules.project.development.util;

import java.util.List;

import org.sidiff.revision.editrules.project.development.registry.WorkspaceRulebaseExtension;
import org.sidiff.revision.editrules.project.registry.RulebaseExtension;

public class WorkspaceRulebaseUtil {

	public static RulebaseExtension getRuntimeVersion(List<RulebaseExtension> rulebases, WorkspaceRulebaseExtension rulebase) {
		
		for (RulebaseExtension runtimeRulebase : rulebases) {
			if (!(runtimeRulebase instanceof WorkspaceRulebaseExtension)) {
				if (rulebase.equalsRuntime(runtimeRulebase)) {
					return runtimeRulebase;
				}
			}
		}
		
		return null;
	}
}
