package org.sidiff.common.emf;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;

public class EMFValidate {
	
	static int minimumSeverity = Diagnostic.WARNING;
	
	public static void validateObject(EObject... eObjects) throws InvalidModelException
	  {
		String message = null;
		LogUtil.log(LogEvent.NOTICE, "------------------------------------------------------------");
		LogUtil.log(LogEvent.NOTICE, "-------------------------- Validate ------------------------");
		LogUtil.log(LogEvent.NOTICE, "------------------------------------------------------------");
		for(EObject eObject : eObjects){
			
			ArrayList<String> warnings = new ArrayList<String>();
			ArrayList<String> errors = new ArrayList<String>();
			
			// Get name:
			EStructuralFeature nameFeature = eObject.eClass().getEStructuralFeature("name");
			String name = eObject.toString();
					
			if (nameFeature != null && eObject.eGet(nameFeature)!=null) {
				name = eObject.eGet(nameFeature).toString();
			}
			
			LogUtil.log(LogEvent.NOTICE, "Validating: " + eObject);
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
			if (diagnostic.getSeverity() == Diagnostic.ERROR || 
					(diagnostic.getSeverity() == Diagnostic.WARNING && minimumSeverity == Diagnostic.WARNING )){
				if(message == null)
					message = name + ": ;";
				else
					message += " ;" + name + ": ;";
				
				LogUtil.log(LogEvent.MESSAGE, diagnostic.getMessage());
				for (Iterator i=diagnostic.getChildren().iterator(); i.hasNext();)
				{
					Diagnostic childDiagnostic = (Diagnostic)i.next();
					switch (childDiagnostic.getSeverity())
					{
						case Diagnostic.ERROR:
							LogUtil.log(LogEvent.ERROR, "\t" + childDiagnostic.getMessage());
							errors.add(childDiagnostic.getMessage());
							break;
						case Diagnostic.WARNING:
							if(minimumSeverity == Diagnostic.WARNING) {
								LogUtil.log(LogEvent.WARNING, "\t" + childDiagnostic.getMessage());
								warnings.add(childDiagnostic.getMessage());
							}
							break;
					}
				}
				if(!warnings.isEmpty()){
					message += "- - - - - - - - - - WARNINGS - - - - - - - - - -;";
					for(String s : warnings)
						message +=s + ";";
				}
				if(!errors.isEmpty()){
					message += "- - - - - - - - - - ERRORS - - - - - - - - - - - -;";
					for(String s : errors)
						message += s + ";";
				}
			}
	    }
	    if(message != null){
	    	throw new InvalidModelException(message);
	    }
	    else{
	    	LogUtil.log(LogEvent.NOTICE, "Validation successfull. Minimum Severity: " + minimumSeverity);
	    }
	  }
	
	/**
	 * Convenient method for validation a Resource, this just delegates the validation for
	 * each root node of the resource.
	 * @param model resource to validate
	 * @throws InvalidModelException if there are some negative validation results
	 */
	public static void validateModel(Resource model) throws InvalidModelException{
		for(EObject root : model.getContents()){
			validateObject(root);
		}
	}
	
	/**
	 * Convenient method for validation a ResourceSet, this just delegates the validation for
	 * each root Resource of the ResourceSet.
	 * @param model resource set to validate
	 * @throws InvalidModelException if there are some negative validation results
	 */
	public static void validateModel(ResourceSet model) throws InvalidModelException{
		for(Resource root : model.getResources()){
			validateModel(root);
		}
		
	}
	/**
	 * Sets the minimum severity which is needed for throwing an @{InvalidModelException}. If not set,
	 * defaults to @{Diagnostic.Warning} and thus includes warnings as well as errors
	 * according to EMF Diagnostic.
	 * @param severity
	 */
	public static void setMinimumValidationSeverity(int severity) {
		EMFValidate.minimumSeverity = severity;
	}
	
	
}
