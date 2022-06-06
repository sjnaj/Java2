
/**
 * @Author: fengsc
 * @Date: 2022-04-07 12:39:24
 * @LastEditTime: 2022-04-09 19:38:37
 */
import static java.util.stream.IntStream.*;//必须static导入才能直接访问static对象

public class Repeat {
    public static void repeat(int n, Runnable action) {
        range(0, n).forEach(i -> action.run());//forEach只接收consumer
    }

}