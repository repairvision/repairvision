package org.sidiff.repair.history.generator.ecore;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.historymodel.ValidationError;
import org.sidiff.repair.history.generator.metadata.DataSetMetadata;
import org.sidiff.repair.history.generator.metadata.HistoryMetadata;
import org.sidiff.repair.history.generator.util.HistoryUtil;
import org.sidiff.repair.history.generator.validation.EMFValidator;

public class EcoreHistoryValidationApplication implements IApplication  {

	// Histories with no inconsistencies:
	private Set<String> modelHistoryFilter = new HashSet<>();
	{
		String[] modelHistoryFilterArray = {
				
				// birt
				"https://github.com/eclipse/birtorg.eclipse.birt.chart.model.attribute.ecore",
				"https://github.com/eclipse/birtorg.eclipse.birt.chart.model.component.ecore",
				"https://github.com/eclipse/birtorg.eclipse.birt.chart.model.data.ecore",
				"https://github.com/eclipse/birtorg.eclipse.birt.chart.model.ecore",
				"https://github.com/eclipse/birtorg.eclipse.birt.chart.model.layout.ecore",
				"https://github.com/eclipse/birtmodel.ecore",
				
				// datatools
				"http://git.eclipse.org/c/datatools/org.eclipse.datatools.gitorg.eclipse.datatools.connectivity.oda.design.ecore",
				
				// eclipse.e4
				"http://git.eclipse.org/c/eatop/org.eclipse.eatop.gitgeastadl.ecore",
				
				// modeling.eatop
				
				// technology.stem
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitcommon.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitexperiment.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitlogger.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitmodifier.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitpredicate.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitsequencer.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitsolver.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gittrigger.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitedges.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitlabels.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitnodes.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gittypes.ecore",
				"http://git.eclipse.org/c/stem/org.eclipse.stem.gitstandard.ecore"
		};
		modelHistoryFilter.addAll(Arrays.asList(modelHistoryFilterArray));
	}
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		DataSetMetadata dataset = new DataSetMetadata("C:\\evaluation\\", true);
		
		Set<String> validationNames = new HashSet<>();
		Map<HistoryMetadata, Set<String>> inconsistentHistories = new LinkedHashMap<>();
		int inconsistencyCount = 0;
		int inconsistentModels = 0;
		
		for (HistoryMetadata history : dataset.getHistories()) {
			if (!history.getProjectName().contains("modeling.eatop")) {
				continue;
			}
			if (modelHistoryFilter.contains(getFilter(history))) {
				continue;
			}
			
			System.out.println("Project: " + history.getProjectName() + " Model: " + history.getLatestRemoteFilePath());
			
			// TODO: Create meta-data for resolved models!
			try {
				File modeHistoryFolder = new File(history.getDatafile().getParent() + File.separator
						+ history.getDatafile().getName().substring(0, history.getDatafile().getName().lastIndexOf(".")));
				boolean hasInconsistencies = false;
				
				for (File modelCommitFolder : modeHistoryFolder.listFiles()) {
					File modelVersion = new File(modelCommitFolder.getAbsoluteFile() 
							+ File.separator + new File(history.getLatestRemoteFilePath()).getName());
					URI uri = URI.createFileURI(modelVersion.getAbsolutePath());
					
					Date coevolutionDate = null;
					String versionName = modelCommitFolder.getName();
					
					if (versionName.contains("coevolution")) {
						coevolutionDate = EcoreHistorySettings.DATE_ISO8601_PATH_COMPATIBLE.parse(
								versionName.substring(versionName.lastIndexOf('_') + 1, versionName.length()));
					}
					
					// Filter co-evolutions that after the last version of the model:
//					if ((coevolutionDate == null) || !coevolutionDate.after(history.getNewestVersion().getParsedDate())) {
						ResourceSet resourceSet = new ResourceSetImpl();
						Resource model = HistoryUtil.load(resourceSet, uri);
						
						EMFValidator validator = new EMFValidator();
						Collection<ValidationError> inconsistencies = validator.validate(model);
						
						// Analyze inconsistencies:
						if (!inconsistencies.isEmpty()) {
							hasInconsistencies = true;
							
							inconsistencyCount += inconsistencies.size();
							++inconsistentModels;
							
							Set<String> modelValidationNames = inconsistencies.stream().map(ValidationError::getName).collect(Collectors.toSet());
							validationNames.addAll(modelValidationNames);
							
							if (inconsistentHistories.containsKey(history)) {
								inconsistentHistories.get(history).addAll(modelValidationNames);
							} else  {
								inconsistentHistories.put(history, modelValidationNames);
							}
							
							for (ValidationError inconsistency : inconsistencies) {
								if (inconsistency.getName().equals("TheFeatureOfContainsAnUnresolvedProxy")) {
									System.out.println("TheFeatureOfContainsAnUnresolvedProxy: " + modelCommitFolder.getName());
								}
							}
//						}
					}
				}
				
				if (!hasInconsistencies) {
					System.out.println("\"" + getFilter(history) + "\",");
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Inconsistencies found: " + inconsistencyCount);
		System.out.println("Inconsistent models: " + inconsistentModels);
		System.out.println();
		System.out.println("Inconsistencies per Project:");
		
		for (HistoryMetadata history : inconsistentHistories.keySet()) {
			System.out.println();
			System.out.println("Project: " + history.getProjectName() + " Model: " + history.getLatestRemoteFilePath());
			
			for (String inconsistency : inconsistentHistories.get(history)) {
				System.out.println(inconsistency);
			}
		}
		
		
		return IApplication.EXIT_OK;
	}
	
	protected String getFilter(HistoryMetadata history) {
		return history.getRepositoryURL() + history.getNewestVersion().getFileName();
	}

	@Override
	public void stop() {
	}
}
