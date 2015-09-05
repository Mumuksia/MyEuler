import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.Assert.assertEquals;

/**
 * User: Muksia
 * Date: 01/09/15
 * Time: 18:01
 */
public class DescendingOrder {
    public static int sortDesc(final int num) {
        Character[] numbers = String.valueOf(num).chars()
                .mapToObj(c -> (char)c)
                .toArray(Character[]::new);
        String reversedNumber =Arrays.stream(numbers).sorted((p1, p2) -> p2 - p1).
        map(p->p.toString()).collect(Collectors.joining());
        return Integer.valueOf(reversedNumber);
    }

    @Test
    public void test_01() {
        assertEquals(0, DescendingOrder.sortDesc(0));
    }

    @Test
    public void test_02() {
        assertEquals(51, DescendingOrder.sortDesc(15));
    }


    @Test
    public void test_03() {
        assertEquals(987654321, DescendingOrder.sortDesc(123456789));
    }
}
