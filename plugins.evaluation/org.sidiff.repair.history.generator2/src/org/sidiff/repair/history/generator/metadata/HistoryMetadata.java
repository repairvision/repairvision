package org.sidiff.repair.history.generator.metadata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.sidiff.repair.history.generator.json.JSONObject;

public class HistoryMetadata {
	
	private static final DateFormat DATE_ISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	
	private static final String key_date = "date";
	
	private static final String key_projectName = "projectName";
	
	private static final String key_repositoryURL = "repositoryURL";
	
	private static final String key_versions = "versions";
	
	private static final String key_commits = "commits";
	
	private File datafile;
	
	private JSONObject history = new JSONObject();
	
	private List<VersionMetadata> versions = new ArrayList<>();
	
	public HistoryMetadata(File datafile) {
		this.datafile = datafile;
	}
	
	public void read() {
		try {
			history = new JSONObject(new String(Files.readAllBytes(Paths.get(datafile.getAbsolutePath()))));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write() {
		
		// write meta data per model:
		history.put(key_date, DATE_ISO8601.format(new Date()));
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
	
	public List<VersionMetadata> getVersions() {
		return versions;
	}
	
	protected JSONObject getJSON() {
		return history;
	}
}
