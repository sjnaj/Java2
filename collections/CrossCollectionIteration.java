
/**
 * @Author: fengsc
 * @Date: 2022-04-01 21:41:02
 * @LastEditTime: 2022-04-01 21:45:10
 */
import java.util.*;
import reflection.pets.*;

public class CrossCollectionIteration {
    public static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> pets = new PetCreator().list(8);
        LinkedList<Pet> pets2 = new LinkedList<>(pets);
        HashSet<Pet> pets3 = new HashSet<>(pets);
        TreeSet<Pet> pets4 = new TreeSet<>(pets);
        display(pets.iterator());
        display(pets2.iterator());
        display(pets3.iterator());
        display(pets4.iterator());
    }

}
/*
 * 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
 * 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
 * 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
 * 5:Cymric 2:Cymric 7:Manx 1:Manx 3:Mutt 6:Pug 4:Pug 0:Rat
 */
