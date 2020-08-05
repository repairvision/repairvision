package org.sidiff.revision.repair.history.evaluation.driver.app;

import java.io.File;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.generic.matcher.uuid.UUIDMatcherProvider;
import org.sidiff.history.revision.util.SettingsUtil;
import org.sidiff.historymodel.History;
import org.sidiff.revision.api.ComplementationFacade;
import org.sidiff.revision.common.emf.document.Scope;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.difference.builder.GenericDifferenceBuilderProvider;
import org.sidiff.revision.difference.builder.IDifferenceBuilderProvider;
import org.sidiff.revision.difference.matcher.IMatcherProvider;
import org.sidiff.revision.editrules.project.registry.RulebaseRegistry;
import org.sidiff.revision.editrules.project.registry.util.RulebaseUtil;
import org.sidiff.revision.repair.api.RepairFacade;
import org.sidiff.revision.repair.api.RepairJob;
import org.sidiff.revision.repair.api.configuration.RepairSettings;
import org.sidiff.revision.repair.history.evaluation.EvaluationDataSets;
import org.sidiff.revision.repair.history.evaluation.driver.HistoryEvaluationDriver;
import org.sidiff.revision.repair.history.evaluation.driver.data.HistoryInfo;

public class HistoryEvaluationApplication implements IApplication {
	
//	private static String MATCHER = "org.sidiff.revision.difference.matcher.id.xmiid.XMIIDMatcher";
//	private static String DIFFERENCE_BUILDER = "org.sidiff.ecore.difference.technical.TechnicalDifferenceBuilderEcoreNoAnnotations";
	
	private static int START_WITH_VERSION = 0;
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		for (String historyPath : EvaluationDataSets.HISTORIES) {
			try {
				System.out.println("LOADIND EVALUATION: " + historyPath);
				System.out.println("RULEBASE: " + EvaluationDataSets.RULEBASE);
				
				// load history:
				History history = loadHistory(URI.createFileURI(new File(EvaluationDataSets.RESULTS_DATA_SET + historyPath).getPath()));
				
				// initialize history analyzer:
				HistoryInfo historyInfo = new HistoryInfo(history);
				
				// load edit rules:
				List<URI> rulebase = RulebaseRegistry.getRulebase(EvaluationDataSets.RULEBASE);
				Collection<Rule> editRules = RulebaseUtil.eLoadEditRules(rulebase, false);
				
				System.out.println("EDIT RULES: " + editRules.size());
				
				// repair algorithm:
				ComplementationFacade<RepairJob, RepairSettings> repairFacade = new RepairFacade();

				// start evaluation:
				System.out.println("STARTING EVALUATION");
				
				HistoryEvaluationDriver.START_WITH_VERSION = START_WITH_VERSION;
				System.out.println("WITH VERSION " + HistoryEvaluationDriver.START_WITH_VERSION);
						
				HistoryEvaluationDriver.calculateRepairs(repairFacade, historyInfo, editRules, getSettings());
				
				System.out.println("FINISHED EVALUATION");
				System.gc();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return IApplication.EXIT_OK;
	}
	
	private DifferenceSettings getSettings() {
		DifferenceSettings differenceSettings = SettingsUtil.getDefaultDifferenceSettings();
		IMatcherProvider matcherProvider = new UUIDMatcherProvider();
//		IMatcher matcher = MatchingUtils.getMatcherByKey(MATCHER);
		IDifferenceBuilderProvider builder = new GenericDifferenceBuilderProvider();
//		ITechnicalDifferenceBuilder builder = TechnicalDifferenceUtils.getTechnicalDifferenceBuilder(DIFFERENCE_BUILDER);
		differenceSettings.setMatcher(matcherProvider);
		differenceSettings.setTechBuilder(builder);
		differenceSettings.setScope(Scope.RESOURCE_SET);
		
		if ((matcherProvider == null) || (builder == null)) {
			throw new RuntimeException("Invalid difference settings!");
		}
		
		return differenceSettings;
	}
	
	private History loadHistory(URI uri) {
		ResourceSet resourceSet = new ResourceSetImpl();
 		Resource historyResource = resourceSet.getResource(uri, true);
		History history = (History) historyResource.getContents().get(0);
		
//		// load all resources:
//		Set<Resource> loaded = new HashSet<>();
//		Set<Resource> newLoaded = new HashSet<>();
//		newLoaded.add(historyResource);
//		
//		while (!newLoaded.isEmpty()) {
//			for (Resource resource : newLoaded) {
//				EcoreUtil.resolveAll(resource);
//				loaded.add(resource);
//			}
//			newLoaded = new HashSet<>(resourceSet.getResources());
//			newLoaded.removeAll(loaded);
//		}
//		
//		// freeze ecore models e.g. generic types:
//		for (Resource resource : resourceSet.getResources()) {
//			if ((resource.getContents() != null) && (resource.getContents().get(0) instanceof EPackageImpl)) {
//				EPackageImpl ePackage = (EPackageImpl) resource.getContents().get(0);
//				ePackage.freeze();
//			}
//		}
		
		return history;
	}

	@Override
	public void stop() {
	}
}
