package org.sidiff.matching.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.sidiff.common.emf.modelstorage.AbstractEMFImporter;
import org.sidiff.common.emf.modelstorage.Loader;
import org.sidiff.common.util.StringUtil;
import org.sidiff.matching.model.util.CorrespondenceStringResolver;
import org.sidiff.matching.model.util.MatchingStringResolver;

public class Activator extends EMFPlugin implements BundleActivator {
	//TODO VDUECK need this Activator ?
//	private static ResourceLocator plugin;
	
	private static Activator INSTANCE;
	private static EclipsePlugin plugin;

	public Activator() {
		super(new ResourceLocator [] {});
	}
	
	public static Activator getInstance(){
		return INSTANCE;
	}

	private static final Map<String, String> URIMAP = new HashMap<String, String>();

	static {
		URIMAP.put("http://www.sidiff.org/org.sidiff.core.correspondences.model","platform:/resource/org.sidiff.core.correspondences.model/model/MatchingModel.ecore");
	}
	
	//TODO VDUECK need to implement this in an own class
	Loader matchModelLoader = new AbstractEMFImporter() {
		
		@Override
		public Set<String> getMagicKeys() {
			return Collections.singleton(".*");
		}
		
		@Override
		public String getSuffix() {
			return "smf.xmi";
		}
		
		@Override
		public Map<String, String> getSchemaLocationMappings() {
			return URIMAP;
		}
		
		@Override
		public String getLoaderDescription() {
			return "Loader for Matchings";
		}
	};
	
	public void start(BundleContext context) throws Exception {
		INSTANCE = this;
		
	//	ServiceHelper.registerServiceProvider(context, MatchingModelServiceProvider.class, new MatchingModelServiceProviderImpl(), null, null);
//		ModelStorage.getInstance().registerLoader(matchModelLoader);
		StringUtil.addStringResolver(new MatchingStringResolver());
		StringUtil.addStringResolver(new CorrespondenceStringResolver());
	}

	public void stop(BundleContext context) throws Exception {
		StringUtil.removeStringResolver(Matching.class);
		StringUtil.removeStringResolver(Correspondence.class);
	}

	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	public static class GmdPluginImpl extends EclipsePlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public GmdPluginImpl() {
			super();
	
			// Remember the static instance.
			//
			plugin = this;
		}
	}
}
