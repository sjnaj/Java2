
/**
 * @Author: fengsc
 * @Date: 2022-04-10 18:53:38
 * @LastEditTime: 2022-04-10 19:23:46
 */
import java.util.stream.*;
import java.util.function.*;


interface Matcher extends BiPredicate<Stream<Integer>, Predicate<Integer>> {
}

public class Maching {
    static void show(Matcher matcher, int val) {
        System.out.println(
                matcher.test(IntStream.rangeClosed(1, 9)
                        .boxed()// *装箱因为第二个参数predicate函数需要Integer作为参数
                        .peek(i -> System.out.format("%d ", i))// 打印,演示短路效果
                        , i -> i < val));
    }

    public static void main(String[] args) {
        show(Stream::allMatch, 10);
        show(Stream::allMatch, 4);
        show(Stream::anyMatch, 2);
        show(Stream::anyMatch, 0);
        show(Stream::noneMatch, 5);
        show(Stream::noneMatch, 0);
    }
}
/*
 * 1 2 3 4 5 6 7 8 9 true
 * 1 2 3 4 false
 * 1 true
 * 1 2 3 4 5 6 7 8 9 false
 * 1 false
 * 1 2 3 4 5 6 7 8 9 true
 */