package algo;

import com.euler.utils.FileUtilsEuler;
import com.euler.utils.graphs.Edg;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MinimalCutgraph {

    private static Map<Integer, List<Edg>> adjList = new ConcurrentHashMap<Integer, List<Edg>>();

    public void init() throws IOException {
        FileUtilsEuler.fileName = "d:/temp/kargerAdj.txt";
        int[][] lines = FileUtilsEuler.readFileListSpaces();
        for (int i = 0; i < lines.length; i++) {
            List<Edg> edges = new ArrayList<Edg>();
            for (int j = 0; j < 10; j++) {
                if (lines[i][j] > 0) {
                    edges.add(new Edg(i, lines[i][j]));
                }

            }
            adjList.put(i, edges);
        }

    }

    @Test
    public void doTest() throws IOException {
        init();
        System.out.println(adjList.keySet().size());
        while (adjList.keySet().size() > 2) {
            cutOperation(randomEdge());
            System.out.println(adjList.keySet().size());
        }

    }

    public static void cutOperation(Edg e) {
        int from = e.from;
        List<Edg> edges = adjList.get(e.to);

        synchronized (edges) {


            for (Edg edg : edges) {
                if (edg != e && from != edg.from) {
                    adjList.get(edg.from).add(new Edg(edg.from, from));
                    adjList.get(edg.from).remove(edg);
                } else {
                    edges.remove(edg);
                }
            }

            adjList.get(from).addAll(edges);
            adjList.keySet().remove(e.to);
        }
    }

    public Edg randomEdge() {
        Set<Integer> nodes = adjList.keySet();

        int item = new Random().nextInt(nodes.size() - 1);
        int i = 0;
        for (int obj : nodes) {
            if (i == item)
                break;
            i = i + 1;
        }
        List<Edg> edges = adjList.get(i);
        item = new Random().nextInt(edges.size() - 1);
        i = 0;
        for (Edg obj : edges) {
            if (i == item)
                return obj;
            i = i + 1;
        }
        return null;
    }

}
