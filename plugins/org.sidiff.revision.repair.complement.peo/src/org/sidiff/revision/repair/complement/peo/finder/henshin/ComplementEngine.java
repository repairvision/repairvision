package org.sidiff.revision.repair.complement.peo.finder.henshin;

import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;

public class ComplementEngine extends EngineImpl {

	public ComplementEngine(boolean sortVariables, String... globalJavaImports) {
		super(globalJavaImports);
		this.sortVariables = sortVariables;
	}
}
