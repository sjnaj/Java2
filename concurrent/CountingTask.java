
/**
 * @Author: fengsc
 * @Date: 2022-06-06 13:36:56
 * @LastEditTime: 2022-06-06 13:45:14
 */

public class CountingTask implements java.util.concurrent.Callable<Integer>{//会与自定义的callable混淆
    final int id;

    public CountingTask(int id) {
        this.id = id;
    }

    @Override
    public Integer call() {
        Integer val = 0;
        for (int i = 0; i < 100; i++)
            val++;
        System.out.println(id + " " +
                Thread.currentThread().getName() + " " + val);
        return val;
    }

}
