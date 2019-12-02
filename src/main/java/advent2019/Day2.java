package advent2019;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day2 {

    public int[] ai = new int[200];

    public int solveComputer() throws IOException {
        List<String> result = Files.readAllLines(Paths.get(System.getProperty("user.dir") +
                "/src/main/resources/advent/day2.txt"));

        ai = convertInput(result.get(0));
        return 1;
    }

    public int[] convertInput(String input){
        return Arrays.stream(input.split(",")).mapToInt(Integer::valueOf).toArray();
    }

    public int calculateComputer(int[] ai){
        for (int i= 0; i<ai.length;){
            if (ai[i] == 1){
                ai[ai[i+3]] = ai[ai[i+1]] + ai[ai[i+2]];
            } else
            if (ai[i] == 2){
                ai[ai[i+3]] = ai[ai[i+1]] * ai[ai[i+2]];
            } else
            if (ai[i] == 99){
                return ai[0];
            }
            i+=4;
        }
        return ai[0];
    }

    @Test
    public void testInput(){
        int[] testAI = convertInput("1,9,10,3,2,3,11,0,99,30,40,50");
        assertEquals(3500, calculateComputer(testAI));
    }

    @Test
    public void testInput2(){
        int[] testAI = convertInput("1,0,0,0,99");
        assertEquals(2, calculateComputer(testAI));
    }

    @Test
    public void testInput3(){
        int[] testAI = convertInput("2,3,0,3,99");
        assertEquals(2, calculateComputer(testAI));
    }

    @Test
    public void testInput4(){
        int[] testAI = convertInput("2,4,4,5,99,0");
        assertEquals(2, calculateComputer(testAI));
    }

    @Test
    public void testInput5(){
        int[] testAI = convertInput("1,1,1,4,99,5,6,0,99");
        assertEquals(30, calculateComputer(testAI));
    }


    @Test
    public void testResult() throws IOException {
        List<String> result = Files.readAllLines(Paths.get(System.getProperty("user.dir") +
                "/src/main/resources/advent/day2.txt"));

        int[] testAI = convertInput(result.get(0));
        testAI[1] = 12;
        testAI[2] = 2;
        assertEquals(7210630, calculateComputer(testAI));
    }

    public int resetComputer() throws IOException {
        List<String> result = Files.readAllLines(Paths.get(System.getProperty("user.dir") +
                "/src/main/resources/advent/day2.txt"));

        for (int i= 0; i<99; i++){
            for (int j= 0; j<99; j++){
                int[] testAI = convertInput(result.get(0));
                testAI[1] = i;
                testAI[2] = j;
                if (calculateComputer(testAI) == 19690720){
                    return 100*i + j;
                }
            }
        }
        return 0;
    }

    @Test
    public void restComputerTest() throws IOException {
        assertEquals(1, resetComputer());
    }
}
