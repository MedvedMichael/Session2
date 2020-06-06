package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        TextFileRW manager = new TextFileRW("input.txt");
        ArrayList<String> lines = manager.getLines(5);
        for (String line : lines) {
            System.out.println(line);
        }

        manager.writeToFile("output.txt", lines);
    }
}
