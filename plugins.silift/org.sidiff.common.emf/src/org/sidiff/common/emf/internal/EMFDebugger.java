package org.sidiff.common.emf.internal;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.common.util.Debugger;
import org.sidiff.common.util.StatisticsUtil;

public class EMFDebugger implements Debugger {
	
	private static final String FUNCTION_PATTERN = "%s (%s) : %s\n";
	
	private static final String HELP = "EMFDebugger provides general functions for debugging Resources\n";
	
	private static final String COUNT_MODEL = "Counts Instances of each EClass occuring in the Resource";
	private static final String CHECK_MODEL_ID = "Checks for each EObject inside the Resource if it's Type is part of the Metamodel referenced by the given String URI";
	
	private static final String[] FUNCTIONS = {
			String.format(FUNCTION_PATTERN, "countModel", "Resource", COUNT_MODEL),
			String.format(FUNCTION_PATTERN, "checkModelID", "Resource, String", CHECK_MODEL_ID)
		};


	public void countModel(Resource resource) {
		TreeIterator<EObject> iterator = resource.getAllContents();
		StatisticsUtil stats = StatisticsUtil.getInstance();
		while (iterator.hasNext()) {
			EObject obj = iterator.next();
			stats.count(EMFUtil.getModelRelativeName(obj.eClass()));
		}
		System.out.println(stats.dump());
	}
	
	public boolean checkModelID(Resource resource,String modelURI){
		
		boolean result = true;
		
		TreeIterator<EObject> elementIter = resource.getAllContents();
		while(elementIter.hasNext()){
			EObject element = elementIter.next();
			
			EPackage epackage = element.eClass().getEPackage();
			while(!modelURI.equals(epackage.getNsURI())){
				epackage= epackage.getESuperPackage();
				if(epackage==null){
					LogUtil.log(LogEvent.ERROR, "Invalid object Type '"+element.getClass().getName()+"' -> Not in '"+modelURI+"'");
					result &= false;
					continue;
				}
			}
			
		}
		return result;
	}
	
	@Override
	public String help() {
		StringBuffer result = new StringBuffer(HELP);
		
		for(String function : FUNCTIONS){
			result.append(function);
		}
		result.deleteCharAt(result.length()-1);
		return result.toString();
	}
	
}
