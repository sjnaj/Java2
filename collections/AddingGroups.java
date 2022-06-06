
/**
 * @Author: fengsc
 * @Date: 2022-04-01 09:22:41
 * @LastEditTime: 2022-04-01 09:29:14
 */
import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = { 6, 7, 8, 9, 10 };
        collection.addAll(Arrays.asList(moreInts));
        // Runs significantly faster, but you can't
        // construct a Collection this way:
        // 静态方法
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        // Produces a list "backed by" an array:
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99); // OK -- modify an element
        // list.add(21); // Runtime error; the underlying
        // array cannot be resized.
        //*底层是数组，不能修改size
        //*首选方式是构建一个不含元素的Collection,再调用静态方法addAll()初始化，因为它更快
    }

}
