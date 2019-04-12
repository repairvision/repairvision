package org.sidiff.difference.symmetric.graphviewer.parts.design;

import org.eclipse.gef.fx.nodes.Connection;

public abstract class SwitchableConnection extends Connection {

	/**
	 * Delegates to the protected method {@link FXConnection#refreshGeometry()}
	 */
	public void refreshConnection() {
		refresh();
	}
}
