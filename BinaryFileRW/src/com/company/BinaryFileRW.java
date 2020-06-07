package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BinaryFileRW {
    File file;

    BinaryFileRW(String path) {
        file = new File(path);
    }
    BinaryFileRW(){}

    int [] readInts() {
        byte[] byteInput = new byte[(int) file.length()];
        int[] ints = new int[byteInput.length / 4];
        try {
            FileInputStream fis = new FileInputStream(file);
            fis.read(byteInput, 0, byteInput.length);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteBuffer.wrap(byteInput).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().get(ints);
        return ints;
    }

    void writeInts(String path ,int [] ints){
        ByteBuffer outBuf = ByteBuffer.allocate(ints.length*4);
        outBuf.order(ByteOrder.LITTLE_ENDIAN);
        for(int i = 0; i<ints.length; i++){
            outBuf.putInt(ints[i]);
        }

        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(outBuf.array(), 0, ints.length*4);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}