
/**
 * @Author: fengsc
 * @Date: 2022-04-10 17:39:16
 * @LastEditTime: 2022-04-10 18:02:18
 */
import java.util.stream.*;
import java.util.*;

class Pair {
    private final Character c;
    private final Integer i;

    Pair(Character c, Integer i) {
        this.c = c;
        this.i = i;
    }

    public Character getC() {
        return c;
    }

    public Integer getI() {
        return i;
    }

    @Override
    public String toString() {
        return "Pair(" + c + ", " + i + ")";
    }
}

class RandomPair {
    Random rand = new Random(47);
    // An infinite iterator of random capital letters:
    Iterator<Character> capChars = rand.ints(65, 91)
            .mapToObj(i -> (char) i)// *int 转为character
            .iterator();// *terminal operation.

    public Stream<Pair> stream() {
        return rand.ints(100, 1000).distinct()
                .mapToObj(i -> new Pair(capChars.next(), i));
    }
}

public class MapCollector {
    public static void main(String[] args) {
        Map<Integer, Character> map = new RandomPair().stream()
                .limit(8)
                .collect(
                        Collectors.toMap(Pair::getI, Pair::getC));
        System.out.println(map);
    }
}
/* {688=W, 293=B, 309=C, 761=N, 858=N, 668=G, 622=F, 751=N} */
