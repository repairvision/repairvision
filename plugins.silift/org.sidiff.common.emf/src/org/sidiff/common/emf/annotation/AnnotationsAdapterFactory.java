package org.sidiff.common.emf.annotation;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.sidiff.common.emf.adapters.SiDiffAdapter;
import org.sidiff.common.emf.adapters.SiDiffAdapterFactory;
import org.sidiff.common.emf.annotation.internal.AnnotateableElementImpl;

/**
 * Adapter factory for creating annotateable element adapters.
 * @author wenzel
 *
 */
public class AnnotationsAdapterFactory extends SiDiffAdapterFactory implements AdapterFactory {

	public AnnotationsAdapterFactory() {
		super(AnnotateableElement.class);
	}

	@Override
	public SiDiffAdapter createAdapter() {
		return new AnnotateableElementImpl();
	}

}
