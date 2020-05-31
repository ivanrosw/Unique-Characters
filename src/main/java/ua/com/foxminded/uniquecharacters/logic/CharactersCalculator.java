package ua.com.foxminded.uniquecharacters.logic;

import java.util.*;

public class CharactersCalculator {

    private static final String NEXT_STRING_PATTERN = "\n";
    private static final String QUOTES = "\"";
    private static final String DASH = " - ";


    private Map<String, String> cache = new HashMap<>();

    private static CharactersCalculator instance;

    private CharactersCalculator() {

    }

    public String getUniqueCharacters(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("String is empty or null");
        }

        return cache.computeIfAbsent(text, k -> calculateCharacters(k));
    }

    private String calculateCharacters(String text) {
        Map<String, Integer> charsCountMap = new LinkedHashMap<>();
        Arrays.asList(text.split("")).forEach(stringChar -> charsCountMap
                .merge(stringChar, 1, Integer::sum));

        StringBuilder result = new StringBuilder();
        result.append(text + NEXT_STRING_PATTERN);
        charsCountMap.forEach((stringChar, amount) -> result
                .append(QUOTES + stringChar + QUOTES + DASH + amount + NEXT_STRING_PATTERN));

        return result.toString();
    }

    public static CharactersCalculator getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new CharactersCalculator();
            return instance;
        }
    }
}
