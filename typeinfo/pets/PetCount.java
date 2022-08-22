/**
 * @Author: fengsc
 * @Date: 2022-08-06 11:59:50
 * @LastEditTime: 2022-08-06 12:15:55
 */
package pets;

import java.util.*;
import java.util.stream.*;

public class PetCount {
    static class Counter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        Counter() {
            super(LiteralPetCreator.ALL_TYPES.stream().map(lpc -> Pair.make(lpc, 0))
                    .collect(Collectors.toMap(Pair::key, Pair::value)));
        }

        public void count(Pet pet) {
            entrySet().stream().filter(entry -> entry.getKey().isInstance(pet))
                    .forEach(entry -> put(entry.getKey(), entry.getValue() + 1));
        }

        @Override
        public String toString() {
            String result = entrySet().stream()
                    .map(pair -> String.format("%s=%s",
                            pair.getKey().getSimpleName(),
                            pair.getValue()))
                    .collect(Collectors.joining(", "));
            return "{" + result + "}";
        }
    }

    public static void main(String[] args) {
        Counter petCount = new Counter();
        Pets.stream()
                .limit(20)
                .peek(petCount::count)
                .forEach(p -> System.out.print(
                        p.getClass().getSimpleName() + " "));
        System.out.println("\n" + petCount);
    }
}
