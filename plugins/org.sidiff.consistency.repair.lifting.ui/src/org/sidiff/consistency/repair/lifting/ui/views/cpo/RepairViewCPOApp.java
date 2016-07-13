package org.sidiff.consistency.repair.lifting.ui.views.cpo;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.TreeViewer;
import org.sidiff.consistency.repair.lifting.api.Repair;
import org.sidiff.consistency.repair.lifting.ui.views.RepairViewBasicApp;

public class RepairViewCPOApp extends RepairViewBasicApp {

	private Collection<IResource> cpEditRuleFiles = new ArrayList<>();
	
	private Collection<IResource> subEditRuleFiles = new ArrayList<>();
	
	public RepairViewCPOApp(TreeViewer viewer_repairs) {
		super(viewer_repairs);
	}

	@Override
	public void calculateRepairs() {
	}

	@Override
	public void applyRepair(Repair repair) {
	}

	public boolean removeSubEditRule(IResource selection) {
		subEditRuleFiles.remove(selection);
		return true;
	}

	public boolean addSubEditRule(IResource element) {
		if (element.getFileExtension().equalsIgnoreCase("henshin")) {
			subEditRuleFiles.add(element);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean removeCPEditRule(IResource selection) {
		cpEditRuleFiles.remove(selection);
		return true;
	}

	public boolean addCPEditRule(IResource element) {
		if (element.getFileExtension().equalsIgnoreCase("henshin")) {
			cpEditRuleFiles.add(element);
			return true;
		} else {
			return false;
		}
	}
}
