package codewars;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FibonacciProduct {

  public long[] productFib(long prod){
    return getNextFibonacci(prod, 1, 1);
  }

  public long[] getNextFibonacci(long prod, long number, long previous){
    long product = number * previous;
    if (product == prod){
      return new long[]{previous, number, 1};
    } else if (product > prod) {
      return new long[]{previous, number, 0};
    }
    return getNextFibonacci(prod, number + previous, number);
  }

  @Test
  public void testFibonacci(){
    assertThat(productFib(714), is(new long[]{21, 34, 1}));
  }

  @Test
  public void testFibonacciFalse(){
    assertThat(productFib(800), is(new long[]{34, 55, 0}));
  }

}
