package org.sidiff.reverseengineering.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.sidiff.reverseengineering.java.transformation.JavaASTBindingResolver;
import org.sidiff.reverseengineering.java.transformation.JavaASTBindingTranslator;
import org.sidiff.reverseengineering.java.transformation.JavaASTLibraryModel;
import org.sidiff.reverseengineering.java.transformation.JavaASTProjectModel;
import org.sidiff.reverseengineering.java.transformation.JavaASTTransformation;
import org.sidiff.reverseengineering.java.transformation.JavaASTWorkspaceModel;
import org.sidiff.reverseengineering.java.transformation.uml.JavaASTBindingResolverUML;
import org.sidiff.reverseengineering.java.transformation.uml.JavaASTBindingTranslatorUML;
import org.sidiff.reverseengineering.java.transformation.uml.JavaASTLibraryModelUML;
import org.sidiff.reverseengineering.java.transformation.uml.JavaASTProjectModelUML;
import org.sidiff.reverseengineering.java.transformation.uml.JavaASTTransformationUML;
import org.sidiff.reverseengineering.java.transformation.uml.JavaASTWorkspaceModelUML;
import org.sidiff.reverseengineering.java.transformation.uml.rules.JavaToUMLHelper;
import org.sidiff.reverseengineering.java.transformation.uml.rules.JavaToUMLRules;
import org.sidiff.reverseengineering.java.util.EMFHelper;
import org.sidiff.reverseengineering.java.util.JavaParser;
import org.sidiff.reverseengineering.java.util.WorkspaceUtil;

/**
 * Incremental reverse engineering of Java ASTs to EMF models. We compute one
 * model per Java source file which might be regenerated independently. The
 * resolution of references between model is done by utilizing Java name binding
 * as object XMI IDs. Only if no Java name binding is available for a model
 * element it will use EMF's default UUIDs. References to external libraries
 * (not included in (configured) workspace) are collected in a common library
 * model. UUIDs (none Java bindings) are matched and reused, therefore, we use
 * EMF compare to compute a matching to the old model.
 * 
 * @author Manuel Ohrndorf
 */
public class ReverseEngineeringApp implements IApplication {

	// https://www.vogella.com/tutorials/EclipseJDT/article.html
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		// Logging:
		Level logLevel = Level.FINE;
		Activator.getLogger().setLevel(logLevel);
		ConsoleHandler consolHandler = new ConsoleHandler();
		consolHandler.setLevel(logLevel);
		Activator.getLogger().addHandler(consolHandler);

		// Application Settings:
		URI baseURI = URI.createFileURI("C:\\Users\\manue\\git\\repairvision\\plugins.research\\org.sidiff.reverseengineering.java\\test");
		
		boolean parseMethodBodies = false;
		
//		Set<String> workspaceProjectsFilter = new HashSet<>(Arrays.asList(new String[] { "org.eclipse.jdt.core.tests.builder" }));
//		Set<IProject> workspaceProjects = getAllWorkspaceProjects(workspaceProjectsFilter);
		Set<IProject> workspaceProjects = getProject("Test");
		Set<String> workspaceProjectNames = getProjectName(workspaceProjects);
		
		JavaParser javaParser = new JavaParser();
		EMFHelper emfHelper = new EMFHelper();
		JavaASTBindingTranslator bindingTranslator = new JavaASTBindingTranslatorUML();
		JavaToUMLHelper javaToUMLHelper = new JavaToUMLHelper();
		
		ResourceSet resourceSet = new ResourceSetImpl();
		
		URI workspaceModelURI = baseURI.appendSegment("System").appendFileExtension("uml");
    	XMLResource workspaceModelResource = (XMLResource) resourceSet.createResource(workspaceModelURI);
    	JavaASTWorkspaceModel workspaceModel = new JavaASTWorkspaceModelUML(workspaceModelResource, "System");
		
		URI libraryModelURI = baseURI.appendSegment("Libraries").appendFileExtension("uml");
    	XMLResource libraryModelResource = (XMLResource) resourceSet.createResource(libraryModelURI);
    	JavaASTLibraryModel libraryModel = new JavaASTLibraryModelUML(libraryModelResource, bindingTranslator, javaToUMLHelper);

		for (IProject project : workspaceProjects) {
			
			// Store bindings per project to avoid "overwhelming" the binding map, lead to bad performance:
			Supplier<JavaASTTransformation> javaAST2Model = () -> new JavaASTTransformationUML(new JavaToUMLRules(javaToUMLHelper));
			JavaASTBindingResolver modelBindings = new JavaASTBindingResolverUML(workspaceProjectNames, bindingTranslator, new HashMap<>(), libraryModel);
			
			URI projectModelURI = baseURI.appendSegment(project.getName())
					.appendSegment(project.getName()).appendFileExtension("uml");
			XMLResource projectModelResource = (XMLResource) resourceSet.createResource(projectModelURI);
			JavaASTProjectModel projectModel = new JavaASTProjectModelUML(projectModelResource);

			/* start model generation */
			generateModel(baseURI, 
					workspaceProjectNames, 
					project, 
					resourceSet, 
					javaParser,
					emfHelper,
					javaAST2Model, 
					modelBindings, 
					workspaceModel, 
					libraryModel, 
					projectModel,
					parseMethodBodies);

			// Save project model:
			projectModel.save();
		}
		
		// Save main workspace and common library model:
		if (!libraryModel.getLibraryModel().getContents().isEmpty()) {
			workspaceModel.addToWorkspace(libraryModel.getLibraryModel().getContents().get(0));
		}
		
		libraryModel.save();
		workspaceModel.save();

    	System.out.println("FINISHED!");
		return IApplication.EXIT_OK;
	}
	
	public Set<String> getProjectName(Set<IProject> projects) {
		return projects.stream().map(IProject::getName).collect(Collectors.toSet());
	}
	
	public Set<IProject> getProject(String name) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject(name);
		return Collections.singleton(project);
	}

	public Set<IProject> getAllWorkspaceProjects(Set<String> workspaceProjectsFilter) {
		Set<IProject> workspaceProjects = new HashSet<>();
		
		// Get all projects in the workspace
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject[] projects = root.getProjects();
		
		for (IProject project : projects) {
			try {
				if (!workspaceProjectsFilter.contains(project.getName())) {
					if (WorkspaceUtil.isJavaProject(project)) {
						workspaceProjects.add(project);
					}
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		
		return workspaceProjects;
	}

	@Override
	public void stop() {
	}
	
	private void generateModel(URI baseURI, 
			Set<String> workspaceProjects, 
			IProject project, 
			ResourceSet resourceSet,
			JavaParser javaParser, 
			EMFHelper emfHelper, 
			Supplier<JavaASTTransformation> javaAST2Model,
			JavaASTBindingResolver modelBindings, 
			JavaASTWorkspaceModel workspaceModel,
			JavaASTLibraryModel libraryModel, 
			JavaASTProjectModel projectModel, 
			boolean parseMethodBodies)
			throws JavaModelException {

		System.out.print("Parsing...");
		Map<ICompilationUnit, CompilationUnit> parsedASTs = javaParser.parse(project, parseMethodBodies);
		System.out.println("Finished");

    	ResourceSet resourceSetOld = new ResourceSetImpl();
    	
    	for (CompilationUnit javaAST : parsedASTs.values()) {
    		IJavaElement javaElement = javaAST.getJavaElement();
    		System.out.println(javaElement.getResource());
    		
    		JavaASTTransformation transformation = javaAST2Model.get();
    		transformation.init(javaElement.getResource(), modelBindings);
    		transformation.apply(javaAST);
    		
    		// Add to project model:
    		if (javaElement.getParent() instanceof IPackageFragment) {
    			for (EObject rootModelELement : transformation.getRootModelElements()) {
    				projectModel.addPackagedElement(project, javaAST.getPackage().resolveBinding(),
    						(IPackageFragment) javaElement.getParent(), rootModelELement);
    			}
    		}
    		
    		// Save or update model resource:
    		URI modelURI = transformation.getModelURI(baseURI);
    		XMLResource resourceOld = null; // for reuse of XMI object IDs
    		
    		if (resourceSet.getURIConverter().exists(modelURI, null)) {
    			resourceOld = (XMLResource) resourceSetOld.getResource(modelURI, true);
    		}
    		
			emfHelper.saveModelWithBindings(modelURI, resourceSet, modelBindings.getBindings(),
					transformation.getRootModelElements(), resourceOld);
		}
    	
    	// Add project to workspace:
    	if (!projectModel.getProjectModel().getContents().isEmpty()) {
    		workspaceModel.addToWorkspace(projectModel.getProjectModel().getContents().get(0));
    	}
    }
}
