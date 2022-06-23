
/**
 * @Author: fengsc
 * @Date: 2022-06-06 17:13:57
 * @LastEditTime: 2022-06-06 17:17:33
 */
package cake;

import java.util.concurrent.*;
import java.util.stream.*;

public class Baked {
    static class Pan {
    }

    static Pan pan(Batter b) {
        new Nap(0.1);
        return new Pan();
    }

    static Baked heat(Pan p) {
        new Nap(0.1);
        return new Baked(); 
    }

    static CompletableFuture<Baked> bake(CompletableFuture<Batter> cfb) {
        return cfb
                .thenApplyAsync(Baked::pan)
                .thenApplyAsync(Baked::heat);
    }

    public static Stream<CompletableFuture<Baked>> batch() {
        CompletableFuture<Batter> batter = Batter.mix();
        //单批面糊放入四个平底锅烘烤
        return Stream.of(
                bake(batter),
                bake(batter),
                bake(batter),
                bake(batter));
    }

}