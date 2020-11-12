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
import org.eclipse.uml2.uml.DataType;
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
import org.sidiff.reverseengineering.java.transformation.JavaASTBindingTranslator;
import org.sidiff.reverseengineering.java.transformation.JavaASTLibraryModel;
import org.sidiff.reverseengineering.java.util.JavaASTUtil;

/**
 * Manages the creation of library UML model elements.
 * 
 * @author Manuel Ohrndorf
 */
public class JavaASTLibraryModelUML extends JavaASTLibraryModel {

	private UMLFactory umlFactory = UMLFactory.eINSTANCE;
	
	private UMLPackage umlPackage = UMLPackage.eINSTANCE;
	
	private Model libraryModelRoot;
	
	private Package primitiveTypeModel;
	
	/**
	 * @param libraryModel      The library model.
	 * @param bindingTranslator Creates model object IDs.
	 */
	public JavaASTLibraryModelUML(XMLResource libraryModel, JavaASTBindingTranslator bindingTranslator) {
		super(libraryModel, bindingTranslator);
		
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
	public DataType getPrimitiveType(IBinding binding) {
		EObject libraryModelElement =  super.getPrimitiveType(binding);

		if ((libraryModelElement == null) && JavaASTUtil.isPrimitiveType(binding)) {
			if (primitiveTypeModel == null) {
				createLibraryPrimitiveModel();
			}
			DataType newDataType = createLibraryPrimitiveDataType(binding);
			bindPrimitiveType(binding, newDataType);
			return newDataType;
		}
		
		return (DataType) libraryModelElement;
	}

	protected void createLibraryPrimitiveModel() {
		this.primitiveTypeModel = umlFactory.createPackage();
		this.primitiveTypeModel.setName("datatypes");
		this.libraryModelRoot.getPackagedElements().add(0, primitiveTypeModel);
	}

	protected DataType createLibraryPrimitiveDataType(IBinding binding) {
		DataType primitiveDataType = umlFactory.createDataType();
		primitiveDataType.setName(binding.getName());
		primitiveTypeModel.getPackagedElements().add(primitiveDataType);
		return primitiveDataType;
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
			return (E) createLibraryPackage((IPackageBinding) externalBinding); // binds internally
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
			bindModelElement(externalBinding, libraryModelElement);
			return (E) libraryModelElement;
		}
		
		return null;
	}

	protected EObject createLibraryPackage(IPackageBinding packageBinding) {
		String bindingKey = null;
		Package parentPackage = libraryModelRoot;
		Package childPackage = null;
		
		for (String packageName : packageBinding.getNameComponents()) {
			if (bindingKey == null) {
				bindingKey = packageName;
			} else {
				bindingKey += "/" + packageName;
			}
			childPackage = super.getLibraryModelElement(getBindingKey(bindingKey));
					
			if (childPackage == null) {
				childPackage = umlFactory.createPackage();
				childPackage.setName(packageName);
				parentPackage.getPackagedElements().add(childPackage);
				bindModelElement(getBindingKey(bindingKey), childPackage);
			}
			
			parentPackage = childPackage;
		}
		
		return childPackage;
	}

	protected EObject createLibraryEnumeration(ITypeBinding typeBinding) {
		Enumeration libraryEnum = umlFactory.createEnumeration();
		libraryEnum.setName(typeBinding.getName());
		
		Package libraryPackage = getLibraryModelElement(typeBinding.getPackage(), umlPackage.getPackage());
		libraryPackage.getOwnedTypes().add(libraryEnum);
		
		for (IVariableBinding enumLiteral : typeBinding.getDeclaredFields()) {
			EnumerationLiteral libraryEnumLiteral = umlFactory.createEnumerationLiteral();
			libraryEnumLiteral.setName(enumLiteral.getName());
			libraryEnum.getOwnedLiterals().add(libraryEnumLiteral);
		}
		
		return libraryEnum;
	}

	protected EObject createLibraryEnumLiteral(IVariableBinding variableBinding) {
		getLibraryModelElement(variableBinding.getDeclaringClass(), umlPackage.getEnumeration());
		return super.getLibraryModelElement(variableBinding, umlPackage.getEnumerationLiteral());
	}

	protected EObject createLibraryInterface(ITypeBinding typeBinding) {
		typeBinding = JavaASTUtil.genericTypeErasure(typeBinding);
		
		Interface libraryIterface = umlFactory.createInterface();
		libraryIterface.setName(typeBinding.getName());
		
		Package libraryPackage = getLibraryModelElement(typeBinding.getPackage(), umlPackage.getPackage());
		libraryPackage.getOwnedTypes().add(libraryIterface);
		
		return libraryIterface;
	}

	protected EObject createLibraryClass(ITypeBinding typeBinding) {
		typeBinding = JavaASTUtil.genericTypeErasure(typeBinding);
		
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
		
		// Create parameter signature:
		for (ITypeBinding parameter : methodBinding.getParameterTypes()) {
			Parameter libraryParameter = umlFactory.createParameter();
			libraryParameter.setName(parameter.getName());
			libraryOperation.getOwnedParameters().add(libraryParameter);
		}
		
		return libraryOperation;
	}

	protected EObject createLibraryParameter(IVariableBinding variableBinding) {
		getLibraryModelElement(variableBinding.getDeclaringMethod(), umlPackage.getOperation());
		return super.getLibraryModelElement(variableBinding, umlPackage.getParameter());
	}

	protected EObject createLibraryProperty(IVariableBinding variableBinding) {
		Property libraryProperty = umlFactory.createProperty();
		libraryProperty.setName(variableBinding.getName());
		
		StructuredClassifier libraryClassifier = getLibraryModelElement(variableBinding.getDeclaringClass(), umlPackage.getStructuredClassifier());
		libraryClassifier.getOwnedAttributes().add(libraryProperty);
		
		return libraryProperty;
	}
}
