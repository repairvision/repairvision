package org.sidiff.validation.constraint.project.builder.wizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.pde.internal.ui.elements.ElementList;
import org.eclipse.pde.internal.ui.wizards.plugin.ContentPage;
import org.eclipse.pde.internal.ui.wizards.plugin.NewPluginProjectWizard;
import org.eclipse.pde.internal.ui.wizards.plugin.TemplateListSelectionPage;
import org.eclipse.pde.ui.IPluginContentWizard;

/**
 * This is a wizard for creating a new constraint plug-ins.
 * 
 * @author Manuel Ohrndorf
 */
@SuppressWarnings("restriction")
public class ConstraintProjectWizardDirect extends NewPluginProjectWizard {
	
	@Override
	public void addPage(IWizardPage page) {

		if (page instanceof TemplateListSelectionPage) {
			try {
				// Replace template selection page with constraint pages:
				TemplateListSelectionPage templates = (TemplateListSelectionPage) page;
				
		        // Access private member: fWizardListPage
		        final Class<NewPluginProjectWizard> pluginWizardClass = NewPluginProjectWizard.class;
		        final java.lang.reflect.Field field = pluginWizardClass.getDeclaredField("fWizardListPage");
		        field.setAccessible(true);

				// Replace template selection page field:
		        ConstraintTemplate constraintTemplate = new ConstraintTemplate(templates.getWizardElements(), fContentPage, templates.getMessage());
		        field.set(this, constraintTemplate);
		        
				// Add constraint wizard pages:
		        constraintTemplate.constraintWizard.addPages();
				
				for (IWizardPage constraintPage : constraintTemplate.constraintWizard.getPages()) {
					addPage(constraintPage);
				}
				
				// Set window title:
				this.setWindowTitle("Constraint Plug-In Project");
			} catch (Exception e) {
				// Normal behavior:
				super.addPage(page);
			}
		} else {
			// Normal behavior:
			super.addPage(page);
		}
	}
	
	private class ConstraintTemplate extends TemplateListSelectionPage {
		
		public ConstraintProjectWizard constraintWizard;

		public ConstraintTemplate(ElementList wizardElements, ContentPage page, String message) {
			super(wizardElements, page, message);
			constraintWizard = new ConstraintProjectWizard();
		}
		
		@Override
		public IPluginContentWizard getSelectedWizard() {
			return constraintWizard;
		}
	}
}
