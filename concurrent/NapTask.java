/**
 * @Author: fengsc
 * @Date: 2022-06-06 13:06:54
 * @LastEditTime: 2022-06-06 13:09:17
 */

public class NapTask implements Runnable {
    final int id;

    public NapTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        new Nap(0.1);
        System.out.println(this + " " + Thread.currentThread().getName());

    }

    @Override
    public String toString() {
        return "NapTask[" + id + "]";
    }

}
