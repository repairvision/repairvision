package org.sidiff.revision.ui.editors.integration.registry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.sidiff.revision.ui.editors.integration.extension.IEditorIntegration;

public class IntegrationEditorRegistry {

	private static IntegrationEditorRegistry INSTANCE = null;

	private final List<IEditorIntegration> integrationEditors;

	public static IntegrationEditorRegistry getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new IntegrationEditorRegistry();
		}
		return INSTANCE;
	}

	private IntegrationEditorRegistry() {
		this.integrationEditors = new ArrayList<IEditorIntegration>();
		
		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(IEditorIntegration.EXTENSION_POINT_ID);
		
		for (IConfigurationElement e : elements) {
			try {
				integrationEditors.add(
						(IEditorIntegration) e.createExecutableExtension(IEditorIntegration.EXTENSION_POINT_ATTRIBUTE));
			} catch (CoreException e1) {
				e1.printStackTrace();
			}
		}
	}

	public List<IEditorIntegration> getIntegrationEditors() {
		return Collections.unmodifiableList(integrationEditors);
	}

}
