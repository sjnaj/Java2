
/**
 * @Author: fengsc
 * @Date: 2022-04-07 10:05:56
 * @LastEditTime: 2022-04-07 12:20:05
 */
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;
import java.util.function.*;

public class RandomWords implements Supplier<String> {
    List<String> words = new ArrayList<String>();
    Random rand = new Random(47);

    RandomWords(String name) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(name));

        for (String line : lines.subList(1, lines.size())) {// 跳过第一行
            for (String word : line.split("[,?.]+")) {// 分隔符分割
                words.add(word);
            }
        }

    }

    @Override
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }

    @Override
    public String toString() {
        return words.stream()
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws Exception {

        System.out.println(Stream
                .generate(new RandomWords("stream/chess.dat"))//把任意Supplier<T> 用于生成 T 类型的流
                .limit(10)//不限制个数会产生流直至内存溢出
                .collect(Collectors.joining(" ")));
    }
}
// Well sir And what leads you to that conclusion Not much of a cheese shop
// really is it And what leads you to that conclusion is it sir And what leads
// you to that conclusion Well