
/**
 * @Author: fengsc
 * @Date: 2022-06-06 15:24:13
 * @LastEditTime: 2022-06-06 18:09:37
 */

public class Machina {

    public enum State {
        START, ONE, TWO, THREE, END;

        State step() {
            if (equals(END)) {
                return END;
            }
            return values()[ordinal() + 1];
        }
    };

    private State state = State.START;
    private final int id;

    public Machina(int id) {
        this.id = id;
    }

    public static Machina work(Machina m) {
        if (!m.state.equals(State.END)) {//work() 方法将机器从一个状态移动到下一个状态，并且需要 100 毫秒才能完成 “工作”。
            new Nap(1);
            m.state = m.state.step();
        }
        System.out.println(m);
        return m;
    }

    @Override
    public String toString() {
        return "Machina" + id + ": " + (state.equals(State.END) ? "complete" : state);
    }

}