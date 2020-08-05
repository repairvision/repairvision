package org.sidiff.validation.ocl;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.sidiff.revision.common.emf.EMFHandlerUtil;
import org.sidiff.revision.common.ui.workbench.InfoConsole;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;

public class TracingOCLEvaluationHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<URI> resources = EMFHandlerUtil.getSelectedURI(event);
		URI oclURI = null;
		URI modelURI = null;
		
		if (resources.size() == 2) {
			for (URI uri : resources) {
				if (uri.fileExtension().equalsIgnoreCase("ocl") || uri.fileExtension().equalsIgnoreCase("oclas")) {
					oclURI = uri;
				} else {
					modelURI = uri;
				}
			}
		}
		
		if ((oclURI == null) || (modelURI == null)) {
			WorkbenchUtil.showError("Please select an OCL (*.ocl, *.oclas) and a model file!");
			return null;
		}
		
		try {
			EnvironmentFactoryInternalExtension oclEnvironmentFactory = TracingOCLExecutor.getEnviromentFactory(null, false);
			Resource modelResource = oclEnvironmentFactory.getResourceSet().getResource(modelURI, true);
			
			List<Constraint> oclInavariants = TracingOCLExecutor.getInvariants(oclEnvironmentFactory, oclURI);
			List<Constraint> selectedOCLInvariant = WorkbenchUtil.showSelections("Select Invariant:", oclInavariants, WorkbenchUtil.getEMFLabelProvider());
			
			List<EObject> contextElements = StreamSupport.stream(
					((Iterable<EObject>) () -> modelResource.getAllContents()).spliterator(), false)
					.filter(e -> TracingOCLExecutor.isMatchingContext(oclEnvironmentFactory, e, selectedOCLInvariant.get(0))).collect(Collectors.toList());
			List<EObject> selectedContextElements = WorkbenchUtil.showSelections("Select Context: ", contextElements, WorkbenchUtil.getEMFLabelProvider());
			
			for (EObject contextElement : selectedContextElements) {
				for (Constraint oclInvariant : selectedOCLInvariant) {
					if (TracingOCLExecutor.isMatchingContext(oclEnvironmentFactory, contextElement, oclInvariant) ) {
						InfoConsole.printInfo(InfoConsole.getHorizontalLine());
						TracingOCLExecutor oclExecutor = new TracingOCLExecutor(oclEnvironmentFactory, oclInvariant, contextElement);
						InfoConsole.printInfo("Evaluation Result: " + oclExecutor.execute());
						InfoConsole.printInfo(InfoConsole.getHorizontalLine());
					}
				}
			}
		} catch (ParserException | IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
