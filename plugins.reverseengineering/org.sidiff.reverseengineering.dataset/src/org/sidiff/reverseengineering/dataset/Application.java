package org.sidiff.reverseengineering.dataset;

import java.io.File;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.sidiff.reverseengineering.dataset.history.model.FileChange;
import org.sidiff.reverseengineering.dataset.history.model.History;
import org.sidiff.reverseengineering.dataset.history.model.Version;
import org.sidiff.reverseengineering.dataset.history.repository.FileDiff;
import org.sidiff.reverseengineering.dataset.history.repository.GitRepository;
import org.sidiff.reverseengineering.dataset.history.repository.filter.VersionFilter;
import org.sidiff.reverseengineering.dataset.history.util.HistoryIterator;

public class Application implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		GitRepository repo = new GitRepository(new File("C:\\Users\\manue\\git\\gitanalyzerplus-sampleproject"));
		History history = repo.getHistory(VersionFilter.FILTER_NOTHING);
		
		for (Version version : (Iterable<Version>) () -> new HistoryIterator(history)) {
//			if (version.getIdentification().equals("40f1269975827c69721a79e29a650a32221887b0")) {
				System.out.println(version);
//				version.setFileChanges(repo.getChanges(version, false));
				
//				for (FileChange changedFile : version.getFileChanges()) {
//					System.out.println("\t\t" + changedFile);
//				}
				
				for (FileDiff fileDiff : repo.computeMergeCommit(version)) {
					System.out.println("\t\t" + fileDiff.getPath());
				}
//			}
		}
		
		return null;
	}

	@Override
	public void stop() {
	}

}
