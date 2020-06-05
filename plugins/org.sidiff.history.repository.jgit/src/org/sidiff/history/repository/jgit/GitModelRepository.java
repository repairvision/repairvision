package org.sidiff.history.repository.jgit;

import org.sidiff.history.repository.IModelHistory;
import org.sidiff.history.repository.IModelRepository;
import org.sidiff.history.repository.IModelVersion;

public class GitModelRepository implements IModelRepository {

	@Override
	public IModelHistory getModelVersions(IModelVersion modelVersion) {
		return new GitModelHistory((GitModelVersion) modelVersion);
	}

}
