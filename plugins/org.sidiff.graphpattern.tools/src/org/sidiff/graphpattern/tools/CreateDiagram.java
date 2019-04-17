package org.sidiff.graphpattern.tools;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.helper.SiriusResourceHelper;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelection;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallbackWithConfimation;
import org.eclipse.sirius.ui.business.internal.commands.ChangeViewpointSelectionCommand;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.consistency.common.emf.SiriusUtil;
import org.sidiff.graphpattern.edit.util.ItemProviderUtil;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;

@SuppressWarnings("restriction")
public class CreateDiagram extends AbstractHandler  {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Object selected = getSelection(event);
		
		if (selected instanceof IFile) {
			Resource resource = EMFHandlerUtil.getSelection(event);
			
			if (!resource.getContents().isEmpty()) {
				selected = resource.getContents().get(0);
			}
		}
		
		if (selected instanceof EObject) {
			IProgressMonitor monitor = new NullProgressMonitor();
			
			// new diagram:
			URI modelElementURI = EcoreUtil.getURI((EObject)selected);
			URI sessionResourceURI = modelElementURI.trimFragment().trimFileExtension().appendFileExtension("aird");
			
			createViewpoint(modelElementURI, sessionResourceURI, monitor);
			createRepresentation((EObject) selected, monitor, modelElementURI, 
					WorkbenchUtil.showQuestion("Open diagram editors?"));
		}
		
		return null;
	}
	
	protected Object getSelection(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);

		if (!selection.isEmpty() && (selection instanceof IStructuredSelection)) {
			return ((IStructuredSelection) selection).getFirstElement();
		}
		
		return null;
	}

	protected void createViewpoint(URI modelElementURI, URI sessionResourceURI, IProgressMonitor monitor) {
		
		// create viewpoint:
		Session session = SessionManager.INSTANCE.getSession(sessionResourceURI, monitor);

		// adding the resource also to Sirius session:
		AddSemanticResourceCommand addCommandToSession = new AddSemanticResourceCommand(session, modelElementURI.trimFragment(), monitor);
		session.getTransactionalEditingDomain().getCommandStack().execute(addCommandToSession);

		// find and add viewpoint:
		Set<Viewpoint> availableViewpoints = ViewpointSelection.getViewpoints(modelElementURI.fileExtension());
		Set<Viewpoint> viewpoints = new HashSet<Viewpoint>();
		
		for(Viewpoint viewpoint : availableViewpoints) {
			viewpoints.add(SiriusResourceHelper.getCorrespondingViewpoint(session, viewpoint));
		}

		RecordingCommand command = new ChangeViewpointSelectionCommand(
				session, new ViewpointSelectionCallbackWithConfimation(), 
				viewpoints, new HashSet<Viewpoint>(), true, monitor);
		TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
		domain.getCommandStack().execute(command);
		
		// open the session and add it to the session manager:
		session.open(monitor);
	}

	protected void createRepresentation(EObject element, IProgressMonitor monitor, URI modelElementURI, boolean openEditor) {
		Session session = SessionManager.INSTANCE.getSession(modelElementURI.trimFragment().trimFileExtension().appendFileExtension("aird"), monitor);
		EObject modelElement = session.getSemanticResources().iterator().next().getEObject(modelElementURI.fragment());
		
		if (modelElement == null) {
			WorkbenchUtil.showError("Something went wrong. Try to delete .aird diagram and retry!");
			return;
		}
		
		Map<EObject, RepresentationDescription> representations = getRepresentations(session, modelElement);

		for (Entry<EObject, RepresentationDescription> representation : representations.entrySet()) {
			RepresentationDescription description = representation.getValue();
			EObject nextModelElement = representation.getKey();
			String name = getDiagramName(nextModelElement, session, description);
			
			SiriusUtil.edit(session.getTransactionalEditingDomain(), () -> {
				DialectManager.INSTANCE.createRepresentation(name, nextModelElement, description, session, monitor); 
			});
			
			SessionManager.INSTANCE.notifyRepresentationCreated(session);
			
			// open editor:
			if (openEditor) {
				for (DRepresentation diagramRepresentation : DialectManager.INSTANCE.getRepresentations(description, session)) {
					if (diagramRepresentation.getName().equals(name)) {
						DialectUIManager dialectUIManager = DialectUIManager.INSTANCE;

						dialectUIManager.openEditor(session, diagramRepresentation, monitor);
					}
				}
			}
		}
	}
	
	protected Map<EObject, RepresentationDescription> getRepresentations(Session session, EObject element) {
		Map<EObject, RepresentationDescription> representations = new LinkedHashMap<>();
		
		Collection<RepresentationDescription> descriptions = DialectManager.INSTANCE.getAvailableRepresentationDescriptions(session.getSelectedViewpoints(false), element);
		
		if (!descriptions.isEmpty()) {
			
			// representation for the element:
			RepresentationDescription description = descriptions.iterator().next();
			representations.put(element, description);
		} else {
			
			// representation for all children:
			element.eAllContents().forEachRemaining(child ->  {
				Collection<RepresentationDescription> childDescriptions = DialectManager.INSTANCE.getAvailableRepresentationDescriptions(session.getSelectedViewpoints(false), child);
				
				if (!childDescriptions.isEmpty()) {
					RepresentationDescription childDescription = childDescriptions.iterator().next();
					representations.put(child, childDescription);
				}
			});
			
			// representation for container:
			if (representations.isEmpty()) {
				EObject container = element.eContainer();
				
				while (container != null) {
					Collection<RepresentationDescription> containerDescriptions = DialectManager.INSTANCE.getAvailableRepresentationDescriptions(session.getSelectedViewpoints(false), container);
					
					if (!containerDescriptions.isEmpty()) {
						RepresentationDescription containerDescription = containerDescriptions.iterator().next();
						representations.put(container, containerDescription);
						break;
					}
					
					container = element.eContainer();
				}
			}
		}
		
		return representations;
	}

	protected String getDiagramName(EObject modelElement, Session session, RepresentationDescription description) {
		String name = ItemProviderUtil.getTextByObject(modelElement);
		int count = 0;
		
		for (DRepresentation diagramRepresentation : DialectManager.INSTANCE.getRepresentations(description, session)) {
			if (diagramRepresentation.getName().equals(name) || ((count > 0) && diagramRepresentation.getName().equals(name + " (" + count + ")"))) {
				++count;
			}
		}
		
		if (count > 0) {
			name = name + " (" + count + ")";
		}
		
		return name;
	}
}
