package org.sidiff.repair.api.cpo;

import java.util.Collection;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.api.IRepairSettings;

public class CPORepairSettings implements IRepairSettings {

	/**
	 * All edit-rules which are to be investigated for partial executions.
	 */
	private Collection<Rule> subEditRules;
	
	/**
	 * All consistency-preserving edit-operations.
	 */
	private Collection<Rule> cpoEditRules;
	
	/**
	 * The document type of the models.
	 */
	private String documentType;
	
	/**
	 * The settings for the difference calculation.
	 */
	private DifferenceSettings differenceSettings;

	
	/**
	 * @param subEditRules
	 *            All edit-rules which are to be investigated for partial
	 *            executions.
	 * @param cpoEditRules
	 *            All consistency-preserving edit-operations.
	 * @param documentType
	 *            The document type of the models.
	 * @param differenceSettings
	 *            The settings for the difference calculation.
	 */
	public CPORepairSettings(
			Collection<Rule> subEditRules, Collection<Rule> cpoEditRules, 
			String documentType, DifferenceSettings differenceSettings) {
		super();
		this.subEditRules = subEditRules;
		this.cpoEditRules = cpoEditRules;
		this.documentType = documentType;
		this.differenceSettings = differenceSettings;
	}

	public Collection<Rule> getSubEditRules() {
		return subEditRules;
	}

	public void setSubEditRules(Collection<Rule> subEditRules) {
		this.subEditRules = subEditRules;
	}

	public Collection<Rule> getCPOEditRules() {
		return cpoEditRules;
	}

	public void setCPOEditRules(Collection<Rule> cpoEditRules) {
		this.cpoEditRules = cpoEditRules;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public DifferenceSettings getDifferenceSettings() {
		return differenceSettings;
	}

	public void setDifferenceSettings(DifferenceSettings differenceSettings) {
		this.differenceSettings = differenceSettings;
	}
}
