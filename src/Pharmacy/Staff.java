package Pharmacy;

import java.util.GregorianCalendar;

public class Staff extends Account {
    private GregorianCalendar dateEmployed;
    private int staffID;
    private static int count = 10000;

    public GregorianCalendar getDateEmployed() {
        return dateEmployed;
    }

    public void setDateEmployed(GregorianCalendar dateEmployed) {
        this.dateEmployed = dateEmployed;
    }

    public int getStaffID() {
        return staffID;
    }

    private void autoIncrement() {
        count++;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String toString() {
        return "Name";
    }

    public Staff() {
        this("No name", "", "", "", new GregorianCalendar(1970,1,1),
                new GregorianCalendar(1970,1,1), count);
    }

    public Staff(String name, String eircode, String username, String password, GregorianCalendar dateOfBirth, GregorianCalendar dateEmployed, int staffID) {
        super(name, eircode, username, password, dateOfBirth);

        setDateEmployed(dateEmployed);
        autoIncrement();
        setStaffID(count);
    }
}
