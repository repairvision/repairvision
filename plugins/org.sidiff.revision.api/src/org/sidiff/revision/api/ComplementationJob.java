package org.sidiff.revision.api;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.api.ranking.RankingComparator;
import org.sidiff.revision.api.undo.ComplementCommand;
import org.sidiff.revision.api.undo.IEditCommand;
import org.sidiff.revision.api.undo.RollbackCommand;

/**
 * A container for all applicable complements.
 * 
 * @author Manuel Ohrndorf
 *
 * @param <R>
 *            The kind of {@link ComplementationPlan}.
 */
public class ComplementationJob<R extends ComplementationPlan> {

	/**
	 * History of applied complements.
	 */
	protected Stack<IEditCommand> editStack = new Stack<>();

	/**
	 * All applicable complement plans
	 */
	protected List<R> complementationPlans;
	
	/**
	 * Ranking for complement rules and complements.
	 */
	protected RankingComparator ranking;

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
	 * Initializes an empty complement job.
	 */
	public ComplementationJob(List<R> complements, IRevision revision, EGraph targetGraph) {
		this.complementationPlans = complements;
		this.revision = revision;
		this.targetGraph = targetGraph;
		
		this.engine = new EngineImpl();
		this.ranking = new RankingComparator(this);
	}

	/**
	 * Copies the history of applied complements from the given complement job.
	 * 
	 * @param complementJob
	 *            The complement job that contains the complement history.
	 */
	public void copyHistory(ComplementationJob<R> complementJob) {
		this.editStack = complementJob.editStack;
	}

	public boolean applyComplement(ComplementationPlan complementationPlan, Match match, boolean saveModel) {

		// Apply complement:
		RuleApplication application = new RuleApplicationImpl(engine);
		application.setEGraph(targetGraph);
		application.setRule(complementationPlan.getComplementingEditRule());
		application.setCompleteMatch(match);
		
		ComplementCommand complementCommand = new ComplementCommand(application);
		
		if (complementCommand.apply()) {
			editStack.push(complementCommand);
			
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
	
	public boolean rollbackIncomplete(ComplementationPlan complement, boolean saveModel) {

		// rollback inconsistency-inducing changes:
		RollbackCommand rollbackCommand = new RollbackCommand(complement, revision);

		if (rollbackCommand.apply()) {
			editStack.push(rollbackCommand);

			if (saveModel) {
				try {
					revision.getVersionB().getTargetResource().save(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			return false;
		}

		return true;

	}

	public boolean undoLast(boolean saveModel) {

		// Undo complement:
		if (!editStack.isEmpty()) {
			IEditCommand lastEdit = editStack.pop();

			// Save model
			if (lastEdit.undo()) {
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

	public List<R> getComplementationPlans() {
		return complementationPlans;
	}

	public void setComplementationPlans(List<R> complements) {
		this.complementationPlans = complements;
	}
	
	public RankingComparator getRanking() {
		return ranking;
	}
	
	public void setRanking(RankingComparator ranking) {
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
