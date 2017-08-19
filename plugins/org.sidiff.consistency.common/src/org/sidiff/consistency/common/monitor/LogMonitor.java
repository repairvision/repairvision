package org.sidiff.consistency.common.monitor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.sidiff.consistency.common.java.StringPrinter;

public class LogMonitor implements IProgressMonitor {

	protected IProgressMonitor progressMonitor = new NullProgressMonitor();
	
	protected Map<String, LogTable> log = new LinkedHashMap<>();
	
	public LogMonitor() {
	}
	
	public LogMonitor(IProgressMonitor progressMonitor) {
		this.progressMonitor = progressMonitor;
	}
	
	public void setProgressMonitor(IProgressMonitor progressMonitor) {
		this.progressMonitor = progressMonitor;
	}
	
	public boolean createLog(String name) {
		return (log.putIfAbsent(name, new LogTable()) == null);
	}
	
	public boolean removeLog(String name) {
		return (log.remove(name) != null);
	}
	
	public boolean containsLog(String name) {
		return log.containsKey(name);
	}
	
	public LogTable getLog(String name) {
		if (!containsLog(name)) {
			createLog(name);
		}
		return log.get(name);
	}
	
	public Set<String> getLogs() {
		return Collections.unmodifiableSet(log.keySet());
	}
	
	public void dump() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		StringPrinter toString = new StringPrinter();
		
		for (Entry<String, LogTable> logTableEntry : log.entrySet()) {
			toString.println(StringPrinter.HORIZONTAL_SEPERATOR_01);
			toString.println(logTableEntry.getKey());
			toString.println(StringPrinter.HORIZONTAL_SEPERATOR_01);
			toString.print(logTableEntry.getValue());
		}
		
		return toString.toString();
	}
	
	public void toCSV(String path) {
		for (Entry<String, LogTable> logTableEntry : log.entrySet()) {
			
			// generate file name:
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			String timeStamp = df.format(new Date(System.currentTimeMillis()));
			String fileName = logTableEntry.getKey() + "_" + timeStamp + ".csv";
			
			// create folder:
			path = path + File.pathSeparator + timeStamp;
			File folder = new File(path);
			
			if (!folder.exists()) {
				folder.mkdir();
			}
			
			// save log:
			logTableEntry.getValue().toCSV(path + File.pathSeparator + fileName);
		}
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
