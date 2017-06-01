package com.ccs.learning.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ccs on 2017/6/1.
 */
public class GetChannel {
    public static void main(String[] args) throws Exception {
        File f = new File("data.txt");
        System.out.println(f.getAbsolutePath());
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("some text".getBytes()));
        fc.close();
        fc = new RandomAccessFile("data.txt", "rw").getChannel();

        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("some more".getBytes()));
        fc.close();

        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fc.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }
        fc.close();
        System.out.println();
        System.out.println("......................");
        fc = new FileInputStream("data.txt").getChannel();
        buffer = ByteBuffer.allocate(7);
        while(fc.read(buffer)!=-1){
            buffer.flip();
            System.out.print(new String(buffer.array()));
            //buffer.clear();
        }
    }
}
