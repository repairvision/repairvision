package org.sidiff.matcher;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.candidates.CandidatesUtil;
import org.sidiff.candidates.ICandidates;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.correspondences.CorrespondencesUtil;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.matcher.mode.MatcherMode;

/**
 * this is the abstract base matcher for the already known matcher.
 *
 */
public abstract class BaseMatcher implements IMatcher {

	/**
	 * 
	 */
	private ICorrespondences correspondencesService;
	
	/**
	 * 
	 */
	private ICandidates candidatesService;

	/**
	 * 
	 */
	private Collection<Resource> models;
	
	private MatcherMode mode = MatcherMode.SINGLE;

	/**
	 * RESOURCE or RESOURCE_SET
	 */
	protected Scope scope;	
	
	@Override
	public void startMatching(Collection<Resource> models, Scope scope){
		init(models, scope);
		LogUtil.log(LogEvent.NOTICE, "------------------------------------------------------------");
		LogUtil.log(LogEvent.NOTICE, "--------------------------MATCHING--------------------------");
		LogUtil.log(LogEvent.NOTICE, "------------------------------------------------------------");
		LogUtil.log(LogEvent.NOTICE, "---Matcher---");
		LogUtil.log(LogEvent.NOTICE, this.getName());
		int modelnumber = 0;
		for(Resource model : models){
			modelnumber++;
			LogUtil.log(LogEvent.NOTICE, "# M" + modelnumber + " #");  
			LogUtil.log(LogEvent.NOTICE, "URI: " + model.getURI());  
			LogUtil.log(LogEvent.NOTICE, "Corresponding | Unmatched: " +
			this.getCorrespondencesService().getElementsWithCorrespondences(model).size() + " | " 
					+  this.getCorrespondencesService().getElementsWithoutCorrespondences(model).size());
		}
		LogUtil.log(LogEvent.NOTICE, "---Models---");

		match();
		LogUtil.log(LogEvent.NOTICE, "---Matching Result---");

		modelnumber = 0;
		for(Resource model : models){
			modelnumber++;
			LogUtil.log(LogEvent.NOTICE, "# M" + modelnumber + " #");  
			LogUtil.log(LogEvent.NOTICE, "URI: " + model.getURI());  
			LogUtil.log(LogEvent.NOTICE, "Corresponding | Unmatched: " +
			this.getCorrespondencesService().getElementsWithCorrespondences(model).size() + " | " 
					+  this.getCorrespondencesService().getElementsWithoutCorrespondences(model).size());
		}
	}
	
	/**
	 * 
	 */
	protected abstract void match();

	/**
	 * 
	 * @param models
	 * @param scope
	 */
	protected void init(Collection<Resource> models,  Scope scope) {
		LogUtil.log(LogEvent.DEBUG, "Initializing Matcher...");
		this.models = models;
		this.scope = scope;	
		if(correspondencesService == null){
			this.correspondencesService = CorrespondencesUtil.getDefaultCorrespondencesService();
		}
		this.candidatesService = CandidatesUtil.getCandidatesServiceInstance();
		
		if(this.mode.equals(MatcherMode.SINGLE)){
			this.correspondencesService.init(models);
			this.candidatesService.init(models);
		}
		LogUtil.log(LogEvent.DEBUG, "Matcher initialized!");
	}
	
	@Override
	public void reset() {
		this.models = null;
		if(candidatesService != null){
			this.candidatesService.reset();
		}
		if(correspondencesService != null){
			this.correspondencesService.reset();
		}
	}
	
	
	@Override
	public boolean canHandleDocTypes(Set<String> documentTypes) {
		
		return getDocumentTypes().contains(EMFModelAccess.GENERIC_DOCUMENT_TYPE)
				|| getDocumentTypes().containsAll(documentTypes);

	}
	
	@Override
	public boolean canHandleModels(Collection<Resource> models) {
		Set<String> docTypes = new HashSet<String>();
		for(Resource model : models){
			if(isResourceSetCapable()){
				docTypes.addAll(EMFModelAccess.getDocumentTypes(model,
						Scope.RESOURCE_SET));
			}else{
				docTypes.addAll(EMFModelAccess.getDocumentTypes(model, Scope.RESOURCE));
			}
		}
		
		return canHandleDocTypes(docTypes);
	}
	
	@Override
	public boolean isResourceSetCapable() {
		return false;
	}	
	
	
	// ---------- Getter and Setter Methods----------
	
	public String getKey(){
		return getClass().getSimpleName();
	}
	
	public String getServiceID(){
		return SERVICE_ID+"."+getKey();
	}
	
	public Collection<Resource> getModels() {
		return models;
	}	

	public void setCorrespondencesService(ICorrespondences correspondencesService){
		this.correspondencesService = correspondencesService;
	}
	
	public ICorrespondences getCorrespondencesService() {
		return correspondencesService;
	}

	@Override
	public void setCandidatesService(ICandidates candidatesService) {
		this.candidatesService = candidatesService;
	}
	
	public ICandidates getCandidatesService() {
		return candidatesService;
	}

	public MatcherMode getMode() {
		return mode;
	}

	public void setMode(MatcherMode mode) {
		this.mode = mode;
	}
	
	
}
