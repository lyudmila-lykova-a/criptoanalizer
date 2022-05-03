package ru.javarush.golf.lykova.cryptoanalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CaesarCharEncodeHelper {

    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,”:-!? ";

    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Path.of("C:\\Users\\lykov\\IdeaProjects\\cryptoanalyzer\\tempTest\\BruteForseSource.txt"));
        List<String> result = new ArrayList<>();
        for (String string : strings) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : string.toCharArray()) {
                if (ALPHABET.indexOf(Character.toLowerCase(c)) >= 0) {
                    stringBuilder.append(c);
                }
            }
            result.add(stringBuilder.toString());
        }
        Files.write(Path.of("C:\\Users\\lykov\\IdeaProjects\\cryptoanalyzer\\tempTest\\BruteForseSource.txt.cleared"), result);
    }

}
