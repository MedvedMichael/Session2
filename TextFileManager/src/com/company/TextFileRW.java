package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileRW {
    File file;

    TextFileRW(String path) {
        file = new File(path);
    }

    ArrayList<String> getLines() {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(this.file);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return lines;
    }

    ArrayList<String> getLines(int numberOfLines) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(this.file);
            for (int i = 0; i < numberOfLines; i++) {
                if (!scanner.hasNextLine())
                    break;
                lines.add(scanner.nextLine());
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return lines;
    }

    void writeToFile(String path, ArrayList<String> lines) {
        String text = "";
        for (String line : lines)
            text += line + "\n";

        writeToFile(path, text);

    }

    void writeToFile(String path, String text) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.append(text);
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


}
