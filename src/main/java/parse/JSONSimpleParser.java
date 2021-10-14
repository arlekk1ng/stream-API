package parse;

import main_task.Person;

import java.util.List;
import java.util.ArrayList;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Date;
import java.text.SimpleDateFormat;

public class JSONSimpleParser {

    private JSONSimpleParser() {

    }

    private static final String TAG_NAME;
    private static final String TAG_SURNAME;
    private static final String TAG_LASTNAME;
    private static final String TAG_BIRTHDAY;
    private static final String TAG_ADDRESS;
    private static final String DATE_FORMAT;

    static {
        TAG_NAME = "name";
        TAG_SURNAME = "surname";
        TAG_LASTNAME = "lastName";
        TAG_BIRTHDAY = "birthday";
        TAG_ADDRESS = "address";
        DATE_FORMAT = "dd.MM.yyyy";
    }


    public static List<Person> parseToList(final String fileName) throws FileNotFoundException,
                                                                   org.json.simple.parser.ParseException
    {
        List<Person> people = new ArrayList<>();

        try (FileReader reader = new FileReader(fileName)) {
            JSONArray peopleJSONArray = (JSONArray) new JSONParser().parse(reader);
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);

            for (Object item: peopleJSONArray) {
                JSONObject personJSONObject = (JSONObject) item;

                String firstName = (String) personJSONObject.get(TAG_NAME);
                String secondName = (String) personJSONObject.get(TAG_SURNAME);
                String lastName = (String) personJSONObject.get(TAG_LASTNAME);
                String address = (String) personJSONObject.get(TAG_ADDRESS);

                String birthday = (String) personJSONObject.get(TAG_BIRTHDAY);
                Date date = null;

                try {
                    date = format.parse(birthday);
                } catch (java.text.ParseException exception) {
                    System.out.println("У объекта \"" + String.join(" ", secondName, firstName, lastName) +
                                       "\" не удалось получить дату рождения.");
                }

                people.add(new Person(firstName, secondName, lastName, date, address));
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return people;
    }
}
