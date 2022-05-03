package ru.javarush.golf.lykova.cryptoanalyzer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce {

    private final String fileName;

    public BruteForce(String fileName) {
        this.fileName = fileName;
    }

    public int tryToDecrypt() throws IOException {
        String encodedText = Files.readString(Path.of(fileName), StandardCharsets.UTF_8);

        long maxProbability = 0;
        int key = 0;
        for (int i = 0; i < CaesarCharEncode.ALPHABET.length(); i++) {
            StringEncode stringEncode = new StringEncode(new CaesarCharEncode(i, true));
            String resultString = stringEncode.encode(encodedText);
            long decryptionProbability = correctDecryptionProbability(resultString);
            if (decryptionProbability > maxProbability) {
                maxProbability = decryptionProbability;
                key = i;
            }
        }
        return key;
    }


    private long correctDecryptionProbability(String encodedText) {
        Pattern pattern = Pattern.compile("( [а-я]{2,7} )|([а-я]{2,}[.,!?\"] )");
        Matcher countEmailMatcher = pattern.matcher(encodedText);
        return countEmailMatcher.results().count();
    }

}
