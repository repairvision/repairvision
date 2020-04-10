package org.sidiff.revision.repair.history.retrieval.ecore;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.revision.repair.history.retrieval.miner.data.ModelingDataSet;

/**
 * Repository URL -> Original (All extracted model versions.)
 * 
 * @author Manuel Ohrndorf
 */
public class EcoreHistoryMiningApplication implements IApplication {
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		start("C:\\evaluation\\");
		return IApplication.EXIT_OK;
	}
	
	public void start(String localPath) {
		
//		####################################################################################################
//		2017-09-18
//		####################################################################################################
//		https://projects.eclipse.org/
//		-> Technology Types -> Modeling
//		####################################################################################################
//		https://github.com/search
//		-> org:eclipse xmlns:ecore extension:ecore size:>1000
//		####################################################################################################
//		https://git.eclipse.org/c/
//		-> org.eclipse.emf
//		####################################################################################################
		
		ModelingDataSet dataSet = new ModelingDataSet();
		dataSet.setMiners(EcoreHistorySettings.getInstance().getMiners());
		
		build(dataSet, localPath);
		
		dataSet.mine(true, true);
		// (ignore already existing versions)
		// (download model files)
	}
	
	private void build(ModelingDataSet dataSet, String localPath) {

		// https://projects.eclipse.org/projects/modeling.mdt.uml2/developer
		dataSet.addProject(localPath, "modeling.mdt.uml2",
				"http://git.eclipse.org/c/uml2/org.eclipse.uml2.git",
				"https://projects.eclipse.org/projects/modeling.mdt.uml2",
				
				"/plugins/org.eclipse.uml2.uml/model/UML.ecore",
				"/plugins/org.eclipse.uml2.types/model/Types.ecore",
				"/plugins/org.eclipse.uml2.codegen.ecore/model/GenModel.ecore",
				"/plugins/org.eclipse.uml2.uml.profile.standard/model/Standard.ecore",
				"/plugins/org.eclipse.uml2.uml/model/CMOF.ecore",
				"/plugins/org.eclipse.uml2.uml/model/CMOF20.ecore",
				"/plugins/org.eclipse.uml2.uml/model/CMOF24.ecore",
				"/plugins/org.eclipse.uml2.uml/model/CMOF241.ecore",
				"/plugins/org.eclipse.uml2.uml/model/UML30.ecore");
	
		// https://projects.eclipse.org/projects/modeling.emft.emf-store/developer
		dataSet.addProject(localPath, "modeling.emft.emf-store", 
				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git",
				"https://projects.eclipse.org/projects/modeling.emft.emf-store",
				
				"/bundles/org.eclipse.emf.emfstore.client/model/client.ecore",
				"/bundles/org.eclipse.emf.emfstore.common.model/model/common.ecore",
				"/bundles/org.eclipse.emf.emfstore.fuzzy.emf/model/config.ecore",
				"/bundles/org.eclipse.emf.emfstore.server.model/model/server.ecore");
	
		// https://projects.eclipse.org/projects/modeling.mdt.ocl/developer
		dataSet.addProject(localPath, "modeling.mdt.ocl", 
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git",
				"https://projects.eclipse.org/projects/modeling.mdt.ocl",
				
				"/plugins/org.eclipse.ocl.pivot.uml/model/OCLforUML.ecore",
				"/plugins/org.eclipse.ocl.pivot/model/Lookup.ecore",
				"/plugins/org.eclipse.ocl.pivot/model-gen/oclstdlib.ecore",
				"/plugins/org.eclipse.ocl.pivot/model/Pivot.ecore",
				"/plugins/org.eclipse.ocl.pivot/model/Values.ecore",
				"/plugins/org.eclipse.ocl.uml/model/OCLUML.ecore",
				"/plugins/org.eclipse.ocl.ecore/model/OCLEcore.ecore",
				"/plugins/org.eclipse.ocl.ecore/model/oclstdlib.ecore",
				"/plugins/org.eclipse.ocl/model/OCL.ecore",
				"/plugins/org.eclipse.ocl/model/OCLCST.ecore",
				"/plugins/org.eclipse.ocl.xtext.base/model/BaseCS.ecore",
				"/plugins/org.eclipse.ocl.xtext.essentialocl/model/EssentialOCLCS.ecore"
			
				// TODO:
//				/tests/org.eclipse.ocl.ecore.tests/model/Company.ecore,
//				/tests/org.eclipse.ocl.ecore.tests/model/HiddenOpposites.ecore,
//				/tests/org.eclipse.ocl.ecore.tests/model/ModelWithErrors.ecore,
//				/tests/org.eclipse.ocl.ecore.tests/model/NamesTest.ecore,
//				/tests/org.eclipse.ocl.ecore.tests/model/NoReflectionCompany.ecore,
//				/tests/org.eclipse.ocl.ecore.tests/model/OCLTest.ecore,
//				/tests/org.eclipse.ocl.ecore.tests/model/VoidCollectionTypes.ecore,
//				/tests/org.eclipse.ocl.ecore.tests/model/extlibrary.ecore,
//				/tests/org.eclipse.ocl.examples.impactanalyzer.testmodel.company/model/company.ecore,
//				/tests/org.eclipse.ocl.examples.impactanalyzer.testmodel.company/model/primitivetypes.ecore,
//				/tests/org.eclipse.ocl.examples.impactanalyzer.testmodel.ngpm/model/abapmapping.ecore,
//				/tests/org.eclipse.ocl.examples.impactanalyzer.testmodel.ngpm/model/ap_runtime_constraints.ecore,
//				/tests/org.eclipse.ocl.examples.impactanalyzer.testmodel.ngpm/model/behavioral.ecore,
//				/tests/org.eclipse.ocl.examples.impactanalyzer.testmodel.ngpm/model/configuration.ecore,
//				/tests/org.eclipse.ocl.examples.impactanalyzer.testmodel.ngpm/model/data.ecore,
//				/tests/org.eclipse.ocl.examples.impactanalyzer.testmodel.ngpm/model/dataaccess.ecore,
//				/tests/org.eclipse.ocl.examples.impactanalyzer.testmodel.ngpm/model/deployment.ecore,
//				/tests/org.eclipse.ocl.examples.impactanalyzer.testmodel.ngpm/model/integration.ecore,
//				/tests/org.eclipse.ocl.examples.impactanalyzer.testmodel.ngpm/model/localization.ecore,
//				/tests/org.eclipse.ocl.examples.impactanalyzer.testmodel.ngpm/model/modelmanagement.ecore,
//				/tests/org.eclipse.ocl.examples.impactanalyzer.testmodel.ngpm/model/ngpm.genmodel,
//				/tests/org.eclipse.ocl.examples.impactanalyzer.testmodel.ngpm/model/persistence.ecore,
//				/tests/org.eclipse.ocl.examples.impactanalyzer.testmodel.ngpm/model/ui.ecore,
//				/tests/org.eclipse.ocl.examples.validity.test/model/ecoreTest.ecore,
//				/tests/org.eclipse.ocl.examples.validity.test/model/ecoreTest2.ecore,
//				/tests/org.eclipse.ocl.uml.tests/model/DummyRegistration.ecore,
//				/tests/org.eclipse.ocl.examples.xtext.tests/models...
//				...
								
				);
		
		dataSet.addProject(localPath, "modeling.mdt.ocl.examples", 
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git",
				"https://projects.eclipse.org/projects/modeling.mdt.ocl",
				
				"/examples/org.eclipse.ocl.examples.pivot/model/pivot.ecore",
				"/examples/org.eclipse.ocl.examples.pivot/model/Pivot.ecore",
				"/examples/org.eclipse.ocl.examples.xtext.base/model/BaseCS.ecore",
				"/examples/org.eclipse.ocl.examples.codegen/model/cgmodel.ecore",
				"/examples/org.eclipse.ocl.examples.xtext.essentialocl/model/EssentialOCLCS.ecore");
						

		// https://projects.eclipse.org/projects/modeling.mmt.qvt-oml/developer
		dataSet.addProject(localPath, "modeling.mmt.qvt-oml", 
				"http://git.eclipse.org/c/mmt/org.eclipse.qvto.git",
				"https://projects.eclipse.org/projects/modeling.mmt.qvt-oml",
				
				"/plugins/org.eclipse.m2m.qvt.oml.ecore.imperativeocl/model/ImperativeOCL.ecore",
				"/plugins/org.eclipse.m2m.qvt.oml.emf.util/model/MModelURIMap.ecore",
				"/plugins/org.eclipse.m2m.qvt.oml/model/QVTOperational.ecore",
				"/plugins/org.eclipse.m2m.qvt.oml/model/trace.ecore");
		
		// https://projects.eclipse.org/projects/technology.ogee/developer
		dataSet.addProject(localPath, "technology.ogee", 
				"http://git.eclipse.org/c/ogee/org.eclipse.ogee.git",
				"https://projects.eclipse.org/projects/technology.ogee",
				
				"/org.eclipse.ogee.model/model/OData.ecore");
		
		// https://projects.eclipse.org/projects/modeling.m2t.acceleo/developer
		dataSet.addProject(localPath, "modeling.m2t.acceleo", 
				"http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.git",
				"https://projects.eclipse.org/projects/modeling.m2t.acceleo",
				
				"/plugins/org.eclipse.acceleo.model/model/mtl.ecore",
				"/plugins/org.eclipse.acceleo.model/model/mtlnonstdlib.ecore",
				"/plugins/org.eclipse.acceleo.model/model/mtlstdlib.ecore",
				"/plugins/org.eclipse.acceleo.profiler/model/profiler.ecore",
				"/plugins/org.eclipse.acceleo.ui.interpreter.completeocl/model/evaluation_result.ecore");
		
		// https://projects.eclipse.org/projects/modeling.emft.emf-client/developer
		dataSet.addProject(localPath, "modeling.emft.emf-client", 
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git",
				"https://projects.eclipse.org/projects/modeling.emft.emf-client",
				
				"/bundles/org.eclipse.emf.ecp.diffmerge.model/model/diffmerge.ecore",
				"/bundles/org.eclipse.emf.ecp.core/model/ecp.ecore",
				"/bundles/org.eclipse.emf.ecp.view.categorization.model/model/categorization.ecore",
				"/bundles/org.eclipse.emf.ecp.view.compoundcontrol.model/model/compoundcontrol.ecore",
				"/bundles/org.eclipse.emf.ecp.view.custom.model/model/custom.ecore",
				"/bundles/org.eclipse.emf.ecp.view.group.model/model/group.ecore",
				"/bundles/org.eclipse.emf.ecp.view.groupedgrid.model/model/groupedGrid.ecore",
				"/bundles/org.eclipse.emf.ecp.view.horizontal.model/model/horizontal.ecore",
				"/bundles/org.eclipse.emf.ecp.view.indexdmr.model/model/indexdmr.ecore",
				"/bundles/org.eclipse.emf.ecp.view.keyattributedmr.model/model/keyattributedmr.ecore",
				"/bundles/org.eclipse.emf.ecp.view.label.model/model/label.ecore",
				"/bundles/org.eclipse.emf.ecp.view.mappingdmr.model/model/mappingdmr.ecore",
				"/bundles/org.eclipse.emf.ecp.view.model/model/view.ecore",
				"/bundles/org.eclipse.emf.ecp.view.model/model/viewModel.ecore",
				"/bundles/org.eclipse.emf.ecp.view.rule.model/model/rule.ecore",
				"/bundles/org.eclipse.emf.ecp.view.section.model/model/section.ecore",
				"/bundles/org.eclipse.emf.ecp.view.stack.model/model/stack.ecore",
				"/bundles/org.eclipse.emf.ecp.view.table.model/model/table.ecore",
				"/bundles/org.eclipse.emf.ecp.view.template.model/model/alignmentStyle.ecore",
				"/bundles/org.eclipse.emf.ecp.view.template.model/model/backgroundStyle.ecore",
				"/bundles/org.eclipse.emf.ecp.view.template.model/model/domainModelReferenceSelector.ecore",
				"/bundles/org.eclipse.emf.ecp.view.template.model/model/fontPropertiesStyle.ecore",
				"/bundles/org.eclipse.emf.ecp.view.template.model/model/mandatoryStyle.ecore",
				"/bundles/org.eclipse.emf.ecp.view.template.model/model/tabStyle.ecore",
				"/bundles/org.eclipse.emf.ecp.view.template.model/model/tableStyleProperty.ecore",
				"/bundles/org.eclipse.emf.ecp.view.template.model/model/tableValidationColumnStyleProperty.ecore",
				"/bundles/org.eclipse.emf.ecp.view.template.model/model/template.ecore",
				"/bundles/org.eclipse.emf.ecp.view.template.model/model/textControlEnablementStyle.ecore",
				"/bundles/org.eclipse.emf.ecp.view.template.model/model/validationStyle.ecore",
				"/bundles/org.eclipse.emf.ecp.view.template.model/model/viewModelElementSelector.ecore",
				"/bundles/org.eclipse.emf.ecp.view.treemasterdetail.model/model/treeMasterDetail.ecore",
				"/bundles/org.eclipse.emf.ecp.view.vertical.model/model/vertical.ecore",
				"/bundles/org.eclipse.emf.ecp.view.viewproxy.model/model/viewproxy.ecore",
				"/bundles/org.eclipse.emfforms.rulerepository.model/model/rulerepository.ecore",
				"/bundles/org.eclipse.emfforms.view.annotation.model/model/annotation.ecore",
				"/bundles/org.eclipse.emfforms.view.controlgrid.model/model/controlgrid.ecore");
		
		// https://projects.eclipse.org/projects/modeling.mmt.atl/developer
		dataSet.addProject(localPath, "modeling.mmt.atl", 
				"http://git.eclipse.org/c/mmt/org.eclipse.atl.git",
				"https://projects.eclipse.org/projects/modeling.mmt.atl",
				
				"/plugins/org.eclipse.m2m.atl.emftvm/model/emftvm.ecore",
				"/plugins/org.eclipse.m2m.atl.emftvm.trace/model/trace.ecore",
				"/plugins/org.eclipse.m2m.atl.profiler.exportmodel/model/exportmodel.ecore",
				"/plugins/org.eclipse.m2m.atl.profiler.model/model/ATL-Profiler.ecore",
				
				"/deprecated/org.atl.eclipse.engine/src/org/atl/eclipse/engine/resources/ATL-0.2.ecore"
				
				);
		
		// https://projects.eclipse.org/projects/modeling.emf.diffmerge/developer
		dataSet.addProject(localPath, "modeling.emf.diffmerge.patch", 
				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patch.git",
				"https://projects.eclipse.org/projects/modeling.emf.diffmerge",
				
				"/plugins/org.eclipse.emf.diffmerge.patch.persistence.emf/model/modelpatch.ecore");
		
		dataSet.addProject(localPath, "modeling.emf.diffmerge.coevolution", 
				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.coevolution.git",
				"https://projects.eclipse.org/projects/modeling.emf.diffmerge",
				
				"/core/plugins/org.eclipse.emf.diffmerge.bridge.traces.gen/model/BridgeTraces.ecore");
		
		dataSet.addProject(localPath, "modeling.emf.diffmerge.patterns", 
				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.git",
				"https://projects.eclipse.org/projects/modeling.emf.diffmerge",
				
				"/core/plugins/org.eclipse.emf.diffmerge.patterns.core.gen/model/CorePatterns.ecore",
				"/core/plugins/org.eclipse.emf.diffmerge.patterns.support.gen/model/CommonPatternSupport.ecore",
				"/core/plugins/org.eclipse.emf.diffmerge.patterns.templates.gen/model/TemplatePatterns.ecore");
		
		dataSet.addProject(localPath, "modeling.emf.diffmerge.core", 
				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.core.git",
				"https://projects.eclipse.org/projects/modeling.emf.diffmerge",
				
				"/plugins/org.eclipse.emf.diffmerge/model/DiffData.ecore");
		
		// https://projects.eclipse.org/projects/modeling.elk/developer
		dataSet.addProject(localPath, "modeling.elk", 
				"https://github.com/eclipse/elk",
				"https://projects.eclipse.org/projects/modeling.elk",
				
				"/plugins/org.eclipse.elk.graph/model/elkgraph.ecore");

		// https://projects.eclipse.org/projects/modeling.mdt.papyrus/developer
		dataSet.addProject(localPath, "modeling.mdt.papyrus", 
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git",
				"https://projects.eclipse.org/projects/modeling.mdt.papyrus",
				
				"/plugins/facet/org.eclipse.papyrus.emf.facet.custom.metamodel/model/catalog-0.2.0.ecore",
				"/plugins/facet/org.eclipse.papyrus.emf.facet.custom.metamodel/model/custom-0.2.0.ecore",
				"/plugins/facet/org.eclipse.papyrus.emf.facet.custom.metamodel/model/custom_primitive_types-0.2.0.ecore",
				"/plugins/facet/org.eclipse.papyrus.emf.facet.custom.metamodel/model/query-0.3.0.ecore",
				"/plugins/facet/org.eclipse.papyrus.emf.facet.custom.metamodel/model/treeproxy-0.2.0.ecore",
				"/plugins/facet/org.eclipse.papyrus.emf.facet.efacet.metamodel/model/efacet-0.2.0.ecore",
				"/plugins/facet/org.eclipse.papyrus.emf.facet.efacet.metamodel/model/efacetcatalog-0.2.0.ecore",
				"/plugins/facet/org.eclipse.papyrus.emf.facet.efacet/model/efacet.ecore",
				"/plugins/facet/org.eclipse.papyrus.emf.facet.widgets.celleditors/model/celleditors.ecore",
				"/plugins/infra/core/org.eclipse.papyrus.infra.core.architecture/model/Architecture.ecore",
				"/plugins/uml/org.eclipse.papyrus.uml.filters/model/umlfilters.ecore",
				"/plugins/infra/filters/org.eclipse.papyrus.infra.filters/model/filters.ecore",
				"/plugins/infra/types/org.eclipse.papyrus.infra.types/model/ElementTypesConfigurations.ecore",
				"/plugins/facet/org.eclipse.papyrus.emf.facet.util.emf.catalog/model/catalog.ecore");

		// https://projects.eclipse.org/projects/modeling.mmt.qvtd/developer
		dataSet.addProject(localPath, "modeling.mmt.qvtd", 
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git",
				"https://projects.eclipse.org/projects/modeling.mmt.qvtd",
				
				"/plugins/org.eclipse.qvt/model/ecore/EMOF.ecore",
				"/plugins/org.eclipse.qvt/model/ecore/EssentialOCL.ecore",
				"/plugins/org.eclipse.qvt/model/ecore/FlatQVT.ecore",
				"/plugins/org.eclipse.qvt/model/ecore/ImperativeOCL.ecore",
				"/plugins/org.eclipse.qvt/model/ecore/PrimitiveTypes.ecore",
				"/plugins/org.eclipse.qvt/model/ecore/QVT.ecore", 
				"/plugins/org.eclipse.qvt/model/ecore/QVTBase.ecore",
				"/plugins/org.eclipse.qvt/model/ecore/QVTCore.ecore",
				"/plugins/org.eclipse.qvt/model/ecore/QVTOperational.ecore",
				"/plugins/org.eclipse.qvt/model/ecore/QVTRelation.ecore",
				"/plugins/org.eclipse.qvt/model/ecore/QVTTemplate.ecore",
				"/plugins/org.eclipse.qvtd.codegen/model/qvticgmodel.ecore",
				"/plugins/org.eclipse.qvtd.compiler/model/ECoreContainmentTree.ecore",
				"/plugins/org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore",
				"/plugins/org.eclipse.qvtd.pivot.qvtbase/model/QVTbaseStructural.ecore",
				"/plugins/org.eclipse.qvtd.pivot.qvtcore/model/QVTcore.ecore",
				"/plugins/org.eclipse.qvtd.pivot.qvtcore/model/QVTcoreStructural.ecore",
				"/plugins/org.eclipse.qvtd.pivot.qvtimperative/model/EvaluationStatus.ecore",
				"/plugins/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ecore",
				"/plugins/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperativeStructural.ecore",
				"/plugins/org.eclipse.qvtd.xtext.qvtbase/model/QVTbaseCS.ecore",
				"/plugins/org.eclipse.qvtd.xtext.qvtcore/model/QVTcoreCS.ecore",
				"/plugins/org.eclipse.qvtd.xtext.qvtimperative/model/QVTimperativeCS.ecore",
				"/plugins/org.eclipse.qvtd.xtext.qvtrelation/model/QVTrelationCS.ecore",
				"/plugins/org.eclipse.qvtd.pivot.qvtrelation/model/QVTrelation.ecore",
				"/plugins/org.eclipse.qvtd.pivot.qvttemplate/model/QVTtemplate.ecore",
				"/plugins/org.eclipse.qvtd.umlx/model/UMLX.ecore",
				"/plugins/org.eclipse.qvtd.xtext.qvtcorebase/model/QVTcoreBaseCS.ecore",
				"/plugins/org.eclipse.qvtd.pivot.qvtcorebase/model/QVTcoreBase.ecore");

		// https://projects.eclipse.org/projects/modeling.sirius/developer
		dataSet.addProject(localPath, "modeling.sirius", 
				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.git",
				"https://projects.eclipse.org/projects/modeling.sirius",
				
				"/plugins/org.eclipse.sirius.diagram.sequence/model/sequence.ecore",
				"/plugins/org.eclipse.sirius.properties.ext.widgets.reference/model/properties-ext-widgets-reference.ecore",
				"/plugins/org.eclipse.sirius.properties/model/properties.ecore",
				"/plugins/org.eclipse.sirius.sample.interactions/model/interactions.ecore",
				"/plugins/org.eclipse.sirius/model/viewpoint.ecore",
				"/plugins/org.eclipse.sirius.diagram/model/diagram.ecore",
				"/plugins/org.eclipse.sirius/model/contribution.ecore");

		// https://projects.eclipse.org/projects/modeling.mdt.sphinx/developer
		dataSet.addProject(localPath, "modeling.mdt.sphinx", 
				"http://git.eclipse.org/c/sphinx/org.eclipse.sphinx.git",
				"https://projects.eclipse.org/projects/modeling.mdt.sphinx",
				
				"plugins/org.eclipse.sphinx.emf.check.catalog/model/CheckCatalog.ecore");
		
		// https://projects.eclipse.org/projects/modeling.upr/developer
		
		// https://projects.eclipse.org/projects/modeling.mdht/developer
		dataSet.addProject(localPath, "modeling.mdht", 
				"http://git.eclipse.org/c/mdht/org.eclipse.mdht.git",
				"https://projects.eclipse.org/projects/modeling.mdht",
				
				"/core/plugins/org.eclipse.mdht.metamodel.traceability/model/traceability.ecore");
		
		// https://projects.eclipse.org/projects/technology.handly/developer
		
		// https://projects.eclipse.org/projects/modeling.emf.egf/developer
		dataSet.addProject(localPath, "modeling.emf.egf", 
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git",
				"https://projects.eclipse.org/projects/modeling.emf.egf",
				
				"/plugins/org.eclipse.egf.model.fprod/model/Fprod.ecore",
				"/plugins/org.eclipse.egf.model.ftask/model/Ftask.ecore",
				"/plugins/org.eclipse.egf.model.javapattern/model/JavaPattern.ecore",
				"/plugins/org.eclipse.egf.model.jetpattern/model/JetPattern.ecore",
				"/plugins/org.eclipse.egf.model/model/Domain.ecore", "/plugins/org.eclipse.egf.model/model/Fcore.ecore",
				"/plugins/org.eclipse.egf.model/model/Mapping.ecore",
				"/plugins/org.eclipse.egf.model/model/Pattern.ecore",
				"/plugins/org.eclipse.egf.model/model/Types.ecore");
		
		// https://projects.eclipse.org/projects/modeling.efm/developer
		
		// https://projects.eclipse.org/projects/modeling.umlgen/developer
		
		// https://projects.eclipse.org/projects/modeling.viatra/developer
		
		// https://projects.eclipse.org/projects/modeling.fmc/developer
		dataSet.addProject(localPath, "modeling.fmc", 
				"http://git.eclipse.org/c/fmc/org.eclipse.fmc.core.git",
				"https://projects.eclipse.org/projects/modeling.fmc",
				
				"/org.eclipse.fmc.mm/model/Blockdiagram.ecore");

		// TODO: https://projects.eclipse.org/projects/modeling.tmf.xtext/developer
		dataSet.addProject(localPath, "modeling.tmf.xtext.core", 
				"https://github.com/eclipse/xtext-core",
				"https://projects.eclipse.org/projects/modeling.tmf.xtext",
				
				"org.eclipse.xtext.tests/src/org/eclipse/xtext/linking/lazy/LazyLinkingTestLanguage.ecore");
		
		dataSet.addProject(localPath, "modeling.tmf.xtext.extras", 
				"https://github.com/eclipse/xtext-extras",
				"https://projects.eclipse.org/projects/modeling.tmf.xtext",
				
				"/org.eclipse.xtext.xbase/model/Xbase.ecore",
				"/org.eclipse.xtext.common.types/model/JavaVMTypes.ecore");
		
		// https://projects.eclipse.org/projects/soa.bpmn2-modeler/developer
		
		// https://projects.eclipse.org/projects/modeling.mdt.bpmn2/developer
		dataSet.addProject(localPath, "modeling.mdt.bpmn2", 
				"http://git.eclipse.org/c/bpmn2/org.eclipse.bpmn2.git",
				"https://projects.eclipse.org/projects/modeling.mdt.bpmn2",
				
				"/org.eclipse.bpmn2/model/BPMN20.ecore", "/org.eclipse.bpmn2/model/BPMNDI.ecore",
				"/org.eclipse.bpmn2/model/DC.ecore", "/org.eclipse.bpmn2/model/DI.ecore");
		
		// https://projects.eclipse.org/projects/modeling.emfcompare/developer
		dataSet.addProject(localPath, "modeling.emfcompare", 
				"http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.git",
				"https://projects.eclipse.org/projects/modeling.emfcompare",
				
				"/plugins/org.eclipse.emf.compare.diagram/model/diagramCompare.ecore",
				"/plugins/org.eclipse.emf.compare/model/compare.ecore",
				"/plugins/org.eclipse.emf.compare.uml2/model/uml2compare.ecore");
		
		// https://projects.eclipse.org/projects/modeling.papyrus-rt/developer
		
		// https://projects.eclipse.org/projects/modeling.emft.edapt/developer
		dataSet.addProject(localPath, "modeling.emft.edapt", 
				"http://git.eclipse.org/c/edapt/org.eclipse.emf.edapt.git",
				"https://projects.eclipse.org/projects/modeling.emft.edapt",
				
				"/plugins/org.eclipse.emf.edapt.declaration/model/declaration.ecore",
				"/plugins/org.eclipse.emf.edapt.history/model/history.ecore");
		
		// https://projects.eclipse.org/projects/modeling.capra/developer
		
		// https://projects.eclipse.org/projects/modeling.emft.ecore"tools/developer
		
		// https://projects.eclipse.org/projects/modeling.emf-parsley/developer
		
		// https://projects.eclipse.org/projects/modeling.mdt.etrice/developer
		
		// https://projects.eclipse.org/projects/modeling.eef/developer
		dataSet.addProject(localPath, "modeling.eef", 
				"http://git.eclipse.org/c/eef/org.eclipse.eef.git",
				"https://projects.eclipse.org/projects/modeling.eef",
				
				"/plugins/org.eclipse.eef/model/eef.ecore",
				"/plugins/org.eclipse.emf.eef.components/model/components.ecore",
				"/plugins/org.eclipse.emf.eef.eefgen/model/EEFGen.ecore",
				"/plugins/org.eclipse.emf.eef.mapping/model/mapping.ecore",
				"/plugins/org.eclipse.emf.eef.modelingbot/model/mbot.ecore",
				"/plugins/org.eclipse.emf.eef.views/model/views.ecore",
				"/plugins/org.eclipse.emf.eef.editor.model/model/extended.ecore",
				"/plugins/org.eclipse.sirius.context/model/context.ecore",
				"/prototypes/org.eclipse.sirius.expression/model/expression.ecore",
				"/prototypes/org.eclipse.sirius.contentassist/model/contentassist.ecore",
				"/prototypes/org.eclipse.sirius.validation/model/validation.ecore");
		
		// https://projects.eclipse.org/projects/modeling.amalgam/developer
		
		// https://projects.eclipse.org/projects/modeling.eatop/developer
		dataSet.addProject(localPath, "modeling.eatop", 
				"http://git.eclipse.org/c/eatop/org.eclipse.eatop.git",
				"https://projects.eclipse.org/projects/modeling.eatop",
				
		//		"/plugins/org.eclipse.eatop.eastadl2112/model/eastadl2112.ecore", TODO
				"/plugins/org.eclipse.eatop.eastadl2112/model/geastadl.ecore",
				"/plugins/org.eclipse.eatop.geastadl/model/geastadl.ecore");
		
		// https://projects.eclipse.org/projects/modeling.gmp.gmf-notation/developer
		dataSet.addProject(localPath, "modeling.gmp.gmf-notation", 
				"http://git.eclipse.org/c/gmf-notation/org.eclipse.gmf.notation.git",
				"https://projects.eclipse.org/projects/modeling.gmp.gmf-notation",
				
				"/org.eclipse.gmf.runtime.notation/model/notation.ecore");
		
		// https://projects.eclipse.org/projects/modeling.gmf-runtime/developer
		
		// https://projects.eclipse.org/projects/modeling.gmp.gmf-tooling/developer
		dataSet.addProject(localPath, "modeling.gmp.gmf-tooling", 
				"http://git.eclipse.org/c/gmf-tooling/org.eclipse.gmf-tooling.git",
				"https://projects.eclipse.org/projects/modeling.gmp.gmf-tooling",
				
				"/plugins/org.eclipse.gmf.graphdef/models/gmfgraph.ecore",
				"/plugins/org.eclipse.gmf.graphdef/models/gmfgraph_2006.ecore",
				"/plugins/org.eclipse.gmf.map/models/gmfmap.ecore",
				"/plugins/org.eclipse.gmf.map/models/gmfmap_2007.ecore",
				"/plugins/org.eclipse.gmf.tooldef/models/tooldef.ecore",
				"/plugins/org.eclipse.gmf.tooling.simplemap.model/model/simplemap.ecore",
				"/archive/org.eclipse.gmf.diadef/models/diadef.ecore");
		
		// https://projects.eclipse.org/projects/modeling.gmp.graphiti/developer
		dataSet.addProject(localPath, "modeling.gmp.graphiti", 
				"http://git.eclipse.org/c/graphiti/org.eclipse.graphiti.git",
				"https://projects.eclipse.org/projects/modeling.gmp.graphiti",
				
				"/plugins/org.eclipse.graphiti.mm/model/graphiti.ecore");
		
		// https://projects.eclipse.org/projects/modeling.emf.mwe/developer
		
		// https://projects.eclipse.org/projects/modeling.mdt.modisco/developer
		dataSet.addProject(localPath, "modeling.mdt.modisco", 
				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.git",
				"https://projects.eclipse.org/projects/modeling.mdt.modisco",
				
				"/org.eclipse.gmt.modisco.infra.browser.custom/models/uiCustom.ecore",
				"/org.eclipse.gmt.modisco.infra.facet/model/facet.ecore",
				"/org.eclipse.gmt.modisco.infra.query/model/query.ecore",
				"/org.eclipse.gmt.modisco.omg.kdm/model/kdm.ecore", "/org.eclipse.gmt.modisco.omg.smm/model/SMM.ecore");
		
		// https://projects.eclipse.org/projects/technology.sapphire/developer

		// https://projects.eclipse.org/projects/technology.stem/developer
		dataSet.addProject(localPath, "technology.stem", 
				"http://git.eclipse.org/c/stem/org.eclipse.stem.git",
				"https://projects.eclipse.org/projects/technology.stem",
				
				"/models/populations/org.eclipse.stem.populationmodels/model/standard.ecore",
				"/models/foodproduction/org.eclipse.stem.foodproduction/model/foodproduction.ecore",
				"/models/populations/org.eclipse.stem.populationmodels/model/standard.ecore",
				"/core/org.eclipse.stem.core/model/common.ecore", 
				"/core/org.eclipse.stem.core/model/experiment.ecore",
				"/core/org.eclipse.stem.core/model/graph.ecore", 
				"/core/org.eclipse.stem.core/model/logger.ecore",
				"/core/org.eclipse.stem.core/model/model.ecore", 
				"/core/org.eclipse.stem.core/model/modifier.ecore",
				"/core/org.eclipse.stem.core/model/predicate.ecore", 
				"/core/org.eclipse.stem.core/model/scenario.ecore",
				"/core/org.eclipse.stem.core/model/sequencer.ecore", 
				"/core/org.eclipse.stem.core/model/solver.ecore",
				"/core/org.eclipse.stem.core/model/trigger.ecore",
				"/core/org.eclipse.stem.definitions/model/edges.ecore",
				"/core/org.eclipse.stem.definitions/model/labels.ecore",
				"/core/org.eclipse.stem.definitions/model/nodes.ecore",
				"/core/org.eclipse.stem.definitions/model/types.ecore");

		// https://projects.eclipse.org/projects/soa.stardust/developer
		
		// https://projects.eclipse.org/projects/modeling.m2t.xpand/developer
		dataSet.addProject(localPath, "modeling.m2t.xpand", 
				"http://git.eclipse.org/c/m2t/org.eclipse.xpand.git",
				"https://projects.eclipse.org/projects/modeling.m2t.xpand",
				
				"/plugins/org.eclipse.xpand.incremental/model/trace.ecore");
		
		// https://projects.eclipse.org/projects/modeling.emft.texo/developer
		dataSet.addProject(localPath, "modeling.emft.texo", 
				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.git",
				"https://projects.eclipse.org/projects/modeling.emft.texo",
				
				"/core/org.eclipse.emf.texo.json/model/request.ecore",
				"/generator/org.eclipse.emf.texo.annotations.model/model/texo-annotations-model.ecore",
				"/generator/org.eclipse.emf.texo.modelgenerator/model/texo-annotations-modelgenerator.ecore",
				"/generator/org.eclipse.emf.texo.orm/model/orm.ecore",
				"/generator/org.eclipse.emf.texo.orm/model/texo-annotations-orm.ecore");
		
		// https://projects.eclipse.org/projects/modeling.epsilon/developer
		dataSet.addProject(localPath, "modeling.epsilon", 
				"http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.git",
				"https://projects.eclipse.org/projects/modeling.epsilon",
				
				"/plugins/org.eclipse.epsilon.antlr.postprocessor.model/model/org/eclipse/epsilon/antlr/postprocessor/model/AntlrAst.ecore",
				"/plugins/org.eclipse.epsilon.hutn.model.antlrAst/model/org/eclipse/epsilon/hutn/model/hutnAntlrAst/AntlrAst.ecore",
				"/plugins/org.eclipse.epsilon.hutn.model.antlrAst/model/org/eclipse/epsilon/hutn/model/hutnAntlrAst/HutnAntlrAst.ecore",
				"/plugins/org.eclipse.epsilon.hutn.model.config/model/org/eclipse/epsilon/hutn/model/config/HUTNConfig.ecore",
				"/plugins/org.eclipse.epsilon.hutn.model/model/org/eclipse/epsilon/hutn/model/HUTN.ecore"
				
				// TODO
//				"/examples/..."
				
				);
		
		// https://projects.eclipse.org/projects/modeling.emft.henshin/developer
		dataSet.addProject(localPath, "modeling.emft.henshin", 
				"http://git.eclipse.org/c/henshin/org.eclipse.emft.henshin.git",
				"https://projects.eclipse.org/projects/modeling.emft.henshin",
				
				"/plugins/org.eclipse.emf.henshin.model/model/henshin.ecore");
		
		// https://projects.eclipse.org/projects/technology.osee/developer
		
		// https://projects.eclipse.org/projects/modeling.mdt.rmf/developer
		dataSet.addProject(localPath, "modeling.mdt.rmf", 
				"http://git.eclipse.org/c/rmf/org.eclipse.rmf.git",
				"https://projects.eclipse.org/projects/modeling.mdt.rmf",
				
				"/org.eclipse.rmf.reqif10/model/reqif10.ecore",
				"/org.eclipse.rmf.reqif10.pror/model/configuration.ecore",
				"/org.eclipse.rmf.reqif10.search/model/criteria.ecore",
				"/org.eclipse.rmf.reqif10.xhtml/model/datatypes.ecore",
				"/org.eclipse.rmf.reqif10.xhtml/model/xhtml.ecore");
		
		// https://projects.eclipse.org/projects/technology.app4mc/developer
		
		// https://projects.eclipse.org/projects/modeling.gendoc/developer
		
		// https://projects.eclipse.org/projects/technology.camf/developer
		dataSet.addProject(localPath, "technology.camf", 
				"http://git.eclipse.org/c/camf/org.eclipse.camf.git",
				"https://projects.eclipse.org/projects/technology.camf",
				
				"/plugins/org.eclipse.camf.infosystem.model/model/infosystem.ecore",
				"/plugins/org.eclipse.camf.tosca/model/extension.ecore",
				"/plugins/org.eclipse.camf.tosca/model/hrequirements.ecore",
				"/plugins/org.eclipse.camf.tosca/model/sybl.ecore",
				"/plugins/org.eclipse.camf.tosca/model/tosca.ecore");
		
		// https://projects.eclipse.org/projects/modeling.emfservices/developer
		
		// https://projects.eclipse.org/projects/modeling.franca/developer
		
		// https://projects.eclipse.org/projects/modeling.gemoc/developer
		
		// https://projects.eclipse.org/projects/modeling.papyrus-xtuml/developer
		
		// https://projects.eclipse.org/projects/modeling.pmf/developer
		dataSet.addProject(localPath, "modeling.pmf", 
				"http://git.eclipse.org/c/pmf/org.eclipse.pmf.git",
				"https://projects.eclipse.org/projects/modeling.pmf",
				
				"/org.eclipse.pmf.pim/model/emf.ecore", 
				"/org.eclipse.pmf.pim/model/pmf.ecore");
		
		// https://projects.eclipse.org/projects/soa.winery/developer
		
		// https://projects.eclipse.org/projects/mylyn.context.mft/developer
		
		// https://projects.eclipse.org/projects/technology.cbi/developer
		dataSet.addProject(localPath, "technology.cbi", 
				"https://github.com/eclipse/b3",
				"https://projects.eclipse.org/projects/technology.cbi",
				
				"/org.eclipse.b3.aggregator.legacy/models/aggregator_0.9.0.ecore",
				"/org.eclipse.b3.aggregator.legacy/models/aggregator_1.1.0.ecore",
				"/org.eclipse.b3.aggregator/model/Aggregator.ecore",
				"/org.eclipse.b3.backend/model/B3Backend.ecore",
				"/org.eclipse.b3.build/model/B3Build.ecore",
				"/org.eclipse.b3.p2.maven/model/maven-metadata.ecore", 
				"/org.eclipse.b3.p2/model/p2.ecore");
	
		// https://projects.eclipse.org/projects/birt/developer
		dataSet.addProject(localPath, "birt", 
				"https://github.com/eclipse/birt",
				"https://projects.eclipse.org/projects/birt",
				
				"/chart/org.eclipse.birt.chart.engine/src/model/org.eclipse.birt.chart.model.attribute.ecore",
				"/chart/org.eclipse.birt.chart.engine/src/model/org.eclipse.birt.chart.model.component.ecore",
				"/chart/org.eclipse.birt.chart.engine/src/model/org.eclipse.birt.chart.model.ecore",
				"/chart/org.eclipse.birt.chart.engine/src/model/org.eclipse.birt.chart.model.layout.ecore",
				"/chart/org.eclipse.birt.chart.engine/src/model/org.eclipse.birt.chart.model.type.ecore",
				"/chart/org.eclipse.birt.chart.engine/src/model/org.eclipse.birt.chart.model.data.ecore",
				"/model/org.eclipse.birt.report.model.adapter.oda/schema/model.ecore");

		// https://projects.eclipse.org/projects/modeling.emft.wazaabi/developer
		dataSet.addProject(localPath, "modeling.emft.wazaabi", 
				"https://github.com/eclipse/wazaabi",
				"https://projects.eclipse.org/projects/modeling.emft.wazaabi",
				
				"/plugins/org.eclipse.wazaabi.mm.core/model/core.ecore",
				"/plugins/org.eclipse.wazaabi.mm.edp/model/EDP.ecore",
				"/plugins/org.eclipse.wazaabi.mm.swt/model/SWTComponents.ecore");
		
		// https://projects.eclipse.org/projects/science.eavp/developer
		dataSet.addProject(localPath, "science.eavp", 
				"https://github.com/eclipse/eavp",
				"https://projects.eclipse.org/projects/science.eavp",
				
				"/org.eclipse.eavp.geometry.view.model/model/org.eclipse.eavp.geometry.view.model.ecore");
	
		// https://projects.eclipse.org/projects/modeling.emf.emf/developer
		dataSet.addProject(localPath, "modeling.emf.emf", 
				"https://git.eclipse.org/c/emf/org.eclipse.emf.git",
				"https://projects.eclipse.org/projects/modeling.emf.emf",
				
				"/plugins/org.eclipse.emf.ecore.change/model/Change.ecore",
				"/plugins/org.eclipse.emf.ecore/model/Ecore.ecore",
				"/plugins/org.eclipse.emf.ecore/model/XMLNamespace.ecore",
				"/plugins/org.eclipse.emf.ecore/model/XMLType.ecore",
				"/plugins/org.eclipse.emf.gwt.ecore/model/Ecore.ecore",
				"/plugins/org.eclipse.emf.gwt.ecore/model/XMLNamespace.ecore",
				"/plugins/org.eclipse.emf.gwt.ecore/model/XMLType.ecore",
				"/plugins/org.eclipse.emf.ecore.xcore/model/Xcore.ecore",
				"/plugins/org.eclipse.emf.edit/model/Tree.ecore",
				"/plugins/org.eclipse.emf.mapping.ecore2ecore/model/Ecore2Ecore.ecore",
				"/plugins/org.eclipse.emf.mapping.ecore2xml/model/Ecore2XML.ecore",
				"/plugins/org.eclipse.emf.mapping/model/Mapping.ecore",
				"/plugins/org.eclipse.emf.codegen.ecore/model/GenModel.ecore"
				
				// TODO
//				/examples/...
				
				// TODO
//				/tests/org.eclipse.emf.test.core/data/Bad.ecore
				
				);
		
		// https://projects.eclipse.org/projects/technology.dltk/developer
		dataSet.addProject(localPath, "technology.dltk.javascript", 
				"https://github.com/eclipse/dltk.javascript",
				"https://projects.eclipse.org/projects/technology.dltk",
				
				"/plugins/org.eclipse.dltk.javascript.core.manipulation/model/dom.ecore",
				"/plugins/org.eclipse.dltk.javascript.core/model/references.ecore");
		
		dataSet.addProject(localPath, "technology.dltk.core", 
				"http://git.eclipse.org/c/dltk/org.eclipse.dltk.core.git",
				"https://projects.eclipse.org/projects/technology.dltk",
				
				"/core/plugins/org.eclipse.dltk.core/models/cache_model.ecore",
				"/core/plugins/org.eclipse.dltk.validators.core/models/validators.ecore",
				"/core/plugins/org.eclipse.dltk.launching/model/launching.ecore");
		
		// https://projects.eclipse.org/projects/datatools/developer
		dataSet.addProject(localPath, "datatools", 
				"http://git.eclipse.org/c/datatools/org.eclipse.datatools.git",
				"https://projects.eclipse.org/projects/datatools",
				
				"/plugins/connectivity/org.eclipse.datatools.connectivity.oda.design/model/org.eclipse.datatools.connectivity.oda.design.ecore");
		
		// https://projects.eclipse.org/projects/modeling.gmp.graphiti/developer
		dataSet.addProject(localPath, "modeling.gmp.graphiti", 
				"https://github.com/eclipse/gmp.graphiti",
				"https://projects.eclipse.org/projects/modeling.gmp.graphiti",
				
				"/plugins/org.eclipse.graphiti.mm/model/graphiti.ecore");
		
		// https://projects.eclipse.org/projects/tools.buckminster/developer
		dataSet.addProject(localPath, "tools.buckminster", 
				"http://git.eclipse.org/c/buckminster/buckminster.git",
				"https://projects.eclipse.org/projects/tools.buckminster",
				
				"/org.eclipse.buckminster.cspec/model/cspec.ecore",
				"/org.eclipse.buckminster.model.common/model/common.ecore",
				"/org.eclipse.buckminster.rmap/model/rmap.ecore",
				"/org.eclipse.buckminster.mspec/model/mspec.ecore");
		
		// https://projects.eclipse.org/projects/modeling.emf.cdo/developer
		dataSet.addProject(localPath, "modeling.emf.cdo", 
				"http://git.eclipse.org/c/cdo/cdo.git",
				"https://projects.eclipse.org/projects/modeling.emf.cdo",
				
				"/plugins/org.eclipse.emf.cdo.examples.company/model/company.ecore",
				"/plugins/org.eclipse.emf.cdo.expressions/model/expressions.ecore",
				"/plugins/org.eclipse.emf.cdo.security/model/security.ecore",
				"/plugins/org.gastro.business/model/business.ecore", 
				"/plugins/org.gastro.inventory/model/inventory.ecore",
				"/plugins/org.eclipse.emf.cdo/model/eresource.ecore",
				"/plugins/org.eclipse.emf.cdo/model/etypes.ecore");

		// https://projects.eclipse.org/projects/eclipse.e4/developer
		dataSet.addProject(localPath, "eclipse.e4", 
				"http://git.eclipse.org/c/platform/eclipse.platform.ui.git",
				"https://projects.eclipse.org/projects/eclipse.e4",
				
				"/bundles/org.eclipse.e4.ui.model.workbench/model/UIElements.ecore");

		// TODO
//	    "file": "./model/ProjectInfrastructure.ecore", 
//	    "projectName": "www.eclipse.org", 
//	    "repositoryName": "projects.git",
		
		// TODO
//	    "file": "./games/murdercase/murdercase.ecore", 
//	    "projectName": "www.eclipse.org", 
//	    "repositoryName": "epsilon.git", 

	}


	@Override
	public void stop() {
	}
}
