package org.sidiff.integration.editor.extension;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.sidiff.common.utilities.emf.DocumentType;
import org.sidiff.common.utilities.emf.EMFStorage;

public class BasicEditorIntegration extends AbstractEditorIntegration {

	protected String docType, modelFileExt, diagramFileExt;

	public BasicEditorIntegration(String defaultEditorId, String diagramEditorId,
			String docType, String modelFileExt, String diagramFileExt) {
		super(defaultEditorId, diagramEditorId);
		this.docType = docType;
		this.modelFileExt = modelFileExt;
		this.diagramFileExt = diagramFileExt;
	}

	protected URI getMainDiagramFile(URI modelFile) {
		URI[] files = getDiagramFiles(modelFile);
		return files.length > 0 ? files[0] : null;
	}

	protected URI[] getDiagramFiles(URI modelFile) {
		String ext = modelFile.fileExtension();
		if (modelFileExt != null && diagramFileExt != null && modelFileExt.equals(ext)) {
			URI diagramUri = modelFile.trimFileExtension().appendFileExtension(diagramFileExt);
			return new URI[] { diagramUri };
		}
		return new URI[0];
	}

	@Override
	public boolean supportsModel(URI modelFile) {
		return modelFileExt != null && modelFile.fileExtension().toLowerCase().endsWith(modelFileExt);
	}

	@Override
	public boolean supportsDiagram(URI diagramFile) {
		return diagramFile != null && diagramFileExt != null
				&& diagramFile.fileExtension().toLowerCase().endsWith(diagramFileExt);
	}

	@Override
	public IEditorPart openModelInDefaultEditor(URI modelURI) {
		if (modelURI == null || !isDefaultEditorPresent()) {
			return null;
		}
		try {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IPath location = Path.fromOSString(EMFStorage.uriToFile(modelURI).getAbsolutePath());
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(location);
			IEditorInput input;
			if ((file != null) && file.exists()) {
				input = new FileEditorInput(file);
			} else {
				input = new URIEditorInput(modelURI);
			}
			return page.openEditor(input, defaultEditorId);
		} catch (PartInitException ex) {
			return null;
		}
	}

	@Override
	public IEditorPart openDiagram(URI diagramURI) {
		if (diagramURI == null || !isDiagramEditorPresent()) {
			return null;
		}
		try {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IPath location = Path.fromOSString(EMFStorage.uriToFile(diagramURI).getAbsolutePath());
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(location);
			IEditorInput input;
			if ((file != null) && file.exists()) {
				input = new FileEditorInput(file);
			} else {
				input = new URIEditorInput(diagramURI);
			}
			return page.openEditor(input, diagramEditorId);
		} catch (PartInitException ex) {
			return null;
		}
	}

	@Override
	public IEditorPart openDiagramForModel(URI modelFile) {
		return openDiagram(getMainDiagramFile(modelFile));
	}

	@Override
	public boolean supportsGMFAnimation(URI diagramFile) {
		return false;
	}

	@Override
	public boolean supportsDiagramming(Resource model) {
		if(docType == null || !docType.equals(DocumentType.getDocumentType(model)))
			return false;
		URI diagram = getMainDiagramFile(model.getURI());
		return diagram != null && EMFStorage.uriToFile(diagram).exists();
	}

	@Override
	public boolean supportsModel(Resource model) {
		return docType != null && docType.equals(DocumentType.getDocumentType(model))
				&& model.getURI().fileExtension().equals(this.modelFileExt);
	}

	/**
	 * Determines if a file can be copied using a standard file copy instead of EMF
	 * @param diagramFile File to check
	 * @return <i>true</i> if file can be copied using standard file copy
	 */
	protected boolean allowFileCopy(URI diagramFile) {
		return false;
	}

	@Override
	public URI copyDiagram(URI modelFile, String savePath) throws FileNotFoundException {
		final String separator = System.getProperty("file.separator");
		try {
			String modelFileName = modelFile.lastSegment();
			
			// This code assumes that mainDiagramUri is in diagramFiles:
			URI[] diagramFiles = getDiagramFiles(modelFile);
			URI mainDiagramUri = getMainDiagramFile(modelFile);

			if (diagramFiles == null || diagramFiles.length == 0 || mainDiagramUri == null) {
				throw new RuntimeException("Model not supported");
			}

			// Load the diagram file:
			List<Resource> diagramResources = new ArrayList<Resource>();
			List<File> diagramNonResources = new ArrayList<File>();
			for (URI diagramFile : diagramFiles) {
				File file = new File(EMFStorage.uriToPath(diagramFile));
				if (!file.exists() || !file.isFile()) {
					throw new FileNotFoundException("A diagram file was not found");
				}
				Resource resource = tryLoad(diagramFile);
				if (resource != null) {
					diagramResources.add(resource);
				} else if (allowFileCopy(diagramFile)) {
					diagramNonResources.add(file);
				} else {
					throw new RuntimeException("Diagram cannot be loaded as resource");
				}
			}
			// Save the diagram files:
			for (Resource diagramResource : diagramResources) {
				URI diagramFileURI = EMFStorage
						.pathToUri(savePath + separator + diagramResource.getURI().lastSegment());
				EcoreUtil.resolveAll(diagramResource);
				for(Resource r : diagramResource.getResourceSet().getResources()){
					if(r.getURI().lastSegment().equals(modelFileName)){
						r.setURI(EMFStorage.pathToUri(savePath + separator + modelFileName));
					}
				}
				saveDiagram(diagramFileURI, diagramResource);
			}
			for (File file : diagramNonResources) {
				File dest = new File(savePath + separator + file.getName());
				Files.copy(file.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
				// Refresh views like project manager, so that the copied file
				// is displayed
				try {
					IFile ifile = ResourcesPlugin.getWorkspace().getRoot()
							.getFileForLocation(Path.fromOSString(dest.getAbsolutePath()));
					ifile.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				} catch (Exception e) {
				}
			}
			return EMFStorage.pathToUri(savePath + separator + mainDiagramUri.lastSegment());
		} catch (Exception e) {
			if (e instanceof FileNotFoundException) {
				throw (FileNotFoundException) e;
			}
			throw new RuntimeException("Error copying diagram", e);
		}
	}

	private static Resource tryLoad(URI uri) {
		try {
			return EMFStorage.eLoad(uri).eResource();
		} catch (Exception e) {
			return null;
		}
	}

	private static void saveDiagram(URI diagramURI, Resource diagramResource) {
		diagramResource.setURI(diagramURI);

		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		options.put(XMIResource.OPTION_URI_HANDLER, new DeresolveToLastSegment());

		try {
			diagramResource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class DeresolveToLastSegment extends URIHandlerImpl {
		@Override
		public URI deresolve(URI uri) {
			return URI.createURI(uri.lastSegment()).appendFragment(uri.fragment());
		}
	}

	@Override
	public Collection<EObject> getHighlightableElements(EObject element) {
		ArrayList<EObject> res = new ArrayList<EObject>();
		res.add(element);
		return res;
	}

	@Override
	public Map<String, String> getFileExtensions() {
		Map<String, String>  extensions = new HashMap<String, String> ();
		extensions.put("model", this.modelFileExt);
		extensions.put("diagram", this.diagramFileExt);
		return extensions;
	}
}
