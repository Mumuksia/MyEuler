package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: Muksia
 * Date: 05/09/15
 * Time: 16:50
 */
public class Stairs {
    public static int NumberOfSteps(int n, int m)
    {
        return n==m?n:recursion(n, m, 0);
    }


    public static int recursion(int n, int m, int step){
        if (n == m){
            return m + step - 1;
        }
        if (n%2 == 0 && (n/2 + step)%m == 0){
            return n/2 + step;
        }
        else {
            if (n<m)      {
                return -1;
            } else {
                return recursion(n-1, m, ++step);
            }
        }
    }




    @Test
    public void test1() {
        assertEquals(6, NumberOfSteps(11, 2));
    }

    @Test
    public void test11() {
        assertEquals(4, NumberOfSteps(5, 4));
    }

    @Test
    public void test7() {
        assertEquals(6, NumberOfSteps(10, 2));
    }
    @Test
    public void test2() {
        assertEquals(-1, NumberOfSteps(3, 5));
    }
    @Test
    public void test3() {
        assertEquals(5000, NumberOfSteps(10000, 1000));
    }

    @Test
    public void test4() {
        assertEquals(5000, NumberOfSteps(5000, 5000));
    }
}
