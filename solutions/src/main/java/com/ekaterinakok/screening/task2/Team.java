package com.ekaterinakok.screening.task2;

import java.util.Arrays;
import java.util.Objects;

/**
 * Неизменяемая модель (Value Object) команды из трех человек.
 * <p>
 * Класс автоматически обеспечивает инвариантность к порядку имен участников.
 * При создании объекта имена сортируются в лексикографическом (алфавитном) порядке,
 * что гарантирует корректную работу методов {@link #equals(Object)} и {@link #hashCode()}
 * при использовании объекта в качестве ключа в хэш-таблицах.
 * </p>
 *
 * @param member1 имя первого участника (после сортировки)
 * @param member2 имя второго участника (после сортировки)
 * @param member3 имя третьего участника (после сортировки)
 */
public record Team(String member1, String member2, String member3) {

    /**
     * Канонический конструктор, выполняющий валидацию и сортировку имен.
     *
     * @param member1 имя первого участника
     * @param member2 имя второго участника
     * @param member3 имя третьего участника
     * @throws NullPointerException     если хотя бы одно из имен является {@code null}
     * @throws IllegalArgumentException если хотя бы одно из имен пустое или состоит только из пробелов
     */
    public Team {
        Objects.requireNonNull(member1, "Имя первого участника не может быть null");
        Objects.requireNonNull(member2, "Имя второго участника не может быть null");
        Objects.requireNonNull(member3, "Имя третьего участника не может быть null");

        if (member1.isBlank() || member2.isBlank() || member3.isBlank()) {
            throw new IllegalArgumentException("Имена участников не могут быть пустыми");
        }

        String[] sortedMembers = {member1.trim(), member2.trim(), member3.trim()};
        Arrays.sort(sortedMembers);

        member1 = sortedMembers[0];
        member2 = sortedMembers[1];
        member3 = sortedMembers[2];
    }

    /**
     * Фабричный метод для создания объекта команды из строки.
     * Метод разбивает входящую строку по пробельным символам.
     *
     * @param line строка, содержащая три имени, разделенных пробелами
     * @return новый экземпляр класса {@link Team} с отсортированными именами
     * @throws IllegalArgumentException если строка пуста или содержит не ровно три имени
     */
    public static Team fromLine(String line) {
        if (line == null || line.isBlank()) {
            throw new IllegalArgumentException("Строка ввода не может быть пустой");
        }

        String[] parts = line.trim().split("\\s+");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Команда должна состоять ровно из 3 имен. Получено элементов: " + parts.length);
        }

        return new Team(parts[0], parts[1], parts[2]);
    }

    @Override
    public String toString() {
        return member1 + " " + member2 + " " + member3;
    }
}
