package org.sidiff.completion.ui.codebricks.util;

import java.util.List;
import java.util.function.Consumer;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick;

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
	
	public static Adapter onTemplatePlaceholderSelected(Codebricks codebricks, Consumer<TemplatePlaceholderBrick> onPlaceholderChanged) {
		EContentAdapter adapter = new EContentAdapter() {
            public void notifyChanged(Notification notification) {
            	if (notification.getNotifier() instanceof TemplatePlaceholderBrick) {
            		TemplatePlaceholderBrick placeholder = (TemplatePlaceholderBrick) notification.getNotifier();
            		
            		if (notification.getFeature() == CodebricksPackage.eINSTANCE.getTemplatePlaceholderBrick_Choice()) {
            			if (notification.getOldValue() != notification.getNewValue()) {
            				onPlaceholderChanged.accept(placeholder);
            			}
            		}
            	}
            }
        };
        codebricks.eAdapters().add(adapter);
        return adapter;
	}
	
	public static Adapter onObjectPlaceholderSelected(Codebricks codebricks, Consumer<ObjectPlaceholderBrick> onPlaceholderChanged) {
		EContentAdapter adapter = new EContentAdapter() {
            public void notifyChanged(Notification notification) {
            	if (notification.getNotifier() instanceof ObjectPlaceholderBrick) {
            		if (notification.getFeature() == CodebricksPackage.eINSTANCE.getObjectPlaceholderBrick_Element()) {
            			if (notification.getOldValue() != notification.getNewValue()) {
            				onPlaceholderChanged.accept((ObjectPlaceholderBrick) notification.getNotifier());
            			}
            		}
            	}
            }
        };
        codebricks.eAdapters().add(adapter);
        return adapter;
	}
	
	public static Adapter onValuePlaceholderSelected(Codebricks codebricks, Consumer<ValuePlaceholderBrick> onPlaceholderChanged) {
		EContentAdapter adapter = new EContentAdapter() {
            public void notifyChanged(Notification notification) {
            	if (notification.getNotifier() instanceof ValuePlaceholderBrick) {
            		if (notification.getFeature() == CodebricksPackage.eINSTANCE.getValuePlaceholderBrick_InstanceValue()) {
            			if (notification.getOldValue() != notification.getNewValue()) {
            				onPlaceholderChanged.accept((ValuePlaceholderBrick) notification.getNotifier());
            			}
            		}
            	}
            }
        };
        codebricks.eAdapters().add(adapter);
        return adapter;
	}
}
