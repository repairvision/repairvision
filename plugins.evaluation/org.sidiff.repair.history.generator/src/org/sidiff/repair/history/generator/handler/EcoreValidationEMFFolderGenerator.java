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
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.configuration.IConfigurable;
import org.sidiff.consistency.common.settings.SettingsUtil;
import org.sidiff.difference.technical.ITechnicalDifferenceBuilder;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.difference.technical.api.util.TechnicalDifferenceUtils;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matching.api.util.MatchingUtils;
import org.sidiff.repair.history.generator.HistoryModelGenerator;
import org.sidiff.repair.history.generator.repository.BasicHistoryRepository;
import org.sidiff.repair.history.generator.repository.IHistoryRepository;
import org.sidiff.repair.history.generator.settings.EvaluationSettings;
import org.sidiff.repair.history.generator.validation.EMFValidator;

public class EcoreValidationEMFFolderGenerator extends AbstractHandler implements IHandler {

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
						
						IMatcher matcher = MatchingUtils.getMatcherByKey("org.sidiff.matcher.signature.name.NamedElementMatcher");
						ITechnicalDifferenceBuilder builder = TechnicalDifferenceUtils.getTechnicalDifferenceBuilder("org.sidiff.ecore.difference.technical.TechnicalDifferenceBuilderEcoreNoAnnotations");
						
						IConfigurable configurable = (IConfigurable) matcher;
						configurable.getConfigurationOptions();
						configurable.setConfigurationOption("Use Qualified Names", true);
						configurable.setConfigurationOption("Allow Ambiguous Names", true);
						
						differenceSettings.setMatcher(matcher);
						differenceSettings.setTechBuilder(builder);
						
						String inputPath = folder.getLocation().toOSString();
						String outputProject = HistoryModelGenerator.getProjectName(HistoryModelGenerator.PROJECT_NAME_PREFIX, inputPath);
						URI versionFolderURI = URI.createPlatformResourceURI(outputProject + "/" + HistoryModelGenerator.VERSIONS_FOLDER, true);
						
						IHistoryRepository repository = new BasicHistoryRepository(versionFolderURI);
						
						EvaluationSettings evaluationSettings = new EvaluationSettings(folder.getName(), new String[]{"ecore"}, repository, differenceSettings, new EMFValidator());
						new HistoryModelGenerator().generateHistoryProject(inputPath, outputProject, evaluationSettings);
					}
				}				
				return Status.OK_STATUS;
			}
		};
		
		job.schedule();
		return null;
	}

}
