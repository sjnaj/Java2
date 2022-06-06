
/**
 * @Author: fengsc
 * @Date: 2022-04-09 23:33:46
 * @LastEditTime: 2022-04-09 23:35:13
 */
import java.util.stream.*;
import java.util.*;

public class ArrayStreams {

    public static void main(String[] args) {
        Arrays.stream(new double[] { 3.14159, 2.718, 1.618 })
                .forEach(n -> System.out.format("%f ", n));
        System.out.println();
        Arrays.stream(new int[] { 1, 3, 5 })
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        Arrays.stream(new long[] { 11, 22, 44, 66 })
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        // 选择一个子域:
        Arrays.stream(new int[] { 1, 3, 5, 7, 15, 28, 37 }, 3, 6)//3，6指定区间
                .forEach(n -> System.out.format("%d ", n));
    }

}
// 3.141590 2.718000 1.618000 
// 1 3 5 
// 11 22 44 66 
// 7 15 28 