package org.sidiff.reverseengineering.java;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.sidiff.reverseengineering.java.transformation.JavaASTBindingResolver;
import org.sidiff.reverseengineering.java.transformation.JavaASTLibraryModel;
import org.sidiff.reverseengineering.java.transformation.JavaASTTransformation;
import org.sidiff.reverseengineering.java.transformation.uml.JavaASTBindingResolverUML;
import org.sidiff.reverseengineering.java.transformation.uml.JavaASTLibraryModelUML;
import org.sidiff.reverseengineering.java.transformation.uml.JavaASTTransformationUML;
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

		// Application Settings:
		URI baseURI = URI.createFileURI("D:\\workspaces\\revision\\org.sidiff.reverseengineering.java\\test");
		Set<String> workspaceProjects = new HashSet<>(Arrays.asList(new String[] { "Test" }));
		
		JavaParser javaParser = new JavaParser();
		EMFHelper emfHelper = new EMFHelper();
		
		ResourceSet resourceSet = new ResourceSetImpl();
		URI commonModelURI = baseURI.appendSegment("Libraries").appendFileExtension("uml");
    	XMLResource commonModelResource = (XMLResource) resourceSet.createResource(commonModelURI);
    	JavaASTLibraryModel commonModel = new JavaASTLibraryModelUML(commonModelResource);
    	
    	Supplier<JavaASTTransformation> javaAST2Model = () -> new JavaASTTransformationUML();
    	JavaASTBindingResolver modelBindings = new JavaASTBindingResolverUML(workspaceProjects, new HashMap<>(), commonModel);

		// Get all projects in the workspace
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject[] projects = root.getProjects();

		for (IProject project : projects) {
			try {
				if (workspaceProjects.contains(project.getName())) {
					if (WorkspaceUtil.isJavaProject(project)) {
						generateModel(baseURI, workspaceProjects, project, resourceSet, javaParser, emfHelper,
								javaAST2Model, modelBindings, commonModel);
					}
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		
		// Save common library model:
    	try {
			commonModel.getLibraryModel().save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

    	System.out.println("FINISHED!");
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
	}
	
	private void generateModel(URI baseURI, Set<String> workspaceProjects, IProject project, ResourceSet resourceSet,
			JavaParser javaParser, EMFHelper emfHelper, Supplier<JavaASTTransformation> javaAST2Model, JavaASTBindingResolver modelBindings,
			JavaASTLibraryModel libraryModel) throws JavaModelException {

		Map<ICompilationUnit, CompilationUnit> parsedASTs = javaParser.parse(project, true);

    	ResourceSet resourceSetOld = new ResourceSetImpl();
    	
    	for (CompilationUnit javaAST : parsedASTs.values()) {
    		System.out.println(javaAST.getJavaElement().getResource());
    		
    		JavaASTTransformation transformation = javaAST2Model.get();
    		transformation.init(javaAST.getJavaElement().getResource(), modelBindings);
    		transformation.apply(javaAST);
    		
    		// Save or update model resource:
    		URI modelURI = transformation.getModelURI(baseURI);
    		XMLResource resourceOld = null; // for reuse of XMI object IDs
    		
    		if (resourceSet.getURIConverter().exists(modelURI, null)) {
    			resourceOld = (XMLResource) resourceSetOld.getResource(modelURI, true);
    		}
    		
			emfHelper.saveModelWithBindings(modelURI, resourceSet, modelBindings.getBindings(),
					transformation.getRootModelElements(), resourceOld);
		}
    }
}
