package Pharmacy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Prescription {
    private int PrescriptionID;
    private static int count = 10000;
    private ArrayList<Drug> drugs;
    private GregorianCalendar dateIssued;

    public int getPrescriptionID() {
        return PrescriptionID;
    }

    private void autoIncrement() {
        count++;
    }

    public void setID(int PrescriptionID) {
        this.PrescriptionID = PrescriptionID;
    }

    public ArrayList<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(ArrayList<Drug> drugs) {
        this.drugs = drugs;
    }

    public GregorianCalendar getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(GregorianCalendar dateIssued) {
        this.dateIssued = dateIssued;
    }

    public String toString() {
        StringBuilder prescrip = new StringBuilder("Medicine requested: \n");
        for (int i = 0; i < getDrugs().size(); i++) {
            prescrip.append(getDrugs().get(i)).append('\n');
        }

        // seems as though I can't edit dateOfBirth to accommodate a string.
        // Source: https://stackoverflow.com/questions/4169634/going-from-mm-dd-yyyy-to-dd-mmm-yyyy-in-java
        DateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        String date = sdf.format(getDateIssued().getTime());

        return prescrip.toString() + "Date issued: " + date;
    }

    public Prescription() {
        this(new ArrayList<Drug>(),
                new GregorianCalendar(1970, Calendar.JANUARY,1));
    }

    public Prescription(ArrayList<Drug> drugs, GregorianCalendar dateIssued) {
        setDrugs(drugs);
        setDateIssued(dateIssued);
        autoIncrement();
        setID(count);
    }
}
