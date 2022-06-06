
/**
 * @Author: fengsc
 * @Date: 2022-04-03 09:58:26
 * @LastEditTime: 2022-04-03 10:16:57
 */
import java.util.function.*;;

public class BiConsumerPermutations {
    static BiConsumer<Integer, Double> bicid = (i, d) -> System.out.format("%d, %f%n", i, d);
    static BiConsumer<Double, Integer> bicdi = (d, i) -> System.out.format("%d, %f%n", i, d);
    static BiConsumer<Integer, Long> bicil = (i, l) -> System.out.format("%d, %d%n", i, l);

    public static void main(String[] args) {
        bicid.accept(47, 11.34);
        bicdi.accept(22.45, 92);
        bicil.accept(1, 11L);
    }

}