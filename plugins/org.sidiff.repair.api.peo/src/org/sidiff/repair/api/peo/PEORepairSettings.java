package org.sidiff.repair.api.peo;

import java.util.Collection;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.api.BasicRepairSettings;

public class PEORepairSettings extends BasicRepairSettings {

	/**
	 * All edit-rules which are to be investigated for partial executions.
	 */
	private Collection<Rule> editRules;
	
	/**
	 * The settings for the difference calculation.
	 */
	private DifferenceSettings differenceSettings;

	public PEORepairSettings(Collection<Rule> editRules, DifferenceSettings differenceSettings) {
		super();
		this.editRules = editRules;
		this.differenceSettings = differenceSettings;
	}

	public Collection<Rule> getEditRules() {
		return editRules;
	}

	public void setEditRules(Collection<Rule> editRules) {
		this.editRules = editRules;
	}

	public DifferenceSettings getDifferenceSettings() {
		return differenceSettings;
	}

	public void setDifferenceSettings(DifferenceSettings differenceSettings) {
		this.differenceSettings = differenceSettings;
	}
}
