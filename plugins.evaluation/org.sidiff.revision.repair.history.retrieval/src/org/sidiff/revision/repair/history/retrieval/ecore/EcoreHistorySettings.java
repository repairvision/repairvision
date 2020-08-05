package org.sidiff.revision.repair.history.retrieval.ecore;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.sidiff.history.analysis.validation.EMFValidator;
import org.sidiff.history.analysis.validation.IValidator;
import org.sidiff.history.revision.util.SettingsUtil;
import org.sidiff.revision.difference.api.registry.MatcherRegistry;
import org.sidiff.revision.common.emf.document.Scope;
import org.sidiff.revision.difference.api.registry.DifferenceBuilderRegistry;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.difference.builder.IDifferenceBuilderProvider;
import org.sidiff.revision.difference.matcher.IMatcherProvider;
import org.sidiff.revision.repair.history.retrieval.miner.connectors.EclipseGitOrgMiner;
import org.sidiff.revision.repair.history.retrieval.miner.connectors.GitHubComMiner;
import org.sidiff.revision.repair.history.retrieval.miner.connectors.IRepositoryMiner;

public class EcoreHistorySettings {

	public static final DateFormat DATE_ISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	
	public static final DateFormat DATE_ISO8601_PATH_COMPATIBLE = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss'Z'");
	
	public static final DecimalFormat VERSION_NUMBER_FORMAT = new DecimalFormat("#0000");
	
	public static final String INCONSISTENCY_UNRESOLVED_PROXY = "TheFeatureOfContainsAnUnresolvedProxy";
	
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
		differenceSettings.setScope(Scope.RESOURCE_SET);
		
		IMatcherProvider matcherProvider = MatcherRegistry.getMatcherByKey("org.sidiff.ecore.repair.history.matcher.EcoreMatcher");
		differenceSettings.setMatcher(matcherProvider);
		
		IDifferenceBuilderProvider builder = DifferenceBuilderRegistry.getTechnicalDifferenceBuilder("org.sidiff.ecore.difference.technical.TechnicalDifferenceBuilderEcoreNoAnnotations");
		differenceSettings.setTechBuilder(builder);
		return differenceSettings;
	}
}
