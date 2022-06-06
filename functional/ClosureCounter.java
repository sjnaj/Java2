
/**
 * @Author: fengsc
 * @Date: 2022-04-03 15:30:52
 * @LastEditTime: 2022-04-03 16:04:02
 */
import java.util.*;
import java.util.function.*;

public class ClosureCounter {
    Supplier<Integer> getCounter(int start) {
        int[] count = new int[1];
        count[0] = start;
        return () -> count[0] += 1;
    }

    public static void main(String[] args) {
        ClosureCounter c = new ClosureCounter();
        Supplier<Integer> counter = c.getCounter(0);
        for (int i = 0; i < 10; i++) {
            System.out.print(counter.get() + " ");
        }
        System.out.println();
    }

}
// 1 2 3 4 5 6 7 8 9 10