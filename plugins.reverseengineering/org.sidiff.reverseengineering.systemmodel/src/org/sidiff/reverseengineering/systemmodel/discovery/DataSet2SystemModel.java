package org.sidiff.reverseengineering.systemmodel.discovery;

import java.time.Instant;

import org.sidiff.reverseengineering.dataset.history.model.FileChange;
import org.sidiff.reverseengineering.dataset.history.model.LineChange;
import org.sidiff.reverseengineering.dataset.history.model.Version;
import org.sidiff.reverseengineering.systemmodel.ChangeType;
import org.sidiff.reverseengineering.systemmodel.SystemModelFactory;

public class DataSet2SystemModel {
	
	public ChangeType convertChange(LineChange lineChange) {
		switch (lineChange.getType()) {
		case DELETE:
			return ChangeType.DELETE;
		case EMPTY:
			return ChangeType.DELETE;
		case INSERT:
			return ChangeType.ADD;
		case REPLACE:
			return ChangeType.MODIFY;
		default:
			return ChangeType.MODIFY;
		}
	}
	
	public ChangeType convertChange(FileChange fileChange) {
		switch (fileChange.getType()) {
		case DELETE:
			return ChangeType.DELETE;
		case ADD:
			return ChangeType.ADD;
		case MODIFY:
			return ChangeType.MODIFY;
		default:
			return ChangeType.MODIFY;
		}
	}
	
	public org.sidiff.reverseengineering.systemmodel.TracedVersion convertVersion(Version version) {
		org.sidiff.reverseengineering.systemmodel.TracedVersion eVersion = SystemModelFactory.eINSTANCE.createTracedVersion();
		eVersion.setCodeVersionID(version.getIdentificationTrace());
		eVersion.setModelVersionID(version.getIdentification());
		eVersion.setDate(convertDate(version.getDate()));
		eVersion.setAuthor(version.getAuthor());
		eVersion.setCommitMessage(version.getCommitMessage());
		return eVersion;
	}
	
	public String convertDate(Instant date) {
		return date.toString();
	}
	
}
