
/**
 * @Author: fengsc
 * @Date: 2022-08-06 11:50:48
 * @LastEditTime: 2022-08-06 11:55:41
 */
package pets;

import java.util.*;
import java.util.stream.*;

public class Pets {
    public static final PetCreator CREATOR = new LiteralPetCreator();

    public static Pet get() {
        return CREATOR.get();
    }

    public static Pet[] array(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++)
            result[i] = CREATOR.get();
        return result;
    }

    public static List<Pet> list(int size) {
        List<Pet> result = new ArrayList<>();
        Collections.addAll(result, array(size));
        return result;
    }
    public static Stream<Pet> stream(){
        return Stream.generate(CREATOR);
    }
}