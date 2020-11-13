package org.sidiff.reverseengineering.java.transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IBinding;
import org.sidiff.reverseengineering.java.Activator;

/**
 * Base implementation of a Java AST to model transformation.
 * 
 * @author Manuel Ohrndorf
 */
public abstract class JavaASTTransformation extends ASTVisitor {
	
	/**
	 * Manages the Java AST to model bindings.
	 */
	private JavaASTBindingResolver bindings;
	
	/**
	 * The corresponding Java resource in the workspace.
	 */
	private IResource astResource;
	
	/**
	 * The folder of the Java resource in the workspace.
	 */
	private IPath astResourceFolder;
	
	/**
	 * The name of the corresponding project (namespace).
	 */
	private String projectName;
	
	/**
	 * All root model elements created by this transformation.
	 */
	private List<EObject> rootModelElements;
	
	/**
	 * Trace: Java AST node -> Model element
	 */
	private Map<ASTNode, EObject> javaToModelTrace;
	
	/**
	 * Initializes the Java AST transformation.
	 * 
	 * @param astResource The corresponding Java resource in the workspace.
	 * @param bindings    Manages the Java AST to model bindings.
	 * @return itself
	 */
	public JavaASTTransformation init(IResource astResource, JavaASTBindingResolver bindings) {
		this.astResource = astResource;
		this.astResourceFolder = astResource.getParent().getFullPath();
		this.projectName = astResource.getProject().getName();
		this.bindings = bindings;
		this.rootModelElements = new ArrayList<>();
		this.javaToModelTrace = new HashMap<>();
		return this;
	}
	
	/**
	 * Start the transformation process.
	 * 
	 * @param javaAST The Java AST to be transformed.
	 */
	public void apply(CompilationUnit javaAST) {
		javaAST.accept(this);
	}

	/**
	 * @param binding     An AST node binding.
	 * @param isTypeOfThe The minimal type of the proxy
	 * @return The corresponding model element; possibly a proxy that can not be
	 *         resolved/loaded yet! So do NOT access informations of this object!
	 */
	public <E extends EObject> E resolveBindingProxy(IBinding binding, EClass isTypeOf) throws ClassNotFoundException {
		return bindings.resolveBindingProxy(astResourceFolder, binding, isTypeOf);
	}

	/**
	 * Traces a root model element in this transformation.
	 * 
	 * @param rootModelElement A model element (or main element of model fragment).
	 */
	public void createRootModelElement(ASTNode astNode, EObject rootModelElement) {
		assert (astNode != null);
		
		// Trace generated element:
		javaToModelTrace.put(astNode, rootModelElement);
		
		// Trace binding key for cross AST resolution:
		IBinding binding = bindings.getBinding(astNode);
		
		if (binding != null) {
			bindings.bind(projectName, binding, rootModelElement);
		}
		
		// Log creation of root model element:
		rootModelElements.add(rootModelElement);
	}
	
	/**
	 * Traces a main model element in this transformation and creates a binding.
	 * 
	 * @param modelElement A model element.
	 */
	public void createModelElement(ASTNode astNode, EObject modelElement) {
		assert (astNode != null);
		
		// Trace generated element:
		javaToModelTrace.put(astNode, modelElement);
		
		// Trace binding key for cross AST resolution:
		IBinding binding = bindings.getBinding(astNode);
		
		if (binding != null) {
			bindings.bind(projectName, binding, modelElement);
		} else {
			if (Activator.getLogger().isLoggable(Level.FINE)) {
				Activator.getLogger().log(Level.FINE, "No binding found for: " 
						+ astNode.getClass() + "\n" + modelElement + "\n" + astNode);
			}
		}
	}
	
	/**
	 * Traces a model element fragment (no binding) in this transformation.
	 * 
	 * @param modelElement A model element fragment (no binding).
	 */
	public void createModelElementFragment(ASTNode astNode, EObject modelElement) {
		assert (astNode != null);
		
		// Trace generated element:
		javaToModelTrace.put(astNode, modelElement);
	}
	
	/**
	 * @param astNode A Java AST node.
	 * @return A model element created by this transformation.
	 */
	@SuppressWarnings("unchecked")
	public <E extends EObject> E getModelElement(ASTNode astNode) {
		return (E) javaToModelTrace.get(astNode);
	}
	
	@SuppressWarnings("unchecked")
	public <E extends EObject> E getParentModelElement(ASTNode astNode, EClass type) {
		while(astNode != null) {
			EObject modelElement = getModelElement(astNode);

			if ((modelElement != null) && (type == modelElement.eClass())) {
				return (E) modelElement;
			}
			
			astNode = astNode.getParent();
		}
		return null;
	}
	
	/**
	 * @return The corresponding Java resource in the workspace.
	 */
	public IResource getAstResource() {
		return astResource;
	}
	
	/**
	 * @return The folder of the Java resource in the workspace.
	 */
	public IPath getAstResourceFolder() {
		return astResourceFolder;
	}
	
	/**
	 * @return The name of the corresponding project (namespace).
	 */
	public String getProjectName() {
		return projectName;
	}
	
	/**
	 * @param baseURI The first part of the URI, e.g., protocol.
	 * @return The base URI plus the model path equivalent to the Java AST path in
	 *         the workspace.
	 */
	public URI getModelURI(URI baseURI) {
		IPath projectStructure = bindings.getModelPath(astResource.getFullPath());
		return baseURI.appendSegments(projectStructure.segments());
	}
	
	/**
	 * @return Trace: Java AST node -> Model element
	 */
	public Map<ASTNode, EObject> getJavaToModelTrace() {
		return javaToModelTrace;
	}
	
	/**
	 * @return All root model elements created by this transformation.
	 */
	public List<EObject> getRootModelElements() {
		return rootModelElements;
	}
}
