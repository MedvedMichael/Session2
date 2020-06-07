package com.company;

public class Main {

    public static void main(String[] args) {
        BinaryFileRW binaryFileRW = new BinaryFileRW();
        binaryFileRW.writeInts("output", new int[]{1, 2, 3, 4, 5, 6, 7, 8987, 573844539});
        binaryFileRW = new BinaryFileRW("output");
        int [] ints = binaryFileRW.readInts();
        for(int number:ints)
            System.out.println(number);
    }
}
