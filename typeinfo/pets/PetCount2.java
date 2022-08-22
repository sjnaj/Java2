/**
 * @Author: fengsc
 * @Date: 2022-08-06 12:52:12
 * @LastEditTime: 2022-08-06 13:35:37
 */
package pets;

import java.util.*;
import java.util.stream.*;

public class PetCount2 {
    static class TypeCounter extends HashMap<Class<?>, Integer> {
        private Class<?> baseType;

        public TypeCounter(Class<?> baseType) {
            this.baseType = baseType;
        }

        public void count(Object obj) {
            Class<?> type = obj.getClass();
            if (!baseType.isAssignableFrom(type)) {
                throw new RuntimeException(
                        obj + " incorrect type: " + type +
                                ", should be type or subtype of " + baseType);
            }
            countClass(type);
        }

        private void countClass(Class<?> type) {
            Integer quantity = get(type);
            put(type, quantity == null ? 1 : quantity + 1);
            Class<?> superClass = type.getSuperclass();
            if (superClass != null && baseType.isAssignableFrom(superClass)) {
                countClass(superClass);// 沿继承链向上递归调用
            }
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
        TypeCounter counter = new TypeCounter(Pet.class);

        Pets.stream().limit(20).peek(counter::count).forEach(p -> System.out.print(
                p.getClass().getSimpleName() + " "));
        System.out.println("\n" + counter);
    }
}
