package org.sidiff.repair.history.generator.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.consistency.common.settings.SettingsUtil;
import org.sidiff.correspondences.matchingmodel.MatchingModelCorrespondences;
import org.sidiff.difference.technical.ITechnicalDifferenceBuilder;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.difference.technical.api.util.TechnicalDifferenceUtils;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matching.api.util.MatchingUtils;
import org.sidiff.repair.history.generator.HistoryModelGenerator;
import org.sidiff.repair.history.generator.settings.EvaluationSettings;
import org.sidiff.repair.history.generator.validation.FOLValidator;

public class GenerateHistoryModelUMLandFOLHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		Job job = new Job("Generate History Model"){

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				ISelection selection = HandlerUtil.getCurrentSelection(event);
				
				if (selection instanceof IStructuredSelection){
					IStructuredSelection structuredSelection = (IStructuredSelection) selection;
					if(structuredSelection.getFirstElement() instanceof IFolder){
						IFolder folder = (IFolder) structuredSelection.getFirstElement();
						
						DifferenceSettings differenceSettings = SettingsUtil.getDefaultDifferenceSettings();
						
						IMatcher matcher = MatchingUtils.getMatcherByKey("org.sidiff.matcher.adapter.emfcompare.EMFCompareMatcherAdapter");
						ITechnicalDifferenceBuilder builder = TechnicalDifferenceUtils.getTechnicalDifferenceBuilder("org.sidiff.uml2v4.difference.technical.TechnicalDifferenceBuilderUML");
						
						differenceSettings.setCorrespondencesService(new MatchingModelCorrespondences());
						differenceSettings.setMatcher(matcher);
						differenceSettings.setTechBuilder(builder);
						differenceSettings.setMergeImports(false);
						
						EvaluationSettings evaluationSettings = new EvaluationSettings(folder.getName(), new String[]{"uml"}, differenceSettings, new FOLValidator());
						new HistoryModelGenerator().generateHistoryProject(folder.getLocation().toOSString(), evaluationSettings);
					}
				}				
				return Status.OK_STATUS;
			}
		};
		
		job.schedule();
		return null;
	}

}
