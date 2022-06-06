/**
 * @Author: fengsc
 * @Date: 2022-04-02 20:01:57
 * @LastEditTime: 2022-04-03 12:09:18
 */
import java.util.function.*;
public class Fibonacci {
    Function<Integer, Integer>fib;

    Fibonacci() {
        fib = n -> n == 0 ? 0 : n == 1 ? 1 : fib.apply(n - 1) + fib.apply(n - 2);
    }

    public int fibonacci(int n) {
        return fib.apply(n);
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        for (int i = 0; i < 10; i++) {
            // System.out.println(f.fib.call(i));
            System.out.println(f.fibonacci(i));
        }
    }
}
