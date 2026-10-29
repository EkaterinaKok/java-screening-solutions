package com.ekaterinakok.screening.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Главный запускаемый класс для демонстрации решения задачи "Победители".
 * <p>
 * В данной версии класс использует фиксированный набор входных данных.
 * Это позволяет быстро проверять корректность
 * алгоритма локально в IDE без необходимости ручного ввода.
 * </p>
 */
public class WinnersDemo {

    /**
     * Точка входа в приложение. Инициализирует список тестовых команд,
     * передает его в анализатор бизнес-логики и выводит результаты в консоль.
     */
    public static void main(String[] args) {

        String[] mockInputLines = {
                "ANT  BORIS CHRIS",
                "DENIS EGOR FEDOR",
                "BORIS ANT  CHRIS",
                "ANNA MARIA OSTE",
                "CHRIS BORIS ANT"
        };

        try {
            List<Team> teams = new ArrayList<>(mockInputLines.length);

            for (String line : mockInputLines) {
                if (line != null && !line.isBlank()) {
                    teams.add(Team.fromLine(line));
                }
            }

            WinnerAnalyzer analyzer = new WinnerAnalyzer();
            int result = analyzer.findMaxVictories(teams);

            System.out.println("--- Анализ результатов ---");
            System.out.println("Макс. побед: " + result);
            System.out.println("Лучший состав(ы): " + analyzer.getBestTeams());

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка обработки тестовых данных: " + e.getMessage());
            System.out.println(0);
        }
    }
}