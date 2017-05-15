package org.sidiff.repair.ui.peo.evaluation.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.repair.historymodel.History;

public class RepairEvaluation implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	/**
	 * RQ01: History URI -> Evaluation
	 */
	private Map<String, ResearchQuestions> researchQuestions = new HashMap<>();
	
	public static double ratio(int a, int b) {
		if (b != 0) {
			return ((double) a) / ((double) b);
		} else {
			return -1;
		}
	}
	
	public Map<String, ResearchQuestions> getResearchQuestions() {
		return researchQuestions;
	}
		
	public ResearchQuestions createNewResearchQuestion(History history) {
		ResearchQuestions newRQ = new ResearchQuestions(history.getName(), history.eResource().getURI().toString());
		researchQuestions.put(newRQ.getHistoryURI(), newRQ);
		return newRQ;
	}
	
	public void store(ResearchQuestions researchQuestions) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
		String date = df.format(new Date());
		
		String outputPath =  EMFStorage.uriToFile(
				URI.createURI(researchQuestions.getHistoryURI()))
				.getParentFile().getAbsolutePath() + "\\" + date 
				+ researchQuestions.getHistoryName() + ".evaluation";
		
		try {
			File outputFile = new File(outputPath);
			outputFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		ObjectOutputStream obj_out = null;
		
		try {
			
			// Write to disk with FileOutputStream
			FileOutputStream f_out = new FileOutputStream(outputPath);
			
			// Write object with ObjectOutputStream
			obj_out = new ObjectOutputStream (f_out);
			
			// Write object out to disk
			obj_out.writeObject (researchQuestions);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (obj_out != null) {
				try {
					obj_out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void load(String path) {
		ObjectInputStream obj_in = null;
		
		try {
			// Read from disk using FileInputStream
			FileInputStream f_in = new FileInputStream(path);

			// Read object using ObjectInputStream
			obj_in = new ObjectInputStream (f_in);

			// Read an object
			Object obj = obj_in.readObject();

			if (obj instanceof ResearchQuestions) {
				researchQuestions.put(((ResearchQuestions) obj).getHistoryURI(), (ResearchQuestions) obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			if (obj_in != null) {
				try {
					obj_in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void dump() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat( "#,###,###,##0.00" );
		StringBuffer string = new StringBuffer();
		
//		string.append("\\begin{table*}[t!]");
//		string.append("\n");
//		string.append("\\centering");
//		string.append("\n");
//		string.append("\\begin{tabular}{|l|c|c||c|c|c||c|c|c||c|c|c||c|}");
//		string.append("\n");
//		string.append("\\hline");
//		string.append("\n");
//		string.append("\\multicolumn{3}{|c||}{} & \\multicolumn{3}{|c||}{RQ1} & \\multicolumn{3}{|c||}{RQ2} & \\multicolumn{3}{|c||}{RQ3} & \\multicolumn{1}{|c|}{RQ4}\\\\");
//		string.append("\n");
//		string.append("\\hline Model History & Rev. & Elem. & $RI_{M/A} $ & $RI_{wir}$ & $\frac{RI_{wir}}{RI_{M/A}}$ & $HOR_{M/A} $ & $HOR_{wir}$ & $\frac{HOR_{wir}}{HOR_{M/A}}$ & $RA_{M/A} $ & $RA_{wir}$ & $\frac{RA_{wir}}{RA_{M/A}}$ & Prio. \\\\");
//		string.append("\n");
//		string.append("\\hline\\hline");
//		string.append("\n");
		
		//	ProjectA.ModelA & 20 & 800 & 40 & 39 & 0.95 & 39 & 39 & 1.0 & 12 & 6 (2/3) & 0.5 & 2/6\\
		
		for (ResearchQuestions rq : researchQuestions.values()) {
			
			string.append(rq.getHistoryName());
			string.append(" & ");
			string.append(rq.getResearchQuestion01().revisionsAll);
			string.append(" & ");
			string.append(rq.getResearchQuestion01().avgElements);
			string.append(" & ");
			
			string.append(rq.getResearchQuestion01().atLeastOnRepairRE);
			string.append(" & ");
			string.append(rq.getResearchQuestion01().atLeastOnRepairOPK);
			string.append(" & ");
			string.append(df.format(rq.getResearchQuestion01().getRatioAtLeastOnRepair()));
			string.append(" & ");
			
			string.append(rq.getResearchQuestion02().repairAsObservedRE);
			string.append(" & ");
			string.append(rq.getResearchQuestion02().repairAsObservedOPK);
			string.append(" & ");
			string.append(df.format(rq.getResearchQuestion02().getRatioRepairAsObserved()));
			string.append(" & ");
			
			int repairTreePathsRE = ResearchQuestion03.getRepairActionsRE(rq.getResearchQuestion03().values());
			int repairsAllOPK = ResearchQuestion03.getRepairsAllOPK(rq.getResearchQuestion03().values());
			
			int avgRepairsAllOPK = ResearchQuestion03.getAVGRepairsAllOPK(rq.getResearchQuestion03().values());
			int avgComplementsAllOPK = ResearchQuestion03.getAVGComplementsAllOPK(rq.getResearchQuestion03().values());
			
			string.append(repairTreePathsRE);
			string.append(" & ");
			string.append(repairsAllOPK);
			string.append("(" + avgRepairsAllOPK);
			string.append("/" + avgComplementsAllOPK + ")");
			string.append(" & ");
			string.append(df.format(RepairEvaluation.ratio(repairTreePathsRE, repairsAllOPK)));
			string.append(" & ");
			
			int avgCountOfRepairs = ResearchQuestion04.getAVGCountOfRepairs(rq.getResearchQuestion04().values());
			int avgPositionOfComplement = ResearchQuestion04.getAVGPositionOfComplement(rq.getResearchQuestion04().values());
			
			string.append("(" + avgPositionOfComplement);
			string.append("/" + avgCountOfRepairs + ")");
			
			string.append("\\\\");
			string.append("\n");
		}

//		string.append("\\end{tabular}");
//		string.append("\n");
//		string.append("\\vspace{0.25cm}");
//		string.append("\n");
//		string.append("\\caption{TODO: results ....}");
//		string.append("\n");
//		string.append("\\label{tab:results}");
//		string.append("\n");
//		string.append("\\end{table*}");
//		string.append("\n");
		
		return string.toString();
	}
}
