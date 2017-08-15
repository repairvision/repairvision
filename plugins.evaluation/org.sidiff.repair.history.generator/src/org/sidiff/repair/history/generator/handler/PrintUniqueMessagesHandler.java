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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.sidiff.repair.historymodel.Version;



public class PrintUniqueMessagesHandler extends AbstractHandler {
	
	private static MessageConsoleStream out = null;
	
	private static void initMessageConsoleStream(){
		MessageConsole messageConsole = null;
		String consoleName = "HISTORY REPORT";
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
		out = messageConsole.newMessageStream();
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Job job = new Job("Print Unique Validation Error Messages"){

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				initMessageConsoleStream();
				ISelection selection = HandlerUtil.getCurrentSelection(event);
				
				if (selection instanceof IStructuredSelection){
					IStructuredSelection structuredSelection = (IStructuredSelection) selection;
					Map<String,  List<ValidationError>> messages = new HashMap<String, List<ValidationError>>();
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
											printHistoryInfo(history);
											for(ValidationError validationError : history.getUniqueValidationErrors()){
												if(!messages.containsKey(validationError.getName())){
													messages.put(validationError.getName(), new ArrayList<ValidationError>());
												}
												messages.get(validationError.getName()).add(validationError);
													
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
					
					List<Entry<String, List<ValidationError>>> sortedList = new LinkedList<Entry<String,List<ValidationError>>>(messages.entrySet());
					// Defined Custom Comparator here
					Collections.sort(sortedList, new Comparator<Entry<String, List<ValidationError>>>() {

						@Override
						public int compare(Entry<String, List<ValidationError>> o1, Entry<String, List<ValidationError>> o2) {
							return o1.getValue().size()- o2.getValue().size();
						}
					});
					
					HashMap<String, List<ValidationError>> sortedHashMap = new LinkedHashMap<String, List<ValidationError>>();
					for (Iterator<Entry<String, List<ValidationError>>> iterator = sortedList.iterator(); iterator.hasNext();) {
						Entry<String, List<ValidationError>> entry = iterator.next();
						sortedHashMap.put(entry.getKey(), entry.getValue());
					}
				
					Collections.reverse(sortedList);
					out.println("History - Overview");
					out.println("Validation Error; Count; Location; Resolved; ");
					for(Entry<String,List<ValidationError>> entry : sortedList){
						out.print(entry.getKey());
						out.print(";");
						out.print(entry.getValue().size() + ";");
						Set<String> projects = new HashSet<String>();
						for(ValidationError error : entry.getValue()){
							projects.add(((History)error.eContainer().eContainer()).getName());
						}
						ArrayList<String> projectsList = new ArrayList<String>(projects);
						for(int i=0; i<projectsList.size(); i++){
							out.print(projectsList.get(i));
							if(i<projectsList.size()-1){
								out.print(", ");
							}
						}
						
						int introducedAndResolved = 0;
						for(ValidationError error : entry.getValue()){
							if(error.isIntroduced() && error.isResolved()){
								introducedAndResolved++;
							}
						}
						out.print(";" + introducedAndResolved + "\n");
					}
					out.print("\n\n");
				}
				return Status.OK_STATUS;
			}
		};
		
		job.schedule();
		return null;
	}
	
	private void printHistoryInfo(History history){
		String historyName = history.getName();
		out.println(historyName);
		String header = "Validation Error; Message; Elements; Introduced in; Resolved in; Consistency Rule; Repair Rules; fixable; fixed as observed";
		out.println(header);
		List<ValidationError> introducedResolvedValidationErrors = new ArrayList<ValidationError>();
		for(Version version : history.getVersions()){
			if(!version.getValidationErrors().isEmpty()){
				for(ValidationError validationError : version.getValidationErrors()){
					if(validationError.getPrec() == null && validationError.isIntroduced() && validationError.isResolved()){
						introducedResolvedValidationErrors.add(validationError);
					}
				}
			}
		}
		for(ValidationError validationError : introducedResolvedValidationErrors){
			String row = validationError.getName() + "; " + validationError.getMessage() + "; ";
			for(int i = 0; i < validationError.getInvalidElement().size(); i++){
				EObject invalidElement = validationError.getInvalidElement().get(i);
				String signature = calculateSignature(invalidElement);
				row += signature;
				if(i<validationError.getInvalidElement().size()-1){
					row += ", ";
				}else{
					row += "; ";
				}
			}
		
			row	+= validationError.getIntroducedIn().getName() + "; " + validationError.getResolvedIn().getName() + "-; -; ;";
			out.println(row);
		}
		out.println("\n\n");
	}
	
	private static String calculateSignature(EObject eObject) {
		
		String signature = "";
		
		if(eObject.eContainer() != null){
			signature = calculateSignature(eObject.eContainer()) + ".";
		}
		
		EStructuralFeature nameFeature = eObject.eClass().getEStructuralFeature("name");
		
		boolean hasName = false; 
		
		if (nameFeature != null) {
			Object nameValue = eObject.eGet(nameFeature);
			
			if (nameValue != null && nameValue instanceof String && !((String)nameValue).isEmpty()) {
				signature += (String) nameValue;
				hasName = true;
			}
		}
		
		if(!hasName){
			// Remove Object ID if present:
			signature += eObject.toString().replaceFirst("@.*?\\s", "").replaceAll("\\(.*\\)", "").replaceAll("\\s", "");
		}
		return signature;
		
	}
}
