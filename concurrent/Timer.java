/**
 * @Author: fengsc
 * @Date: 2022-06-06 10:19:55
 * @LastEditTime: 2022-06-06 10:29:33
 */
import static java.util.concurrent.TimeUnit.*;

public class Timer {
  private long start = System.nanoTime();
  public long duration() {
    return NANOSECONDS.toMillis(
      System.nanoTime() - start);
  }
  public static long duration(Runnable test) {
    Timer timer = new Timer();
    test.run();
    return timer.duration();
  }
}
