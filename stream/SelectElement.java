
/**
 * @Author: fengsc
 * @Date: 2022-04-10 19:28:23
 * @LastEditTime: 2022-04-10 19:31:30
 */


public class SelectElement {
    public static void main(String[] args) {
        //使用自定义rands使得每组的随机数都一样
        System.out.println(RandInts.rands().findFirst().getAsInt());//*需要解包
        System.out.println(
                RandInts.rands().parallel().findFirst().getAsInt());
        System.out.println(RandInts.rands().findAny().getAsInt());

        System.out.println(
                RandInts.rands().parallel().findAny().getAsInt());//*并行情况下findAny不一定选择第一个
    }
}
// 75
// 75
// 75
// 54