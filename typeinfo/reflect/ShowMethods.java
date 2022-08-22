
/**
 * @Author: fengsc
 * @Date: 2022-08-06 19:47:04
 * @LastEditTime: 2022-08-07 15:54:30
 */
package reflect;

import java.lang.reflect.*;
import java.util.regex.*;

import java.util.*;

public class ShowMethods {
    private static String usage = "usage:\n" +
            "ShowMethods qualified.class.name\n" +
            "To show all methods in class or:\n" +
            "ShowMethods qualified.class.name word\n" +
            "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile("\\w+\\.");
    private static int i=0;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        args = scanner.nextLine().split(" ");
        if (args[0] == "") {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor<?>[] ctors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods)
                    System.out.println(
                            p.matcher(
                                    method.toString()).replaceAll(""));// 去除前缀 等价于 method.replaceAll("\\w+\\.","")
                for (Constructor<?> ctor : ctors)
                    System.out.println(
                            p.matcher(ctor.toString()).replaceAll(""));
                lines = methods.length + ctors.length;
            } else {
                for (Method method : methods)
                    if (method.toString().contains(args[1])) {
                        System.out.println(p.matcher(
                                method.toString()).replaceAll(""));
                        lines++;
                    }
                for (Constructor<?> ctor : ctors)
                    if (ctor.toString().contains(args[1])) {

                        System.out.println(p.matcher(
                                ctor.toString()).replaceAll(""));
                        lines++;
                    }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
        scanner.close();
    }

}