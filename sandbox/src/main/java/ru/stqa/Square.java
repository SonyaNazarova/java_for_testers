package ru.stqa;

public record Square (double side){

public Square{
    if (side < 0) {
        throw new IllegalArgumentException("Сторона квадрата не должна быть отрицательная");
    }
}

    public static void printSquareArea(Square s) {
        String text = String.format("Площадь квадрата со сторной %f = %f", s.side, s.area());
        System.out.println(text);
    }

    public static void printSquarePerimeter(Square s) {
        String text = String.format("Периметр квадрата со сторной %f = %f", s.side, s.perimeter());
        System.out.println(text);
    }


    public double area() {
        return this.side * this.side;
    }

    public double perimeter() {
        return 4*this.side;
    }
}
