
/**
 * @Author: fengsc
 * @Date: 2022-06-06 13:09:50
 * @LastEditTime: 2022-06-06 13:28:29
 */
import java.util.concurrent.*;
import java.util.stream.*;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Timer timer=new Timer();
        IntStream.range(0, 10)
                .mapToObj(NapTask::new)
                .forEach(exec::execute);
        System.out.println("All tasks submitted");
        exec.shutdown();// no new tasks will be accepted.
        while (!exec.isTerminated()) {//Returns true if all tasks have completed following shut down.
            System.out.println(Thread.currentThread().getName() + " awaiting termination");
            new Nap(0.1);

        }
        System.out.println(timer.duration());//1137

    }
}