package org.sidiff.common.crypto;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.SignatureException;
import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

import org.sidiff.common.xml.XMLDOMCreator;
import org.w3c.dom.Document;

/**
 * A class which can sign subsets of XML documents.
 * 
 * @author mcguire
 * 
 */
@Deprecated
public class XMLSigner {

	private ArrayList<String> mXPaths;

	public XMLSigner() {
		mXPaths = new ArrayList<String>();
	}

	/**
	 * Clears the list of XPaths.
	 */
	private void reset() {
		mXPaths.clear();
	}

	/**
	 * Adds an XPath to the list of XPaths which will be used in the signing process. This has to be called at least once.
	 * 
	 * XPaths act as a filter on the XML document.
	 * 
	 * @param xPath
	 *            the XPath to add.
	 */
	public void addXPathToSign(String xPath) {
		mXPaths.add(xPath);
	}

	/**
	 * Signs part of the XML document given in the input stream. The parts to sign are defined by the XPaths given to addXPathToSign(). For each XPath, a MD5 sum of the matched nodes is calculated. The XPaths together with their MD5 sums are stored in the
	 * signature info stream. The signature info itself is signed, and the signature written to the signature stream.
	 * 
	 * This uses the private key of the SignatureManager, so make sure the key is loaded!
	 * 
	 * @param XMLToSign
	 *            the stream which contains the XML document to be signed.
	 * @param sigInfoStream
	 *            the stream to which the signature information is written to
	 * @param signatureStream
	 *            the stream to which the signature of the signature information is written to
	 * 
	 * @throws IOException
	 * @throws InvalidKeyException
	 * @throws XPathExpressionException
	 * @throws SignatureException
	 */
	public void signXML(InputStream XMLToSign, OutputStream sigInfoStream, OutputStream signatureStream) throws IOException, InvalidKeyException, XPathExpressionException, SignatureException {
		assert (!mXPaths.isEmpty());

		ArrayList<String> md5Sums = CryptoUtil.MD5SumsForXML(XMLToSign, mXPaths);
		XMLToSign.close();
		assert (md5Sums.size() == mXPaths.size());

		ByteArrayOutputStream sigInfoByteStream = new ByteArrayOutputStream();
		BufferedWriter sigInfoWriter = new BufferedWriter(new OutputStreamWriter(sigInfoByteStream));
		for (int i = 0; i < mXPaths.size(); i++) {
			sigInfoWriter.write(mXPaths.get(i));
			sigInfoWriter.newLine();
			sigInfoWriter.write(md5Sums.get(i));
			sigInfoWriter.newLine();
		}
		sigInfoWriter.close();

		sigInfoStream.write(sigInfoByteStream.toByteArray());
		sigInfoStream.close();

		Signer signer = new Signer();
		ByteArrayInputStream sigBytesInputStream = new ByteArrayInputStream(sigInfoByteStream.toByteArray());
		signer.sign(sigBytesInputStream, signatureStream);

		reset();
	}

	/**
	 * Same as signXML(), only that this takes a Document, not an InputStream.
	 */
	public void signDocument(Document document, OutputStream sigInfoStream, OutputStream signatureStream) throws InvalidKeyException, XPathExpressionException, SignatureException, IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		XMLDOMCreator.writeDocument(outputStream, document);
		signXML(new ByteArrayInputStream(outputStream.toByteArray()), sigInfoStream, signatureStream);
	}

	/**
	 * Same as signXMLStream(), only that this operates on files.
	 */
	public void signXMLFile(String xmlFile, String sigInfoFile, String sigFile) throws InvalidKeyException, SignatureException, XPathExpressionException, FileNotFoundException, IOException {
		signXML(new FileInputStream(xmlFile), new FileOutputStream(sigInfoFile), new FileOutputStream(sigFile));
	}
}
