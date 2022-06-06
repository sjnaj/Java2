
/**
 * @Author: fengsc
 * @Date: 2022-04-09 22:18:41
 * @LastEditTime: 2022-04-09 22:18:42
 */
import java.util.function.*;

public class Bubble {
    public final int i;

    public Bubble(int n) {
        i = n;
    }

    @Override
    public String toString() {
        return "Bubble(" + i + ")";
    }

    private static int count = 0;

    public static Bubble bubbler() {
        return new Bubble(count++);
    }
}