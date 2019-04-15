package org.sidiff.integration.editor.extension;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.IEditorPart;

public interface IEditorIntegration {

	String EXTENSION_POINT_ID = "org.sidiff.integration.editor";
	String EXTENSION_POINT_ATTRIBUTE = "class";

	/**
	 * This method is used to find a highlightable element corresponding to
	 * "element" in a diagram It sould be called using {@link EditorAccess#}.
	 * 
	 * In a bit more detail: Given the input model element, which is obtained
	 * from the data layer of the editor (MVC pattern), we have to return the
	 * set of highlightable elements in this context. In most cases, the
	 * resulting collection will only contain the element itself. It can also be
	 * an empty collection if no element in the given context can be
	 * highlighted. In some cases, it can be really a set of elements.
	 * 
	 * 
	 * @param obj
	 * @return Highlightable elements corresponding to "element", "element"
	 *         itself or null
	 */
	public Collection<EObject> getHighlightableElements(EObject element);

	/**
	 * Checks if a model file can be opened by the editor
	 * 
	 * @param modelFile
	 * @return
	 */
	public boolean supportsModel(URI modelFile);

	/**
	 * Checks if a model file can be opened by the editor
	 * 
	 * @param model
	 * @return
	 */
	public boolean supportsModel(Resource model);

	/**
	 * Checks if a diagram file can be opened by the editor. This does NOT mean
	 * that an editor is present or even specified
	 * 
	 * @param diagramFile
	 * @return
	 */
	public boolean supportsDiagram(URI diagramFile);

	/**
	 * Checks if a diagram for the model can be created, saved, etc. by this
	 * editor
	 * 
	 * @param modelFile
	 * @return
	 */
	public boolean supportsDiagramming(Resource model);

	/**
	 * Copies all diagram files for a model to a save path. Existing files will
	 * be replaced
	 * 
	 * @param modelURI
	 * @param savePath
	 * @throws FileNotFoundException
	 *             The diagram files could not be found
	 * @return File The main diagram file which can be opened by the editor
	 */
	public URI copyDiagram(URI modelURI, String savePath) throws FileNotFoundException;

	/**
	 * Returns the ID for the default editor or null
	 * 
	 * @return
	 */
	public String getDefaultEditorID();

	/**
	 * Returns the ID for the diagram editor or null
	 * 
	 * @return
	 */
	public String getDiagramEditorID();

	/**
	 * Checks if the default editor is present in the current workspace
	 * 
	 * @return true if present, false if not
	 */
	public boolean isDefaultEditorPresent();

	/**
	 * Checks if the diagram editor is present in the current workspace
	 * 
	 * @return
	 */
	public boolean isDiagramEditorPresent();

	/**
	 * Opens a model in the default editor NOTE: If GMFAnimation is supported
	 * the editor must be opened with a org.eclipse.ui.IFileEditorInput
	 * 
	 * @param modelURI
	 * @return Opened editor or null
	 */
	public IEditorPart openModelInDefaultEditor(URI modelURI);

	/**
	 * Opens a diagram NOTE: If GMFAnimation is supported the editor must be
	 * opened with a org.eclipse.ui.IFileEditorInput
	 * 
	 * @param diagramFile
	 * @return Opened editor or null
	 */
	public IEditorPart openDiagram(URI diagramFile);

	/**
	 * Opens a diagram NOTE: If GMFAnimation is supported the editor must be
	 * opened with a org.eclipse.ui.IFileEditorInput
	 * 
	 * @param modelFile
	 * @return Opened editor or null
	 */
	public IEditorPart openDiagramForModel(URI modelFile);

	/**
	 * 
	 * @param diagramFile
	 * @return
	 */
	public boolean supportsGMFAnimation(URI diagramFile);

	/**
	 * Returns the Editing of an EditorPart opened by this editor
	 * 
	 * @param editorPart
	 * @return
	 */
	public EditingDomain getEditingDomain(IEditorPart editorPart);

	/**
	 * Returns the current Resource of an EditorPart opened by this editor
	 * 
	 * @param editorPart
	 * @return
	 */
	public Resource getResource(IEditorPart editorPart);

	/**
	 * Returns a Map with the file extensions of all files required
	 * by the editor integration
	 * 
	 * @return the model file uses the key "model" and the diagram file
	 *         "diagram"
	 */
	public Map<String, String> getFileExtensions();
}
