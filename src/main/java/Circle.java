import org.junit.Test;

import java.text.DecimalFormat;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * User: Muksia
 * Date: 01/09/15
 * Time: 20:20
 */
public class Circle {
    public static double area(double radius) {
        if (radius <= 0){
            throw new IllegalArgumentException();
        }
        return (double)Math.round(Math.PI*radius*radius*100)/100;
    }

    @Test
    public void testKnownValues() {
        try {
            Circle.area(0);
            fail("Radius of 0 should throw an IllegalArgumentException");
        } catch(IllegalArgumentException iae) {}
        for(int i = 0; i < 3; i++) {
            double x = 3D;
            assertEquals(28.27D, Circle.area(x), 0.01);
        }

        assertEquals(29170.2,Circle.area(96.3595428335386));
    }
}
