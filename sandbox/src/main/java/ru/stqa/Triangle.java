package ru.stqa;


import java.util.Objects;

public record  Triangle (double a, double b, double c){

     public Triangle{
         if ( a < 0 || b < 0 || c < 0 ) {
             throw new IllegalArgumentException("Сторона треугольника  не может быть отрицательная");
         }

         if ((a+b) < c || (a+c) < b || (b+c) < a){
             throw new IllegalArgumentException("Cумма двух любых сторон треугольника должна быть не меньше третьей стороны");
         }

     }

     public static void printTrianglePerimeter(Triangle p) {
        var text = String.format("Периметр треугольника со сторонами %f , %f и %f = %f", p.a, p.b, p.c, p.Perimeter());
        System.out.println(text);

        }

            public static void printTriangleArea(Triangle a) {
                var text = String.format("Площадь треугольника со сторонами %f , %f и %f = %f", a.a, a.b, a.c, Math.sqrt(a.Area()));
                System.out.println(text);
            }


     public double Perimeter() {
         return  this.a + this.b + this.c;
     }

     public double Area() {
         return (Perimeter()/2*(Perimeter()/2-a)*(Perimeter()/2-b)*(Perimeter()/2-c));
     }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(this.a, triangle.a) == 0 && Double.compare(this.b, triangle.b) == 0 && Double.compare(this.c, triangle.c) == 0)
                || (Double.compare(this.b, triangle.a) == 0 && Double.compare(this.a, triangle.b) == 0 && Double.compare(this.c, triangle.c) == 0)
                || (Double.compare(this.c, triangle.a) == 0 && Double.compare(this.b, triangle.b) == 0 && Double.compare(this.a, triangle.c) == 0)
                || (Double.compare(this.a, triangle.a) == 0 && Double.compare(this.c, triangle.b) == 0 && Double.compare(this.b, triangle.c) == 0)
                || (Double.compare(this.b, triangle.a) == 0 && Double.compare(this.c, triangle.b) == 0 && Double.compare(this.a, triangle.c) == 0)
                || (Double.compare(this.c, triangle.a) == 0 && Double.compare(this.a, triangle.b) == 0 && Double.compare(this.b, triangle.c) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}
