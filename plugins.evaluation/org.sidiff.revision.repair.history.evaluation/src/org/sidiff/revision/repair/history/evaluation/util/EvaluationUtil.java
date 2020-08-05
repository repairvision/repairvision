package org.sidiff.revision.repair.history.evaluation.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.EObjectList;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.Version;
import org.sidiff.revision.common.emf.EMFStorage;
import org.sidiff.revision.common.logging.table.LogTable;
import org.sidiff.revision.repair.history.evaluation.driver.data.HistoryInfo;

public class EvaluationUtil {
	
	private static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
	
	public static void saveLog(HistoryInfo history, LogTable log, String timestamp, String name) {
		String projectPath = EMFStorage.uriToPath(history.getHistory().eResource().getURI().trimSegments(1));
		
		// generate file name:
		String fileName = history.getHistory().getName() + "_" + timestamp + "_" + name + ".csv";

		// create folder:
		projectPath = projectPath + File.separator + timestamp;
		File folder = new File(projectPath);

		if (!folder.exists()) {
			folder.mkdir();
		}

		// save CSV:
		log.toCSV(folder.getAbsolutePath() + File.separator + fileName);
	}
	
	public static void updateProject(HistoryInfo history) {
		try {
			String projectName = history.getHistory().eResource().getURI().trimSegments(1).lastSegment();
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject(projectName);
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Date getTimestamp(String timeStamp) {
		try {
			return TIME_FORMAT.parse(timeStamp);
		} catch (ParseException e) {
		}
		return null;
	}
	
	public static String getTimestamp() {
		return TIME_FORMAT.format(new Date(System.currentTimeMillis()));
	}
	
	public static EObjectList toEObjectList(List<? extends EObject> list, String label) {
		EObjectList eObjectList = GraphpatternFactory.eINSTANCE.createEObjectList();
		eObjectList.setLabel(label);
		eObjectList.getContent().addAll(list);
		return eObjectList;
	}
	
	public static Version createEmptyModelVersion(History history) {
		Version initialVersion = history.getVersions().get(0);
		
//		Resource emptyModel = Revision.createEmptyModel(initialVersion.getModel());
		
		Version emptyModelVersion = HistoryModelFactory.eINSTANCE.createVersion();
		emptyModelVersion.setName("The Empty Model");
//		emptyModelVersion.setModelURI(emptyModel.getURI().toString()); // FIXME
		emptyModelVersion.setModelURI(initialVersion.getModelURI());
		emptyModelVersion.setRepositoryVersion("-1");
		emptyModelVersion.setStatus(initialVersion.getStatus());
//		emptyModelVersion.setModel(emptyModel);
		
		history.getVersions().add(0, emptyModelVersion);
		return emptyModelVersion;
	}

}
