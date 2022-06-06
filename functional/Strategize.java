/**
 * @Author: fengsc
 * @Date: 2022-04-02 18:05:44
 * @LastEditTime: 2022-04-02 19:24:14
 */
interface Strategy {
    String approach(String msg);

    default String approach1(String msg) {
        return msg;
    }
}

class Soft implements Strategy {
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }

}

class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}

public class Strategize {
    Strategy strategy;
    String msg;

    Strategize(String msg) {
        this.msg = msg;
        strategy = new Soft();// 1
    }

    void communicate() {
        System.out.println(strategy.approach1(msg));
    }

    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
                new Strategy() {
                    public String approach(String msg) {
                        return msg.toUpperCase() + "!";// 2
                    }
                },
                msg -> msg.substring(0, 5), // 3
                Unrelated::twice,
        };
        Strategize s = new Strategize("Hello there");
        s.communicate();// action 1
        for (Strategy strategy : strategies) {// action 2,3,4
            s.changeStrategy(strategy);
            s.communicate();// 打印不同strategy被approch的结果
        }

    }

}
/*
 * hello there?
 * HELLO THERE!
 * Hello
 * Hello there Hello there
 */
