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

/**
 * The UML model representing a Java project
 * 
 * @author Manuel Ohrndorf
 */
public class JavaASTProjectModelUML extends JavaASTProjectModel {
	
	private UMLFactory umlFactory = UMLFactory.eINSTANCE;
	
	protected Model projectModelRoot;
	
	protected Package defaultPackage;

	/**
	 * @param projectModel      The model representing a Java project
	 * @param bindingTranslator Helper to translate bindings.
	 */
	public JavaASTProjectModelUML(XMLResource projectModel, JavaASTBindingTranslator bindingTranslator) {
		super(projectModel, bindingTranslator);
	}
	
	@Override
	public void addPackagedElement(IProject project, IPackageBinding binding, EObject modelElement) {
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
				if (defaultPackage == null) {
					this.defaultPackage = umlFactory.createPackage();
					this.defaultPackage.setName("default");
					this.projectModelRoot.getNestedPackages().add(0, defaultPackage);
					bindModelElement(getBindingKey(project, "default"), defaultPackage);
				}
				
				this.defaultPackage.getPackagedElements().add((PackageableElement) modelElement);
			}
		}
	}
	
	protected Package getProjectPackage(IProject project) {
		if (projectModelRoot == null) {
			this.projectModelRoot = umlFactory.createModel();
			projectModelRoot.setName(project.getName());
			getProjectModel().getContents().add(projectModelRoot);
			
			bindModelElement(getBindingKey(project), projectModelRoot);
		}
		return projectModelRoot;
	}

}
