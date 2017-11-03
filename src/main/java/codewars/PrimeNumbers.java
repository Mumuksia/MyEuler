package codewars;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrimeNumbers {



  public String getPrimeRepresentation(int n){
    Map<Integer, Integer> primes = new HashMap<>();
    int i = 2;
    while (n != 1){
      if (n % i == 0){
        primes.computeIfPresent(i , (key, value) -> ++value);
        primes.putIfAbsent(i, 1);
        n = n/i;
      } else {
        i++;
      }
    }
    return transformMap(primes);
  }

  public String transformMap(Map<Integer, Integer> result){
    final StringBuilder line = new StringBuilder();
    result.keySet().stream().sorted().forEach(key -> {
      if (result.get(key) > 1) {
        line.append("(" + key + "**" + result.get(key) + ")");
      } else {
        line.append("(" + key + ")");
      }
    });
    return line.toString();
  }

  @Test
  public void shouldReturnSameNumberIfPrime(){
    assertThat(getPrimeRepresentation(7), is("(7)"));
  }

  @Test
  public void shouldReturnPowerIfTwoOrMore(){
    assertThat(getPrimeRepresentation(9), is("(3**2)"));
  }


}
