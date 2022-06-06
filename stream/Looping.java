
/**
 * @Author: fengsc
 * @Date: 2022-04-07 12:47:32
 * @LastEditTime: 2022-04-09 19:09:20
 */
// import static Repeat.repeat;
// 这是 Java 设计的行为方式。默认包只是有一些意想不到的行为，这也是鼓励程序员永远不要使用默认包的原因之一。
// 不同的classpath可能会导致类混淆
public class Looping {
    static void hi() {
        System.out.println("Hi!");
    }

    public static void main(String[] args) {
        Repeat.repeat(3, () -> System.out.println("Looping!"));
        Repeat.repeat(2, Looping::hi);
    }

}
