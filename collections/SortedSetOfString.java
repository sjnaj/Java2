
/**
 * @Author: fengsc
 * @Date: 2022-04-01 23:22:15
 * @LastEditTime: 2022-04-01 23:22:15
 */
import java.util.*;

public class SortedSetOfString {
    public static void main(String[] args) {
        Set<String> colors = new TreeSet<>();
        for (int i = 0; i < 100; i++) {
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Red");
            colors.add("Red");
            colors.add("Orange");
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Purple");
        }
        System.out.println(colors);
    }
}
// [Blue, Orange, Purple, Red, Yellow]