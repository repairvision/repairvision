package org.sidiff.repair.api.peo;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.repair.api.IRepairFacade;

/**
 * API for the repair engine functions.
 * 
 * @author Manuel Ohrndorf
 */
public class PEORepairFacade implements IRepairFacade<PEORepairJob, PEORepairSettings> {

	@Override
	public PEORepairJob getRepairs(URI uriModelA, URI uriModelB, PEORepairSettings settings) {
		
		// Initialize:
		ResourceSet differenceRSS = new ResourceSetImpl();
		Resource modelA = differenceRSS.getResource(uriModelA, true);
		Resource modelB = differenceRSS.getResource(uriModelB, true);
	
		return new PEORepairCalculationEngine(settings, modelA, modelB).getRepairs();
	}
	
	@Override
	public PEORepairJob getRepairs(Resource modelA, Resource modelB, PEORepairSettings settings) {
		return new PEORepairCalculationEngine(settings, modelA, modelB).getRepairs();
	}
}
