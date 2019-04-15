package org.sidiff.common;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.sidiff.common.util.ObjectUtil;
import org.sidiff.common.util.StringUtil;
import org.sidiff.common.util.internal.*;

/**
 * Dieser Aktivator wird genutzt, falls die Bibliothek in einem OSGI
 * Kontext genutzt wird. Er ermoeglicht den spaetern Zugriff auf den
 * Bundelcontext und initialisiert diverse Bibliotheksteile!
 * Daher solle ein zugriff auf diese Klasse in jedem Fall
 * vor der Benutzung der Bibliothek erfolgen. 
 * 
 * @author Maik Schmidt
 *
 */
public class Activator implements BundleActivator {

	/**
	 * Stores the context in which the bundle is running, if given.
	 */
	private static BundleContext context = null;
	
	@Override
	public void start(BundleContext context) throws Exception {
		assert(context!=null):"Context of an activated bundle must not be null!";
		Activator.context= context;
		
		//register all provided StringResolvers
		StringUtil.addStringResolver(new ArrayStringResolver());
		StringUtil.addStringResolver(new CollectionStringResolver());
		StringUtil.addStringResolver(new ExceptionStringResolver());
		StringUtil.addStringResolver(new ErrorStringResolver());
		StringUtil.addStringResolver(new HashTableStringResolver());
		StringUtil.addStringResolver(new MapStringResolver());
		StringUtil.addStringResolver(new ThreadStringResolver());
		StringUtil.addStringResolver(new StackTraceStringResolver());
		
		//register all ObjectConverter
		ObjectUtil.registerConverter(new StringConverter());
		ObjectUtil.registerConverter(new IntegerConverter());
		ObjectUtil.registerConverter(new GenericListConverter());
		ObjectUtil.registerConverter(new GenericMapConverter());
		ObjectUtil.registerConverter(new GenericSetConverter());
		ObjectUtil.registerConverter(new FloatConverter());
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		assert(context!=null):"Context of a deactivated bundle must not be null!";
		assert(Activator.context==context):"Given context is not the same as given during activation!";
		Activator.context=null;
		
		//unregister all provided StringResolvers
		StringUtil.removeStringResolver(ArrayStringResolver.class);
		StringUtil.removeStringResolver(CollectionStringResolver.class);
		StringUtil.removeStringResolver(ExceptionStringResolver.class);
		StringUtil.removeStringResolver(ErrorStringResolver.class);
		StringUtil.removeStringResolver(HashTableStringResolver.class);
		StringUtil.removeStringResolver(MapStringResolver.class);
		StringUtil.removeStringResolver(ThreadStringResolver.class);
		StringUtil.removeStringResolver(StackTraceStringResolver.class);
	}
	
	// DOKU
	public static BundleContext getBundleContext(){
		assert(isActivated()):"Bundle is not activated yet!";
		return Activator.context;
	}
	
	// DOKU
	public static boolean isActivated(){
		return Activator.context!=null;
	}
	
}
