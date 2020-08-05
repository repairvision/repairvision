package org.sidiff.revision.editrules.generation.decompose;

import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.revision.common.emf.EMFHandlerUtil;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;

public class DecomposingEditRulesHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection(event);
		Bundle complexEditRulesBundle = null;
		Bundle basicEditRulesBundle = null;
		
		try {
			if (selection.size() == 2) {
				for (Object selected : selection.toList()) {
					if (selected instanceof IResource) {
						Bundle bundle = EMFHandlerUtil.loadResource((IResource) selected, Bundle.class, new ResourceSetImpl());
						
						if (bundle.eResource().getURI().lastSegment().matches(".*?\\.basic.*?\\.graphpattern")) {
							basicEditRulesBundle = bundle;
						} else {
							complexEditRulesBundle = bundle;
						}
					}
				}
			} 
			
			if ((complexEditRulesBundle == null) || (basicEditRulesBundle == null)) {
				throw new ExecutionException("Missing Bundle");
			} else {
				// Clean up existing sub graphs:
				if (WorkbenchUtil.askQuestion("Clear existing decompositions from bundle?")) {
					for (Pattern complexEditRulePattern : complexEditRulesBundle.getPatterns()) {
						complexEditRulePattern.getAllGraphPatterns().forEach(graph -> {
							graph.getSubgraphs().forEach(DecomposingEditRulesUtil::clearSubGraphElements);
							graph.getSubgraphs().clear();
						});
					}
				}
				
				// Calculate decomposition:
				new DecomposingEditRules().decompose(complexEditRulesBundle, basicEditRulesBundle);
				
				// Save decomposition in complex edit rule bundle:
				complexEditRulesBundle.eResource().save(Collections.emptyMap());
			}
			
			return null;
		} catch (Exception e) {
			WorkbenchUtil.showErrorWithException(
					"Select a bundle with complex and basic (*.basic.graphpattern) edit rules"
					+ " to decompose the complex into the basic rules.",
					this, e);
			throw new ExecutionException(e.getMessage(), e);
		}
	}
}
