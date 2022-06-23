
/**
 * @Author: fengsc
 * @Date: 2022-06-06 14:07:26
 * @LastEditTime: 2022-06-06 14:33:09
 */
import java.util.concurrent.atomic.AtomicBoolean;

public class QuitableTask implements Runnable {
    final int id;

    public QuitableTask(int id) {
        this.id = id;
    }

    private AtomicBoolean running = new AtomicBoolean(true);

    public void quit() {
        running.set(false);
    }
    @Override
    public void run() {
        while(running.get()) {
            new Nap(0.1);
        }
        System.out.println(id+" ");
    }

}
