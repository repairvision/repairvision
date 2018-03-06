package org.sidiff.repair.api.peo;

import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.repair.complement.peo.finder.ComplementFinder;
import org.sidiff.repair.complement.peo.finder.ComplementFinderEngine;

public class PEORepairMonitor {

	private boolean enabled;
	
	private SymmetricDifference difference;
	
	private ComplementFinderEngine complementFinderEngine;
	
	private ComplementFinder complementFinder;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public SymmetricDifference getDifference() {
		return difference;
	}

	public void setDifference(SymmetricDifference difference) {
		if (enabled) {
			this.difference = difference;
		}
	}

	public ComplementFinderEngine getComplementFinderEngine() {
		return complementFinderEngine;
	}

	public void setComplementFinderEngine(ComplementFinderEngine complementFinderEngine) {
		if (enabled) {
			this.complementFinderEngine = complementFinderEngine;
		}
	}

	public ComplementFinder getComplementFinder() {
		return complementFinder;
	}

	public void setComplementFinder(ComplementFinder complementFinder) {
		if (enabled) {
			this.complementFinder = complementFinder;
		}
	}
}
