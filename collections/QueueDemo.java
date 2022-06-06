
/**
 * @Author: fengsc
 * @Date: 2022-04-02 09:55:36
 * @LastEditTime: 2022-04-02 20:37:29
 */
import java.util.*;

public class QueueDemo {
    public static void printQ(Queue<? extends Object> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            q.offer(rand.nextInt(i + 10));//尾部插入
        }
        printQ(q);
        Queue<Character>cq=new LinkedList<>();
        for(char c:"lalallaninin".toCharArray()){//split("")返回的是String组
            cq.offer(c);
        }
        printQ(cq);
    }

}
/*8 1 1 1 5 14 3 1 0 1 
l a l a l l a n i n i n */
