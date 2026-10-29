package com.ekaterinakok.screening.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервисный класс для анализа истории олимпиад и определения команд-лидеров.
 * <p>
 * Класс реализует алгоритм попарного сравнения составов команд в соответствии
 * с официальным разбором задачи. Порядок участников внутри команд стандартизирован
 * лексикографически, что позволяет выполнять прямое посимвольное сопоставление.
 * </p>
 */
public class WinnerAnalyzer {

    /**
     * Список команд, набравших максимальное количество побед на текущий момент анализа.
     * Использование списка позволяет корректно обрабатывать ситуации, когда сразу несколько
     * разных составов разделили между собой первое место по количеству побед.
     */
    private final List<Team> bestTeams = new ArrayList<>();

    /**
     * Анализирует историю побед и находит максимальное количество триумфов для одного состава.
     * <p>
     * Алгоритм имеет квадратичную асимптотику {@code O(N^2)} по времени, сравнивая каждую
     * команду со всеми остальными элементами списка. Дополнительная память составляет {@code O(1)}
     * (за исключением результирующего списка лидеров), что полностью укладывается в ограничения задачи.
     * </p>
     *
     * @param teams список всех команд-победителей за N лет (порядок имен внутри команд значения не имеет)
     * @return максимальное число побед, одержанных одной и той же командой;
     * возвращает {@code 0}, если переданный список пуст или равен {@code null}
     */
    public int findMaxVictories(List<Team> teams) {
        if (teams == null || teams.isEmpty()) {
            return 0;
        }

        int globalMax = 0;
        int n = teams.size();

        this.bestTeams.clear();

        for (int i = 0; i < n; i++) {
            Team currentTeam = teams.get(i);
            int currentCount = 0;

            for (int j = 0; j < n; j++) {
                if (currentTeam.equals(teams.get(j))) {
                    currentCount++;
                }
            }

            if (currentCount > globalMax) {
                globalMax = currentCount;
                bestTeams.clear();
                bestTeams.add(currentTeam);

            } else if (currentCount == globalMax && !bestTeams.contains(currentTeam)) {
                bestTeams.add(currentTeam);
            }
        }

        return globalMax;
    }

    /**
     * Возвращает список команд, которые побеждали максимальное количество раз.
     * <p>
     * Метод возвращает неизменяемую копию списка, чтобы предотвратить случайную
     * модификацию внутренних данных класса извне (принцип инкапсуляции).
     * </p>
     *
     * @return {@link List} объектов {@link Team}, набравших больше всего побед;
     * список будет пустым, если метод {@link #findMaxVictories(List)} еще не вызывался.
     */
    public List<Team> getBestTeams() {
        return List.copyOf(bestTeams);
    }
}

