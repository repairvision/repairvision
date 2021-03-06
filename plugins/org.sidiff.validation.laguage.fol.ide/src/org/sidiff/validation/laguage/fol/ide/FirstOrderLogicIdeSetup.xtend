/*
 * generated by Xtext 2.12.0
 */
package org.sidiff.validation.laguage.fol.ide

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import org.sidiff.validation.laguage.fol.FirstOrderLogicRuntimeModule
import org.sidiff.validation.laguage.fol.FirstOrderLogicStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class FirstOrderLogicIdeSetup extends FirstOrderLogicStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new FirstOrderLogicRuntimeModule, new FirstOrderLogicIdeModule))
	}
	
}
