package org.sidiff.common.util;

import java.lang.reflect.*;
import java.util.*;

import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.common.io.ResourceUtil;

/**
 * Utility class for the reflective instantiation of classes.
 * @author wenzel
 *
 */
public class ReflectionUtil {

	/**
	 * Creates an instance of the specified class.
	 * @param <T>
	 * @param clientClass
	 * @param constuctorParams
	 * @return
	 */
	public static <T extends Object> T createInstance(Class<T> clientClass, Object... constuctorParams) {
		Constructor<T> constructor = getConstructor(clientClass, constuctorParams);
		if (constructor == null) {
			throw new IllegalArgumentException("ReflectionUtil::createInstance - No suitable constructor [" + StringUtil.resolve(constuctorParams) + "] at Class " + clientClass.getName());
		}
		try {
			return constructor.newInstance(constuctorParams);
		} catch (IllegalArgumentException e) {
			throw new SiDiffRuntimeException("Internal Error! Wrong args/constructor used! " + clientClass.getName() + "-[" + StringUtil.resolve(constuctorParams) + "]\n",e);
		} catch (InstantiationException e) {
			throw new SiDiffRuntimeException("Cannot create instance from class " + clientClass.getName() + "\n", e);
		} catch (IllegalAccessException e) {
			throw new SiDiffRuntimeException("Cannot access constructor of class " + clientClass.getName() + "\n", e);
		} catch (InvocationTargetException e) {
			throw new SiDiffRuntimeException("Constructor of "+clientClass.getName()+" has thrown a Exception!\n", e);
		}
	}

	/**
	 * Creates an instance of the specified class.
	 * @param <T>
	 * @param className
	 * @param resulttype
	 * @param constuctorParams
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> T createInstance(String className, Class<T> resulttype, Object... constuctorParams) {
		// Try to get Client Class
		Class<?> clientClass = null;
		try {
			clientClass = ReflectionUtil.loadClass(className);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("ReflectionUtil::createInstance - Class not found: " + className);
		}
		Constructor<?> constructor = getConstructor(clientClass, constuctorParams);
		if (constructor == null) {
			throw new IllegalArgumentException("ReflectionUtil::createInstance - No suitable constructor [" + StringUtil.resolve(constuctorParams) + "] at Class " + className);
		}
		try {
			return (T) createInstance(clientClass, constuctorParams);
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("ReflectionUtil::createInstance - Wrong expectet Objecttype '" + className + "' isn't " + resulttype.getName() + ".");
		}
	}

	/**
	 * Returns the constructor of a given class whose signature matches with the types 
	 * of the given constructor parameters. 
	 * @param <T>
	 * @param clientClass
	 * @param constuctorParams
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> Constructor<T> getConstructor(Class<T> clientClass, Object... constuctorParams) {
		// Get Matching Constuctor
		Constructor<T> constructor = null;
		for (Constructor<?> c : clientClass.getConstructors()) {
			Class<?>[] params = c.getParameterTypes();
			if (params.length == constuctorParams.length) {

				boolean matchingConstructor = true;
				for (int i = 0; i < constuctorParams.length; i++) {
					if (params[i].isPrimitive()) {
						// Assignment Comartible to Wrapper
						Class<?> primitiveConstructorParam = null;
						try {
							primitiveConstructorParam = (Class<?>) (constuctorParams[i].getClass().getField("TYPE").get(constuctorParams[i]));
						} catch (Exception e) {
							/** Not a Wrapper */
						}

						if (!params[i].equals(primitiveConstructorParam)) {
							matchingConstructor = false;
							break;
						}
					} else {
						// Constructor parameter is a reference Type
						if (constuctorParams[i] != null && !params[i].isAssignableFrom(constuctorParams[i].getClass())) {
							matchingConstructor = false;
							break;
						}
					}
				}
				if (matchingConstructor) {
					constructor = (Constructor<T>) c;
					break;
				}
			}
		}
		return constructor;
	}

	/**
	 * Invokes a static method on a class that is accessed reflectively. 
	 * @param <T>
	 * @param resultType
	 * @param clientClass
	 * @param methodName
	 * @param methodParams
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T invokeStaticMethod(Class<T> resultType, Class clientClass, String methodName, Object... methodParams) {

		// Get Matching Method
		Method method = null;
		for (Method m : clientClass.getMethods()) {
			Class[] params = m.getParameterTypes();
			if (m.getName().equals(methodName) && params.length == methodParams.length) {

				// Check return Value
				if ((resultType == null && m.getReturnType() == void.class) || (resultType != null && resultType.isAssignableFrom(m.getReturnType()))) {

					boolean matchingMethod = true;
					// Check args
					for (int i = 0; i < params.length; i++) {
						if (params[i].isPrimitive()) {
							// Assignment Comartible to Wrapper
							Class primitiveMethodParam = null;
							try {
								primitiveMethodParam = (Class) (methodParams[i].getClass().getField("TYPE").get(methodParams[i]));
							} catch (Exception e) {
								/** Not a Wrapper */
							}

							if (!params[i].equals(primitiveMethodParam)) {
								matchingMethod = false;
								break;
							}
						} else {
							// Constructor parameter is a reference Type
							if (methodParams[i] != null && !params[i].isAssignableFrom(methodParams[i].getClass())) {
								matchingMethod = false;
								break;
							}
						}
					}
					if (matchingMethod) {
						method = m;
						break;
					}
				}
			}
		}
		return invokeStaticMethod(resultType, method, methodParams);
	}

	/**
	 * Invokes a static method on a class that is accessed reflectively. 
	 * @param <T>
	 * @param resultType
	 * @param method
	 * @param args
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T invokeStaticMethod(Class<T> resultType, Method method, Object... args) {

		try {
			return (T) method.invoke(null, args);
		} catch (Exception e) {
			throw new IllegalArgumentException("Cannot invoke " + method + "; nonstatic,accessable or wrong args?");
		}

	}

	/**
	 * Loads the class that is specified by its name.
	 * Its queries all class loaders that have been registered at the ResourceUtil.
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Class<?> loadClass(String name) throws ClassNotFoundException {

		ClassLoader suitableLoader = ResourceUtil.getClassLoaderByClassName(name);
		if (suitableLoader != null) {
			return suitableLoader.loadClass(name);
		} else {
			return Class.forName(name);
		}
		//throw new ClassNotFoundException(name);
	}
	
	/**
	 * Computes the inheritance distance between two classes.
	 * I.e. the number of inheritance relationships that have to be traversed
	 * to get from the one class to the other.
	 * @param superclass
	 * @param subclass
	 * @return
	 */
	public static int computeInheritanceDistance(Class<?> superclass, Class<?> subclass){
		
		assert(subclass!=null && superclass!=null) : "Cannot compute inheritance distance to 'null'";
		
		if(superclass==subclass){
			return 0;
		} else if(subclass.getSuperclass()!=null&&superclass.isAssignableFrom(subclass.getSuperclass())){
			// Superclass lookup
			int distanceFromHere = computeInheritanceDistance(superclass, subclass.getSuperclass());
			return (distanceFromHere<Integer.MAX_VALUE)?1+distanceFromHere : Integer.MAX_VALUE;
		} else {
			for(Class<?> interfaceLookup : subclass.getInterfaces()){
				if(superclass.isAssignableFrom(interfaceLookup)){
					// Interface lookup
					int distanceFromHere = computeInheritanceDistance(superclass, interfaceLookup);
					return (distanceFromHere<Integer.MAX_VALUE)?1+distanceFromHere : Integer.MAX_VALUE;
				}
			}
		}
		return Integer.MAX_VALUE;
		
	}
	
	public static Set<Class<?>> computePolymorism(Class<?> clazz){
		Set<Class<?>> result = new HashSet<Class<?>>();
		lookupSupertypes(result,clazz);
		lookupInterfaces(result, clazz);
		return result;
	}
	
	private static Set<Class<?>> lookupSupertypes(Set<Class<?>> set, Class<?> clazz){

		set.add(clazz);
		if(clazz!=Object.class){
			return lookupSupertypes(set, clazz.getSuperclass());
		} else {
			return set;
		}
	}
	
	private static void lookupInterfaces(Set<Class<?>> set, Class<?> clazz){

		Class<?>[] interfaces = clazz.getInterfaces();
		for(Class<?> iclazz : interfaces){
			set.add(iclazz);
			lookupInterfaces(set, iclazz);
		}
		
	}
	
}
