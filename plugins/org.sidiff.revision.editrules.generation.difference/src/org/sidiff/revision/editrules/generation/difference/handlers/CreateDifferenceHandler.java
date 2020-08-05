package org.sidiff.revision.editrules.generation.difference.handlers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.sidiff.revision.common.emf.EMFHandlerUtil;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.common.emf.document.Scope;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.api.DifferenceFacade;
import org.sidiff.revision.difference.api.registry.MatcherRegistry;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.difference.api.util.IncrementalMatchingUtil;
import org.sidiff.revision.difference.builder.GenericDifferenceBuilderProvider;
import org.sidiff.revision.difference.matcher.IMatcherProvider;
import org.sidiff.revision.difference.util.DifferenceUtil;

public class CreateDifferenceHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource modelA = EMFHandlerUtil.getSelection(event, resourceSet, 0);
		Resource modelB = EMFHandlerUtil.getSelection(event, resourceSet, 1);
		
		if ((modelA != null) && (modelB != null)) {
			Scope scope = Scope.RESOURCE;
			Set<String> documentType = Collections.singleton(DocumentType.getDocumentType(modelB));
			
			List<IMatcherProvider> matcherProviders = askForMatcher(documentType);
			
			if (matcherProviders.isEmpty()) {
				return null;
			}
			
			Difference difference = IncrementalMatchingUtil.match(modelA, modelB, scope, matcherProviders);
			DifferenceFacade.deriveDifference(difference, new DifferenceSettings(scope, matcherProviders.get(0), new GenericDifferenceBuilderProvider()));

			// Create difference resource:
			ResourceSet differenceRSS = new ResourceSetImpl();
			Resource differenceResource = differenceRSS
					.createResource(getDifferenceURI(modelA.getURI(), modelB.getURI()));
			differenceResource.getContents().add(difference);
			
			try {
				differenceResource.save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			WorkbenchUtil.showError("Please select two models.");
		}
		
		return null;
	}

	private List<IMatcherProvider> askForMatcher(Set<String> documentType) {
		return WorkbenchUtil.showSelections(
				"Select Matching-Engine(s)", 
				MatcherRegistry.getAvailableMatchers(documentType), 
				new ColumnLabelProvider() {
					
					@Override
					public String getText(Object element) {
						return ((IMatcherProvider) element).getName();
					}
				});
	}
	
	protected static URI getDifferenceURI(URI modelA, URI modelB) {
		return URI.createURI(
				modelA.trimFileExtension().toString() + "_to_" +
				modelB.trimFileExtension().appendFileExtension(DifferenceUtil.FILE_EXTENSION).lastSegment());
	}

}
