package com.ekaterinakok.screening.task1;

/**
 * Класс для расчета минимальной площади квадратной площадки,
 * способной вместить два исходных прямоугольных офисных отдела.
 */
public class OfficeReconstruction {

    /**
     * Вычисляет минимальную площадь квадратной зоны, покрывающей оба прямоугольника.
     *
     * @param x1_1 левая нижняя координата x первого прямоугольника
     * @param y1_1 левая нижняя координата y первого прямоугольника
     * @param x1_2 правая верхняя координата x первого прямоугольника
     * @param y1_2 правая верхняя координата y первого прямоугольника
     * @param x2_1 левая нижняя координата x второго прямоугольника
     * @param y2_1 левая нижняя координата y второго прямоугольника
     * @param x2_2 правая верхняя координата x второго прямоугольника
     * @param y2_2 правая верхняя координата y второго прямоугольника
     * @return минимальная площадь обновленной квадратной площадки
     */
    public long calculateMinSquareArea(long x1_1, long y1_1, long x1_2, long y1_2,
                                       long x2_1, long y2_1, long x2_2, long y2_2) {

        // Находим границы общего прямоугольника (Bounding Box)
        long minX = Math.min(Math.min(x1_1, x1_2), Math.min(x2_1, x2_2));
        long maxX = Math.max(Math.max(x1_1, x1_2), Math.max(x2_1, x2_2));
        long minY = Math.min(Math.min(y1_1, y1_2), Math.min(y2_1, y2_2));
        long maxY = Math.max(Math.max(y1_1, y1_2), Math.max(y2_1, y2_2));

        // Вычисляем ширину и высоту описывающего прямоугольника
        long width = maxX - minX;
        long height = maxY - minY;

        // Сторона квадрата должна быть равна наибольшей из сторон прямоугольника
        long squareSide = Math.max(width, height);

        // Возвращаем площадь квадрата
        return squareSide * squareSide;
    }

}
