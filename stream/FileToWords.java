
/**
 * @Author: fengsc
 * @Date: 2022-04-10 09:11:07
 * @LastEditTime: 2022-04-10 14:11:47
 */
import java.nio.file.*;
import java.util.stream.*;
import java.util.regex.Pattern;
import java.util.*;

public class FileToWords {
    public static Stream<String> stream(String filePath) throws Exception {
        return Files.lines(Paths.get(filePath))
                .skip(1) // First (comment) line
                .flatMap(line -> Pattern.compile("\\W+").splitAsStream(line));//返回流可以无须存储内容，扁平化操将二维流转化为一维
                //等价于.flatMap(line->Arrays.stream(line.split("\\W+")));
                //等价于.line->line.split("\\W+").flatMap(Arrays::stream)
    }
}