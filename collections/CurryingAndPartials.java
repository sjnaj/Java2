
/**
 * @Author: fengsc
 * @Date: 2022-04-06 10:11:43
 * @LastEditTime: 2022-04-06 14:16:51
 */
import java.util.function.*;

public class CurryingAndPartials {

  static int uncurried(int a, int b) {
    return a + b;
  }

  static Function<Integer, Function<Integer, Integer>> curry(
      BiFunction<Integer, Integer, Integer> f) {
    return a -> b -> f.apply(a, b);
  }

  Function<String, Function<String, Function<String, String>>> sum = a -> b -> c -> a + b + c;

  public static void main(String[] args) {
    Function<Integer, Function<Integer, Integer>> sum = a -> b -> a + b; // a是参数，b->a+b是返回值
    System.out.println(uncurried(1, 2));
    Function<Integer, Integer> add1 = sum.apply(1);
    System.out.println(add1.apply(2));
    Function<Integer, Function<Integer, Integer>> add2 = curry((a, b) -> a + b);
    System.out.println(add2.apply(1).apply(2));
  }
}
