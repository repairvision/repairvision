package org.sidiff.repair.history.generator.settings;

import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.history.generator.validation.IValidator;

public class EvaluationSettings {
	
	private String history_name;
	
	private String[] fileFilters;
	
	private DifferenceSettings differenceSettings;

	private IValidator validator;

	public EvaluationSettings(
			String history_name, 
			String[] fileFilters, 
			DifferenceSettings differenceSettings,
			IValidator validator) {
		super();
		this.history_name = history_name;
		this.fileFilters = fileFilters;
		this.differenceSettings = differenceSettings;
		this.validator = validator;
	}

	public String getHistory_name() {
		return history_name;
	}

	public void setHistory_name(String history_name) {
		this.history_name = history_name;
	}

	public String[] getFileFilters() {
		return fileFilters;
	}

	public void setFileFilters(String[] fileFilters) {
		this.fileFilters = fileFilters;
	}

	public DifferenceSettings getDifferenceSettings() {
		return differenceSettings;
	}

	public void setDifferenceSettings(DifferenceSettings differenceSettings) {
		this.differenceSettings = differenceSettings;
	}

	public IValidator getValidator() {
		return validator;
	}

	public void setValidator(IValidator validator) {
		this.validator = validator;
	}
}
