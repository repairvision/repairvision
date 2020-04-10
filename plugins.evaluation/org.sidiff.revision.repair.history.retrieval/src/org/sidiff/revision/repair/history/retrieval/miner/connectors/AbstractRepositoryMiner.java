package org.sidiff.revision.repair.history.retrieval.miner.connectors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource.URIHandler;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.sidiff.revision.repair.history.retrieval.miner.data.ModelVersion;
import org.sidiff.revision.repair.history.retrieval.util.HistoryUtil;

public abstract class AbstractRepositoryMiner implements IRepositoryMiner {
	
	protected int retries = 10;
	
	protected Document mineURL(String url) {
		Document doc = null;
		Exception exception = null;
		
		for (int i = 0; i < retries; i++) {
			try {
				doc = Jsoup.connect(url).get();
				
				exception = null;
				break;
			} catch (Exception e) {
				exception = e;
			}
		}
		
		if (exception != null) {
			exception.printStackTrace();
			System.err.println("Exception: " + url);
		}
		
		return doc;
	}
	
	@Override
	public List<ModelVersion> mineHistory(String repositoryURL, String remotePath) {
		
		List<ModelVersion> versions = null;
		Exception exception = null;
		
		for (int i = 0; i < retries; i++) {
			try {
				versions = internal_mineHistory(getHistoryURL(repositoryURL, remotePath), remotePath);
				
				exception = null;
				break;
			} catch (Exception e) {
				exception = e;
			}
		}
		
		if (exception != null) {
			exception.printStackTrace();
			System.err.println("Exception: " + repositoryURL + remotePath);
		}
		
		return versions;
	}

	@Override
	public void mineVersion(String repositoryURL, String remotePath, String commit, String localPath) throws FileNotFoundException, Exception {
		String plainTextVersionURL = getVersionURL(repositoryURL, remotePath, commit);
		Exception exception = null;
		
		for (int i = 0; i < retries; i++) {
			try {
				
				//Open a URL Stream
//				Response response = Jsoup.connect(plainTextVersionURL).ignoreContentType(true).execute();
//				String model = new String(response.bodyAsBytes());
		        
				URL file = new URL(plainTextVersionURL);
				ReadableByteChannel rbc = Channels.newChannel(file.openStream());
				File outputFile = new File(localPath);
				outputFile.getParentFile().mkdirs();
				outputFile.createNewFile();

				FileOutputStream fos = new FileOutputStream(outputFile);
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
				fos.close();
				
				// try to load model without exceptions:
				URIHandler uriHandler = new URIHandlerImpl() {
					public URI resolve(URI uri) {
						return uri;
					}
					public URI deresolve(URI uri) {
						return uri;
					}
				};
				
				HistoryUtil.load(new ResourceSetImpl(), URI.createFileURI(outputFile.getAbsolutePath()), uriHandler);
				
				exception = null;
				break;
			} catch (FileNotFoundException fnfe) {
				throw fnfe;
			} catch (Exception e) {
				exception = e;
			}
		}

		if (exception != null) {
			throw exception;
		}
	}
	
	protected abstract List<ModelVersion> internal_mineHistory(String historyURL, String remotePath);
}
