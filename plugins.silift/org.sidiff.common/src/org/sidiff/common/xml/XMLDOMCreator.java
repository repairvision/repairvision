package org.sidiff.common.xml;

import java.io.OutputStream;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.w3c.dom.*;

/**
 * Utility class for creating and handling DOM documents of XML files.
 */
public class XMLDOMCreator {

	/**
	 * Creates a DOM document.
	 * @return
	 */
	public static Document createDocument() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			return null;
		}
		return db.newDocument();
	}
	
	/**
	 * Writes the given DOM document into the given OutputStream.
	 * @param outputStream
	 * @param document
	 */
	public static void writeDocument(OutputStream outputStream, Document document) {
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(outputStream);
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Returns a string representation of the given node (in XML syntax). 
	 * @param node
	 * @return
	 */
	public static String writeToString(Node node) {
		StringBuffer buffer = new StringBuffer();
		writeToStringBuffer(buffer, node);
		return buffer.toString();
	}
	
	/**
	 * Returns a string representation of all child nodes of the given node (in XML syntax).
	 * It is surrounded by a container element if specified in the parameter optionalContainer.
	 * @param node
	 * @param optionalContainer name of the container element (null if no container element has to be created)
	 * @return
	 */
	public static String writeChildNodesToString(Node node, String optionalContainer) {
		StringBuffer buffer = new StringBuffer();
		if (optionalContainer!=null && !optionalContainer.trim().equals("")) {
			buffer.append("<");
			buffer.append(optionalContainer);
			buffer.append(">");
		}
		if (node.hasChildNodes()) {
			NodeList childs = node.getChildNodes();
			for (int i=0; i<childs.getLength(); i++)
				writeToStringBuffer(buffer, childs.item(i));
		}
		if (optionalContainer!=null && !optionalContainer.trim().equals("")) {
			buffer.append("</");
			buffer.append(optionalContainer);
			buffer.append(">");
		}
		return buffer.toString();
	}
	
	private static void writeToStringBuffer(StringBuffer buffer, Node node) {
		if (node.getNodeType()==3) {
			buffer.append(node.getTextContent());
			return;
		}
		buffer.append("<");
		buffer.append(node.getNodeName());
		if (node.hasAttributes()) {
			NamedNodeMap map = node.getAttributes();
			for (int i=0; i<map.getLength(); i++) {
				Node attr = map.item(i);
				buffer.append(" ");
				buffer.append(attr.getLocalName());
				buffer.append("=\"");
				buffer.append(attr.getNodeValue());
				buffer.append("\"");
			}
		}
		if (node.hasChildNodes()) {
			buffer.append(">");
			NodeList childs = node.getChildNodes();
			for (int i=0; i<childs.getLength(); i++)
				writeToStringBuffer(buffer, childs.item(i));
			buffer.append("</");
			buffer.append(node.getNodeName());
			buffer.append(">");
		} else {
			buffer.append("/>");
		}
	}
	
	static class DOMSerializerException extends SiDiffRuntimeException {
		private static final long serialVersionUID = -8802586857836471431L;
	}

}
