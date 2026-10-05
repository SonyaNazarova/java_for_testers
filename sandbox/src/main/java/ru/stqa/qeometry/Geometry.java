package ru.stqa.qeometry;

import ru.stqa.qeometry.figures.Rectangle;
import ru.stqa.qeometry.figures.Square;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square(7.0));
        Square.printSquareArea(new Square(5.0));
        Square.printSquareArea(new Square(3.0));

        Rectangle.printRectangleArea (3.0, 5.0);
        Rectangle.printRectangleArea(7.0,9.0);
    }

}
