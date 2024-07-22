/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package net.zelmak.spring.templates;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author zelmak
 */
public class SpringBootJdbcTemplates {

    static class ClassInfo {

        String idClass = "Integer";
        String className = "User";
        String classNamePlural = "Users";
        String initialLowerClassName = "user";
        String initialLowerClassNamePlural = "users";
        String packagePath = "net.zelmak.spring.model";
    }

    public static void main(String[] args) throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        ClassInfo t = new ClassInfo();
        String[] filenames = {"RepositoryTemplate.jt", "ServiceTemplate.jt", "ControllerTemplate.jt"};
        
        System.out.println("--- cut line ---");
        
        for (String filename : filenames) {
            System.out.println();
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(filename)));
            for (String line; (line = br.readLine()) != null;) {
                sb.append(line).append("\n");
            }

            String x = applyTemplate(sb.toString(), t);

            System.out.println(x);

            System.out.println("--- cut line ---");
        }
    }

    private static String applyTemplate(String x, ClassInfo t) {
        x = x.replace("${className}", t.className);
        x = x.replace("${classNamePlural}", t.classNamePlural);
        x = x.replace("${initialLowerClassName}", t.initialLowerClassName);
        x = x.replace("${initialLowerClassNamePlural}", t.initialLowerClassNamePlural);
        x = x.replace("${idClass}", t.idClass);
        x = x.replace("${packagePath}", t.packagePath);
        return x;
    }
}
