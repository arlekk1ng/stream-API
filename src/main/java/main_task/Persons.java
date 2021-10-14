package main_task;

import java.util.Collection;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.stream.Collectors;

public class Persons {

    private Persons() {

    }

    public static void printAllFullNames(Collection<? extends Person> collection) {
        collection.stream().forEach(person -> {
            System.out.println(
                    String.join(" ", person.getSecondName(), person.getFirstName(), person.getLastName())
            );
        });
    }

    public static void printFullNamesBornIn(Collection<? extends Person> collection, int year) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");

        collection.stream().filter(person -> {
            return format.format(person.getBirthday()).equals(String.valueOf(year));
        }).map(person -> {
            return String.join(" ", person.getSecondName(), person.getFirstName(), person.getLastName());
        }).forEach(System.out::println);
    }

    public static List<String> formationListUniqueAddresses(Collection<? extends Person> collection) {
        return collection.stream().map(person -> person.getAddress()).distinct().collect(Collectors.toList());
    }
}
