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

public class EclipseGitOrgMiner implements IRepositoryMiner {
	
	private static final String PROTOCOL = "git.eclipse.org";
	
	private static final String URL_LOG = "/log/";
	
	private static final String URL_ID = "?id=";
	
	private static final String URL_COMMIT = "/commit/";
	
	private static final String URL_PLAIN = "/plain/";
	
	private static final DateFormat DATE_RFC822 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
	
	public static void main(String[] args) throws HttpStatusException {
		
		// TEST:
		IRepositoryMiner miner = new EclipseGitOrgMiner();
		
//		String repositoryURL = "http://git.eclipse.org/c/mmt/org.eclipse.atl.git";
//		String fileURL = "/deprecated/org.atl.eclipse.engine/src/org/atl/eclipse/engine/resources/ATL-0.2.ecore?id=859c1cb272110595f9d8dd29e04d9b82bd52ab8b";
		
		String repositoryURL = "http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git";
		String fileURL = "/bundles/org.eclipse.emf.emfstore.client/model/client.ecore";
		
		 List<ModelVersion> versions = miner.mineHistory(repositoryURL, fileURL);
		 
		for (ModelVersion modelVersion : versions) {
			System.out.println(modelVersion);
			System.out.println();
			
			String file = miner.mineVersion(repositoryURL, modelVersion);
			System.out.println(file.substring(0, Math.min(file.length(), 150)) + "...");
			
			System.out.println();
		}
	}
	
	@Override
	public boolean supports(String repositoryURL) {
		return (repositoryURL.startsWith("http://" + PROTOCOL) || repositoryURL.startsWith("https://" + PROTOCOL));
	}

	@Override
	public List<ModelVersion> mineHistory(String repositoryURL, String fileURL) {
		List<ModelVersion> versions = new ArrayList<>();
		String url = repositoryURL + URL_LOG + fileURL;
		
		try {
			Document doc = Jsoup.connect(url).get();
			Elements links = doc.body().select("div[class='content']").select("a[href]");
			
			for (Element link : links) {
				String versionURL = link.attr("href");
				
				if (versionURL.contains(URL_ID) && !link.parentNode().nodeName().equals("th")) {
//					System.out.println(versionURL);
					
//					for (Element tableCell : link.parent().parent().children()) {
//						System.out.println(tableCell);
//					}
					
					String commit = versionURL.substring(versionURL.lastIndexOf(URL_ID) + URL_ID.length());
//					System.out.println("commit: " + commit);
					
					Element tableRow = RepositoryMinerUtil.getParentNode(link, "tr");

					Date parsedDate = DATE_RFC822.parse(tableRow.select("span[title]").attr("title"));
					String date = HistoryMetadata.DATE_ISO8601.format(parsedDate);
//					System.out.println("date: " + date);
					
					String message = tableRow.children().get(1).text();
//					System.out.println("message: " + message);
					
					String author = tableRow.children().get(2).text();
//					System.out.println("author: " + author);
					
					String file = versionURL.replace(URL_ID + commit, "");
					file =  file.substring(file.lastIndexOf(URL_COMMIT) + URL_COMMIT.length() - 1);
					
					ModelVersion modelVersion = new ModelVersion(file, commit, date, message, author);
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
	public String mineVersion(String repositoryURL, ModelVersion modelVersion) throws HttpStatusException {
		String plainTextVersionURL = "n/a";
		
		try {
			plainTextVersionURL = repositoryURL + URL_PLAIN + modelVersion.getFile() + URL_ID + modelVersion.getCommit();
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
