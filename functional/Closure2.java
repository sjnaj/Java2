
/**
 * @Author: fengsc
 * @Date: 2022-04-03 13:58:40
 * @LastEditTime: 2022-04-03 15:29:31
 */
import java.util.function.*;
import java.util.*;

public class Closure2 {
    Supplier<List<Integer>> makeFun() {
        List<Integer> li = new ArrayList<Integer>();
        li.add(1);
        //li=new ArrayList<Integer>();不能修改引用
        return () -> li;
    }
    public static void main(String[] args){
        Closure2 c=new Closure2();
        List<Integer> li = c.makeFun().get();
        li.add(2);
        li.add(3);
        System.out.println(li);
    }
}
// [1, 2, 3]
