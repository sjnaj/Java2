
/**
 * @Author: fengsc
 * @Date: 2022-04-03 10:34:36
 * @LastEditTime: 2022-04-03 10:43:51
 */
import java.util.function.*;

class I {
    @Override
    public String toString() {
        return "I";
    }
}

class O {
    @Override
    public String toString() {
        return "O";
    }
}

public class TransformFunction {
    static Function<I, O> transform(Function<I, O> function) {
        return function.andThen(o -> {
            System.out.println(o);
            return o;
        });//将function执行的结果赋给o,compose与andThen相反
    }

    public static void main(String[] args) {
        Function<I, O> function = transform(i -> {
            System.out.println(i);
            return new O();
        });
        O o = function.apply(new I());
    }

}
/*
 * I
 * O
 */