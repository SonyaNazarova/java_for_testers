package ru.stqa.qeometry.figures;

public class Square {
    public static void printSquareArea(double side) {
        String text = String.format("Площадь квадрата со сторной %f = %f", side, squareArea(side));
        System.out.println(text);
    }

    private static double squareArea(double a) {
        return a * a;
    }
}
