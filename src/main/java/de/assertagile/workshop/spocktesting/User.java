package de.assertagile.workshop.spocktesting;

import java.time.LocalDate;

public class User {

    private final String userName;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;

    public User(final String userName, final String firstName, final String lastName, final LocalDate birthday) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public boolean isOfAge() {
        return false;
    }

    public UserEntity toEntity() {
        return null;
    }
}
