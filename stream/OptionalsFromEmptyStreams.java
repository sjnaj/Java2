
/**
 * @Author: fengsc
 * @Date: 2022-04-10 13:20:21
 * @LastEditTime: 2022-04-10 13:28:04
 */
import java.util.*;
import java.util.stream.*;

public class OptionalsFromEmptyStreams {
    public static void main(String[] args) {
        System.out.println(Stream.<String>empty().findFirst());
        System.out.println(Stream.<String>empty().findAny());
        System.out.println(Stream.<String>empty().max(String.CASE_INSENSITIVE_ORDER));
        System.out.println(Stream.<String>empty().min(String.CASE_INSENSITIVE_ORDER));
        System.out.println(Stream.<String>empty()
                .reduce((s1, s2) -> s1 + s2));
        System.out.println(IntStream.empty()
                .average());
    }
    
}
// Optional.empty
// Optional.empty
// Optional.empty
// Optional.empty
// Optional.empty
// OptionalDouble.empty