package org.sidiff.revision.repair.history.retrieval.metadata.coevolution;

import java.io.File;

import org.sidiff.revision.repair.history.retrieval.metadata.HistoryMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.VersionMetadata;

public class CoevolutionHistoryMetadata extends HistoryMetadata {

	public CoevolutionHistoryMetadata() {
		super();
	}
	
	public CoevolutionHistoryMetadata(File datafile, boolean onlyExistingVersions) {
		super(datafile, onlyExistingVersions);
	}
	
	public CoevolutionHistoryMetadata(HistoryMetadata original) {
		super(original);
	}
	
	@Override
	protected VersionMetadata createVersion() {
		return new CoevolutionVersionMetadata(this);
	}
}
