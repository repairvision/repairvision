package org.sidiff.repair.ui.peo.evaluation;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.ui.app.IResultChangedListener;
import org.sidiff.repair.ui.peo.evaluation.history.HistoryRepairApplication;

public class HistoryEvaluation {

	public void startEvaluation(HistoryRepairApplication application, Resource modelA, Resource modelB) {
		System.out.println("#################### Evaluation Startet ####################");
		System.out.println("Model A: " + modelA);
		System.out.println("Model A: " + modelB);
		
		application.setModelA(modelA);
		application.setModelB(modelB);
		application.calculateRepairs();
		
		application.addResultChangedListener(new IResultChangedListener<PEORepairJob>() {
			
			@Override
			public void resultChanged(PEORepairJob repairJob) {
				System.out.println(repairJob);
//				System.out.println("Repairs Found: " repairJob.getRepairs());
				System.out.println("#################### Evaluation Finished ####################");
			}
		});
	}
	
}
