/**
 * @Author: fengsc
 * @Date: 2022-04-02 21:25:11
 * @LastEditTime: 2022-04-02 21:30:22
 */
class Child {
    String name;
    int age = -1; // For "unknown"

    Child() {
        name = "stray";
    }

    Child(String nm) {
        name = nm;
    }

    Child(String nm, int yrs) {
        name = nm;
        age = yrs;
    }
}

interface MakeNoArgs {
    Child make();
}

interface Make1Arg {
    Child make(String nm);
}

interface Make2Args {
    Child make(String nm, int age);
}

public class ConstructorReference {
    public static void main(String[] args) {
        MakeNoArgs mna = Child::new; // [1]
        Make1Arg m1a = Child::new;// [2]
        Make2Args m2a = Child::new;// [3]
        Child dn = mna.make();
        Child d1 = m1a.make("Comet");
        Child d2 = m2a.make("Ralph", 4);
    }

}