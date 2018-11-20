package cn.ccs.jdkcomp;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.net.URLClassLoader;

public class MyMain {

    public static void main(String[] args) throws Exception {

        //String strb = "class A { private String aa; public String getAa(){return aa+\"3\"}}";
        String rt = "\r\n";
        String src =
                "public class HelloWorld {" + rt +
                        "    public static void main(String[] args) {" + rt +
                        "        System.out.println(\"Hello,world!\");" + rt +
                        "    }" + rt +
                        "}";
        String fileName = System.getProperty("user.dir") +
                "/src/HelloWorld.java";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();

        //compile
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileMgr.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
        t.call();
        fileMgr.close();

        //load into memory and create an instance
        //URL[] urls = new URL[]{new URL("file:/" + System.getProperty("user.dir") + "/src")};
        URL[] urls = new URL[]{new URL("file:" + System.getProperty("user.dir") + "/src/HelloWorld.class")};
        URLClassLoader ul = new URLClassLoader(urls);

        Class c = ul.loadClass("HelloWorld");

        System.out.println(compiler.getClass().getName());

        System.out.println(c);

    }
}
