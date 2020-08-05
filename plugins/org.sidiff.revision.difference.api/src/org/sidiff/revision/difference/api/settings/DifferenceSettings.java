package org.sidiff.revision.difference.api.settings;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.sidiff.revision.common.emf.document.Scope;
import org.sidiff.revision.difference.api.registry.DifferenceBuilderRegistry;
import org.sidiff.revision.difference.builder.IDifferenceBuilderProvider;
import org.sidiff.revision.difference.matcher.IMatcherProvider;

public class DifferenceSettings extends MatchingSettings {

	private static final String PLUGIN_ID = "org.sidiff.revision.difference.api";

	/**
	 * The Technical Difference Builder to use.
	 */
	private IDifferenceBuilderProvider techBuilder;

	/**
	 * default {@link DifferenceSettings}
	 */
	public DifferenceSettings() {
		super();
		this.techBuilder = DifferenceBuilderRegistry.getGenericTechnicalDifferenceBuilder();
	}

	public DifferenceSettings(Scope scope, IMatcherProvider matcherProvider, IDifferenceBuilderProvider techBuilder) {
		super(scope, matcherProvider);
		this.techBuilder = techBuilder;
	}

	@Override
	public void validate(MultiStatus multiStatus) {
		super.validate(multiStatus);

		if (getTechBuilder() == null) {
			multiStatus.add(new Status(IStatus.ERROR, PLUGIN_ID, 0, "Technical Difference Builder is not set.", null));
		}
	}

	@Override
	public String toString() {
		return new StringBuilder(super.toString()).append("\n")
				.append("DifferenceSettings[")
				.append("Technical-Difference-Builder: ").append(getTechBuilder() != null ? getTechBuilder().getName() : "none").append("]").toString();
	}

	// ---------- Getter and Setter Methods----------

	/**
	 * @return The Technical Difference Builder.
	 *         ({@link IDifferenceBuilderProvider})
	 * @see DifferenceSettingsItem#TECH_BUILDER
	 */
	public IDifferenceBuilderProvider getTechBuilder() {
		return techBuilder;
	}

	/**
	 * @param techBuilder The Technical Difference Builder.
	 *                    ({@link IDifferenceBuilderProvider})
	 * @see DifferenceSettingsItem#TECH_BUILDER
	 */
	public void setTechBuilder(IDifferenceBuilderProvider techBuilder) {
		this.techBuilder = techBuilder;
	}
}
