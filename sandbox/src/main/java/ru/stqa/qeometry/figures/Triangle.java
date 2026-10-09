package ru.stqa.qeometry.figures;


 public record  Triangle (double a, double b, double c){

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
         return (this.a + this.b + this.c)/2*((this.a + this.b + this.c)/2-a)*((this.a + this.b + this.c)/2-b)*((this.a + this.b + this.c)/2-c);
     }
 }
