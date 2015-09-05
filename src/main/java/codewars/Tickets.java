package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: Muksia
 * Date: 05/09/15
 * Time: 15:44
 */
public class Tickets {

    public static String tickets(int[] peopleInLine)
    {
        int count50 = 0;
        int count25 = 0;
        for (int current : peopleInLine){
            if (current == 25){
                count25++;
            }
            if (current == 50){
                count25--;
                if (count25 < 0){
                    return "NO";
                }
                count50++;
            }
            if (current == 100){
                if (count50 > 0){
                    count50--;
                    count25--;
                } else {
                    count25 -= 3;
                }
                if (count25 < 0){
                    return "NO";
                }

            }
        }
        return "YES";
    }

    @Test
    public void test1() {
        assertEquals("YES", tickets(new int[] {25, 25, 50}));
    }
    @Test
    public void test2() {
        assertEquals("NO", tickets(new int []{25, 100}));
    }
}
