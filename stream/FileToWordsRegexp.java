
/**
 * @Author: fengsc
 * @Date: 2022-04-09 23:39:59
 * @LastEditTime: 2022-04-10 08:19:46
 */
import java.util.stream.*;
import java.util.*;
import java.nio.file.*;
import java.io.*;
import java.util.regex.Pattern;

public class FileToWordsRegexp {
    private String all;

    public FileToWordsRegexp(String path) throws Exception {
        all = Files.lines(Paths.get(path))
                .skip(1)
                .collect(Collectors.joining(" "));
    }

    public Stream<String> stream() {//可以不断获取流，缺点是必须储存all
        return Pattern.compile("[ ,.?]+")
                .splitAsStream(all);//接收字符串输出流
    }

    public static void main(String[] args) throws Exception {
        FileToWordsRegexp fw = new FileToWordsRegexp("/home/fengsc/Desktop/Java2/stream/chess.dat");
        System.out.println(fw.stream().limit(7).collect(Collectors.joining(" ")));
        System.out.println(fw.stream().skip(7).limit(2).collect(Collectors.joining(" ")));

    }
}
// Not much of a cheese shop really
// is it