
/**
 * @Author: fengsc
 * @Date: 2022-04-10 15:21:49
 * @LastEditTime: 2022-04-10 16:44:11
 */
import java.util.stream.*;
import java.util.*;
import java.util.function.*;

public class OptionalFilter {
    static String[] elements = { "Foo", "", "Bar", "Baz", "Bingo" };

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Predicate<String> pred) {
        System.out.println(" ---( " + descr + " )---");
        for (int i = 0; i <= elements.length; i++) {//i=length时，skip后获得空流，输出作为间隔标识
            System.out.println(
                    testStream()
                            .skip(i)
                            .findFirst()
                            .filter(pred));
        }
    }

    public static void main(String[] args) {
        test("true", str -> true);
        test("false", str -> false);
        test("str != \"\"", str -> str != "");
        test("str.length() == 3", str -> str.length() == 3);
        test("startsWith(\"B\")",
                str -> str.startsWith("B"));
    }
}
/*
 * ---( true )---
 * Optional[Foo]
 * Optional[]
 * Optional[Bar]
 * Optional[Baz]
 * Optional[Bingo]
 * Optional.empty
 * ---( false )---
 * Optional.empty
 * Optional.empty
 * Optional.empty
 * Optional.empty
 * Optional.empty
 * Optional.empty
 * ---( str != "" )---
 * Optional[Foo]
 * Optional.empty
 * Optional[Bar]
 * Optional[Baz]
 * Optional[Bingo]
 * Optional.empty
 * ---( str.length() == 3 )---
 * Optional[Foo]
 * Optional.empty
 * Optional[Bar]
 * Optional[Baz]
 * Optional.empty
 * Optional.empty
 * ---( startsWith("B") )---
 * Optional.empty
 * Optional.empty
 * Optional[Bar]
 * Optional[Baz]
 * Optional[Bingo]
 * Optional.empty
 */