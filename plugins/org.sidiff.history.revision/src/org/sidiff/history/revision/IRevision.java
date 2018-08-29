package org.sidiff.history.revision;

import org.sidiff.history.revision.difference.IDifference;
import org.sidiff.history.revision.metamodel.IMetaModel;

public interface IRevision {

	IMetaModel getMetaModel();
	
	IVersion getVersionA();
	
	IVersion getVersionB();
	
	IDifference getDifference();
}
