
/**
 * @Author: fengsc
 * @Date: 2022-06-23 21:05:45
 * @LastEditTime: 2022-06-23 21:25:39
 */
import java.nio.file.*;

public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("files/PartsOfPaths.java").toAbsolutePath();
        for (int i = 0; i < p.getNameCount(); i++) {
            System.out.println(p.getName(i));
        }
        System.out.println("ends with '.java': " +
                p.endsWith(".java"));//endsWith比较的是路径部分，不包含后缀
    }
}