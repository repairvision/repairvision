package org.sidiff.repair.history.generator.repository.html;

import java.util.ArrayList;
import java.util.List;

public class ModelingDataSet {
	
	private List<ModelingProject> projects = new ArrayList<>();
	
	public static void main(String[] args) {
		String localPath = "C:\\evaluation\\";
		ModelingDataSet dataSet = new ModelingDataSet();
		
		// https://projects.eclipse.org/projects/modeling.emft.emf-store/developer
		dataSet.addProject(localPath, "modeling.emft.emf-store", "http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git",
				"/bundles/org.eclipse.emf.emfstore.client/model/client.ecore",
				"/bundles/org.eclipse.emf.emfstore.common.model/model/common.ecore",
				"/bundles/org.eclipse.emf.emfstore.fuzzy.emf/model/config.ecore",
				"/bundles/org.eclipse.emf.emfstore.server.model/model/server.ecore");
		
		// https://projects.eclipse.org/projects/modeling.mdt.ocl/developer
		dataSet.addProject(localPath, "modeling.mdt.ocl", "http://git.eclipse.org/c/ocl/org.eclipse.ocl.git",
				"/plugins/org.eclipse.ocl.ecore/model",
				"/plugins/org.eclipse.ocl.pivot.uml/model/OCLforUML.ecore",
				"/plugins/org.eclipse.ocl.pivot/model/Lookup.ecore",
				"/plugins/org.eclipse.ocl.pivot/model/Pivot.ecore",
				"/plugins/org.eclipse.ocl.pivot/model/Values.ecore",
				"/plugins/org.eclipse.ocl.uml/model/OCLUML.ecore",
				"/plugins/org.eclipse.ocl.ecore/model/OCLEcore.ecore",
				"/plugins/org.eclipse.ocl.ecore/model/oclstdlib.ecore",
				"/plugins/org.eclipse.ocl/model/OCL.ecore",
				"/plugins/org.eclipse.ocl/model/OCLCST.ecore");
		
		// https://projects.eclipse.org/projects/modeling.mmt.qvt-oml/developer
		dataSet.addProject(localPath, "modeling.mmt.qvt-oml", "http://git.eclipse.org/c/mmt/org.eclipse.qvto.git",
				"/plugins/org.eclipse.m2m.qvt.oml.ecore.imperativeocl/model/ImperativeOCL.ecore",
				"/plugins/org.eclipse.m2m.qvt.oml.emf.util/model/MModelURIMap.ecore",
				"/plugins/org.eclipse.m2m.qvt.oml/model/QVTOperational.ecore",
				"/plugins/org.eclipse.m2m.qvt.oml/model/trace.ecore");
		
		// https://projects.eclipse.org/projects/technology.ogee/developer
		dataSet.addProject(localPath, "technology.ogee", "http://git.eclipse.org/c/ogee/org.eclipse.ogee.git",
				"/org.eclipse.ogee.model/model/OData.ecore");
		
		// https://projects.eclipse.org/projects/modeling.m2t.acceleo/developer
		dataSet.addProject(localPath, "modeling.m2t.acceleo", "http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.git",
				"/plugins/org.eclipse.acceleo.model/model/mtl.ecore",
				"/plugins/org.eclipse.acceleo.model/model/mtlnonstdlib.ecore",
				"/plugins/org.eclipse.acceleo.model/model/mtlstdlib.ecore",
				"/plugins/org.eclipse.acceleo.profiler/model/profiler.ecore",
				"/plugins/org.eclipse.acceleo.ui.interpreter.completeocl/model/evaluation_result.ecore");
		
		// https://projects.eclipse.org/projects/modeling.emft.emf-client/developer
		dataSet.addProject(localPath, "modeling.emft.emf-client", "http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git",
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
		
		
		dataSet.mine();
	}
	
	public void mine() {
		for (ModelingProject modelingProject : projects) {
			new Thread(() -> {
				modelingProject.mine();
			}).start();
		}
	}
	
	public void addProject(String localPath, String name, String repository, String... files) {
		projects.add(new ModelingProject(localPath, name, repository, files));
	}
	
	public List<ModelingProject> getProjects() {
		return projects;
	}
	
	public void setProjects(List<ModelingProject> projects) {
		this.projects = projects;
	}
}
