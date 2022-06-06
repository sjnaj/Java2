
/**
 * @Author: fengsc
 * @Date: 2022-04-10 13:43:35
 * @LastEditTime: 2022-04-10 13:52:38
 */
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Optionals {
    static void basics(Optional<String> optString) {
        if (optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("Nothing inside");
        }

    }

    static void ifPresent(Optional<String> optString) {
        optString.ifPresent(System.out::println);
    }

    static void orElse(Optional<String> optString) {
        System.out.println(optString.orElse("Nada"));
    }

    static void orElseGet(Optional<String> optString) {
        System.out.println(
                optString.orElseGet(() -> "Generated"));
    }

    static void orElseThrow(Optional<String> optString) {
        try {
            System.out.println(optString.orElseThrow(
                    () -> new Exception("Supplied")));
        } catch (Exception e) {
            System.out.println("Caught " + e);
        }
    }

    static void test(String testName, Consumer<Optional<String>> cos) {
        System.out.println(" === " + testName + " === ");
        cos.accept(Stream.of("Epithets").findFirst());
        cos.accept(Stream.<String>empty().findFirst());
    }

    public static void main(String[] args) {
        test("basics", Optionals::basics);
        test("ifPresent", Optionals::ifPresent);
        //调用替代行为
        test("orElse", Optionals::orElse);
        test("orElseGet", Optionals::orElseGet);
        test("orElseThrow", Optionals::orElseThrow);
    }

}
/*
 * === basics ===
 * Epithets
 * Nothing inside
 * === ifPresent ===
 * Epithets
 * === orElse ===
 * Epithets
 * Nada
 * === orElseGet ===
 * Epithets
 * Generated
 * === orElseThrow ===
 * Epithets
 * Caught java.lang.Exception: Supplied
 */