package ru.javarush.golf.lykova.cryptoanalyzer;

public class StringEncode {

    private final CaesarCharEncode charEncode;

    public StringEncode(CaesarCharEncode charEncode) {
        this.charEncode = charEncode;
    }

    public String encode(String sourceString) {
        StringBuilder result = new StringBuilder();
        for (char letter : sourceString.toCharArray()) {
            result.append(charEncode.encode(letter));
        }
        return result.toString();
    }
}
