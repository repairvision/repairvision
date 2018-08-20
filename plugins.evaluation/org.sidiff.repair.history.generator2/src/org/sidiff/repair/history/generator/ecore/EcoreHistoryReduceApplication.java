package org.sidiff.repair.history.generator.ecore;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.ValidationError;
import org.sidiff.historymodel.Version;
import org.sidiff.repair.history.generator.util.HistoryUtil;
import org.sidiff.repair.history.evaluation.util.EvaluationUtil;

public class EcoreHistoryReduceApplication implements IApplication {

	private File sourceDataSet = new File("C:\\evaluation_matched\\");
	
	private String sourceDataSetURI = URI.createFileURI(sourceDataSet.getAbsolutePath()).toString();
	
	private File targetDataSet = new File("C:\\evaluation_reduced\\"); 
	
	private String targetDataSetURI = URI.createFileURI(targetDataSet.getAbsolutePath()).toString();
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		// Search all history databases:
		List<File> historyFiles = searchHistoryFiles(sourceDataSet);
		
		for (File historyFile : historyFiles) {
			History history = (History) HistoryUtil.load(URI.createFileURI(historyFile.getAbsolutePath())).getContents().get(0);
			
			// Reduce each history to those versions that:
			// (a) have introduced an inconsistency and its direct predecessor.
			// (b) have resolved an inconsistency and its direct predecessor.
			// Remove predecessor/successor reference from inconsistencies.
			// Remove missing proxy errors.
			Set<Version> removedVersions = new HashSet<>();
			
			for (Version version : history.getVersions()) {
				removedVersions.add(version);
				
				for (ValidationError inconsistency : new ArrayList<>(version.getValidationErrors())) {
					inconsistency.setPrec(null);
					inconsistency.setSucc(null);
					
					// Remove missing proxy errors:
					if (inconsistency.getName().equals(EcoreHistorySettings.INCONSISTENCY_UNRESOLVED_PROXY)) {
						version.getValidationErrors().remove(inconsistency);
						continue;
					}
					
					// Filter to introduced/resolved inconsistencies:
					if ((inconsistency.getIntroducedIn() == version) || (inconsistency.getResolvedIn() == version)) {
						removedVersions.remove(version);
						removedVersions.remove(EvaluationUtil.getPrecessorRevision(version));
					} else {
						version.getValidationErrors().remove(inconsistency);
					}
				}
			}
			
			history.getVersions().removeAll(removedVersions);
			
			if (!history.getVersions().isEmpty()) {
				
				// Store only included model resource sets:
				
				// Store history:
				
			}
		}
		
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
	}
	
	protected List<File> searchHistoryFiles(File root) {
		List<File> files = new ArrayList<>();
		
		FileFilter filter = new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				if (!pathname.isDirectory()) {
					if (pathname.getName().toLowerCase().endsWith(".history")) {
						return true;
					}
				}
				return false;
			}
		};
		
		files.addAll(Arrays.asList(root.listFiles(filter)));
		Collections.sort(files);
		
		// Scan for sub-directories recursively:
		for (File file : root.listFiles()) {
			if (file.isDirectory()) {
				files.addAll(searchHistoryFiles(file));
			}
		}
		
		return files;
	}
	
	protected URI toTargetURI(URI sourceURI, boolean mkdirs) {
		URI targetURI =  URI.createURI(sourceURI.toString().replace(sourceDataSetURI.toString(), targetDataSetURI.toString()));
		
		if (mkdirs) {
			new File(targetURI.devicePath()).getParentFile().mkdirs();
		}
		
		return targetURI;
	}
}
