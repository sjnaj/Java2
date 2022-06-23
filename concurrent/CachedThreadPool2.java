
/**
 * @Author: fengsc
 * @Date: 2022-06-06 13:47:58
 * @LastEditTime: 2022-06-06 14:01:39
 */
import java.util.concurrent.*;
import java.util.*;
import java.util.stream.*;

public class CachedThreadPool2 {
    public static Integer extractResult(Future<Integer> f) {
        try {
            return f.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<CountingTask> tasks = IntStream.range(0, 10)
                .mapToObj(CountingTask::new)
                .collect(Collectors.toList());
        List<Future<Integer>> futures = exec.invokeAll(tasks);
        // 只有在所有任务完成后，invokeAll() 才会返回一个 Future 列表，每个任务一个
        // Future。Future 是 Java 5 中引入的机制，允许你提交任务而无需等待它完成。
        // 使用Future模式,获取数据的时候无法立即得到需要的数据。而是先拿到一个契约,
        // 你可以再将来需要的时候再用这个契约去获取需要的数据,这个契约就好比叫外卖的例子里的外卖订单。

        // 当你的任务在尚未完成的 Future 上调用 get() 时，调用会阻塞（等待）直到结果可用
        // 此处的Future 似乎是多余的，因为 in-
        // vokeAll() 甚至在所有任务完成之前都不会返回。但是，这里的 Future 并不用于延迟
        // 结果，而是用于捕获任何可能发生的异常。
        Integer sum = futures.stream()
                .map(CachedThreadPool2::extractResult)
                .reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
        exec.shutdown();
    }
}
