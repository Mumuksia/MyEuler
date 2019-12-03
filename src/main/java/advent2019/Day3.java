package advent2019;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class Day3 {

  int[][] matrix = new int[20009][20009];
  int[][] steps = new int[20009][20009];
  List<Integer> distances = new ArrayList<>();
  List<Integer> stepDistances = new ArrayList<>();
  int centerX = 10000;
  int centerY = 10000;
  int step = 0;

  public int result() throws IOException {
    List<String> result = Files.readAllLines(Paths.get(System.getProperty("user.dir") +
        "/src/main/resources/advent/day3.txt"));

    return calculateDistance(result.get(0), result.get(1));
  }

  public int resultSteps() throws IOException {
    List<String> result = Files.readAllLines(Paths.get(System.getProperty("user.dir") +
        "/src/main/resources/advent/day3.txt"));

    return calculateSteps(result.get(0), result.get(1));
  }

  public int calculateDistance(String line1, String line2){
    Arrays.stream(line1.split(",")).forEach(command -> fillMatrix(centerX, centerY, command));
    centerX = 10000;
    centerY = 10000;
    Arrays.stream(line2.split(",")).forEach(command -> fillMatrix2(centerX, centerY, command));
    return distances.stream().filter(d-> d!=0).mapToInt( d-> d).min().getAsInt();
  }

  public int calculateSteps(String line1, String line2){
    Arrays.stream(line1.split(",")).forEach(command -> fillMatrix(centerX, centerY, command));
    centerX = 10000;
    centerY = 10000;
    step = 0;
    Arrays.stream(line2.split(",")).forEach(command -> fillMatrix2(centerX, centerY, command));
    return stepDistances.stream().filter(d-> d!=0).mapToInt( d-> d).min().getAsInt();
  }

  public void fillMatrix(int x, int y, String command){

    if (command.charAt(0) == 'R'){
      String number = command.substring(1);
      for (int i=1;i<=Integer.parseInt(number);i++){
        step++;
        matrix[x+i][y] =1;
        steps[x+i][y] =step;
        centerX = x+i;
      }
    } else
    if (command.charAt(0) == 'L'){
      String number = command.substring(1);
      for (int i=1;i<=Integer.parseInt(number);i++){
        step++;
        matrix[x-i][y] =1;
        steps[x-i][y] =step;
        centerX = x-i;
      }
    } else
    if (command.charAt(0) == 'U'){
      String number = command.substring(1);
      for (int i=1;i<=Integer.parseInt(number);i++){
        step++;
        matrix[x][y-i] =1;
        steps[x][y-i] =step;
        centerY = y-i;
      }
    } else
    if (command.charAt(0) == 'D'){
      String number = command.substring(1);
      for (int i=1;i<=Integer.parseInt(number);i++){
        step++;
        matrix[x][y+i] =1;
        steps[x][y+i] =step;
        centerY = y+i;
      }
    }
  }

  public void fillMatrix2(int x, int y, String command){

    if (command.charAt(0) == 'R'){
      String number = command.substring(1);
      for (int i=1;i<=Integer.parseInt(number);i++){
        step++;
        if (matrix[x+i][y] == 1){
          distances.add(Math.abs(10000-x-i) + Math.abs(10000-y));
          stepDistances.add(step + steps[x+i][y]);
        }

        centerX = x+i;
      }
    } else
    if (command.charAt(0) == 'L'){
      String number = command.substring(1);
      for (int i=1;i<=Integer.parseInt(number);i++){
        step++;
        if (matrix[x-i][y] == 1){
          distances.add(Math.abs(10000-x+i) + Math.abs(10000-y));
          stepDistances.add(step + steps[x-i][y]);
        }
        centerX = x-i;
      }
    } else
    if (command.charAt(0) == 'U'){
      String number = command.substring(1);
      for (int i=1;i<=Integer.parseInt(number);i++){
        step++;
        if (matrix[x][y-i] == 1){
          distances.add(Math.abs(10000-x) + Math.abs(10000-y + i));
          stepDistances.add(step + steps[x][y-i]);
        }

        centerY = y-i;
      }
    } else
    if (command.charAt(0) == 'D'){
      String number = command.substring(1);
      for (int i=1;i<=Integer.parseInt(number);i++){
        step++;
        if (matrix[x][y+i] == 1){
          distances.add(Math.abs(10000-x) + Math.abs(10000-y-i));
          stepDistances.add(step + steps[x][y+i]);
        }

        centerY = y+i;
      }
    }
  }

  @Test
  public void testInput1(){
    assertEquals(6, calculateDistance("R8,U5,L5,D3", "U7,R6,D4,L4"));
  }

  @Test
  public void testInput2(){
    assertEquals(159, calculateDistance("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83"));
  }

  @Test
  public void testInput3(){
    assertEquals(135, calculateDistance("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"));
  }

  @Test
  public void testResult() throws IOException {
    assertEquals(5319, result());
  }

  @Test
  public void testInputSteps1(){
    assertEquals(30, calculateSteps("R8,U5,L5,D3", "U7,R6,D4,L4"));
  }

  @Test
  public void testInputSteps2(){
    assertEquals(610, calculateSteps("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83"));
  }

  @Test
  public void testInputSteps3(){
    assertEquals(410, calculateSteps("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"));
  }

  @Test
  public void testStepsResult() throws IOException {
    assertEquals(122514, resultSteps());
  }

}
