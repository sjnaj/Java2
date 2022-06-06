
/**
 * @Author: fengsc
 * @Date: 2022-04-01 22:54:13
 * @LastEditTime: 2022-04-01 22:58:47
 */
import java.util.*;

public class StackTest {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<String>();
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
        System.out.println();

    }
}
// fleas has dog My 
