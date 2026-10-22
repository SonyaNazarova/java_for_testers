package ru.stqa.qeometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.Square;
import ru.stqa.Triangle;

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

    @Test
    void testFail() {
        var s1 = new Square(5.0);
        var s2 = new Square(5.0);
        Assertions.assertTrue(s1.equals(s2));
    }

    @Test
    void testEquality() {
        var t1 = new Triangle(5.0, 4.0, 2.0);
        var t2 = new Triangle(5.0, 4.0, 2.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality2() {
        var t1 = new Triangle(5.0, 4.0, 2.0);
        var t2 = new Triangle(4.0, 2.0, 5.0);
        Assertions.assertEquals(t1, t2);
    }

}
