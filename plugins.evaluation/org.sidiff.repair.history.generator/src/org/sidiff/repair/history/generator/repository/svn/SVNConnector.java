package org.sidiff.repair.history.generator.repository.svn;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.sidiff.repair.history.generator.repository.ModelNamingUtil;
import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class SVNConnector {
		
	private static String gitURL = "https://github.com/eclipse/b3/blob/master/org.eclipse.b3.backend/model/B3Backend.ecore";
	
	private static String VERSION_PREFIX = "svn";
	
	private String name = "anonymous";
	private String password = "anonymous";

    private String baseUrl = "https://github.com/eclipse/buckminster";
    private String path = "trunk/";
    
    private String project = "org.eclipse.b3.backend/model";
    private String fileName = "B3Backend.ecore";
    
    private String localPath = "C:/workspaces/models";
    
    public static void main(String[] args) {
    	
    	if (gitURL != null) {
    		SVNConnector connector = new SVNConnector(gitURL);
    		connector.checkOut();
    	} else {
    		SVNConnector connector = new SVNConnector();
    		connector.checkOut();
    	}
    }
    
    public SVNConnector() {
	}
    
    public SVNConnector(String gitHubURL) {
    	
    	if (gitHubURL.contains("/blob/master/")) {
    		// File:
    		String gitViewer = "/blob/master/";
    		int baseURLEnd = gitHubURL.indexOf(gitViewer);
    		
    		if (baseURLEnd != -1) {
    			baseUrl = gitHubURL.substring(0, baseURLEnd);
    			fileName = gitHubURL.substring(gitHubURL.lastIndexOf("/") + 1, gitHubURL.length());
    			project = gitHubURL.substring(baseURLEnd + gitViewer.length(), gitHubURL.length() - fileName.length());
    		}
    	} else if (gitHubURL.contains("/commits/master/")) {
    		// File:
    		String gitViewer = "/commits/master/";
    		int baseURLEnd = gitHubURL.indexOf(gitViewer);
    		
    		if (baseURLEnd != -1) {
    			baseUrl = gitHubURL.substring(0, baseURLEnd);
    			fileName = gitHubURL.substring(gitHubURL.lastIndexOf("/") + 1, gitHubURL.length());
    			project = gitHubURL.substring(baseURLEnd + gitViewer.length(), gitHubURL.length() - fileName.length());
    		}
    	} else if (gitHubURL.contains("/tree/master/")) {
    		// Folder:
    		String gitViewer = "/tree/master/";
    		int baseURLEnd = gitHubURL.indexOf(gitViewer);
    		
    		if (baseURLEnd != -1) {
    			baseUrl = gitHubURL.substring(0, baseURLEnd);
    			project = gitHubURL.replaceFirst(baseUrl, "");
    		}
    	}
	}
    
	public void checkOut() {
		SVNRepository repo = createSVNConnector(baseUrl);
		
		List<SVNDirEntry> fileResults = new ArrayList<>();
		findFile(repo, getHeadRevision(repo), path + project + "/", fileName, fileResults);
		
		System.out.println("Files found: " + fileResults.size());
		
		if (!fileResults.isEmpty()) {
			getRevisions(fileResults.get(0));
		}
		
    }
	
	public static boolean isSVNVersion(String file) {
		return ModelNamingUtil.getVersion(file).startsWith(VERSION_PREFIX);
	}
	
    protected String getLocalFilePath(SVNLogEntry logEntry) {
    	String path = localPath + "/" + project + "/" + fileName + "/";
    	String revision = String.format("%05d", logEntry.getRevision());
    	String fileName = ModelNamingUtil.parseFileName(
    			ModelNamingUtil.unparseDate(logEntry.getDate()), VERSION_PREFIX + revision, this.fileName);
		return path + fileName;
    }
	
	private SVNRepository createSVNConnector(String baseUrl) {
		try {
			SVNURL url = SVNURL.parseURIEncoded(baseUrl);
			SVNRepository repo = SVNRepositoryFactory.create(url);
			
			@SuppressWarnings("deprecation")
			ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(name, password);
			repo.setAuthenticationManager(authManager);

			return repo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private long getHeadRevision(SVNRepository repo) {
		try {
			return repo.getLatestRevision();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	private void findFile(SVNRepository repo, long revision, String filePath, 
			String fileName, List<SVNDirEntry> fileResults) {
		try {
			Collection<?> entriesList = repo.getDir(filePath, revision, null, (Collection<?>) null);
			
			for (Iterator<?> entries = entriesList.iterator(); entries.hasNext();) {
				SVNDirEntry entry = (SVNDirEntry) entries.next();
				
				if ((entry.getKind().equals(SVNNodeKind.FILE)) && (entry.getName().equals(fileName))) {
					fileResults.add(entry);
				}
				
				if (entry.getKind().equals(SVNNodeKind.DIR)) {
					findFile(repo, revision, filePath + entry.getName() + "/", fileName, fileResults);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private List<Long> getRevisions(SVNDirEntry file) {
		try {
			SVNURL url = SVNURL.parseURIEncoded(file.getURL().toDecodedString().substring(0,
					file.getURL().toDecodedString().lastIndexOf(file.getName())));
			SVNRepository repos = SVNRepositoryFactory.create(url);

			System.out.println("reading log...");
			
			long revision = repos.getLatestRevision();
			boolean changePath = false; 
			Collection<?> logEntries = repos.log(new String[] { file.getName() }, 
					(Collection<?>) null, revision, 0, changePath, false);

			List<Long> revisions = new ArrayList<>();
			
			for (Iterator<?> logs = logEntries.iterator(); logs.hasNext();) {
				SVNLogEntry logEntry = (SVNLogEntry) logs.next();
				revisions.add(logEntry.getRevision());
				
				String localPath = getLocalFilePath(logEntry);
				File localFile = new File(localPath);
				localFile.getParentFile().mkdirs();
				
				System.out.println(localPath);
				
				FileOutputStream fos = new FileOutputStream(localFile);
				repos.getFile(file.getName(), logEntry.getRevision(), null, fos);
				fos.flush();
				fos.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
	}
}