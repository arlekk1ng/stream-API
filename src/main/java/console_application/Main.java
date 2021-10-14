package console_application;

import main_task.*;
import parse.JSONSimpleParser;

import java.util.List;

import java.io.FileNotFoundException;
import org.json.simple.parser.ParseException;

public class Main {
    private static final String fileName = "src/main/resources/people.json";

    public static void main(String[] args) {

        try {
            List<Person> people = JSONSimpleParser.parseToList(fileName);

            System.out.println("all full names:");
            Persons.printAllFullNames(people);

            System.out.println("\nborn in 1992:");
            Persons.printFullNamesBornIn(people, 1992);

            List<String> uniqueAddresses = Persons.formationListUniqueAddresses(people);
            System.out.println("\nunique addresses:");
            uniqueAddresses.stream().forEach(System.out::println);

        } catch (FileNotFoundException | ParseException exception) {
            exception.printStackTrace();
        }
    }
}
