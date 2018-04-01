package org.sidiff.graphpattern.design.service;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.profile.extensions.GraphPatternProfileEntry;
import org.sidiff.graphpattern.profile.extensions.GraphPatternProfileLibrary;

public class DialogService {

	public void applyProfile(EObject element) {
		GraphPattern graphPattern = null;
		
		while(graphPattern == null) {
			if (element instanceof GraphPattern) {
				graphPattern = (GraphPattern) element;
			} else {
				if (element.eContainer() != null) {
					element = element.eContainer();
				} else {
					break;
				}
			}
		}
		
		if (graphPattern != null) {
			if ((graphPattern.getPattern() != null) && (graphPattern.getPattern().getBundle() != null)) {
				Bundle bundle = graphPattern.getPattern().getBundle();
				List<GraphPatternProfileEntry> extensions = GraphPatternProfileLibrary.getEntries();

				// dialog:
				ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
				adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
				adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
	
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(
						Display.getCurrent().getActiveShell(), 
						new AdapterFactoryLabelProvider(adapterFactory));
				
				// list profiles in registry:
				Object[] elements = new Object[extensions.size()];
				
				for (int i = 0; i < elements.length; i++) {
					elements[i] = extensions.get(0).getProfile().getProfile();
				}
				
				// open dialog:
				dialog.setElements(elements);
				dialog.setTitle("Apply Profiles");
				
				if (dialog.open() == ElementListSelectionDialog.OK) {
					for (Object selection : dialog.getResult()) {
						if (selection instanceof Profile) {
							bundle.getProfiles().add((Profile) selection); 
						}
					}
				}
			}
		}
	}
}
