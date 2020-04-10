package org.sidiff.revision.editrules.project.builder.wizard;

import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.templates.ITemplateSection;
import org.eclipse.pde.ui.templates.NewPluginTemplateWizard;
import org.sidiff.revision.editrules.project.builder.template.RuleBaseTemplateSection;

/**
 * This is a simple wizard for creating a new model file.
 * 
 * @author Manuel Ohrndorf
 */
public class RuleBaseProjectWizard extends NewPluginTemplateWizard {

	@Override
	public void init(IFieldData data) {		
		super.init(data);
		setWindowTitle("Edit Rules Plug-in Project Wizard");
	}

	@Override
	public ITemplateSection[] createTemplateSections() {
		return new ITemplateSection[] { new RuleBaseTemplateSection() };	
	}
}
