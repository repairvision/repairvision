package org.sidiff.common.xml;

import java.io.*;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.common.io.IOUtil;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.xml.sax.InputSource;

/**
 * Utility class to transform XML documents.
 */
public class XMLTransformer {

	/**
	 * Transforms the given XML input stream with the given XSLT and returns the transformation result as a new input stream.
	 * @param xmlDataStream
	 * @param xsltData
	 * @return
	 */
	public static InputStream transform(InputStream xmlDataStream, InputStream xsltData) {
		StringWriter result = new StringWriter();
		transform(new InputSource(xmlDataStream), new StreamResult(result), new InputSource(xsltData));
		return IOUtil.getInputStreamFromString(result.toString());
	}
	
	/**
	 * Transforms the given XML input stream with the given XSLT and returns the transformation result as a new input stream.
	 * The transformation result is also written to the file system.
	 * @param xmlDataStream
	 * @param xsltData
	 * @return
	 */
	public static InputStream transformUsingTempfile(InputStream xmlDataStream, InputStream xsltData) {
		File tmpfile= null;
		try {
			tmpfile = File.createTempFile(xmlDataStream.hashCode()+"", ".xml");
		} catch (IOException e) {}
		StringWriter result = new StringWriter();
		transform(new InputSource(xmlDataStream), new StreamResult(result), new InputSource(xsltData));
		try {
			Writer mout = new OutputStreamWriter(IOUtil.getOutputStreamIntoFile(tmpfile.getAbsolutePath()));
			mout.write(result.toString());
			mout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return IOUtil.getInputStreamFromFile(tmpfile.getAbsolutePath());
	}
	
	private static void transform(InputSource source, Result result, InputSource transformScript) {

		TransformerFactory tFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = tFactory.newTransformer(new SAXSource(transformScript));
			// Benoetigt um Referenzen im Transformationsskript aufzuloesen (auch in dort geladenen Dokumenten)
			transformer.setURIResolver(XMLResolver.getInstance());
			LogUtil.log(LogEvent.NOTICE, "Using Transformer " + transformer.getClass().getName());

			SAXSource saxSource = new SAXSource(XMLParser.createSAXParser(), source);
			transformer.transform(saxSource, result);

		} catch (Exception e) {
			throw new SiDiffRuntimeException(XMLTransformer.class, "Error while transforming document!", e);
		}
	}
}
