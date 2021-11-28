package de.functional.function;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalStuff {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Ella", Gender.FEMALE),
                new Person("Max", Gender.MALE),
                new Person("Claudia", Gender.FEMALE),
                new Person("Jochen", Gender.MALE)
        );

        // imperative approach
        List<Person> females = new ArrayList<>();
        for(Person person : people) {
            if(Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
        for (Person female : females) {
            System.out.println(female);
        }

        // declarative approach
        people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                //.collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static class Person {
        String name;
        Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
