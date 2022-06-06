
/**
 * @Author: fengsc
 * @Date: 2022-04-10 12:40:09
 * @LastEditTime: 2022-04-10 12:47:56
 */
import java.util.*;
import java.util.stream.*;

public class StreamOfRandoms {
    static Random rand = new Random(47);

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
                .flatMapToInt(i -> IntStream.concat(rand.ints(0, 100).limit(i), IntStream.of(-1)))
                .forEach(i -> System.out.format("%d ", i));
    }
}
// 58 -1 55 93 -1 61 61 29 -1 68 0 22 7 -1 88 28 51 89 9 -1