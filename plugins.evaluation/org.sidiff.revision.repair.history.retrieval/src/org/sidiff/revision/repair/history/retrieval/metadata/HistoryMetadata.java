package org.sidiff.revision.repair.history.retrieval.metadata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.sidiff.revision.repair.history.retrieval.ecore.EcoreHistorySettings;
import org.sidiff.revision.repair.history.retrieval.json.JSONObject;

public class HistoryMetadata {
	
	private static final String key_date = "date";
	
	private static final String key_projectName = "projectName";
	
	private static final String key_repositoryURL = "repositoryURL";
	
	private static final String key_info = "info";
	
	private static final String key_versions = "versions";
	
	private static final String key_commits = "commits";
	
	private File datafile;
	
	private JSONObject history = new JSONObject();
	
	private List<VersionMetadata> versions = new ArrayList<VersionMetadata>() {
		
		private static final long serialVersionUID = 1L;

		public boolean add(VersionMetadata e) {
			boolean result = false;
			
			if (!contains(e)) {
				result = super.add(e);
			}
			
			Collections.sort(this);
			return result;
		}
	};
	
	public HistoryMetadata() {
	}
	
	public HistoryMetadata(File datafile, boolean onlyExistingVersions) {
		this.datafile = datafile;
		
		if (datafile.exists()) {
			read(onlyExistingVersions);
		}
	}
	
	public HistoryMetadata(HistoryMetadata original) {
		this.datafile = original.datafile;
		setInfo(original.getInfo());
		setProjectName(original.getProjectName());
		setRepositoryURL(original.getRepositoryURL());
	}
	
	protected VersionMetadata createVersion() {
		return new VersionMetadata(this);
	}
	
	public File getDatafile() {
		return datafile;
	}
	
	public void setDatafile(File datafile) {
		this.datafile = datafile;
	}
	
	public void read(boolean onlyExistingVersions) {
		try {
			history = new JSONObject(new String(Files.readAllBytes(Paths.get(datafile.getAbsolutePath()))));
			
			for (Object versionObj : history.getJSONArray(key_commits)) {
				if (versionObj instanceof JSONObject) {
					JSONObject versionJSON = (JSONObject) versionObj;
					VersionMetadata version = createVersion();
					version.setJSON(versionJSON);
					versions.add(version);
				}
			}
			
			// Split history and versions:
			history.remove(key_commits);
			
			if (onlyExistingVersions) {
				for (Iterator<VersionMetadata> iterator = versions.iterator(); iterator.hasNext();) {
					VersionMetadata version = (VersionMetadata) iterator.next();
					
					if (!version.getExists()) {
						iterator.remove();
					}
				}
			}
			
			Collections.sort(versions);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write() {
		Collections.sort(versions);
		
		// write meta data per model:
		history.put(key_date, EcoreHistorySettings.DATE_ISO8601.format(new Date()));
		history.put(key_versions, versions.size());
		
		for (VersionMetadata modelVersion : versions) {
			history.append(key_commits, modelVersion.getJSON());
		}
		
		FileWriter fileWriter = null;
		
		try {
			datafile.getParentFile().mkdirs();
			datafile.createNewFile();
			
			fileWriter = new FileWriter(datafile);
			fileWriter.write(history.toString(4));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getProjectName() {
		return history.getString(key_projectName);
	}
	
	public void setProjectName(String projectName) {
		history.put(key_projectName, projectName);
	}

	public String getRepositoryURL() {
		return history.getString(key_repositoryURL);
	}
	
	public void setRepositoryURL(String repositoryURL) {
		history.put(key_repositoryURL, repositoryURL);
	}
	
	public String getInfo() {
		return history.getString(key_info);
	}
	
	public void setInfo(String info) {
		history.put(key_info, info);
	}
	
	public List<VersionMetadata> getVersions() {
		return versions;
	}
	
	public VersionMetadata getVersion(String commit) {
		for (VersionMetadata versionMetadata : versions) {
			if (versionMetadata.getCommit().equals(commit)) {
				return versionMetadata;
			}
		}
		return null;
	}
	
	public VersionMetadata getOlderVersion(VersionMetadata version) {
		int index = versions.indexOf(version);
		
		if (index != -1) {
			if (versions.size() > (index + 1)) {
				return versions.get(index + 1);
			}
		}
		
		return null;
	}
	
	public VersionMetadata getNewerVersion(VersionMetadata version) {
		int index = versions.indexOf(version);
		
		if (index != -1) {
			if ((index - 1) >= 0) {
				return versions.get(index - 1);
			}
		}
		
		return null;
	}
	
	public VersionMetadata getNewestVersion() {
		return versions.get(0);
	}
	
	public VersionMetadata getOldestVersion() {
		return versions.get(versions.size() - 1);
	}
	
	public VersionMetadata getVersionAtTime(Date date) {
		VersionMetadata versionAtTime = null;
		
		for (VersionMetadata version : versions) {
			Date versionDate = version.getParsedDate();
			
			if (versionDate.equals(date) || versionDate.before(date)) {
				if ((versionAtTime == null) || (versionDate.after(versionAtTime.getParsedDate()))) {
					versionAtTime = version;
				}
			}
		}
		
		return versionAtTime;
	}
	
	public String getLatestRemoteFilePath() {
		return versions.get(0).getRemoteFilePath();
	}
	
	public Set<String> getAllRemoteFilePath() {
		return versions.stream().map(VersionMetadata::getRemoteFilePath).collect(Collectors.toSet());
	}
	
	protected JSONObject getJSON() {
		return history;
	}
	
	@Override
	public String toString() {
		return super.toString() + " (File: " + datafile.getAbsolutePath() + ")";
	}
}
