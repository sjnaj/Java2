
/**
 * @Author: fengsc
 * @Date: 2022-04-02 14:17:40
 * @LastEditTime: 2022-04-02 16:51:57
 */
import java.util.*;

class ReversibleArrayList<T> extends ArrayList<T> {
    ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    public Iterable<T> reversed() {
        return new Iterable<T>() {// Iterable的主要方法就是iterator
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;

                    public boolean hasNext() {
                        return current > -1;
                    }

                    public T next() {
                        return get(current--);
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<T> randomized() {
        return new Iterable<T>() {

            public Iterator<T> iterator() {
                List<T> shuffled = new ArrayList<T>(ReversibleArrayList.this);//访问外部类并拷贝,避免修改原对象
                Collections.shuffle(shuffled);
                return shuffled.iterator();

            }
        };
    }

    public static void main(String[] args) {
        ReversibleArrayList<String> list = new ReversibleArrayList<String>(
                Arrays.asList("To be or not to be".split(" ")));
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : list.reversed()) {
            System.out.print(s + " ");
        }
        System.out.println();
        for(String s : list.randomized()) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

}
// To be or not to be 
// be to not or be To 
// To be not to or be 