/**
 * @Author: fengsc
 * @Date: 2022-06-06 17:07:38
 * @LastEditTime: 2022-06-06 17:12:14
 */
package cake;

import java.util.concurrent.*;

public class Batter {
    static class Eggs {
    }

    static class Milk {
    }

    static class Sugar {
    }

    static class Flour {
    }

    static <T> T prepare(T ingredient) {
        new Nap(0.1);
        return ingredient;
    }

    static <T> CompletableFuture<T> prep(T ingredient) {
        return CompletableFuture
                .completedFuture(ingredient)
                .thenApplyAsync(Batter::prepare);
    }

    public static CompletableFuture<Batter> mix() {
        CompletableFuture<Eggs> eggs = prep(new Eggs());
        CompletableFuture<Milk> milk = prep(new Milk());
        CompletableFuture<Sugar> sugar = prep(new Sugar());
        CompletableFuture<Flour> flour = prep(new Flour());
        CompletableFuture
                .allOf(eggs, milk, sugar, flour)
                .join();
        new Nap(0.1); // Mixing time
        return CompletableFuture.completedFuture(new Batter());
    }

}
