package codewars;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

/**
 * User: Muksia
 * Date: 05/09/15
 * Time: 15:55
 */
public class BallotsCounter {


    public static String getWinner(final List<String> listOfBallots) {
        Map<String, Long> resultMap = listOfBallots.stream()
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()));

        for (String candidate : resultMap.keySet()){
            if (resultMap.get(candidate)*2 > listOfBallots.size())
                return candidate;
        }
        return null;
    }

    @Test
    public void testGetWinner_01() {
        assertThat(BallotsCounter.getWinner(Arrays.asList("A")), is("A"));
    }

    @Test
    public void testGetWinner_02() {
        assertThat(BallotsCounter.getWinner(Arrays.asList("A", "A", "A", "B", "B", "B", "A")), is("A"));
    }

    @Test
    public void testGetWinner_03() {
        assertThat(BallotsCounter.getWinner(Arrays.asList("A", "A", "A", "B", "B", "B")), is(nullValue()));
    }

    @Test
    public void testGetWinner_04() {
        assertThat(BallotsCounter.getWinner(Arrays.asList("A", "A", "A", "B", "C", "B")), is(nullValue()));
    }

    @Test
    public void testGetWinner_05() {
        assertThat(BallotsCounter.getWinner(Arrays.asList("A", "A", "B", "B", "C")), is(nullValue()));
    }
}
