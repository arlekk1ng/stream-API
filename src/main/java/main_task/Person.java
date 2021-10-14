package main_task;

import java.util.Date;

public class Person {
    private String firstName;
    private String secondName;
    private String lastName;
    private Date birthday;
    private String address;

    public Person(String firstName, String secondName, String lastName,
                  Date birthday, String address)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }
}
