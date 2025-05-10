package garden_planner.model;

public class CircleBed extends GardenBed {
    private double radius = 1.0;

    public CircleBed(double radius) {}

    public CircleBed() {}

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public double getArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle %.2f %.2f %.2f", left, top, radius);
    }
}
