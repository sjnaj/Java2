
/**
 * @Author: fengsc
 * @Date: 2022-04-10 17:26:11
 * @LastEditTime: 2022-04-10 17:38:15
 */
import java.util.stream.*;
import java.util.*;
import java.nio.file.*;

public class TreeSetOfWords {
    public static void main(String[] args) throws Exception {
        System.out.println(
                Files
                        .lines(Paths.get("/home/fengsc/Desktop/Java2/stream/TreeSetOfWords.java"))
                        .flatMap(line -> Arrays.stream(line.split("\\W+")))
                        .filter(s -> !s.matches("\\d+"))// 除去数字
                        .map(String::trim)
                        .filter(s -> s.length() > 2)
                        .limit(100)
                        .collect(Collectors.toCollection(TreeSet::new)));// 通用于任意类型
    }

}
/*
 * [Arrays, Author, Collectors, Date, Desktop, Exception, Files, Java2,
 * LastEditTime, Paths, String, System, TreeSet, TreeSetOfWords, args, class,
 * collect, fengsc, file, filter, flatMap, get, home, import, java, length,
 * limit, line, lines, main, map, matches, new, nio, out, println, public,
 * split, static, stream, throws, toCollection, trim, util, void]
 */