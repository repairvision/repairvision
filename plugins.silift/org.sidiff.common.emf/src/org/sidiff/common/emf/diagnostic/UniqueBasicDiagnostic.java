package org.sidiff.common.emf.diagnostic;

import java.util.stream.IntStream;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;

/**
 * A {@link BasicDiagnostic} with unique child diagnostics.
 * Diagnostics will only be added as children, if this diagnostic
 * does not already contain an equivalent child diagnostic.
 * @author Robert Müller
 */
public class UniqueBasicDiagnostic extends BasicDiagnostic {

	public UniqueBasicDiagnostic() {
		super();
	}

	public UniqueBasicDiagnostic(String source, int code, String message, Object[] data) {
		super(source, code, message, data);
	}

	public UniqueBasicDiagnostic(int severity, String source, int code, String message, Object[] data) {
		super(severity, source, code, message, data);
	}

	/**
	 * Adds the child diagnostic to this, iff no other child diagnostic is equal to it. 
	 */
	@Override
	public void add(Diagnostic diagnostic) {
		if (getChildren().stream().noneMatch(diag -> equalDiagnostics(diag, diagnostic))) {
			super.add(diagnostic);
		}
	}

	private static boolean equalDiagnostics(Diagnostic diag1, Diagnostic diag2) {
		return diag1.getSeverity() == diag1.getSeverity()
				&& diag1.getMessage().equals(diag2.getMessage())
				&& diag1.getSource().equals(diag2.getSource())
				&& diag1.getChildren().size() == diag2.getChildren().size()
				&& IntStream.range(0, diag1.getChildren().size())
						.allMatch(i -> equalDiagnostics(diag1.getChildren().get(i), diag2.getChildren().get(i)));
	}
}
