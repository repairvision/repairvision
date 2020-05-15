package org.sidiff.revision.difference.derivation.api.settings;

import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.sidiff.candidates.ICandidates;
import org.sidiff.common.utilities.emf.Scope;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.correspondences.matchingmodel.MatchingModelCorrespondences;
import org.sidiff.matcher.IMatcher;
import org.sidiff.revision.difference.derivation.ITechnicalDifferenceBuilder;
import org.sidiff.revision.difference.derivation.api.util.TechnicalDifferenceUtils;

public class DifferenceSettings extends MatchingSettings {

	private static final String PLUGIN_ID = "org.sidiff.revision.difference.derivation.api";

	/**
	 * The Technical Difference Builder to use.
	 */
	private ITechnicalDifferenceBuilder techBuilder;

	/**
	 * default {@link DifferenceSettings}
	 */
	public DifferenceSettings() {
		super();
		this.techBuilder = TechnicalDifferenceUtils.getGenericTechnicalDifferenceBuilder();
		setCorrespondencesService(new MatchingModelCorrespondences());
	}

	public DifferenceSettings(Set<String> documentTypes) {
		super(documentTypes);
		this.techBuilder = TechnicalDifferenceUtils.getDefaultTechnicalDifferenceBuilder(documentTypes);
		setCorrespondencesService(new MatchingModelCorrespondences());
	}

	public DifferenceSettings(Scope scope, boolean validate, IMatcher matcher, ICandidates candidatesService,
			ICorrespondences correspondenceService, ITechnicalDifferenceBuilder techBuilder) {
		super(scope, validate, matcher, candidatesService, correspondenceService);
		this.techBuilder = techBuilder;
	}

	@Override
	public void validate(MultiStatus multiStatus) {
		super.validate(multiStatus);

		if(techBuilder == null) {
			multiStatus.add(new Status(IStatus.ERROR, PLUGIN_ID, 0, "Technical Difference Builder is not set.", null));
		}
	}

	@Override
	public String toString() {
		return new StringBuilder(super.toString()).append("\n")
			.append("DifferenceSettings[")
			.append("Technical-Difference-Builder: ").append(getTechBuilder() != null ? getTechBuilder().getName() : "none")
			.append("]")
			.toString();
	}

	// ---------- Getter and Setter Methods----------

	/**
	 * @return The Technical Difference Builder. ({@link ITechnicalDifferenceBuilder})
	 * @see DifferenceSettingsItem#TECH_BUILDER
	 */
	public ITechnicalDifferenceBuilder getTechBuilder() {
		return techBuilder;
	}

	/**
	 * @param techBuilder The Technical Difference Builder. ({@link ITechnicalDifferenceBuilder})
	 * @see DifferenceSettingsItem#TECH_BUILDER
	 */
	public void setTechBuilder(ITechnicalDifferenceBuilder techBuilder) {
		this.techBuilder = techBuilder;
	}
}
