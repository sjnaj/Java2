
/**
 * @Author: fengsc
 * @Date: 2022-04-02 11:52:49
 * @LastEditTime: 2022-04-02 13:57:06
 */
import java.util.*;
import reflection.pets.*;

class PetSequence {
    protected Pet[] pets = new PetCreator().array(8);
}

public class OnlyIteratorSequence extends PetSequence {//只需要迭代相关的方法时可只实现Iterator接口而不必继承AbstractCollection
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        OnlyIteratorSequence nc = new OnlyIteratorSequence();
        InterfaceVsIterator.display(nc.iterator());
    }

}
// 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 