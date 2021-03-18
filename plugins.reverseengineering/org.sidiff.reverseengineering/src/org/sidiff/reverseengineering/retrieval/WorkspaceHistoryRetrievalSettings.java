package org.sidiff.reverseengineering.retrieval;

import java.nio.file.Path;
import java.util.function.Supplier;

import org.sidiff.reverseengineering.dataset.history.repository.GitRepository;
import org.sidiff.reverseengineering.dataset.history.repository.Repository;
import org.sidiff.reverseengineering.dataset.history.repository.filter.VersionFilter;
import org.sidiff.reverseengineering.dataset.history.util.FileChangeFilter;

public class WorkspaceHistoryRetrievalSettings {
	
	/**
	 * Save the updated data set with an appended time stamp.
	 */
	private boolean appendTimestampToDataSet =  false;
	
	/**
	 * The repository containing the source code to be discovered.
	 */
	private Supplier<Repository> codeRepository;
	
	/**
	 * Matches version in of the source code repository that represent bug fixes.
	 */
	private Supplier<VersionFilter> versionFilter;
	
	public WorkspaceHistoryRetrievalSettings(
			Supplier<Repository> codeRepository,
			FileChangeFilter fileChangeFilter) {
		this.codeRepository = codeRepository;
		this.versionFilter = () -> VersionFilter.FILTER_NOTHING;
	}

	public WorkspaceHistoryRetrievalSettings(String codeRepositoryURL, Path codeRepositoryPath) {
		// With URL for cloning if not found in specified git folder.
		this.codeRepository = () -> new GitRepository(codeRepositoryURL, codeRepositoryPath.toFile());
		this.versionFilter = () -> VersionFilter.FILTER_NOTHING;
	}
	
	public WorkspaceHistoryRetrievalSettings(Path codeRepositoryPath) {
		this(null, codeRepositoryPath);
	}
	
	public boolean isAppendTimestampToDataSet() {
		return appendTimestampToDataSet;
	}

	public void setAppendTimestampToDataSet(boolean appendTimestampToDataSet) {
		this.appendTimestampToDataSet = appendTimestampToDataSet;
	}
	
	public Repository createCodeRepository() {
		return codeRepository.get();
	}
	
	public void setCodeRepository(Supplier<Repository> codeRepository) {
		this.codeRepository = codeRepository;
	}
	
	public VersionFilter createVersionFilter() {
		return versionFilter.get();
	}
	
	public void setVersionFilter(Supplier<VersionFilter> versionFilter) {
		this.versionFilter = versionFilter;
	}
}
