
/**
 * @Author: fengsc
 * @Date: 2022-04-03 12:58:40
 * @LastEditTime: 2022-04-03 15:22:01
 */
import java.util.function.*;

public class Closure1 {
    int i;

    Supplier<Integer> makeFun(int x) {
        return () -> x + i++;
    }

    Supplier<Integer> makeFun2(int x) {
        int i = 0;// 必须为final(隐式，被修改时会提示)
        return () -> x + i;// 不能修改final
    }

    Supplier<Integer> makeFun3(int x) {
        int i = 0;
        i++;
        int iFinal = i;
        return () -> x + iFinal;
    }

    public static void main(String[] args) {
        Closure1 c1 = new Closure1();
        Supplier<Integer> f1 = c1.makeFun(0);
        Supplier<Integer> f2 = c1.makeFun(0);
        Supplier<Integer> f3 = c1.makeFun(0);
        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        // 共享c1的i

    }

}
/*
 * 0
 * 1
 * 2
 */
