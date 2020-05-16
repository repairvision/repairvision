package org.sidiff.revision.difference.api.settings;

import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.sidiff.common.utilities.emf.Scope;
import org.sidiff.revision.difference.api.util.MatchingUtils;
import org.sidiff.revision.difference.matcher.IMatcher;

public class MatchingSettings {
	
	private static final String PLUGIN_ID = "org.sidiff.revision.difference.api";
	
	/**
	 * The {@link Scope} of the comparison. (Default: {@link Scope#RESOURCE}.
	 */
	private Scope scope = Scope.RESOURCE;

	/**
	 * The Matcher for calculating correspondences.
	 */
	private IMatcher matcher;
	
	/**
	 * default {@link MatchingSettings}
	 */
	public MatchingSettings() {
		super();
		this.matcher = MatchingUtils.getGenericMatchers().iterator().next();
	}

	public MatchingSettings(Set<String> documentTypes) {
		super();
		this.matcher = MatchingUtils.getAvailableMatchers(documentTypes).iterator().next();
	}

	public MatchingSettings(Scope scope, IMatcher matcher) {
		this.scope = scope;
		this.matcher = matcher;
	}

	@Override
	public String toString() {
		return new StringBuilder(super.toString()).append("\n")
			.append("MatchingSettings[")
			.append("Scope: ").append(getScope()).append(", ")
			.append("Matcher: ").append(getMatcher() != null ? getMatcher().getName() : "none").append(", ")
			.append("]")
			.toString();
	}
	
	public void validate(MultiStatus multiStatus) {
		
		if(getScope() == null) {
			multiStatus.add(new Status(IStatus.ERROR, PLUGIN_ID, 0, "Scope is not set.", null));
		}
		
		if (getMatcher() == null) {
			multiStatus.add(new Status(IStatus.ERROR, PLUGIN_ID, 0, "Matcher is not set.", null));
		}
	}

	// ---------- Getter and Setter Methods----------

	/**
	 * @return The {@link Scope} of the comparison.
	 * @see BaseSettingsItem#SCOPE
	 */
	public Scope getScope() {
		return scope;
	}

	/**
	 * Setup the new {@link Scope} of the comparison.
	 * 
	 * @param scope The new {@link Scope}.
	 * @see BaseSettingsItem#SCOPE
	 */
	public void setScope(Scope scope) {
		this.scope = scope;
	}

	/**
	 * @return The Matcher for model comparison.
	 */
	public IMatcher getMatcher() {
		return matcher;
	}
	
	/**
	 * @param matcher The Matcher for model comparison.
	 */
	public void setMatcher(IMatcher matcher) {
		this.matcher = matcher;
	}
}
