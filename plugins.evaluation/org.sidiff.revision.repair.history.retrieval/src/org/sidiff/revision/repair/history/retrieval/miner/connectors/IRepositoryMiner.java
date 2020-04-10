package org.sidiff.revision.repair.history.retrieval.miner.connectors;

import java.io.FileNotFoundException;
import java.util.List;

import org.sidiff.revision.repair.history.retrieval.miner.data.ModelVersion;

public interface IRepositoryMiner {

	boolean supports(String repositoryURL);

	List<ModelVersion> mineHistory(String repositoryURL, String remotePath);
	
	String getHistoryURL(String repositoryURL, String remotePath);

	void mineVersion(String repositoryURL, String remotePath, String commit, String localPath) throws FileNotFoundException, Exception;
	
	String getVersionURL(String repositoryURL, String remotePath, String commit);
}