package org.sidiff.repair.api.undo;

public interface IRepairCommand {

	boolean apply();
	
	boolean undo();
}
