package org.sidiff.matching.api.settings;

import java.util.Objects;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.sidiff.candidates.CandidatesUtil;
import org.sidiff.candidates.ICandidates;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.common.settings.BaseSettings;
import org.sidiff.correspondences.CorrespondencesUtil;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matching.api.util.MatchingUtils;

/**
 * 
 * @author cpietsch
 * @see MatchingSettingsItem
 */
public class MatchingSettings extends BaseSettings {

	private static final String PLUGIN_ID = "org.sidiff.matching.api";

	/**
	 * The Matcher for calculating correspondences.
	 */
	private IMatcher matcher;

	/**
	 * 
	 */
	private ICandidates candidatesService;

	/**
	 * 
	 */
	private ICorrespondences correspondencesService;

	/**
	 * default {@link MatchingSettings}
	 */
	public MatchingSettings() {
		super();
		this.matcher = MatchingUtils.getGenericMatchers().iterator().next();
		this.candidatesService = CandidatesUtil.getCandidatesServiceInstance();
		this.correspondencesService = CorrespondencesUtil.getDefaultCorrespondencesService();
	}

	public MatchingSettings(Set<String> documentTypes) {
		super();
		this.matcher = MatchingUtils.getAvailableMatchers(documentTypes).iterator().next();
		this.candidatesService = CandidatesUtil.getCandidatesServiceInstance();
		this.correspondencesService = CorrespondencesUtil.getDefaultCorrespondencesService();
	}

	public MatchingSettings(Scope scope, boolean validate, IMatcher matcher,
			ICandidates candidatesService, ICorrespondences correspondencesService) {
		super(scope, validate);
		this.matcher = matcher;
		this.candidatesService = candidatesService;
		this.correspondencesService = correspondencesService;
		
	}

	@Override
	public void validate(MultiStatus multiStatus) {
		super.validate(multiStatus);

		if(matcher == null) {
			multiStatus.add(new Status(IStatus.ERROR, PLUGIN_ID, 0, "Matcher is not set.", null));
		} else if(getScope() != null && getScope().equals(Scope.RESOURCE_SET) && !matcher.isResourceSetCapable()) {
			multiStatus.add(new Status(IStatus.ERROR, PLUGIN_ID, 0, "Selected Matcher " + matcher.getName()
				+ " does not support ResourceSet-Scope, please change the Matcher or Scope!", null));
		}

		if(correspondencesService == null) {
			multiStatus.add(new Status(Diagnostic.ERROR, PLUGIN_ID, 0, "Correspondences Service is not set.", null));
		}

		// TODO CPietsch (2016-02-07): Checks for similarity based matching settings
	}

	@Override
	public String toString() {
		return new StringBuilder(super.toString()).append("\n")
			.append("MatchingSettings[")
			.append("Matcher: ").append(getMatcher() != null ? getMatcher().getName() : "none").append(", ")
			.append("Candidates Service: ").append(getCandidatesService() != null ? getCandidatesService().getServiceID() : "none").append(", ")
			.append("Correspondences Service: ").append(getCorrespondencesService() != null ? getCorrespondencesService().getServiceID() : "none").append(", ")
			.append("]")
			.toString();
	}

	// ---------- Getter and Setter Methods----------

	/**
	 * @return The Matcher for model comparison.
	 * @see MatchingSettingsItem#MATCHER
	 */
	public IMatcher getMatcher() {
		return matcher;
	}

	/**
	 * @param matcher The Matcher for model comparison.
	 * @see MatchingSettingsItem#MATCHER
	 */
	public void setMatcher(IMatcher matcher) {
		if (!Objects.equals(this.matcher, matcher)) {
			this.matcher = matcher;
			if(this.matcher != null) {
				this.matcher.setCorrespondencesService(this.correspondencesService);
				this.matcher.setCandidatesService(this.candidatesService);
			}
			notifyListeners(MatchingSettingsItem.MATCHER);
		}
	}

	/**
	 * 
	 * @return
	 * @see MatchingSettingsItem#CANDITATE_SERVICE
	 */
	public ICandidates getCandidatesService() {
		return candidatesService;
	}

	/**
	 * 
	 * @param candidateService
	 * @see MatchingSettingsItem#CANDITATE_SERVICE
	 */
	public void setCandidatesService(ICandidates candidateService) {
		if (!Objects.equals(this.candidatesService, candidateService)) {
			this.candidatesService = candidateService;
			if(this.matcher != null) {
				this.matcher.setCandidatesService(candidateService);
			}
			notifyListeners(MatchingSettingsItem.CANDITATE_SERVICE);
		}
	}

	/**
	 * 
	 * @return
	 * @see MatchingSettingsItem#CORRESPONDENCE_SERVICE
	 */
	public ICorrespondences getCorrespondencesService() {
		return correspondencesService;
	}

	/**
	 * 
	 * @param correspondencesService
	 * @see MatchingSettingsItem#CORRESPONDENCE_SERVICE
	 */
	public void setCorrespondencesService(ICorrespondences correspondencesService) {
		if (!Objects.equals(this.correspondencesService, correspondencesService)) {
			this.correspondencesService = correspondencesService;
			if(this.matcher != null) {
				this.matcher.setCorrespondencesService(correspondencesService);
			}
			notifyListeners(MatchingSettingsItem.CORRESPONDENCE_SERVICE);
		}
	}

}
