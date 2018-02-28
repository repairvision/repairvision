package org.sidiff.repair.ui.peo.debugger.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.common.ui.tree.ITreeItem;
import org.sidiff.repair.ui.peo.Activator;

public class DebuggingSession implements IReconitionEngineEventListener, ITreeItem {
	
	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private IRecognitionEngine recognitionEngine;

	private List<DebuggingSnapshotItem> snapshots = new ArrayList<>();
	
	public DebuggingSession(IRecognitionEngine recognitionEngine) {
		this.recognitionEngine = recognitionEngine;
	}
	
	public void start() {
		recognitionEngine.addEventListener(this);
	}
	
	public void clear() {
		snapshots = new ArrayList<>();
	}
	
	public void stop() {
		recognitionEngine.removeEventListener(this);
	}
	
	public void createSnapshot(IRecognitionEngineEvent trigger) {
		snapshots.add(new DebuggingSnapshotItem(this, trigger, recognitionEngine));
	}
	
	public List<DebuggingSnapshotItem> getSnapshots() {
		return snapshots;
	}
	
	@Override
	public void notifyEvent(IRecognitionEngineEvent event) {
		createSnapshot(event);
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
