package org.sidiff.revision.repair.api.peo;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.history.revision.impl.Revision;
import org.sidiff.revision.api.IComplementationFacade;
import org.sidiff.revision.repair.api.peo.configuration.PEORepairSettings;

/**
 * API for the repair engine functions.
 * 
 * @author Manuel Ohrndorf
 */
public class PEORepairFacade implements IComplementationFacade<PEORepairJob, PEORepairSettings> {

	@Override
	public PEORepairJob getComplementations(URI uriModelA, URI uriModelB, PEORepairSettings settings) {
		
		// Initialize:
		ResourceSet differenceRSS = new ResourceSetImpl();
		Resource modelA = differenceRSS.getResource(uriModelA, true);
		Resource modelB = (uriModelB != null) ? differenceRSS.getResource(uriModelB, true) : null;
	
		return new PEORepairCalculationEngine(settings, modelA, modelB).getRepairs();
	}
	
	@Override
	public PEORepairJob getComplementations(Resource modelA, Resource modelB, PEORepairSettings settings) {
		
		if (modelA == null) {
			modelA = Revision.createEmptyModel(modelB);
		}
		
		return new PEORepairCalculationEngine(settings, modelA, modelB).getRepairs();
	}

}
