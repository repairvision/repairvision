package org.sidiff.reverseengineering.java.transformation.uml;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.IPackageBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.sidiff.reverseengineering.java.transformation.JavaASTLibraryModel;

/**
 * Manages the creation of library UML model elements.
 * 
 * @author Manuel Ohrndorf
 */
public class JavaASTLibraryModelUML extends JavaASTLibraryModel {

	private UMLFactory umlFactory = UMLFactory.eINSTANCE;
	
	private UMLPackage umlPackage = UMLPackage.eINSTANCE;
	
	private Model libraryModelRoot;
	
	/**
	 * @param libraryModel The library model.
	 */
	public JavaASTLibraryModelUML(XMLResource libraryModel) {
		super(libraryModel);
		
		if (libraryModel.getContents().isEmpty()) {
			this.libraryModelRoot = umlFactory.createModel();
			this.libraryModelRoot.setName("Library");
			libraryModel.getContents().add(libraryModelRoot);
		} else {
			this.libraryModelRoot = (Model) libraryModel.getContents().get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E extends EObject> E getLibraryModelElement(IBinding externalBinding, EClass isTypeOf) {
		EObject libraryModelElement = super.getLibraryModelElement(externalBinding, isTypeOf);
		
		// Already exists?
		if (libraryModelElement != null) {
			return (E) libraryModelElement;
		}
		
		// Create new:
		switch (externalBinding.getKind()) {
		case IBinding.PACKAGE:
			libraryModelElement = createLibraryPackage((IPackageBinding) externalBinding);
			break;
		case IBinding.TYPE:
			ITypeBinding typeBinding = (ITypeBinding) externalBinding;
			
			if (typeBinding.isEnum()) {
				libraryModelElement = createLibraryEnumeration(typeBinding);
			} else if (typeBinding.isInterface()) {
				libraryModelElement = createLibraryInterface(typeBinding);
			} else if (typeBinding.isClass()) {
				libraryModelElement = createLibraryClass(typeBinding);
			}
			
			break;
		case IBinding.VARIABLE:
			IVariableBinding variableBinding = (IVariableBinding) externalBinding;
			
			if (variableBinding.isParameter()) {
				libraryModelElement = createLibraryParameter(variableBinding);
			} else if (variableBinding.isEnumConstant()) { // is also field
				libraryModelElement = createLibraryEnumLiteral(variableBinding);
			} else if (variableBinding.isField()) {
				libraryModelElement = createLibraryProperty(variableBinding);
			}
			
			break;
		case IBinding.METHOD:
			libraryModelElement = createLibraryOperation((IMethodBinding) externalBinding);
			break;
		}
		
		// Trace and return new model element:
		if (libraryModelElement != null) {
			getLibraryModel().setID(libraryModelElement, externalBinding.getKey());
			return (E) libraryModelElement;
		}
		
		return null;
	}

	protected EObject createLibraryPackage(IPackageBinding packageBinding) {
		// TODO: Create hierarchical Packages!?
		Package libraryPackage = umlFactory.createPackage();
		libraryPackage.setName(packageBinding.getName());
		libraryModelRoot.getPackagedElements().add(libraryPackage);
		return libraryPackage;
	}

	protected EObject createLibraryEnumeration(ITypeBinding typeBinding) {
		Enumeration libraryEnum = umlFactory.createEnumeration();
		libraryEnum.setName(typeBinding.getName());
		
		Package libraryPackage = getLibraryModelElement(typeBinding.getPackage(), umlPackage.getPackage());
		libraryPackage.getOwnedTypes().add(libraryEnum);
		
		return libraryEnum;
	}

	protected EObject createLibraryEnumLiteral(IVariableBinding variableBinding) {
		EnumerationLiteral libraryEnumLiteral = umlFactory.createEnumerationLiteral();
		libraryEnumLiteral.setName(variableBinding.getName());
		
		Enumeration libraryEnum = getLibraryModelElement(variableBinding.getDeclaringClass(), umlPackage.getEnumeration());
		libraryEnum.getOwnedLiterals().add(libraryEnumLiteral);
		
		return libraryEnumLiteral;
	}

	protected EObject createLibraryInterface(ITypeBinding typeBinding) {
		Interface libraryIterface = umlFactory.createInterface();
		libraryIterface.setName(typeBinding.getName());
		
		Package libraryPackage = getLibraryModelElement(typeBinding.getPackage(), umlPackage.getPackage());
		libraryPackage.getOwnedTypes().add(libraryIterface);
		
		return libraryIterface;
	}

	protected EObject createLibraryClass(ITypeBinding typeBinding) {
		Class libraryClass = umlFactory.createClass();
		libraryClass.setName(typeBinding.getName());
		
		Package libraryPackage = getLibraryModelElement(typeBinding.getPackage(), umlPackage.getPackage());
		libraryPackage.getOwnedTypes().add(libraryClass);
		
		return libraryClass;
	}

	protected EObject createLibraryOperation(IMethodBinding methodBinding) {
		Operation libraryOperation = umlFactory.createOperation();
		libraryOperation.setName(methodBinding.getName());
		
		Classifier libraryClassifier = getLibraryModelElement(methodBinding.getDeclaringClass(), umlPackage.getClassifier());
		libraryClassifier.getOperations().add(libraryOperation);
		
		// TODO: Create parameter signature!
		
		return libraryOperation;
	}

	protected EObject createLibraryParameter(IVariableBinding variableBinding) {
		Parameter libraryParameter = umlFactory.createParameter();
		libraryParameter.setName(variableBinding.getName());
		
		Operation libraryOperation = getLibraryModelElement(variableBinding.getDeclaringMethod(), umlPackage.getOperation());
		libraryOperation.getOwnedParameters().add(libraryParameter);
		
		return libraryParameter;
	}

	protected EObject createLibraryProperty(IVariableBinding variableBinding) {
		Property libraryProperty = umlFactory.createProperty();
		libraryProperty.setName(variableBinding.getName());
		
		StructuredClassifier libraryClassifier = getLibraryModelElement(variableBinding.getDeclaringClass(), umlPackage.getStructuredClassifier());
		libraryClassifier.getOwnedAttributes().add(libraryProperty);
		
		return libraryProperty;
	}
}
