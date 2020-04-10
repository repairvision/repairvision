package org.sidiff.revision.repair.history.retrieval.miner.connectors;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.sidiff.revision.repair.history.retrieval.ecore.EcoreHistorySettings;
import org.sidiff.revision.repair.history.retrieval.miner.data.ModelVersion;

public class EclipseGitOrgMiner extends AbstractRepositoryMiner {
	
	private static final String PROTOCOL = "git.eclipse.org";
	
	private static final String URL_LOG = "/log/";
	
	private static final String URL_NEXT_LOG = "?ofs=";
	
	private static final String URL_ID = "?id=";
	
	private static final String URL_COMMIT = "/commit/";
	
	private static final String URL_PLAIN = "/plain/";
	
	private static final DateFormat DATE_RFC822 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
	
	public static void main(String[] args) throws FileNotFoundException {
		
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
			
			try {
				miner.mineVersion(repositoryURL, modelVersion.getRemotePath(), modelVersion.getCommit(), "C:\\" + fileURL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
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
	protected List<ModelVersion> internal_mineHistory(String fullURL, String fileURL) {
		List<ModelVersion> versions = new ArrayList<>();
		
		try {
			Document doc = mineURL(fullURL);
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
					String date = EcoreHistorySettings.DATE_ISO8601.format(parsedDate);
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
				
				if (logURL.contains(URL_NEXT_LOG)) {
					
					// Filter "previous" links: 
					if (fullURL.contains(URL_NEXT_LOG)) {
						int currentPageCount = Integer.valueOf(fullURL.substring(fullURL.lastIndexOf(URL_NEXT_LOG) + URL_NEXT_LOG.length()));
						int nextPageCount = Integer.valueOf(logURL.substring(logURL.lastIndexOf(URL_NEXT_LOG) + URL_NEXT_LOG.length()));
						
						if (currentPageCount > nextPageCount) {
							continue;
						}
					}
					
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
	public String getVersionURL(String repositoryURL, String remotePath, String commit) {
		return repositoryURL + URL_PLAIN + remotePath + URL_ID + commit;
	}
}
