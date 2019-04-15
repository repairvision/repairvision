package org.sidiff.difference.technical.api.settings;

import java.util.Objects;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.sidiff.candidates.ICandidates;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.correspondences.matchingmodel.MatchingModelCorrespondences;
import org.sidiff.difference.technical.ITechnicalDifferenceBuilder;
import org.sidiff.difference.technical.api.util.TechnicalDifferenceUtils;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matching.api.settings.MatchingSettings;

/**
 * @see DifferenceSettingsItem
 */
public class DifferenceSettings extends MatchingSettings {

	private static final String PLUGIN_ID = "org.sidiff.difference.technical.api";

	/**
	 * Enables/disables the internal mergeImports function (more specifically
	 * the EObject location lookup) This lookup is quite costly when comparing
	 * big models and can be disabled here for performance gain however at the
	 * expense of some matching correctness.
	 */
	private boolean mergeImports = true;

	/**
	 * Finally clean up merge imports.
	 */
	private boolean unmergeImports = true;

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
			.append("Merge Imports: ").append(isEnabled_MergeImports()).append(", ")
			.append("Unmerge Imports: ").append(isEnabled_UnmergeImports()).append(", ")
			.append("Technical-Difference-Builder: ").append(getTechBuilder() != null ? getTechBuilder().getName() : "none")
			.append("]")
			.toString();
	}

	// ---------- Getter and Setter Methods----------

	/**
	 * Returns whether mergeImports (esp. EObject Localization Lookup) is enabled. (Default: true)
	 * @return <code>true</code> if enabled; <code>false</code> otherwise.
	 * @see DifferenceSettingsItem#MERGE_IMPORTS
	 */
	public boolean isEnabled_MergeImports() {
		return mergeImports;
	}

	/**
	 * Enables/disables mergeImports (esp. EObject Localization Lookup). (Default: true)
	 * @param mergeImports <code>true</code> if enabled; <code>false</code> otherwise.
	 * @see DifferenceSettingsItem#MERGE_IMPORTS
	 */
	public void setMergeImports(boolean mergeImports) {
		if (this.mergeImports != mergeImports) {
			this.mergeImports = mergeImports;
			notifyListeners(DifferenceSettingsItem.MERGE_IMPORTS);
		}
	}

	/**
	 * Finally clean up merge imports.
	 * @return <code>true</code> if enabled; <code>false</code> otherwise.
	 * @see DifferenceSettingsItem#UNMERGE_IMPORTS
	 */
	public boolean isEnabled_UnmergeImports() {
		return unmergeImports;
	}

	/**
	 * Finally clean up merge imports.
	 * @param unmergeImports <code>true</code> if enabled; <code>false</code> otherwise.
	 * @see DifferenceSettingsItem#UNMERGE_IMPORTS
	 */
	public void setUnmergeImports(boolean unmergeImports) {
		if (this.unmergeImports != unmergeImports) {
			this.unmergeImports = unmergeImports;
			notifyListeners(DifferenceSettingsItem.UNMERGE_IMPORTS);
		}
	}

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
		if (!Objects.equals(this.techBuilder, techBuilder)) {
			this.techBuilder = techBuilder;
			notifyListeners(DifferenceSettingsItem.TECH_BUILDER);
		}
	}
}
