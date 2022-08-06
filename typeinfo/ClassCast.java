/**
 * @Author: fengsc
 * @Date: 2022-08-05 17:44:23
 * @LastEditTime: 2022-08-05 17:46:52
 */
class Build{}
class House extends Build{}
public class ClassCast {
    public static void main(String[] args) {
        Build b=new House();
        Class<House> houseType=House.class;
        House h=houseType.cast(b);
        h=(House)b;//等价的
    }
}
