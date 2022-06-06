/**
 * @Author: fengsc
 * @Date: 2022-04-10 17:10:38
 * @LastEditTime: 2022-04-10 17:21:43
 */
import java.util.stream.*;
import java.util.*;
public class RandInts {
    private static int[] rints=new Random(47).ints(100,1,100).toArray();
    public static IntStream rands(){//每次调用获得相同的流
        return Arrays.stream(rints);
    }
}
