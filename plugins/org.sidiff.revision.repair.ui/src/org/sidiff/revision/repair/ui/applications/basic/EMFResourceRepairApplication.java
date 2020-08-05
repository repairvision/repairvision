package org.sidiff.revision.repair.ui.applications.basic;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.api.ComplementationSettings;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.editrules.project.registry.RulebaseRegistry;
import org.sidiff.revision.ui.application.basic.EMFResourceComplementationApplication;
import org.sidiff.revision.ui.configuration.page.ComplementationPreferencePage;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.project.registry.ConstraintLibraryRegistry;

public abstract class EMFResourceRepairApplication<J extends ComplementationJob<?>, F extends ComplementationSettings> extends EMFResourceComplementationApplication<J, F> {

	@Override
	protected void initializeSettings() {
		if (getModelB() != null) {
			// NOTE: Model A can be the 'empty model'
			ComplementationPreferencePage.populateSettings(getModelB());
		} else if (getModelA() != null) {
			ComplementationPreferencePage.populateSettings(getModelA());
		}
	}
	
	protected DifferenceSettings getMatchingSettings() {
		return ComplementationPreferencePage.getMatchingSettings();
	}
	
	protected String getDoumentType() {
		return ComplementationPreferencePage.getDoumentType();
	}
	
	protected List<URI> getEditRules() {
		return RulebaseRegistry.getEditRules(getDoumentType(), ComplementationPreferencePage.getRulebases());
	}
	
	protected List<IConstraint> getConstraints() {
		return ConstraintLibraryRegistry.getConstraints(getDoumentType(), ComplementationPreferencePage.getConstraintLibraries());
	}
	
}
