
/**
 * @Author: fengsc
 * @Date: 2022-08-05 19:22:27
 * @LastEditTime: 2022-08-06 10:54:15
 */
package pets;

import java.util.*;

public class LiteralPetCreator extends PetCreator {
    public static final List<Class<? extends Pet>> ALL_TYPES = Collections// 不可修改视图
            .unmodifiableList(Arrays.asList(Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class,
                    Manx.class, Cymric.class, Rat.class,
                    Mouse.class, Hamster.class));
    // 用于随机创建的类型:
    private static final List<Class<? extends Pet>> TYPES = ALL_TYPES.subList(ALL_TYPES.indexOf(Mutt.class),
            ALL_TYPES.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return TYPES;
    }

    public static void main(String[] args) {
        System.out.println(TYPES);
    }

}