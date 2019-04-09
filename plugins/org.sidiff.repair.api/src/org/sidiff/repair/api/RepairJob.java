package org.sidiff.repair.api;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.sidiff.history.revision.IRevision;
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
	 * The revision between model A and model B.
	 */
	protected IRevision revision;
	
	/**
	 * The (Henshin) engine which applies the rules.
	 */
	protected EngineImpl engine;
	
	/**
	 * The working graph, i.e. the actual version of the model.
	 */
	protected EGraph targetGraph;

	/**
	 * Initializes an empty repair job.
	 */
	public RepairJob(List<R> repairs, IRevision revision, EGraph targetGraph) {
		this.repairs = repairs;
		this.revision = revision;
		this.targetGraph = targetGraph;
		
		this.engine = new EngineImpl();
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

	public boolean applyRepair(IRepairPlan repair, Match match, boolean saveModel) {

		// Apply repair:
		RuleApplication application = new RuleApplicationImpl(engine);
		application.setEGraph(targetGraph);
		application.setRule(repair.getComplementingEditRule());
		application.setCompleteMatch(match);
		
		if (application.execute(null)) {
			repairStack.push(application);
			
			// Save model
			if (saveModel) {
				try {
					revision.getVersionB().getTargetResource().save(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean undoRepair(boolean saveModel) {

		// Undo repair:
		if (!repairStack.isEmpty()) {
			RuleApplication lastRepairs = repairStack.pop();

			// Save model
			if (lastRepairs.undo(null)) {
				if (saveModel) {
					try {
						revision.getVersionB().getTargetResource().save(null);
					} catch (IOException e) {
						e.printStackTrace();
					}
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
	
	public IRevision getRevision() {
		return revision;
	}
	
	public EngineImpl getEngine() {
		return engine;
	}
	
	public void setEngine(EngineImpl engine) {
		this.engine = engine;
	}
	
	public EGraph getGraph() {
		return targetGraph;
	}
	
	public void setGraph(EGraph graph) {
		this.targetGraph = graph;
	}
}
