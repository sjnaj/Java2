/**
 * @Author: fengsc
 * @Date: 2022-04-02 09:25:59
 * @LastEditTime: 2022-04-02 09:25:59
 */
import java.util.*;
import reflection.pets.*;
public class PetMap {
    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        System.out.println(petMap);
        Pet dog = petMap.get("My Dog");
        System.out.println(dog);
        System.out.println(petMap.containsKey("My Dog"));
        System.out.println(petMap.containsValue(dog));
        }
    
}
