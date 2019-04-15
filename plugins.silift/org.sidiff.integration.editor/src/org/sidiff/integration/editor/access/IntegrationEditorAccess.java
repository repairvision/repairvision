package org.sidiff.integration.editor.access;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.integration.editor.extension.IEditorIntegration;

public class IntegrationEditorAccess {

	private static IntegrationEditorAccess INSTANCE = null;

	private final List<IEditorIntegration> integrationEditors;

	public static IntegrationEditorAccess getInstance() {
		if (INSTANCE == null)
			INSTANCE = new IntegrationEditorAccess();
		return INSTANCE;
	}

	private IntegrationEditorAccess() {
		super();
		this.integrationEditors = new ArrayList<IEditorIntegration>();
		initIntegrationEditors();
	}

	private void initIntegrationEditors() {
		integrationEditors.clear();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IEditorIntegration.EXTENSION_POINT_ID);
		for (IConfigurationElement e : elements) {
			try {
				integrationEditors.add((IEditorIntegration)e.createExecutableExtension(IEditorIntegration.EXTENSION_POINT_ATTRIBUTE));
			} catch (CoreException e1) {
				e1.printStackTrace();
			}
		}
	}

	public List<IEditorIntegration> getIntegrationEditors() {
		return Collections.unmodifiableList(integrationEditors);
	}

	/**
	 * Selects a integration editor for a model type.
	 * Editors with a present Diagram Editor will
	 * be preferred.
	 * 
	 * @param model
	 * @return
	 */
	public IEditorIntegration getIntegrationEditorForModel(Resource model) {
		IEditorIntegration candidate = null;
		for (IEditorIntegration de : integrationEditors) {
			if (de.supportsDiagramming(model) && de.isDiagramEditorPresent()) {
				return de;
			} else if (de.supportsModel(model) && de.isDefaultEditorPresent()){
				candidate = de;
			}
		}
		if (candidate == null) {
			candidate = DefaultEditorIntegration.getInstance(model.getURI());
		}
		return candidate;
	}

	/**
	 * Selects a integration editor for a model type.
	 * Editors with a present Diagram Editor will
	 * be preferred.
	 * 
	 * @param modelOrDiagramFile
	 * @return
	 */
	public IEditorIntegration getIntegrationEditorForModelOrDiagramFile(URI modelOrDiagramFile) {
		IEditorIntegration candidate = null;
		for (IEditorIntegration de : integrationEditors) {
			if(de.supportsDiagram(modelOrDiagramFile) && de.isDiagramEditorPresent()) {
				return de;
			} else if(de.supportsModel(modelOrDiagramFile) && de.isDefaultEditorPresent()) {
				candidate = de;
			}
		}
		if(candidate == null) {
			candidate = DefaultEditorIntegration.getInstance(modelOrDiagramFile);
		}
		return candidate;
	}

	/**
	 * {@link IEditorIntegration#getHighlightableElement(EObject)}
	 * @param element
	 * @return 
	 */
	public Collection<EObject> getHighlightableElements(EObject element){
		Set<EObject> candidates = new HashSet<EObject>();
		for (IEditorIntegration de : integrationEditors) {
			candidates.addAll(de.getHighlightableElements(element));
		}
		if (!candidates.isEmpty()){
			return candidates;
		}
		return DefaultEditorIntegration.getInstance(element.eResource().getURI()).getHighlightableElements(element);
	}
}
