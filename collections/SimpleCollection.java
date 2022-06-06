/**
 * @Author: fengsc
 * @Date: 2022-04-01 09:12:38
 * @LastEditTime: 2022-04-01 09:14:47
 */
import java .util.*;
public class SimpleCollection {
public static void main(String[] args){
    Collection<Integer> c = new ArrayList<>();
    for(int i=0;i<10;i++) c.add(i);
    for(Integer i:c){
        System.out.print(i+" ,");
    }
    System.out.println();
}


    
}
