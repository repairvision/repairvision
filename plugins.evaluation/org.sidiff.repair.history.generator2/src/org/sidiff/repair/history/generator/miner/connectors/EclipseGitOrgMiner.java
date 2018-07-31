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
	
	private String trimTo;
	
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
			
			String file = miner.mineVersion(repositoryURL, modelVersion.getRemotePath(), modelVersion.getCommit());
			System.out.println(file.substring(0, Math.min(file.length(), 150)) + "...");
			
			System.out.println();
		}
	}
	
	public EclipseGitOrgMiner() {
	}
	
	public EclipseGitOrgMiner(String trimTo) {
		this.trimTo = trimTo;
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
		return internal_mineHistory(getHistoryURL(repositoryURL, fileURL), fileURL);
	}

	private List<ModelVersion> internal_mineHistory(String fullURL, String fileURL) {
		List<ModelVersion> versions = new ArrayList<>();
		
		try {
			Document doc = Jsoup.connect(fullURL).get();
			Elements versionLinks = doc.body().select("div[class='content']").select("a[href]");
			
			for (Element versionLink : versionLinks) {
				String versionURL = versionLink.attr("href");
				
				if (versionURL.contains(URL_ID) && !versionLink.parentNode().nodeName().equals("th")) {
//					System.out.println(versionURL);
					
//					for (Element tableCell : link.parent().parent().children()) {
//						System.out.println(tableCell);
//					}
					
					String commit = versionURL.substring(versionURL.lastIndexOf(URL_ID) + URL_ID.length());
//					System.out.println("commit: " + commit);
					
					Element tableRow = RepositoryMinerUtil.getParentNode(versionLink, "tr");

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
			
			// Lookup next log page:
			Elements logLinks = doc.body().select("ul[class='pager']").select("a[href]");
			
			for (Element logLink : logLinks) {
				String logURL = logLink.attr("href");
				
				if (logURL.contains("?ofs=")) {
					versions.addAll(internal_mineHistory("http://" + PROTOCOL + logURL, fileURL));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception while reading history log: " + fullURL);
		}
		
		return versions;
	}
	
	@Override
	public String getVersionURL(String repositoryURL, String fileURL, String commit) {
		return repositoryURL + URL_PLAIN + fileURL + URL_ID + commit;
	}

	@Override
	public String mineVersion(String repositoryURL, String fileURL, String commit) throws HttpStatusException {
		String plainTextVersionURL = "n/a";
		
		try {
			plainTextVersionURL = getVersionURL(repositoryURL, fileURL, commit);
//			System.out.println(plainTextVersionURL);
			
			//Open a URL Stream
			Response response = Jsoup.connect(plainTextVersionURL).ignoreContentType(true).execute();
			String model = new String(response.bodyAsBytes());
			
			// FIXME: Server side bug -> unknown appended HTML!
			if ((trimTo != null) && !model.trim().endsWith(trimTo)) {
				model = model.substring(0, model.lastIndexOf(trimTo) + trimTo.length());
			}
			
			return model;
			
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
