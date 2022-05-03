package ru.javarush.golf.lykova.cryptoanalyzer;

public class CaesarCharEncode {

    public static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";

    private final int key;


    public CaesarCharEncode(int key) {
        this.key = key;
    }

    public CaesarCharEncode(int key, boolean decode) {
        this.key = decode ? -key : key;
    }

    public char encode(char sourceChar) {

        char lowerChar = Character.toLowerCase(sourceChar);
        int index = ALPHABET.indexOf(lowerChar);
        if (index == -1) {
            return ' ';
        }

        return offsetFrom(index);
    }

    private char offsetFrom(int index) {
        int newIndex = (index + key) % ALPHABET.length();

        if (newIndex < 0) {
            return ALPHABET.charAt(ALPHABET.length() + newIndex);
        } else {
            return ALPHABET.charAt(newIndex);
        }
    }
}
