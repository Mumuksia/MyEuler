package algo.kosaraju;

import com.euler.utils.FileUtilsEuler;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: y.zavada
 * Date: 12.04.12
 * Time: 14:50
 * To change this template use File | Settings | File Templates.
 */
public class ResultKosaraju {

    @Test
    public void doTest() throws IOException {
        AdjacencyList adjList = new AdjacencyList();
        long start = System.currentTimeMillis();
        FileUtilsEuler.fileName = "D:/SCC.txt";
        BufferedReader br = new BufferedReader(new FileReader("D:/SCC.txt"));
        PrintWriter pw = new PrintWriter("c:\\temp\\test-prices_NASDAQ.log");
        String line = null;
        int count = 0;
        int[][] nodes = new int[6000000][2];
        int i = 0;

        while ((line = br.readLine()) != null) {
            count++;
            String[] test = line.split(" ");
            nodes[i][0] = Integer.valueOf(test[0]);
            nodes[i][1] = Integer.valueOf(test[1]);
            i++;
        }
        System.out.println(count);
        System.out.println(System.currentTimeMillis() - start);

    }
}
