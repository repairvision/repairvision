package org.sidiff.reverseengineering.java.transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
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
	 * The name of the corresponding project (namespace).
	 */
	private String projectName;
	
	/**
	 * The corresponding Java resource in the workspace.
	 */
	private CompilationUnit javaAST;
	
	/**
	 * The corresponding relative transformation path.
	 */
	private String[] transformationPath;
	
	/**
	 * Manages the Java AST to model bindings.
	 */
	private JavaASTBindingResolver bindings;
	
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
	 * @param javaAST The Java AST to be transformed.
	 * @param bindings    Manages the Java AST to model bindings.
	 * @return itself
	 */
	public JavaASTTransformation init(CompilationUnit javaAST, JavaASTBindingResolver bindings) {
		this.javaAST = javaAST;
		this.bindings = bindings;

		IJavaElement javaElement = javaAST.getJavaElement();
		this.projectName = javaElement.getResource().getProject().getName();
		this.transformationPath = bindings.getModelPath(projectName, javaElement);
		this.rootModelElements = new ArrayList<>();
		this.javaToModelTrace = new HashMap<>();
		return this;
	}
	
	/**
	 * Start the transformation process.
	 * 
	 * @param javaAST The Java AST to be transformed.
	 */
	public void apply() {
		javaAST.accept(this);
	}

	/**
	 * @param binding     An AST node binding.
	 * @param isTypeOfThe The minimal type of the proxy
	 * @return The corresponding model element; possibly a proxy that can not be
	 *         resolved/loaded yet! So do NOT access informations of this object!
	 */
	public <E extends EObject> E resolveBindingProxy(IBinding binding, EClass isTypeOf) throws ClassNotFoundException {
		E bindingProxy = bindings.resolveBindingProxy(transformationPath, binding, isTypeOf);

		if (Activator.getLogger().isLoggable(Level.FINER)) {
			if ((isTypeOf == bindingProxy.eClass()) || isTypeOf.getEAllSuperTypes().contains(bindingProxy.eClass())) {
				Activator.getLogger().log(Level.FINER, "Binding type mismatch:\n" + binding + "\n" + bindingProxy + "\n" + isTypeOf);
			}
		}

		return bindingProxy;
	}

	/**
	 * Traces a root model element in this transformation.
	 * 
	 * @param rootModelElement A model element (or main element of model fragment).
	 */
	public void createRootModelElement(ASTNode astNode, EObject rootModelElement) {

		if ((astNode != null) && (rootModelElement != null)) {

			// Trace generated element:
			javaToModelTrace.put(astNode, rootModelElement);

			// Trace binding key for cross AST resolution:
			IBinding binding = bindings.getBinding(astNode);

			if (binding != null) {
				bindings.bind(projectName, binding, rootModelElement);
			}

			// Log creation of root model element:
			rootModelElements.add(rootModelElement);
		} else {
			if (Activator.getLogger().isLoggable(Level.FINE)) {
				Activator.getLogger().log(Level.FINE, "Tace with null-element:\n" + astNode + "\n" + rootModelElement);
			}
		}
	}

	/**
	 * Traces a main model element in this transformation and creates a binding.
	 * 
	 * @param modelElement A model element.
	 */
	public void createModelElement(ASTNode astNode, EObject modelElement) {
		
		if ((astNode != null) && (modelElement != null)) {
			
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
		} else {
			if (Activator.getLogger().isLoggable(Level.FINE)) {
				Activator.getLogger().log(Level.FINE, "Tace with null-element:\n" + astNode + "\n" + modelElement);
			}
		}
	}
	
	/**
	 * Traces a model element fragment (no binding) in this transformation.
	 * 
	 * @param modelElement A model element fragment (no binding).
	 */
	public void createModelElementFragment(ASTNode astNode, EObject modelElement) {
		
		if ((astNode != null) && (modelElement != null)) {
			
			// Trace generated element:
			javaToModelTrace.put(astNode, modelElement);
		} else {
			if (Activator.getLogger().isLoggable(Level.FINE)) {
				Activator.getLogger().log(Level.FINE, "Tace with null-element:\n" + astNode + "\n" + modelElement);
			}
		}
		
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
		return baseURI.appendSegments(transformationPath);
	}
	
	/**
	 * @return The helper which computes the binding keys.
	 */
	public JavaASTBindingResolver getBindingResolver() {
		return bindings;
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
	
	/**
	 * @return The corresponding Java AST.
	 */
	public CompilationUnit getJavaAST() {
		return javaAST;
	}
}
