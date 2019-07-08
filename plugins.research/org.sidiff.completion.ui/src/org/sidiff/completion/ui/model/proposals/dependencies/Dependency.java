package org.sidiff.completion.ui.model.proposals.dependencies;

public class Dependency {
	
private Node predecessor;
private Node successor;


public Dependency(Node predecessor, Node successor) {
	super();
	this.predecessor = predecessor;
	this.successor = successor;
}


public Node getPredecessor() {
	return predecessor;
}
public void setPredecessor(Node predecessor) {
	this.predecessor = predecessor;
}


public Node getSuccessor() {
	return successor;
}
public void setSuccessor(Node successor) {
	this.successor = successor;
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		return predecessor.getName()+ "->" + successor.getName();
	}

}
