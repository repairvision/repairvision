package org.sidiff.history.repository.jgit;

import static org.sidiff.history.repository.jgit.util.GitUtil.getRepository;
import static org.sidiff.history.repository.jgit.util.GitUtil.getRepositoryPath;
import static org.sidiff.history.repository.util.ModelRepositoryUtil.getModelFile;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.LogCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.revwalk.RevCommit;
import org.sidiff.history.repository.IModelRepositoryConnector;
import org.sidiff.history.repository.IModelVersion;

public class GitModelRepositoryConnector implements IModelRepositoryConnector {

	@Override
	public boolean canHandle(URI resource) {
		try(Git git = getRepository(getModelFile(resource))) {
			return true;
		} catch (Throwable e) {
		}
		return false;
	}

	@Override
	public IModelVersion getModelVersion(URI resource) {
		File modelFile = getModelFile(resource);
		
		try(Git git = getRepository(modelFile)) {
			String repositoryPath = getRepositoryPath(git, modelFile);
			LogCommand logCommand = git.log().add(git.getRepository().resolve(Constants.HEAD)).addPath(repositoryPath);
			
			 for (RevCommit revCommit : logCommand.call()) {
				 String repositoryDirectory = git.getRepository().getDirectory().getAbsolutePath();
				 GitModelVersion modelVersion = new GitModelVersion(revCommit.toObjectId(), repositoryDirectory, repositoryPath);
				 modelVersion.setWorkspaceLocation(resource);
				 return modelVersion;
			 }
		} catch (IOException | GitAPIException e) {
			e.printStackTrace();
		}

		return null;
	}

}
