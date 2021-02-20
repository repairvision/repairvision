package org.sidiff.reverseengineering;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.reverseengineering.configuration.RetrievalConfiguration;
import org.sidiff.reverseengineering.dataset.Activator;
import org.sidiff.reverseengineering.dataset.history.model.Version;
import org.sidiff.reverseengineering.dataset.model.DataSet;
import org.sidiff.reverseengineering.dataset.model.util.DataSetStorage;
import org.sidiff.reverseengineering.dataset.util.json.JsonUtil;
import org.sidiff.reverseengineering.retrieval.SystemModelRetrieval;
import org.sidiff.reverseengineering.retrieval.SystemModelRetrievalSettings;
import org.sidiff.reverseengineering.retrieval.WorkspaceHistoryRetrieval;
import org.sidiff.reverseengineering.retrieval.WorkspaceHistoryRetrievalSettings;
import org.sidiff.reverseengineering.retrieval.util.ApplicationUtil;

/**
 * Converts a Java project into an UML model.
 */
public class DataSetRetrievalApplication implements IApplication {

	/*
	 *  Program Arguments: -dataset "<Path to>/DataSet.json" -retrieval "<Path to>/RetrievalConfiguration.json" -workspacehistory -systemmodelhistory
	 */
	
	public static final String ARGUMENT_DATASET = "-dataset";
	
	public static final String ARGUMENT_CONFIGURATION = "-retrieval";
	
	public static final String ARGUMENT_WORKSPACE_HISTORY = "-workspacehistory";
	
	public static final String ARGUMENT_SYSTEM_MODEL_HISTORY = "-systemmodelhistory";
	
	/**
	 * Phase 02: Retrieves the history of project in the workspace and whether the
	 * content of a project was changed since the last version.
	 */
	private boolean retrieveWorkspaceHistory = true;
	
	/**
	 * Phase 03: Retrieves the system model (UML) from Java.
	 */
	private boolean retrieveSystemModelHistory = true;
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		Path dataSetPath = ApplicationUtil.getPathFromProgramArguments(context, ARGUMENT_DATASET);
		DataSet dataSet = DataSetStorage.load(dataSetPath);
		
		Path retrievalConfigurationPath = ApplicationUtil.getPathFromProgramArguments(context, ARGUMENT_CONFIGURATION);
		RetrievalConfiguration retrievalConfiguration = JsonUtil.parse(retrievalConfigurationPath, RetrievalConfiguration.class);
		
		this.retrieveWorkspaceHistory = ApplicationUtil.containsProgramArgument(context, ARGUMENT_WORKSPACE_HISTORY);
		this.retrieveSystemModelHistory = ApplicationUtil.containsProgramArgument(context, ARGUMENT_SYSTEM_MODEL_HISTORY);
		
		start(dataSetPath, dataSet, retrievalConfigurationPath, retrievalConfiguration);
		
		return IApplication.EXIT_OK;
	}
	
	protected void start(Path datasetPath, DataSet dataset, Path retrievalConfigurationPath, RetrievalConfiguration retrievalConfiguration) throws IOException {
		String codeRepositoryURL = dataset.getRepositoryHost() + dataset.getRepositoryPath();
		Path codeRepositoryPath = Paths.get(retrievalConfiguration.getLocalRepositoryPath().toString(), dataset.getName());
		
		// Workspace:
		if (retrieveWorkspaceHistory) {
			WorkspaceHistoryRetrievalSettings workspaceHistoryRetrievalSettings = new WorkspaceHistoryRetrievalSettings(codeRepositoryURL, codeRepositoryPath);
			WorkspaceHistoryRetrieval workspaceHistoryRetrieval = new WorkspaceHistoryRetrieval(workspaceHistoryRetrievalSettings, dataset, datasetPath);
			
			try {
				workspaceHistoryRetrieval.retrieve();
			} finally {
				workspaceHistoryRetrieval.saveDataSet(workspaceHistoryRetrievalSettings.isAppendTimestampToDataSet());
			}
			
			// update data set path to output file
			datasetPath = workspaceHistoryRetrieval.getDatasetPath();
			
			Activator.getLogger().log(Level.INFO, "Workspace History Retrieval Finished");
			Activator.getLogger().log(Level.INFO, "Workspace History Saved: " + datasetPath);
		}
		
		// Direct System model (Java Model -> System Model):
		if (retrieveSystemModelHistory) {
			SystemModelRetrievalSettings systemModelRetrievalSettings = new SystemModelRetrievalSettings(codeRepositoryURL, codeRepositoryPath);
			SystemModelRetrieval systemModelRetrieval = new SystemModelRetrieval(systemModelRetrievalSettings, dataset, datasetPath);
			Path systemModelRepositoryPath = Path.of("NA");
			
			try {
//				// Resume on last intermediate save:
//				{
//					datasetPath = Paths.get(datasetPath.getParent().toString(),
//							"DataSet_20201120213103_20201121033529.json_3800_b5c1652db351290a42a75d3cdd3241441a4413e2_0e32179056318498bab8548c6d40017d6c717dfd");
//					dataset = DataSetStorage.load(datasetPath);
//					
//					systemModelRetrieval = new SystemModelRetrieval(systemModelProvider, dataset, datasetPath);
//					systemModelRetrieval.retrieve(resume(dataset, "0e32179056318498bab8548c6d40017d6c717dfd"));
//				}
				
				systemModelRepositoryPath = systemModelRetrieval.retrieve();
			} finally {
				datasetPath = systemModelRetrieval.saveDataSet(systemModelRetrievalSettings.isAppendTimestampToDataSet());
			}
			
			Activator.getLogger().log(Level.INFO, "System Model History Retrieval Finished");
			Activator.getLogger().log(Level.INFO, "System Model Repository: " + systemModelRepositoryPath);
			Activator.getLogger().log(Level.INFO, "Model Repository Versions With Code Repository Trace Saved: " + datasetPath);
			Activator.getLogger().log(Level.INFO, "To optimize disc space run: git gc --auto");
		}
	}
	
	@SuppressWarnings("unused")
	private int resume(DataSet dataset, String versionID) {
		List<Version> originalHistory = dataset.getHistory().getVersions();
		int resumeIndex = -1;
		
		for (Version version : originalHistory) {
			if (version.getIdentification().equals(versionID)) {
				resumeIndex = originalHistory.indexOf(version);
			}
		}
		
		return resumeIndex;
	}

	@Override
	public void stop() {
	}

	public boolean isRetrieveWorkspaceHistory() {
		return retrieveWorkspaceHistory;
	}
	
	public void setRetrieveWorkspaceHistory(boolean retrieveWorkspaceHistory) {
		this.retrieveWorkspaceHistory = retrieveWorkspaceHistory;
	}

	public boolean isRetrieveSystemModelHistory() {
		return retrieveSystemModelHistory;
	}

	public void setRetrieveSystemModelHistory(boolean retrieveSystemModelHistory) {
		this.retrieveSystemModelHistory = retrieveSystemModelHistory;
	}
}
