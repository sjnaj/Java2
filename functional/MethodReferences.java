
/**
 * @Author: fengsc
 * @Date: 2022-04-02 20:15:15
 * @LastEditTime: 2022-06-06 13:46:49
 */

interface Callable {

    void call(String s);
}

class Describe {
    void show(String msg) {
        System.out.println(msg);
    }
}

public class MethodReferences {
    static void hello(String name) {
        System.out.println("Hello ," + name);

    }

    static class Description {
        String about;

        Description(String desc) {
            about = desc;
        }

        void help(String msg) {
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        static void assist(String msg) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        Callable c = d::show;//绑定到实例方法
        c.call("call()");
        c = MethodReferences::hello;//绑定到静态方法
        c.call("Bob");
        c = new Description("valuable")::help;
        c.call("information");
        c = Helper::assist;
        c.call("Help!");
    }

}
/*
 * call()
 * Hello ,Bob
 * valuable information
 * Help!
 */