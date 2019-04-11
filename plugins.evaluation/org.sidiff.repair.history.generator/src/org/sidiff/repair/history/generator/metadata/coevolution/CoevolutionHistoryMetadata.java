package org.sidiff.repair.history.generator.metadata.coevolution;

import java.io.File;

import org.sidiff.repair.history.generator.metadata.HistoryMetadata;
import org.sidiff.repair.history.generator.metadata.VersionMetadata;

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
