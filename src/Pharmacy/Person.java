package Pharmacy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Person {
    private String name;
    // This is a terrible idea but there is no way in hell I'm writing 12 different addresses.
    private String eircode;
    private GregorianCalendar dateOfBirth;
    private String username;
    private String password;

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

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    // It's too late, I couldn't get this implemented
    public String getAccount() {
        return getUsername() + ", " + getPassword();
    }

    public void setAccount(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    @Override
    public String toString() {
        /*******************************************************************
         *Title: Going from MM/DD/YYYY to DD-MMM-YYYY in java
         *Author: Brian Clements
         *Site owner/sponsor: stackoverflow.com
         *Date: Nov 12 2010
         *Code Version: Nov 12 2010
         *Availability: https://stackoverflow.com/questions/4169634/going-from-mm-dd-yyyy-to-dd-mmm-yyyy-in-java (Accessed: Nov 29 2021)
         *Modified: Code refactored
         *******************************************************************/
        // seems as though I can't edit dateOfBirth to accommodate a string.
        DateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        String date = sdf.format(getDateOfBirth().getTime());

        return "Name: " + getName() + "\nEircode: " + getEircode() + "\nAccount: " + getAccount() + "\nDate of Birth: "
                + date;
    }

    public Person() {
        this("No name", "No Eircode", "", "",
                new GregorianCalendar(1970, Calendar.JANUARY, 1));
    }

    public Person(String name, String eircode, String username, String password, GregorianCalendar dateOfBirth) {
        setName(name);
        setEircode(eircode);
        setAccount(username, password);
        setDateOfBirth(dateOfBirth);
    }
}
