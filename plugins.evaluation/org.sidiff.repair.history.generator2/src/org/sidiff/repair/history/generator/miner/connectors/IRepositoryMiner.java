package org.sidiff.repair.history.generator.miner.connectors;

import java.io.FileNotFoundException;
import java.util.List;

import org.sidiff.repair.history.generator.miner.data.ModelVersion;

public interface IRepositoryMiner {

	boolean supports(String repositoryURL);

	List<ModelVersion> mineHistory(String repositoryURL, String remotePath);
	
	String getHistoryURL(String repositoryURL, String remotePath);

	void mineVersion(String repositoryURL, String remotePath, String commit, String localPath) throws FileNotFoundException;
	
	String getVersionURL(String repositoryURL, String remotePath, String commit);
}