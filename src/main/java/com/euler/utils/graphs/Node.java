package com.euler.utils.graphs;

public class Node implements Comparable<Node> {
	   
	   public final int name;
	   boolean visited = false;
	   
	   public Node(final int argName) {
	       name = argName;
	   }
	   
	   public int compareTo(final Node argNode) {
	       return argNode == this ? 0 : -1;
	   }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + name;
		result = prime * result + (visited ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (name != other.name)
			return false;
		if (visited != other.visited)
			return false;
		return true;
	}


	}