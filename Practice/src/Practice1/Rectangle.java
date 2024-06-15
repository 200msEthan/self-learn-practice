package Practice1;

public class Rectangle implements Shape{
    double length;
    double width;
    Rectangle(double length, double width){
        setLength(length);
        setWidth(width);
    }
    @Override
    public double calculatePerimeter() {
        double perimeter = 2 * (length + width);
        return perimeter;
    }

    @Override
    public double calculateArea() {
        double area = length * width;
        return area;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}