package ch.seg.info.unibe.example.vod.link;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import default_.ch.seg.info.unibe.example.vod.Video;
import default_.ch.seg.info.unibe.example.vod.impl.ServerImpl;

public class ServerLink extends ServerImpl {
	
	/**
	 * The declared Java field: {@link ch.seg.info.unibe.example.vod.Server}::name
	 */
	private static Field __java__name__;

	/**
	 * The declared Java field: {@link ch.seg.info.unibe.example.vod.Server}::videos
	 */
	private static Field __java__videos__;
	
	/**
	 * The corresponding Java 'Server' object.
	 */
	private ch.seg.info.unibe.example.vod.Server __java__object__;
	
	/**
	 * @return The declared Java field: {@link ch.seg.info.unibe.example.vod.User}::name
	 */
	public static Field __get__java__name__() {
		if (__java__name__ == null) {
			try {
				Class<ch.seg.info.unibe.example.vod.Server> jClass = ch.seg.info.unibe.example.vod.Server.class;
				ServerLink.__java__name__ = jClass.getDeclaredField("name");
				__java__name__.setAccessible(true);
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return __java__name__;
	}
	
	/**
	 * @return The declared Java field: {@link ch.seg.info.unibe.example.vod.Server}::videos
	 */
	public static Field __get__java__videos__() {
		if (__java__videos__ == null) {
			try {
				Class<ch.seg.info.unibe.example.vod.Server> jClass = ch.seg.info.unibe.example.vod.Server.class;
				ServerLink.__java__videos__ = jClass.getDeclaredField("videos");
				__java__videos__.setAccessible(true);
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return __java__videos__;
	}
	
	/**
	 * @return The corresponding Java 'Server' object.
	 */
	public ch.seg.info.unibe.example.vod.Server __get__java__object__() {
		return __java__object__;
	}

	/**
	 * @param __java__object__ The corresponding Java 'Server' object.
	 */
	public void __set__java__object__(ch.seg.info.unibe.example.vod.Server __java__object__) {
		this.__java__object__ = __java__object__;
	}

	/**
	 * @param jServer The Java 'Server' object.
	 * @param trace   The trace of all Java objects to model elements.
	 * @param resolve True: Create referenced model elements. 
	 *                False: Creates a proxy object for referenced model element.
	 * @return The translated model element.
	 */
	public static ServerLink __create__model__element__(ch.seg.info.unibe.example.vod.Server jServer, Map<Object, EObject> trace, boolean resolve) {
		assert !trace.containsKey(jServer) : "Model element already exists!";
		
		ServerLink eServer = new ServerLink();
		trace.put(jServer, eServer);
		eServer.__set__java__object__(jServer);
		eServer.__update__model__element__(trace, resolve);
		return eServer;
	}
	
	/**
	 * @param eServer The 'Server' model element.
	 * @param trace   The trace of all Java objects to model elements.
	 * @param resolve True: Create referenced Java objects. 
	 *                False: Creates a proxy object for referenced Java object.
	 * @return The translated Java object.
	 */
	public static ch.seg.info.unibe.example.vod.Server __create__java__object__(ServerLink eServer, Map<Object, EObject> trace, boolean resolve) {
		// Initialize object with default values.
		// TODO: Do domain-specific adjustments...
		ch.seg.info.unibe.example.vod.Server jServer = new ch.seg.info.unibe.example.vod.Server(null);
		trace.put(jServer, eServer);
		eServer.__set__java__object__(jServer);
		eServer.__update__java__object__(trace, resolve);
		return jServer;
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
		__update__model__element__videos__(trace, resolve);
	}
	
	/**
	 * Sets the 'videos' references of the model element.
	 * 
	 * @param trace The trace of all Java objects to model elements.
	 * @param resolve True: Create referenced model elements. 
	 *                False: Creates a proxy object for referenced model element.
	 */
	@SuppressWarnings("unchecked")
	public void __update__model__element__videos__(Map<Object, EObject> trace, boolean resolve) {
		try {
			Object jVideos = __get__java__videos__().get(this.__java__object__);
			
			// FIXME: Initialize Java List
			
			// Java reference exists?
			if (jVideos != null) {
				// Translate list of Java objects:
				// TODO: Generalize to Collections!
				List<ch.seg.info.unibe.example.vod.Video> jListVideos = (List<ch.seg.info.unibe.example.vod.Video>) jVideos;
				int i = 0;
				
				for (ch.seg.info.unibe.example.vod.Video jVideo : jListVideos) {
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
					if (this.getVideos().size() <= i) {
						// Insert model element:
						this.getVideos().add(eVideo);
					} else {
						Video oldVideo = this.getVideos().get(i);
						
						if (oldVideo != eVideo) {
							// Update model element:
							this.getVideos().set(i, eVideo);
						}
					}
					
					++i;
				}
				
				// Remove elements:
				if (jListVideos.size() > this.getVideos().size()) {
					// Trim list to size:
					jListVideos.subList(this.getVideos().size(), jListVideos.size() - 1).clear();
				}
			} else {
				this.getVideos().clear();
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
		__update__java__object__name__(trace, resolve);
		__update__java__object__videos__(trace, resolve);
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
	 * Sets the field 'videos' the Java object.
	 * 
	 * @param resolve True: Create referenced Java objects.
	 *                False: Creates a proxy object for referenced model element.
	 */
	@SuppressWarnings("unchecked")
	public void __update__java__object__videos__(Map<Object, EObject> trace, boolean resolve) {
		try {
			// Translate list of Java objects:
			// TODO: Generalize to Collections!
			List<ch.seg.info.unibe.example.vod.Video> jListVideos = (List<ch.seg.info.unibe.example.vod.Video>) __get__java__videos__().get(this.__get__java__object__());
			int i = 0;

			for (Video eVideo : getVideos()) {
				VideoLink eVideoLink = (VideoLink) eVideo;
				ch.seg.info.unibe.example.vod.Video jVideo = eVideoLink.__get__java__object__();

				// Create model element?
				if (jVideo == null) {
					if (resolve) {
						jVideo = VideoLink.__create__java__object__(eVideoLink, trace, resolve);
						eVideoLink.__set__java__object__(jVideo);
					} else {
						// TODO: Create Java proxy object.
					}
				}

				// Set Java object:
				if (jListVideos.size() <= i) {
					// Insert model element:
					jListVideos.add(jVideo);
				} else {
					ch.seg.info.unibe.example.vod.Video oldVideo = jListVideos.get(i);

					if (oldVideo != eVideo) {
						// Update model element:
						jListVideos.set(i, jVideo);
					}
				}

				++i;
			}
			
			// Remove elements:
			if (this.getVideos().size() > jListVideos.size()) {
				// Trim list to size:
				this.getVideos().subList(jListVideos.size(), this.getVideos().size() - 1).clear();
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
