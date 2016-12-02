package org.sidiff.repair.api;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Search for partially executed edit-operation which might cause an
 * inconsistency. A repair complements such a partial edit-operation.
 * 
 * @author Manuel Ohrndorf
 *
 * @param <J>
 *            The kind of {@link RepairJob} as container for all repairs.
 * @param <S>
 *            The kind of {@link IRepairSettings}.
 */
public interface IRepairFacade<J extends RepairJob<?>, S extends IRepairSettings> {
	
	/**
	 * Search for partially executed edit-operation which might cause an
	 * inconsistency. A repair complements such a partial edit-operation.
	 * 
	 * @param uriModelA
	 *            The historic model.
	 * @param uriModelB
	 *            The actual model.
	 * @param settings
	 *            The settings for the repair calculation.
	 * @return All found repairs.
	 */
	J getRepairs(URI uriModelA, URI uriModelB, S settings);
	
	/**
	 * Search for partially executed edit-operation which might cause an
	 * inconsistency. A repair complements such a partial edit-operation.
	 * 
	 * @param modelA
	 *            The historic model.
	 * @param modelB
	 *            The actual model.
	 * @param settings
	 *            The settings for the repair calculation.
	 * @return All found repairs.
	 */
	J getRepairs(Resource modelA, Resource modelB, S settings);
}
