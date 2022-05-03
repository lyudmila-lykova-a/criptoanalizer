package ru.javarush.golf.lykova.cryptoanalyzer;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String MENU = "Выберите пункт меню:\n" +
            "\t1. Шифр Цезаря (шифрование)\n" +
            "\t2. Шифр Цезаря (дешифрование)\n" +
            "\t3. Шифр Цезаря (brute force)";


    public static void main(String[] args) throws IOException {
        System.out.println(MENU);
        Scanner scanner = new Scanner(System.in);
        String stringNumber = scanner.nextLine();

        if (stringNumber.equals("1") || stringNumber.equals("2")) {
            System.out.println("Введите имя исходного файла:");
            String inputFileName = scanner.nextLine();
            System.out.println("Введите имя файла с результатом:");
            String outputFileName = scanner.nextLine();
            System.out.println("Введите ключ числом:");
            int key = scanner.nextInt();
            boolean decode = stringNumber.equals("2");
            FileEncode fileEncode = new FileEncode(inputFileName, outputFileName, new StringEncode(new CaesarCharEncode(key, decode)));
            fileEncode.encode();
        } else if (stringNumber.equals("3")) {
            System.out.println("Введите имя зашифрованного файла:");
            String inputFileName = scanner.nextLine();
            System.out.println("Введите имя файла с результатом:");
            String outputFileName = scanner.nextLine();
            BruteForce bruteForce = new BruteForce(inputFileName);
            int key = bruteForce.tryToDecrypt();
            System.out.println("ключ: " + key);
            FileEncode fileEncode = new FileEncode(inputFileName, outputFileName, new StringEncode(new CaesarCharEncode(key, true)));
            fileEncode.encode();
        }
    }

}
