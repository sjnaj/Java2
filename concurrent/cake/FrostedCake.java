
/**
 * @Author: fengsc
 * @Date: 2022-06-06 17:18:23
 * @LastEditTime: 2022-06-06 18:05:38
 */
package cake;

import java.util.concurrent.*;
import java.util.stream.*;

final class Frosting {
    private Frosting() {
    }

    static CompletableFuture<Frosting> make() {
        new Nap(0.1);
        return CompletableFuture
                .completedFuture(new Frosting());
    }
}

public class FrostedCake {

    public FrostedCake(Baked baked, Frosting frosting) {
        new Nap(0.1);
    }

    @Override
    public String toString() {
        return "FrostedCake";
    }

    public static void main(String[] args) {
        Baked.batch().forEach(
                baked -> baked
                        .thenCombineAsync(Frosting.make(),
                                (cake, frosting) -> new FrostedCake(cake, frosting))
                        //第一个函数参数的返回值和调用参数作为第二个函数的参数
                        //返回一个CompletableFuture<FrostedCake>
                        .thenAcceptAsync(System.out::println)
                        //返回一个CompletableFuture<Void> 
                        .join());
    }

}
