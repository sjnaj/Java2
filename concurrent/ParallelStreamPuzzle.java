
/**
 * @Author: fengsc
 * @Date: 2022-06-06 10:41:56
 * @LastEditTime: 2022-06-06 11:31:31
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
        Stream.generate(new IntGenerator())
                .limit(100)
                .parallel()
                .forEach(number -> System.out.println(number + "  " + Thread.currentThread().getName()));
        // 乱序

        Timer timer = new Timer();

        List<Integer> x = Stream.generate(new IntGenerator())
                .limit(100)
                .parallel()
                .collect(Collectors.toList());// sequential and parallel executions produce equivalent results
        // 顺序
        System.out.println(timer.duration());
        System.out.println(x);

    }
}
