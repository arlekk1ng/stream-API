package ru.arlekk1ng.task;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.stream.Collectors;

public class Persons {
    private Persons() {
    }

    public static void printFullNamesOfAllPersons(Collection<? extends Person> collection) {
        collection.stream().forEach(person -> System.out.println(person.getFullName()));
    }

    public static void printFullNamesOfPersonsBornIn(Collection<? extends Person> collection,
                                                     final int yearOfBirth) {
        SimpleDateFormat dateFormatAsYearOfBirth = new SimpleDateFormat("yyyy");

        collection.stream().filter(person ->
            dateFormatAsYearOfBirth.format(person.getBirthday()).equals(String.valueOf(yearOfBirth))
        ).map(person -> person.getFullName()).forEach(System.out::println);
    }

    public static Collection<String> formationCollectionUniqueAddresses(
            Collection<? extends Person> collection) {
        return collection.stream().map(person -> person.getAddress()).distinct()
                         .collect(Collectors.toList());
    }
}
