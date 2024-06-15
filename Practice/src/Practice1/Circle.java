package Practice1;

public class Circle implements Shape{
    double radius;
    Circle(double radius){
        setRadius(radius);
    }
    @Override
    public double calculatePerimeter() {
        double perimeter = 2 * radius * Math.PI;
        return perimeter;
    }

    @Override
    public double calculateArea() {
        double area = Math.PI * radius * radius;
        return area;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}