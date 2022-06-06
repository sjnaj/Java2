
/**
 * @Author: fengsc
 * @Date: 2022-04-09 22:20:35
 * @LastEditTime: 2022-04-09 22:32:02
 */
import java.util.stream.*;

public class Bubbles {
    public static void main(String[] args) {
        Stream
                .generate(Bubble::bubbler)//与Supplyer接口兼容
                .limit(10)
                .forEach(System.out::println);
    }
}
