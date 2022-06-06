
/**
 * @Author: fengsc
 * @Date: 2022-04-10 08:20:40
 * @LastEditTime: 2022-04-10 08:23:41
 */
import java.util.stream.*;

class Peeking {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("/home/fengsc/Desktop/Java2/stream/chess.dat")
                .skip(21)
                .limit(4)
                .map(w -> w + " ")
                .peek(System.out::print)
                .map(String::toUpperCase)
                .peek(System.out::print)
                .map(String::toLowerCase)
                .forEach(System.out::print);
    }

}
