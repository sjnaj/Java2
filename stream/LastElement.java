
/**
 * @Author: fengsc
 * @Date: 2022-04-10 19:32:33
 * @LastEditTime: 2022-04-10 20:23:04
 */
import java.util.*;
import java.util.stream.*;

public class LastElement {
    public static void main(String[] args) {
        OptionalInt last = IntStream.range(10, 20)
                .reduce((n1, n2) -> n2);
        System.out.println(last.orElse(-1));
        // Non-numeric object:
        Optional<String> lastobj = Stream.of("one", "two", "three")
                .reduce((n1, n2) -> n2);
        System.out.println(
                lastobj.orElse("Nothing there!"));
        //注意Optional的类型
    }
}
