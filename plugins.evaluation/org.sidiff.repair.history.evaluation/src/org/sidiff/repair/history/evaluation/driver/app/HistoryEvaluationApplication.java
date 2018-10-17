package org.sidiff.repair.history.evaluation.driver.app;

import java.io.File;
import java.util.ArrayList;
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
import org.sidiff.generic.matcher.uuid.UUIDMatcher;
import org.sidiff.history.revision.util.SettingsUtil;
import org.sidiff.historymodel.History;
import org.sidiff.matcher.IMatcher;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.peo.PEORepairFacade;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.api.peo.configuration.PEORepairSettings;
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
	
	public static String RULEBASE = "Ecore Evaluation Edit Rules";
	
	public static String LOCAL_PATH = "C:/workspaces/sidiff-build";
	
	public static List<String> HISTORIES = new ArrayList<>();
	static {
		HISTORIES.add("/org.eclipse.git.evaluation/birt/chart_org.eclipse.birt.chart.engine_src_model_org.eclipse.birt.chart.model.type.ecore/chart_org.eclipse.birt.chart.engine_src_model_org.eclipse.birt.chart.model.type.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/eclipse.e4/bundles_org.eclipse.e4.ui.model.workbench_model_UIElements.ecore/bundles_org.eclipse.e4.ui.model.workbench_model_UIElements.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.emf.emf/plugins_org.eclipse.emf.codegen.ecore_model_GenModel.ecore/plugins_org.eclipse.emf.codegen.ecore_model_GenModel.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.emf.emf/plugins_org.eclipse.emf.ecore_model_XMLType.ecore/plugins_org.eclipse.emf.ecore_model_XMLType.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.emf.emf/plugins_org.eclipse.emf.ecore.change_model_Change.ecore/plugins_org.eclipse.emf.ecore.change_model_Change.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.emft.edapt/plugins_org.eclipse.emf.edapt.history_model_history.ecore/plugins_org.eclipse.emf.edapt.history_model_history.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.gmp.gmf-tooling/plugins_org.eclipse.gmf.graphdef_models_gmfgraph.ecore/plugins_org.eclipse.gmf.graphdef_models_gmfgraph.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.gmp.gmf-tooling/plugins_org.eclipse.gmf.map_models_gmfmap.ecore/plugins_org.eclipse.gmf.map_models_gmfmap.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.gmp.gmf-tooling/plugins_org.eclipse.gmf.tooldef_models_tooldef.ecore/plugins_org.eclipse.gmf.tooldef_models_tooldef.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.m2t.acceleo/plugins_org.eclipse.acceleo.model_model_mtlnonstdlib.ecore/plugins_org.eclipse.acceleo.model_model_mtlnonstdlib.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.mdt.bpmn2/org.eclipse.bpmn2_model_BPMN20.ecore/org.eclipse.bpmn2_model_BPMN20.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.mdt.ocl/plugins_org.eclipse.ocl.ecore_model_oclstdlib.ecore/plugins_org.eclipse.ocl.ecore_model_oclstdlib.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.mdt.ocl/plugins_org.eclipse.ocl.pivot_model_Lookup.ecore/plugins_org.eclipse.ocl.pivot_model_Lookup.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.mdt.papyrus/plugins_infra_core_org.eclipse.papyrus.infra.core.architecture_model_Architecture.ecore/plugins_infra_core_org.eclipse.papyrus.infra.core.architecture_model_Architecture.ecore.history");
//		HISTORIES.add("/org.eclipse.git.evaluation/modeling.mdt.uml2/plugins_org.eclipse.uml2.uml_model_CMOF.ecore/plugins_org.eclipse.uml2.uml_model_CMOF.ecore.history");
//		HISTORIES.add("/org.eclipse.git.evaluation/modeling.mdt.uml2/plugins_org.eclipse.uml2.uml_model_CMOF20.ecore/plugins_org.eclipse.uml2.uml_model_CMOF20.ecore.history");
//		HISTORIES.add("/org.eclipse.git.evaluation/modeling.mdt.uml2/plugins_org.eclipse.uml2.uml_model_UML.ecore/plugins_org.eclipse.uml2.uml_model_UML.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.mmt.atl/deprecated_org.atl.eclipse.engine_src_org_atl_eclipse_engine_resources_ATL-0.2.ecore/deprecated_org.atl.eclipse.engine_src_org_atl_eclipse_engine_resources_ATL-0.2.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.mmt.atl/plugins_org.eclipse.m2m.atl.emftvm_model_emftvm.ecore/plugins_org.eclipse.m2m.atl.emftvm_model_emftvm.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.mmt.qvt-oml/plugins_org.eclipse.m2m.qvt.oml_model_QVTOperational.ecore/plugins_org.eclipse.m2m.qvt.oml_model_QVTOperational.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.mmt.qvtd/plugins_org.eclipse.qvtd.pivot.qvtbase_model_QVTbase.ecore/plugins_org.eclipse.qvtd.pivot.qvtbase_model_QVTbase.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/modeling.sirius/plugins_org.eclipse.sirius_model_viewpoint.ecore/plugins_org.eclipse.sirius_model_viewpoint.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/science.eavp/org.eclipse.eavp.geometry.view.model_model_org.eclipse.eavp.geometry.view.model.ecore/org.eclipse.eavp.geometry.view.model_model_org.eclipse.eavp.geometry.view.model.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/technology.cbi/org.eclipse.b3.aggregator_model_Aggregator.ecore/org.eclipse.b3.aggregator_model_Aggregator.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/technology.cbi/org.eclipse.b3.backend_model_B3Backend.ecore/org.eclipse.b3.backend_model_B3Backend.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/technology.cbi/org.eclipse.b3.build_model_B3Build.ecore/org.eclipse.b3.build_model_B3Build.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/technology.stem/core_org.eclipse.stem.core_model_graph.ecore/core_org.eclipse.stem.core_model_graph.ecore.history");
		HISTORIES.add("/org.eclipse.git.evaluation/tools.buckminster/org.eclipse.buckminster.rmap_model_rmap.ecore/org.eclipse.buckminster.rmap_model_rmap.ecore.history");
	}
	
	private static int START_WITH_VERSION = 0;
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		for (String historyPath : HISTORIES) {
			try {
				System.out.println("LOADIND EVALUATION: " + historyPath);
				System.out.println("RULEBASE: " + RULEBASE);
				
				// load history:
				History history = loadHistory(URI.createFileURI(new File(LOCAL_PATH + historyPath).getPath()));
				
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
				System.gc();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return IApplication.EXIT_OK;
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
