package org.sidiff.revision.repair.history.evaluation;

import java.util.ArrayList;
import java.util.List;

public class EvaluationDataSets {
	
	public static final String RESULT_REPORT = "C:/evaluations/org.eclipse.git.evaluation_2018-11-02/2020-03-25-results/";
	
	public static final String MANUALLY_EVALUATED_VALUES = RESULT_REPORT + "manually_evaluated_values.csv";
	
	public static final String RULEBASE = "Ecore Evaluation Edit Rules";
	
	public static final String DATA_SET = "C:/Users/manue/git/repairvision/data.evaluation/org.eclipse.git_2018-08-22/";

	public static final String ORIGINAL_DATA_SET = DATA_SET + "org.eclipse.git_original/";
	
	public static final String RESOLVED_DATA_SET = DATA_SET + "org.eclipse.git_resolved/";
	
	public static final String MATCHED_DATA_SET = DATA_SET + "org.eclipse.git_matched/";
	
	public static final String REDUCED_DATA_SET = DATA_SET + "org.eclipse.git_reduced/";
	
	public static final String RESULTS_DATA_SET = "C:/evaluations/org.eclipse.git.evaluation_2018-11-02/";
	
	public static final List<String> HISTORIES = new ArrayList<>();
	static {
		HISTORIES.add("birt/chart_org.eclipse.birt.chart.engine_src_model_org.eclipse.birt.chart.model.type.ecore/chart_org.eclipse.birt.chart.engine_src_model_org.eclipse.birt.chart.model.type.ecore.history");
		HISTORIES.add("eclipse.e4/bundles_org.eclipse.e4.ui.model.workbench_model_UIElements.ecore/bundles_org.eclipse.e4.ui.model.workbench_model_UIElements.ecore.history");
		HISTORIES.add("modeling.emf.emf/plugins_org.eclipse.emf.codegen.ecore_model_GenModel.ecore/plugins_org.eclipse.emf.codegen.ecore_model_GenModel.ecore.history");
		HISTORIES.add("modeling.emf.emf/plugins_org.eclipse.emf.ecore_model_XMLType.ecore/plugins_org.eclipse.emf.ecore_model_XMLType.ecore.history");
		HISTORIES.add("modeling.emf.emf/plugins_org.eclipse.emf.ecore.change_model_Change.ecore/plugins_org.eclipse.emf.ecore.change_model_Change.ecore.history");
		HISTORIES.add("modeling.emft.edapt/plugins_org.eclipse.emf.edapt.history_model_history.ecore/plugins_org.eclipse.emf.edapt.history_model_history.ecore.history");
		HISTORIES.add("modeling.gmp.gmf-tooling/plugins_org.eclipse.gmf.graphdef_models_gmfgraph.ecore/plugins_org.eclipse.gmf.graphdef_models_gmfgraph.ecore.history");
		HISTORIES.add("modeling.gmp.gmf-tooling/plugins_org.eclipse.gmf.map_models_gmfmap.ecore/plugins_org.eclipse.gmf.map_models_gmfmap.ecore.history");
		HISTORIES.add("modeling.gmp.gmf-tooling/plugins_org.eclipse.gmf.tooldef_models_tooldef.ecore/plugins_org.eclipse.gmf.tooldef_models_tooldef.ecore.history");
		HISTORIES.add("modeling.m2t.acceleo/plugins_org.eclipse.acceleo.model_model_mtlnonstdlib.ecore/plugins_org.eclipse.acceleo.model_model_mtlnonstdlib.ecore.history");
		HISTORIES.add("modeling.mdt.bpmn2/org.eclipse.bpmn2_model_BPMN20.ecore/org.eclipse.bpmn2_model_BPMN20.ecore.history");
		HISTORIES.add("modeling.mdt.ocl/plugins_org.eclipse.ocl.ecore_model_oclstdlib.ecore/plugins_org.eclipse.ocl.ecore_model_oclstdlib.ecore.history");
		HISTORIES.add("modeling.mdt.ocl/plugins_org.eclipse.ocl.pivot_model_Lookup.ecore/plugins_org.eclipse.ocl.pivot_model_Lookup.ecore.history");
		HISTORIES.add("modeling.mdt.papyrus/plugins_infra_core_org.eclipse.papyrus.infra.core.architecture_model_Architecture.ecore/plugins_infra_core_org.eclipse.papyrus.infra.core.architecture_model_Architecture.ecore.history");
		HISTORIES.add("modeling.mdt.uml2/plugins_org.eclipse.uml2.uml_model_CMOF.ecore/plugins_org.eclipse.uml2.uml_model_CMOF.ecore.history");
		HISTORIES.add("modeling.mdt.uml2/plugins_org.eclipse.uml2.uml_model_CMOF20.ecore/plugins_org.eclipse.uml2.uml_model_CMOF20.ecore.history");
		HISTORIES.add("modeling.mdt.uml2/plugins_org.eclipse.uml2.uml_model_UML.ecore/plugins_org.eclipse.uml2.uml_model_UML.ecore.history");
		HISTORIES.add("modeling.mmt.atl/deprecated_org.atl.eclipse.engine_src_org_atl_eclipse_engine_resources_ATL-0.2.ecore/deprecated_org.atl.eclipse.engine_src_org_atl_eclipse_engine_resources_ATL-0.2.ecore.history");
		HISTORIES.add("modeling.mmt.atl/plugins_org.eclipse.m2m.atl.emftvm_model_emftvm.ecore/plugins_org.eclipse.m2m.atl.emftvm_model_emftvm.ecore.history");
		HISTORIES.add("modeling.mmt.qvt-oml/plugins_org.eclipse.m2m.qvt.oml_model_QVTOperational.ecore/plugins_org.eclipse.m2m.qvt.oml_model_QVTOperational.ecore.history");
		HISTORIES.add("modeling.mmt.qvtd/plugins_org.eclipse.qvtd.pivot.qvtbase_model_QVTbase.ecore/plugins_org.eclipse.qvtd.pivot.qvtbase_model_QVTbase.ecore.history");
		HISTORIES.add("modeling.sirius/plugins_org.eclipse.sirius_model_viewpoint.ecore/plugins_org.eclipse.sirius_model_viewpoint.ecore.history");
		HISTORIES.add("science.eavp/org.eclipse.eavp.geometry.view.model_model_org.eclipse.eavp.geometry.view.model.ecore/org.eclipse.eavp.geometry.view.model_model_org.eclipse.eavp.geometry.view.model.ecore.history");
		HISTORIES.add("technology.cbi/org.eclipse.b3.aggregator_model_Aggregator.ecore/org.eclipse.b3.aggregator_model_Aggregator.ecore.history");
		HISTORIES.add("technology.cbi/org.eclipse.b3.backend_model_B3Backend.ecore/org.eclipse.b3.backend_model_B3Backend.ecore.history");
		HISTORIES.add("technology.cbi/org.eclipse.b3.build_model_B3Build.ecore/org.eclipse.b3.build_model_B3Build.ecore.history");
		HISTORIES.add("technology.stem/core_org.eclipse.stem.core_model_graph.ecore/core_org.eclipse.stem.core_model_graph.ecore.history");
		HISTORIES.add("tools.buckminster/org.eclipse.buckminster.rmap_model_rmap.ecore/org.eclipse.buckminster.rmap_model_rmap.ecore.history");
	}
	
	public static String print() {
		StringBuilder objString = new StringBuilder();
		
		objString.append("RulebaseExtension: " + RULEBASE).append("\n\n");
		objString.append("Result Report: " + RESULT_REPORT).append("\n\n");
		objString.append("Data Set: " + DATA_SET).append("\n");
		objString.append("Original Data Set: " + ORIGINAL_DATA_SET).append("\n");
		objString.append("Resolved Data Set: " + RESOLVED_DATA_SET).append("\n");
		objString.append("Matched Data Set: " + MATCHED_DATA_SET).append("\n");
		objString.append("Reduced Data Set: " + REDUCED_DATA_SET).append("\n");
		objString.append("Results Data Set: " + RESULTS_DATA_SET).append("\n");
		
		objString.append("\n").append("Histories:").append("\n");
		
		for (String history : HISTORIES) {
			objString.append("  ").append(history).append("\n");
		}
		
		return objString.toString();
	}
}
