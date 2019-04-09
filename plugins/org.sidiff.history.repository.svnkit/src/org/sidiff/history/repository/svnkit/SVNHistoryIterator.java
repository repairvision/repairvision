package org.sidiff.history.repository.svnkit;

import java.util.Collection;
import java.util.Iterator;

import org.sidiff.history.repository.IModelVersion;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;

public class SVNHistoryIterator implements Iterator<IModelVersion> {

	private SVNModelVersion latestModelVersion;
	
	private Iterator<?> logs;
	
	private boolean changePath = false;
	
	public SVNHistoryIterator(SVNModelVersion latestModelVersion) {
		this.latestModelVersion = latestModelVersion;
	}

	private Iterator<?> getLogs() {
		if (logs == null) {
			try {
				SVNURL location = latestModelVersion.getSVNRepositoryLocation();
				
				SVNRepository repository = SVNRepositoryFactory.create(location);
				Collection<?> logEntries = repository.log(new String[] { location.getPath() }, 
						(Collection<?>) null, latestModelVersion.getSVNVersion().getNumber(), 0, changePath, false);
				
				logs = logEntries.iterator();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return logs;
	}
	
	@Override
	public boolean hasNext() {
		return getLogs().hasNext();
	}

	@Override
	public SVNModelVersion next() {
		SVNLogEntry logEntry = (SVNLogEntry) logs.next();
		
		SVNURL location = latestModelVersion.getSVNRepositoryLocation();
		SVNModelVersion historicVersion = new SVNModelVersion(logEntry.getRevision(), location);
		historicVersion.setWorkspaceLocation(latestModelVersion.getWorkspaceLocation(), logEntry.getRevision());
		
		return historicVersion;
	}
}
