/**
 * FROM: https://git.eclipse.org/c/egit/egit.git/tree/org.eclipse.egit.ui/src/org/eclipse/egit/ui/internal/history
 */

/*******************************************************************************
 * Copyright (C) 2007, Robin Rosenberg <robin.rosenberg@dewire.com>
 * Copyright (C) 2008, Shawn O. Pearce <spearce@spearce.org>
 * Copyright (c) 2010, Stefan Lay <stefan.lay@sap.com>
 * Copyright (C) 2012, Robin Stocker <robin@nibor.org>
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.sidiff.reverseengineering.dataset.history.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffEntry.ChangeType;
import org.eclipse.jgit.diff.RenameDetector;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.EmptyTreeIterator;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.TreeFilter;
import org.eclipse.jgit.treewalk.filter.TreeFilterMarker;

/**
 * A class with information about the changes to a file introduced in a commit.
 */
public class FileDiff {

	private final RevCommit commit;

	private DiffEntry diffEntry;

	public static FileDiff[] computeMergeCommit(final Repository repository, String commitId)
			throws MissingObjectException, IncorrectObjectTypeException, IOException, CanceledException {
		ObjectId mergeCommitId = repository.resolve(commitId);

		try (RevWalk revWalk = new RevWalk(repository)) {
			RevCommit mergeCommit = revWalk.parseCommit(mergeCommitId);

			if (mergeCommit.getParentCount() > 1) {
				ObjectId parent1CommitId = repository.resolve(mergeCommit.getParent(0).getName());
				RevCommit parent1 = revWalk.parseCommit(parent1CommitId);

				ObjectId parent2CommitId = repository.resolve(mergeCommit.getParent(1).getName());
				RevCommit parent2 = revWalk.parseCommit(parent2CommitId);

				TreeWalk treeWalk = new TreeWalk(repository);
				treeWalk.addTree(mergeCommit.getTree());
				treeWalk.setRecursive(true);

				return compute(repository, treeWalk, mergeCommit, new RevCommit[] { parent1, parent2 });
			}
		}

		return new FileDiff[0];
	}

	/**
	 * Computer file diffs for specified tree walk and commit
	 *
	 * @param repository
	 * @param walk
	 * @param commit
	 * @param markTreeFilters optional filters for marking entries, see
	 *                        {@link #isMarked(int)}
	 * @return non-null but possibly empty array of file diffs
	 * @throws MissingObjectException
	 * @throws IncorrectObjectTypeException
	 * @throws CorruptObjectException
	 * @throws IOException
	 * @throws CanceledException
	 */
	public static FileDiff[] compute(final Repository repository, final TreeWalk walk, final RevCommit commit,
			final TreeFilter... markTreeFilters) throws MissingObjectException, IncorrectObjectTypeException,
			CorruptObjectException, IOException, CanceledException {
		return compute(repository, walk, commit, commit.getParents(), markTreeFilters);
	}

	/**
	 * Computer file diffs for specified tree walk and commit
	 *
	 * @param repository
	 * @param walk
	 * @param commit
	 * @param parents
	 * @param markTreeFilters optional filters for marking entries, see
	 *                        {@link #isMarked(int)}
	 * @return non-null but possibly empty array of file diffs
	 * @throws MissingObjectException
	 * @throws IncorrectObjectTypeException
	 * @throws CorruptObjectException
	 * @throws IOException
	 * @throws CanceledException
	 */
	public static FileDiff[] compute(final Repository repository, final TreeWalk walk, final RevCommit commit,
			final RevCommit[] parents, final TreeFilter... markTreeFilters) throws MissingObjectException,
			IncorrectObjectTypeException, CorruptObjectException, IOException, CanceledException {
		final ArrayList<FileDiff> r = new ArrayList<>();

		if (parents.length > 0) {
			walk.reset(trees(commit, parents));
		} else {
			walk.reset();
			walk.addTree(new EmptyTreeIterator());
			walk.addTree(commit.getTree());
		}

		if (walk.getTreeCount() <= 2) {
			List<DiffEntry> entries = DiffEntry.scan(walk, false, markTreeFilters);
			List<DiffEntry> xentries = new LinkedList<>(entries);
			RenameDetector detector = new RenameDetector(repository);
			detector.addAll(entries);
			List<DiffEntry> renames = detector.compute(walk.getObjectReader(),
					org.eclipse.jgit.lib.NullProgressMonitor.INSTANCE);
			for (DiffEntry m : renames) {
				final FileDiff d = new FileDiff(commit, m);
				r.add(d);
				for (Iterator<DiffEntry> i = xentries.iterator(); i.hasNext();) {
					DiffEntry n = i.next();
					if (m.getOldPath().equals(n.getOldPath()))
						i.remove();
					else if (m.getNewPath().equals(n.getNewPath()))
						i.remove();
				}
			}
			for (DiffEntry m : xentries) {
				final FileDiff d = new FileDiff(commit, m);
				r.add(d);
			}
		} else { // DiffEntry does not support walks with more than two trees
			final int nTree = walk.getTreeCount();
			final int myTree = nTree - 1;

			TreeFilterMarker treeFilterMarker = new TreeFilterMarker(markTreeFilters);

			while (walk.next()) {
				if (matchAnyParent(walk, myTree))
					continue;

				int treeFilterMarks = treeFilterMarker.getMarks(walk);

				final FileDiffForMerges d = new FileDiffForMerges(commit, treeFilterMarks);
				d.path = walk.getPathString();
				int m0 = 0;
				for (int i = 0; i < myTree; i++)
					m0 |= walk.getRawMode(i);
				final int m1 = walk.getRawMode(myTree);
				d.change = ChangeType.MODIFY;
				if (m0 == 0 && m1 != 0)
					d.change = ChangeType.ADD;
				else if (m0 != 0 && m1 == 0)
					d.change = ChangeType.DELETE;
				else if (m0 != m1 && walk.idEqual(0, myTree))
					d.change = ChangeType.MODIFY; // there is no ChangeType.TypeChanged
				d.blobs = new ObjectId[nTree];
				d.modes = new FileMode[nTree];
				for (int i = 0; i < nTree; i++) {
					d.blobs[i] = walk.getObjectId(i);
					d.modes[i] = walk.getFileMode(i);
				}

				r.add(d);
			}

		}

		final FileDiff[] tmp = new FileDiff[r.size()];
		r.toArray(tmp);
		return tmp;
	}

	static ObjectId[] trees(final RevCommit commit, final RevCommit[] parents) {
		final ObjectId[] r = new ObjectId[parents.length + 1];
		for (int i = 0; i < r.length - 1; i++)
			r[i] = parents[i].getTree().getId();
		r[r.length - 1] = commit.getTree().getId();
		return r;
	}

	private static boolean matchAnyParent(final TreeWalk walk, final int myTree) {
		final int m = walk.getRawMode(myTree);
		for (int i = 0; i < myTree; i++)
			if (walk.getRawMode(i) == m && walk.idEqual(i, myTree))
				return true;
		return false;
	}

	/**
	 * Get commit
	 *
	 * @return commit
	 */
	public RevCommit getCommit() {
		return commit;
	}

	/**
	 * @return the old path in case of a delete, the new path otherwise, but never
	 *         null or <code>/dev/null</code>
	 * @see #getNewPath()
	 * @see #getOldPath()
	 */
	public String getPath() {
		if (ChangeType.DELETE.equals(diffEntry.getChangeType()))
			return diffEntry.getOldPath();
		return diffEntry.getNewPath();
	}

	/**
	 * @return the old path or <code>/dev/null</code> for a completely new file
	 * @see #getPath() for getting the new or old path depending on change type
	 */
	public String getOldPath() {
		return diffEntry.getOldPath();
	}

	/**
	 * @return the new path or <code>/dev/null</code> for a deleted file
	 * @see #getPath() for getting the new or old path depending on change type
	 */
	public String getNewPath() {
		return diffEntry.getNewPath();
	}

	/**
	 * Get change type
	 *
	 * @return type
	 */
	public ChangeType getChange() {
		return diffEntry.getChangeType();
	}

	/**
	 * Get blob object ids
	 *
	 * @return non-null but possibly empty array of object ids
	 */
	public ObjectId[] getBlobs() {
		List<ObjectId> objectIds = new ArrayList<>();
		if (diffEntry.getOldId() != null)
			objectIds.add(diffEntry.getOldId().toObjectId());
		if (diffEntry.getNewId() != null)
			objectIds.add(diffEntry.getNewId().toObjectId());
		return objectIds.toArray(new ObjectId[] {});
	}

	/**
	 * Get file modes
	 *
	 * @return non-null but possibly empty array of file modes
	 */
	public FileMode[] getModes() {
		List<FileMode> modes = new ArrayList<>();
		if (diffEntry.getOldMode() != null)
			modes.add(diffEntry.getOldMode());
		if (diffEntry.getOldMode() != null)
			modes.add(diffEntry.getOldMode());
		return modes.toArray(new FileMode[] {});
	}

	/**
	 * Whether the mark tree filter with the specified index matched during scan or
	 * not, see
	 * {@link #compute(Repository, TreeWalk, RevCommit, RevCommit[], TreeFilter...)}
	 * .
	 *
	 * @param index the tree filter index to check
	 * @return true if it was marked, false otherwise
	 */
	public boolean isMarked(int index) {
		return diffEntry != null && diffEntry.isMarked(index);
	}

	/**
	 * Create a file diff for a specified {@link RevCommit} and {@link DiffEntry}
	 *
	 * @param c
	 * @param entry
	 */
	public FileDiff(final RevCommit c, final DiffEntry entry) {
		diffEntry = entry;
		commit = c;
	}

	/**
	 * Is this diff a submodule?
	 *
	 * @return true if submodule, false otherwise
	 */
	public boolean isSubmodule() {
		if (diffEntry == null)
			return false;
		return diffEntry.getOldMode() == FileMode.GITLINK || diffEntry.getNewMode() == FileMode.GITLINK;
	}

	private static class FileDiffForMerges extends FileDiff {
		private String path;

		private ChangeType change;

		private ObjectId[] blobs;

		private FileMode[] modes;

		private final int treeFilterMarks;

		private FileDiffForMerges(final RevCommit c, int treeFilterMarks) {
			super(c, null);
			this.treeFilterMarks = treeFilterMarks;
		}

		@Override
		public String getPath() {
			return path;
		}

		@Override
		public String getNewPath() {
			return path;
		}

		@Override
		public ChangeType getChange() {
			return change;
		}

		@Override
		public ObjectId[] getBlobs() {
			return blobs;
		}

		@Override
		public FileMode[] getModes() {
			return modes;
		}

		@Override
		public boolean isMarked(int index) {
			return (treeFilterMarks & (1L << index)) != 0;
		}
	}
}
