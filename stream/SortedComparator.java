
/**
 * @Author: fengsc
 * @Date: 2022-04-10 08:25:41
 * @LastEditTime: 2022-04-10 13:09:24
 */
import java.util.*;

public class SortedComparator {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("/home/fengsc/Desktop/Java2/stream/chess.dat")
                .skip(10)
                .limit(10)
                .sorted(Comparator.reverseOrder())//也可传入lambda实现自定义
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}