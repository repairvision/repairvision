package org.sidiff.repair.ui.peo.evaluation.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.repair.ui.peo.evaluation.util.EvaluationUtil;

public class ResearchQuestions implements Serializable  {

	private static final long serialVersionUID = 1L;

	private String historyURI = "N/A";
	
	private String historyName = "N/A";
	
	private ResearchQuestion01 researchQuestion01;
	
	private ResearchQuestion02 researchQuestion02;
	
	private Map<String, ResearchQuestion03> researchQuestion03 = new HashMap<>();
	
	private Map<String, ResearchQuestion04> researchQuestion04 = new HashMap<>();
	
	public ResearchQuestions(String historyName, String historyURI) {
		this.historyURI = historyURI;
		this.historyName = historyName;
	}
	
	public String getHistoryURI() {
		return historyURI;
	}
	
	public String getHistoryName() {
		return historyName;
	}
	
	public ResearchQuestion01 getResearchQuestion01() {
		if (researchQuestion01 != null) {
			researchQuestion01 = new ResearchQuestion01();
			researchQuestion01.historyURI = historyURI;
		}
		return researchQuestion01;
	}
	
	public ResearchQuestion02 getResearchQuestion02() {
		if (researchQuestion02 != null) {
			researchQuestion02 = new ResearchQuestion02();
			researchQuestion02.historyURI = historyURI;
		}
		return researchQuestion02;
	}
	
	public Map<String, ResearchQuestion03> getResearchQuestion03() {
		return researchQuestion03;
	}
	
	public Map<String, ResearchQuestion04> getResearchQuestion04() {
		return researchQuestion04;
	}
	
	public ResearchQuestion03 createNewRQ03(ValidationError validation) {
		assert (validation.eResource().getURI().toString() == historyURI);
		
		Version repairedVersion = EvaluationUtil.getPrecessorRevision(validation.getResolvedIn());
		
		ResearchQuestion03 rq03 = new ResearchQuestion03();
		rq03.historyURI = validation.eResource().getURI().toString();
		rq03.repairedModelURI = repairedVersion.getModelURI();
		rq03.elementURI = EcoreUtil.getURI(validation.getInvalidElement().get(0)).toString();
		rq03.validationID = EvaluationUtil.getValidationID(validation);
		
		researchQuestion03.put(rq03.validationID, rq03);
		return rq03;
	}
	
	public ResearchQuestion04 createNewRQ04(ValidationError validation) {
		assert (validation.eResource().getURI().toString() == historyURI);
		
		Version repairedVersion = EvaluationUtil.getPrecessorRevision(validation.getResolvedIn());
		
		ResearchQuestion04 rq04 = new ResearchQuestion04();
		rq04.historyURI = validation.eResource().getURI().toString();
		rq04.repairedModelURI = repairedVersion.getModelURI();
		rq04.elementURI = EcoreUtil.getURI(validation.getInvalidElement().get(0)).toString();
		rq04.validationID = EvaluationUtil.getValidationID(validation);
		
		researchQuestion04.put(rq04.validationID, rq04);
		return rq04;
	}
}
