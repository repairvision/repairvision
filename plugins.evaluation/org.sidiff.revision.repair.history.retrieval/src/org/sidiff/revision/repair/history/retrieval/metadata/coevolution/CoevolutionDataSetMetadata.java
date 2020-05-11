package org.sidiff.revision.repair.history.retrieval.metadata.coevolution;

import java.io.File;

import org.sidiff.revision.repair.history.retrieval.metadata.DataSetMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.HistoryMetadata;

public class CoevolutionDataSetMetadata extends DataSetMetadata {

	public CoevolutionDataSetMetadata(String localPath, boolean onlyExistingVersions) {
		super(localPath, onlyExistingVersions);
	}
	
	@Override
	protected HistoryMetadata createHistory(File historyFile, boolean onlyExistingVersions) {
		return new CoevolutionHistoryMetadata(historyFile, onlyExistingVersions);
	}
}
