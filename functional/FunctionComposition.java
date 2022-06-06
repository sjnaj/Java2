
/**
 * @Author: fengsc
 * @Date: 2022-04-03 16:06:20
 * @LastEditTime: 2022-04-03 16:36:47
 */
import java.util.function.*;

public class FunctionComposition {
    static Function<String, String> f1 = s -> s.replace('A', '_'),
            f2 = s -> s.substring(3),
            f3 = s -> s.toLowerCase(), f4 = f1.compose(f2).andThen(f3);

    public static void main(String[] args) {
        System.out.println(f4.apply("GO AFTER ALL AMBULANCES"));
    }

}
// _fter _ll _mbul_nces//先后调用f2,f1和f3