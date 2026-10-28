package com.ekaterinakok.screening.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OfficeReconstructionTest {

    private final OfficeReconstruction reconstruction = new OfficeReconstruction();

    @Test
    @DisplayName("Проверка расчета площади для смежных отделов")
    void testAdjacentOffices() {
        long result = reconstruction.calculateMinSquareArea(2, 3, 5, 7, 5, 3, 8, 6);
        assertEquals(36, result);
    }

    @Test
    @DisplayName("Проверка случая, когда один отдел полностью включает в себя другой")
    void testNestedOffices() {
        long result = reconstruction.calculateMinSquareArea(0, 0, 5, 5, 1, 1, 3, 3);
        assertEquals(25, result);
    }

    @Test
    @DisplayName("Проверка работы с отрицательными координатами")
    void testNegativeCoordinates() {
        long result = reconstruction.calculateMinSquareArea(-5, -3, -2, 1, -3, -1, 2, 4);
        assertEquals(49, result);
    }

    @Test
    @DisplayName("Проверка частичного пересечения отделов (в форме креста)")
    void testPartialIntersection() {
        long result = reconstruction.calculateMinSquareArea(0, 2, 10, 4, 4, 0, 6, 8);
        assertEquals(100, result);
    }

}
