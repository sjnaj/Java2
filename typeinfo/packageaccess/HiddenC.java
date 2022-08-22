
/**
 * @Author: fengsc
 * @Date: 2022-08-08 12:08:48
 * @LastEditTime: 2022-08-08 13:40:36
 */
package packageaccess;

import interfacea.*;

class C implements A {
    @Override
    public void f() {
        System.out.println("public C.f()");
    }

    public void g() {
        System.out.println("public C.g()");
    }

    void u() {
        System.out.println("package C.u()");
    }

    protected void v() {
        System.out.println("protected C.v()");
    }

    private void w() {
        System.out.println("private C.w()");
    }
}

public class HiddenC {
    public static A makeA() {
        return new C();
    }

}