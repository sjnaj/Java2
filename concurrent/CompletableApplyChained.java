
/**
 * @Author: fengsc
 * @Date: 2022-06-06 16:39:38
 * @LastEditTime: 2022-06-06 18:08:15
 */
import java.util.concurrent.*;

public class CompletableApplyChained {
    public static void main(String[] args){
        Timer timer = new Timer();
        CompletableFuture<Machina> cf=CompletableFuture.completedFuture(new Machina(0))
        .thenApply(Machina::work)
        .thenApply(Machina::work)
        .thenApply(Machina::work)
        .thenApply(Machina::work);
        //同步调用
        System.out.println(timer.duration());

    }
}