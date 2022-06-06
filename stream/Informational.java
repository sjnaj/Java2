
/**
 * @Author: fengsc
 * @Date: 2022-04-10 22:25:31
 * @LastEditTime: 2022-04-10 22:26:31
 */
import java.util.stream.*;
import java.util.function.*;

public class Informational {
        public static void main(String[] args) throws Exception {
                System.out.println(
                                FileToWords.stream("/home/fengsc/Desktop/Java2/stream/chess.dat").count());
                System.out.println(
                                FileToWords.stream("/home/fengsc/Desktop/Java2/stream/chess.dat")
                                                .min(String.CASE_INSENSITIVE_ORDER)
                                                .orElse("NONE"));
                System.out.println(
                                FileToWords.stream("/home/fengsc/Desktop/Java2/stream/chess.dat")
                                                .max(String.CASE_INSENSITIVE_ORDER)
                                                .orElse("NONE"));
        }
}
/*
 * 32
 * a
 * you
 */