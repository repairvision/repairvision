package org.sidiff.revision.repair.api;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.history.revision.impl.Revision;
import org.sidiff.revision.api.ComplementationFacade;
import org.sidiff.revision.repair.api.configuration.RepairSettings;

/**
 * API for the repair engine functions.
 * 
 * @author Manuel Ohrndorf
 */
public class RepairFacade implements ComplementationFacade<RepairJob, RepairSettings> {

	@Override
	public RepairJob getComplementations(URI uriModelA, URI uriModelB, RepairSettings settings) {
		
		// Initialize:
		ResourceSet differenceRSS = new ResourceSetImpl();
		Resource modelA = differenceRSS.getResource(uriModelA, true);
		Resource modelB = (uriModelB != null) ? differenceRSS.getResource(uriModelB, true) : null;
	
		return new RepairCalculationEngine(settings, modelA, modelB).getRepairs();
	}
	
	@Override
	public RepairJob getComplementations(Resource modelA, Resource modelB, RepairSettings settings) {
		
		if (modelA == null) {
			modelA = Revision.createEmptyModel(modelB);
		}
		
		return new RepairCalculationEngine(settings, modelA, modelB).getRepairs();
	}

}
