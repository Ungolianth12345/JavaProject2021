package Pharmacy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Staff extends Employee {
    private int staffID;
    private static int count = 10000;

    public int getStaffID() {
        return staffID;
    }

    private void autoIncrement() {
        count++;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    @Override
    public String toString() {
        return super.toString() + "\nStaff ID: " + getStaffID();
    }

    public Staff() {
        this("No name", "", "", "", new GregorianCalendar(1970,1,1),
                new GregorianCalendar(1970,1,1));
    }

    public Staff(String name, String eircode, String username, String password, GregorianCalendar dateOfBirth,
                 GregorianCalendar dateEmployed) {
        super(name, eircode, username, password, dateOfBirth, dateEmployed);
        autoIncrement();
        setStaffID(count);
    }
}
