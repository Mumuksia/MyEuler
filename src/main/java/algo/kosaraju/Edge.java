package algo.kosaraju;

/**
 * Created with IntelliJ IDEA.
 * User: y.zavada
 * Date: 12.04.12
 * Time: 14:47
 * To change this template use File | Settings | File Templates.
 */
public class Edge implements Comparable<Edge> {

    final Node from, to;
    final int weight;

    public Edge(final Node argFrom, final Node argTo, final int argWeight){
        from = argFrom;
        to = argTo;
        weight = argWeight;
    }

    public int compareTo(final Edge argEdge){
        return weight - argEdge.weight;
    }
}