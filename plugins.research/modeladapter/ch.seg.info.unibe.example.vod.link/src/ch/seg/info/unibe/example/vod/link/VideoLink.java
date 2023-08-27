package ch.seg.info.unibe.example.vod.link;

import java.lang.reflect.Field;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import default_.ch.seg.info.unibe.example.vod.Server;
import default_.ch.seg.info.unibe.example.vod.impl.VideoImpl;

public class VideoLink extends VideoImpl {
	
	/**
	 * The declared Java field: {@link ch.seg.info.unibe.example.vod.Server}::name
	 */
	private static Field __java__name__;
	
	/**
	 * The declared Java field: {@link ch.seg.info.unibe.example.vod.Video}::main
	 */
	private static Field __java__main__;
	
	/**
	 * The declared Java field: {@link ch.seg.info.unibe.example.vod.Video}::mirror
	 */
	private static Field __java__mirror__;
	
	/**
	 * The corresponding Java 'Video' object.
	 */
	private ch.seg.info.unibe.example.vod.Video __java__object__;
	
	/**
	 * @return The declared Java field: {@link ch.seg.info.unibe.example.vod.User}::name
	 */
	public static Field __get__java__name__() {
		if (__java__name__ == null) {
			try {
				Class<ch.seg.info.unibe.example.vod.Video> jClass = ch.seg.info.unibe.example.vod.Video.class;
				VideoLink.__java__name__ = jClass.getDeclaredField("name");
				__java__name__.setAccessible(true);
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return __java__name__;
	}
	
	/**
	 * @return The declared Java field: {@link ch.seg.info.unibe.example.vod.Video}::main
	 */
	public static Field __get__java__main__() {
		if (__java__main__ == null) {
			try {
				Class<ch.seg.info.unibe.example.vod.Video> jClass = ch.seg.info.unibe.example.vod.Video.class;
				VideoLink.__java__main__ = jClass.getDeclaredField("main");
				__java__main__.setAccessible(true);
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return __java__main__;
	}
	
	/**
	 * @return The declared Java field: {@link ch.seg.info.unibe.example.vod.Video}::mirror
	 */
	public static Field __get__java__mirror__() {
		if (__java__mirror__ == null) {
			try {
				Class<ch.seg.info.unibe.example.vod.Video> jClass = ch.seg.info.unibe.example.vod.Video.class;
				VideoLink.__java__mirror__ = jClass.getDeclaredField("mirror");
				__java__mirror__.setAccessible(true);
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return __java__mirror__;
	}
	
	/**
	 * @return The corresponding Java 'Video' object.
	 */
	public ch.seg.info.unibe.example.vod.Video __get__java__object__() {
		return __java__object__;
	}

	/**
	 * @param __java__object__ The corresponding Java 'Video' object.
	 */
	public void __set__java__object__(ch.seg.info.unibe.example.vod.Video __java__object__) {
		this.__java__object__ = __java__object__;
	}
	
	/**
	 * @param jServer The Java 'Video' object.
	 * @param trace   The trace of all Java objects to model elements.
	 * @param resolve True: Create referenced model elements. 
	 *                False: Creates a proxy object for referenced model element.
	 * @return The translated model element.
	 */
	public static VideoLink __create__model__element__(ch.seg.info.unibe.example.vod.Video jVideo, Map<Object, EObject> trace, boolean resolve) {
		assert !trace.containsKey(jVideo) : "Model element already exists!";
		
		VideoLink eVideo = new VideoLink();
		trace.put(jVideo, eVideo);
		eVideo.__set__java__object__(jVideo);
		eVideo.__update__model__element__(trace, resolve);
		return eVideo;
	}
	
	/**
	 * @param eServer The 'Server' model element.
	 * @param trace   The trace of all Java objects to model elements.
	 * @param resolve True: Create referenced Java objects. False: Creates a proxy
	 *                object for referenced Java object.
	 * @return The translated Java object.
	 */
	public static ch.seg.info.unibe.example.vod.Video __create__java__object__(VideoLink eVideo, Map<Object, EObject> trace, boolean resolve) {
		// Initialize object with default values.
		// TODO: Do domain-specific adjustments...
		ch.seg.info.unibe.example.vod.Video jVideo = new ch.seg.info.unibe.example.vod.Video(null, null, null);
		trace.put(jVideo, eVideo);
		eVideo.__set__java__object__(jVideo);
		eVideo.__update__java__object__(trace, resolve);
		return jVideo;
	}
	
	/**
	 * Sets the attributes and references of the model element.
	 * 
	 * @param trace The trace of all Java objects to model elements.
	 * @param resolve True: Create referenced model elements. 
	 *                False: Creates a proxy object for referenced model element.
	 */
	public void __update__model__element__(Map<Object, EObject> trace, boolean resolve) {
		// TODO: super.__update__model__element__(trace, resolve);
		__update__model__element__name__(trace, resolve);
		__update__model__element__main__(trace, resolve);
		__update__model__element__mirror__(trace, resolve);
	}
	
	/**
	 * Sets the 'name' attribute of the model element.
	 * 
	 * @param trace The trace of all Java objects to model elements.
	 * @param resolve True: Create referenced model elements. 
	 *                False: Creates a proxy object for referenced model element.
	 */
	public void __update__model__element__name__(Map<Object, EObject> trace, boolean resolve) {
		try {
			// Set attribute value:
			String jName = (String) __get__java__name__().get(this.__java__object__);
			// TODO: Translate non-basic Java types.
			this.setName(jName);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets the 'main' references of the model element.
	 * 
	 * @param trace The trace of all Java objects to model elements.
	 * @param resolve True: Create referenced model elements. 
	 *                False: Creates a proxy object for referenced model element.
	 */
	public void __update__model__element__main__(Map<Object, EObject> trace, boolean resolve) {
		try {
			ch.seg.info.unibe.example.vod.Server jServer = (ch.seg.info.unibe.example.vod.Server) __get__java__main__().get(this.__java__object__);
			
			// Java reference exists?
			if (jServer != null) {
				// Translate reference to Java object:
				Server eServer = (Server) trace.get(jServer);

				// Create model element?
				if (eServer == null) {
					if (resolve) {
						eServer = ServerLink.__create__model__element__(jServer, trace, resolve);
					} else {
						// TODO: Create proxy InternalEObject.
					}
				}

				// Set model element:
				this.setMain(eServer);
			} else {
				this.setMain(null);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the 'mirror' references of the model element.
	 * 
	 * @param trace The trace of all Java objects to model elements.
	 * @param resolve True: Create referenced model elements. 
	 *                False: Creates a proxy object for referenced model element.
	 */
	public void __update__model__element__mirror__(Map<Object, EObject> trace, boolean resolve) {
		try {
			ch.seg.info.unibe.example.vod.Server jServer = (ch.seg.info.unibe.example.vod.Server) __get__java__mirror__().get(this.__java__object__);
			
			// Java reference exists?
			if (jServer != null) {
				// Translate reference to Java object:
				Server eServer = (Server) trace.get(jServer);

				// Create model element?
				if (eServer == null) {
					if (resolve) {
						eServer = ServerLink.__create__model__element__(jServer, trace, resolve);
					} else {
						// TODO: Create proxy InternalEObject.
					}
				}

				// Set model element:
				this.setMirror(eServer);
			} else {
				this.setMirror(null);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Sets the fields of the Java object.
	 * 
	 * @param resolve True: Create referenced Java objects.
	 *                False: Creates a proxy object for referenced model element.
	 */
	public void __update__java__object__(Map<Object, EObject> trace, boolean resolve) {
		// TODO: super.__update__java__object__(trace, resolve);
		__update__java__object__name__(trace, resolve);
		__update__java__object__main__(trace, resolve);
		__update__java__object__mirror__(trace, resolve);
	}
	
	/**
	 * Sets the field 'name' the Java object.
	 * 
	 * @param resolve True: Create referenced Java objects.
	 *                False: Creates a proxy object for referenced model element.
	 */
	public void __update__java__object__name__(Map<Object, EObject> trace, boolean resolve) {
		try {
			// Set Java object:
			String eName = getName();
			// TODO: Translate non-basic Java types.
			__get__java__name__().set(this.__get__java__object__(), eName);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the field 'main' the Java object.
	 * 
	 * @param resolve True: Create referenced Java objects.
	 *                False: Creates a proxy object for referenced model element.
	 */
	public void __update__java__object__main__(Map<Object, EObject> trace, boolean resolve) {
		try {
			// Translate reference to Java objects:
			Server eServer = getMain();
			ServerLink eServerLink = (ServerLink) eServer;
			ch.seg.info.unibe.example.vod.Server jServer = eServerLink.__get__java__object__();

			// Create model element?
			if (jServer == null) {
				if (resolve) {
					jServer = ServerLink.__create__java__object__(eServerLink, trace, resolve);
					eServerLink.__set__java__object__(jServer);
				} else {
					// TODO: Create Java proxy object.
				}
			}

			// Set Java object:
			__get__java__main__().set(this.__get__java__object__(), jServer);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the field 'mirror' the Java object.
	 * 
	 * @param resolve True: Create referenced Java objects.
	 *                False: Creates a proxy object for referenced model element.
	 */
	public void __update__java__object__mirror__(Map<Object, EObject> trace, boolean resolve) {
		try {
			// Translate reference to Java objects:
			Server eServer = getMirror();
			ServerLink eServerLink = (ServerLink) eServer;
			ch.seg.info.unibe.example.vod.Server jServer = eServerLink.__get__java__object__();

			// Create model element?
			if (jServer == null) {
				if (resolve) {
					jServer = ServerLink.__create__java__object__(eServerLink, trace, resolve);
					eServerLink.__set__java__object__(jServer);
				} else {
					// TODO: Create Java proxy object.
				}
			}

			// Set Java object:
			__get__java__mirror__().set(this.__get__java__object__(), jServer);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
