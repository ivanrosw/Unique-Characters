package ua.com.foxminded.uniquecharacters;

import ua.com.foxminded.uniquecharacters.logic.CharactersCalculator;

public class UniqueCharacters {

    public static void main(String[] args) {
        CharactersCalculator charactersCalculator = CharactersCalculator.getInstance();
        System.out.println(charactersCalculator.getUniqueCharacters("hello world!"));
        System.out.println(charactersCalculator.getUniqueCharacters("hello world!"));
        System.out.println(charactersCalculator.getUniqueCharacters(""));
        System.out.println(charactersCalculator.getUniqueCharacters(null));
    }
}
