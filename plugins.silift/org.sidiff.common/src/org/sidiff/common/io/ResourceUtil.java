package org.sidiff.common.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;

/**
 * Utility class for accessing resources.
 */
public class ResourceUtil {

	private static ArrayList<ClassLoader> classLoaders = new ArrayList<ClassLoader>();

	static {
		classLoaders.add(ResourceUtil.class.getClassLoader());
	}
	
	/**
	 * Returns all class loaders that are registered.
	 * @return
	 */
	public static List<ClassLoader> getClassLoaders() {
		return Collections.unmodifiableList(classLoaders);
	}

	/**
	 * Registers a class loader.
	 * @param classLoader
	 */
	public static void registerClassLoader(ClassLoader classLoader) {
		
		if (!classLoaders.contains(classLoader)) {
			synchronized (classLoaders) {
				classLoaders.add(classLoader);
			}
			assert(LogUtil.log(LogEvent.DEBUG, "Added ClassLoader to the system: " + classLoader.toString()));
		} else {
			assert(LogUtil.log(LogEvent.DEBUG, "Already registered ClassLoader: " + classLoader.toString()));
		}
		
		
	}
	
	/**
	 * Unregisters a class loader.
	 * @param classLoader
	 */
	public static void unregisterClassLoader(ClassLoader classLoader) {
		if (classLoaders.contains(classLoader)) {
			synchronized (classLoaders) {
				classLoaders.remove(classLoader);
			}
			assert(LogUtil.log(LogEvent.DEBUG, "ClassLoader removed from system: " + classLoader.toString()));
		} else {
			LogUtil.log(LogEvent.WARNING, "Cannot remove non present ClassLoader: " +classLoader.toString());
		}
	}

	/**
	 * Returns an input stream for a resource whose name is given. This method iterates
	 * over all registered class loaders until the respective resource can be found.
	 * @param name
	 * @return
	 */
	public static InputStream getInputStreamByResourceName(String name) {
		InputStream result = null;
		synchronized (classLoaders) {
			for (ClassLoader currentLoader : classLoaders) {
				result = currentLoader.getResourceAsStream(name);
				if(result!=null){
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Returns the class loader that can load the resource whose name is given.
	 * @param name
	 * @return
	 */
	public static ClassLoader getClassLoaderByResourceName(String name) {

		ClassLoader loader = null;
		synchronized (classLoaders) {
			for (ClassLoader currentLoader : classLoaders) {
				InputStream stream = currentLoader.getResourceAsStream(name);
				if (stream != null) {
					loader = currentLoader;
					try {
						stream.close();
					} catch (IOException e) {
						throw new SiDiffRuntimeException("Exception while closing stream?!", e);
					}
					break;
				}
			}
		}
		return loader;
	}

	/**
	 * Returns the class loader that can load the class whose name is given.
	 * @param name
	 * @return
	 */
	public static ClassLoader getClassLoaderByClassName(String name) {
		ClassLoader loader = null;
		synchronized (classLoaders) {
			for (ClassLoader currentLoader : classLoaders) {
				try {
					currentLoader.loadClass(name);
					loader = currentLoader;
					break;
				} catch (ClassNotFoundException e) {
				}
			}
		}
		return loader;
	}

}
