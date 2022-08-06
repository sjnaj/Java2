/**
 * @Author: fengsc
 * @Date: 2022-08-06 12:06:51
 * @LastEditTime: 2022-08-06 12:08:03
 */
package pets;

public class Pair<K, V> {
    public final K key;
    public final V value;

    public Pair(K k, V v) {
        key = k;
        value = v;
    }

    public K key() {
        return key;
    }

    public V value() {
        return value;
    }

    public static <K, V> Pair<K, V> make(K k, V v) {
        return new Pair<K, V>(k, v);
    }
}
