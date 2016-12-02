package de.assertagile.workshop.spocktesting;

import java.time.LocalDate;

class UserEntity {

    private String userName;
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    public UserEntity() {}

    public UserEntity(String userName, String firstName, String lastName, LocalDate birthday) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
