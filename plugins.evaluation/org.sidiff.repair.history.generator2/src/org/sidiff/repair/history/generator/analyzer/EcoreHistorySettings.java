package org.sidiff.repair.history.generator.analyzer;

import java.util.Arrays;
import java.util.List;

import org.sidiff.repair.history.generator.miner.connectors.EclipseGitOrgMiner;
import org.sidiff.repair.history.generator.miner.connectors.GitHubComMiner;
import org.sidiff.repair.history.generator.miner.connectors.IRepositoryMiner;

public class EcoreHistorySettings {
	
	private static EcoreHistorySettings instance;
	
	private List<IRepositoryMiner> miners = Arrays.asList(new EclipseGitOrgMiner("</ecore:EPackage>"), new GitHubComMiner());
	
	public static EcoreHistorySettings getInstance() {
		if (instance == null) {
			instance = new EcoreHistorySettings();
		}
		return instance;
	}
			
	public List<IRepositoryMiner> getMiners() {
		return miners;
	}
}
