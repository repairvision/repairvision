package org.sidiff.consistency.repair.validation.test;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.consistency.repair.validation.ConsistencyRule;
import org.sidiff.consistency.repair.validation.test.library.ConsistencyRuleLibrary;
import org.sidiff.consistency.repair.validation.util.BatchValidationIterator;

public class TestApplication implements IApplication {


	
	@SuppressWarnings("unused")
	@Override
	public Object start(IApplicationContext applicationContext) throws Exception {
		
		// Load Model
		String consistent = "D:/Workspace/SiLift/org.sidiff.consistency.repair.validation/src/org/sidiff/consistency/repair/validation/test/M0005A.uml";
		String inconsistent = "D:/Workspace/SiLift/org.sidiff.consistency.repair.validation/src/org/sidiff/consistency/repair/validation/test/M0005B.uml";
		
		String consistencyRule = "messageBasedOnOperation";
		
		ResourceSet rss = new ResourceSetImpl();
		URI modeURI = URI.createFileURI(consistent);
		Resource modelResource = rss.getResource(modeURI, true);;
		
		// Load consistency rule:
		ConsistencyRuleLibrary cruleLibrary = ConsistencyRuleLibrary.getConsistencyRuleLibrary(
				EMFModelAccess.getDocumentType(modelResource));
		ConsistencyRule crule = cruleLibrary.getConsistencyRule(consistencyRule);
		
		// Check consistency:
		List<ConsistencyRule> consistencyRules = new ArrayList<>();
		consistencyRules.add(crule);
		
		new BatchValidationIterator(modelResource, consistencyRules).forEachRemaining(validation -> {
				System.out.print("Validation [");
				System.out.print(validation.getResult());
				System.out.println("] " 
						+ validation.getRule().getName() + ": " 
						+ validation.getContext());
				
				if (validation.getRepair() != null) {
					System.out.println("\nRepair-Tree: \n\n" + validation.getRepair());
				}
		});
		
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
	}
}
