/**
 * @Author: fengsc
 * @Date: 2022-06-06 17:10:31
 * @LastEditTime: 2022-06-06 17:10:32
 */
package cake;
import java.util.concurrent.*;
public class Nap {

    public Nap(double t) {
        try {
            TimeUnit.MILLISECONDS.sleep((int) (1000 * t));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Nap(double t, String msg) {
        this(t);
        System.out.println(msg);
    }

}