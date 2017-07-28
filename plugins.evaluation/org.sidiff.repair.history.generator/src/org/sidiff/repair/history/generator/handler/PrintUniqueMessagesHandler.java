package org.sidiff.repair.history.generator.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.Map.Entry;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;


public class PrintUniqueMessagesHandler extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Job job = new Job("Print Unique Validation Error Messages"){

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				ISelection selection = HandlerUtil.getCurrentSelection(event);
				
				if (selection instanceof IStructuredSelection){
					IStructuredSelection structuredSelection = (IStructuredSelection) selection;
					Map<String, Integer> messages = new HashMap<String, Integer>();
					for (Iterator<Object> iterator = structuredSelection.iterator(); iterator.hasNext();) {
						Object obj = iterator.next();
						if(obj instanceof IProject){
							IProject project = (IProject)obj;
							try {
								for(IResource resource : project.members()){
									if(resource instanceof IFile){
										IFile file = (IFile)resource;
										if(file.getFileExtension().equals("history")){
											History history = (History) EMFStorage.eLoad(EMFStorage.pathToUri(file.getLocation().toOSString()));
											for(ValidationError validationError : history.getUniqueValidationErrors()){
												if(!messages.containsKey(validationError.getName())){
													messages.put(validationError.getName(), 0);
												}
												if(validationError.getPrec() == null )
													messages.put(validationError.getName(), messages.get(validationError.getName()) + 1);
											}
										}
									}
								}
							} catch (CoreException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
					
					List<Entry<String, Integer>> sortedList = new LinkedList<Entry<String,Integer>>(messages.entrySet());
					// Defined Custom Comparator here
					Collections.sort(sortedList, new Comparator<Entry<String, Integer>>() {
						


						@Override
						public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
							return (o1.getValue())
									.compareTo(o2.getValue());
						}
					});
					
					HashMap<String, Integer> sortedHashMap = new LinkedHashMap<String, Integer>();
					for (Iterator<Entry<String, Integer>> iterator = sortedList.iterator(); iterator.hasNext();) {
						Entry<String, Integer> entry = iterator.next();
						sortedHashMap.put(entry.getKey(), entry.getValue());
					}

				  
					
					String consoleName = "HISTORY REPORT";
					MessageConsole messageConsole = null;
					
					ConsolePlugin plugin = ConsolePlugin.getDefault();
					IConsoleManager conMan = plugin.getConsoleManager();
					IConsole[] existing = conMan.getConsoles();
					for (int i = 0; i < existing.length; i++)
						if (consoleName.equals(existing[i].getName()))
							messageConsole = (MessageConsole) existing[i];
					// no console found, so create a new on
					if(messageConsole == null){
						messageConsole= new MessageConsole(consoleName, null);
						conMan.addConsoles(new IConsole[] { messageConsole });
					}
					
				
					MessageConsoleStream out = messageConsole.newMessageStream();
					Collections.reverse(sortedList);
					for(Entry<String,Integer> entry : sortedList){
						out.println(entry.getKey() + " (" + entry.getValue() + ")");
					}
				}
				return Status.OK_STATUS;
			}
		};
		
		job.schedule();
		return null;
	}
	
}
