package org.sidiff.repair.history.generator.miner.connectors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.sidiff.repair.history.generator.metadata.HistoryMetadata;
import org.sidiff.repair.history.generator.miner.data.ModelVersion;

public class GitHubComMiner implements IRepositoryMiner {
	
	private static final String PROTOCOL = "github.com";
	
	private static final String URL_LOG = "/commits/master/";
	
	private static final String URL_ID = "/tree/";
	
	private static final String URL_PLAIN = "raw.githubusercontent.com";
	
	private static final DateFormat DATE_ISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// TEST:
		IRepositoryMiner miner = new GitHubComMiner();
		
		String repositoryURL = "https://github.com/eclipse/elk";
		String fileURL = "/plugins/org.eclipse.elk.graph/model/elkgraph.ecore";
		
		
		 List<ModelVersion> versions = miner.mineHistory(repositoryURL, fileURL);
		 
		for (ModelVersion modelVersion : versions) {
			System.out.println(modelVersion);
			System.out.println();
			
			miner.mineVersion(repositoryURL, modelVersion.getRemotePath(), modelVersion.getCommit(), "C:\\" + fileURL);
			
			System.out.println();
		}
	}
	
	@Override
	public boolean supports(String repositoryURL) {
		return (repositoryURL.startsWith("http://" + PROTOCOL) || repositoryURL.startsWith("https://" + PROTOCOL));
	}
	
	@Override
	public String getHistoryURL(String repositoryURL, String remotePath) {
		return repositoryURL + URL_LOG + remotePath;
	}
	
	@Override
	public List<ModelVersion> mineHistory(String repositoryURL, String remotePath) {
		return internal_mineHistory(getHistoryURL(repositoryURL, remotePath), remotePath);
	}

	private List<ModelVersion> internal_mineHistory(String fullURL, String fileURL) {
		List<ModelVersion> versions = new ArrayList<>();
		
		try {
			Document doc = Jsoup.connect(fullURL).get();
			Elements links = doc.body().select("a[href]");
			
			for (Element link : links) {
				String versionURL = link.attr("href");
				
				if (versionURL.contains(URL_ID)) {
//					System.out.println(versionURL);
					
					String commit = versionURL.substring(versionURL.lastIndexOf(URL_ID) + URL_ID.length());
//					System.out.println("commit: " + commit);

					Date parsedDate = DATE_ISO8601.parse(link.parent().parent().selectFirst("relative-time").attr("datetime"));
					String date = HistoryMetadata.DATE_ISO8601.format(parsedDate);
//					System.out.println("date: " + date);
					
					String message = link.parent().parent().children().get(0).children().get(0).selectFirst("a[title]").attr("title");
//					System.out.println("message: " + message);
					
					String author = link.parent().parent().selectFirst("relative-time").parent().children().get(0).text();
//					System.out.println("author: " + author);
					
					ModelVersion modelVersion = new ModelVersion(fileURL, commit, date, message, author);
					versions.add(modelVersion);
				}
			}
			
			// Lookup next log page:
			Elements logLinks = doc.body().select("div[class='pagination']").select("a[href]");
			
			for (Element logLink : logLinks) {
				String logURL = logLink.attr("href");
				
				if (logURL.contains("?after=")) {
					versions.addAll(internal_mineHistory(logURL, fileURL));
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception while reading history log: " + fullURL);
		}
		
		return versions;
	}
	
	@Override
	public String getVersionURL(String repositoryURL, String remotePath, String commit) {
		return repositoryURL.replaceFirst(PROTOCOL, URL_PLAIN) + "/" + commit + "/" + remotePath;
	}

	@Override
	public void mineVersion(String repositoryURL, String remotePath, String commit, String localPath) throws FileNotFoundException {
		String plainTextVersionURL = "n/a";
		
		try {
			plainTextVersionURL = getVersionURL(repositoryURL, remotePath, commit);
//			System.out.println(plainTextVersionURL);
			
			//Open a URL Stream
//			Response response = Jsoup.connect(plainTextVersionURL).ignoreContentType(true).execute();
//			return new String(response.bodyAsBytes());
			
			URL file = new URL(plainTextVersionURL);
			ReadableByteChannel rbc = Channels.newChannel(file.openStream());
			File outputFile = new File(localPath);
			outputFile.getParentFile().mkdirs();
			outputFile.createNewFile();

			FileOutputStream fos = new FileOutputStream(outputFile);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
		} catch (FileNotFoundException fnfe) {
			throw fnfe;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception: " + plainTextVersionURL);
		}
	}
}
