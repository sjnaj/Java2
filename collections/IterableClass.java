
/**
 * @Author: fengsc
 * @Date: 2022-04-02 14:07:40
 * @LastEditTime: 2022-04-02 14:09:45
 */
import java.util.*;

public class IterableClass implements Iterable<String> {
    protected String[] words = ("And that is how " +
            "we know the Earth to be banana-shaped.").split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }

            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };

    }

    public static void main(String[] args) {
        for (String s : new IterableClass())// 实现Iteratable接口或数组可以使用for in 遍历
            System.out.print(s + " ");
    }
}
// And that is how we know the Earth to be banana-shaped.