package ru.arlekk1ng.task;

import java.util.Date;

public class Person {
    private String firstName;
    private String secondName;
    private String lastName;
    private Date birthday;
    private String address;

    public Person(String firstName, String secondName, String lastName, Date birthday,
                  String address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
    }

    public String getFullName() {
        return String.join(" ", secondName, firstName, lastName);
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }
}
