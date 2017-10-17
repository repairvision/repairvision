package org.sidiff.repair.api;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.sidiff.repair.api.ranking.RepairRankingComparator;

/**
 * A container for all applicable repairs.
 * 
 * @author Manuel Ohrndorf
 *
 * @param <R>
 *            The kind of {@link Repair}.
 */
public class RepairJob<R extends IRepairPlan> {

	/**
	 * History of applied repairs.
	 */
	protected Stack<RuleApplication> repairStack = new Stack<>();

	/**
	 * All applicable repair plans
	 */
	protected List<R> repairs;
	
	/**
	 * Ranking for complement rules and repairs.
	 */
	protected RepairRankingComparator ranking;

	/**
	 * The historic model version.
	 */
	protected Resource modelA;

	/**
	 * The actual model version which have to be repaired.
	 */
	protected Resource modelB;

	/**
	 * The difference between model A and model B.
	 */
	protected Resource difference;
	
	/**
	 * The (Henshin) engine which applies the rules.
	 */
	protected EngineImpl engine;
	
	/**
	 * The working graph, i.e. the actual version of the model.
	 */
	protected EGraph graph;

	/**
	 * Initializes an empty repair job.
	 */
	public RepairJob() {
		this.ranking = new RepairRankingComparator(this);
	}

	/**
	 * Copies the history of applied repairs from the given repair job.
	 * 
	 * @param repairJob
	 *            The repair job that contains the repair history.
	 */
	public void copyHistory(RepairJob<R> repairJob) {
		this.repairStack = repairJob.repairStack;
	}

	public boolean applyRepair(IRepairPlan repair, Match match) {

		// Apply repair:
		RuleApplication application = new RuleApplicationImpl(engine);
		application.setEGraph(graph);
		application.setRule(repair.getComplementingEditRule());
		application.setCompleteMatch(match);
		
		if (application.execute(null)) {
			repairStack.push(application);
			
			// Save model
			try {
				getModelB().save(null);
			} catch (IOException e) {
				e.printStackTrace();
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean undoRepair() {

		// Undo repair:
		if (!repairStack.isEmpty()) {
			RuleApplication lastRepairs = repairStack.pop();

			// Save model
			if (lastRepairs.undo(null)) {
				try {
					getModelB().save(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return true;
		} else {
			return false;
		}
	}

	public List<R> getRepairs() {
		return repairs;
	}

	public void setRepairs(List<R> repairs) {
		this.repairs = repairs;
	}
	
	public RepairRankingComparator getRanking() {
		return ranking;
	}
	
	public void setRanking(RepairRankingComparator ranking) {
		this.ranking = ranking;
	}
	
	public Resource getModelA() {
		return modelA;
	}

	public void setModelA(Resource modelA) {
		this.modelA = modelA;
	}

	public Resource getModelB() {
		return modelB;
	}

	public void setModelB(Resource modelB) {
		this.modelB = modelB;
	}

	public Resource getDifference() {
		return difference;
	}

	public void setDifference(Resource difference) {
		this.difference = difference;
	}
	
	public EngineImpl getEngine() {
		return engine;
	}
	
	public void setEngine(EngineImpl engine) {
		this.engine = engine;
	}
	
	public EGraph getGraph() {
		return graph;
	}
	
	public void setGraph(EGraph graph) {
		this.graph = graph;
	}
}
