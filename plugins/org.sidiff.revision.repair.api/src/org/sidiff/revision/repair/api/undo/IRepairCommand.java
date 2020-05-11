package org.sidiff.revision.repair.api.undo;

public interface IRepairCommand {

	boolean apply();
	
	boolean undo();
}
