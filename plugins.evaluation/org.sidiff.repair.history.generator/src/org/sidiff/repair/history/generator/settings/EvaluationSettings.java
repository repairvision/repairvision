package org.sidiff.repair.history.generator.settings;

import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.history.analysis.validation.IValidator;
import org.sidiff.repair.history.generator.repository.IHistoryRepository;

public class EvaluationSettings {
	
	private String historyName;
	
	private String[] fileFilters;
	
	private IHistoryRepository repository; 
	
	private DifferenceSettings differenceSettings;

	private IValidator validator;

	public EvaluationSettings(
			String history_name, 
			String[] fileFilters, 
			IHistoryRepository repository,
			DifferenceSettings differenceSettings,
			IValidator validator) {
		super();
		this.historyName = history_name;
		this.fileFilters = fileFilters;
		this.repository = repository;
		this.differenceSettings = differenceSettings;
		this.validator = validator;
	}

	public String getHistoryName() {
		return historyName;
	}

	public void setHistoryName(String historyName) {
		this.historyName = historyName;
	}

	public String[] getFileFilters() {
		return fileFilters;
	}

	public void setFileFilters(String[] fileFilters) {
		this.fileFilters = fileFilters;
	}
	
	public IHistoryRepository getRepository() {
		return repository;
	}
	
	public void setRepository(IHistoryRepository repository) {
		this.repository = repository;
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
