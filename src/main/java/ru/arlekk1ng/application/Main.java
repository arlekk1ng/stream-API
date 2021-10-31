package ru.arlekk1ng.application;

import java.io.FileNotFoundException;
import java.util.Collection;
import org.json.simple.parser.ParseException;
import ru.arlekk1ng.loader.JSONPersonLoader;
import ru.arlekk1ng.task.Person;
import ru.arlekk1ng.task.Persons;

public class Main {
    private static final String FILENAME = "src/main/resources/people.json";

    public static void main(String[] args) {
        try {
            Collection<Person> people = JSONPersonLoader.parseToCollection(FILENAME);

            System.out.println("all full names:");
            Persons.printFullNamesOfAllPersons(people);

            System.out.println("\nborn in 1992:");
            Persons.printFullNamesOfPersonsBornIn(people, 1992);

            Collection<String> uniqueAddresses = Persons.formationCollectionUniqueAddresses(people);
            System.out.println("\nunique addresses:");
            uniqueAddresses.stream().forEach(System.out::println);
        } catch (FileNotFoundException | ParseException exception) {
            exception.printStackTrace();
        }
    }
}
