package ru.stqa.qeometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculatePerimeter() {
        var p = new Triangle(5.0, 10.0, 15.0);
        double result = p.Perimeter();
        Assertions.assertEquals(30.0, result);
    }

    @Test
    void canCalculateArea() {
        var a = new Triangle(3.0, 4.0, 5.0);
        double result = Math.sqrt(a.Area());
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-5.0, 4.0, 8.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ОК
        }
    }

    @Test
    void cannotCreateTriangleWithBigSum() {
        try {
            new Triangle(10.0, 15.0, 40.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ОК
        }

    }
}
