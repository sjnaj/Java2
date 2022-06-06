/**
 * @Author: fengsc
 * @Date: 2022-04-02 19:47:32
 * @LastEditTime: 2022-04-02 20:01:22
 */
public class Frctorial {
    static IntCall fact;// *递归必须是静态或实例

    public static void main(String[] args) {
        fact = n -> n == 0 ? 1 : fact.call(n - 1) * n;// 相当于继承自IntCall的匿名对象
        for (int i = 0; i < 10; i++) {
            System.out.println(fact.call(i));//相当于将匿名对象里的函数实名为call
        }
    }

}
// 1
// 1
// 2
// 6
// 24
// 120
// 720
// 5040
// 40320
// 362880