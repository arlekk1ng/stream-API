package ru.arlekk1ng.loader;

import static ru.arlekk1ng.loader.JSONPersonTags.DATE_FORMAT;
import static ru.arlekk1ng.loader.JSONPersonTags.TAG_ADDRESS;
import static ru.arlekk1ng.loader.JSONPersonTags.TAG_BIRTHDAY;
import static ru.arlekk1ng.loader.JSONPersonTags.TAG_LASTNAME;
import static ru.arlekk1ng.loader.JSONPersonTags.TAG_NAME;
import static ru.arlekk1ng.loader.JSONPersonTags.TAG_SURNAME;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import ru.arlekk1ng.task.Person;

public class JSONPersonLoader {
    private JSONPersonLoader() {
    }

    public static Collection<Person> parseToCollection(final String fileName)
            throws FileNotFoundException, org.json.simple.parser.ParseException {
        Collection<Person> people = new ArrayList<>();

        try (FileReader reader = new FileReader(fileName)) {
            JSONArray jsonArrayOfPeople = (JSONArray) new JSONParser().parse(reader);
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

            for (Object item : jsonArrayOfPeople) {
                JSONObject personJsonObject = (JSONObject) item;

                String firstName = (String) personJsonObject.get(TAG_NAME);
                String secondName = (String) personJsonObject.get(TAG_SURNAME);
                String lastName = (String) personJsonObject.get(TAG_LASTNAME);
                String address = (String) personJsonObject.get(TAG_ADDRESS);

                String birthday = (String) personJsonObject.get(TAG_BIRTHDAY);
                Date date = null;

                try {
                    date = dateFormat.parse(birthday);
                } catch (java.text.ParseException exception) {
                    System.out.println(
                            "У объекта \"" + String.join(" ", secondName, firstName, lastName)
                            + "\" не удалось получить дату рождения."
                    );
                }

                people.add(new Person(firstName, secondName, lastName, date, address));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return people;
    }
}
