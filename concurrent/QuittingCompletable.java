
/**
 * @Author: fengsc
 * @Date: 2022-06-06 14:46:25
 * @LastEditTime: 2022-06-06 15:14:49
 */
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class QuittingCompletable {
    public static void main(String[] args) {
        List<QuitableTask> tasks = IntStream.range(1, QuittingTasks.COUNT)
                .mapToObj(QuitableTask::new)
                .collect(Collectors.toList());
        List<CompletableFuture<Void>> cfutures = tasks.stream()
                .map(CompletableFuture::runAsync)
                .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuitableTask::quit);
        cfutures.forEach(CompletableFuture::join);
        // 在创建 cfutures 期间，每个任务都交给 CompletableFuture::runAsync。这执
        // 行 VerifyTask.run() 并返回 CompletableFuture<Void> 。因为 run() 不返回任何内
        // 容，所以在这种情况下只使用 CompletableFuture 调用 join() 来等待它完成。

    }
}
