
/**
 * @Author: fengsc
 * @Date: 2022-04-10 17:18:14
 * @LastEditTime: 2022-04-10 17:22:48
 */
import java.util.stream.*;
import java.util.*;

public class ForEach {
    static final int SZ = 14;

    public static void main(String[] args) {
        RandInts.rands()
                .limit(SZ)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        RandInts.rands()
                .limit(SZ)
                .parallel()
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        RandInts.rands()
                .limit(SZ)
                .parallel()
                .forEachOrdered(n -> System.out.format("%d ", n));//*使并行情况下输出顺序保持一致
    }
}
/*
 * 75 90 32 66 23 12 2 60 28 14 76 31 31 41
 * 31 41 76 66 90 32 75 14 60 28 2 23 31 12
 * 75 90 32 66 23 12 2 60 28 14 76 31 31 41
 */