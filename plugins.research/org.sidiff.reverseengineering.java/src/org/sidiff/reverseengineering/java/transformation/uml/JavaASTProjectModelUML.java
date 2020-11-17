package org.sidiff.reverseengineering.java.transformation.uml;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.core.dom.IPackageBinding;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.sidiff.reverseengineering.java.transformation.JavaASTBindingTranslator;
import org.sidiff.reverseengineering.java.transformation.JavaASTProjectModel;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

/**
 * The UML model representing a Java project
 * 
 * @author Manuel Ohrndorf
 */
public class JavaASTProjectModelUML extends JavaASTProjectModel {
	
	protected UMLFactory umlFactory = UMLFactory.eINSTANCE;
	
	protected String defaultPackageName = "default" ;
	
	protected Model projectModelRoot;
	
	protected Package defaultPackage;

	/**
	 * @see {@link JavaASTProjectModel#JavaASTProjectModel(XMLResource, JavaASTBindingTranslator)}
	 */
	@Inject
	public JavaASTProjectModelUML(
			@Assisted XMLResource projectModel, 
			JavaASTBindingTranslator bindingTranslator) {
		super(projectModel, bindingTranslator);
	}
	
	@Override
	public void addPackagedElement(IProject project, IPackageBinding binding, EObject modelElement) {
		
		// default package?
		if (binding == null) {
			if (modelElement instanceof PackageableElement) {
				getDefaultPackage(project).getPackagedElements().add((PackageableElement) modelElement);
				return;
			}
		}
		
		String[] packages = binding.getNameComponents();
		String bindingKey = null;
		Package parentPackage = getProjectPackage(project);
		Package childPackage = null;

		for (String packageName : packages) {
			if (bindingKey == null) {
				bindingKey = packageName;
			} else {
				bindingKey += "/" + packageName;
			}
			
			if (packageName == packages[packages.length - 1]) {
				// Bind Java key to inner most package:
				childPackage = getModelElement(getBindingKey(project, binding.getKey()));
			} else {
				childPackage = getModelElement(getBindingKey(project, bindingKey));
			}

			if (childPackage == null) {
				childPackage = umlFactory.createPackage();
				childPackage.setName(packageName);
				parentPackage.getNestedPackages().add(childPackage);
				
				if (packageName == packages[packages.length - 1]) {
					// Bind Java key to inner most package:
					bindModelElement(getBindingKey(project, binding.getKey()), childPackage);
				} else {
					bindModelElement(getBindingKey(project, bindingKey), childPackage);
				}
			}

			parentPackage = childPackage;
		}
		
		// add model element:
		if (modelElement instanceof PackageableElement) {
			if (childPackage != null) {
				childPackage.getPackagedElements().add((PackageableElement) modelElement);
			} else {
				getDefaultPackage(project).getPackagedElements().add((PackageableElement) modelElement);
			}
		}
	}
	
	protected Package getProjectPackage(IProject project) {
		if (projectModelRoot == null) {
			if (getProjectModel().getContents().isEmpty() || !(getProjectModel().getContents().get(0) instanceof Model)) {
				this.projectModelRoot = umlFactory.createModel();
				projectModelRoot.setName(project.getName());
				getProjectModel().getContents().add(projectModelRoot);
				
				bindModelElement(getBindingKey(project), projectModelRoot);
			}
		}
		return projectModelRoot;
	}
	
	private Package getDefaultPackage(IProject project) {
		if (defaultPackage == null) {
			this.defaultPackage = (Package) getProjectPackage(project).getPackagedElement(defaultPackageName);
			
			if (defaultPackage == null) {
				this.defaultPackage = umlFactory.createPackage();
				this.defaultPackage.setName("default");
				getProjectPackage(project).getNestedPackages().add(0, defaultPackage);
				bindModelElement(getBindingKey(project, "default"), defaultPackage);
			}
		}
		return defaultPackage;
	}
}
