package org.sidiff.repair.history.generator.ecore;

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
import org.sidiff.historymodel.ValidationError;
import org.sidiff.repair.history.generator.metadata.HistoryMetadata;
import org.sidiff.repair.history.generator.metadata.VersionMetadata;
import org.sidiff.repair.history.generator.metadata.coevolution.CoevolutionDataSetMetadata;
import org.sidiff.repair.history.generator.metadata.coevolution.CoevolutionVersionMetadata;
import org.sidiff.repair.history.generator.util.HistoryUtil;
import org.sidiff.repair.history.generator.validation.EMFValidator;

public class EcoreHistoryValidationApplication implements IApplication  {

	// Histories with no inconsistencies:
	private Set<String> modelHistoryFilter = new HashSet<>();
	{
		String[] modelHistoryFilterArray = {
				
//				// birt
//				"https://github.com/eclipse/birtorg.eclipse.birt.chart.model.attribute.ecore",
//				"https://github.com/eclipse/birtorg.eclipse.birt.chart.model.component.ecore",
//				"https://github.com/eclipse/birtorg.eclipse.birt.chart.model.data.ecore",
//				"https://github.com/eclipse/birtorg.eclipse.birt.chart.model.ecore",
//				"https://github.com/eclipse/birtorg.eclipse.birt.chart.model.layout.ecore",
//				"https://github.com/eclipse/birtmodel.ecore",
//				
//				// datatools
//				"http://git.eclipse.org/c/datatools/org.eclipse.datatools.git/org.eclipse.datatools.connectivity.oda.design.ecore",
//				
//				// eclipse.e4
//				"http://git.eclipse.org/c/eatop/org.eclipse.eatop.git/geastadl.ecore",
//				
//				// modeling.eatop
//				"http://git.eclipse.org/c/eatop/org.eclipse.eatop.git/geastadl.ecore",
//				
//				// modeling.elk
//				
//				// modeling.eef
//				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/eef.ecore",
//				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/components.ecore",
//				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/extended.ecore",
//				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/EEFGen.ecore",
//				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/mapping.ecore",
//				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/views.ecore",
//				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/context.ecore",
//				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/contentassist.ecore",
//				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/expression.ecore",
//				"http://git.eclipse.org/c/eef/org.eclipse.eef.git/validation.ecore",
//				
//				// modeling.elk
//				"https://github.com/eclipse/elkelkgraph.ecore",
//				
//				// modeling.emf.cdo
//				"http://git.eclipse.org/c/cdo/cdo.git/company.ecore",
//				"http://git.eclipse.org/c/cdo/cdo.git/expressions.ecore",
//				"http://git.eclipse.org/c/cdo/cdo.git/security.ecore",
//				"http://git.eclipse.org/c/cdo/cdo.git/eresource.ecore",
//				"http://git.eclipse.org/c/cdo/cdo.git/etypes.ecore",
//				"http://git.eclipse.org/c/cdo/cdo.git/business.ecore",
//				"http://git.eclipse.org/c/cdo/cdo.git/inventory.ecore",
//				
//				// modeling.emf.diffmerge.coevolution
//				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.coevolution.git/BridgeTraces.ecore",
//				
//				// modeling.emf.diffmerge.core
//				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.core.git//DiffData.ecore",
//				
//				// modeling.emf.diffmerge.patch
//				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patch.git/modelpatch.ecore",
//				
//				// modeling.emf.diffmerge.patterns
//				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.git/CorePatterns.ecore",
//				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.git/CommonPatternSupport.ecore",
//				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.git/TemplatePatterns.ecore",
//				
//				// modeling.emf.egf
//				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/Fprod.ecore",
//				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/Ftask.ecore",
//				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/JavaPattern.ecore",
//				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/JetPattern.ecore",
//				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/Domain.ecore",
//				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/Fcore.ecore",
//				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/Mapping.ecore",
//				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/Pattern.ecore",
//				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git/Types.ecore",
//				
//				// modeling.emf.emf
//				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/Xcore.ecore",
//				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/Ecore.ecore",
//				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/XMLNamespace.ecore",
//				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/Tree.ecore",
//				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/Ecore.ecore",
//				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/XMLNamespace.ecore",
//				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/XMLType.ecore",
//				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/Ecore2Ecore.ecore",
//				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/Ecore2XML.ecore",
//				"https://git.eclipse.org/c/emf/org.eclipse.emf.git/Mapping.ecore",
//				
//				// modeling.emfcompare
//				"http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.git/diagramCompare.ecore",
//				"http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.git/uml2compare.ecore",
//				"http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.git/compare.ecore",
//				
//				// modeling.emft.edapt
//				
//				// modeling.emft.emf-client
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/diffmerge.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/categorization.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/compoundcontrol.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/group.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/groupedGrid.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/horizontal.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/indexdmr.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/keyattributedmr.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/label.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/mappingdmr.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/view.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/rule.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/section.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/stack.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/table.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/alignmentStyle.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/backgroundStyle.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/domainModelReferenceSelector.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/fontPropertiesStyle.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/mandatoryStyle.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/tableStyleProperty.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/tableValidationColumnStyleProperty.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/tabStyle.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/template.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/textControlEnablementStyle.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/validationStyle.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/viewModelElementSelector.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/treeMasterDetail.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/vertical.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/viewproxy.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/rulerepository.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/annotation.ecore",
//				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git/controlgrid.ecore",
//				
//				// modeling.emft.emf-store
//				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git/client.ecore",
//				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git/common.ecore",
//				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git/config.ecore",
//				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git/server.ecore",
//				
//				// modeling.emft.henshin
//				"http://git.eclipse.org/c/henshin/org.eclipse.emft.henshin.git/henshin.ecore",
//				
//				// modeling.emft.texo
//				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.git/request.ecore",
//				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.git/texo-annotations-model.ecore",
//				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.git/texo-annotations-modelgenerator.ecore",
//				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.git/orm.ecore",
//				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.git/texo-annotations-orm.ecore",
//				
//				// modeling.emft.wazaabi
//				"https://github.com/eclipse/wazaabicore.ecore",
//				"https://github.com/eclipse/wazaabiEDP.ecore",
//				"https://github.com/eclipse/wazaabiSWTComponents.ecore",
//				
//				// modeling.epsilon
//				"http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.git/AntlrAst.ecore",
//				"http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.git/HutnAntlrAst.ecore",
//				"http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.git/HUTNConfig.ecore",
//				"http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.git/HUTN.ecore",
//
//				// modeling.fmc
//				"http://git.eclipse.org/c/fmc/org.eclipse.fmc.core.git/Blockdiagram.ecore",
//				
//				// modeling.gmp.gmf-notation
//				"http://git.eclipse.org/c/gmf-notation/org.eclipse.gmf.notation.git/notation.ecore",
//				
//				// modeling.gmp.gmf-tooling
//				"http://git.eclipse.org/c/gmf-tooling/org.eclipse.gmf-tooling.git/diadef.ecore",
//				"http://git.eclipse.org/c/gmf-tooling/org.eclipse.gmf-tooling.git/gmfmap_2007.ecore",
//				"http://git.eclipse.org/c/gmf-tooling/org.eclipse.gmf-tooling.git/simplemap.ecore",
//				
//				// modeling.gmp.graphiti
//				"https://github.com/eclipse/gmp.graphitigraphiti.ecore",
//
//				// modeling.m2t.acceleo
//				"http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.git/mtl.ecore",
//				"http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.git/mtlstdlib.ecore",
//				"http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.git/profiler.ecore",
//				"http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.git/evaluation_result.ecore",
//				
//				// modeling.m2t.xpand
//				"http://git.eclipse.org/c/m2t/org.eclipse.xpand.git/trace.ecore",
//				
//				// modeling.mdht
//				"http://git.eclipse.org/c/mdht/org.eclipse.mdht.git/traceability.ecore",
//				
//				// modeling.mdt.bpmn2
//				"http://git.eclipse.org/c/bpmn2/org.eclipse.bpmn2.git/BPMNDI.ecore",
//				"http://git.eclipse.org/c/bpmn2/org.eclipse.bpmn2.git/DC.ecore",
//				"http://git.eclipse.org/c/bpmn2/org.eclipse.bpmn2.git/DI.ecore",
//				
//				// modeling.mdt.modisco
//				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.git/uiCustom.ecore",
//				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.git/facet.ecore",
//				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.git/query.ecore",
//				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.git/kdm.ecore",
//				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.git/SMM.ecore",
//				
//				// modeling.mdt.ocl
//				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/OCLEcore.ecore",
//				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/OCLforUML.ecore",
//				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/Pivot.ecore",
//				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/Values.ecore",
//				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/OCLUML.ecore",
//				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/BaseCS.ecore",
//				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/EssentialOCLCS.ecore",
//				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/OCL.ecore",
//				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/OCLCST.ecore",
//				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/cgmodel.ecore",
//				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/pivot.ecore",
//				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/BaseCS.ecore",
//				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/EssentialOCLCS.ecore",
//				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.git/oclstdlib.ecore",
//				
//				// modeling.mdt.ocl.examples
//				
//				// modeling.mdt.papyrus
//				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/catalog-0.2.0.ecore",
//				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/custom-0.2.0.ecore",
//				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/custom_primitive_types-0.2.0.ecore",
//				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/query-0.3.0.ecore",
//				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/treeproxy-0.2.0.ecore",
//				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/efacet-0.2.0.ecore",
//				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/efacetcatalog-0.2.0.ecore",
//				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/efacet.ecore",
//				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/catalog.ecore",
//				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/celleditors.ecore",
//				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/filters.ecore",
//				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/ElementTypesConfigurations.ecore",
//				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git/umlfilters.ecore",
//				
//				// modeling.mdt.rmf
//				"http://git.eclipse.org/c/rmf/org.eclipse.rmf.git/configuration.ecore",
//				"http://git.eclipse.org/c/rmf/org.eclipse.rmf.git/criteria.ecore",
//				"http://git.eclipse.org/c/rmf/org.eclipse.rmf.git/datatypes.ecore",
//				"http://git.eclipse.org/c/rmf/org.eclipse.rmf.git/xhtml.ecore",
//				"http://git.eclipse.org/c/rmf/org.eclipse.rmf.git/reqif10.ecore",
//				
//				// modeling.mdt.sphinx
//				"http://git.eclipse.org/c/sphinx/org.eclipse.sphinx.git/CheckCatalog.ecore",
//				
//				// modeling.mdt.uml2
//				"http://git.eclipse.org/c/uml2/org.eclipse.uml2.git/UML30.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.atl.git/trace.ecore",
//				"http://git.eclipse.org/c/uml2/org.eclipse.uml2.git/Types.ecore",
//				"http://git.eclipse.org/c/uml2/org.eclipse.uml2.git/Standard.ecore",
//				"http://git.eclipse.org/c/uml2/org.eclipse.uml2.git/CMOF24.ecore",
//				"http://git.eclipse.org/c/uml2/org.eclipse.uml2.git/CMOF241.ecore",
//				
//				// TODO
//				// modeling.mmt.atl
//				"http://git.eclipse.org/c/mmt/org.eclipse.atl.git/exportmodel.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.atl.git/ATL-Profiler.ecore",
//				
//				// modeling.mmt.qvtd
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/EMOF.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/EssentialOCL.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/PrimitiveTypes.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/QVTBase.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/QVTCore.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/QVTRelation.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/QVTTemplate.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/qvticgmodel.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/ECoreContainmentTree.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/QVTbaseStructural.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/QVTcoreStructural.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/QVTcoreBase.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/EvaluationStatus.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/QVTimperativeStructural.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/UMLX.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/QVTbaseCS.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/QVTcoreCS.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git/QVTimperativeCS.ecore",
//				
//				// modeling.mmt.qvt-oml
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvto.git/ImperativeOCL.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvto.git/MModelURIMap.ecore",
//				"http://git.eclipse.org/c/mmt/org.eclipse.qvto.git/trace.ecore",
//							
//				// modeling.pmf
//				"http://git.eclipse.org/c/pmf/org.eclipse.pmf.git/emf.ecore",
//				
//				// modeling.sirius
//				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.git/diagram.ecore",
//				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.git/properties-ext-widgets-reference.ecore",
//				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.git/properties.ecore",
//				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.git/interactions.ecore",
//				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.git/contribution.ecore",
//				
//				// modeling.tmf.xtext.core
//				"https://github.com/eclipse/xtext-coreLazyLinkingTestLanguage.ecore",
//				
//				// modeling.tmf.xtext.extras
//				"https://github.com/eclipse/xtext-extrasJavaVMTypes.ecore",
//				"https://github.com/eclipse/xtext-extrasXbase.ecore",
//				
//				// science.eavp
//				
//				// technology.camf
//				"http://git.eclipse.org/c/camf/org.eclipse.camf.git/infosystem.ecore",
//				"http://git.eclipse.org/c/camf/org.eclipse.camf.git/extension.ecore",
//				"http://git.eclipse.org/c/camf/org.eclipse.camf.git/hrequirements.ecore",
//				"http://git.eclipse.org/c/camf/org.eclipse.camf.git/sybl.ecore",
//				"http://git.eclipse.org/c/camf/org.eclipse.camf.git/tosca.ecore",
//				
//				// technology.cbi
//				"https://github.com/eclipse/b3maven-metadata.ecore",
//				"https://github.com/eclipse/b3p2.ecore",
//				
//				// technology.dltk.core
//				"http://git.eclipse.org/c/dltk/org.eclipse.dltk.core.git/cache_model.ecore",
//				"http://git.eclipse.org/c/dltk/org.eclipse.dltk.core.git/launching.ecore",
//				"http://git.eclipse.org/c/dltk/org.eclipse.dltk.core.git/validators.ecore",
//				
//				// technology.dltk.javascript
//				"https://github.com/eclipse/dltk.javascriptdom.ecore",
//				"https://github.com/eclipse/dltk.javascriptreferences.ecore",
//				"http://git.eclipse.org/c/ogee/org.eclipse.ogee.git/OData.ecore",
//				
//				// technology.ogee
//				
//				// technology.stem
//				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/common.ecore",
//				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/experiment.ecore",
//				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/logger.ecore",
//				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/modifier.ecore",
//				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/predicate.ecore",
//				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/sequencer.ecore",
//				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/solver.ecore",
//				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/trigger.ecore",
//				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/edges.ecore",
//				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/labels.ecore",
//				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/nodes.ecore",
//				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/types.ecore",
//				"http://git.eclipse.org/c/stem/org.eclipse.stem.git/standard.ecore"
//				
//				// tools.buckminster
				
		};
		modelHistoryFilter.addAll(Arrays.asList(modelHistoryFilterArray));
	}
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		CoevolutionDataSetMetadata dataset = new CoevolutionDataSetMetadata("C:\\evaluation_resolved\\", true);
		
		Set<String> validationNames = new HashSet<>();
		Map<HistoryMetadata, Set<String>> inconsistentHistories = new LinkedHashMap<>();
		int inconsistencyCount = 0;
		int inconsistentModels = 0;
		
		boolean start = false;
		
		for (HistoryMetadata history : dataset.getHistories()) {
			if (history.getProjectName().contains("modeling.mmt.atl")) {
				start = true;
			} else {
				if (!start) {
					continue;
				}
			}
			
			if (modelHistoryFilter.contains(getFilter(history))) {
				continue;
			}
			
			System.out.println("Project: " + history.getProjectName() + " Model: " + history.getLatestRemoteFilePath());
			
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

					EMFValidator validator = new EMFValidator();
					Collection<ValidationError> inconsistencies = validator.validate(model);

					// Analyze inconsistencies:
					if (!inconsistencies.isEmpty()) {
						hasInconsistencies = true;

						inconsistencyCount += inconsistencies.size();
						++inconsistentModels;

						Set<String> modelValidationNames = inconsistencies.stream().map(ValidationError::getName).collect(Collectors.toSet());
						validationNames.addAll(modelValidationNames);

						if (inconsistentHistories.containsKey(history)) {
							inconsistentHistories.get(history).addAll(modelValidationNames);
						} else  {
							inconsistentHistories.put(history, modelValidationNames);
						}

						for (ValidationError inconsistency : inconsistencies) {
							if (inconsistency.getName().equals("TheFeatureOfContainsAnUnresolvedProxy")) {
								unresolvedVersions.add(workspaceVersion.getLocalFilePath());
							}
						}
					}
				}
				
				if (!unresolvedVersions.isEmpty()) {
					System.out.println("Unresolved Proxy:");
					
					for (String unresolvedVersion : unresolvedVersions) {
						System.out.println(unresolvedVersion);
					}
				}
				
				if (!hasInconsistencies) {
					System.out.println("\"" + getFilter(history) + "\",");
				}
			} catch(Exception e) {
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
	
	protected String getFilter(HistoryMetadata history) {
		return history.getRepositoryURL() + "/" + history.getNewestVersion().getFileName();
	}

	@Override
	public void stop() {
	}
}
