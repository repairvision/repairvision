package org.sidiff.repair.history.generator.ecore;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
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
import org.sidiff.repair.history.generator.metadata.DataSetMetadata;
import org.sidiff.repair.history.generator.metadata.HistoryMetadata;
import org.sidiff.repair.history.generator.util.HistoryUtil;
import org.sidiff.repair.history.generator.validation.EMFValidator;

public class EcoreHistoryValidationApplication implements IApplication  {

	// Histories with no inconsistencies:
	private Set<String> modelHistoryFilter = new HashSet<>();
	{
		String[] modelHistoryFilterArray = {
				
				// birt
				"https://github.com/eclipse/birtorg.eclipse.birt.chart.model.attribute.ecore",
				"https://github.com/eclipse/birtorg.eclipse.birt.chart.model.component.ecore",
				"https://github.com/eclipse/birtorg.eclipse.birt.chart.model.data.ecore",
				"https://github.com/eclipse/birtorg.eclipse.birt.chart.model.ecore",
				"https://github.com/eclipse/birtorg.eclipse.birt.chart.model.layout.ecore",
				"https://github.com/eclipse/birtmodel.ecore",
				
				// datatools
				"http://git.eclipse.org/c/datatools/org.eclipse.datatools.gitorg.eclipse.datatools.connectivity.oda.design.ecore",
				
				// eclipse.e4
				"http://git.eclipse.org/c/eatop/org.eclipse.eatop.gitgeastadl.ecore",
				
				// modeling.eatop
				"http://git.eclipse.org/c/eatop/org.eclipse.eatop.gitgeastadl.ecore",
				
				// modeling.elk
				
				// modeling.eef
				"http://git.eclipse.org/c/eef/org.eclipse.eef.giteef.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.gitcomponents.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.gitextended.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.gitEEFGen.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.gitmapping.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.gitviews.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.gitcontext.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.gitcontentassist.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.gitexpression.ecore",
				"http://git.eclipse.org/c/eef/org.eclipse.eef.gitvalidation.ecore",
				
				// modeling.elk
				"https://github.com/eclipse/elkelkgraph.ecore",
				
				// modeling.emf.cdo
				"http://git.eclipse.org/c/cdo/cdo.gitcompany.ecore",
				"http://git.eclipse.org/c/cdo/cdo.gitexpressions.ecore",
				"http://git.eclipse.org/c/cdo/cdo.gitsecurity.ecore",
				"http://git.eclipse.org/c/cdo/cdo.giteresource.ecore",
				"http://git.eclipse.org/c/cdo/cdo.gitetypes.ecore",
				"http://git.eclipse.org/c/cdo/cdo.gitbusiness.ecore",
				"http://git.eclipse.org/c/cdo/cdo.gitinventory.ecore",
				
				// modeling.emf.diffmerge.coevolution
				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.coevolution.gitBridgeTraces.ecore",
				
				// modeling.emf.diffmerge.core
				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.core.gitDiffData.ecore",
				
				// modeling.emf.diffmerge.patch
				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patch.gitmodelpatch.ecore",
				
				// modeling.emf.diffmerge.patterns
				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.gitCorePatterns.ecore",
				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.gitCommonPatternSupport.ecore",
				"http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.gitTemplatePatterns.ecore",
				
				// modeling.emf.egf
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.gitFprod.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.gitFtask.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.gitJavaPattern.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.gitJetPattern.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.gitDomain.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.gitFcore.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.gitMapping.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.gitPattern.ecore",
				"http://git.eclipse.org/c/egf/org.eclipse.emf.egf.gitTypes.ecore",
				
				// modeling.emf.emf
				"https://git.eclipse.org/c/emf/org.eclipse.emf.gitXcore.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.gitEcore.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.gitXMLNamespace.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.gitTree.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.gitEcore.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.gitXMLNamespace.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.gitXMLType.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.gitEcore2Ecore.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.gitEcore2XML.ecore",
				"https://git.eclipse.org/c/emf/org.eclipse.emf.gitMapping.ecore",
				
				// modeling.emfcompare
				"http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.gitdiagramCompare.ecore",
				"http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.gituml2compare.ecore",
				"http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.gitcompare.ecore",
				
				// modeling.emft.edapt
				
				// modeling.emft.emf-client
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitdiffmerge.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitcategorization.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitcompoundcontrol.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitgroup.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitgroupedGrid.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.githorizontal.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitindexdmr.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitkeyattributedmr.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitlabel.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitmappingdmr.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitview.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitrule.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitsection.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitstack.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gittable.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitalignmentStyle.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitbackgroundStyle.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitdomainModelReferenceSelector.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitfontPropertiesStyle.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitmandatoryStyle.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gittableStyleProperty.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gittableValidationColumnStyleProperty.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gittabStyle.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gittemplate.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gittextControlEnablementStyle.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitvalidationStyle.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitviewModelElementSelector.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gittreeMasterDetail.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitvertical.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitviewproxy.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitrulerepository.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitannotation.ecore",
				"http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.gitcontrolgrid.ecore",
				
				// modeling.emft.emf-store
				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.gitclient.ecore",
				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.gitcommon.ecore",
				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.gitconfig.ecore",
				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.gitserver.ecore",
				
				// modeling.emft.henshin
				"http://git.eclipse.org/c/henshin/org.eclipse.emft.henshin.githenshin.ecore",
				
				// modeling.emft.texo
				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.gitrequest.ecore",
				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.gittexo-annotations-model.ecore",
				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.gittexo-annotations-modelgenerator.ecore",
				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.gitorm.ecore",
				"http://git.eclipse.org/c/texo/org.eclipse.emf.texo.gittexo-annotations-orm.ecore",
				
				// modeling.emft.wazaabi
				"https://github.com/eclipse/wazaabicore.ecore",
				"https://github.com/eclipse/wazaabiEDP.ecore",
				"https://github.com/eclipse/wazaabiSWTComponents.ecore",
				
				// modeling.epsilon
				"http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.gitAntlrAst.ecore",
				"http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.gitHutnAntlrAst.ecore",
				"http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.gitHUTNConfig.ecore",
				"http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.gitHUTN.ecore",

				// modeling.fmc
				"http://git.eclipse.org/c/fmc/org.eclipse.fmc.core.gitBlockdiagram.ecore",
				
				// modeling.gmp.gmf-notation
				"http://git.eclipse.org/c/gmf-notation/org.eclipse.gmf.notation.gitnotation.ecore",
				
				// modeling.gmp.gmf-tooling
				"http://git.eclipse.org/c/gmf-tooling/org.eclipse.gmf-tooling.gitdiadef.ecore",
				"http://git.eclipse.org/c/gmf-tooling/org.eclipse.gmf-tooling.gitgmfmap_2007.ecore",
				"http://git.eclipse.org/c/gmf-tooling/org.eclipse.gmf-tooling.gitsimplemap.ecore",
				
				// modeling.gmp.graphiti
				"https://github.com/eclipse/gmp.graphitigraphiti.ecore",

				// modeling.m2t.acceleo
				"http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.gitmtl.ecore",
				"http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.gitmtlstdlib.ecore",
				"http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.gitprofiler.ecore",
				"http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.gitevaluation_result.ecore",
				
				// modeling.m2t.xpand
				"http://git.eclipse.org/c/m2t/org.eclipse.xpand.gittrace.ecore",
				
				// modeling.mdht
				"http://git.eclipse.org/c/mdht/org.eclipse.mdht.gittraceability.ecore",
				
				// modeling.mdt.bpmn2
				"http://git.eclipse.org/c/bpmn2/org.eclipse.bpmn2.gitBPMNDI.ecore",
				"http://git.eclipse.org/c/bpmn2/org.eclipse.bpmn2.gitDC.ecore",
				"http://git.eclipse.org/c/bpmn2/org.eclipse.bpmn2.gitDI.ecore",
				
				// modeling.mdt.modisco
				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.gituiCustom.ecore",
				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.gitfacet.ecore",
				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.gitquery.ecore",
				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.gitkdm.ecore",
				"http://git.eclipse.org/c/modisco/org.eclipse.modisco.gitSMM.ecore",
				
				// modeling.mdt.ocl
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.gitOCLEcore.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.gitOCLforUML.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.gitPivot.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.gitValues.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.gitOCLUML.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.gitBaseCS.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.gitEssentialOCLCS.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.gitOCL.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.gitOCLCST.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.gitcgmodel.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.gitpivot.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.gitBaseCS.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.gitEssentialOCLCS.ecore",
				"http://git.eclipse.org/c/ocl/org.eclipse.ocl.gitoclstdlib.ecore",
				
				// modeling.mdt.ocl.examples
				
				// modeling.mdt.papyrus
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.gitcatalog-0.2.0.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.gitcustom-0.2.0.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.gitcustom_primitive_types-0.2.0.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.gitquery-0.3.0.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.gittreeproxy-0.2.0.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.gitefacet-0.2.0.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.gitefacetcatalog-0.2.0.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.gitefacet.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.gitcatalog.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.gitcelleditors.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.gitfilters.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.gitElementTypesConfigurations.ecore",
				"http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.gitumlfilters.ecore",
				
				// TODO
				// modeling.mdt.rmf
				
				// modeling.mdt.sphinx
				
				// modeling.mdt.uml2
				"http://git.eclipse.org/c/uml2/org.eclipse.uml2.gitUML30.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.atl.gittrace.ecore",
				
				// modeling.mmt.atl
				"http://git.eclipse.org/c/mmt/org.eclipse.atl.gitexportmodel.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.atl.gitATL-Profiler.ecore",
				
				// modeling.mmt.qvtd
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitEMOF.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitEssentialOCL.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitPrimitiveTypes.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitQVTBase.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitQVTCore.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitQVTRelation.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitQVTTemplate.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitqvticgmodel.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitECoreContainmentTree.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitQVTbaseStructural.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitQVTcoreStructural.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitQVTcoreBase.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitEvaluationStatus.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitQVTimperativeStructural.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitUMLX.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitQVTbaseCS.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitQVTcoreCS.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvtd.gitQVTimperativeCS.ecore",
				
				// modeling.mmt.qvt-oml
				"http://git.eclipse.org/c/mmt/org.eclipse.qvto.gitImperativeOCL.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvto.gitMModelURIMap.ecore",
				"http://git.eclipse.org/c/mmt/org.eclipse.qvto.gittrace.ecore",
							
				// modeling.pmf
				"http://git.eclipse.org/c/pmf/org.eclipse.pmf.gitemf.ecore",
				
				// modeling.sirius
				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.gitdiagram.ecore",
				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.gitproperties-ext-widgets-reference.ecore",
				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.gitproperties.ecore",
				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.gitinteractions.ecore",
				"http://git.eclipse.org/c/sirius/org.eclipse.sirius.gitcontribution.ecore",
				
				// modeling.tmf.xtext.core
				"https://github.com/eclipse/xtext-coreLazyLinkingTestLanguage.ecore",
				
				// modeling.tmf.xtext.extras
				"https://github.com/eclipse/xtext-extrasJavaVMTypes.ecore",
				"https://github.com/eclipse/xtext-extrasXbase.ecore",
				
				// science.eavp
				
				// technology.camf
				"http://git.eclipse.org/c/camf/org.eclipse.camf.gitinfosystem.ecore",
				"http://git.eclipse.org/c/camf/org.eclipse.camf.gitextension.ecore",
				"http://git.eclipse.org/c/camf/org.eclipse.camf.githrequirements.ecore",
				"http://git.eclipse.org/c/camf/org.eclipse.camf.gitsybl.ecore",
				"http://git.eclipse.org/c/camf/org.eclipse.camf.gittosca.ecore",
				
				// technology.cbi
				"https://github.com/eclipse/b3maven-metadata.ecore",
				"https://github.com/eclipse/b3p2.ecore",
				
				// technology.dltk.core
				"http://git.eclipse.org/c/dltk/org.eclipse.dltk.core.gitcache_model.ecore",
				"http://git.eclipse.org/c/dltk/org.eclipse.dltk.core.gitlaunching.ecore",
				"http://git.eclipse.org/c/dltk/org.eclipse.dltk.core.gitvalidators.ecore",
				
				// technology.dltk.javascript
				"https://github.com/eclipse/dltk.javascriptdom.ecore",
				"https://github.com/eclipse/dltk.javascriptreferences.ecore",
				"http://git.eclipse.org/c/ogee/org.eclipse.ogee.gitOData.ecore",
				
				// technology.ogee
				
				// technology.stem
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitcommon.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitexperiment.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitlogger.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitmodifier.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitpredicate.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitsequencer.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitsolver.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gittrigger.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitedges.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitlabels.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitnodes.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gittypes.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitstandard.ecore"
				
				// tools.buckminster
				
		};
		modelHistoryFilter.addAll(Arrays.asList(modelHistoryFilterArray));
	}
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		DataSetMetadata dataset = new DataSetMetadata("C:\\evaluation\\", true);
		
		Set<String> validationNames = new HashSet<>();
		Map<HistoryMetadata, Set<String>> inconsistentHistories = new LinkedHashMap<>();
		int inconsistencyCount = 0;
		int inconsistentModels = 0;
		
		for (HistoryMetadata history : dataset.getHistories()) {
			if (!history.getProjectName().contains("modeling.mdt.papyrus")) {
				continue;
			}
			if (modelHistoryFilter.contains(getFilter(history))) {
				continue;
			}
			
			System.out.println("Project: " + history.getProjectName() + " Model: " + history.getLatestRemoteFilePath());
			
			// TODO: Create meta-data for resolved models!
			try {
				File modeHistoryFolder = new File(history.getDatafile().getParent() + File.separator
						+ history.getDatafile().getName().substring(0, history.getDatafile().getName().lastIndexOf(".")));
				boolean hasInconsistencies = false;
				
				for (File modelCommitFolder : modeHistoryFolder.listFiles()) {
					File modelVersion = new File(modelCommitFolder.getAbsoluteFile() 
							+ File.separator + new File(history.getLatestRemoteFilePath()).getName());
					URI uri = URI.createFileURI(modelVersion.getAbsolutePath());
					
					Date coevolutionDate = null;
					String versionName = modelCommitFolder.getName();
					
					if (versionName.contains("coevolution")) {
						coevolutionDate = EcoreHistorySettings.DATE_ISO8601_PATH_COMPATIBLE.parse(
								versionName.substring(versionName.lastIndexOf('_') + 1, versionName.length()));
					}
					
					// Filter co-evolutions that after the last version of the model:
					if ((coevolutionDate != null) && coevolutionDate.after(history.getNewestVersion().getParsedDate())) {
						continue;
					}
					
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
								System.out.println("TheFeatureOfContainsAnUnresolvedProxy: " + modelCommitFolder.getName());
							}
						}
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
		return history.getRepositoryURL() + history.getNewestVersion().getFileName();
	}

	@Override
	public void stop() {
	}
}
