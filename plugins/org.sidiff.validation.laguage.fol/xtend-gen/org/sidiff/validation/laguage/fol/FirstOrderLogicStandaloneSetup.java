/**
 * generated by Xtext 2.10.0
 */
package org.sidiff.validation.laguage.fol;

import org.sidiff.validation.laguage.fol.FirstOrderLogicStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class FirstOrderLogicStandaloneSetup extends FirstOrderLogicStandaloneSetupGenerated {
  public static void doSetup() {
    new FirstOrderLogicStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}
