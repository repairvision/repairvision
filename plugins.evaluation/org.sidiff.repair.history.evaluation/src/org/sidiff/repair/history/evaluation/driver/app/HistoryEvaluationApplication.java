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
import org.sidiff.consistency.common.settings.SettingsUtil;
import org.sidiff.difference.technical.GenericTechnicalDifferenceBuilder;
import org.sidiff.difference.technical.ITechnicalDifferenceBuilder;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.historymodel.History;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matching.api.util.MatchingUtils;
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
	
	private static String MATCHER = "org.sidiff.matcher.id.xmiid.XMIIDMatcher";
	
//	private static String DIFFERENCE_BUILDER = "org.sidiff.ecore.difference.technical.TechnicalDifferenceBuilderEcoreNoAnnotations";
	
//	private static String HISTORY = "org.sidiff.ecore.testdata.history.atl.atl-0.2/ATL-0.2.ecore.history";
	private static String HISTORY = "org.sidiff.ecore.testdata.history.uml2.uml/UML.ecore.history";
	
	private static String RULEBASE = "Ecore Evaluation Edit Rules";
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("LOADIND EVALUATION");
		
		// difference settings:
		DifferenceSettings differenceSettings = SettingsUtil.getDefaultDifferenceSettings();
		IMatcher matcher = MatchingUtils.getMatcherByKey(MATCHER);
		ITechnicalDifferenceBuilder builder = new GenericTechnicalDifferenceBuilder();
//		ITechnicalDifferenceBuilder builder = TechnicalDifferenceUtils.getTechnicalDifferenceBuilder(DIFFERENCE_BUILDER);
		differenceSettings.setMatcher(matcher);
		differenceSettings.setTechBuilder(builder);
		
		if ((matcher == null) || (builder == null)) {
			throw new RuntimeException("Invalid difference settings!");
		}
		
		// load history:
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource historyResource = resourceSet.getResource(URI.createPlatformResourceURI(HISTORY, true), true);
		History history = (History) historyResource.getContents().get(0);
		HistoryInfo historyInfo = new HistoryInfo(history);
		
		// load edit rules:
		List<URI> rulebase = RulebaseLibrary.getRulebase(RULEBASE);
		Collection<Rule> editRules = RulebaseUtil.eLoadEditRules(rulebase, false);
		
		System.out.println("EDIT RULES: " + editRules.size());
		
		// repair algorithm:
		IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade = new PEORepairFacade();

		// start evaluation:
		System.out.println("STARTING EVALUATION");
		
		HistoryEvaluationDriver.calculateRepairs(repairFacade, historyInfo, editRules, differenceSettings);
		
		System.out.println("FINISHED EVALUATION");
		
		return null;
	}

	@Override
	public void stop() {
	}
}
