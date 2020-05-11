package org.sidiff.revision.repair.history.retrieval.miner.connectors;

import org.jsoup.nodes.Element;

public class RepositoryMinerUtil {

	public static Element getParentNode(Element child, String name) {
		while(child.hasParent()) {
			if (child.parent().nodeName().equals(name)) {
				return child.parent();
			}
			child = child.parent();
		}
		return null;
	}
}
