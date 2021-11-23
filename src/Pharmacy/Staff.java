package Pharmacy;

import java.util.GregorianCalendar;

public abstract class Staff implements Account {
    private String name;
    private String address;
    private String username;
    private String password;
    private GregorianCalendar dateOfBirth;
    private GregorianCalendar dateEmployed;
    private int staffID;
    private int staffCount;

    public Staff() {
        this("No name", "", "", "", new GregorianCalendar(1970,1,1),
                new GregorianCalendar(1970,1,1), 0);
    }

    public Staff(String name, String address, String username, String password, GregorianCalendar dateOfBirth, GregorianCalendar dateEmployed, int staffID) {
        setName(name);
        setAddress(address);
        setUsername(username);
        setPassword(password);
        setDateOfBirth(dateOfBirth);
        setDateEmployed(dateEmployed);
        setStaffID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public GregorianCalendar getDateEmployed() {
        return dateEmployed;
    }

    public void setDateEmployed(GregorianCalendar dateEmployed) {
        this.dateEmployed = dateEmployed;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID() {
        staffCount++;
        this.staffID = staffCount;
    }

    public String toString() {
        return "Name";
    }
}
