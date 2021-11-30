package Pharmacy;

import java.util.GregorianCalendar;

public class Customer extends Person {
    private Prescription prescription;

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public String toString() {
        return super.toString();
    }

    public Customer() {
        this("No name", "", "", "", new GregorianCalendar(1970,1,1));
    }

    public Customer(String name, String eircode, String username, String password, GregorianCalendar dateOfBirth) {
        super(name, eircode, username, password, dateOfBirth);
        setPrescription(prescription);
    }
}
