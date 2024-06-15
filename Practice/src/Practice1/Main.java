package Practice1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Triangle side 1:");
        double side1 = scanner.nextDouble();
        System.out.println("Triangle side 2:");
        double side2 = scanner.nextDouble();
        System.out.println("Triangle side 3:");
        double side3 = scanner.nextDouble();
        Triangle triangle = new Triangle(side1, side2, side3);
        System.out.println("Rectangle length:");
        double length = scanner.nextDouble();
        System.out.println("Rectangle width:");
        double width = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(length, width);
        System.out.println("Circle radius:");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);
        Shape[] shapes = {
                triangle,
                rectangle,
                circle
        };
        try {
            for (Shape x : shapes) {
                System.out.print("Perimeter: ");
                if (x.calculatePerimeter() <= 0) throw new ArithmeticException();
                System.out.println(x.calculatePerimeter());
                System.out.println();
                System.out.print("Area: ");
                if (x.calculateArea() <= 0) throw new ArithmeticException();
                System.out.println(x.calculateArea());
                System.out.println();
            }
        }
        catch(ArithmeticException e){
            System.out.println("Invalid numbers (Either inputting zero, or negative numbers)");
        }
    }
}