package Practice1;

public class Triangle implements Shape{
    private double side1;
    private double side2;
    private double side3;
    Triangle(double side1, double side2, double side3){
        setSide1(side1);
        setSide2(side2);
        setSide3(side3);
    }
    public void calculatePerimeter(double base, double height) {
        System.out.println("Not enough info needed");
    }
    @Override
    public double calculatePerimeter() {
        double perimeter = side1 + side2 + side3;
        return perimeter;
    }

    @Override
    public double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
        return area;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
}