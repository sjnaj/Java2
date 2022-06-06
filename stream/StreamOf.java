
/**
 * @Author: fengsc
 * @Date: 2022-04-06 11:52:07
 * @LastEditTime: 2022-04-06 13:53:12
 */
import java.util.stream.*;

public class StreamOf {

  public static void main(String[] args) {
    Stream
        .of("It's ", "a ", "wonderful ", "day ", "for ", "pie!")
        .forEach(System.out::print);

    // System.out.println();
    Stream
        .of(3.14159, 2.718, 1.618)
        .forEach(System.out::println);
  }
}
