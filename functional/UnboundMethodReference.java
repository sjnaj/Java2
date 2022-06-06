/**
 * @Author: fengsc
 * @Date: 2022-04-02 20:38:39
 * @LastEditTime: 2022-04-02 21:01:41
 */
class X {
    String f() {
        return "X::f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class UnboundMethodReference {
    public static void main(String[] args) {
        // MakeString ms = X::f; // 未实例化不能绑定
        TransformX sp = X::f;//有this参数，可以在未实例化时绑定
        X x = new X();
        System.out.println(sp.transform(x)); 
        System.out.println(x.f()); // 同等效果
    }

}
// X::f()
// X::f()
