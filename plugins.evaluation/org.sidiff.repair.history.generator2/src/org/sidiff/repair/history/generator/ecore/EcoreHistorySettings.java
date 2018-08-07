package org.sidiff.repair.history.generator.ecore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.sidiff.consistency.common.settings.SettingsUtil;
import org.sidiff.difference.technical.ITechnicalDifferenceBuilder;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.difference.technical.api.util.TechnicalDifferenceUtils;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matching.api.util.MatchingUtils;
import org.sidiff.repair.history.generator.miner.connectors.EclipseGitOrgMiner;
import org.sidiff.repair.history.generator.miner.connectors.GitHubComMiner;
import org.sidiff.repair.history.generator.miner.connectors.IRepositoryMiner;
import org.sidiff.repair.history.generator.validation.EMFValidator;
import org.sidiff.repair.history.generator.validation.IValidator;

public class EcoreHistorySettings {

	public static final DateFormat DATE_ISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	
	public static final DateFormat DATE_ISO8601_PATH_COMPATIBLE = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss'Z'");
	
	private static EcoreHistorySettings instance;
	
	private List<IRepositoryMiner> miners = Arrays.asList(new EclipseGitOrgMiner(), new GitHubComMiner());
	
	private IValidator validator = new EMFValidator();
	
	public static EcoreHistorySettings getInstance() {
		if (instance == null) {
			instance = new EcoreHistorySettings();
		}
		return instance;
	}
			
	public List<IRepositoryMiner> getMiners() {
		return miners;
	}
	
	public String generateVersionName(Date date, String commit) {
		return EcoreHistorySettings.DATE_ISO8601_PATH_COMPATIBLE.format(date) + "_" + commit;
	}
	
	public String generateHistoryName(String remoteFilePath) {
		
		if (remoteFilePath.startsWith("/")) {
			remoteFilePath = remoteFilePath.replaceFirst("/", "");
		}
		
		return remoteFilePath.replace("/", "_");
	}

	public IValidator getValidator() {
		return validator;
	}

	public DifferenceSettings getDifferenceSettings() {
		DifferenceSettings differenceSettings = SettingsUtil.getDefaultDifferenceSettings();
		IMatcher matcher = MatchingUtils.getMatcherByKey("org.sidiff.ecore.repair.history.matcher.EcoreMatcher");
		ITechnicalDifferenceBuilder builder = TechnicalDifferenceUtils.getTechnicalDifferenceBuilder("org.sidiff.ecore.difference.technical.TechnicalDifferenceBuilderEcoreNoAnnotations");
		differenceSettings.setMatcher(matcher);
		differenceSettings.setTechBuilder(builder);
		return differenceSettings;
	}
}
