import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RomanRecursion {

  private static final Map<Integer, Double> values = new HashMap<>();
  private static final int EDGE = 10;

  public Double calculate(){
    values.put(0, 9.0);
    values.put(1, 35.0);

    calculateValuesTill(9.0, 35.0, 2);

    return values.get(7) + values.get(9);
  }

  private void calculateValuesTill(double value1, double value2, int counter){
    if (counter < EDGE){
      double newValue = Math.sin(value2 + Math.cos(value1));
      values.put(counter, newValue);
      calculateValuesTill(value2, newValue, ++counter);
    }
  }

  @Test
  public void doTest(){
    calculate();
  }


}
