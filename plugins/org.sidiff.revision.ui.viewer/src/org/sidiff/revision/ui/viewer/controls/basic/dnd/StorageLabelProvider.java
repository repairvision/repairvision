/*******************************************************************************
 * Copyright (c) 2000, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.sidiff.revision.ui.viewer.controls.basic.dnd;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IFileEditorMapping;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * Standard label provider for IStorage objects. Use this class when you want to
 * present IStorage objects in a viewer.
 */
public class StorageLabelProvider extends LabelProvider  {

	private IEditorRegistry editorRegistry = null;

	private Map<String, Image> imageMap = new HashMap<String, Image>(10);

	private Image defaultImage;

	private IEditorRegistry getEditorRegistry() {
		if (editorRegistry == null) {
			editorRegistry = PlatformUI.getWorkbench().getEditorRegistry();
		}
		return editorRegistry;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see ILabelProvider#getImage
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof IStorage) {
			return getImageEntry((IStorage) element);
		}

		return super.getImage(element);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see ILabelProvider#getText
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof IStorage) {
			return ((IStorage) element).getName();
		}
		return super.getText(element);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see IBaseLabelProvider#dispose
	 */
	@Override
	public void dispose() {
		if (imageMap != null) {
			Iterator<Image> each = imageMap.values().iterator();
			while (each.hasNext()) {
				Image image = each.next();
				image.dispose();
			}
			imageMap = null;
		}
		defaultImage = null;
	}

	private Image getImageEntry(IStorage element) {

		if ((element == null) || (element.getName() == null)) {
			return getDefaultImage();
		}

		// Try to find icon for full name
		String name = element.getName();
		Image image = imageMap.get(name);
		if (image != null) {
			return image;
		}
		IFileEditorMapping[] mappings = getEditorRegistry().getFileEditorMappings();
		int i = 0;
		while (i < mappings.length) {
			if (mappings[i].getLabel().equals(name)) {
				break;
			}
			i++;
		}
		String key = name;
		if (i == mappings.length) {
			// Try to find icon for extension
			IPath path = element.getFullPath();
			if (path == null) {
				return getDefaultImage();
			}
			key = path.getFileExtension();
			if (key == null) {
				return getDefaultImage();
			}
			image = imageMap.get(key);
			if (image != null) {
				return image;
			}
		}

		// Get the image from the editor registry
		ImageDescriptor desc = getEditorRegistry().getImageDescriptor(name);
		image = desc.createImage();

		imageMap.put(key, image);

		return image;
	}

	private Image getDefaultImage() {
		if (defaultImage == null) {
			defaultImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
		}
		return defaultImage;
	}
}
