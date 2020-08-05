package org.sidiff.historymodel.presentation.handlers;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.Version;
import org.sidiff.historymodel.presentation.util.HistoryModelEditorTools;
import org.sidiff.revision.common.emf.EMFStorage;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.common.utilities.java.JUtil;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.project.registry.ConstraintLibraryRegistry;
import org.sidiff.validation.constraint.project.registry.util.ConstraintLibraryUtil;

public class ShowEditStepsWithFilterHandler extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (!selection.isEmpty() && (selection instanceof IStructuredSelection)) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();
			
			
			if (selected instanceof Problem) {
				Problem inconsistency = (Problem) selected;
				
				if (inconsistency.isIntroduced()) {
					Version beforeIntroduced = inconsistency.getIntroducedIn().getPredecessor();
					Version introduced = inconsistency.getIntroducedIn();
					
					Resource beforeIntroducedResource = new ResourceSetImpl().getResource(getModelURI(beforeIntroduced), true);
					EcoreUtil.resolveAll(beforeIntroducedResource);
					Resource introducedResource = new ResourceSetImpl().getResource(getModelURI(introduced), true);
					EcoreUtil.resolveAll(introducedResource);
					
					String uriFragmentContext = EMFStorage.getXmiId(inconsistency.getContextElement()); // UUID
					
					Set<EObject> scopes = new HashSet<>();
					scopes.addAll(getScope(beforeIntroducedResource, uriFragmentContext, inconsistency.getName()));
					scopes.addAll(getScope(introducedResource, uriFragmentContext, inconsistency.getName()));
					
					Set<String> uriFragmentScope = scopes.stream().map(o -> EMFStorage.getXmiId(o)).collect(Collectors.toSet());
					
					HistoryModelEditorTools.compare(
							beforeIntroducedResource.getResourceSet(),
							introducedResource.getResourceSet(),
							uriFragmentScope);
				} else {
					WorkbenchUtil.showMessage("No introducing edit step found!");
				}
				
				if (inconsistency.isResolved()) {
					Version beforeResolved = inconsistency.getResolvedIn().getPredecessor();
					Version resolved = inconsistency.getResolvedIn();
					
					Resource beforeResolvedResource = new ResourceSetImpl().getResource(getModelURI(beforeResolved), true);
					EcoreUtil.resolveAll(beforeResolvedResource);
					Resource resolvedResource = new ResourceSetImpl().getResource(getModelURI(resolved), true);
					EcoreUtil.resolveAll(resolvedResource);
					
					String uriFragmentContext = EMFStorage.getXmiId(inconsistency.getContextElement()); // UUID
					
					Set<EObject> scopes = new HashSet<>();
					scopes.addAll(getScope(beforeResolvedResource, uriFragmentContext, inconsistency.getName()));
					scopes.addAll(getScope(resolvedResource, uriFragmentContext, inconsistency.getName()));
					
					Set<String> uriFragmentScope = scopes.stream().map(o -> EMFStorage.getXmiId(o)).collect(Collectors.toSet());
					
					HistoryModelEditorTools.compare(
							beforeResolvedResource.getResourceSet(),
							resolvedResource.getResourceSet(),
							uriFragmentScope);
				} else {
					WorkbenchUtil.showMessage("No resolving edit step found!");
				}
			}
		}
		
		return null;
	}
	
	public Set<EObject> getScope(Resource model, String uriFragmentContext, String constraint) {
		EObject context = model.getEObject(uriFragmentContext);
		
		if (context != null) {
			IConstraint constraintRule = ConstraintLibraryUtil.getConsistencyRule(ConstraintLibraryRegistry.getLibraries(DocumentType.getDocumentType(model)), constraint);
			List<Validation> validations = ValidationFacade.validate(
					JUtil.singeltonIterator(context),
					Collections.singletonList(constraintRule),
					true, true);
			
			Set<EObject> scopes = new HashSet<>();
			ValidationFacade.analyzeScope(validations).forEach(scope -> scopes.addAll(scope.getScope().getScope()));
			
			return scopes;
		} else {
			return Collections.emptySet();
		}
	}
	
	private URI getModelURI(Version version) {
		return version.eResource().getURI().trimSegments(1).appendSegments(version.getModelURI().split("/"));
	}
}
