package org.sidiff.reverseengineering.java.transformation;

import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.ModuleDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.VariableDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.sidiff.reverseengineering.java.util.JavaASTUtil;

/**
 * Manages the Java AST to model bindings.
 * 
 * @author Manuel Ohrndorf
 */
public class JavaASTBindingResolver {

	/**
	 * The local projects in the workspace that will be transformed to corresponding
	 * models. Otherwise, a project will be considered as external projects.
	 * External projects might be generated as common fragments.
	 */
	private Set<String> workspaceProjects;
	
	/**
	 * The file extension of the corresponding modeling domain.
	 */
	private String modelFileExtension;
	
	/**
	 * Creates bindings for the model.
	 */
	private JavaASTBindingTranslator bindingTranslator;

	/**
	 * Binding key -> Model element
	 */
	private Map<String, EObject> bindings;
	
	/**
	 * The common model manager.
	 */
	private JavaASTLibraryModel libraryModel;
	
	/**
	 * @param workspaceProjects  The local projects in the workspace that will be
	 *                           transformed to corresponding models. Otherwise, a
	 *                           project will be considered as external projects.
	 *                           External projects might be generated as common
	 *                           fragments.
	 * @param modelFileExtension The file extension of the modeling domain.
	 * @param bindings           The initial bindings, e.g., common model elements.
	 * @param libraryModel        The common model manager.
	 */
	public JavaASTBindingResolver(Set<String> workspaceProjects, String modelFileExtension,
			JavaASTBindingTranslator bindingTranslator, Map<String, EObject> bindings,
			JavaASTLibraryModel libraryModel) {
		
		this.workspaceProjects = workspaceProjects;
		this.modelFileExtension = modelFileExtension;
		this.bindingTranslator = bindingTranslator;
		this.bindings = bindings;
		this.libraryModel = libraryModel;
	}
	
	/**
	 * Traces a model element binding in this transformation.
	 * 
	 * @param projectName  The name of the containing project
	 * @param binding      The Java AST binding of the corresponding model element.
	 * @param modelElement A model element (or main element of model fragment).
	 */
	public void bind(String projectName, IBinding binding, EObject modelElement) {
		bindings.put(bindingTranslator.getBindingKey(projectName, binding), modelElement);
	}

	/**
	 * @param astBindingKey  The binding of the AST root in which the given node is
	 *                       contained.
	 * @param nodeBindingKey An AST node binding.
	 * @param isTypeOfThe    The minimal type of the proxy
	 * @return The corresponding model element.
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public <E extends EObject> E resolveBinding(IPath localPath, IBinding binding, EClass isTypeOf) 
			throws ClassNotFoundException {
		
		if (JavaASTUtil.isPrimitiveType(binding)) {
			return libraryModel.getPrimitiveType(binding);
		} else {
			IJavaElement javaElement = binding.getJavaElement();
			String projectName = javaElement.getJavaProject().getProject().getName();
			String uniqueBindingKey = bindingTranslator.getBindingKey(projectName, binding);
			
			// Check for internal bindings and already existing common external bindings:
			EObject existingBinding = bindings.get(uniqueBindingKey); 
			
			if (existingBinding != null) {
				return (E) existingBinding;
			} else {
				// Create new workspace proxy binding or common external binding:
				IPath externalPath = javaElement.getPath();
				return (E) createExternalBinding(projectName, binding, externalPath, localPath, isTypeOf);
			}
		}
	}

	/**
	 * @param externalProjectName The name of the external project containing the
	 * @param externalBinding     The Java AST binding.
	 * @param externalPath        The path to the external model.
	 * @param localPath           The local path of the current model.
	 * @param isTypeOfThe         The minimal type of the external model element.
	 * @return The external model element (common or proxy) for the given binding.
	 * @throws ClassNotFoundException
	 */
	protected EObject createExternalBinding(
			String externalProjectName, IBinding externalBinding, 
			IPath externalPath, IPath localPath, EClass isTypeOf) 
					throws ClassNotFoundException {
		
		if (workspaceProjects.contains(externalProjectName) && isInWorkspace(externalBinding)) {
			
			// External workspace model element:
			URI externalBindingURI = getExternalURI(externalProjectName, externalBinding, externalPath, localPath);
			String uniqueBindingKey = externalBindingURI.fragment();
			EObject newExternalModelElement = createExternalProxy(externalBindingURI, externalBinding, isTypeOf);

			// Trace the new binding:
			if ((newExternalModelElement != null) && (newExternalModelElement != null)) {
				bindings.put(uniqueBindingKey, newExternalModelElement);
			}
			
			return newExternalModelElement;
		} else {
			
			// External common model element:
			return libraryModel.getLibraryModelElement(externalBinding, isTypeOf);
		}
	}
	
	/**
	 * @param externalBinding A Java binding.
	 * @return <code>true</code> if it is a source file in the workspace;
	 *         <code>false</code> if it is, e.g., a Java source of the JDT.
	 */
	protected boolean isInWorkspace(IBinding externalBinding) {
		return externalBinding.getJavaElement().getResource() != null;
	}

	/**
	 * @param externalBindingURI The model element URI based on the Java AST binding.
	 * @param externalBinding    The Java AST binding.
	 * @param isTypeOfThe        minimal type of the proxy.
	 * @return A proxy model element for the given configuration.
	 * @throws ClassNotFoundException
	 */
	protected EObject createExternalProxy(URI externalBindingURI, IBinding externalBinding, EClass isTypeOf) 
			throws ClassNotFoundException {

		BasicEObjectImpl proxyElement = (BasicEObjectImpl) EcoreUtil.create(getBindingProxyType(externalBinding, isTypeOf));
		proxyElement.eSetProxyURI(externalBindingURI);
		
		return proxyElement;
	}
	
	/**
	 * @param externalProjectName The name of the external project containing the
	 * @param externalBinding     The Java AST binding.
	 * @param externalPath        The path to the external model.
	 * @param localPath           The local path of the current model.
	 * @return The URI to the external model.
	 */
	protected URI getExternalURI(String externalProjectName, IBinding externalBinding, IPath externalPath, IPath localPath) {
		IPath relativePath = getModelPath(externalPath.makeRelativeTo(localPath));
		URI modelURI = URI.createURI(relativePath.toString(), true);
		return getURI(modelURI, externalProjectName, externalBinding);
	}
	
	/**
	 * @param modelURI    The URI to the model resource.
	 * @param projectName The name of the containing project
	 * @param binding     The Java AST binding.
	 * @return The URI with the corresponding fragment.
	 */
	protected URI getURI(URI modelURI, String projectName, IBinding binding) {
		return modelURI.appendFragment(bindingTranslator.getBindingKey(projectName, binding));
	}
	
	/**
	 * @param node An node of the AST.
	 * @return The binding of this node or <code>null</code>.
	 */
	public IBinding getBinding(ASTNode node) {

		// see org.eclipse.jdt.core.dom.IBinding
		// see org.eclipse.jdt.core.dom.DefaultBindingResolver

		if (node instanceof ModuleDeclaration) {
			return ((ModuleDeclaration) node).resolveBinding();
		} else if (node instanceof AbstractTypeDeclaration) {
			return ((AbstractTypeDeclaration) node).resolveBinding();
		} else if (node instanceof VariableDeclaration) {
			return ((VariableDeclaration) node).resolveBinding();
		} else if (node instanceof FieldDeclaration) {
			FieldDeclaration fieldDeclaration = (FieldDeclaration) node;
			
			if ((fieldDeclaration.fragments().size() == 1) 
					&& (fieldDeclaration.fragments().get(0) instanceof VariableDeclarationFragment)) {
				
				VariableDeclarationFragment declarationFragment = (VariableDeclarationFragment) fieldDeclaration.fragments().get(0);
				return declarationFragment.resolveBinding();
			}
		} else if (node instanceof MethodDeclaration) {
			return ((MethodDeclaration) node).resolveBinding();
		} else if (node instanceof Annotation) {
			return ((Annotation) node).resolveAnnotationBinding();
		} else if (node instanceof MemberValuePair) {
			return ((MemberValuePair) node).resolveMemberValuePairBinding();
		} else if (node instanceof EnumConstantDeclaration) {
			return ((EnumConstantDeclaration) node).resolveVariable();
		} else if (node instanceof Type) {
			return ((Type) node).resolveBinding();
		}

		return null;
	}
	
	/**
	 * Returns the type of a proxy element based on a Java AST binding. The type is
	 * also stored in the xmi:type attribute of the model file. Please note that,
	 * for example, a UML Class might be converted into an Interface. This would
	 * require to load and save all resources with references pointing at the new
	 * interface, to change the type stored in the xmi:type attribute. However, the
	 * xmi:type only determines the type of the proxy objects and do not lead to
	 * failures during loading. The xmi:type have to be a concrete class, i.e., not
	 * abstract or an interface. For example, a UML Class could even be represented
	 * by an Activity as the Type of a Parameter.
	 * 
	 * @param binding  The Java AST binding.
	 * @param isTypeOf The minimal type required type;
	 * @return The type of the proxy model element.
	 */
	protected EClass getBindingProxyType(IBinding binding, EClass isTypeOf) throws ClassNotFoundException {

		if (!isTypeOf.isInterface() && !isTypeOf.isAbstract()) {
			return isTypeOf;
		}
		
		// Generic strategy:
		EClass concreteSubClass = getConcreteSubClass(isTypeOf, isTypeOf.eClass().getEPackage());
		
		if (concreteSubClass != null) {
			return concreteSubClass;
		}

		throw new ClassNotFoundException("No concrete subtype found: " + isTypeOf.toString());
	}

	private EClass getConcreteSubClass(EClass eSuperClass, EPackage ePackage) {
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				
				if (!eClass.isInterface() && !eClass.isAbstract()) {
					if (eClass.getEAllSuperTypes().contains(eSuperClass)) {
						return eClass;
					}
				}
			}
		}
		
		for (EPackage sub : ePackage.getESubpackages()) {
			return getConcreteSubClass(eSuperClass, sub);
		}
		
		return null;
	}
	
	/**
	 * @param astPath The path of the Java AST resource.
	 * @return The path of the corresponding model.
	 */
	public IPath getModelPath(IPath astPath) {
		return astPath.removeFileExtension().addFileExtension(modelFileExtension);
	}
	
	/**
	 * @return The file extension of the corresponding modeling domain.
	 */
	public String getModelFileExtension() {
		return modelFileExtension;
	}

	/**
	 * @return The local projects in the workspace that will be transformed to
	 *         corresponding models. Otherwise, a project will be considered as
	 *         external projects. External projects might be generated as common
	 *         fragments.
	 */
	public Set<String> getWorkspaceProjects() {
		return workspaceProjects;
	}
	
	/**
	 * @return Binding key -> Model element
	 */
	public Map<String, EObject> getBindings() {
		return bindings;
	}
}
