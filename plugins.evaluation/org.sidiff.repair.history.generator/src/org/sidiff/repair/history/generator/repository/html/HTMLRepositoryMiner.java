package org.sidiff.repair.history.generator.repository.html;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class HTMLRepositoryMiner {
	
	private static final String URL = "http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git/log/bundles/org.eclipse.emf.emfstore.client/model/client.ecore";
	
	private static final String URL_ATTRIBUTE_ID = "?id=";
	
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect(URL).get();
			Elements links = doc.body().select("a[href]");
			
			for (Element link : links) {
				String versionURL = link.attr("href");
				
				if (versionURL.contains(URL_ATTRIBUTE_ID)) {
					System.out.println(versionURL);
					
					String commit = versionURL.substring(versionURL.lastIndexOf(URL_ATTRIBUTE_ID) + URL_ATTRIBUTE_ID.length());
					System.out.println("commit: " + commit);
					System.out.println("date: " + link.parent().parent().children().get(0).children().get(0).attr("title"));
					System.out.println("message: " + link.parent().parent().children().get(1).text());
					System.out.println("author: " + link.parent().parent().children().get(2).text());
					
					String plainTextVersionURL = URL.replace("/log/", "/plain/") + URL_ATTRIBUTE_ID + commit;
					Document versionDoc = Jsoup.connect(plainTextVersionURL).parser(Parser.xmlParser()).get();
					System.out.println(versionDoc.toString());
					
					
//					for (Element tableCell : link.parent().parent().children()) {
//						System.out.println(tableCell);
//					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mine(ModelHistory history) {
		
	}
}
