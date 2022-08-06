
/**
 * @Author: fengsc
 * @Date: 2022-08-05 17:23:53
 * @LastEditTime: 2022-08-05 18:03:45
 */
import java.lang.reflect.InvocationTargetException;
import java.util.function.*;
import java.util.stream.*;

class CountedInteger {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}

public class DynamicSupplier<T> implements Supplier<T> {
    private Class<T> type;

    public DynamicSupplier(Class<T> type) {
        this.type = type;
    }
    @Override
    public T get(){
        try {
            return type.getDeclaredConstructor().newInstance();// 可以使用含参构造
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException
                | SecurityException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Stream
                .generate(new DynamicSupplier<>(CountedInteger.class))
                .skip(10)
                .limit(5)
                .forEach(System.out::println);
    }

}
