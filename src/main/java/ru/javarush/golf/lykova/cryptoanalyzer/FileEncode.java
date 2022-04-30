package ru.javarush.golf.lykova.cryptoanalyzer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileEncode {

    public final String fileName;
    public final StringEncode stringEncode;

    public FileEncode(String fileName, StringEncode stringEncode) {
        this.fileName = fileName;
        this.stringEncode = stringEncode;
    }

    public void encode() throws IOException {
        List<String> lineList = Files.readAllLines(Path.of(fileName));
        List<String> encodedLineList = new ArrayList<>();
        for (String line : lineList) {
            encodedLineList.add(stringEncode.encode(line));
        }
        Files.write(Path.of(fileName + ".encoded"), encodedLineList, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
    }
}
