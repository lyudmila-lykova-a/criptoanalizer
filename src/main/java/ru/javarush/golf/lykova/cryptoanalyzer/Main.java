package ru.javarush.golf.lykova.cryptoanalyzer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\lykov\\IdeaProjects\\cryptoanalyzer\\tempTest\\temporaryTest.txt";
        int key = 1;
        FileEncode fileEncode = new FileEncode(fileName, new StringEncode(new CaesarCharEncode(key, true)));
        fileEncode.encode();
    }
}
