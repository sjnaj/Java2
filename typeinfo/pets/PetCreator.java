/**
 * @Author: fengsc
 * @Date: 2022-08-05 18:39:41
 * @LastEditTime: 2022-08-06 14:16:39
 */
package pets;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.*;

public abstract class PetCreator implements Supplier<Pet> {
    private Random rand = new Random(47);

    public abstract List<Class<? extends Pet>> types();

    @Override
    public Pet get() {
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException
                | SecurityException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
