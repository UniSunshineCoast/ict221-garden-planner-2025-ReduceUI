
import garden_planner.model.CircleBed;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleBedTest {
    @Test
    void testGetRadius() {
        var circleBed = new CircleBed();
        assertEquals(1, circleBed.getRadius());
    }
    void testSetRadius() {
        var circleBed = new CircleBed();
        circleBed.setRadius(10);
        assertEquals(10, circleBed.getRadius());
    }


    @Test
    void testGetArea() {
        var Bed = new CircleBed();
        // Define a small delta for floating-point comparisons
        double delta = 0.0001;


        Assertions.assertEquals(3.14, Bed.getArea());

        Bed.setRadius(2);
        assertEquals(12.56, Bed.getArea());

        Bed.setRadius(3);
        assertEquals(28.26, Bed.getArea(), delta); // returns 28.259999999999998 without delta

    }
    @Test
    void testGetPerimeter() {
        var Bed = new CircleBed();

        Assertions.assertEquals(6.28, Bed.getPerimeter());

        Bed.setRadius(2);
        assertEquals(12.56, Bed.getPerimeter());
    }
    @Test
    void testToString() {
        var bed = new CircleBed();
        String expectedString = String.format("Circle 0.00 0.00 1.00");
        String actualString = bed.toString();

        assertEquals(expectedString, actualString, "toString() should format the rectangle information correctly.");


    }

}
