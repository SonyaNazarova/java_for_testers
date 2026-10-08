package ru.stqa.qeometry.figures;


 public record Triangle(double a, double b, double c){

            public static void printTrianglePerimeter(double a, double b, double c) {
        var text = String.format("Периметр треугольника со сторонами %f , %f и %f = %f", a, b, c, trianglePerimeter(a,b,c));
        System.out.println(text);

        }
            public static double trianglePerimeter(double a, double b, double c) {
                return a+b+c;
            }

            public static void printTriangleArea(double a, double b, double c) {
                var text = String.format("Площадь треугольника со сторонами %f , %f и %f = %f", a, b, c, Math.sqrt(triangleArea(a,b,c)));
                System.out.println(text);
            }

            public static double triangleArea(double a, double b, double c) {
                return (a+b+c)/2*((a+b+c)/2-a)*((a+b+c)/2-b)*((a+b+c)/2-c);
            }


 }
