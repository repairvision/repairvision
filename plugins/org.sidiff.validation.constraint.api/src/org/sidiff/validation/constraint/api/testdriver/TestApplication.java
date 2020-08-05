package org.sidiff.validation.constraint.api.testdriver;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.validation.constraint.api.util.ValidationIterator;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.project.registry.ConstraintLibraryRegistry;
import org.sidiff.validation.constraint.project.registry.util.ConstraintLibraryUtil;

public class TestApplication implements IApplication {
	
	@Override
	public Object start(IApplicationContext applicationContext) throws Exception {
		
		// Load Model
		String base = "D:/Workspace/SiLiftEvaluation/org.sidiff.validation.constraint/src/org/sidiff/validation/constraint/testdriver/";
//		String modelFile = base + "B.InconsistentModelVersion.uml";
		String modelFile = base + "M0005B.uml";
		
		String consistencyRule = "Inconsistency_UntypedProperty";
		
		ResourceSet rss = new ResourceSetImpl();
		URI modeURI = URI.createFileURI(modelFile);
		Resource modelResource = rss.getResource(modeURI, true);;
		
		// Load consistency rule:
		IConstraint crule = ConstraintLibraryUtil.getConsistencyRule(
				ConstraintLibraryRegistry.getLibraries(DocumentType.getDocumentType(modelResource)),
				consistencyRule);
		
		// Check consistency:
		if (crule != null) {
			new ValidationIterator(modelResource.getAllContents(), Collections.singletonList(crule), true, true).forEachRemaining(validation -> {
				System.out.print("Validation [");
				System.out.print(validation.getResult());
				System.out.println("] " 
						+ validation.getRule().getName() + ": " 
						+ validation.getContext());
				System.out.println("---------------------------------------------------------------------------------");
			});
		} else {
			System.err.println("Consistency-Rule not found: " + consistencyRule);
		}
		
		System.out.println("Validation finished!");
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
	}
}
