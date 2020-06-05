package org.sidiff.history.repository.jgit.util;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class GitUtil {

	/**
	 * @param repository The repository.
	 * @param file       A absolute file path.
	 * @return The path relative to the repository.
	 */
	public static String getRepositoryPath(Git repository, File file) {
		return repository.getRepository().getDirectory().getParentFile().toURI().relativize(file.toURI()).getPath();
	}

	/**
	 * @param file A file in the repository.
	 * @return The repository API.
	 * @throws IOException
	 */
	public static Git getRepository(File file) throws IOException {
		return new Git(new FileRepositoryBuilder().findGitDir(file).build());
	}

	/**
	 * @param directory The Git directory (containing .git folder)
	 * @return The repository API.
	 * @throws IOException
	 */
	public static Git getRepository(String directory) throws IOException {
		return new Git(FileRepositoryBuilder.create(new File(directory)));
	}
}
