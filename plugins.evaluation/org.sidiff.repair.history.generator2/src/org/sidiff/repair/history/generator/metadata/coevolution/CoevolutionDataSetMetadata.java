package org.sidiff.repair.history.generator.metadata.coevolution;

import java.io.File;

import org.sidiff.repair.history.generator.metadata.DataSetMetadata;
import org.sidiff.repair.history.generator.metadata.HistoryMetadata;

public class CoevolutionDataSetMetadata extends DataSetMetadata {

	public CoevolutionDataSetMetadata(String localPath, boolean onlyExistingVersions) {
		super(localPath, onlyExistingVersions);
	}
	
	@Override
	protected HistoryMetadata createHistory(File historyFile, boolean onlyExistingVersions) {
		return new CoevolutionHistoryMetadata(historyFile, onlyExistingVersions);
	}
}
