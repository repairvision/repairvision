package org.sidiff.repair.history.generator.reports.validation;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.repair.history.generator.reports.util.EcoreUtil;

public class EcoreDiagnosticAdapter extends EMFDiagnosticAdapter {

	public EcoreDiagnosticAdapter(Diagnostic diagnostic) {
		super(diagnostic);
	}

	@Override
	protected String getIdentificationString() {
		String res = getCharacterizingMessageFragment();
		res += "::";

		for (Object o : getAdaptee().getData()) {
			if (o instanceof EObject) {
				res += getName((EObject) o);
				res += "::";
			}
		}

		return res;
	}

	private String getName(EObject obj) {
		if (obj instanceof ENamedElement) {
			return ((ENamedElement) obj).getName();
		} else {
			return "<" + obj.eClass().getName() + ">";
		}
	}

	@Override
	protected List<String> getCharacterizingMessageFragments() {
		return EcoreUtil.getCharacterizingMessageFragments();
	}
}
