
/**
 * @Author: fengsc
 * @Date: 2022-04-02 11:03:42
 * @LastEditTime: 2022-08-07 12:21:54
 */
import java.util.*;
import reflection.pets.*;

public class CollectionSequence extends AbstractCollection<Pet> {
    private Pet[] pets = new PetCreator().array(8);

    @Override
    public int size() {
        return pets.length;
    }

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public void remove() {// 不强制实现，default是抛出不支持异常
                Arrays.asList(pets).remove(pets[index - 1]);
            }

        };
    }

    public static void main(String[] args) {
        CollectionSequence cs = new CollectionSequence();
        InterfaceVsIterator.display(cs);
    }

}
// 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 