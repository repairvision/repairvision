package org.sidiff.graphpattern.design.tools.diagram;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
import org.sidiff.revision.common.emf.ItemProviderUtil;
import org.sidiff.revision.common.emf.diagram.SiriusUtil;

/**
 * Creates Sirius diagrams for a given model element and its contained elements.
 * 
 * @author Manuel Ohrndorf
 */
@SuppressWarnings("restriction")
public class ModelDiagramCreator {
	
	private URI sessionResourceURI;
	
	private Session session;
	
	private Map<EObject, RepresentationDescription> representations;

	public ModelDiagramCreator(EObject modelElement, IProgressMonitor monitor) throws IOException {
		URI modelElementURI = EcoreUtil.getURI((EObject)modelElement);
		this.sessionResourceURI = modelElementURI.trimFragment().trimFileExtension().appendFileExtension("aird");
		
		createViewpoint(modelElementURI, sessionResourceURI, monitor);
		
		// Find representation:
		this.session = findSession(modelElementURI, monitor);
		EObject modelElementInSession = findModelElementInSession(session, modelElementURI);
		
		if (modelElementInSession == null) {
			throw new IOException("Something went wrong. Try to delete .aird diagram and retry!");
		}
		
		this.representations = findRepresentations(session, modelElementInSession);
	}
	
	public URI getDiagramFile() {
		return sessionResourceURI;
	}
	
	public URI createRepresentations(IProgressMonitor monitor) {
		for (Entry<EObject, RepresentationDescription> represenation : representations.entrySet()) {
			createRepresentation(represenation.getKey(), represenation.getValue(), monitor);
		}
		return getDiagramFile();
	}
	
	public Map<EObject, RepresentationDescription> getRepresentations() {
		return representations;
	}
	
	public String createRepresentation(EObject element, RepresentationDescription description, IProgressMonitor monitor) {
		String name = getUniqueDiagramName(element, session, description);

		SiriusUtil.edit(session.getTransactionalEditingDomain(), () -> {
			DialectManager.INSTANCE.createRepresentation(name, element, description, session, monitor); 
		});

		SessionManager.INSTANCE.notifyRepresentationCreated(session);
		return name;
	}
	
	public void openRepresentation(RepresentationDescription description, String name, IProgressMonitor monitor) {
		for (DRepresentation diagramRepresentation : DialectManager.INSTANCE.getRepresentations(description, session)) {
			if (diagramRepresentation.getName().equals(name)) {
				DialectUIManager dialectUIManager = DialectUIManager.INSTANCE;

				dialectUIManager.openEditor(session, diagramRepresentation, monitor);
			}
		}
	}
	
	private void createViewpoint(URI modelElementURI, URI sessionResourceURI, IProgressMonitor monitor) {
		
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
	
	private Session findSession(URI modelElementURI, IProgressMonitor monitor) {
		return SessionManager.INSTANCE.getSession(modelElementURI.trimFragment().trimFileExtension().appendFileExtension("aird"), monitor);
	}
	
	private EObject findModelElementInSession(Session session, URI modelElementURI) {
		return session.getSemanticResources().iterator().next().getEObject(modelElementURI.fragment());
	}
	
	private Map<EObject, RepresentationDescription> findRepresentations(Session session, EObject element) {
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
	
	protected String getUniqueDiagramName(EObject modelElement, Session session, RepresentationDescription description) {
		String name = getDiagramName(modelElement);
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
	
	protected String getDiagramName(EObject modelElement) {
		return ItemProviderUtil.getTextByObject(modelElement);
	}
}
