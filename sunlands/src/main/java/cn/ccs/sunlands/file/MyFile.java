package cn.ccs.sunlands.file;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyFile {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
        File f = new File(System.getProperty("user.home")+"/abcde.txt");
        if(!f.exists()){
            //f.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(f);

        outputStream.write("abcddfd".getBytes());
        outputStream.flush();
        System.out.println(f.getAbsolutePath());
        System.out.println(f.exists());
    }

    public void my(){

    }
}
