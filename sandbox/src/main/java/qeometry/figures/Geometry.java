package qeometry.figures;

import ru.stqa.Rectangle;
import ru.stqa.Square;
import ru.stqa.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square(7.0));
        Square.printSquareArea(new Square(5.0));
        Square.printSquareArea(new Square(3.0));

        Rectangle.printRectangleArea (3.0, 5.0);
        Rectangle.printRectangleArea(7.0,9.0);


        Triangle.printTrianglePerimeter (new Triangle(2.0, 4.0, 3.0));
        Triangle.printTriangleArea (new Triangle(3.0, 5.0, 4.0));


    }

}
