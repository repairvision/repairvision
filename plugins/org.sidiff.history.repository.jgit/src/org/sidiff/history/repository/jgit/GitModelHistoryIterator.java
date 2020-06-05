package org.sidiff.history.repository.jgit;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.revwalk.RevCommit;
import org.sidiff.history.repository.IModelVersion;

public class GitModelHistoryIterator implements Iterator<IModelVersion> {
	
	private GitModelVersion latestModelVersion;
	
	private Iterator<RevCommit> commits;

	public GitModelHistoryIterator(Git git, GitModelVersion modelVersion) {
		this.latestModelVersion = modelVersion;
		
		try {
			this.commits = git.log().add(git.getRepository().resolve(Constants.HEAD))
					.addPath(modelVersion.getRepositoryLocation()).call().iterator();
		} catch (Throwable e) {
			e.printStackTrace();
			this.commits = Collections.emptyIterator();
		}
	}

	@Override
	public boolean hasNext() {
		return commits.hasNext();
	}

	@Override
	public IModelVersion next() {

		RevCommit revCommit = commits.next();
		GitModelVersion modelVersion = new GitModelVersion(
				revCommit.toObjectId(), 
				latestModelVersion.getRepository(), 
				latestModelVersion.getRepositoryLocation());
		modelVersion.setWorkspaceLocation(
				latestModelVersion.getWorkspaceLocation(), 
				modelVersion.getVersion());

		return modelVersion;
	}

}
