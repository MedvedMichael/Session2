package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String text = getText();
        String path = "output.txt";

        writeEncryptedText(text, path);

        String encodedText = getTextFromFile(path);
        System.out.println(encodedText);

        String decodedText = decodeText(encodedText);
        System.out.println(decodedText);

    }

    static String decodeText(String text) {
        TextEncoder encoder = new TextEncoder();
        return encoder.decryptText(text);
    }

    static String getTextFromFile(String path) {
        TextFileRW manager = new TextFileRW(path);
        String text = manager.getLines().get(0);
        return text;
    }

    static void writeEncryptedText(String text, String path) {
        TextFileRW manager = new TextFileRW();
        TextEncoder encoder = new TextEncoder();
        String encodedText = encoder.encryptText(text);
        manager.writeToFile(path, encodedText);
    }

    static String getText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input text: ");
        String text = scanner.nextLine();
        return text;
    }
}
