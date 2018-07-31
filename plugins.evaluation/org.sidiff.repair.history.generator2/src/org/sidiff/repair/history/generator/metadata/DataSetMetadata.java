package org.sidiff.repair.history.generator.metadata;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSetMetadata {

	private List<HistoryMetadata> histories = new ArrayList<>();
	
	public static void main(String[] args) {
		DataSetMetadata dataset = new DataSetMetadata("C:\\evaluation\\");
		
		for (HistoryMetadata history : dataset.getHistories()) {
			System.out.println(history.getProjectName() 
					+ " : " + history.getRepositoryURL() 
					+ " : " + history.getLatestRemoteFilePath() 
					+ " : " + history.getVersions().size());
		}
	}
	
	public DataSetMetadata(String localPath) {
		for (File historyFile : searchMetadata(new File(localPath))) {
			HistoryMetadata history = new HistoryMetadata(historyFile);
			history.read();
			histories.add(history);
		}
	}
	
	protected List<File> searchMetadata(File root) {
		List<File> files = new ArrayList<>();
		
		FileFilter filter = new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				if (!pathname.isDirectory()) {
					if (pathname.getName().toLowerCase().endsWith(".json")) {
						return true;
					}
				}
				return false;
			}
		};
		
		files.addAll(Arrays.asList(root.listFiles(filter)));
		Collections.sort(files);
		
		// Scan for sub-directories recursively:
		for (File file : root.listFiles()) {
			if (file.isDirectory()) {
				files.addAll(searchMetadata(file));
			}
		}
		return files;
	}
	
	public List<HistoryMetadata> getHistories() {
		return histories;
	}
	
	public void setHistories(List<HistoryMetadata> histories) {
		this.histories = histories;
	}
}
