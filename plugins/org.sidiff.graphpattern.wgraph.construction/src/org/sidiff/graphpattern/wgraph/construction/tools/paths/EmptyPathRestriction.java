package org.sidiff.graphpattern.wgraph.construction.tools.paths;

import org.sidiff.graphpattern.EdgePattern;

public class EmptyPathRestriction implements IPathRestriction {

	@Override
	public boolean isRestrictedOutgoing(EdgePattern edge) {
		return false;
	}

	@Override
	public boolean isRestrictedIncoming(EdgePattern edge) {
		return false;
	}
}
