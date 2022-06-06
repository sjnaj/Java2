
/**
 * @Author: fengsc
 * @Date: 2022-04-02 08:35:37
 * @LastEditTime: 2022-04-02 09:00:53
 */
import java.util.*;
import java.nio.file.*;

public class UniqueWords {
    public static void main(String[] args) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("/home/fengsc/Desktop/Java2/collections/SetOperations.java"));

        Set<String> words = new TreeSet<String>();
        for (String line : lines) {
            for (String word : line.split("\\W+")) {// 以单词字符分割
                if (word.length() > 0) {//排除分割产生的空字符(相邻两个非单词字符之间)
                    words.add(word);
                }
            }
        }
        System.out.println(words);
    }
}