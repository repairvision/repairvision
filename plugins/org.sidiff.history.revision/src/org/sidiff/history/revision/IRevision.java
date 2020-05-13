package org.sidiff.history.revision;

import org.sidiff.history.revision.difference.IRevisionDifference;
import org.sidiff.history.revision.metamodel.IMetaModel;

public interface IRevision {

	IMetaModel getMetaModel();
	
	IVersion getVersionA();
	
	IVersion getVersionB();
	
	IRevisionDifference getDifference();
}
