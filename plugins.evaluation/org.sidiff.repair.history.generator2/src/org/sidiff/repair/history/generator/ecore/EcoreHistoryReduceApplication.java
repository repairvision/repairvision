package org.sidiff.repair.history.generator.ecore;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.ValidationError;
import org.sidiff.historymodel.Version;
import org.sidiff.repair.history.evaluation.util.EvaluationUtil;
import org.sidiff.repair.history.generator.util.HistoryUtil;

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
			// Remove/Update predecessor/successor reference from inconsistencies.
			// Remove missing proxy errors.
			// Remove non resolved inconsistencies.
			Set<Version> removedVersions = new HashSet<>(history.getVersions());
			
			for (Version version : history.getVersions()) {
				
				for (ValidationError inconsistency : new ArrayList<>(version.getValidationErrors())) {
					
					// Remove non resolved inconsistencies:
					if (!inconsistency.isResolved()) {
						version.getValidationErrors().remove(inconsistency);
						continue;
					}
					
					// Remove missing proxy errors:
					if (inconsistency.getName().equals(EcoreHistorySettings.INCONSISTENCY_UNRESOLVED_PROXY)) {
						version.getValidationErrors().remove(inconsistency);
						continue;
					}
					
					// Filter to introduced/resolved inconsistencies:
					Version successorVersion = EvaluationUtil.getSuccessorRevision(version);
					
					// Preserve introduced/resolved step:
					if ((inconsistency.getIntroducedIn() == version) || (inconsistency.getResolvedIn() == successorVersion)) {
						if (inconsistency.getIntroducedIn() == version) {
							removedVersions.remove(EvaluationUtil.getPrecessorRevision(version));
							removedVersions.remove(version);
						}
						
						if (inconsistency.getResolvedIn() == successorVersion) {
							removedVersions.remove(version);
							removedVersions.remove(successorVersion);
						}
					} else {
						
						// Remove inconsistency:
						ValidationError predecessorInconsistency = inconsistency.getPrec();
						ValidationError successorInconsistency =  inconsistency.getSucc();
						
						if (predecessorInconsistency != null) {
							predecessorInconsistency.setSucc(successorInconsistency);
						}
						if (successorInconsistency != null) {
							successorInconsistency.setPrec(predecessorInconsistency);
						}
						
						version.getValidationErrors().remove(inconsistency);
					}
					
				}
			}
			
			history.getVersions().removeAll(removedVersions);
			
			if (!history.getVersions().isEmpty()) {
				
				// Store only included model resource sets:
				for (Version version : history.getVersions()) {
					File modelFile = new File(history.eResource().getURI().trimSegments(1).devicePath() + version.getModelURI());
					copy(modelFile.getParentFile(), toTargetFile(modelFile, true).getParentFile());
				}
				
				// Store history:
				Resource historyResource = history.eResource();
				historyResource.setURI(toTargetURI(historyResource.getURI(), true));
				
				Map<String, Object> options = new HashMap<String, Object>();
				options.put(XMIResource.OPTION_URI_HANDLER, new URIHandlerImpl() {
					public URI deresolve(URI uri) {
						return super.deresolve(toTargetURI(uri, false));
					}
				});
				
				historyResource.save(options);
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
	
	protected File toTargetFile(File source, boolean mkdirs) {
		File target =  new File(source.getAbsolutePath().replace(sourceDataSet.getAbsolutePath(), targetDataSet.getAbsolutePath()));
		
		if (mkdirs) {
			target.getParentFile().mkdirs();
		}
		
		return target;
	}
	
	protected URI toTargetURI(URI sourceURI, boolean mkdirs) {
		URI targetURI =  URI.createURI(sourceURI.toString().replace(sourceDataSetURI.toString(), targetDataSetURI.toString()));
		
		if (mkdirs) {
			new File(targetURI.devicePath()).getParentFile().mkdirs();
		}
		
		return targetURI;
	}
	
	public void copy(File sourceLocation, File targetLocation) throws IOException {
		if (sourceLocation.isDirectory()) {
			copyDirectory(sourceLocation, targetLocation);
		} else {
			copyFile(sourceLocation, targetLocation);
		}
	}

	private void copyDirectory(File source, File target) throws IOException {
		if (!target.exists()) {
			target.mkdir();
		}

		for (String f : source.list()) {
			copy(new File(source, f), new File(target, f));
		}
	}

	private void copyFile(File source, File target) throws IOException {
		try (InputStream in = new FileInputStream(source); OutputStream out = new FileOutputStream(target)) {
			byte[] buf = new byte[1024];
			int length;
			while ((length = in.read(buf)) > 0) {
				out.write(buf, 0, length);
			}
		}
	}
}
