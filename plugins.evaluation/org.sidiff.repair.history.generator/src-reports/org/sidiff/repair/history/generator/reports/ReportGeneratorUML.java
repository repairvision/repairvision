package org.sidiff.repair.history.generator.reports;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EValidatorRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLValidator;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.difference.lifting.api.settings.LiftingSettings;
import org.sidiff.repair.history.generator.reports.util.UMLUtil;

public class ReportGeneratorUML extends ReportGenerator {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		EValidator.Registry registry = new EValidatorRegistryImpl(EValidator.Registry.INSTANCE);
		registry.put(UMLPackage.eINSTANCE, new UMLValidator());

		return super.start(context);
	}

	@Override
	protected String[] getFileFilters() {
		return new String[] { "uml" };
	}

	@Override
	protected long maxModelFileLength() {
		// return 10000L;
		return Long.MAX_VALUE;
	}

	@Override
	protected List<String> getCharacterizingMessageFragments() {
		return UMLUtil.getCharacterizingMessageFragments();
	}

	@Override
	protected boolean exists(EObject element, Resource model) {
		String xmiID = EMFUtil.getXmiId(element);
		for (Iterator<EObject> iterator = model.getAllContents(); iterator.hasNext();) {
			EObject obj = iterator.next();
			if (EMFUtil.getXmiId(obj).equals(xmiID)) {
				return true;
			}
		}

		return false;
	}

	@Override
	protected LiftingSettings getLiftingSettings() {
		// TODO Auto-generated method stub
		return null;
	}
}
