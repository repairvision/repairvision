/*
 * generated by Xtext 2.21.0
 */
package org.sidiff.validation.laguage.fol.ui.tests;

import com.google.inject.Injector;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.sidiff.validation.laguage.fol.ui.internal.FolActivator;

public class FirstOrderLogicUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return FolActivator.getInstance().getInjector("org.sidiff.validation.laguage.fol.FirstOrderLogic");
	}

}
