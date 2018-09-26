package org.sidiff.repair.history.evaluation.driver.app;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.difference.technical.GenericTechnicalDifferenceBuilder;
import org.sidiff.difference.technical.ITechnicalDifferenceBuilder;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.history.revision.util.SettingsUtil;
import org.sidiff.history.revision.uuid.UUIDMatcher;
import org.sidiff.historymodel.History;
import org.sidiff.matcher.IMatcher;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.peo.PEORepairFacade;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.api.peo.PEORepairSettings;
import org.sidiff.repair.editrules.library.RulebaseLibrary;
import org.sidiff.repair.editrules.library.RulebaseUtil;
import org.sidiff.repair.history.evaluation.driver.HistoryEvaluationDriver;
import org.sidiff.repair.history.evaluation.driver.data.HistoryInfo;

public class HistoryEvaluationApplication implements IApplication {

	// Export products/evaluation-driver.product
	// (If needed: update Contents/Add Required Plug-ins)
	// 
	// Run headless product from plugins folder (system independent):
	// java -jar org.eclipse.equinox.launcher_1.4.0.v20161219-1356.jar -application org.sidiff.repair.history.evaluation.driver -consoleLog -noExit first second last
	// 
	// or
	//
	// Run headless product with launcher (system dependent):
	// eclipse -application org.sidiff.repair.history.evaluation.driver -consoleLog -noExit first second last
	
//	private static String MATCHER = "org.sidiff.matcher.id.xmiid.XMIIDMatcher";
//	private static String DIFFERENCE_BUILDER = "org.sidiff.ecore.difference.technical.TechnicalDifferenceBuilderEcoreNoAnnotations";
	
	private static String RULEBASE = "Ecore Evaluation Edit Rules";
	
	private static String HISTORY = "C:/evaluations/org.eclipse.git_2018-08-22/org.eclipse.git.annotated/modeling.mdt.uml2/plugins_org.eclipse.uml2.uml_model_UML.ecore/plugins_org.eclipse.uml2.uml_model_UML.ecore.history";
	
	private static int START_WITH_VERSION = 0;
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("LOADIND EVALUATION: " + HISTORY);
		System.out.println("RULEBASE: " + RULEBASE);
		
		// load history:
		History history = loadHistory(URI.createFileURI(HISTORY));
		
		// initialize history analyzer:
		HistoryInfo historyInfo = new HistoryInfo(history);
		
		// load edit rules:
		List<URI> rulebase = RulebaseLibrary.getRulebase(RULEBASE);
		Collection<Rule> editRules = RulebaseUtil.eLoadEditRules(rulebase, false);
		
		System.out.println("EDIT RULES: " + editRules.size());
		
		// repair algorithm:
		IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade = new PEORepairFacade();

		// start evaluation:
		System.out.println("STARTING EVALUATION");
		
		HistoryEvaluationDriver.START_WITH_VERSION = START_WITH_VERSION;
		System.out.println("WITH VERSION " + HistoryEvaluationDriver.START_WITH_VERSION);
				
		HistoryEvaluationDriver.calculateRepairs(repairFacade, historyInfo, editRules, getSettings());
		
		System.out.println("FINISHED EVALUATION");
		
		return null;
	}
	
	private DifferenceSettings getSettings() {
		DifferenceSettings differenceSettings = SettingsUtil.getDefaultDifferenceSettings();
		IMatcher matcher = new UUIDMatcher();
//		IMatcher matcher = MatchingUtils.getMatcherByKey(MATCHER);
		ITechnicalDifferenceBuilder builder = new GenericTechnicalDifferenceBuilder();
//		ITechnicalDifferenceBuilder builder = TechnicalDifferenceUtils.getTechnicalDifferenceBuilder(DIFFERENCE_BUILDER);
		differenceSettings.setMatcher(matcher);
		differenceSettings.setTechBuilder(builder);
		differenceSettings.setScope(Scope.RESOURCE_SET);
		
		if ((matcher == null) || (builder == null)) {
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
