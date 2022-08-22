
/**
 * @Author: fengsc
 * @Date: 2022-08-07 12:49:59
 * @LastEditTime: 2022-08-07 12:50:00
 */
import java.util.*;

public class CountedList extends ArrayList<String> {
    private static int counter = 0;
    private int id = counter++;

    public CountedList() {
        System.out.println("CountedList #" + id);
    }

    public int getId() {
        return id;
    }
}