
/**
 * @Author: fengsc
 * @Date: 2022-04-09 22:16:08
 * @LastEditTime: 2022-04-09 22:16:08
 */
import java.util.*;
import java.util.stream.*;

    public class Duplicator {
        public static void main(String[] args) {
            Stream.generate(() -> "duplicate")
                    .limit(3)
                    .forEach(System.out::println);
        }
    
}
