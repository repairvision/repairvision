package org.sidiff.common.crypto;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.SignatureException;
import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;

/**
 * A class which can verify XML documents which were signed with a XMLSigner.
 * 
 * @author mcguire
 * 
 */
@Deprecated
public class XMLVerifier {

	private boolean compareMD5s(ArrayList<String> a, ArrayList<String> b) {
		if (a.size() != b.size())
			return false;
		for (int i = 0; i < a.size(); i++)
			if (a.get(i).compareTo(b.get(i)) != 0)
				return false;
		return true;
	}

	private class XMLInfo {
		public boolean verified;
		ArrayList<String> xPaths;
		ArrayList<String> md5sFromSigInfo;

		public XMLInfo() {
			xPaths = new ArrayList<String>();
			md5sFromSigInfo = new ArrayList<String>();
		}
	}

	private XMLInfo processSignature(InputStream sigInfoStream, InputStream sigStream) throws IOException, InvalidKeyException {
		XMLInfo info = new XMLInfo();
		byte[] sigInfoBytes = CryptoUtil.readInputStream(sigInfoStream);

		Verifier verifier = new Verifier();
		boolean sigInfoOK = verifier.verify(new ByteArrayInputStream(sigInfoBytes), sigStream);
		info.verified = sigInfoOK;
		if (!sigInfoOK)
			return info;

		BufferedReader sigInfoReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sigInfoBytes)));
		for (;;) {
			String xPath = sigInfoReader.readLine();
			if (xPath == null)
				break;
			String md5 = sigInfoReader.readLine();
			assert (md5 != null);
			info.xPaths.add(xPath);
			info.md5sFromSigInfo.add(md5);
		}
		assert (info.xPaths.size() > 0);
		return info;
	}

	/**
	 * Tests if the signature info in the given signature info stream is valid and matches the given XML document stream content.
	 * 
	 * The signature info itself is signed, and it is also tested that the signature in the signature stream matches the content of the signature info stream.
	 * 
	 * This used the public key of the SignatureManager, so make sure the key is loaded first!
	 * 
	 * @param xmlStream
	 *            the stream which contains the XML document
	 * @param sigInfoStream
	 *            the stream which contains the signature information, i.e. the XPaths and their MD5 sums
	 * @param sigStream
	 *            the stream which contains the signature of the signature info stream
	 * 
	 * @return true if the signature is OK, false otherwise.
	 * 
	 * @throws IOException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 * @throws XPathExpressionException
	 */
	public boolean verifyXML(InputStream xmlStream, InputStream sigInfoStream, InputStream sigStream) throws IOException, InvalidKeyException, SignatureException, XPathExpressionException {
		XMLInfo info = processSignature(sigInfoStream, sigStream);
		if (!info.verified)
			return false;
		ArrayList<String> md5sFromFile = CryptoUtil.MD5SumsForXML(xmlStream, info.xPaths);
		return compareMD5s(info.md5sFromSigInfo, md5sFromFile);
	}

	/**
	 * Same as verifyXML(), only that this takes a Document, not an InputStream
	 */
	public boolean verifyDocument(Document document, InputStream sigInfoStream, InputStream sigStream) throws IOException, InvalidKeyException, SignatureException, XPathExpressionException {
		XMLInfo info = processSignature(sigInfoStream, sigStream);
		if (!info.verified)
			return false;
		ArrayList<String> md5sFromFile = CryptoUtil.MD5SumsForDocument(document, info.xPaths);
		return compareMD5s(info.md5sFromSigInfo, md5sFromFile);
	}

	/**
	 * Same as verifyXMLStream(), only that it operates on files instead.
	 */
	public boolean verifyXMLFile(String xmlFile, String sigInfoFile, String sigFile) throws InvalidKeyException, SignatureException, XPathExpressionException, IOException {
		FileInputStream xmlStream = new FileInputStream(xmlFile);
		FileInputStream sigInfoStream;
		FileInputStream sigStream;
		try {
			sigInfoStream = new FileInputStream(sigInfoFile);
			sigStream = new FileInputStream(sigFile);
		} catch (FileNotFoundException e) {
			return false;
		}

		return verifyXML(xmlStream, sigInfoStream, sigStream);
	}
}
