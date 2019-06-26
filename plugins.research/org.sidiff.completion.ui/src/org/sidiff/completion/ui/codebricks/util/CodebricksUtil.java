package org.sidiff.completion.ui.codebricks.util;

import java.util.List;
import java.util.function.Consumer;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.CodebricksPackage;

public class CodebricksUtil {

	public static Adapter onAlternativeChosen(Codebricks codebricks, Consumer<Codebrick> onAlternativeChosen) {
		EContentAdapter adapter = new EContentAdapter() {
            public void notifyChanged(Notification notification) {
                if (notification.getFeature() == CodebricksPackage.eINSTANCE.getTemplatePlaceholderBrick_Choice()) {
                	if (codebricks.isChosen()) {
                		List<Codebrick> choice = codebricks.getChoice();
                		
                		if (choice.size() == 1) {
                			onAlternativeChosen.accept(choice.get(0));
                		}
                	}
                }
            }
        };
        codebricks.eAdapters().add(adapter);
        return adapter;
	}
}
