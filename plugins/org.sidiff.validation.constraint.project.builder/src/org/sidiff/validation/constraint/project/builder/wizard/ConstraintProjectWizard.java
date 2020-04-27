package org.sidiff.validation.constraint.project.builder.wizard;

import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.templates.ITemplateSection;
import org.eclipse.pde.ui.templates.NewPluginTemplateWizard;
import org.sidiff.validation.constraint.project.builder.template.ConstraintTemplateSection;

/**
 * This is a wizard for creating a new constraint plug-ins.
 * 
 * @author Manuel Ohrndorf
 */
public class ConstraintProjectWizard extends NewPluginTemplateWizard {

	@Override
	public void init(IFieldData data) {		
		super.init(data);
		setWindowTitle("Constraint Plug-in Project Wizard");
	}

	@Override
	public ITemplateSection[] createTemplateSections() {
		return new ITemplateSection[] { new ConstraintTemplateSection() };	
	}
	
	@Override
	public boolean canFinish() {
		ConstraintTemplateSection constraintTemplateSection = (ConstraintTemplateSection) getTemplateSections()[0];

		return super.canFinish() && constraintTemplateSection.canFinish();
	}
	
}