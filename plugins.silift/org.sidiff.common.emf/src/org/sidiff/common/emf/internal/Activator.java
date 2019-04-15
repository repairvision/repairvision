package org.sidiff.common.emf.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.adapters.ElementByIDAdapterFactory;
import org.sidiff.common.emf.adapters.SiDiffAdapterFactory;
import org.sidiff.common.emf.annotation.AnnotationManager;
import org.sidiff.common.emf.annotation.AnnotationsAdapterFactory;
import org.sidiff.common.emf.annotation.internal.AnnotationDebugger;
import org.sidiff.common.io.IOUtil;
import org.sidiff.common.io.ResourceUtil;
import org.sidiff.common.util.StringResolver;
import org.sidiff.common.util.StringUtil;
import org.sidiff.common.xml.XMLResolver;

public class Activator implements BundleActivator {

	public final static String BUNDLE_ID = "org.sidiff.common.emf";

	private final static SiDiffAdapterFactory annotationsAdapterFactory = new AnnotationsAdapterFactory();
	private final static SiDiffAdapterFactory elementByIDAdapterFactory = new ElementByIDAdapterFactory();
	private final static StringResolver eObjectStringResolver = new EObjectStringResolver();

	@Override
	public void start(BundleContext context) throws Exception {

		EMFAdapter.INSTANCE.addAdapterFactory(annotationsAdapterFactory);
		EMFAdapter.INSTANCE.addAdapterFactory(elementByIDAdapterFactory);
		StringUtil.addStringResolver(eObjectStringResolver);
		ResourceUtil.registerClassLoader(this.getClass().getClassLoader());
		XMLResolver.getInstance().includeMapping(IOUtil.getInputStream("org.sidiff.common.emf.dtdmap.xml"));
		AnnotationManager.registerConverter(new GenericEObjectConverter());
		
		/*
		assert(SiDiffDebugger.addDebugger("ed", new EMFDebugger()));
		assert(SiDiffDebugger.addDebugger("ad", new AnnotationDebugger()));
		*/
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		EMFAdapter.INSTANCE.removeAdapterFactory(annotationsAdapterFactory);
		EMFAdapter.INSTANCE.removeAdapterFactory(elementByIDAdapterFactory);
		StringUtil.removeStringResolver(eObjectStringResolver);

		ResourceUtil.unregisterClassLoader(this.getClass().getClassLoader());

	}

}
