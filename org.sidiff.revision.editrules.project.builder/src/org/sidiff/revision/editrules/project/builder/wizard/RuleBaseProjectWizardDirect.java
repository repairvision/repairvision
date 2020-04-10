package org.sidiff.revision.editrules.project.builder.wizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.pde.internal.ui.elements.ElementList;
import org.eclipse.pde.internal.ui.wizards.plugin.ContentPage;
import org.eclipse.pde.internal.ui.wizards.plugin.NewPluginProjectWizard;
import org.eclipse.pde.internal.ui.wizards.plugin.TemplateListSelectionPage;
import org.eclipse.pde.ui.IPluginContentWizard;

/**
 * This is a wizard for creating a new rulebase plug-ins.
 * 
 * @author Manuel Ohrndorf
 */
@SuppressWarnings("restriction")
public class RuleBaseProjectWizardDirect extends NewPluginProjectWizard {
	
	@Override
	public void addPage(IWizardPage page) {

		if (page instanceof TemplateListSelectionPage) {
			try {
				// Replace template selection page with rulebase pages:
				TemplateListSelectionPage templates = (TemplateListSelectionPage) page;
				
		        // Access private member: fWizardListPage
		        final Class<NewPluginProjectWizard> pluginWizardClass = NewPluginProjectWizard.class;
		        final java.lang.reflect.Field field = pluginWizardClass.getDeclaredField("fWizardListPage");
		        field.setAccessible(true);

				// Replace template selection page field:
		        RulebaseTemplate rulebaseTemplate = new RulebaseTemplate(templates.getWizardElements(), fContentPage, templates.getMessage());
		        field.set(this, rulebaseTemplate);
		        
				// Add rulebase wizard pages:
		        rulebaseTemplate.rulebaseWizard.addPages();
				
				for (IWizardPage rulebasePage : rulebaseTemplate.rulebaseWizard.getPages()) {
					addPage(rulebasePage);
				}
				
				// Set window title:
				this.setWindowTitle("Rule-Base Plug-In Project");
			} catch (Exception e) {
				// Normal behavior:
				super.addPage(page);
			}
		} else {
			// Normal behavior:
			super.addPage(page);
		}
	}
	
	private class RulebaseTemplate extends TemplateListSelectionPage {
		
		public RuleBaseProjectWizard rulebaseWizard;

		public RulebaseTemplate(ElementList wizardElements, ContentPage page, String message) {
			super(wizardElements, page, message);
			rulebaseWizard = new RuleBaseProjectWizard();
		}
		
		@Override
		public IPluginContentWizard getSelectedWizard() {
			return rulebaseWizard;
		}
	}
}
