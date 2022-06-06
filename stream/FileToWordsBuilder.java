
/**
 * @Author: fengsc
 * @Date: 2022-04-09 22:48:24
 * @LastEditTime: 2022-04-10 12:57:30
 */
import java.io.*;
import java.util.stream.*;
import java.nio.file.*;

public class FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(String filePath) throws IOException {
        Files.lines(Paths.get(filePath))
                .skip(1) // 略过开头的注释行
                .forEach(line -> {
                    for (String w : line.split("[ .?,]+"))
                        builder.add(w);
                });
    }

    Stream<String> stream() {
        return builder.build();//调用后就不能修改原builder了，并且这种方式失去了流无须存储的特点
    }

    public static void main(String[] args) throws Exception {
        new FileToWordsBuilder("/home/fengsc/Desktop/Java2/stream/chess.dat")
                .stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}