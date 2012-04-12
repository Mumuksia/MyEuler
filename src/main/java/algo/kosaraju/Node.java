package algo.kosaraju;

/**
 * Created with IntelliJ IDEA.
 * User: y.zavada
 * Date: 12.04.12
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */
public class Node implements Comparable<Node> {

    final int name;
    boolean visited = false;   // used for Kosaraju's algorithm and Edmonds's algorithm
    int lowlink = -1;          // used for Tarjan's algorithm
    int index = -1;            // used for Tarjan's algorithm

    public Node(final int argName) {
        name = argName;
    }

    public int compareTo(final Node argNode) {
        return argNode == this ? 0 : -1;
    }
}
