package org.sidiff.repair.history.generator.reports.validation;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;

/**
 * Encapsulates the EMF validation framework. Simply adapts a Diagnostic, which
 * is the error class in the EMF validation framework.
 * 
 * @author kehrer
 */
public abstract class EMFDiagnosticAdapter implements IValidationError {

	private Diagnostic adaptee;

	public EMFDiagnosticAdapter(Diagnostic diagnostic) {
		adaptee = diagnostic;
	}

	@Override
	public Throwable getException() {
		return adaptee.getException();
	}

	@Override
	public String getMessage() {
		return adaptee.getMessage();
	}

	@Override
	public String getSource() {
		return adaptee.getSource();
	}

	@Override
	public String getSeverity() {
		if (adaptee.getSeverity() == Diagnostic.ERROR) {
			return IValidationError.ERROR;
		}
		if (adaptee.getSeverity() == Diagnostic.WARNING) {
			return IValidationError.WARNING;
		}

		return "UNKNOWN";
	}

	public Diagnostic getAdaptee() {
		return adaptee;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EMFDiagnosticAdapter)) {
			return false;
		}

		return getIdentificationString().equals(((EMFDiagnosticAdapter) obj).getIdentificationString());
	}

	@Override
	public int hashCode() {
		return getIdentificationString().hashCode();
	}

	@Override
	public String getCharacterizingMessageFragment() {
		for (String characterizing : getCharacterizingMessageFragments()) {
			if (getMessage().contains(characterizing)) {
				return characterizing;
			}
		}

		return getMessage();
	}

	protected abstract List<String> getCharacterizingMessageFragments();

	protected abstract String getIdentificationString();

}
