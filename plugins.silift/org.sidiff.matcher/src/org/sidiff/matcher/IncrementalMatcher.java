package org.sidiff.matcher;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.candidates.ICandidates;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.common.utilities.emf.DocumentType;
import org.sidiff.common.utilities.emf.Scope;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.matcher.mode.MatcherMode;

/**
 * Incremental matcher which must be initialized with a list of IMatchers. When
 * the matching is computed, this incremental matcher invokes all sub-matchers
 * in the order which is given by the list of matchers. 
 * 
 * Note that this matcher is not registered via an extension point and will not
 * be shown in the UI. If the user selects more than one @link{IMatcher} in the 
 * @link{MatchingEngineWidget} this class will be created dynamically and all chosen matchers will
 * be added.
 * 
 * 
 * @author kehrer
 */
public class IncrementalMatcher implements IMatcher {

	/**
	 * The list of matchers which will be executed in the order given by the
	 * List.
	 */
	private List<IMatcher> matchers;

	/**
	 * Constructs a new incremental matcher based on a list of sub-matchers.
	 * These sub-matchers will be executed in the order given by the list.
	 * 
	 * @param matchers
	 */
	public IncrementalMatcher(List<IMatcher> matchers) {
		super();
		this.matchers = matchers;
	}

	@Override
	public void startMatching(Collection<Resource> models, Scope scope) {

		LogUtil.log(LogEvent.NOTICE, "Starting incremental matching");

		boolean initialized = false;
		for (int i = 0; i < matchers.size(); i++) {
			IMatcher nextMatcher = matchers.get(i);
			if (nextMatcher.canHandleModels(models)) {
				LogUtil.log(LogEvent.NOTICE, "Next matcher (" + i + "): " + nextMatcher.getName());
				if(initialized){
					nextMatcher.setMode(MatcherMode.INCREMENTAL);
					nextMatcher.setCandidatesService(matchers.get(i-1).getCandidatesService());
					nextMatcher.setCorrespondencesService(matchers.get(i-1).getCorrespondencesService());
				}
				nextMatcher.startMatching(models, scope);
				initialized = true;
			} else {
				LogUtil.log(LogEvent.NOTICE, "Next matcher (" + i + "): " + nextMatcher.getName()
				+ ": Skip because cannot handle resources " + models );

			}
		}

		LogUtil.log(LogEvent.NOTICE, "Finished incremental matching");
	}

	@Override
	public void reset() {		
		for (int i = 0; i < matchers.size(); i++) {
			IMatcher nextMatcher = matchers.get(i);
			nextMatcher.reset();

		}		
	}
	
	@Override
	public boolean canHandleDocTypes(Set<String> documentTypes) {
		return getDocumentTypes().containsAll(documentTypes);
	}
	
	@Override
	public boolean canHandleModels(Collection<Resource> models) {
		Set<String> docTypes = new HashSet<String>();
		for(Resource model : models){
			if(isResourceSetCapable()){
				docTypes.addAll(DocumentType.getDocumentTypes(model,
						Scope.RESOURCE_SET));
			}else{
				docTypes.addAll(DocumentType.getDocumentTypes(model, Scope.RESOURCE));
			}
		}

		return canHandleDocTypes(docTypes);
	}

	@Override
	public boolean isResourceSetCapable() {
		// true if at least one of the matchers is resource set capable
		for (IMatcher matcher : matchers) {
			if (matcher.isResourceSetCapable()) {
				return true;
			}
		}

		return false;
	}	

	@Override
	public Set<String> getDocumentTypes() {
		Set<String> docTypes = new HashSet<String>();
		for(IMatcher matcher : matchers){
			docTypes.addAll(matcher.getDocumentTypes());
		}
		return docTypes;
	}

	@Override
	public String getName() {
		return "Incremental Matcher";
	}

	@Override
	public String getKey() {
		return getClass().getName();
	}


	@Override
	public String getDescription() {
		return "This matcher incrementally invokes all sub-matchers in the order which is given by the list of matchers.";

	}

	@Override
	public String getServiceID() {
		return SERVICE_ID+"."+getKey();
	}

	public void setMatchers(List<IMatcher> imatchers) {
	
		this.matchers = imatchers;
		
	}
	
	public List<IMatcher> getMatchers() {
		return matchers;
	}

	@Override
	public Collection<Resource> getModels() {
		return matchers.get(0).getModels();
	}

	@Override
	public ICorrespondences getCorrespondencesService() {
		return matchers.iterator().next().getCorrespondencesService();
	}

	@Override
	public ICandidates getCandidatesService() {
		return matchers.iterator().next().getCandidatesService();

	}

	@Override
	public void setCorrespondencesService(ICorrespondences correspondencesService) {
		for(IMatcher matcher : matchers){
			matcher.setCorrespondencesService(correspondencesService);
		}
		
	}

	@Override
	public void setCandidatesService(ICandidates candidatesService) {
		for(IMatcher matcher : matchers){
			matcher.setCandidatesService(candidatesService);
		}
	}

	@Override
	public MatcherMode getMode() {
		return MatcherMode.INCREMENTAL;
	}

	@Override
	public void setMode(MatcherMode mode) {
		// TODO Auto-generated method stub
		
	}

}
