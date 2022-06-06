
/**
 * @Author: fengsc
 * @Date: 2022-04-01 10:06:35
 * @LastEditTime: 2022-04-02 11:34:45
 */
import java.util.*;

public class PrintingCollections {
    static Collection<String> fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map<String, String>fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }

    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<>()));
        System.out.println(fill(new LinkedList<>()));
        System.out.println(fill(new HashSet<>()));
        System.out.println(fill(new TreeSet<>()));
        System.out.println(fill(new LinkedHashSet<>()));


        System.out.println(fill(new HashMap<>()));
        System.out.println(fill(new TreeMap<>()));
        System.out.println(fill(new LinkedHashMap<>()));
    }
}
/*
 * [rat, cat, dog, dog]
 * [rat, cat, dog, dog]
 * [rat, cat, dog]//此三同下
 * [cat, dog, rat]
 * [rat, cat, dog]
 * {rat=Fuzzy, cat=Rags, dog=Spot}//查找最快
 * {cat=Rags, dog=Spot, rat=Fuzzy}//键值升序
 * {rat=Fuzzy, cat=Rags, dog=Spot}//插入顺序
 */