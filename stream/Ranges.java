/**
 * @Author: fengsc
 * @Date: 2022-04-07 12:34:16
 * @LastEditTime: 2022-04-07 12:38:26
 */
import static java.util.stream.IntStream.*;
public class Ranges {
        public static void main(String[] args) {
            //传统方法
            int result =0;
            for(int i = 1; i<10;i++){
                result+=i;
            }
            System.out.println(result);
            //for in
            result=0;
            for(int i : range(1,10).toArray()){
                result+=i;
            }
            System.out.println(result);
            //stream
            System.out.println(range(1,10).sum());
            
        }
}