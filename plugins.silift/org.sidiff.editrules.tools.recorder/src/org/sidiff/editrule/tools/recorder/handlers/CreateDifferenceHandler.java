package org.sidiff.editrule.tools.recorder.handlers;

import java.io.IOException;
import java.util.ArrayList;
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
import org.sidiff.common.utilities.emf.DocumentType;
import org.sidiff.common.utilities.emf.EMFHandlerUtil;
import org.sidiff.common.utilities.emf.Scope;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.DifferenceFactory;
import org.sidiff.revision.difference.api.registry.MatcherRegistry;
import org.sidiff.revision.difference.derivation.GenericTechnicalDifferenceBuilder;
import org.sidiff.revision.difference.derivation.ITechnicalDifferenceBuilder;
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
			
			IMatcherProvider matcherProvider = matcherProviders.get(0);
			Difference difference = createMatching(modelA, modelB, scope, matcherProvider);
			
			for (IMatcherProvider subsequentMatcher : matcherProviders.subList(1, matcherProviders.size())) {
				Difference subsequentMatching = createMatching(modelA, modelB, scope, subsequentMatcher);
				iterativeMatching(difference, subsequentMatching);
			}

			ITechnicalDifferenceBuilder tdBuilder = new GenericTechnicalDifferenceBuilder();
			tdBuilder.deriveTechDiff(difference, scope);

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

	private Difference createMatching(Resource modelA, Resource modelB, Scope scope, IMatcherProvider matcherProvider) {
		Difference difference = DifferenceFactory.eINSTANCE.createDifference();
		matcherProvider.createMatcher().startMatching(difference, modelA, modelB, scope);
		return difference;
	}
	
	private void iterativeMatching(Difference base, Difference subsequent) {
		List<Correspondence> newCorrespondences = new ArrayList<>();
		
		for (Correspondence subsequentCorrespondence : subsequent.getCorrespondences()) {
			if (!containsCorrespondence(base, subsequentCorrespondence)) {
				newCorrespondences.add(subsequentCorrespondence);
			}
		}
		
		for (Correspondence correspondence : newCorrespondences) {
			base.getCorrespondences().add(correspondence);
			base.getUnmatchedA().remove(correspondence.getMatchedA());
			base.getUnmatchedB().remove(correspondence.getMatchedB());
		}
	}
	
	private boolean containsCorrespondence(Difference matching, Correspondence correspondence) {
		for (Correspondence otherCorrespondence : matching.getCorrespondences()) {
			if ((otherCorrespondence.getMatchedA() == correspondence.getMatchedA())
					|| (otherCorrespondence.getMatchedB() == correspondence.getMatchedB())) {
				return true;
			}
		}
		return false;
	}
	
	protected static URI getDifferenceURI(URI modelA, URI modelB) {
		return URI.createURI(
				modelA.trimFileExtension().toString() + "_to_" +
				modelB.trimFileExtension().appendFileExtension(DifferenceUtil.FILE_EXTENSION).lastSegment());
	}

}
