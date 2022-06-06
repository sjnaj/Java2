
/**
 * @Author: fengsc
 * @Date: 2022-04-02 10:38:43
 * @LastEditTime: 2022-04-02 10:43:56
 */
import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            queue.offer(rand.nextInt(i + 10));
        }
        QueueDemo.printQ(queue);
        List<Integer> ints = Arrays.asList(25, 22, 20,
                18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        queue = new PriorityQueue<>(ints);
        QueueDemo.printQ(queue);
        queue = new PriorityQueue<>(ints.size(), Collections.reverseOrder());// 初始化容量并修改比较器
        queue.addAll(ints);
        QueueDemo.printQ(queue);

    }

}
/*
 * 0 1 1 1 1 1 3 5 8 14
 * 1 1 2 3 3 9 9 14 14 18 18 20 21 22 23 25 25
 * 25 25 23 22 21 20 18 18 14 14 9 9 3 3 2 1 1
 */
