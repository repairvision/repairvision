package org.sidiff.common.io.internal;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.common.collections.MapWithDefault;
import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.xml.sax.*;

/**
 * ContentHandler to load a map of key-value-pairs.
 * Used by the XMLResolver to load mappings from DTD urls to internal resource files.
 */
public class MapContentHandler implements ContentHandler {

	// static variables used for parsing
	private static final String ELEM_MAP = "Map";
	private static final String ATT_MAP_TYPE = "type";

	private static final String ELEM_MAPENTRY = "MapEntry";
	private static final String ATT_MAPENTRY_KEY = "key";
	private static final String ATT_MAPENTRY_VALUE = "value";

	public static final String DEFAULT_VALUE_KEY = "*";

	// *************************************************************************

	// local variables
	private String mapType;
	private Map<String, String> map;

	/**
	 * Constructor.
	 * 
	 * @param type
	 *            The unique type to be set for this content handler.
	 */
	public MapContentHandler(String type) {
		this.mapType = type;
		this.map = new HashMap<String, String>();
	}

	/**
	 * Method add�s a given map, to the local existing one.
	 * 
	 * @param map
	 *            Map to be added.
	 */
	public void putMap(Map<String, String> map) {
		this.map = map;
	}

	/**
	 * @see org.xml.sax.ContentHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	public void startElement(String uri, String localName, String name, Attributes atts) throws SAXException {
		if (localName.equalsIgnoreCase(ELEM_MAP)) {
			checkMapType(atts);
		} else if (localName.equalsIgnoreCase(ELEM_MAPENTRY)) {
			processMapEntry(atts);
		}
	}

	/**
	 * Method parses an map entry from the XML source to the local map.
	 * 
	 * @param atts
	 *            Attributes of a map entry.
	 */
	@SuppressWarnings("unchecked")
	private void processMapEntry(Attributes atts) {

		if (DEFAULT_VALUE_KEY.equals(atts.getValue(ATT_MAPENTRY_KEY))) {
			// Wildcat
			if (this.map instanceof MapWithDefault) {
				((MapWithDefault<String, String>) this.map).setDefaultValue(atts.getValue(ATT_MAPENTRY_VALUE));
				assert(LogUtil.log(LogEvent.DEBUG, "Following entry was added:" + "default ,value:" + atts.getValue(ATT_MAPENTRY_VALUE)));
				return;
			} else {
				assert(LogUtil.log(LogEvent.DEBUG, "Default key '" + DEFAULT_VALUE_KEY + "' occured, but map does not Support default!"));
			}
		}

		this.map.put(atts.getValue(ATT_MAPENTRY_KEY), atts.getValue(ATT_MAPENTRY_VALUE));
		assert(LogUtil.log(LogEvent.DEBUG, "Following entry was added:" + "key:" + atts.getValue(ATT_MAPENTRY_KEY) + ",value:" + atts.getValue(ATT_MAPENTRY_VALUE)));
	}

	/**
	 * Method check�s whether the parsed type equals the type of this content handler.
	 * 
	 * @param atts
	 *            The type attribute set for this XML file.
	 */
	private void checkMapType(Attributes atts) {

		if (!mapType.equals(atts.getValue(ATT_MAP_TYPE))) {
			throw new SiDiffRuntimeException("Cannot load map! Reason: Type of this map (" + mapType + ") does not equal the the permitted type (" + atts.getValue(ATT_MAP_TYPE) + ").");
		}
	}

	/**
	 * @see org.xml.sax.ContentHandler#endDocument()
	 */
	public void endDocument() throws SAXException {
		this.map = null;
	}

	// Following the unused method stubs of the ContentHandler interface.
	public void endElement(String uri, String localName, String name) throws SAXException {
	}

	public void startDocument() throws SAXException {

	}

	public void characters(char[] ch, int start, int length) throws SAXException {
	}

	public void endPrefixMapping(String prefix) throws SAXException {
	}

	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
	}

	public void processingInstruction(String target, String data) throws SAXException {
	}

	public void setDocumentLocator(Locator locator) {
	}

	public void skippedEntity(String name) throws SAXException {
	}

	public void startPrefixMapping(String prefix, String uri) throws SAXException {
	}

}// SiDiffMapContentHandler
