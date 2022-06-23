
/**
 * @Author: fengsc
 * @Date: 2022-06-06 11:32:55
 * @LastEditTime: 2022-06-06 11:53:49
 */
import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.concurrent.atomic.*;

public class ParallelStreamPuzzle2 {
    public static final Deque<String> TRACE = new ConcurrentLinkedDeque<String>();

    static class IntGenerator implements Supplier<Integer> {
        private AtomicInteger current = new AtomicInteger();

        @Override
        public Integer get() {
            TRACE.add(current.get() + ": " + Thread.currentThread().getName());
            return current.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        List<Integer> x = Stream.generate(new IntGenerator())
                .limit(10)
                .parallel()
                .collect(Collectors.toList());
        Stream.generate(new IntGenerator())
                .limit(10)
                .parallel()
                .forEach(number -> System.out.println(number));
            //都是乱序
        System.out.println(x);
        System.out.println(TRACE);
    }
}
