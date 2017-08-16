package org.sidiff.repair.history.evaluation.driver;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.sidiff.consistency.common.ui.util.InfoConsole;
import org.sidiff.repair.history.evaluation.driver.data.HistoryInfo;
import org.sidiff.repair.historymodel.Version;

public class PrintHistoryInfoDriver {

	public static void printHistoryInfo(HistoryInfo history) {
		StringBuffer print = new StringBuffer();
		print.append(history.getHistory().getName() + ":\n");
		
		Map<String, Integer> inconsistencyCounter = new HashMap<>();
		
		for (Version version : history.getHistory().getVersions()) {
			version.getModel().getAllContents().forEachRemaining(element ->  {
				if (element instanceof EAnnotation) {
					EAnnotation annotation = (EAnnotation) element;
					
					if ((annotation.getSource() != null) && annotation.getSource().startsWith("VALIDATION")) {
						Integer counter = inconsistencyCounter.getOrDefault(annotation.getSource(), 0);
						++counter;
						inconsistencyCounter.put(annotation.getSource(), counter);
					}
				}
			});
		}
		
		for (String inconsistency : inconsistencyCounter.keySet()) {
			print.append("  " + inconsistency + ": " + inconsistencyCounter.get(inconsistency) + "\n");
		}
		
		InfoConsole.printInfo(print);
	}
}
