
/**
 * @Author: fengsc
 * @Date: 2022-04-01 09:40:55
 * @LastEditTime: 2022-04-01 15:41:08
 */
import java.util.*;

class Snow {
}

class Powder extends Snow {
}

class Light extends Powder {
}

class Heavy extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}

public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(
                new Crusty(), new Slush(), new Powder());
        // - snow1.add(new Heavy()); // Exception
        List<Snow> snow2 = Arrays.asList(
                new Light(), new Heavy());
        // - snow2.add(new Slush()); // Exception
        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3,
                new Light(), new Heavy(), new Powder());
        snow3.add(new Crusty());
        // Hint with explicit type argument specification:使向上转型发生在asList而不是构造snow4的过程中
        List<Snow> snow4 = Arrays.<Snow>asList(
                new Light(), new Heavy(), new Slush());
        // - snow4.add(new Powder()); // Exception
    }

}