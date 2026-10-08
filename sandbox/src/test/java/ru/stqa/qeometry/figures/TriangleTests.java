package ru.stqa.qeometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculatePerimeter(){
         double result = Triangle.trianglePerimeter(5,10,15);
        Assertions.assertEquals(30, result);
    }

    @Test
    void canCalculateArea(){
        double result = Math.sqrt(Triangle.triangleArea(3,4,5));
        Assertions.assertEquals(6, result);
    }
}
