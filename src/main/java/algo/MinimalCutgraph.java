package algo;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.testng.annotations.Test;

import com.euler.utils.FileUtilsEuler;
import com.euler.utils.graphs.AdjacencyList;
import com.euler.utils.graphs.Edge;
import com.euler.utils.graphs.Node;

public class MinimalCutgraph {
	
	private static AdjacencyList adjList = new AdjacencyList();
	
	public void init() throws IOException{
		FileUtilsEuler.fileName="d:/temp/kargerAdj.txt";
		int[][] lines = FileUtilsEuler.readFileListSpaces();
		for (int i=0; i<lines.length; i++){
			for (int j=0; j<10; j++){
				if (lines[i][j] > 0){
			adjList.addEdge(new Node(i), new Node(lines[i][j]), 0);			
				}
			}
		}
		
	}
	
	@Test
	public void doTest() throws IOException{
		init();
		System.out.println(adjList.getAllEdges().size());
		System.out.println(adjList.getSourceNodeSet().size());
		while (adjList.getSourceNodeSet().size() > 2){			
			cutOperation(random(adjList.getSourceNodeSet().size(), adjList.getSourceNodeSet()));
		}
		
	}
	
	public static void cutOperation(Node nd){
		System.out.println(nd.name);
		synchronized (adjList) {
			Node res = random(adjList.getAdjacent(nd)).to;
			for(Edge e : adjList.getAdjacent(nd)){
				if (res != e.to && res != nd && e.to != nd){
				adjList.addEdge(res, e.to, 0);
				}
			}
				
		}
		adjList.getSourceNodeSet().remove(nd);
	
	}
	
	public Node random(int size, Set<Node> mySet){
		int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
		int i = 0;
		for(Node obj : mySet)
		{
		    if (i == item)
		        return obj;
		    i = i + 1;
		}
		return null;
	}
	
	public static Edge random(List<Edge> mySet){
		int item = new Random().nextInt(mySet.size()); // In real life, the Random object should be rather more shared than this
		int i = 0;
		for(Edge obj : mySet)
		{
		    if (i == item)
		        return obj;
		    i = i + 1;
		}
		return null;
	}

}
