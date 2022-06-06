
/**
 * @Author: fengsc
 * @Date: 2022-04-02 09:04:22
 * @LastEditTime: 2022-04-02 09:21:13
 */
import java.util.*;

public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int r = rand.nextInt(20);
            Integer freq = m.get(r);// Integer，不是int，可能返回null
            m.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(m);
    }

}
/*
 * {0=481, 1=502, 2=489, 3=508, 4=481, 5=503, 6=519, 7=471, 8=468, 9=549,
 * 10=513, 11=531, 12=521, 13=506, 14=477, 15=497, 16=533, 17=509, 18=478,
 * 19=464}
 */
