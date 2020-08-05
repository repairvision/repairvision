package org.sidiff.revision.editrules.generation.complex2basic;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.revision.common.emf.EMFHandlerUtil;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.editrules.generation.generator.util.GraphPatternGeneratorUtil;

public class ComplexToBasicGraphPatternsHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection(event);
		Bundle complexPatternsBundle = null;
		Bundle basicPatternsBundle = null;
		
		try {
			if (selection.size() == 1) {
				complexPatternsBundle = EMFHandlerUtil.getSelection(event, Bundle.class);

				basicPatternsBundle = GraphpatternFactory.eINSTANCE.createBundle();
				basicPatternsBundle.setName(complexPatternsBundle.getName());
				basicPatternsBundle.getDomains().addAll(complexPatternsBundle.getDomains());
			} else if (selection.size() == 2) {
				for (Object selected : selection.toList()) {
					if (selected instanceof IResource) {
						Bundle bundle = EMFHandlerUtil.loadResource((IResource) selected, Bundle.class, new ResourceSetImpl());
						
						if (bundle.eResource().getURI().lastSegment().matches(".*?\\.basic.*?\\.graphpattern")) {
							basicPatternsBundle = bundle;
							
							if (WorkbenchUtil.askQuestion("Clear basic pattern bundle?")) {
								basicPatternsBundle.getPatterns().clear();
							}
						} else {
							complexPatternsBundle = bundle;
						}
					}
				}
			} 
			
			if ((complexPatternsBundle == null) || (basicPatternsBundle == null)) {
				throw new ExecutionException("Missing Bundle");
			}
		} catch (Exception e) {
			WorkbenchUtil.showErrorWithException(
					"Select a bundle with complex pattern to generate a new basic pattern bundle."
					+ " Select a basic (*.basic.graphpattern) and complex pattern bundle to update the basic bundle.",
					this, e);
			throw new ExecutionException(e.getMessage(), e);
		}
		
		for (Pattern pattern : complexPatternsBundle.getPatterns()) {
			new ComplexToBasicGraphPatterns().findNewBasicPatterns(complexPatternsBundle, basicPatternsBundle, pattern);
		}
		
		URI complexPatternsBundleURI = complexPatternsBundle.eResource().getURI();
		String basicPatternsBundleFileName = complexPatternsBundleURI.trimFileExtension().lastSegment() + ".basic." + complexPatternsBundleURI.fileExtension();
		URI basicPatternsBundleURI = complexPatternsBundleURI.trimSegments(1).appendSegment(basicPatternsBundleFileName);
		
		GraphPatternGeneratorUtil.saveBundle(basicPatternsBundleURI, basicPatternsBundle);
		return null;
	}
}
