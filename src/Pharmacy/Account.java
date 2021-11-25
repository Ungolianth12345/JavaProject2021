package Pharmacy;

import java.util.GregorianCalendar;

public abstract class Account {
    private String name;
    // This is a terrible idea but there is no way in hell I'm writing 12 different addresses.
    private String eircode;
    private String username;
    private String password;
    private GregorianCalendar dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nEircode: " + getEircode() + "Date of Birth: " + getDateOfBirth();
    }

    public Account(String name, String eircode, String username, String password, GregorianCalendar dateOfBirth) {
        setName(name);
        setEircode(eircode);
        setUsername(username);
        setPassword(password);
        setDateOfBirth(dateOfBirth);
    }
}
