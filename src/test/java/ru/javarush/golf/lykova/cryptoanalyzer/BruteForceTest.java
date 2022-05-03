package ru.javarush.golf.lykova.cryptoanalyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class BruteForceTest {

    @Test
    public void bruteForceCase1Success_test() throws IOException, URISyntaxException {
        // given
        URL resource = getClass().getClassLoader().getResource("BruteForseSource.txt.encoded");
        String fileName = Paths.get(resource.toURI()).toString();
        BruteForce bruteForce = new BruteForce(fileName);
        // when
        int key = bruteForce.tryToDecrypt();
        // then
        Assertions.assertEquals(3, key);
    }

    @Test
    public void bruteForceCase2Success_test() throws IOException, URISyntaxException {
        // given
        URL resource = getClass().getClassLoader().getResource("Remark.BruteForseSource2.txt.encoded");
        String fileName = Paths.get(resource.toURI()).toString();
        BruteForce bruteForce = new BruteForce(fileName);
        // when
        int key = bruteForce.tryToDecrypt();
        // then
        Assertions.assertEquals(4, key);
    }
}
