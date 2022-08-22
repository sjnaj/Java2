
/**
 * @Author: fengsc
 * @Date: 2022-08-09 09:08:09
 * @LastEditTime: 2022-08-09 11:04:17
 */
import java.lang.reflect.Array;

public class GenericArrayWithTypeToken<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(
                Integer.class, 10);
        // This now works:
        Integer[] ia = gai.rep();//数组的运行时类型是确切的类型 T[]
    }
}