package org.sidiff.reverseengineering.retrieval;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;

import org.sidiff.reverseengineering.Activator;
import org.sidiff.reverseengineering.dataset.history.model.FileChange;
import org.sidiff.reverseengineering.dataset.history.model.History;
import org.sidiff.reverseengineering.dataset.history.model.Version;
import org.sidiff.reverseengineering.dataset.history.repository.Repository;
import org.sidiff.reverseengineering.dataset.model.DataSet;
import org.sidiff.reverseengineering.dataset.model.util.DataSetStorage;
import org.sidiff.reverseengineering.dataset.workspace.builder.WorkspaceDiscoverer;
import org.sidiff.reverseengineering.dataset.workspace.model.Workspace;

public class WorkspaceHistoryRetrieval {
	
	private WorkspaceHistoryRetrievalSettings settings;
	
	private DataSet dataset;
	
	private Path datasetPath;
	
	private Repository codeRepository;
	
	private Path codeRepositoryPath;
	
	public WorkspaceHistoryRetrieval(WorkspaceHistoryRetrievalSettings settings, DataSet dataset, Path datasetPath) {
		this.settings = settings;
		this.datasetPath = datasetPath;
		this.dataset = dataset;
	}
	
	public void retrieve() {
		retrieveHistory();
		retrieveWorkspaceHistory();
	}
	
	public void retrieveHistory() {
		this.codeRepository = settings.createCodeRepository();
		this.codeRepositoryPath = codeRepository.getWorkingDirectory();
		
		// Retrieve commits and filtering versions:
		History history = codeRepository.getHistory(settings.createVersionFilter());
		dataset.setHistory(history);
	}
	
	private void retrieveWorkspaceHistory() {
		History history = dataset.getHistory();
		List<Version> versions = history.getVersions();
		
		try {
			// Iterate from old to new versions:
			for (int i = versions.size(); i-- > 0;) {
				Version olderVersion = (versions.size() > i + 1) ? versions.get(i + 1) : null;
				Version version = versions.get(i);

				Workspace workspace = retrieveWorkspaceVersion(history, version);
				retrieveWorkspaceChanges(workspace, olderVersion, version);
				
				if (Activator.getLogger().isLoggable(Level.FINE)) {
					Activator.getLogger().log(Level.FINE, "Retrieved workspace for version " 
							+ (versions.size() - i) + " of " + versions.size() + " versions");
				}
			}
		} finally {
			// Always reset head pointer of the code repository to its original position, e.g., if the iteration fails.
			codeRepository.reset();
		}
	}
	
	private Workspace retrieveWorkspaceVersion(History history, Version version) {
		
		if (Activator.getLogger().isLoggable(Level.FINER)) {
			Activator.getLogger().log(Level.FINER, "Retrieve Workspace: " + version);
		}
		
		// Check out and import newer workspace version:
		codeRepository.checkout(history, version);
		
		// Find projects in this version:
		Workspace workspace = new Workspace();
		WorkspaceDiscoverer workspaceDiscoverer = new WorkspaceDiscoverer(workspace, codeRepositoryPath);
		workspaceDiscoverer.findProjects(codeRepositoryPath);
		
		version.setWorkspace(workspace);
		return workspace;
	}
	
	private void retrieveWorkspaceChanges(Workspace workspace, Version versionA, Version versionB) {
		if (versionA == null) {
			List<FileChange> fileChanges = codeRepository.getChanges(versionB, false); // initial version
			versionB.setFileChanges(fileChanges);
		} else {
			List<FileChange> fileChanges = codeRepository.getChanges(versionA, versionB, false, settings.isFlattenHistoryBranches());
			versionB.setFileChanges(fileChanges);
		}
	}

	public Path getCodeRepositoryPath() {
		return codeRepositoryPath;
	}
	
	public Path getDatasetPath() {
		return datasetPath;
	}
	
	public DataSet getDataset() {
		return dataset;
	}
	
	public void saveDataSet(boolean appendTimestamp) {
		try {
			dataset.createTimestamp();
			this.datasetPath = DataSetStorage.save(datasetPath, dataset, appendTimestamp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
