package amazon;

import junit.framework.Assert;
import org.junit.Test;


public class CommonValuesTest {

    @Test
    public void doTest() {
        CommonValues cv = new CommonValues();

        Assert.assertEquals(0, cv.getSumOfMostCommonValues(null));

        Assert.assertEquals(0, cv.getSumOfMostCommonValues(new int[]{}));

        int[] data = new int[]{2, -4, 5, 6, -4};
        Assert.assertEquals(-8, cv.getSumOfMostCommonValues(data));


        data = new int[]{0, 0, 0, 0, 2, 2, 2, 2, -4, 5, 6, -4};
        Assert.assertEquals(0, cv.getSumOfMostCommonValues(data));

        data = new int[]{1};
        Assert.assertEquals(1, cv.getSumOfMostCommonValues(data));

        System.out.println(Integer.MAX_VALUE);
    }

}
