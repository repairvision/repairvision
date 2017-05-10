package org.sidiff.repair.ui.peo.evaluation.statistic;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.repair.ui.peo.evaluation.data.EvaluationData;

public class GetValidationErrors implements IApplication {

	private String KEY = "Inconsistencies";
	
	private EvaluationData data = new EvaluationData();
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		for (String file : EvaluationSetup.FILES) {
			getValidationErrors(file);
		}
		data.dump();
		
		return IApplication.EXIT_OK;
	}
	
	private void getValidationErrors(String file) {
		ResourceSet rss = new ResourceSetImpl();
		Resource historyRes = rss.getResource(URI.createFileURI(EvaluationSetup.FOLDER + "/" + file), true);
		History history = (History) historyRes.getContents().get(0);
		
		for (Version version : history.getVersions()) {
			for (ValidationError inconsistency : version.getValidationErrors()) {
				data.appendSet(KEY, inconsistency.getName());
			}
		}
	}

	@Override
	public void stop() {
	}
}
