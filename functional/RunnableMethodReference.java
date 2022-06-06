/**
 * @Author: fengsc
 * @Date: 2022-04-02 20:26:14
 * @LastEditTime: 2022-04-02 20:34:45
 */
class Go {
    static void go() {
        System.out.println("Go::go");
    }
}

public class RunnableMethodReference {
    public static void main(String[] args) {
        new Thread(new Runnable() {//Runnable只有一个无参无返回的run函数
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();
        new Thread(() -> System.out.println("Lambda")).start();
        new Thread(Go::go).start();

    }

}
/*
 * Anonymous
 * Lambda
 * Go::go
 */
