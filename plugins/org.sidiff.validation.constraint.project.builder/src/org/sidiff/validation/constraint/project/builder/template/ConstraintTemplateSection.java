package org.sidiff.validation.constraint.project.builder.template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.pde.core.IEditableModel;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.templates.OptionTemplateSection;
import org.eclipse.pde.ui.templates.PluginReference;
import org.osgi.framework.Constants;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.common.utilities.java.StringUtil;
import org.sidiff.validation.constraint.project.ConstraintPlugin;
import org.sidiff.validation.constraint.project.builder.Activator;
import org.sidiff.validation.constraint.project.builder.nature.ConstraintProjectNature;
import org.sidiff.validation.constraint.project.builder.wizard.ConstraintProjectPageConstraints;
import org.sidiff.validation.laguage.fol.util.EMFMetaAccessUtil;

/**
 * Defines the PDE template for creating a constraint plug-in project.
 * 
 * @author Manuel Ohrndorf
 */
public class ConstraintTemplateSection extends OptionTemplateSection {
	
	private ConstraintProjectPageConstraints pageConstraints;
	
	private Map<String, EPackage> workspaceEPackages;

	public ConstraintTemplateSection() {
		addOption(KEY_PACKAGE_NAME, ConstraintTemplateSection.KEY_PACKAGE_NAME, (String) null, 0);
		setPageCount(1);
	}
	
	private Map<String, EPackage> getWorkspaceEPackages() {
		if (workspaceEPackages == null) {
			workspaceEPackages = EMFMetaAccessUtil.getWorkspaceEPackages();
		}
		return workspaceEPackages;
	}
	
	@Override
	public String getUsedExtensionPoint() {
		return ConstraintPlugin.EXTENSION_POINT_ID;
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
		addConstraintExtension();
		addConstraintNature();
		
		setManifestHeader(Constants.BUNDLE_ACTIVATIONPOLICY, Constants.ACTIVATION_LAZY);
		
		// Done by addConstraintExtension()
//		setManifestHeader(Constants.BUNDLE_SYMBOLICNAME, getManifestHeader(Constants.BUNDLE_SYMBOLICNAME) + ";" + Constants.SINGLETON_DIRECTIVE + ":=true");
	}
	
	private void addConstraintExtension() throws CoreException {
		IPluginBase plugin = model.getPluginBase();
		IPluginExtension extension = createExtension(ConstraintPlugin.EXTENSION_POINT_ID, true);
		plugin.add(extension);
	}

	private void addConstraintNature() throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		String[] newNatures = new String[natures.length + 2];
		System.arraycopy(natures, 0, newNatures, 1, natures.length);
		
		// Make constraint first nature so the icon is shown:
		newNatures[0] = ConstraintProjectNature.CONSTRAINT_NATURE_ID;
		
		// Add XText project nature:
		newNatures[newNatures.length - 1] = ConstraintProjectNature.XTEXT_NATURE_ID;
		
		description.setNatureIds(newNatures);
		project.setDescription(description, null);
	}

	@Override
	public void addPages(Wizard wizard) {
		Set<String> availableDocumentTypes = new HashSet<>(DocumentType.getAvailableDocumentTypes());
		availableDocumentTypes.addAll(getWorkspaceEPackages().keySet());
		
		String[] sortedAvailableDocumentTypes = availableDocumentTypes.toArray(new String[0]);
		Arrays.sort(sortedAvailableDocumentTypes);
		
		pageConstraints = new ConstraintProjectPageConstraints(
				getStringOption(KEY_PACKAGE_NAME), 
				sortedAvailableDocumentTypes);
		wizard.addPage(pageConstraints);
		markPagesAdded();
	}

	@Override
	public boolean isDependentOnParentWizard() {
		return true;
	}
	
	@Override
	public String[] getNewFiles() {
		// build.properties defines the files included in the binary build:
		return new String[0];
	}
	
	@Override
	public IPluginReference[] getDependencies(String schemaVersion) {
		List<IPluginReference> dependencies = new ArrayList<>();
		
		dependencies.add(new PluginReference(ConstraintPlugin.EXTENSION_POINT_DEPENDENCIE, null, 0));
		dependencies.add(new PluginReference(ConstraintPlugin.CONSTRAINT_INTERPRETER_DEPENDENCIE, null, 0));
		
		for (String documentType : pageConstraints.getSelectedDocumentTypes()) {
			String documentTypeDependency = EMFMetaAccessUtil.getPluginSymbolicName(documentType, EMFMetaAccessUtil.getWorkspaceGenModels());
			dependencies.add(new PluginReference(documentTypeDependency, null, 0));
		}
		
		return dependencies.toArray(new IPluginReference[0]);
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
	
	@Override
	public void execute(IProject project, IPluginModelBase model, IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 100);
		super.execute(project, model, progress.split(80));
		
		// Create package for constraint file:
		String packageName = getFormattedPackageName(model.getPluginBase().getId());
		IFolder packageFolder = createPackage(project, "src", packageName, progress);
		
		// Create FOL-File:
		String folFileName = StringUtil.toUpperFirst(pageConstraints.getName()) + "Constraints.fol";
		File folFile = createFOLFile(packageFolder, folFileName);
		
		// Create src-gen folder:
		createSourceFolder(model, "src-gen", progress.split(10));
		
		try {
			WorkbenchUtil.refreshProject(project);
			WorkbenchUtil.openEditor(folFile.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private File createFOLFile(IFolder folder, String fileName) {
		List<String> documentTypes = pageConstraints.getSelectedDocumentTypes();
		String description = "";
		String header = "";
		String helloWorldConstraint = "";
		
		// Description:
		if (!pageConstraints.getDescription().isEmpty()) {
			description =
					"/*\n" + 
					" * Constraint Library for "+ pageConstraints.getDescriptionText() +"\n" + 
					" */\n\n";
		}
		
		// Header:
		if (!documentTypes.isEmpty()) {
			String documentType = getMainDocumentType(documentTypes);
			
			header = getDomains(documentTypes);
			
			// Hello World Constraint:
			EPackage ePackage = getEPackage(documentType);
			
			if (ePackage != null) {
				Optional<EClassifier> exampleClass = ePackage.getEClassifiers().stream().filter(c -> c instanceof EClass).findAny();
				
				if (exampleClass.isPresent()) {
					helloWorldConstraint = "\n// TODO: Hello World Constraint - Replace This:\n";
					helloWorldConstraint += "constraint MyName message \"My validation message\" context " +  exampleClass.get().getName() + " contextElementName : isEqual(true, true)";
				}
			}
		}
		
		File folFile = new File(folder.getLocation().toFile().getAbsolutePath() + "/" + fileName);
		
		try {
			folFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (FileWriter writer = new FileWriter(folFile)) {
			writer.append(description);
			writer.append(header);
			writer.append(helloWorldConstraint);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return folFile;
	}

	private String getDomains(List<String> documentTypes) {
		StringBuilder code = new StringBuilder();
		
		for (String documentType : documentTypes) {
			code.append("domain ");
			code.append("'");
			code.append(documentType);
			code.append("'");
			code.append("\n");
		}
		
		return code.toString();
	}

	private IFolder createPackage(IProject project, String sourceFolder, String packageName, SubMonitor progress) throws JavaModelException {
		IFolder srcFolder = project.getFolder(sourceFolder);
		
		if (srcFolder.exists()) {
			IJavaProject javaProject = JavaCore.create(project);
			IPackageFragment packageFragment = javaProject.findPackageFragmentRoot(srcFolder.getFullPath())
					.createPackageFragment(packageName, true, progress.split(10));
			return (IFolder) packageFragment.getResource();
		}
		
		return null;
	}

	private void createSourceFolder(IPluginModelBase model, String srcGenFolder, IProgressMonitor monitor) throws CoreException, JavaModelException {
		SubMonitor progress = SubMonitor.convert(monitor, 2);
		
		// Create src-gen folder:
		WorkbenchUtil.createFolder(project, srcGenFolder, progress.split(1));
		
		// Add src-gen folder to build.properties
		IBuildModel buildModel = PluginRegistry.createBuildModel(model);

		if (buildModel instanceof IEditableModel) {
			buildModel.getBuild().getEntry("source..").addToken(srcGenFolder + "/");
			((IEditableModel) buildModel).save();
		}
		
		// Add src-gen folder to classpath:
		IJavaProject javaProject = JavaCore.create(project);
		IClasspathEntry[] entries = javaProject.getRawClasspath();

		IClasspathEntry[] newEntries = new IClasspathEntry[entries.length + 1];
		System.arraycopy(entries, 0, newEntries, 0, entries.length);

		IPath srcPath= javaProject.getPath().append(srcGenFolder);
		IClasspathEntry srcEntry= JavaCore.newSourceEntry(srcPath, null);

		newEntries[entries.length] = JavaCore.newSourceEntry(srcEntry.getPath());
		javaProject.setRawClasspath(newEntries, null);
	}
	
	private String getMainDocumentType(List<String> documentTypes) {
		if (!documentTypes.isEmpty()) {
			return documentTypes.get(0);
		} else {
			return "";
		}
	}
	
	private EPackage getEPackage(String documentType) {
		return EMFMetaAccessUtil.getEPackage(documentType, getWorkspaceEPackages());
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

	public boolean canFinish() {
		return pageConstraints.canFinish();
	}
	
}
