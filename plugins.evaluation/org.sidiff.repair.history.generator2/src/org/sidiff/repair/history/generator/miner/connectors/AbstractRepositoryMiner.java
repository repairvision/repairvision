package org.sidiff.repair.history.generator.miner.connectors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public abstract class AbstractRepositoryMiner implements IRepositoryMiner {

	public void mineVersion(String repositoryURL, String remotePath, String commit, String localPath) throws FileNotFoundException {
		String plainTextVersionURL = getVersionURL(repositoryURL, remotePath, commit);
		
		int retries = 10;
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
				
				break;
			} catch (FileNotFoundException fnfe) {
				throw fnfe;
			} catch (Exception e) {
				exception = e;
			}
		}

		if (exception != null) {
			exception.printStackTrace();
			System.err.println("Exception: " + plainTextVersionURL);
		}
	}
}
