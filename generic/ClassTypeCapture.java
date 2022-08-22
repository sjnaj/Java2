
/**
 * @Author: fengsc
 * @Date: 2022-08-08 17:15:36
 * @LastEditTime: 2022-08-09 08:42:45
 */
class Building {
}

class House1 extends Building {
}

public class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House1()));
        ClassTypeCapture<House1> ctt2 = new ClassTypeCapture<>(House1.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House1()));
    }
}