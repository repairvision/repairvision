package org.sidiff.consistency.common.monitor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

public class LogMonitor implements IProgressMonitor {

	protected IProgressMonitor progressMonitor = new NullProgressMonitor();
	
	protected LogTable log = new LogTable();
	
	public LogMonitor() {
	}
	
	public LogMonitor(LogTable log) {
		this.log = log;
	}
	
	public LogMonitor(IProgressMonitor progressMonitor) {
		this.progressMonitor = progressMonitor;
	}
	
	public void setProgressMonitor(IProgressMonitor progressMonitor) {
		this.progressMonitor = progressMonitor;
	}
	
	public LogTable getLog() {
		return log;
	}
	
	public void dump() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return log.toString();
	}
	
	public void toCSV(String path) {
			
		// generate file name:
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
		String timeStamp = df.format(new Date(System.currentTimeMillis()));
		String fileName = timeStamp + ".csv";

		// create folder:
		path = path + File.separator + timeStamp;
		File folder = new File(path);

		if (!folder.exists()) {
			folder.mkdir();
		}

		// save log:
		log.toCSV(path + File.separator + fileName);
	}

	@Override
	public void beginTask(String name, int totalWork) {
		progressMonitor.beginTask(name, totalWork);
	}

	@Override
	public void done() {
		progressMonitor.done();
	}

	@Override
	public void internalWorked(double work) {
		progressMonitor.internalWorked(work);
	}

	@Override
	public boolean isCanceled() {
		return progressMonitor.isCanceled();
	}

	@Override
	public void setCanceled(boolean value) {
		progressMonitor.setCanceled(value);
	}

	@Override
	public void setTaskName(String name) {
		progressMonitor.setTaskName(name);
	}

	@Override
	public void subTask(String name) {
		progressMonitor.subTask(name);
	}

	@Override
	public void worked(int work) {
		progressMonitor.worked(work);
	}
}
