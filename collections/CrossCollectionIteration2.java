
/**
 * @Author: fengsc
 * @Date: 2022-04-01 21:47:28
 * @LastEditTime: 2022-04-01 21:53:56
 */
import java.util.*;
import reflection.pets.*;

public class CrossCollectionIteration2 {
    public static void display(Iterable<Pet> ip) {// 向上转型为接口，iterator即定义在其内
        Iterator<Pet> it = ip.iterator();
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> pets = new PetCreator().list(7);
        LinkedList<Pet> petsLL = new LinkedList<>(pets);
        HashSet<Pet> petsHS = new HashSet<>(pets);
        TreeSet<Pet> petsTS = new TreeSet<>(pets);
        display(pets);
        display(petsLL);
        display(petsHS);
        display(petsTS);
    }

}
/*
 * 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug
 * 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug
 * 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug
 * 5:Cymric 2:Cymric 1:Manx 3:Mutt 6:Pug 4:Pug 0:Rat
 */