package org.sidiff.revision.api.undo;

public interface IEditCommand {

	boolean apply();
	
	boolean undo();
}
