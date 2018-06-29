package org.sidiff.repair.history.generator.reports;

import java.util.List;

import org.eclipse.emf.ecore.EcorePackage;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.configuration.IConfigurable;
import org.sidiff.difference.lifting.api.settings.LiftingSettings;
import org.sidiff.difference.lifting.api.util.PipelineUtils;
import org.sidiff.repair.history.generator.reports.util.EcoreUtil;

public class ReportGeneratorEcore extends ReportGenerator {

	@Override
	protected String[] getFileFilters() {
		return new String[] { "ecore" };
	}

	@Override
	protected long maxModelFileLength() {
		// return 10000L;
		return Long.MAX_VALUE;
	}

	@Override
	protected List<String> getCharacterizingMessageFragments() {
		return EcoreUtil.getCharacterizingMessageFragments();
	}

//	@Override
//	protected boolean exists(EObject element, Resource model) {
//		if (element instanceof ENamedElement) {
//			ENamedElement namedElement = (ENamedElement) element;
//
//			for (Iterator<EObject> iterator = model.getAllContents(); iterator.hasNext();) {
//				EObject obj = iterator.next();
//				if (obj instanceof ENamedElement) {
//					ENamedElement namedObj = (ENamedElement) obj;
//
//					if ((namedElement.eClass() == namedObj.eClass())
//							&& (namedElement.getName().equals(namedObj.getName()))) {
//						return true;
//					}
//				}
//			}
//		}
//
//		return false;
//	}

	@Override
	protected LiftingSettings getLiftingSettings() {
		LiftingSettings settings = new LiftingSettings();
		settings.setScope(Scope.RESOURCE_SET);
		settings.setMatcher(PipelineUtils.getMatcherByKey("org.sidiff.matcher.signature.name.NamedElementMatcher"));
		((IConfigurable)settings.getMatcher()).getConfigurationOptions();
		((IConfigurable)settings.getMatcher()).setConfigurationOption("Use Qualified Names", true);
		((IConfigurable)settings.getMatcher()).setConfigurationOption("toString() Signature for Unnamed Elements", true);
		settings.setTechBuilder(PipelineUtils.getTechnicalDifferenceBuilder("org.sidiff.ecore.difference.technical.TechnicalDifferenceBuilderEcore"));
		settings.setRrSorter(PipelineUtils.getRecognitionRuleSorter("EcoreRRSorter"));
		settings.setRuleBases(PipelineUtils.getAvailableRulebases(EcorePackage.eNS_URI));
		return settings;
	}

}
