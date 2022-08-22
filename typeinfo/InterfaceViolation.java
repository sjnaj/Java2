
/**
 * @Author: fengsc
 * @Date: 2022-08-08 11:56:46
 * @LastEditTime: 2022-08-08 12:01:12
 */
import interfacea.*;

class B implements A {
    public void f() {
    }

    public void g() {
    }
}

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        // a.g();undefined
        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            
            B b = (B) a;
            b.g();
        }
    }
}