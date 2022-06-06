
/**
 * @Author: fengsc
 * @Date: 2022-06-06 10:15:25
 * @LastEditTime: 2022-06-06 10:34:12
 */
import java.util.*;
import java.util.stream.*;
import static java.util.stream.LongStream.*;
import java.io.*;
import java.nio.file.*;

public class ParallelPrime {
    static final int COUNT = 100_000;

    public static boolean isPrime(long n) {
        return rangeClosed(2, (long) Math.sqrt(n)).noneMatch(i -> n % i == 0);
    }

    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();
        List<String> primes =

                iterate(2, i -> i + 1)
                        .parallel()
                        .filter(ParallelPrime::isPrime)
                        .limit(COUNT)
                        .mapToObj(Long::toString)
                        .collect(Collectors.toList());
        System.out.println(timer.duration());// 843，注释掉paraller时是1455
        Files.write(Paths.get("primes.txt"), primes, StandardOpenOption.CREATE);

    }

}
