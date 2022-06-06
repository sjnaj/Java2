
/**
 * @Author: fengsc
 * @Date: 2022-04-01 23:11:59
 * @LastEditTime: 2022-04-01 23:21:31
 */
import java.util.*;

public class SetOfInteger {
    public static void main(String[] args) {
        Set<Integer> intset = new HashSet<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10000; i++) {
            intset.add(rand.nextInt(30));
        }
        System.out.println(intset);

    }

}
// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29]
