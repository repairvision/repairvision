package org.sidiff.repair.history.generator.miner.connectors;

import java.util.List;

import org.jsoup.HttpStatusException;
import org.sidiff.repair.history.generator.miner.data.ModelVersion;

public interface IRepositoryMiner {

	boolean supports(String repositoryURL);

	List<ModelVersion> mineHistory(String repositoryURL, String fileURL);
	
	String getHistoryURL(String repositoryURL, String fileURL);

	String mineVersion(String repositoryURL, String fileURL, String commit) throws HttpStatusException;
	
	String getVersionURL(String repositoryURL, String fileURL, String commit);
}