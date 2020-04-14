package org.sidiff.revision.editrules.project.builder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.profile.henshin.converter.GraphPatternToHenshinConverterHandler;
import org.sidiff.revision.editrules.generation.constructors.CreationEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.DeletionEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.IEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.RelocationEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.TransformationEditRuleConstructor;
import org.sidiff.revision.editrules.generation.generator.api.EditRuleGenerator;
import org.sidiff.revision.editrules.project.RuleBasePlugin;

/**
 * Builds the edit rules from a catalog of graph patterns.
 * 
 * @author Manuel Ohrndorf
 */
public class RuleBaseBuilder extends IncrementalProjectBuilder {

	protected void buildRulebase(IProgressMonitor monitor) {
		URI editrulesURI = getEditrulesURI();
		URI henshinEditrulesURI = getHeshinRuleFolder();
		
		Bundle patternBundle = loadGraphPatterns();
		
		if (validateGraphPatterns(patternBundle, monitor)) {
			Bundle editrulesBundle = generateEditRulePatterns(patternBundle, editrulesURI);
			convertToHenshin(henshinEditrulesURI, editrulesBundle);
		}
		
		monitor.done();
	}

	private URI getEditrulesURI() {
		return URI.createPlatformResourceURI(
				getProject().getName() + "/" + RuleBasePlugin.GRAPHPATTERN_EDIT_RULE_FILE, true);
	}
	
	private URI getHeshinRuleFolder() {
		return URI.createPlatformResourceURI(
				getProject().getName() + "/" + RuleBasePlugin.EDIT_RULE_FOLDER, true);
	}

	private Bundle loadGraphPatterns() {
		URI graphpatternURI = URI.createPlatformResourceURI(
				getProject().getName() + "/" + RuleBasePlugin.GRAPHPATTERN_FILE, true);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(graphpatternURI, true);
		Bundle patternBundle = (Bundle) resource.getContents().get(0);
		
		return patternBundle;
	}
	
	private boolean validateGraphPatterns(Bundle patternBundle, IProgressMonitor monitor) {
		IFile graphpatternFile = getProject().getFile(RuleBasePlugin.GRAPHPATTERN_FILE);
		boolean result = WorkbenchUtil.validateEMFResource(graphpatternFile, patternBundle);
		
		monitor.done();
		return result;
	}

	private Bundle generateEditRulePatterns(Bundle patternBundle, URI editrulesURI) {
		
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
	
	private void convertToHenshin(URI henshinEditrulesURI, Bundle editrulesBundle) {
		GraphPatternToHenshinConverterHandler henshinConverter = new GraphPatternToHenshinConverterHandler();
		henshinConverter.convertBundle(editrulesBundle, henshinEditrulesURI);
	}
	
	@Override
	protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		if (kind == IncrementalProjectBuilder.FULL_BUILD) {
			fullBuild(monitor);
		} else {
			IResourceDelta delta = getDelta(getProject());
			
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
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
		IFile graphpatternFile = getProject().getFile(RuleBasePlugin.GRAPHPATTERN_FILE);
		
		if (graphpatternFile.exists() && containsResource(delta, graphpatternFile.getProjectRelativePath())) {
			fullBuild(monitor);
		}
	}
	
	private boolean containsResource(IResourceDelta delta, IPath path) throws CoreException {
		for (IResourceDelta resourceDelta : delta.getAffectedChildren()) {
			if (path.equals(resourceDelta.getResource().getProjectRelativePath())) {
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