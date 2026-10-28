package com.ekaterinakok.screening.task1;

/**
 * Демонстрационный класс для запуска и проверки решения задачи "Перестройка".
 */
public class ReconstructionDemo {

    public static void main(String[] args) {

        System.out.println("=== Задача 1: Перестройка ===");

        OfficeReconstruction reconstruction = new OfficeReconstruction();

        // Пример 1: Прямоугольники стоят рядом
        long area1 = reconstruction.calculateMinSquareArea(2, 3, 5, 7, 5, 3, 8, 6);
        System.out.println("Результат теста 1: " + area1 + " (Ожидается: 36)");

        // Пример 2: Один прямоугольник внутри другого
        long area2 = reconstruction.calculateMinSquareArea(0, 0, 10, 10, 2, 2, 5, 5);
        System.out.println("Результат теста 2: " + area2 + " (Ожидается: 100)");
    }

}
