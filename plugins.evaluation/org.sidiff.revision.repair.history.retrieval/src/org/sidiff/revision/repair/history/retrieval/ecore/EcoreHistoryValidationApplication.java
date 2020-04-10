package org.sidiff.revision.repair.history.retrieval.ecore;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.history.analysis.validation.EMFValidator;
import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.Version;
import org.sidiff.revision.repair.history.retrieval.metadata.HistoryMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.VersionMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.coevolution.CoevolutionDataSetMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.coevolution.CoevolutionVersionMetadata;
import org.sidiff.revision.repair.history.retrieval.util.HistoryUtil;

/**
 * Creates a filter with all model histories that contain no inconsistencies.
 * 
 * @author Manuel Ohrndof
 */
public class EcoreHistoryValidationApplication implements IApplication  {

	// Histories with no inconsistencies:
	protected static Set<String> modelHistoryFilter = new HashSet<>();
	static {
		String[] modelHistoryFilterArray = {

				// birt

				"https://github.com/eclipse/birt/chart/org.eclipse.birt.chart.engine/src/model/org.eclipse.birt.chart.model.attribute.ecore",
				"https://github.com/eclipse/birt/chart/org.eclipse.birt.chart.engine/src/model/org.eclipse.birt.chart.model.component.ecore",
				"https://github.com/eclipse/birt/chart/org.eclipse.birt.chart.engine/src/model/org.eclipse.birt.chart.model.data.ecore",
				"https://github.com/eclipse/birt/chart/org.eclipse.birt.chart.engine/src/model/org.eclipse.birt.chart.model.ecore",
				"https://github.com/eclipse/birt/chart/org.eclipse.birt.chart.engine/src/model/org.eclipse.birt.chart.model.layout.ecore",
				"https://github.com/eclipse/birt/model/org.eclipse.birt.report.model.adapter.oda/schema/model.ecore",

				// datatools

				"http://git.eclipse.org/c/datatools/org.eclipse.datatools.git/plugins/connectivity/org.eclipse.datatools.connectivity.oda.design/model/org.eclipse.datatools.connectivity.oda.design.ecore",

				// eclipse.e4


				// modeling.eatop

				"http://git.eclipse.org/c/eatop/org.eclipse.eatop.git/plugins/org.eclipse.eatop.geastadl/model/geastadl.ecore",

				// modeling.eef

				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/plugins/org.eclipse.eef/model/eef.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/plugins/org.eclipse.emf.eef.components/model/components.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/plugins/org.eclipse.emf.eef.editor.model/model/extended.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/plugins/org.eclipse.emf.eef.eefgen/model/EEFGen.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/plugins/org.eclipse.emf.eef.mapping/model/mapping.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/plugins/org.eclipse.emf.eef.views/model/views.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/plugins/org.eclipse.sirius.context/model/context.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/prototypes/org.eclipse.sirius.contentassist/model/contentassist.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/prototypes/org.eclipse.sirius.expression/model/expression.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/prototypes/org.eclipse.sirius.validation/model/validation.ecore",

				// modeling.elk

				"https://github.com/eclipse/elk/plugins/org.eclipse.elk.graph/model/elkgraph.ecore",

				// modeling.emf.cdo

				"http://git.eclipse.org/c/cdo/cdo.git/plugins/org.eclipse.emf.cdo.examples.company/model/company.ecore",
				"http://git.eclipse.org/c/cdo/cdo.git/plugins/org.eclipse.emf.cdo.expressions/model/expressions.ecore",
				"http://git.eclipse.org/c/cdo/cdo.git/plugins/org.eclipse.emf.cdo.security/model/security.ecore",
				"http://git.eclipse.org/c/cdo/cdo.git/plugins/org.eclipse.emf.cdo/model/eresource.ecore",
				"http://git.eclipse.org/c/cdo/cdo.git/plugins/org.eclipse.emf.cdo/model/etypes.ecore",
				"http://git.eclipse.org/c/cdo/cdo.git/plugins/org.gastro.business/model/business.ecore",
				"http://git.eclipse.org/c/cdo/cdo.git/plugins/org.gastro.inventory/model/inventory.ecore",

				// modeling.emf.diffmerge.coevolution

				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.coevolution.git/core/plugins/org.eclipse.emf.diffmerge.bridge.traces.gen/model/BridgeTraces.ecore",

				// modeling.emf.diffmerge.core

				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.core.git/plugins/org.eclipse.emf.diffmerge/model/DiffData.ecore",

				// modeling.emf.diffmerge.patch

				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patch.git/plugins/org.eclipse.emf.diffmerge.patch.persistence.emf/model/modelpatch.ecore",

				// modeling.emf.diffmerge.patterns

				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.git/core/plugins/org.eclipse.emf.diffmerge.patterns.core.gen/model/CorePatterns.ecore",
				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.git/core/plugins/org.eclipse.emf.diffmerge.patterns.support.gen/model/CommonPatternSupport.ecore",
				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.git/core/plugins/org.eclipse.emf.diffmerge.patterns.templates.gen/model/TemplatePatterns.ecore",

				// modeling.emf.egf

				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/plugins/org.eclipse.egf.model.fprod/model/Fprod.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/plugins/org.eclipse.egf.model.ftask/model/Ftask.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/plugins/org.eclipse.egf.model.javapattern/model/JavaPattern.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/plugins/org.eclipse.egf.model.jetpattern/model/JetPattern.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/plugins/org.eclipse.egf.model/model/Domain.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/plugins/org.eclipse.egf.model/model/Fcore.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/plugins/org.eclipse.egf.model/model/Mapping.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/plugins/org.eclipse.egf.model/model/Pattern.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/plugins/org.eclipse.egf.model/model/Types.ecore",

				// modeling.emf.emf

				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/plugins/org.eclipse.emf.ecore.xcore/model/Xcore.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/plugins/org.eclipse.emf.ecore/model/Ecore.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/plugins/org.eclipse.emf.ecore/model/XMLNamespace.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/plugins/org.eclipse.emf.edit/model/Tree.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/plugins/org.eclipse.emf.gwt.ecore/model/Ecore.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/plugins/org.eclipse.emf.gwt.ecore/model/XMLNamespace.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/plugins/org.eclipse.emf.gwt.ecore/model/XMLType.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/plugins/org.eclipse.emf.mapping.ecore2ecore/model/Ecore2Ecore.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/plugins/org.eclipse.emf.mapping.ecore2xml/model/Ecore2XML.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/plugins/org.eclipse.emf.mapping/model/Mapping.ecore",

				// modeling.emfcompare

				"http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.git/plugins/org.eclipse.emf.compare.diagram/model/diagramCompare.ecore",
				"http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.git/plugins/org.eclipse.emf.compare.uml2/model/uml2compare.ecore",
				"http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.git/plugins/org.eclipse.emf.compare/model/compare.ecore",

				// modeling.emft.edapt


				// modeling.emft.emf-client

				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.diffmerge.model/model/diffmerge.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.categorization.model/model/categorization.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.compoundcontrol.model/model/compoundcontrol.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.group.model/model/group.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.groupedgrid.model/model/groupedGrid.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.horizontal.model/model/horizontal.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.indexdmr.model/model/indexdmr.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.keyattributedmr.model/model/keyattributedmr.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.label.model/model/label.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.mappingdmr.model/model/mappingdmr.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.model/model/view.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.rule.model/model/rule.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.section.model/model/section.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.stack.model/model/stack.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.table.model/model/table.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.template.model/model/alignmentStyle.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.template.model/model/backgroundStyle.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.template.model/model/domainModelReferenceSelector.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.template.model/model/fontPropertiesStyle.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.template.model/model/mandatoryStyle.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.template.model/model/tableStyleProperty.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.template.model/model/tableValidationColumnStyleProperty.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.template.model/model/tabStyle.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.template.model/model/template.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.template.model/model/textControlEnablementStyle.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.template.model/model/validationStyle.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.template.model/model/viewModelElementSelector.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.treemasterdetail.model/model/treeMasterDetail.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.vertical.model/model/vertical.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emf.ecp.view.viewproxy.model/model/viewproxy.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emfforms.rulerepository.model/model/rulerepository.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emfforms.view.annotation.model/model/annotation.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/bundles/org.eclipse.emfforms.view.controlgrid.model/model/controlgrid.ecore",

				// modeling.emft.emf-store

				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git/bundles/org.eclipse.emf.emfstore.client/model/client.ecore",
				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git/bundles/org.eclipse.emf.emfstore.common.model/model/common.ecore",
				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git/bundles/org.eclipse.emf.emfstore.fuzzy.emf/model/config.ecore",
				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git/bundles/org.eclipse.emf.emfstore.server.model/model/server.ecore",

				// modeling.emft.henshin

				"http://git.eclipse.org/c/henshin/org.eclipse.emft.henshin.git/plugins/org.eclipse.emf.henshin.model/model/henshin.ecore",

				// modeling.emft.texo

				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.git/core/org.eclipse.emf.texo.json/model/request.ecore",
				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.git/generator/org.eclipse.emf.texo.annotations.model/model/texo-annotations-model.ecore",
				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.git/generator/org.eclipse.emf.texo.modelgenerator/model/texo-annotations-modelgenerator.ecore",
				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.git/generator/org.eclipse.emf.texo.orm/model/orm.ecore",
				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.git/generator/org.eclipse.emf.texo.orm/model/texo-annotations-orm.ecore",

				// modeling.emft.wazaabi

				"https://github.com/eclipse/wazaabi/plugins/org.eclipse.wazaabi.mm.core/model/core.ecore",
				"https://github.com/eclipse/wazaabi/plugins/org.eclipse.wazaabi.mm.edp/model/EDP.ecore",
				"https://github.com/eclipse/wazaabi/plugins/org.eclipse.wazaabi.mm.swt/model/SWTComponents.ecore",

				// modeling.epsilon

				"http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.git/plugins/org.eclipse.epsilon.hutn.model.antlrAst/model/org/eclipse/epsilon/hutn/model/hutnAntlrAst/AntlrAst.ecore",
				"http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.git/plugins/org.eclipse.epsilon.hutn.model.antlrAst/model/org/eclipse/epsilon/hutn/model/hutnAntlrAst/HutnAntlrAst.ecore",
				"http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.git/plugins/org.eclipse.epsilon.hutn.model.config/model/org/eclipse/epsilon/hutn/model/config/HUTNConfig.ecore",
				"http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.git/plugins/org.eclipse.epsilon.hutn.model/model/org/eclipse/epsilon/hutn/model/HUTN.ecore",

				// modeling.fmc

				"http://git.eclipse.org/c/fmc/org.eclipse.fmc.core.git/org.eclipse.fmc.mm/model/Blockdiagram.ecore",

				// modeling.gmp.gmf-notation

				"http://git.eclipse.org/c/gmf-notation/org.eclipse.gmf.notation.git/org.eclipse.gmf.runtime.notation/model/notation.ecore",

				// modeling.gmp.gmf-tooling

				"http://git.eclipse.org/c/gmf-tooling/org.eclipse.gmf-tooling.git/archive/org.eclipse.gmf.diadef/models/diadef.ecore",
				"http://git.eclipse.org/c/gmf-tooling/org.eclipse.gmf-tooling.git/plugins/org.eclipse.gmf.map/models/gmfmap_2007.ecore",
				"http://git.eclipse.org/c/gmf-tooling/org.eclipse.gmf-tooling.git/plugins/org.eclipse.gmf.tooling.simplemap.model/model/simplemap.ecore",

				// modeling.gmp.graphiti

				"https://github.com/eclipse/gmp.graphiti/plugins/org.eclipse.graphiti.mm/model/graphiti.ecore",

				// modeling.m2t.acceleo

				"http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.git/plugins/org.eclipse.acceleo.model/model/mtl.ecore",
				"http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.git/plugins/org.eclipse.acceleo.model/model/mtlstdlib.ecore",
				"http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.git/plugins/org.eclipse.acceleo.profiler/model/profiler.ecore",
				"http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.git/plugins/org.eclipse.acceleo.ui.interpreter.completeocl/model/evaluation_result.ecore",

				// modeling.m2t.xpand

				"http://git.eclipse.org/c/m2t/org.eclipse.xpand.git/plugins/org.eclipse.xpand.incremental/model/trace.ecore",

				// modeling.mdht

				"http://git.eclipse.org/c/mdht/org.eclipse.mdht.git/core/plugins/org.eclipse.mdht.metamodel.traceability/model/traceability.ecore",

				// modeling.mdt.bpmn2

				"http://git.eclipse.org/c/bpmn2/org.eclipse.bpmn2.git/org.eclipse.bpmn2/model/BPMNDI.ecore",
				"http://git.eclipse.org/c/bpmn2/org.eclipse.bpmn2.git/org.eclipse.bpmn2/model/DC.ecore",
				"http://git.eclipse.org/c/bpmn2/org.eclipse.bpmn2.git/org.eclipse.bpmn2/model/DI.ecore",

				// modeling.mdt.modisco

				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.git/org.eclipse.gmt.modisco.infra.browser.custom/models/uiCustom.ecore",
				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.git/org.eclipse.gmt.modisco.infra.facet/model/facet.ecore",
				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.git/org.eclipse.gmt.modisco.infra.query/model/query.ecore",
				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.git/org.eclipse.gmt.modisco.omg.kdm/model/kdm.ecore",
				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.git/org.eclipse.gmt.modisco.omg.smm/model/SMM.ecore",

				// modeling.mdt.ocl

				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/plugins/org.eclipse.ocl.ecore/model/OCLEcore.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/plugins/org.eclipse.ocl.pivot.uml/model/OCLforUML.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/plugins/org.eclipse.ocl.pivot/model-gen/oclstdlib.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/plugins/org.eclipse.ocl.pivot/model/Pivot.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/plugins/org.eclipse.ocl.pivot/model/Values.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/plugins/org.eclipse.ocl.uml/model/OCLUML.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/plugins/org.eclipse.ocl.xtext.base/model/BaseCS.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/plugins/org.eclipse.ocl.xtext.essentialocl/model/EssentialOCLCS.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/plugins/org.eclipse.ocl/model/OCL.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/plugins/org.eclipse.ocl/model/OCLCST.ecore",

				// modeling.mdt.ocl.examples

				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/examples/org.eclipse.ocl.examples.codegen/model/cgmodel.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/examples/org.eclipse.ocl.examples.pivot/model/pivot.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/examples/org.eclipse.ocl.examples.pivot/model/Pivot.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/examples/org.eclipse.ocl.examples.xtext.base/model/BaseCS.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/examples/org.eclipse.ocl.examples.xtext.essentialocl/model/EssentialOCLCS.ecore",

				// modeling.mdt.papyrus

				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/plugins/facet/org.eclipse.papyrus.emf.facet.custom.metamodel/model/catalog-0.2.0.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/plugins/facet/org.eclipse.papyrus.emf.facet.custom.metamodel/model/custom-0.2.0.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/plugins/facet/org.eclipse.papyrus.emf.facet.custom.metamodel/model/custom_primitive_types-0.2.0.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/plugins/facet/org.eclipse.papyrus.emf.facet.custom.metamodel/model/query-0.3.0.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/plugins/facet/org.eclipse.papyrus.emf.facet.custom.metamodel/model/treeproxy-0.2.0.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/plugins/facet/org.eclipse.papyrus.emf.facet.efacet.metamodel/model/efacet-0.2.0.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/plugins/facet/org.eclipse.papyrus.emf.facet.efacet.metamodel/model/efacetcatalog-0.2.0.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/plugins/facet/org.eclipse.papyrus.emf.facet.efacet/model/efacet.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/plugins/facet/org.eclipse.papyrus.emf.facet.util.emf.catalog/model/catalog.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/plugins/facet/org.eclipse.papyrus.emf.facet.widgets.celleditors/model/celleditors.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/plugins/infra/filters/org.eclipse.papyrus.infra.filters/model/filters.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/plugins/infra/types/org.eclipse.papyrus.infra.types/model/ElementTypesConfigurations.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/plugins/uml/org.eclipse.papyrus.uml.filters/model/umlfilters.ecore",

				// modeling.mdt.rmf

				"http://git.eclipse.org/c/rmf/org.eclipse.rmf.git/org.eclipse.rmf.reqif10.pror/model/configuration.ecore",
				"http://git.eclipse.org/c/rmf/org.eclipse.rmf.git/org.eclipse.rmf.reqif10.search/model/criteria.ecore",
				"http://git.eclipse.org/c/rmf/org.eclipse.rmf.git/org.eclipse.rmf.reqif10.xhtml/model/datatypes.ecore",
				"http://git.eclipse.org/c/rmf/org.eclipse.rmf.git/org.eclipse.rmf.reqif10.xhtml/model/xhtml.ecore",
				"http://git.eclipse.org/c/rmf/org.eclipse.rmf.git/org.eclipse.rmf.reqif10/model/reqif10.ecore",

				// modeling.mdt.sphinx

				"http://git.eclipse.org/c/sphinx/org.eclipse.sphinx.git/plugins/org.eclipse.sphinx.emf.check.catalog/model/CheckCatalog.ecore",

				// modeling.mdt.uml2

				"http://git.eclipse.org/c/uml2/org.eclipse.uml2.git/plugins/org.eclipse.uml2.codegen.ecore/model/GenModel.ecore",
				"http://git.eclipse.org/c/uml2/org.eclipse.uml2.git/plugins/org.eclipse.uml2.types/model/Types.ecore",
				"http://git.eclipse.org/c/uml2/org.eclipse.uml2.git/plugins/org.eclipse.uml2.uml.profile.standard/model/Standard.ecore",
				"http://git.eclipse.org/c/uml2/org.eclipse.uml2.git/plugins/org.eclipse.uml2.uml/model/CMOF24.ecore",
				"http://git.eclipse.org/c/uml2/org.eclipse.uml2.git/plugins/org.eclipse.uml2.uml/model/CMOF241.ecore",
				"http://git.eclipse.org/c/uml2/org.eclipse.uml2.git/plugins/org.eclipse.uml2.uml/model/UML30.ecore",

				// modeling.mmt.atl

				"http://git.eclipse.org/c/mmt/org.eclipse.atl.git/plugins/org.eclipse.m2m.atl.emftvm.trace/model/trace.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.atl.git/plugins/org.eclipse.m2m.atl.profiler.exportmodel/model/exportmodel.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.atl.git/plugins/org.eclipse.m2m.atl.profiler.model/model/ATL-Profiler.ecore",
				
				// modeling.mmt.qvt-oml

				"http://git.eclipse.org/c/mmt/org.eclipse.qvto.git/plugins/org.eclipse.m2m.qvt.oml.ecore.imperativeocl/model/ImperativeOCL.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvto.git/plugins/org.eclipse.m2m.qvt.oml.emf.util/model/MModelURIMap.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvto.git/plugins/org.eclipse.m2m.qvt.oml/model/trace.ecore",

				// modeling.mmt.qvtd

				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvtd.codegen/model/qvticgmodel.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvtd.compiler/model/ECoreContainmentTree.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvtd.pivot.qvtbase/model/QVTbaseStructural.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvtd.pivot.qvtcorebase/model/QVTcoreBase.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvtd.pivot.qvtcore/model/QVTcoreStructural.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvtd.pivot.qvtimperative/model/EvaluationStatus.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperativeStructural.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvtd.umlx/model/UMLX.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvtd.xtext.qvtbase/model/QVTbaseCS.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvtd.xtext.qvtcorebase/model/QVTcoreBaseCS.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvtd.xtext.qvtcore/model/QVTcoreCS.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvtd.xtext.qvtimperative/model/QVTimperativeCS.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvt/model/ecore/EMOF.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvt/model/ecore/EssentialOCL.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvt/model/ecore/PrimitiveTypes.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvt/model/ecore/QVTBase.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvt/model/ecore/QVTCore.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvt/model/ecore/QVTOperational.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvt/model/ecore/QVTRelation.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/plugins/org.eclipse.qvt/model/ecore/QVTTemplate.ecore",

				// modeling.pmf

				"http://git.eclipse.org/c/pmf/org.eclipse.pmf.git/org.eclipse.pmf.pim/model/emf.ecore",

				// modeling.sirius

				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.git/plugins/org.eclipse.sirius.diagram/model/diagram.ecore",
				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.git/plugins/org.eclipse.sirius.properties.ext.widgets.reference/model/properties-ext-widgets-reference.ecore",
				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.git/plugins/org.eclipse.sirius.properties/model/properties.ecore",
				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.git/plugins/org.eclipse.sirius.sample.interactions/model/interactions.ecore",
				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.git/plugins/org.eclipse.sirius/model/contribution.ecore",

				// modeling.tmf.xtext.core

				"https://github.com/eclipse/xtext-coreorg.eclipse.xtext.tests/src/org/eclipse/xtext/linking/lazy/LazyLinkingTestLanguage.ecore",

				// modeling.tmf.xtext.extras

				"https://github.com/eclipse/xtext-extras/org.eclipse.xtext.common.types/model/JavaVMTypes.ecore",
				"https://github.com/eclipse/xtext-extras/org.eclipse.xtext.xbase/model/Xbase.ecore",

				// science.eavp


				// technology.camf

				"http://git.eclipse.org/c/camf/org.eclipse.camf.git/plugins/org.eclipse.camf.infosystem.model/model/infosystem.ecore",
				"http://git.eclipse.org/c/camf/org.eclipse.camf.git/plugins/org.eclipse.camf.tosca/model/extension.ecore",
				"http://git.eclipse.org/c/camf/org.eclipse.camf.git/plugins/org.eclipse.camf.tosca/model/hrequirements.ecore",
				"http://git.eclipse.org/c/camf/org.eclipse.camf.git/plugins/org.eclipse.camf.tosca/model/sybl.ecore",
				"http://git.eclipse.org/c/camf/org.eclipse.camf.git/plugins/org.eclipse.camf.tosca/model/tosca.ecore",

				// technology.cbi

				"https://github.com/eclipse/b3/org.eclipse.b3.p2.maven/model/maven-metadata.ecore",
				"https://github.com/eclipse/b3/org.eclipse.b3.p2/model/p2.ecore",

				// technology.dltk.core

				"http://git.eclipse.org/c/dltk/org.eclipse.dltk.core.git/core/plugins/org.eclipse.dltk.core/models/cache_model.ecore",
				"http://git.eclipse.org/c/dltk/org.eclipse.dltk.core.git/core/plugins/org.eclipse.dltk.launching/model/launching.ecore",
				"http://git.eclipse.org/c/dltk/org.eclipse.dltk.core.git/core/plugins/org.eclipse.dltk.validators.core/models/validators.ecore",

				// technology.dltk.javascript

				"https://github.com/eclipse/dltk.javascript/plugins/org.eclipse.dltk.javascript.core.manipulation/model/dom.ecore",
				"https://github.com/eclipse/dltk.javascript/plugins/org.eclipse.dltk.javascript.core/model/references.ecore",

				// technology.ogee

				"http://git.eclipse.org/c/ogee/org.eclipse.ogee.git/org.eclipse.ogee.model/model/OData.ecore",

				// technology.stem

				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/core/org.eclipse.stem.core/model/common.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/core/org.eclipse.stem.core/model/experiment.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/core/org.eclipse.stem.core/model/logger.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/core/org.eclipse.stem.core/model/modifier.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/core/org.eclipse.stem.core/model/predicate.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/core/org.eclipse.stem.core/model/sequencer.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/core/org.eclipse.stem.core/model/solver.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/core/org.eclipse.stem.core/model/trigger.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/core/org.eclipse.stem.definitions/model/edges.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/core/org.eclipse.stem.definitions/model/labels.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/core/org.eclipse.stem.definitions/model/nodes.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/core/org.eclipse.stem.definitions/model/types.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/models/populations/org.eclipse.stem.populationmodels/model/standard.ecore",

				// tools.buckminster

				"http://git.eclipse.org/c/buckminster/buckminster.git/org.eclipse.buckminster.model.common/model/common.ecore",
				"http://git.eclipse.org/c/buckminster/buckminster.git/org.eclipse.buckminster.mspec/model/mspec.ecore",
		};
		modelHistoryFilter.addAll(Arrays.asList(modelHistoryFilterArray));
	}
	
	protected static String getFilter(HistoryMetadata history) {
		return history.getRepositoryURL() + history.getNewestVersion().getRemoteFilePath();
	}
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		CoevolutionDataSetMetadata dataset = new CoevolutionDataSetMetadata("C:\\evaluation_resolved\\", true);
		
		Set<String> validationNames = new HashSet<>();
		Map<HistoryMetadata, Set<String>> inconsistentHistories = new LinkedHashMap<>();
		int inconsistencyCount = 0;
		int inconsistentModels = 0;
		
//		boolean start = false;
		String lastProject = "";
		
		for (HistoryMetadata history : dataset.getHistories()) {
			
//			// Validate only project X:
//			if (!history.getProjectName().contains("modeling.mmt.qvt")) {
//				continue;
//			} 
			
//			// Start validation with project X:
//			if (history.getProjectName().contains("modeling.mmt.atl")) {
//				start = true;
//			} else {
//				if (!start) {
//					continue;
//				}
//			}
			
			if (modelHistoryFilter.contains(getFilter(history))) {
				continue;
			}
			
			if (!lastProject.equals(history.getProjectName())) {
				lastProject = history.getProjectName();
				
				System.out.println();
				System.out.println("// " + history.getProjectName());
				System.out.println();
			}
			
			try {
				boolean hasInconsistencies = false;
				Set<String> unresolvedVersions = new HashSet<>();
				
				for (VersionMetadata version : history.getVersions()) {
					CoevolutionVersionMetadata workspaceVersion = (CoevolutionVersionMetadata) version;
					
					URI uri = URI.createFileURI(history.getDatafile().getParent() + "/" + workspaceVersion.getLocalFilePath());
					
//					// Filter co-evolutions that after the last version of the model:
//					Date coevolutionDate = workspaceVersion.getParsedCoevolutionDate();
//
//					if ((coevolutionDate != null) && coevolutionDate.after(history.getNewestVersion().getParsedDate())) {
//						continue;
//					}
					
					ResourceSet resourceSet = new ResourceSetImpl();
					Resource model = HistoryUtil.load(resourceSet, uri);
					Version modelVersion = HistoryModelFactory.eINSTANCE.createVersion();
					modelVersion.setModel(model);
					
					EMFValidator validator = new EMFValidator();
					validator.validate(modelVersion);
					
					Collection<Problem> inconsistencies = modelVersion.getProblems();

					// Analyze inconsistencies:
					if (!inconsistencies.isEmpty()) {
						hasInconsistencies = true;

						inconsistencyCount += inconsistencies.size();
						++inconsistentModels;

						Set<String> modelValidationNames = inconsistencies.stream().map(Problem::getName).collect(Collectors.toSet());
						validationNames.addAll(modelValidationNames);

						if (inconsistentHistories.containsKey(history)) {
							inconsistentHistories.get(history).addAll(modelValidationNames);
						} else  {
							inconsistentHistories.put(history, modelValidationNames);
						}

						for (Problem inconsistency : inconsistencies) {
							if (inconsistency.getName().equals(EcoreHistorySettings.INCONSISTENCY_UNRESOLVED_PROXY)) {
								unresolvedVersions.add(workspaceVersion.getLocalFilePath());
							}
						}
					}
				}
				
				if (!unresolvedVersions.isEmpty()) {
					System.out.println("Project: " + history.getProjectName() + " Model: " + history.getLatestRemoteFilePath());
					System.out.println("Unresolved Proxy:");
					
					for (String unresolvedVersion : unresolvedVersions) {
						System.out.println(unresolvedVersion);
					}
				}
				
				if (!hasInconsistencies) {
					System.out.println("\"" + getFilter(history) + "\",");
				}
			} catch(Exception e) {
				System.out.println("Project: " + history.getProjectName() + " Model: " + history.getLatestRemoteFilePath());
				e.printStackTrace();
			}
		}
		
		System.out.println("Inconsistencies found: " + inconsistencyCount);
		System.out.println("Inconsistent models: " + inconsistentModels);
		System.out.println();
		System.out.println("Inconsistencies per Project:");
		
		for (HistoryMetadata history : inconsistentHistories.keySet()) {
			System.out.println();
			System.out.println("Project: " + history.getProjectName() + " Model: " + history.getLatestRemoteFilePath());
			
			for (String inconsistency : inconsistentHistories.get(history)) {
				System.out.println(inconsistency);
			}
		}
		
		
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
	}
}
