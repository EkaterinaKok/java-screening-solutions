package com.ekaterinakok.screening.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinnerAnalyzerTest {

    private final WinnerAnalyzer analyzer = new WinnerAnalyzer();

    @Test
    @DisplayName("Проверка базового примера")
    void testBaseExample(){
        List<Team> history = List.of(
                Team.fromLine("ANT BORIS CHRIS"),
                Team.fromLine("DENIS EGOR FEDOR"),
                Team.fromLine("BORIS ANT CHRIS"),
                Team.fromLine("ANNA MARIA OSTE"),
                Team.fromLine("CHRIS BORIS ANT")
        );

        int result = analyzer.findMaxVictories(history);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("Проверка на случай, когда все команды победили строго по одному разу")
    void testAllUniqueTeams(){
        List<Team> history = List.of(
                Team.fromLine("A B C"),
                Team.fromLine("D E F"),
                Team.fromLine("G H I"),
                Team.fromLine("K L M"),
                Team.fromLine("N O P")
        );

        int result = analyzer.findMaxVictories(history);

        assertEquals(1, result);
    }

    @Test
    @DisplayName("Проверка на ввод неккоректных данные (устойчивость к пробелам)")
    void testIncorrectData(){
        List<Team> history = List.of(
                Team.fromLine("  A    B C  "),
                Team.fromLine("  D E    F"),
                Team.fromLine("B     C A    "),
                Team.fromLine("K      L M"),
                Team.fromLine("C A    B       ")
        );

        int result = analyzer.findMaxVictories(history);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("Проверка исключений (валидация некорректного формата)")
    void testInvalidFormat(){
        assertThrows(IllegalArgumentException.class, () -> Team.fromLine("K L M Q"));

        assertThrows(IllegalArgumentException.class, () -> Team.fromLine("A B"));

        assertThrows(IllegalArgumentException.class, () -> Team.fromLine("   "));
    }

}
