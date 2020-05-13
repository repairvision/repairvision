package org.sidiff.editrule.tools.recorder.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import org.sidiff.common.emf.access.Scope;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.common.utilities.emf.DocumentType;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.correspondences.matchingmodel.MatchingModelCorrespondences;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matcher.MatcherUtil;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.derivation.GenericTechnicalDifferenceBuilder;
import org.sidiff.revision.difference.derivation.ITechnicalDifferenceBuilder;
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
			
			List<IMatcher> matchers = askForMatcher(documentType);
			
			if (matchers.isEmpty()) {
				return null;
			}
			
			IMatcher matcher = matchers.get(0);
			Difference difference = createMatching(modelA, modelB, scope, matcher);
			
			for (IMatcher subsequentMatcher : matchers.subList(1, matchers.size())) {
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

	private List<IMatcher> askForMatcher(Set<String> documentType) {
		return WorkbenchUtil.showSelections(
				"Select Matching-Engine(s)", 
				MatcherUtil.getAvailableMatchers(documentType), 
				new ColumnLabelProvider() {
					
					@Override
					public String getText(Object element) {
						return ((IMatcher) element).getName();
					}
				});
	}

	private Difference createMatching(Resource modelA, Resource modelB, Scope scope, IMatcher matcher) {
		matcher.reset();
		
		if (matcher.getCandidatesService() != null) {
			matcher.getCandidatesService().reset();
		}
		
		if (matcher.getCorrespondencesService() != null) {
			matcher.getCorrespondencesService().reset();
		}

		Collection<Resource> models = Arrays.asList(new Resource[] { modelA, modelB });
		matcher.startMatching(models, scope);
		
		ICorrespondences correspondences = matcher.getCorrespondencesService();
		Difference matching = ((MatchingModelCorrespondences) correspondences).getDifference();
		
		return matching;
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
