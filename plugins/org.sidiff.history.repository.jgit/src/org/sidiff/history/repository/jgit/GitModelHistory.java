package org.sidiff.history.repository.jgit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.sidiff.history.repository.IModelHistory;
import org.sidiff.history.repository.IModelVersion;
import org.sidiff.history.repository.jgit.util.GitUtil;
import org.sidiff.history.repository.util.ModelRepositoryUtil;

public class GitModelHistory implements IModelHistory {

	private GitModelVersion latestModelVersion;
	
	private Git git;
	
	public GitModelHistory(GitModelVersion modelVersion) {
		this.latestModelVersion = modelVersion;
		
		try {
			this.git = GitUtil.getRepository(latestModelVersion.getRepository());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Iterator<IModelVersion> iterator() {
		return new GitModelHistoryIterator(git, latestModelVersion);
	}
	
	@Override
	public Resource loadModelVersion(ResourceSet resourceSet, IModelVersion modelVersion) {
		GitModelVersion gitModelVersion = (GitModelVersion) modelVersion;
		
		try {
			
			// Check out:
			File localFile = ModelRepositoryUtil.getModelFile(modelVersion.getWorkspaceLocation());
			localFile.getParentFile().mkdirs();
			
			
			try (FileOutputStream fos = new FileOutputStream(localFile)) {
				try (ObjectReader reader = git.getRepository().newObjectReader()) {
					try (RevWalk revWalk = new RevWalk(git.getRepository())) {
						RevCommit commit = revWalk.parseCommit(gitModelVersion.getObjectID());
		            	TreeWalk treewalk = TreeWalk.forPath(reader, gitModelVersion.getRepositoryLocation(), commit.getTree());
		            	reader.open(treewalk.getObjectId(0)).copyTo(fos);
					}
				}
			}
			
			// Load model:
			return resourceSet.getResource(gitModelVersion.getWorkspaceLocation(), true);
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void close() throws IOException {
		if (git != null) {
			git.close();
		}
	}

}
