package org.sidiff.revision.repair.ui.peo.debugger.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.common.ui.tree.ITreeItem;
import org.sidiff.revision.repair.api.peo.PEORepairCalculationEngineDebugger;
import org.sidiff.revision.repair.ui.peo.Activator;

public class DebuggingSession implements ITreeItem {
	
	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private PEORepairCalculationEngineDebugger debugger;

	private List<DebuggingSnapshotItem> snapshots = new ArrayList<>();
	
	public DebuggingSession(PEORepairCalculationEngineDebugger debugger) {
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
