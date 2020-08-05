package org.sidiff.revision.editrules.project.builder.template;

import static org.sidiff.revision.editrules.project.builder.util.RuleBaseBuilderUtils.createEditRuleFolders;
import static org.sidiff.revision.editrules.project.builder.util.RuleBaseBuilderUtils.createExampleFolders;
import static org.sidiff.revision.editrules.project.builder.util.RuleBaseBuilderUtils.getEditRuleFolder;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.templates.OptionTemplateSection;
import org.eclipse.pde.ui.templates.PluginReference;
import org.osgi.framework.Constants;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.editrules.project.RuleBasePlugin;
import org.sidiff.revision.editrules.project.builder.Activator;
import org.sidiff.revision.editrules.project.builder.nature.RuleBaseProjectNature;
import org.sidiff.revision.editrules.project.builder.template.ASGPatternBundle.DiagramURI;
import org.sidiff.revision.editrules.project.builder.wizard.RuleBaseProjectPageEditRules;
import org.sidiff.validation.laguage.fol.util.EMFMetaAccessUtil;

/**
 * Defines the PDE template for creating a rulebase plug-in project.
 * 
 * @author Manuel Ohrndorf
 */
public class RuleBaseTemplateSection extends OptionTemplateSection {
	
	private RuleBaseProjectPageEditRules pageEditRules;
	
	public RuleBaseTemplateSection() {
		addOption(KEY_PACKAGE_NAME, RuleBaseTemplateSection.KEY_PACKAGE_NAME, (String) null, 0);
		setPageCount(1);
	}
	
	@Override
	public String getUsedExtensionPoint() {
		return RuleBasePlugin.EXTENSION_POINT_ID;
	}

	@Override
	public String getSectionId() {
		return "plugin";
	}

	@Override
	protected ResourceBundle getPluginResourceBundle() {
		org.osgi.framework.Bundle bundle = Platform.getBundle(Activator.getPluginId());
		return Platform.getResourceBundle(bundle);
	}

	@Override
	protected URL getInstallURL() {
		return Activator.getDefault().getInstallURL();
	}

	@Override
	protected void updateModel(IProgressMonitor monitor) throws CoreException {
		addRuleBaseExtension();
		addRuleBaseNature();
		
		setManifestHeader(Constants.BUNDLE_ACTIVATIONPOLICY, Constants.ACTIVATION_LAZY);
	}
	
	private void addRuleBaseExtension() throws CoreException {
		IPluginBase plugin = model.getPluginBase();
		IPluginModelFactory factory = model.getPluginFactory();
		IPluginExtension extension = createExtension(RuleBasePlugin.EXTENSION_POINT_ID, true);
		IPluginElement element = factory.createElement(extension);
		
		// register new rulebase:
		String documentType = DocumentType.getDocumentTypes(pageEditRules.getSelectedDocumentTypes());
		
		element.setName(RuleBasePlugin.EXTENSION_POINT_ELEMENT_RULEBASE);
		element.setAttribute(RuleBasePlugin.EXTENSION_POINT_ATTRIBUTE_RULEBASE_NAME, getStringOption(KEY_PACKAGE_NAME));
		element.setAttribute(RuleBasePlugin.EXTENSION_POINT_ATTRIBUTE_RULEBASE_DOCUMENT_TYPE, documentType);
		element.setAttribute(RuleBasePlugin.EXTENSION_POINT_ATTRIBUTE_RULEBASE_FOLDER, RuleBasePlugin.EDIT_RULE_FOLDER);
		
		extension.add(element);
		plugin.add(extension);
	}

	private void addRuleBaseNature() throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 1, natures.length);
		
		// Make rulebase first nature so the icon is shown:
		newNatures[0] = RuleBaseProjectNature.NATURE_ID;
		
		description.setNatureIds(newNatures);
		project.setDescription(description, null);
	}

	@Override
	public void addPages(Wizard wizard) {
		Set<String> availableDocumentTypes = new HashSet<>(DocumentType.getAvailableDocumentTypes());
		String[] sortedAvailableDocumentTypes = availableDocumentTypes.toArray(new String[0]);
		Arrays.sort(sortedAvailableDocumentTypes);
		
		pageEditRules = new RuleBaseProjectPageEditRules(
				getStringOption(KEY_PACKAGE_NAME), 
				sortedAvailableDocumentTypes);
		wizard.addPage(pageEditRules);
		markPagesAdded();
	}
	
	@Override
	public boolean isDependentOnParentWizard() {
		return true;
	}

	@Override
	public String[] getNewFiles() {
		
		// build.properties defines the files included in the binary build:
		Set<String> newFiles = new LinkedHashSet<>();
		newFiles.add(RuleBasePlugin.GRAPHPATTERN_FILE);
		newFiles.add(RuleBasePlugin.GRAPHPATTERN_EDIT_RULE_FILE);
		newFiles.add(getEditRuleFolder());
		return newFiles.toArray(new String[0]);
	}
	
	@Override
	public IPluginReference[] getDependencies(String schemaVersion) {
		return new IPluginReference[] {
			new PluginReference(RuleBasePlugin.EXTENSION_POINT_DEPENDENCIE, null, 0)
		};
	}

	@Override
	protected void initializeFields(IFieldData data) {
		// In a new project wizard, we don't know this yet - the model has not been created
		String id = data.getId();
		initializeOption(KEY_PACKAGE_NAME, getFormattedPackageName(id));
	}

	@Override
	public void initializeFields(IPluginModelBase model) {
		// In the new extension wizard, the model exists so we can initialize directly from it
		String pluginId = model.getPluginBase().getId();
		initializeOption(KEY_PACKAGE_NAME, getFormattedPackageName(pluginId));
	}
	
	private EPackage getEPackage(String documentType) {
		return EMFMetaAccessUtil.getEPackage(documentType);
	}
	
	private static String getFormattedPackageName(String pluginID) {
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < pluginID.length(); i++) {
			char ch = pluginID.charAt(i);
			
			if (builder.length() == 0) {
				if (Character.isJavaIdentifierStart(ch)) {
					builder.append(Character.toLowerCase(ch));
				}
			} else {
				if (Character.isJavaIdentifierPart(ch) || ch == '.') {
					builder.append(ch);
				}
			}
		}
		return builder.toString().toLowerCase(Locale.ENGLISH);
	}

	@Override
	public void execute(IProject project, IPluginModelBase model, IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 100);
		super.execute(project, model, progress.split(50));

		createEditRuleFolders(project, progress.split(1));
		Bundle patternBundle = createASGPatternBundle(project, progress.split(39));
		
		if (pageEditRules.isCreateExampleFolderOption()) {
			createExampleFolders(patternBundle, project, progress.split(10));
		}
	}

	private Bundle createASGPatternBundle(IProject project, IProgressMonitor monitor) {
		ASGPatternBundle asgPattern = new ASGPatternBundle(pageEditRules.getName(), pageEditRules.getDescriptionText());
		pageEditRules.getSelectedDocumentTypes().forEach(docType -> asgPattern.addDocumentType(getEPackage(docType)));
		pageEditRules.getSelectedConstraints().forEach(c -> asgPattern.addConstraint(c, pageEditRules.isInitializePatternsOption()));
		
		DiagramURI diagramDashboardURI = asgPattern.saveWithDiagrams(project, monitor);
		
		// Do no include the relocation edge in the diagrams:
		asgPattern.initializeRelocationEdges();
		asgPattern.save(project);
		
		openDiagram(project, diagramDashboardURI);
		
		return asgPattern.getPatternBundle();
	}

	private void openDiagram(IProject project, DiagramURI diagramDashboardURI) {
		if (diagramDashboardURI.diagramURI != null) {
			try {
				String path = project.getLocation().removeLastSegments(1) + diagramDashboardURI.diagramURI.toPlatformString(true);
				WorkbenchUtil.openEditor(path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean canFinish() {
		return pageEditRules.canFinish();
	}
}
