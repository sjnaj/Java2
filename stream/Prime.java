
/**
 * @Author: fengsc
 * @Date: 2022-04-10 08:37:01
 * @LastEditTime: 2022-04-10 14:13:09
 */
import java.util.stream.*;
import static java.util.stream.LongStream.*;//静态导入

public class Prime {
    public static boolean isPrime(long n) {
        return rangeClosed(2, (long) Math.sqrt(n))// 注意强制转换为整形,上界小于下界则为空流
                .noneMatch(i -> n % i == 0);//If the stream is empty then true is returned and the predicate is not evaluated.
    }

    public LongStream numbers() {
        return iterate(2, i -> i + 1)
                .filter(Prime::isPrime);
    }

    public static void main(String[] args) {
        new Prime().numbers()
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        new Prime().numbers()
                .skip(90)
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
    }
}
// 2 3 5 7 11 13 17 19 23 29 
// 467 479 487 491 499 503 509 521 523 541 