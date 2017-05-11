package org.sidiff.repair.ui.peo.evaluation.statistic;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.ui.peo.evaluation.data.EvaluationData;
import org.sidiff.repair.ui.peo.evaluation.util.EvaluationUtil;

public class GetValidationErrors implements IApplication {

	private String KEY = "Inconsistencies";
	
	private EvaluationData data = new EvaluationData() {

		private static final long serialVersionUID = 1L;

		public String toStringAdapter(Object object) {
			
			if (object instanceof ValidationError) {
				ValidationError inconsistency = (ValidationError) object; 
				String intorduced = (inconsistency.getIntroducedIn() != null) 
						? inconsistency.getIntroducedIn().getName() : "#NULL";
				String resloved = (inconsistency.getResolvedIn() != null) 
							? inconsistency.getResolvedIn().getName() : "#NULL";
				
				URI uri = URI.createURI(inconsistency.getIntroducedIn().getModelURI());
							
				return uri.segment(uri.segmentCount() - 3)
						+ ": Intorduced:" + intorduced + " || Resolved: " + resloved;
			}
			
			return super.toStringAdapter(object);
		}
	};
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("#################### Evaluation Startet ####################");
		
		for (String file : EvaluationSetup.FILES) {
			getValidationErrors(file);
		}
		data.dump();
		
		System.out.println("#################### Evaluation Finished ####################");
		return IApplication.EXIT_OK;
	}
	
	private void getValidationErrors(String file) {
		ResourceSet rss = new ResourceSetImpl();
		rss.getURIConverter().getURIMap().put(URI.createPlatformResourceURI("", true), URI.createFileURI(EvaluationSetup.FOLDER + "/"));
		
		Resource historyRes = rss.getResource(URI.createFileURI(EvaluationSetup.FOLDER + "/" + file), true);
		History history = (History) historyRes.getContents().get(0);
		
//		for (Version version : history.getVersions()) {
//			for (ValidationError inconsistency : version.getValidationErrors()) {
//				data.appendToRow(KEY, inconsistency.getName(), inconsistency);
//			}
//		}
		
		for (ValidationError inconsistency : EvaluationUtil.getValidations(history)) {
			data.appendToRow(KEY, EvaluationUtil.getValidationID(inconsistency), inconsistency);
		}
	}

	@Override
	public void stop() {
	}
}
