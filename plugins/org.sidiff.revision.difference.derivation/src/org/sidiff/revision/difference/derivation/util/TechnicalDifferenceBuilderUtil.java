package org.sidiff.revision.difference.derivation.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.difference.derivation.GenericTechnicalDifferenceBuilder;
import org.sidiff.revision.difference.derivation.ITechnicalDifferenceBuilder;

public class TechnicalDifferenceBuilderUtil {
	
	private final static ITechnicalDifferenceBuilder GENERIC_TECHNICAL_DIFFERENCE_BUILDER = new GenericTechnicalDifferenceBuilder();

	/**
	 * Returns the available technical difference builders for the given documentTypes.
	 * If no convenient builder is found, a generic technical difference builder will be returned.
	 * 
	 * @param documentTypes
	 * @return
	 */
	public static List<ITechnicalDifferenceBuilder> getAvailableTechnicalDifferenceBuilders(Set<String> documentTypes){
		List<ITechnicalDifferenceBuilder> tdbSet = new ArrayList<ITechnicalDifferenceBuilder>();
		
		for(ITechnicalDifferenceBuilder techBuilder : getAllAvailableTechnicalDifferenceBuilders()){
			if (techBuilder.canHandleDocTypes(documentTypes)) {
				tdbSet.add(techBuilder);
			}
		}
		
		tdbSet.add(GENERIC_TECHNICAL_DIFFERENCE_BUILDER);
		return tdbSet;
	}
	
	/**
	 * Returns the available technical difference builders for the documentTypes of the given models.
	 * If no convenient builder is found, a generic technical difference builder will be returned.
	 * 
	 * @param documentTypes
	 * @return
	 */
	public static List<ITechnicalDifferenceBuilder> getAvailableTechnicalDifferenceBuilders(Resource modelA, Resource modelB){
		List<ITechnicalDifferenceBuilder> tdbSet = new ArrayList<ITechnicalDifferenceBuilder>();
		
		for(ITechnicalDifferenceBuilder techBuilder : getAllAvailableTechnicalDifferenceBuilders()){
			if (techBuilder.canHandleModels(modelA, modelB)) {
				tdbSet.add(techBuilder);
			}
		}
		
		tdbSet.add(GENERIC_TECHNICAL_DIFFERENCE_BUILDER);
		return tdbSet;
	}
	
	/**
	 * 
	 * Returns the default technical difference builder for the given
	 * documentTypes: <br/>
	 * In case of Ecore: take first non-generics diff builder. <br/>
	 * Otherwise: take first technical difference builder.
	 * 
	 * @param documentTypes
	 * @return
	 */
	public static ITechnicalDifferenceBuilder getDefaultTechnicalDifferenceBuilder(Set<String> documentTypes){
		List<ITechnicalDifferenceBuilder> tdBuilders = getAvailableTechnicalDifferenceBuilders(documentTypes);
		ITechnicalDifferenceBuilder tdBuilder = null;
		
		if (!tdBuilders.isEmpty()){
			tdBuilder = tdBuilders.get(0);
		} else {
			tdBuilder = getGenericTechnicalDifferenceBuilder();
		}
		
		return tdBuilder;
	}
	
	/**
	 * Returns a generic technical difference builder.
	 * 
	 * @return
	 */
	public static ITechnicalDifferenceBuilder getGenericTechnicalDifferenceBuilder(){
		return GENERIC_TECHNICAL_DIFFERENCE_BUILDER;
	}
	
	/**
	 * Returns the technical difference builder with the given key.
	 * 
	 * @param name
	 * @return
	 */
	public static ITechnicalDifferenceBuilder getTechnicalDifferenceBuilder(String key){
		ITechnicalDifferenceBuilder tbExtension = null;
		for(ITechnicalDifferenceBuilder techBuilder : getAllAvailableTechnicalDifferenceBuilders()){
			if (techBuilder.getKey().equals(key)) {
				tbExtension = techBuilder;
				break;
			}
		}
		return tbExtension;
	}
	
	/**
	 * Get all technical difference builders from the extension registry.
	 * 
	 * @return
	 */
	public static List<ITechnicalDifferenceBuilder> getAllAvailableTechnicalDifferenceBuilders(){
		List<ITechnicalDifferenceBuilder> availableTechBuilders = new ArrayList<ITechnicalDifferenceBuilder>();
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(ITechnicalDifferenceBuilder.extensionPointID)) {
			try {
				ITechnicalDifferenceBuilder techBuilder = (ITechnicalDifferenceBuilder) configurationElement.createExecutableExtension("difference_builder");
				
				if (!availableTechBuilders.contains(techBuilder)) {
					availableTechBuilders.add(techBuilder);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		
		availableTechBuilders.sort(new Comparator<ITechnicalDifferenceBuilder>() {

			@Override
			public int compare(ITechnicalDifferenceBuilder t1, ITechnicalDifferenceBuilder t2) {
				return t1.getName().compareTo(t2.getName());
			}
		});
		
		return availableTechBuilders;
	}

}
