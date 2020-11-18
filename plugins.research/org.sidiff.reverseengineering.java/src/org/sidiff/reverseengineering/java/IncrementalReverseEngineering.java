package org.sidiff.reverseengineering.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.sidiff.reverseengineering.java.configuration.TransformationModule.JavaASTBindingResolverFactory;
import org.sidiff.reverseengineering.java.configuration.TransformationModule.JavaASTLibraryModelFactory;
import org.sidiff.reverseengineering.java.configuration.TransformationModule.JavaASTProjectModelFactory;
import org.sidiff.reverseengineering.java.configuration.TransformationModule.JavaASTTransformationFactory;
import org.sidiff.reverseengineering.java.configuration.TransformationModule.JavaASTWorkspaceModelFactory;
import org.sidiff.reverseengineering.java.configuration.TransformationSettings;
import org.sidiff.reverseengineering.java.transformation.JavaASTBindingResolver;
import org.sidiff.reverseengineering.java.transformation.JavaASTLibraryModel;
import org.sidiff.reverseengineering.java.transformation.JavaASTProjectModel;
import org.sidiff.reverseengineering.java.transformation.JavaASTTransformation;
import org.sidiff.reverseengineering.java.transformation.JavaASTWorkspaceModel;
import org.sidiff.reverseengineering.java.util.EMFHelper;
import org.sidiff.reverseengineering.java.util.JavaParser;

import com.google.inject.Inject;

public class IncrementalReverseEngineering {

	private TransformationSettings settings;
	
	private JavaASTTransformationFactory transformationFactory;
	
	private JavaASTBindingResolverFactory bindingResolverFactory;
	
	private JavaASTWorkspaceModelFactory workspaceModelFactory;
	
	private JavaASTLibraryModelFactory libraryModelFactory;
	
	private JavaASTProjectModelFactory projectModelFactory;
	
	private JavaParser javaParser;
	
	private EMFHelper emfHelper;
	
	private ResourceSet oldResourceSet;
	
	private ResourceSet resourceSetNew;
	
	private List<TransformationListener> listeners;
	
	@Inject
	public IncrementalReverseEngineering(
			TransformationSettings settings,
			JavaASTTransformationFactory transformationFactory,
			JavaASTBindingResolverFactory bindingResolverFactory,
			JavaASTWorkspaceModelFactory workspaceModelFactory,
			JavaASTLibraryModelFactory libraryModelFactory,
			JavaASTProjectModelFactory projectModelFactory, 
			JavaParser javaParser, 
			EMFHelper emfHelper,
			ResourceSet oldResourceSet) {
		this.settings = settings;
		this.transformationFactory = transformationFactory;
		this.bindingResolverFactory = bindingResolverFactory;
		this.workspaceModelFactory = workspaceModelFactory;
		this.libraryModelFactory = libraryModelFactory;
		this.projectModelFactory = projectModelFactory;
		this.javaParser = javaParser;
		this.emfHelper = emfHelper;
		this.oldResourceSet = oldResourceSet;
		this.listeners = new ArrayList<>();
	}
	
	public void addTransformationListener(TransformationListener listener) {
		this.listeners.add(listener);
	}
	
	public void removeTransformationListener(TransformationListener listener) {
		this.listeners.remove(listener);
	}

	public void performWorkspaceUpdate(List<WorkspaceUpdate> updates) {
		
		Set<String> workspaceProjectScope = updates.stream()
				.map(WorkspaceUpdate::getProject)
				.map(IProject::getName)
				.collect(Collectors.toSet());
    	
		// Setup model resources:
		JavaASTWorkspaceModel workspaceModel = workspaceModelFactory.create(settings.getWorkspaceModel(), settings.getName());
    	JavaASTLibraryModel libraryModel = libraryModelFactory.create(settings.getLibraryModel());
    	this.resourceSetNew = settings.getWorkspaceModel().getResourceSet();
		
		for (WorkspaceUpdate workspaceUpdate : updates) {
			try {
				/* Start Transformation */
				JavaASTProjectModel projectModel = process(workspaceUpdate, workspaceProjectScope, workspaceModel, libraryModel);
				
				// Save project model:
				if (!projectModel.getProjectModel().getContents().isEmpty()) {
					workspaceModel.addToWorkspace(projectModel.getProjectModel().getContents().get(0));
					projectModel.save();
				} else {
					workspaceModel.removeFromWorkspace(projectModel.getProjectModel().getContents().get(0));
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		
		// Save main workspace and common library model:
		if (!libraryModel.getLibraryModel().getContents().isEmpty()) {
			workspaceModel.addToWorkspace(libraryModel.getLibraryModel().getContents().get(0));
			libraryModel.save();
		} else {
			workspaceModel.removeFromWorkspace(libraryModel.getLibraryModel().getContents().get(0));
		}
		
		workspaceModel.save();
	}
	
	protected JavaASTProjectModel process(
			WorkspaceUpdate workspaceUpdate, 
			Set<String> workspaceProjectScope,
			JavaASTWorkspaceModel workspaceModel,
			JavaASTLibraryModel libraryModel) 
					throws JavaModelException {
		
		// Parse Java source files to be updated:
		if (Activator.isLoggable(Level.FINE)) Activator.log(Level.FINE, "Parsing...");
		
		Map<ICompilationUnit, CompilationUnit> parsedASTs = javaParser.parse(
				workspaceUpdate.getProject(), workspaceUpdate.needsUpdate(), settings.isIncludeMethodBodies());
		
		if (Activator.isLoggable(Level.FINE)) Activator.log(Level.FINE, "Finished");

		// Setup project model resource:
		URI projectModelURI = settings.getBaseURI().appendSegment(workspaceUpdate.getProject().getName())
				.appendSegment(workspaceUpdate.getProject().getName()).appendFileExtension(settings.getModelFileExtension());
		XMLResource projectModelResource = EMFHelper.initializeResource(resourceSetNew, projectModelURI);
    	JavaASTProjectModel projectModel = projectModelFactory.create(projectModelResource, workspaceUpdate.getProject());
    	
    	// Remove elements to be updated:
    	for (IResource removed : workspaceUpdate.getRemoved()) {
    		removeFromProjectModel(projectModel, removed);
    	}
    	
    	for (IResource modified : workspaceUpdate.getModified()) {
    		removeFromProjectModel(projectModel, modified);
    	}
    	
    	// Log modified models:
    	List<Resource> oldResources = new ArrayList<>(); 
    	
    	// Process all compilation units:
    	for (CompilationUnit javaAST : parsedASTs.values()) {
    		IJavaElement javaElement = javaAST.getJavaElement();
    		
    		if (Activator.isLoggable(Level.FINE)) Activator.log(Level.FINE, javaElement.getResource().getFullPath().toString());
   		
    		JavaASTBindingResolver modelBindings = bindingResolverFactory.create(javaAST, workspaceProjectScope, libraryModel);
    		JavaASTTransformation transformation = transformationFactory.create(javaAST, modelBindings);

			/* Start Model Transformation */
    		transformation.apply();
    		
    		// Add to project model:
    		if (javaElement.getParent() instanceof IPackageFragment) {
    			for (EObject rootModelElement : transformation.getRootModelElements()) {
    				if ((javaAST.getPackage() != null) && (javaAST.getPackage().resolveBinding() != null)) {
    					projectModel.addPackagedElement(javaAST.getPackage().resolveBinding(), rootModelElement);
    				} else {
    					projectModel.addPackagedElement(null, rootModelElement); // default package
    				}
    			}
    		}
    		
    		// Save model resource:
    		URI modelURI = transformation.getModelURI(settings.getBaseURI());
    		
    		// Update model?
    		XMLResource resourceOld = null; // for reuse of XMI object IDs
    		
    		if (workspaceUpdate.isModified(javaElement.getResource())) {
    			if (EMFHelper.resourceExists(oldResourceSet, modelURI)) {
    				resourceOld = (XMLResource) oldResourceSet.getResource(modelURI, true);
    				oldResources.add(resourceOld);
    			}
    		}

			Resource typeModel = emfHelper.saveModelWithBindings(
					modelURI, resourceSetNew, modelBindings.getBindings(),
					transformation.getRootModelElements(), resourceOld);
			
			// Notify listeners:
			TransformationTrace trace = transformation.getTransformationTrace();
			trace.setWorkspaceModel(workspaceModel.getWorkspaceModel());
			trace.setLibraryModel(libraryModel.getLibraryModel());
			trace.setProjectModel(projectModel.getProjectModel());
			trace.setJavaResource(javaElement.getResource());
			trace.setTypeModel(typeModel);
			
			for (TransformationListener listener : listeners) {
				listener.typeModelTransformed(trace.getJavaResource(), trace);
			}
		}
    	
    	// Clean up old resources, keep old library model:
    	oldResourceSet.getResources().removeAll(oldResources);
    	
    	return projectModel;
    }

	private void removeFromProjectModel(JavaASTProjectModel projectModel, IResource removed) {
		try {
			EObject[] removedModelElement = projectModel.removePackagedElement(
					removed.getParent().getProjectRelativePath().segments(), 
					removed.getFullPath().removeFileExtension().lastSegment());
			
			for (TransformationListener listener : listeners) {
				listener.typeModelRemoved(removed, removedModelElement[0], removedModelElement[1]);
			}
		} catch (NoSuchElementException e) {
			if (Activator.getLogger().isLoggable(Level.WARNING)) {
				Activator.getLogger().log(Level.WARNING, "Element to be removed not found: " + removed);
			}
		}
	}
	
}
