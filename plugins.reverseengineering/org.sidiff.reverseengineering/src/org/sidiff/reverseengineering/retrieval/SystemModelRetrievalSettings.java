package org.sidiff.reverseengineering.retrieval;

import java.nio.file.Path;
import java.util.function.Supplier;

import org.sidiff.reverseengineering.dataset.history.util.FileChangeFilter;
import org.sidiff.reverseengineering.dataset.workspace.filter.JavaProjectFilter;
import org.sidiff.reverseengineering.dataset.workspace.filter.ProjectFilter;

public class SystemModelRetrievalSettings extends WorkspaceHistoryRetrievalSettings {
	
	/**
	 * Save the updated data set with an appended time stamp.
	 */
	private boolean appendTimestampToDataSet =  true;
	
	/**
	 * Filters projects from the source code repository, e.g., test code projects
	 * and by default searches PDE projects.
	 */
	private Supplier<ProjectFilter> projectFilter;
	
	/**
	 * Files to be tested for changes, whether a model needs to be recalculated.
	 */
	private FileChangeFilter fileChangeFilter;
	
	/**
	 * Cyclic save of the data set.
	 */
	private int intermediateSave = -1;
	
	/**
	 * Transform method bodies in system model.
	 */
	private boolean includeMethodBodies = false;
	
	public SystemModelRetrievalSettings(String codeRepositoryURL, Path codeRepositoryPath) {
		super(codeRepositoryURL, codeRepositoryPath);
		this.projectFilter =  () -> new JavaProjectFilter(); // new PDEProjectFilter();
		this.fileChangeFilter = (fileChange) -> !fileChange.getLocation().toString().toLowerCase().endsWith(".java");
		this.intermediateSave = 200;
	}
	
	public SystemModelRetrievalSettings(Path codeRepositoryPath) {
		this(null, codeRepositoryPath);
	}
	
	public boolean isAppendTimestampToDataSet() {
		return appendTimestampToDataSet;
	}

	public void setAppendTimestampToDataSet(boolean appendTimestampToDataSet) {
		this.appendTimestampToDataSet = appendTimestampToDataSet;
	}

	public ProjectFilter createProjectFilter() {
		return projectFilter.get();
	}

	public void setProjectFilter(Supplier<ProjectFilter> projectFilter) {
		this.projectFilter = projectFilter;
	}

	public FileChangeFilter getFileChangeFilter() {
		return fileChangeFilter;
	}

	public void setFileChangeFilter(FileChangeFilter fileChangeFilter) {
		this.fileChangeFilter = fileChangeFilter;
	}

	public int getIntermediateSave() {
		return intermediateSave;
	}

	public void setIntermediateSave(int intermediateSave) {
		this.intermediateSave = intermediateSave;
	}

	public boolean isIncludeMethodBodies() {
		return includeMethodBodies;
	}

	public void setIncludeMethodBodies(boolean includeMethodBodies) {
		this.includeMethodBodies = includeMethodBodies;
	}
}
