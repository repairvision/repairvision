package org.sidiff.revision.editrules.project.builder;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.profile.henshin.converter.GraphPatternToHenshinConverterHandler;
import org.sidiff.graphpattern.tools.model2graph.FolderToBundleTransformation;
import org.sidiff.graphpattern.tools.model2graph.ModelToGraphPatternFactory;
import org.sidiff.graphpattern.validation.GraphPatternValidation;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.editrules.generation.constructors.CreationEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.DeletionEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.IEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.RelocationEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.TransformationEditRuleConstructor;
import org.sidiff.revision.editrules.generation.generator.api.EditRuleGenerator;
import org.sidiff.revision.editrules.project.RuleBasePlugin;
import org.sidiff.revision.editrules.project.builder.util.RuleBaseBuilderUtils;
import org.sidiff.validation.laguage.fol.util.EMFMetaAccessUtil;

/**
 * Builds the edit rules from a catalog of graph patterns.
 * 
 * @author Manuel Ohrndorf
 */
public class RuleBaseBuilder extends IncrementalProjectBuilder {

	private Set<IPath> watchForChanges() {
		Set<IPath> paths = new LinkedHashSet<>();
		IProject project = getProject();
		
		paths.add(project.getFile(RuleBasePlugin.GRAPHPATTERN_FILE).getProjectRelativePath());
		paths.add(project.getFolder(RuleBasePlugin.EXAMPLE_FOLDER).getProjectRelativePath());
		
		return paths;
	}
	
	private URI getGraphPatternFileURI() {
		return URI.createPlatformResourceURI(
				getProject().getName() + "/" + RuleBasePlugin.GRAPHPATTERN_FILE, true);
	}
	
	private URI getGraphPatternEditRuleFileURI() {
		return URI.createPlatformResourceURI(
				getProject().getName() + "/" + RuleBasePlugin.GRAPHPATTERN_EDIT_RULE_FILE, true);
	}
	
	private URI getEditRuleFolderURI() {
		return URI.createPlatformResourceURI(
				getProject().getName() + "/" + RuleBasePlugin.EDIT_RULE_FOLDER, true);
	}
	
	private IFolder getExampleFolder(Bundle patternBundle) {
		return getProject().getFolder(RuleBaseBuilderUtils.getExampleFolder(patternBundle));
	}
	
	private void buildRulebase(IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		
		URI editrulesURI = getGraphPatternEditRuleFileURI();
		URI henshinEditrulesURI = getEditRuleFolderURI();
		
		Bundle patternBundle = loadGraphPatterns(subMonitor.split(10));
		
		// Synchronize pattern bundle and example folder structure:
		try {
			RuleBaseBuilderUtils.createExampleFolders(patternBundle, getProject(), subMonitor.split(5));
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		// Convert models to ASG pattens:
		convertExamplePatterns(patternBundle, subMonitor.split(25));
		
		// Generate edit rules:
		if (validateGraphPatterns(patternBundle, subMonitor.split(10))) {
			Bundle editrulesBundle = generateEditRulePatterns(patternBundle, editrulesURI, subMonitor.split(30));
			convertToHenshin(henshinEditrulesURI, editrulesBundle, subMonitor.split(20));
		}
	}
	
	private void convertExamplePatterns(Bundle patternBundle, IProgressMonitor monitor) {
		IFolder exampleFolder = getExampleFolder(patternBundle);
		
		if ((exampleFolder != null) && (exampleFolder.exists())) {
			Set<String> modelFileExtensions = new HashSet<>();
			
			for (EPackage metamodel : patternBundle.getDomains()) {
				modelFileExtensions.addAll(EMFMetaAccessUtil.getFileExtensionFromDocumentType(DocumentType.getDocumentType(metamodel)));
			}
			
			// TODO: make 'overwrite' and 'create definition file' configurable
			ModelToGraphPatternFactory modelToGraphPatternFactory = new ModelToGraphPatternFactory(true);
			FolderToBundleTransformation converter = new FolderToBundleTransformation(modelFileExtensions, modelToGraphPatternFactory);
			converter.updateBundle(patternBundle, exampleFolder, false);	
			
			try {
				patternBundle.eResource().save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private Bundle loadGraphPatterns(IProgressMonitor monitor) {
		URI graphpatternURI = getGraphPatternFileURI();
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(graphpatternURI, true);
		Bundle patternBundle = (Bundle) resource.getContents().get(0);
		
		return patternBundle;
	}
	
	private boolean validateGraphPatterns(Bundle patternBundle, IProgressMonitor monitor) {
		IFile graphpatternFile = getProject().getFile(RuleBasePlugin.GRAPHPATTERN_FILE);
		return GraphPatternValidation.validate(graphpatternFile, patternBundle);
	}

	private Bundle generateEditRulePatterns(Bundle patternBundle, URI editrulesURI, IProgressMonitor monitor) {
		
		@SuppressWarnings("unchecked")
		List<Class<IEditRuleConstructor>> generators = Arrays.asList(new Class[] {
				CreationEditRuleConstructor.class,
				DeletionEditRuleConstructor.class,
				TransformationEditRuleConstructor.class,
				RelocationEditRuleConstructor.class});
		
		EditRuleGenerator generator = new EditRuleGenerator();
		Bundle editrulesBundle = generator.generateEditRules(generators, patternBundle, editrulesURI);
		
		return editrulesBundle;
	}
	
	private void convertToHenshin(URI henshinEditrulesURI, Bundle editrulesBundle, IProgressMonitor monitor) {
		GraphPatternToHenshinConverterHandler henshinConverter = new GraphPatternToHenshinConverterHandler();
		henshinConverter.convertBundle(editrulesBundle, henshinEditrulesURI);
	}
	
	@Override
	protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 1);
		
		if (kind == IncrementalProjectBuilder.FULL_BUILD) {
			fullBuild(subMonitor.split(1));
		} else {
			IResourceDelta delta = getDelta(getProject());
			
			if (delta == null) {
				fullBuild(subMonitor.split(1));
			} else {
				incrementalBuild(delta, subMonitor.split(1));
			}
		}
		return null;
	}

	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		
		// remove markers
		removeMarkers(getProject(), IResource.DEPTH_INFINITE);

		// delete Graph-Pattern based edit rule file:
		IFile graphpatternEditRuleFile = getProject().getFile(RuleBasePlugin.GRAPHPATTERN_EDIT_RULE_FILE);
		
		if (graphpatternEditRuleFile.exists()) {
			graphpatternEditRuleFile.delete(true, monitor);
		}
		
		// delete edit rule files:
		IFolder editruleFolder = getProject().getFolder(RuleBasePlugin.EDIT_RULE_FOLDER);
		
		if (editruleFolder.exists()) {
			editruleFolder.accept(editruleFile -> {
				if (!monitor.isCanceled()) {
					editruleFile.delete(true, monitor);
					return editruleFile instanceof IFolder;
				}
				return false;
			});
		}
		
		monitor.done();
	}

	private void fullBuild(IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 100);
		
		refreshProject(progress.split(5));
		clean(progress.split(10));
		buildRulebase(progress.split(80));
		refreshProject(progress.split(5));
	}
	
	private void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		if (containsResource(delta, watchForChanges())) {
			fullBuild(monitor);
		}
	}
	
	private boolean containsResource(IResourceDelta delta, Set<IPath> path) throws CoreException {
		for (IResourceDelta childDelta : delta.getAffectedChildren()) {
			if (path.contains(childDelta.getResource().getProjectRelativePath())
					|| containsResource(childDelta, path)) {
				return true;
			}
		}
		return false;
	}
	
	private void removeMarkers(IResource resource, int depth) {
		try {
			// Delete old EMF markers
			resource.deleteMarkers(EValidator.MARKER, true, depth);
			
			// Also delete project marker
			getProject().deleteMarkers(IMarker.PROBLEM, false, depth);

		} catch (CoreException e) {
			Activator.logWarning("Could not remove markers from " + resource, e);
		}
	}

	private void refreshProject(IProgressMonitor monitor) {
		try {
			getProject().refreshLocal(IResource.DEPTH_INFINITE, monitor);
		} catch (CoreException e) {
			Activator.logWarning("Could not refresh project " + getProject(), e);
		}
	}
}