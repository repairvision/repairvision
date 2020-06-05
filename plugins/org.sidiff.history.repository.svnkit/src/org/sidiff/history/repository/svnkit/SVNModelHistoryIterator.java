package org.sidiff.history.repository.svnkit;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.sidiff.history.repository.IModelVersion;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc2.SvnLog;
import org.tmatesoft.svn.core.wc2.SvnOperationFactory;
import org.tmatesoft.svn.core.wc2.SvnRevisionRange;
import org.tmatesoft.svn.core.wc2.SvnTarget;

public class SVNModelHistoryIterator implements Iterator<IModelVersion> {

	private SVNModelVersion latestModelVersion;
	
	private Iterator<?> logs;
	
	public SVNModelHistoryIterator(SVNModelVersion latestModelVersion) {
		this.latestModelVersion = latestModelVersion;
	}

	private Iterator<?> getLogs() {
		if (logs == null) {
			try {
				SVNURL location = latestModelVersion.getSVNRepositoryLocation();
				
				SvnLog logOperation = new SvnOperationFactory().createLog();
				logOperation.setSingleTarget(SvnTarget.fromURL(location));
				logOperation.setRevisionRanges(
						Collections.singleton(SvnRevisionRange.create(SVNRevision.create(1), SVNRevision.HEAD)));
				
				Collection<?> logEntries = logOperation.run(null);
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
