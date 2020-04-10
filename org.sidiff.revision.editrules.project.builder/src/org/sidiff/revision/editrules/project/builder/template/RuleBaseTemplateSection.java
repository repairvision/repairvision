package org.sidiff.revision.editrules.project.builder.template;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
import org.sidiff.common.ui.util.UIUtil;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes;
import org.sidiff.graphpattern.tools.visualization.CreateDiagram;
import org.sidiff.revision.editrules.project.builder.Activator;
import org.sidiff.revision.editrules.project.builder.RuleBasePlugin;
import org.sidiff.revision.editrules.project.builder.nature.RuleBaseProjectNature;
import org.sidiff.revision.editrules.project.builder.wizard.RuleBaseProjectPageEditRules;

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
	}
	
	private void addRuleBaseExtension() throws CoreException {
		IPluginBase plugin = model.getPluginBase();
		IPluginModelFactory factory = model.getPluginFactory();
		IPluginExtension extension = createExtension(RuleBasePlugin.EXTENSION_POINT_ID, true);
		IPluginElement element = factory.createElement(extension);
		
		// register new rulebase:
		element.setName(RuleBasePlugin.EXTENSION_POINT_ELEMENT_RULEBASE);
		element.setAttribute(RuleBasePlugin.EXTENSION_POINT_ATTRIBUTE_RULEBASE_NAME, getStringOption(KEY_PACKAGE_NAME));
		element.setAttribute(RuleBasePlugin.EXTENSION_POINT_ATTRIBUTE_RULEBASE_DOCUMENT_TYPE, pageEditRules.getName());
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
		pageEditRules = new RuleBaseProjectPageEditRules(getAvailableDocumentTypes());
		wizard.addPage(pageEditRules);
		markPagesAdded();
	}
	
	protected String[] getAvailableDocumentTypes() {
		return EcorePlugin.getEPackageNsURIToGenModelLocationMap(false).keySet().toArray(new String[0]);
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
		newFiles.addAll(getNewFolders());
		return newFiles.toArray(new String[0]);
	}
	
	private static Set<String> getNewFolders() {
		Set<String> newFolders = new LinkedHashSet<>();
		newFolders.add(RuleBasePlugin.EDIT_RULE_FOLDER + "/");
		return newFolders;
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
		SubMonitor progress = SubMonitor.convert(monitor, 4);
		super.execute(project, model, progress.split(1));

		createOutputFolders(project, progress.split(1));
		Bundle patternBundle = createGraphPatternFile(project, progress.split(1));
		URI diagramFile = createGraphPatternDiagram(patternBundle, progress.split(1));
		
		if (diagramFile != null) {
			try {
				String path = project.getLocation().removeLastSegments(1) + diagramFile.toPlatformString(true);
				UIUtil.openEditor(path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void createOutputFolders(IProject project, IProgressMonitor monitor) throws CoreException {
		Set<String> newFolders = getNewFolders();
		
		for(String folderName : newFolders) {
			IFolder folder = project.getFolder(folderName);
			if(!folder.exists()) {
				folder.create(true, true, monitor);
			}
		}
		
		monitor.done();
	}

	private Bundle createGraphPatternFile(IProject project, IProgressMonitor monitor) {
		Bundle patternBundle = GraphpatternFactory.eINSTANCE.createBundle();
		patternBundle.getProfiles().add(ConstraintStereotypes.instance);
		patternBundle.setName(pageEditRules.getName());
		patternBundle.setDescription(pageEditRules.getDescription());
		patternBundle.getDomains().addAll(pageEditRules.getDocumentTypes());

		URI patternURI = URI.createPlatformResourceURI(project.getName() + "/" + RuleBasePlugin.GRAPHPATTERN_FILE, true);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(patternURI);
		resource.getContents().add(patternBundle);
		
		try {
			resource.save(Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		monitor.done();
		return patternBundle;
	}
	
	private URI createGraphPatternDiagram(Bundle patternBundle, IProgressMonitor monitor) {
		try {
			CreateDiagram createDiagram = new CreateDiagram();
			URI diagramFile = createDiagram.createDiagram(patternBundle, false, monitor);
			return diagramFile;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
