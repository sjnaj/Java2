
/**
 * @Author: fengsc
 * @Date: 2022-04-02 09:31:42
 * @LastEditTime: 2022-04-02 09:42:09
 */
import java.util.*;
import reflection.pets.*;

public class MapOfList {
    public static final Map<Person, List<? extends Pet>> petPeople = new HashMap<>();
    static {// 只初始化一次
        petPeople.put(new Person("Dawn"),
                Arrays.asList(new Cymric("Molly"),
                        new Mutt("Spot")));
        petPeople.put(new Person("Kate"),
                Arrays.asList(new Cat("Shackleton"),
                        new Cat("Elsie May"),
                        new Dog("Margrett")));
        petPeople.put(new Person("Marilyn"),
                Arrays.asList(
                        new Pug("Louie aka Louis Snorkelstein Dupree"),
                        new Cat("Stanford"),
                        new Cat("Pinkola")));
        petPeople.put(new Person("Luke"),
                Arrays.asList(
                        new Rat("Fuzzy"),
                        new Rat("Fizzy")));
        petPeople.put(new Person("Isaac"),
                Arrays.asList(new Rat("Freckly")));
    }

    public static void main(String[] args) {
        System.out.println("People: " + petPeople.keySet());//键集合
        System.out.println("Pets: " + petPeople.values());//值集合
        for (Person person : petPeople.keySet()) {// 依键遍历
            System.out.println(person + " has:");
            for (Pet pet : petPeople.get(person))// 遍历List
                System.out.println("" + pet);
        }
    }

}
/*
 * People: [Luke, Dawn, Isaac, Kate, Marilyn]
 * Pets: [[Rat Fuzzy, Rat Fizzy], [Cymric Molly, Mutt Spot], [Rat Freckly], [Cat
 * Shackleton, Cat Elsie May, Dog Margrett], [Pug Louie aka Louis Snorkelstein
 * Dupree, Cat Stanford, Cat Pinkola]]
 * Luke has:
 * Rat Fuzzy
 * Rat Fizzy
 * Dawn has:
 * Cymric Molly
 * Mutt Spot
 * Isaac has:
 * Rat Freckly
 * Kate has:
 * Cat Shackleton
 * Cat Elsie May
 * Dog Margrett
 * Marilyn has:
 * Pug Louie aka Louis Snorkelstein Dupree
 * Cat Stanford
 * Cat Pinkola
 */