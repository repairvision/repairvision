package org.sidiff.revision.repair.ui.debugger.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.repair.api.RepairCalculationEngineDebugger;
import org.sidiff.revision.repair.ui.Activator;
import org.sidiff.revision.repair.ui.debugger.ITreeItem;

public class DebuggingSession implements ITreeItem {
	
	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private RepairCalculationEngineDebugger debugger;

	private List<DebuggingSnapshotItem> snapshots = new ArrayList<>();
	
	public DebuggingSession(RepairCalculationEngineDebugger debugger) {
		this.debugger = debugger;
	}
	
	public void clear() {
		snapshots = new ArrayList<>();
	}
	
	public void createSnapshot() {
		snapshots.add(new DebuggingSnapshotItem(this, debugger.getLastComplementFinderMonitor()));
	}
	
	public List<DebuggingSnapshotItem> getSnapshots() {
		return snapshots;
	}
	
	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return "Debugging Session [" + snapshots.size() + "]";
	}

	@Override
	public ITreeItem getParent() {
		return null;
	}
	
	@Override
	public boolean hasChildren() {
		return !snapshots.isEmpty();
	}

	@Override
	public ITreeItem[] getChildren() {
		return snapshots.toArray(new ITreeItem[0]);
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		for (DebuggingSnapshotItem snapshot : snapshots) {
			string.append("\n");
			string.append(snapshot.toString());
		}
		
		return string.toString();
	}
}
