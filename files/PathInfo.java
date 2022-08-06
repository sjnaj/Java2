
/**
 * @Author: fengsc
 * @Date: 2022-06-23 20:53:17
 * @LastEditTime: 2022-08-05 17:57:06
 */
import java.nio.file.*;
import java.net.URI;
import java.io.IOException;

public class PathInfo {
    static void show(String id, Object p) {
        System.out.println(id + ":" + p);
    }

    static void info(Path p) {
        show("toString", p);
        show("Exists", Files.exists(p));
        show("RegularFile", Files.isRegularFile(p));
        show("Directory", Files.isDirectory(p));
        show("Absolute", p.isAbsolute());
        show("FileName", p.getFileName());
        show("Parent", p.getParent());
        show("Root", p.getRoot());
        System.out.println("******************");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        info(Paths.get("home", "fengsc", "Desktop", "Java2", "primes.txt"));
        Path p = Paths.get("files/PathInfo.java");
        info(p);
        Path ap = p.toAbsolutePath();
        info(ap);
        info(ap.getParent());
        try {
            info(p.toRealPath());

        } catch (IOException e) {
            System.out.println(e);
        }
        URI u = p.toUri();// URI，是统一资源标识符，用来唯一的标识一个资源。
                          // 而URL是统一资源定位器，它是一种具体的URI，即URL可以用来标识一个资源，而且还指明了如何locate这个资源。
        System.out.println("URI: " + u);
        Path puri = Paths.get(u);
        System.out.println(Files.exists(puri));

    }
}
