package org.sidiff.validation.constraint.test;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.repair.validation.IConstraint;
import org.sidiff.repair.validation.util.BatchValidationIterator;
import org.sidiff.validation.constraint.library.ConstraintLibraryRegistry;
import org.sidiff.validation.constraint.library.util.ConstraintLibraryUtil;

public class TestApplication implements IApplication {
	
	@SuppressWarnings("unused")
	@Override
	public Object start(IApplicationContext applicationContext) throws Exception {
		
		// Load Model
		String base = "D:/Workspace/SiLiftEvaluation/org.sidiff.validation.constraint/src/org/sidiff/validation/constraint/test/";
		String consistent =  base + "M0005A.uml";
		String inconsistent = base + "M0005B.uml";
		
		String consistencyRule = "Inconsistency_MessageBasedOnOperation";
		
		ResourceSet rss = new ResourceSetImpl();
		URI modeURI = URI.createFileURI(inconsistent);
		Resource modelResource = rss.getResource(modeURI, true);;
		
		// Load consistency rule:
		IConstraint crule = ConstraintLibraryUtil.getConsistencyRule(
				ConstraintLibraryRegistry.getLibraries(EMFModelAccess.getDocumentType(modelResource)),
				consistencyRule);
		
		// Check consistency:
		new BatchValidationIterator(modelResource, Collections.singletonList(crule)).forEachRemaining(validation -> {
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
