package ch.seg.info.unibe.example.vod.link;

import java.lang.reflect.Field;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import default_.ch.seg.info.unibe.example.vod.Video;
import default_.ch.seg.info.unibe.example.vod.impl.UserImpl;

public class UserLink extends UserImpl {

	/**
	 * The declared Java field: {@link ch.seg.info.unibe.example.vod.User}::open
	 */
	private static Field __java__open__;
	
	/**
	 * The declared Java field: {@link ch.seg.info.unibe.example.vod.User}::name
	 */
	private static Field __java__name__;
	
	/**
	 * The corresponding Java 'Server' object.
	 */
	private ch.seg.info.unibe.example.vod.User __java__object__;
	
	/**
	 * @return The declared Java field: {@link ch.seg.info.unibe.example.vod.User}::open
	 */
	public static Field __get__java__open__() {
		if (__java__open__ == null) {
			try {
				Class<ch.seg.info.unibe.example.vod.User> jClass = ch.seg.info.unibe.example.vod.User.class;
				UserLink.__java__open__ = jClass.getDeclaredField("open");
				__java__open__.setAccessible(true);
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return __java__open__;
	}
	
	/**
	 * @return The declared Java field: {@link ch.seg.info.unibe.example.vod.User}::name
	 */
	public static Field __get__java__name__() {
		if (__java__name__ == null) {
			try {
				Class<ch.seg.info.unibe.example.vod.User> jClass = ch.seg.info.unibe.example.vod.User.class;
				UserLink.__java__name__ = jClass.getDeclaredField("name");
				__java__name__.setAccessible(true);
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return __java__name__;
	}
	
	/**
	 * @return The corresponding Java 'User' object.
	 */
	public ch.seg.info.unibe.example.vod.User __get__java__object__() {
		return __java__object__;
	}

	/**
	 * @param __java__object__ The corresponding Java 'User' object.
	 */
	public void __set__java__object__(ch.seg.info.unibe.example.vod.User __java__object__) {
		this.__java__object__ = __java__object__;
	}

	/**
	 * @param jUser The Java 'User' object.
	 * @param trace   The trace of all Java objects to model elements.
	 * @param resolve True: Create referenced model elements. 
	 *                False: Creates a proxy object for referenced model element.
	 * @return The translated model element.
	 */
	public static UserLink __create__model__element__(ch.seg.info.unibe.example.vod.User jUser, Map<Object, EObject> trace, boolean resolve) {
		assert !trace.containsKey(jUser) : "Model element already exists!";
		
		UserLink eUser = new UserLink();
		trace.put(jUser, eUser);
		eUser.__set__java__object__(jUser);
		eUser.__update__model__element__(trace, resolve);
		return eUser;
	}
	
	/**
	 * @param eUser The 'Server' model element.
	 * @param trace   The trace of all Java objects to model elements.
	 * @param resolve True: Create referenced Java objects. 
	 *                False: Creates a proxy object for referenced Java object.
	 * @return The translated Java object.
	 */
	public static ch.seg.info.unibe.example.vod.User __create__java__object__(UserLink eUser, Map<Object, EObject> trace, boolean resolve) {
		// Initialize object with default values.
		// TODO: Do domain-specific adjustments...
		ch.seg.info.unibe.example.vod.User jUser = new ch.seg.info.unibe.example.vod.User(null);
		trace.put(jUser, eUser);
		eUser.__set__java__object__(jUser);
		eUser.__update__java__object__(trace, resolve);
		return jUser;
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
		__update__model__element__open__(trace, resolve);
		__update__model__element__name__(trace, resolve);
	}
	
	/**
	 * Sets the 'open' reference of the model element.
	 * 
	 * @param trace The trace of all Java objects to model elements.
	 * @param resolve True: Create referenced model elements. 
	 *                False: Creates a proxy object for referenced model element.
	 */
	public void __update__model__element__open__(Map<Object, EObject> trace, boolean resolve) {
		try {
			ch.seg.info.unibe.example.vod.Video jVideo = (ch.seg.info.unibe.example.vod.Video) __get__java__open__().get(this.__java__object__);
			
			// Java reference exists?
			if (jVideo != null) {
				// Translate reference to Java object:
				Video eVideo = (Video) trace.get(jVideo);

				// Create model element?
				if (eVideo == null) {
					if (resolve) {
						eVideo = VideoLink.__create__model__element__(jVideo, trace, resolve);
					} else {
						// TODO: Create proxy InternalEObject.
					}
				}

				// Set model element:
				this.setOpen(eVideo);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
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
	 * Sets the fields of the Java object.
	 * 
	 * @param resolve True: Create referenced Java objects.
	 *                False: Creates a proxy object for referenced model element.
	 */
	public void __update__java__object__(Map<Object, EObject> trace, boolean resolve) {
		// TODO: super.__update__java__object__(trace, resolve);
		__update__java__object__open__(trace, resolve);
		__update__java__object__name__(trace, resolve);
	}
	
	/**
	 * Sets the field 'open' the Java object.
	 * 
	 * @param resolve True: Create referenced Java objects.
	 *                False: Creates a proxy object for referenced model element.
	 */
	public void __update__java__object__open__(Map<Object, EObject> trace, boolean resolve) {
		try {
			// Translate reference to Java objects:
			Video eVideo = getOpen();
			VideoLink eVideoLink = (VideoLink) eVideo;
			ch.seg.info.unibe.example.vod.Video jVideo = eVideoLink.__get__java__object__();

			// Create Java object?
			if (jVideo == null) {
				if (resolve) {
					jVideo = VideoLink.__create__java__object__(eVideoLink, trace, resolve);
					eVideoLink.__set__java__object__(jVideo);
				} else {
					// TODO: Create Java proxy object.
				}
			}

			// Set Java object:
			__get__java__open__().set(this.__get__java__object__(), jVideo);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
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
}
