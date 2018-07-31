package org.sidiff.repair.history.generator.miner.connectors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Connection.Response;
import org.jsoup.HttpStatusException;
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
	
	public static void main(String[] args) throws HttpStatusException {
		
		// TEST:
		IRepositoryMiner miner = new GitHubComMiner();
		
		String repositoryURL = "https://github.com/eclipse/elk";
		String fileURL = "/plugins/org.eclipse.elk.graph/model/elkgraph.ecore";
		
		
		 List<ModelVersion> versions = miner.mineHistory(repositoryURL, fileURL);
		 
		for (ModelVersion modelVersion : versions) {
			System.out.println(modelVersion);
			System.out.println();
			
			String file = miner.mineVersion(repositoryURL, modelVersion.getRemotePath(), modelVersion.getCommit());
			System.out.println(file.substring(0, Math.min(file.length(), 150)) + "...");
			
			System.out.println();
		}
	}
	
	@Override
	public boolean supports(String repositoryURL) {
		return (repositoryURL.startsWith("http://" + PROTOCOL) || repositoryURL.startsWith("https://" + PROTOCOL));
	}
	
	@Override
	public String getHistoryURL(String repositoryURL, String fileURL) {
		return repositoryURL + URL_LOG + fileURL;
	}

	@Override
	public List<ModelVersion> mineHistory(String repositoryURL, String fileURL) {
		List<ModelVersion> versions = new ArrayList<>();
		String url = getHistoryURL(repositoryURL, fileURL);
		
		try {
			Document doc = Jsoup.connect(url).get();
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
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception while reading history log: " + url);
		}
		
		return versions;
	}
	
	@Override
	public String getVersionURL(String repositoryURL, String fileURL, String commit) {
		return repositoryURL.replaceFirst(PROTOCOL, URL_PLAIN) + "/" + commit + "/" + fileURL;
	}

	@Override
	public String mineVersion(String repositoryURL, String fileURL, String commit) throws HttpStatusException {
		String plainTextVersionURL = "n/a";
		
		try {
			plainTextVersionURL = getVersionURL(repositoryURL, fileURL, commit);
//			System.out.println(plainTextVersionURL);
			
			//Open a URL Stream
			Response response = Jsoup.connect(plainTextVersionURL).ignoreContentType(true).execute();
			return new String(response.bodyAsBytes());
			
//			Document versionDoc = Jsoup.connect(plainTextVersionURL).parser(Parser.xmlParser()).get();
//			System.out.println(versionDoc.toString());
//			return versionDoc.toString();
		} catch (HttpStatusException hse) {
			throw hse;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception: " + plainTextVersionURL);
		}
		
		return null;
	}
}
