
import garden_planner.model.RectBed;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectBedTest {

    @Test
    void testSetLeft() {
        RectBed bed = new RectBed();
        bed.setLeft(10);
        assertEquals(10, bed.getLeft());
    }
    @Test
    void testGetLeft() {
        RectBed bed = new RectBed();
        double left = bed.getLeft();
        assertEquals(0, left);

        bed.setLeft(10);
        double getter = bed.getLeft();
        assertEquals(10, getter);
    }
    @Test
    void testSetTop() {
        RectBed bed = new RectBed();
        bed.setTop(10);
        assertEquals(10, bed.getTop());
    }
    @Test
    void testGetTop() {
        RectBed bed = new RectBed();
        double top = bed.getTop();
        assertEquals(0, top);
    }
    @Test
    void testSetWidth() {
        RectBed bed = new RectBed();
        bed.setWidth(10);
        assertEquals(10, bed.getWidth());
    }
    @Test
    void testGetWidth() {
        RectBed bed = new RectBed();
        double width = bed.getWidth();
        assertEquals(1, width);
    }
    @Test
    void testSetHeight() {
        RectBed bed = new RectBed();
        bed.setHeight(10);
        assertEquals(10, bed.getHeight());
    }
    @Test
    void testGetHeight() {
        RectBed bed = new RectBed();
        double height = bed.getHeight();
        assertEquals(1, height);
    }
    @Test
    void testGetArea() {
        RectBed Bed = new RectBed();

        Assertions.assertEquals(1, Bed.getArea());

        Bed.setWidth(2);
        Bed.setHeight(3);
        assertEquals(6, Bed.getArea());

        Bed.setWidth(7);
        Bed.setHeight(0);
        assertEquals(0, Bed.getArea());

    }
    @Test
    void testGetPerimeter() {
        RectBed Bed = new RectBed();

        Assertions.assertEquals(4, Bed.getPerimeter());

        Bed.setWidth(2);
        Bed.setHeight(3);
        assertEquals(10, Bed.getPerimeter());
    }
    @Test
    void testToString() {
        RectBed bed = new RectBed();
        String expectedString = String.format("Rectangle 0.00 0.00 1.00 1.00");
        String actualString = bed.toString();

        assertEquals(expectedString, actualString, "toString() should format the rectangle information correctly.");


    }

}
