package org.sidiff.common.io;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.sidiff.common.collections.MapWithDefault;
import org.sidiff.common.io.internal.MapContentHandler;
import org.sidiff.common.xml.XMLParser;

/**
 * The SiDiffMapLoader provides a general map support. Static methods can be used for parsing maps from an XML doc. The instances of the {@link MapContentHandler}s are stored in a static map with the handler types as key.
 */
public class MapLoader {

	/**
	 * This map hold�s the instances of the {@link MapContentHandler} with unique types used as keys.
	 */
	private static final HashMap<String, MapContentHandler> contentHandlers = new HashMap<String, MapContentHandler>();

	/**
	 * Method add�s a given map to an existing or new instantiated {@link MapContentHandler} and after that parses further types from the given file.
	 * 
	 * @param type
	 *            Type of the content handler. e.g."DTD", "NodeTypes", and so on.
	 * @param map
	 *            Map to be added to the {@link MapContentHandler}.
	 * @param dataFile
	 *            File inheriting an XML document.
	 */
	public static void parseMapFromStream(String type, Map<String, String> map, InputStream stream) {
		MapContentHandler cHandler = null;
		if (contentHandlers.containsKey(type)) {
			cHandler = contentHandlers.get(type);
		} else {
			cHandler = new MapContentHandler(type);
			contentHandlers.put(type, cHandler);
		}
		cHandler.putMap(map);
		XMLParser.parseStream(stream, cHandler);
	}

	/**
	 * Method parses a file containing an XML doc to an existing or new instantiated {@link MapContentHandler}. Method return�s the filled map.
	 * 
	 * @param type
	 *            Type of the content handler. e.g."DTD", "NodeTypes", and so on.
	 * @param dataFile
	 *            File inheriting an XML document.
	 * @return Method return�s the filled map.
	 */
	public static Map<String, String> parseMapFromStream(String type, InputStream stream) {
		MapContentHandler cHandler = null;
		if (contentHandlers.containsKey(type)) {
			cHandler = contentHandlers.get(type);
		} else {
			cHandler = new MapContentHandler(type);
			contentHandlers.put(type, cHandler);
		}
		Map<String, String> map = new MapWithDefault<String, String>(new HashMap<String, String>());
		cHandler.putMap(map);
		XMLParser.parseStream(stream, cHandler);
		return map;
	}

}// SiDiffMapLoader
