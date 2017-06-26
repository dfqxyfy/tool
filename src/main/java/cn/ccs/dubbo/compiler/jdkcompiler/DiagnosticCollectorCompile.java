package cn.ccs.dubbo.compiler.jdkcompiler;

/**
 * Created by ccs on 2017/6/18.
 */
import java.io.IOException;
import java.util.Arrays;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class DiagnosticCollectorCompile {

    public static void main(String args[]) throws IOException {
        String src = "class MyClass {\n" +
                "  public static void main(String args[]) {\n" +
                "    System.out.println(\"Hello, World\");\n" +
                "  }\n" +
                "}";

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
        Iterable<? extends JavaFileObject> compilationUnits = fileManager
                .getJavaFileObjectsFromStrings(Arrays.asList(src));
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null,
                null, compilationUnits);
        boolean success = task.call();
        fileManager.close();
        System.out.println("Success: " + success);
    }
}