package org.sidiff.repair.history.evaluation.driver;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.sidiff.consistency.common.ui.util.InfoConsole;
import org.sidiff.repair.history.evaluation.driver.data.HistoryInfo;

public class PrintHistoryInfoDriver {

	public static void printHistoryInfo(HistoryInfo history) {
		StringBuffer print = new StringBuffer();
		print.append(history.getHistory().getName() + ":\n");
		
		Map<String, List<EAnnotation>> inconsistencyAnnotations = history.getInconsistencyAnnotations();
		
		for (String inconsistency : inconsistencyAnnotations.keySet()) {
			print.append("  " + inconsistency + ": " + inconsistencyAnnotations.get(inconsistency).size() + "\n");
		}
		
		InfoConsole.printInfo(print);
	}
}
  