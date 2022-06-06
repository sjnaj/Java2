
/**
 * @Author: fengsc
 * @Date: 2022-04-09 22:41:26
 * @LastEditTime: 2022-04-09 22:45:38
 */
import java.util.stream.*;

public class Fibonacci2 {
    int x=1;

    Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {
            int result = x + i;
            x = i;
            return result;//作为下一个i
        });
    }

    public static void main(String[] args) {
        new Fibonacci2()
                .numbers()
                .skip(20)
                .limit(10)
                .forEach(System.out::println);
    }

}
