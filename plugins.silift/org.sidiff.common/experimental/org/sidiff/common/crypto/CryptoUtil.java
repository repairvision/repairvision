package org.sidiff.common.crypto;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

/**
 * Various static utility functions used throughout this package.
 * 
 * @author mcguire
 * 
 * Completely untested and currently not used.
 */
@Deprecated 
public class CryptoUtil {

	private static final String DIGEST_ALGO = "MD5";

	/**
	 * Converts a byte array to a readable hex string
	 * 
	 * @param byteArray
	 *            the byte array to convert
	 * @return a readable hex string
	 */
	static String byteArrayToHexString(byte[] byteArray) {
		StringBuffer sb = new StringBuffer(byteArray.length * 2);
		for (int i = 0; i < byteArray.length; i++) {
			int v = byteArray[i] & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase();
	}

	private static String XMLStringFromNode(Node node) {
		String result = "";
		switch (node.getNodeType()) {
		case Node.ATTRIBUTE_NODE:
			result += ((Attr) node).getName() + "=" + ((Attr) node).getValue();
			result += "\n";
			break;
		case Node.ELEMENT_NODE:
			result += ((Element) node).getTagName();
			result += "\n";
			break;
		// TODO ?? Discuss: Support more types? (Sw, 27.10.08)
		}
		result += node.getTextContent();

		NamedNodeMap attributes = node.getAttributes();
		if (attributes != null)
			for (int i = 0; i < attributes.getLength(); i++) {
				result += XMLStringFromNode(attributes.item(i));
			}

		NodeList children = node.getChildNodes();
		if (children != null)
			for (int i = 0; i < children.getLength(); i++) {
				result += XMLStringFromNode(children.item(i));
			}
		return result;
	}

	private static String md5SumForNodeList(NodeList nodes) {
		String XML = "";
		for (int curNode = 0; curNode < nodes.getLength(); curNode++) {
			XML += XMLStringFromNode(nodes.item(curNode));
		}
		// System.out.println("XML for XPath " + xPathString + ":\n" + XML);

		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance(DIGEST_ALGO);
			byte[] md5Bytes = digest.digest(XML.getBytes());
			return CryptoUtil.byteArrayToHexString(md5Bytes);
		} catch (NoSuchAlgorithmException e) {
			// Should never happen
			assert (false);
			return "";
		}
	}

	/**
	 * For each given XPath, this function calculates the MD5 checksum of the nodes of the XML document that match the XPath.
	 * 
	 * @param XMLInputStream
	 *            the input XML document
	 * @param xPaths
	 *            a list of XPaths to calculate the MD5 sum for
	 * @return a list of Strings. Each list entry is the MD5 sum of one of the XPaths which were given as parameters.
	 * @throws XPathExpressionException
	 * @throws IOException
	 */
	public static ArrayList<String> MD5SumsForXML(InputStream XMLInputStream, ArrayList<String> xPaths) throws XPathExpressionException, IOException {
		ArrayList<String> md5s = new ArrayList<String>();
		byte[] xmlBytes = CryptoUtil.readInputStream(XMLInputStream);
		assert (xmlBytes.length > 0);

		for (int curXPath = 0; curXPath < xPaths.size(); curXPath++) {
			String xPathString = xPaths.get(curXPath);
			XPath xpath = XPathFactory.newInstance().newXPath();
			InputSource inputSource = new InputSource(new ByteArrayInputStream(xmlBytes));
			NodeList nodes = (NodeList) xpath.evaluate(xPathString, inputSource, XPathConstants.NODESET);

			md5s.add(md5SumForNodeList(nodes));
		}
		return md5s;
	}

	/**
	 * Same as MD5SumsForXML(), only that it takes a Document, not an InputStream.
	 */
	public static ArrayList<String> MD5SumsForDocument(Document document, ArrayList<String> xPaths) throws XPathExpressionException {
		ArrayList<String> md5s = new ArrayList<String>();

		for (int curXPath = 0; curXPath < xPaths.size(); curXPath++) {
			String xPathString = xPaths.get(curXPath);
			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList nodes = (NodeList) xpath.evaluate(xPathString, document, XPathConstants.NODESET);

			md5s.add(md5SumForNodeList(nodes));
		}
		return md5s;
	}

	/**
	 * Reads the entire content of the input stream and saves it into a byte array.
	 * 
	 * @param inputStream
	 *            the input stream to read from
	 * @return the byte array which has the content of the input stream
	 * @throws IOException
	 */
	public static byte[] readInputStream(InputStream inputStream) throws IOException {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		while (true) {
			byte[] keyBuffer = new byte[1024];
			int amountRead = inputStream.read(keyBuffer);
			if (amountRead == -1)
				break;
			byteStream.write(keyBuffer, 0, amountRead);
		}
		inputStream.close();
		return byteStream.toByteArray();
	}
}
