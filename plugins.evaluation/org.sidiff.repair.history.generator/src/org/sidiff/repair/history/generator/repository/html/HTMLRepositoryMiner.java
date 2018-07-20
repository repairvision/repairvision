package org.sidiff.repair.history.generator.repository.html;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection.Response;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLRepositoryMiner {
	
	private static final String PROTOCOL = "git.eclipse.org";
	
	private static final String URL_ATTRIBUTE_ID = "?id=";
	
	private static final String URL_LOG = "/log/";
	
	private static final String URL_COMMIT = "/commit/";
	
	private static final String URL_PLAIN = "/plain/";
	
	private String repository;
	
	private String file;
	
	public static void main(String[] args) throws HttpStatusException {
		
		// TEST:
		HTMLRepositoryMiner miner = new HTMLRepositoryMiner(
				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git",
				"/bundles/org.eclipse.emf.emfstore.client/model/client.ecore");
		
		 List<ModelVersion> versions = miner.mine();
		 
		for (ModelVersion modelVersion : versions) {
			System.out.println(modelVersion);
			System.out.println();
			
			String file = miner.mine(modelVersion);
			System.out.println(file.substring(0, Math.min(file.length(), 150)) + "...");
			
			System.out.println();
		}
	}
	
	public HTMLRepositoryMiner(String repository, String file) {
		this.repository = repository;
		this.file = file;
		
		if (!(repository.startsWith("http://" + PROTOCOL) || repository.startsWith("https://" + PROTOCOL))) {
			throw new RuntimeException("Unsupported Repository: " + repository);
		}
	}

	public List<ModelVersion> mine() {
		List<ModelVersion> versions = new ArrayList<>();
		String url = repository + URL_LOG + file;
		
		try {
			Document doc = Jsoup.connect(url).get();
			Elements links = doc.body().select("a[href]");
			
			for (Element link : links) {
				String versionURL = link.attr("href");
				
				if (versionURL.contains(URL_ATTRIBUTE_ID)) {
//					System.out.println(versionURL);
					
					String commit = versionURL.substring(versionURL.lastIndexOf(URL_ATTRIBUTE_ID) + URL_ATTRIBUTE_ID.length());
//					System.out.println("commit: " + commit);

					String date = link.parent().parent().children().get(0).children().get(0).attr("title");
//					System.out.println("date: " + date);
					
					String message = link.parent().parent().children().get(1).text();
//					System.out.println("message: " + message);
					
					String author = link.parent().parent().children().get(2).text();
//					System.out.println("author: " + author);
					
//					for (Element tableCell : link.parent().parent().children()) {
//						System.out.println(tableCell);
//					}
					
					String file = versionURL.replace(URL_ATTRIBUTE_ID + commit, "");
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

	public String mine(ModelVersion modelVersion) throws HttpStatusException {
		String plainTextVersionURL = "n/a";
		
		try {
			plainTextVersionURL = repository + URL_PLAIN + modelVersion.getFile() + URL_ATTRIBUTE_ID + modelVersion.getCommit();
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
