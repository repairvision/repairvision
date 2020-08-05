package org.sidiff.revision.common.emf;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 * The resource manager is used to save and load EMF and java resources.
 */
public class EMFStorage {

	/**
	 * Do nothing while saving the URI.
	 */
	@SuppressWarnings("unused")
	private static class DoNotDeresolve extends URIHandlerImpl {
		@Override
		public URI deresolve(URI uri) {
			return uri;
		}
	}	
	
	/**
	 * URI will be replaced by the last segment
	 */
	private static class ResolveLastSegment extends URIHandlerImpl {
		@Override
		public URI deresolve(URI uri) {
			String rel= uri.toString();
			String segment = rel.substring(rel.indexOf(uri.lastSegment()));
			return URI.createURI(segment);
		}
	}
	
	
	/**
	 * URI will be replaced by the shortest relative URI.
	 */
	private static class DeresolveRelative extends URIHandlerImpl{
		@Override
		public URI deresolve(URI uri){
			return !uri.isPlatform() || (uri.segmentCount() > 0 && baseURI.segmentCount() > 0 && uri.segment(0).equals(baseURI.segment(0))) ? super.deresolve(uri) : uri;
		}
	}
	
	/**
	 * Deresolve as file URI to platform resource URI.
	 */
	private static class FileToPlatformResourceDeresolve extends URIHandlerImpl {
		
		@Override
		public URI deresolve(URI uri) {
			
			if (uri.isFile()) {
				// FIXME: Very slow for a high count of URIs!
				return uriToPlatformUri(uri).appendFragment(uri.fragment());
			}
			
			return uri;
		}
	}	

	/**
	 * Save EMF resource which is already contained in a resource. References
	 * will be saved as platform resource URIs.
	 * 
	 * @param root
	 *            the root object that will be saved.
	 */
	public static void eSave(EObject root) {

		Resource resource = root.eResource();

		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		options.put(XMIResource.OPTION_URI_HANDLER, new FileToPlatformResourceDeresolve());

		try {
			resource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Save EMF resource to given URI path. References will be saved as platform resource URIs.
	 * 
	 * @param path
	 *            the save path.
	 * @param root
	 *            the root object that will be saved.
	 */
	public static void eSaveAs(URI uri, EObject root) {

		Resource resource = new XMIIDResourceImpl(uri);
		resource.getContents().add(root);

		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		options.put(XMIResource.OPTION_URI_HANDLER, new FileToPlatformResourceDeresolve());

		try {
			resource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Save EMF resource to given URI path. References will be saved as platform resource URIs.
	 * 
	 * @param path
	 *            the save path.
	 * @param root
	 *            the root objects that will be saved.
	 */
	public static void eSaveAs(URI uri, Collection<? extends EObject> content) {

		Resource resource = new XMIIDResourceImpl(uri);
		resource.getContents().addAll(content);

		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		options.put(XMIResource.OPTION_URI_HANDLER, new FileToPlatformResourceDeresolve());

		try {
			resource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Save EMF resource to given URI path.
	 * 
	 * @param path
	 *            the save path.
	 * @param root
	 *            the root object that will be saved.
	 * @param relative
	 * 			  true: URIs will be replaced by the shortest relative path.
	 *            false: Do nothing while saving the URI.
	 */
	public static void eSaveAs(URI uri, EObject root, boolean relative) {

		Resource resource = null;
		
		if(root.eResource() != null){
			resource = root.eResource();
			resource.setURI(uri);
		}else{
			resource = new XMIResourceImpl(uri);
			resource.getContents().add(root);
		}
		
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		if(relative) {
			options.put(XMIResource.OPTION_URI_HANDLER, new DeresolveRelative());
		} else {
			options.put(XMIResource.OPTION_URI_HANDLER, new ResolveLastSegment());
		}

		try {
			resource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Overwrite EMF resource.
	 * 
	 * @param oldObj
	 *            The old object to overwrite.
	 * @param newObj
	 *            The new object to put into the old resource.
	 */
	public static void eOverwrite(EObject oldObj, EObject newObj) {

		Resource resource = oldObj.eResource();
		resource.getContents().clear();
		resource.getContents().add(newObj);
	}

	/**
	 * Load EMF resource.
	 * 
	 * @param eObjectUri
	 *            the EMF-file path.
	 * @return the loaded EMF-object.
	 */
	public static EObject eLoad(URI eObjectUri) {
		Resource eObjectResource = new ResourceSetImpl().getResource(eObjectUri, true);
		EObject eObject = eObjectResource.getContents().get(0);

		return eObject;
	}
	
	/**
	 * Load EMF resource.
	 * 
	 * @param eObjectUri
	 *            the EMF-file path.
	 * @param rss
	 *            The resource set that should be used.
	 * @return the loaded EMF-object.
	 */
	public static EObject eLoad(URI eObjectUri, ResourceSet rss) {
		Resource eObjectResource = rss.getResource(eObjectUri, true);
		EObject eObject = eObjectResource.getContents().get(0);

		return eObject;
	}

	/**
	 * Reload EMF-object.
	 * 
	 * @param root
	 *            the root object (The same that was loaded).
	 * @return the reloaded EMF-object.
	 */
	public static EObject eReload(EObject root) {

		try {
			Resource resource = root.eResource();
			resource.unload();
			resource.load(null);
			EObject reloaded = resource.getContents().get(0);

			return reloaded;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Returns the URI of the given root object.
	 * 
	 * @param rootEObject
	 *            the root object
	 * @return the object URI.
	 */
	public static URI getURI(EObject rootEObject) {
		if (rootEObject.eIsProxy()) {
			return ((InternalEObject) rootEObject).eProxyURI().trimFragment();
		} else {
			return rootEObject.eResource().getURI();
		}
	}

	/**
	 * Returns the normalized URI of the given {@link Resource}.
	 * If the resource is contained in a {@link ResourceSet} the
	 * set's {@link URIConverter} is used to normalize the resource's URI.
	 * Otherwise, the resource's URI is returned without normalization.
	 * @param resource the resource
	 * @return normalized URI of this resource
	 */
	public static URI getNormalizedURI(Resource resource) {
		URI uri = resource.getURI();
		if(resource.getResourceSet() != null) {
			uri = resource.getResourceSet().getURIConverter().normalize(uri);
		}
		return uri;
	}

	/**
	 * Converts a (e.g. platform) URI to a file URI.
	 * 
	 * @param uri The URI to convert.
	 * @return The given URI as file URI.
	 */
	public static URI uriToFileUri(URI uri) {
		URI fileURI = pathToFileUri(uriToPath(uri));
		return fileURI;
	}
	
	/**
	 * Converts a (e.g. file) URI to a platform resource URI.
	 * Returns an file URI if the URI is not workspace relative.
	 * 
	 * @param uri The URI to convert.
	 * @return The given URI as platform resource URI.
	 */
	public static URI uriToPlatformUri(URI uri) {
		URI fileURI = pathToUri(uriToPath(uri));
		return fileURI;
	}

	/**
	 * Converts a file path to an platform resource URI.
	 * 
	 * @param path
	 *            The path to convert.
	 * @return The given path as platform resource URI.
	 */
	public static URI pathToUri(String path) {
		File file = pathToFile(path);
		return fileToUri(file);
	}
	
	/**
	 * Converts a file path to an platform resource URI.
	 * 
	 * @param path
	 *            The path to convert.
	 * @return The given path as platform resource URI.
	 */
	public static URI pathToFileUri(String path) {
		File file = pathToFile(path);
		return fileToFileUri(file);
	}
	
	public static java.net.URI pathToRelativeUri(String base, String path) {
		return new File(base).toURI().relativize(new File(path).toURI());
	}

	/**
	 * Converts a file path to a <code>File</code>.
	 * 
	 * @param path
	 *            The path to convert.
	 * @return The given path as <code>File</code>
	 */
	public static File pathToFile(String path) {
		return new File(path);
	}

	/**
	 * Converts a URI to an absolute file path.
	 * 
	 * @param uri
	 *            The URI to convert.
	 * @return The given URI as absolute file path
	 */
	public static String uriToPath(URI uri) {
		
		//We can assume that this URI is used in the platform context
		if (uri.isPlatform()) {
			// NOTE: Get the project the URI is corresponding to,
			// so we can resolve linked resources in this way.
			// This perhaps can be done in a cleaner way.
			
			// NOTE: A project name might differ from its folder name.
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(uri.segment(1));
			String projectLoc = project.getLocation().toString();
			String platformPath = uri.toPlatformString(true);
			String projectPath = platformPath.substring(project.getName().length() + 1, platformPath.length());
			return pathToFile(projectLoc + projectPath).getAbsolutePath();
		}

		return pathToFile(uri.devicePath()).getAbsolutePath();
	}

	/**
	 * Converts a URI to a <code>File</code>.
	 * 
	 * @param uri
	 *            The URI to convert.
	 * @return The given URI as <code>File</code>.
	 */
	public static File uriToFile(URI uri) {
		return new File(uriToPath(uri));
	}

	/**
	 * Converts a {@link URI#isPlatformResource platform resource} {@link URI}
	 * (a platform resource with the first segment being "resource") to an {@link IFile}.
	 * @param uri the URI
	 * @return IFile for the given URI, <code>null</code> if the URI is not a platform resource URI
	 */
	public static IFile uriToIFile(URI uri) {
		if(uri.isPlatformResource() && uri.segmentCount() > 2) {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		}
		return null;
	}

	/**
	 * Converts a <code>File</code> inside the workspace to an absolute file path.
	 * 
	 * @param file The <code>File</code> to convert.
	 * @return The given <code>File</code> as absolute file path
	 */
	public static String fileToPath(File file) {
		if (file.isAbsolute()) {
			return file.getAbsolutePath();
		} else {
			return new File(
					ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() 
					+ file.getPath()).getAbsolutePath();	
		}
	}

	/**
	 * Converts a <code>File</code> to a platform resource URI.
	 * Returns an file URI if the URI is not workspace relative.
	 * 
	 * @param file The <code>File</code> to convert.
	 * @return The given file as platform resource URI.
	 */
	public static URI fileToUri(File file) {
		IFile[] iFiles = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(file.toURI());
		
		if (iFiles.length > 0) {
			return URI.createPlatformResourceURI(iFiles[0].getFullPath().toString(), true);
		} else {
			return URI.createFileURI(file.getAbsolutePath());
		}
	}
	
	/**
	 * Converts a <code>File</code> to a file URI.
	 * 
	 * @param file
	 *            The <code>File</code> to convert.
	 * @return The given file as file URI.
	 */
	public static URI fileToFileUri(File file) {
		return URI.createFileURI(fileToPath(file));
	}
	
	/**
	 * Converts a <code>IResource</code> to a platform resource URI.
	 * 
	 * @param file
	 *            The <code>IResource</code> to convert.
	 * @return The given resource as file URI.
	 */
	public static URI iResourceToURI(IResource iResource) {
		return URI.createPlatformResourceURI(iResource.getFullPath().toString(), true);
	}

	/**
	 * Returns the folder path.
	 * 
	 * @param filePath
	 *            the file or folder path.
	 * @return the folder path.
	 */
	public static File getDirectory(String filePath) {
		File path = new File(filePath);

		if (path.isFile()) {
			return new File(path.getParent());
		} else {
			return path;
		}
	}

	/**
	 * Returns the xmi:id attribute value for the given eObject as a <tt>String</tt>. Returns <b>null</b> in case there's no containing resource or the eObject simply didn't have a xmi:id attribute.
	 */
	public static String getXmiId(EObject eObject) {
		String objectID = null;
		if (eObject != null && eObject.eResource() instanceof XMIResource) {
			objectID = ((XMIResource) eObject.eResource()).getID(eObject);
		}
		return objectID;
	}

	/**
	 * Sets the xmi:id attribute value for the given eObject
	 * 
	 * @param eObject
	 * 				the object for that the id is set
	 * @param id
	 * 				the id that is set
	 */
	public static void setXmiId(EObject eObject, String id){
		if (eObject.eResource() instanceof XMIResource) {
			((XMIResource) eObject.eResource()).setID(eObject, id);
		}
	}
}
