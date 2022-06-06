/**
 * @Author: fengsc
 * @Date: 2022-04-03 09:53:11
 * @LastEditTime: 2022-04-06 12:24:40
 */
interface TriFunction<T, V, U, R> {// 自定义多变量接口
    R apply(T t, V v, U u);
}

public class TriFunctionTest {
    static int f(int i, long l, double d) {
        return 99;
    }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf = TriFunctionTest::f;
        tf = (i, l, d) -> 12;
    }
}