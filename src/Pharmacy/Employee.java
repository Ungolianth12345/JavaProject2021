package Pharmacy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Employee extends Person {
    private GregorianCalendar dateEmployed;

    public GregorianCalendar getDateEmployed() {
        return dateEmployed;
    }

    public void setDateEmployed(GregorianCalendar dateEmployed) {
        this.dateEmployed = dateEmployed;
    }

    @Override
    public String toString() {
        // Source: https://stackoverflow.com/questions/4169634/going-from-mm-dd-yyyy-to-dd-mmm-yyyy-in-java
        DateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        String dateEmployed = sdf.format(getDateEmployed().getTime());

        return super.toString() + "\nDate Employed: " + dateEmployed;
    }

    public Employee() {
        this("No name", "", "", "",
                new GregorianCalendar(1970, Calendar.JANUARY,1),
                new GregorianCalendar(1970, Calendar.JANUARY,1));
    }

    public Employee(String name, String eircode, String username, String password, GregorianCalendar dateOfBirth,
                    GregorianCalendar dateEmployed) {
        super(name, eircode, username, password, dateOfBirth);
        setDateEmployed(dateEmployed);
    }
}
