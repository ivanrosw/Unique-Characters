package ua.com.foxminded.uniquecharacters.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharactersCalculatorTest {

    @Test
    void TestGetUniqueCharacters_ShouldCalculateUniqueCharacters_WhenInputText() {
        CharactersCalculator charactersCalculator = CharactersCalculator.getInstance();
        String expected = "hello world!\n" +
                "\"h\" - 1\n" +
                "\"e\" - 1\n" +
                "\"l\" - 3\n" +
                "\"o\" - 2\n" +
                "\" \" - 1\n" +
                "\"w\" - 1\n" +
                "\"r\" - 1\n" +
                "\"d\" - 1\n" +
                "\"!\" - 1\n";
        String actual = charactersCalculator.getUniqueCharacters("hello world!");
        assertEquals(expected, actual);
    }

    @Test
    void TestGetUniqueCharacters_ShouldThrowsIllegalArgumentException_WhenInputEmptyString() {
        CharactersCalculator charactersCalculator = CharactersCalculator.getInstance();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            charactersCalculator.getUniqueCharacters("");
        });
    }

    @Test
    void TestGetUniqueCharacters_ShouldThrowsIllegalArgumentException_WhenInputNull() {
        CharactersCalculator charactersCalculator = CharactersCalculator.getInstance();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            charactersCalculator.getUniqueCharacters("");
        });
    }

    @Test
    void TestGetUniqueCharacters_ShouldCalculateDifferentCharacters_WhenInputCharactersWithDifferentCase() {
        CharactersCalculator charactersCalculator = CharactersCalculator.getInstance();
        String expected = "oooOOOooo\n" +
                "\"o\" - 6\n" +
                "\"O\" - 3\n";
        String actual = charactersCalculator.getUniqueCharacters("oooOOOooo");
        assertEquals(expected, actual);
    }

    @Test
    void TestGetUniqueCharacters_ShouldCalculateUniqueCharacters_WhenInputTextWithMixedCharacters() {
        CharactersCalculator charactersCalculator = CharactersCalculator.getInstance();
        String expected = "ooobbbaaaaooobbbaaa\n" +
                "\"o\" - 6\n" +
                "\"b\" - 6\n" +
                "\"a\" - 7\n";
        String actual = charactersCalculator.getUniqueCharacters("ooobbbaaaaooobbbaaa");
        assertEquals(expected, actual);
    }

    @Test
    void TestGetUniqueCharacters_ShouldCalculateUniqueCharacters_WhenInputTextContainsOnlySpecificSymbols() {
        CharactersCalculator charactersCalculator = CharactersCalculator.getInstance();
        String expected = "!!/\\$%#&*\n" +
                "\"!\" - 2\n" +
                "\"/\" - 1\n" +
                "\"\\\" - 1\n" +
                "\"$\" - 1\n" +
                "\"%\" - 1\n" +
                "\"#\" - 1\n" +
                "\"&\" - 1\n" +
                "\"*\" - 1\n";
        String actual = charactersCalculator.getUniqueCharacters("!!/\\$%#&*");
        assertEquals(expected, actual);
    }

    @Test
    void TestGetUniqueCharacters_ShouldCalculateUniqueCharacters_WhenInputTextContainsOnlyNumbers() {
        CharactersCalculator charactersCalculator = CharactersCalculator.getInstance();
        String expected = "112233235556417 6623 12 5\n" +
                "\"1\" - 4\n" +
                "\"2\" - 5\n" +
                "\"3\" - 4\n" +
                "\"5\" - 4\n" +
                "\"6\" - 3\n" +
                "\"4\" - 1\n" +
                "\"7\" - 1\n" +
                "\" \" - 3\n";
        String actual = charactersCalculator.getUniqueCharacters("112233235556417 6623 12 5");
        assertEquals(expected, actual);
    }

    @Test
    void TestGetUniqueCharacters_ShouldCalculateUniqueCharacters_WhenInputTextContainsOnlySpaceSymbols() {
        CharactersCalculator charactersCalculator = CharactersCalculator.getInstance();
        String expected = "    \n" +
                "\" \" - 4\n";
        String actual = charactersCalculator.getUniqueCharacters("    ");
        assertEquals(expected, actual);
    }

    @Test
    void TestGetInstance_ShouldReturnSameObject_WhenTryingGetInstance() {
        CharactersCalculator expected = CharactersCalculator.getInstance();
        CharactersCalculator actual = CharactersCalculator.getInstance();
        assertEquals(expected, actual);
    }

    //тест на символы, цифры, пробелы
}
