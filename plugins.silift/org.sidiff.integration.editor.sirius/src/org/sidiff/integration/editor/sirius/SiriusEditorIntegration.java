package org.sidiff.integration.editor.sirius;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.sidiff.common.utilities.emf.EMFStorage;
import org.sidiff.integration.editor.extension.AbstractEditorIntegration;

public class SiriusEditorIntegration extends AbstractEditorIntegration {

	public SiriusEditorIntegration() {
		// The fake editor is sufficient for this purpose
		super(null, "org.eclipse.sirius.ui.fakeeditoronlyforicon");
	}

	// Sirius generally supports any EMF-based models, therefore no
	// model file extension is defined.
	private static final String DIAGRAM_FILE_EXT = "aird";
	private static final String MODEL_FILE_EXT = "ecore";

	@Override
	public boolean supportsModel(Resource model) {
		return getDiagramForModel(model.getURI()) != null;
	}

	@Override
	public boolean supportsDiagramming(Resource model) {
		return getDiagramForModel(model.getURI()) != null;
	}

	@Override
	public boolean supportsModel(URI modelFile) {
		return getDiagramForModel(modelFile) != null;
	}

	@Override
	public boolean supportsDiagram(URI diagramFile) {
		return diagramFile.fileExtension().toLowerCase().endsWith(DIAGRAM_FILE_EXT);
	}

	@Override
	public URI copyDiagram(URI modelFile, String savePath)
			throws FileNotFoundException {
		final String separator = System.getProperty("file.separator");
		try {
			final URI mainDiagramUri = getDiagramForModel(modelFile);
			if (mainDiagramUri == null)
				throw new RuntimeException("Model not supported");
			ResourceSet set = new ResourceSetImpl();
			final File testFile = new File(EMFStorage.uriToPath(mainDiagramUri));
			if (!testFile.exists() || !testFile.isFile())
				throw new FileNotFoundException("A diagram file was not found");
			Resource resource = EMFStorage.eLoad(mainDiagramUri).eResource();
			set.getResources().add(resource);
			final URI diagramSaveFile = EMFStorage.pathToUri(savePath
					+ separator + resource.getURI().lastSegment());
			EMFStorage.eSaveAs(diagramSaveFile, resource.getContents().get(0),
					false);
			return EMFStorage.pathToUri(savePath + separator
					+ mainDiagramUri.lastSegment());
		} catch (Exception e) {
			if (e instanceof FileNotFoundException)
				throw (FileNotFoundException) e;
			// TODO Exception-handling?
			throw new RuntimeException("Error copying diagram", e);
		}
	}

	@Override
	public IEditorPart openModelInDefaultEditor(URI modelURI) {
		try {
			// FIXME Could be problematic with files in archives
			String path = EMFStorage.uriToPath(modelURI);
			IEditorDescriptor desc = PlatformUI.getWorkbench()
					.getEditorRegistry().getDefaultEditor(path);
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			return page.openEditor(new URIEditorInput(modelURI), desc.getId());
		} catch (PartInitException ex) {
			return null;
		}
	}

	private URI getDiagramForModel(URI modelFile) {
		URI diagramURI = modelFile.trimFileExtension().appendFileExtension(DIAGRAM_FILE_EXT);
		if (modelFile.isArchive()) {
			String authority = diagramURI.authority().replaceAll("\\\\", "/");
			if (authority.endsWith("!")) authority = authority.substring(0, authority.length() - 1);
			File authorityFile = new File(java.net.URI.create(authority));
			if (!authorityFile.isFile())
				return null;
			String fileString = diagramURI.toString().substring(diagramURI.toString().indexOf(diagramURI.authority())+ diagramURI.authority().length()).replaceAll("\\\\", "/");
			if (fileString.startsWith("/")) fileString=fileString.substring(1);
			for (String s : getEntries(authorityFile.getAbsolutePath())) {
				if (s != null && s.equals(fileString)) return diagramURI;
			}
			return null;
		} else if (EMFStorage.uriToFile(diagramURI).exists()) {
			return diagramURI;
		}
		return null;
	}
	
	private List<String> getEntries(String zipFile) {
		List<String> entries = new ArrayList<String>();
		ZipFile file = null;
		
		try {
			file = new ZipFile(zipFile);
			Enumeration<?> enu = file.entries();

			while (enu.hasMoreElements()) {
				ZipEntry zipEntry = (ZipEntry) enu.nextElement();
				String zipEntryName = zipEntry.getName();
				entries.add(zipEntryName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return entries;
	}

	@Override
	public IEditorPart openDiagramForModel(URI modelFile) {
		URI diagramUri = getDiagramForModel(modelFile);
		if (diagramUri != null)
			return openDiagram(diagramUri);
		return null;
	}

	@Override
	public boolean supportsGMFAnimation(URI diagramFile) {
		return true;
	}

	@Override
	public IEditorPart openDiagram(URI diagramFile) {
		if (diagramFile == null || !isDiagramEditorPresent())
			return null;

		// Start Sirius Session
		Session session = SessionManager.INSTANCE.getSession(diagramFile, new NullProgressMonitor());
		if (session == null)
			return null;
		if (!session.isOpen())
			session.open(new NullProgressMonitor());
		for (Session otherSession : SessionManager.INSTANCE.getSessions()) {
			otherSession.getOwnedViews();
		}

		// Get representation
		Collection<DView> views = session.getOwnedViews();
		EList<DRepresentation> representations = new BasicEList<DRepresentation>();
		for (DView view : views) {
			for(DRepresentationDescriptor descriptor : view.getOwnedRepresentationDescriptors()){
				representations.add(descriptor.getRepresentation());
			}
		}

		// FIXME: Generic way of choosing the right representation
		if (representations.isEmpty())
			return null;
		return DialectUIManager.INSTANCE.openEditor(session,
				representations.get(0), new NullProgressMonitor());
	}

	@Override
	public Collection<EObject> getHighlightableElements(EObject element) {
		ArrayList<EObject> res = new ArrayList<EObject>();
		if (element instanceof DRepresentationElement) {
			res.add(((DRepresentationElement) element).getTarget());
		} 
		return res;
	}

	@Override
	public Resource getResource(IEditorPart editorPart) {
		if (editorPart instanceof DDiagramEditor) {
			DDiagramEditor editor = (DDiagramEditor) editorPart;
			Iterator<Resource> iter = editor.getSession()
					.getSemanticResources().iterator();
			if (iter.hasNext()) {
				// FIXME: Determine the right resource if there are multiple
				return iter.next();
			}
			return null;
		}
		throw new UnsupportedOperationException("editorPart must be a DDiagramEditor");
	}

	@Override
	public Map<String, String> getFileExtensions() {
		Map<String, String> extensions = new HashMap<String, String>();
		extensions.put("diagram", DIAGRAM_FILE_EXT);
		extensions.put("model", MODEL_FILE_EXT);
		return extensions;
	}
}
