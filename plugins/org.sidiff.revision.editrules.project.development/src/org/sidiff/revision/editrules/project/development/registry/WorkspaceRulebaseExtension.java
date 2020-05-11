package org.sidiff.revision.editrules.project.development.registry;

import org.sidiff.revision.editrules.project.registry.RulebaseExtension;

public class WorkspaceRulebaseExtension extends RulebaseExtension {

	private RulebaseExtension runtime;
	
	public WorkspaceRulebaseExtension(String projectName, String runtimeName, String workspaceName, String documentType, String folder) {
		super(projectName, workspaceName, documentType, folder);
		this.runtime = new RulebaseExtension(projectName, runtimeName, documentType, folder);
	}

	public String getRuntimeName() {
		return runtime.getName();
	}
	
	public boolean equalsRuntime(RulebaseExtension runtime) {
		return this.runtime.equals(runtime);
	}
}
