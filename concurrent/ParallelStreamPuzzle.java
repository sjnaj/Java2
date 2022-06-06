
/**
 * @Author: fengsc
 * @Date: 2022-06-06 10:41:56
 * @LastEditTime: 2022-06-06 10:58:11
 */
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ParallelStreamPuzzle {
    static class IntGenerator implements Supplier<Integer> {
        private int current = 0;

        @Override
        public Integer get() {
            return current++;
        }
    }
    public static void main(String[] args) {
        List<Integer> x = Stream.generate(new IntGenerator())
                .limit(10)
                .parallel()
                .collect(Collectors.toList());
        System.out.println(x);
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        listOfNumbers.parallelStream()
                .forEach(number -> System.out.println(number + " " + Thread.currentThread().getName()));
    }
}
