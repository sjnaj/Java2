
/**
 * @Author: fengsc
 * @Date: 2022-06-06 14:34:09
 * @LastEditTime: 2022-06-06 14:41:19
 */
import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

public class QuittingTasks {
    public static final int COUNT = 150;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<QuitableTask> tasks = IntStream.range(1, COUNT)
                .mapToObj(QuitableTask::new)
                .peek(qt -> exec.execute(qt))
                .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuitableTask::quit);
        exec.shutdown();
        // 只要任何任务仍在运行，就会阻止程序退出。即使为每个任务
        // 按顺序调用 quit() 方法，任务也不会按照它们创建的顺序关闭。独立运行的任务不会确
        // 定性地响应信号。
    }
}
