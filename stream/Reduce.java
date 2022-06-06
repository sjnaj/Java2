
/**
 * @Author: fengsc
 * @Date: 2022-04-10 18:40:11
 * @LastEditTime: 2022-04-10 18:42:16
 */
import java.util.stream.*;
import java.util.*;

class Frobnitz {
    int size;

    Frobnitz(int sz) {
        size = sz;
    }

    @Override
    public String toString() {
        return "Frobnitz(" + size + ")";
    }

    // Generator:
    static Random rand = new Random(47);
    static final int BOUND = 100;

    static Frobnitz supply() {
        return new Frobnitz(rand.nextInt(BOUND));
    }
}

public class Reduce {
    public static void main(String[] args) {
        Stream.generate(Frobnitz::supply)
                .limit(10)
                .peek(System.out::println)
                .reduce((fr0, fr1) -> fr0.size < 50 ? fr0 : fr1)//获取第一个size<50的元素，第一个参数为累积位
                .ifPresent(System.out::println);//提供初值则不用判空
    }

}
// Frobnitz(58)
// Frobnitz(55)
// Frobnitz(93)
// Frobnitz(61)
// Frobnitz(61)
// Frobnitz(29)
// Frobnitz(68)
// Frobnitz(0)
// Frobnitz(22)
// Frobnitz(7)
// Frobnitz(29)
