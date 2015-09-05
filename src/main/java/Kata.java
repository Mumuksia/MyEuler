import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * User: Muksia
 * Date: 01/09/15
 * Time: 20:13
 */
public class Kata {

    public static int alternateSqSum(int[] arr) {
        boolean even = false;
        int sum = 0;
        for (int a : arr){
            if (even){
                sum += a*a;
            } else {
                sum += a;
            }
            even = !even;
        }
        return sum;
    }

    @Test
    public void exampleTest() {
        assertEquals(379, Kata.alternateSqSum(new int[] {11, 12, 13, 14, 15}));
    }
}
