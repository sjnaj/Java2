
/**
 * @Author: fengsc
 * @Date: 2022-04-10 12:21:56
 * @LastEditTime: 2022-04-10 12:38:39
 */
import java.util.stream.*;

public class FlatMap {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of("Gonzo", "Fozzie", "Beaker"))//从映射返回的每个流都会自动扁平为组成它的字符串。
                .forEach(System.out::println);
    }
}
// Gonzo
// Fozzie
// Beaker
// Gonzo
// Fozzie
// Beaker
// Gonzo
// Fozzie
// Beaker
