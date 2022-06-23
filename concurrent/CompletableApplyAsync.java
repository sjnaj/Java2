
/**
 * @Author: fengsc
 * @Date: 2022-06-06 16:43:25
 * @LastEditTime: 2022-06-06 18:10:37
 */
import java.util.concurrent.*;

public class CompletableApplyAsync {
    public static void main(String[] args) {
        Timer timer = new Timer();
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(
                new Machina(0))
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work);
            //异步调用，构建速度快，时间主要花费在join处，无须等待前一个任务完成即可布置后一个任务，最后在join处等待完成
        System.out.println(timer.duration());
        System.out.println(cf.join());//异步不join会提前结束
        System.out.println(timer.duration());
    }
}