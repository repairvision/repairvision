package org.sidiff.revision.difference.api.registry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.difference.builder.GenericDifferenceBuilderProvider;
import org.sidiff.revision.difference.builder.IDifferenceBuilderProvider;
import org.sidiff.revision.difference.builder.util.DifferenceBuilderUtil;

public class DifferenceBuilderRegistry {

	private final static IDifferenceBuilderProvider GENERIC_TECHNICAL_DIFFERENCE_BUILDER = new GenericDifferenceBuilderProvider();

	/**
	 * Returns the available technical difference builders for the given documentTypes.
	 * If no convenient builder is found, a generic technical difference builder will be returned.
	 * 
	 * @param documentTypes
	 * @return
	 */
	public static List<IDifferenceBuilderProvider> getAvailableTechnicalDifferenceBuilders(Set<String> documentTypes){
		List<IDifferenceBuilderProvider> tdbSet = new ArrayList<IDifferenceBuilderProvider>();

		for(IDifferenceBuilderProvider techBuilder : getAllAvailableTechnicalDifferenceBuilders()){
			if (DifferenceBuilderUtil.canHandleDocTypes(techBuilder, documentTypes)) {
				tdbSet.add(techBuilder);
			}
		}

		return tdbSet;
	}

	/**
	 * Returns the available technical difference builders for the documentTypes of the given models.
	 * If no convenient builder is found, a generic technical difference builder will be returned.
	 * 
	 * @param documentTypes
	 * @return
	 */
	public static List<IDifferenceBuilderProvider> getAvailableTechnicalDifferenceBuilders(Resource modelA, Resource modelB){
		List<IDifferenceBuilderProvider> tdbSet = new ArrayList<IDifferenceBuilderProvider>();

		for(IDifferenceBuilderProvider techBuilder : getAllAvailableTechnicalDifferenceBuilders()){
			if (DifferenceBuilderUtil.canHandleModels(techBuilder, modelA, modelB)) {
				tdbSet.add(techBuilder);
			}
		}

		return tdbSet;
	}

	/**
	 * Returns a generic technical difference builder.
	 * 
	 * @return
	 */
	public static IDifferenceBuilderProvider getGenericTechnicalDifferenceBuilder(){
		return GENERIC_TECHNICAL_DIFFERENCE_BUILDER;
	}

	/**
	 * Returns the technical difference builder with the given key.
	 * 
	 * @param name
	 * @return
	 */
	public static IDifferenceBuilderProvider getTechnicalDifferenceBuilder(String key){
		IDifferenceBuilderProvider tbExtension = null;
		for(IDifferenceBuilderProvider techBuilder : getAllAvailableTechnicalDifferenceBuilders()){
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
	public static List<IDifferenceBuilderProvider> getAllAvailableTechnicalDifferenceBuilders(){
		List<IDifferenceBuilderProvider> availableTechBuilders = new ArrayList<IDifferenceBuilderProvider>();

		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(IDifferenceBuilderProvider.EXTENSION_POINT_ID)) {
			try {
				IDifferenceBuilderProvider techBuilder = (IDifferenceBuilderProvider) configurationElement.createExecutableExtension(IDifferenceBuilderProvider.EXTENSION_POINT_ATTRIBUTE);

				if (!availableTechBuilders.contains(techBuilder)) {
					availableTechBuilders.add(techBuilder);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		availableTechBuilders.sort(new Comparator<IDifferenceBuilderProvider>() {

			@Override
			public int compare(IDifferenceBuilderProvider t1, IDifferenceBuilderProvider t2) {
				return t1.getName().compareTo(t2.getName());
			}
		});

		return availableTechBuilders;
	}

}
