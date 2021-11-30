package Pharmacy;

import javax.swing.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestDriver {
    public static void main(String[] args) {
        Drug m1 = new Drug("Thiosonide", "250 mg tablets", 2.49, "ColdFlu");
        Drug m2 = new Drug("Nutritriptan", "300 mg tablets", 5.49, "Digestion");
        Drug m3 = new Drug("Aeromara", "500 ml", 12.99, "Respiratory");

        ArrayList<Drug> testBatch = new ArrayList<>();
        testBatch.add(m1);
        testBatch.add(m2);
        testBatch.add(m3);

        Prescription p1 = new Prescription(10001, "Manager", testBatch,
                new GregorianCalendar(2021, Calendar.NOVEMBER, 21));

        Staff staff1 = new Staff("Slartibartfast", "A131CF9", "slarty", "slarty",
                new GregorianCalendar(1952, Calendar.APRIL, 9),
                new GregorianCalendar(2002, Calendar.SEPTEMBER,12));

        Staff staff2 = new Staff("Alice O' Connor", "F527D79", "alioc", "jaques",
                new GregorianCalendar(1982, Calendar.JUNE, 22),
                new GregorianCalendar(2009, Calendar.FEBRUARY, 12));

        ArrayList<Staff> staffManaged = new ArrayList<>();
        staffManaged.add(staff1);
        staffManaged.add(staff2);

        Manager manager1 = new Manager("Patrick Sullivan", "J45M29", "admin", "admin",
                new GregorianCalendar(1971, Calendar.AUGUST, 22),
                new GregorianCalendar(1999, Calendar.JANUARY, 5), staffManaged);

        Customer customer1 = new Customer();

//        System.out.println("---\nMedicine check\n---\n" + m1);
//        System.out.println("\n---\nPrescription check\n---\n" + p1);
//        System.out.println("\n---\nStaff check\n---\n" + staff1 + "\n\n" + staff2);
//        System.out.println("\n---\nManager check\n---\n" + manager1);
//        System.out.println("\n---\nCustomer check\n---\n" + customer1);

//        new AuthorisationGUI();
//        new MainMenuGUI();
//        new AddEditStaffGUI();

        /*GregorianCalendar cal = new DateChooser(new MainMenuGUI()).getDateChosen();
        DateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        String date = sdf.format(cal.getTime());
        System.out.println(date);*/

        /*GregorianCalendar cal = new GregorianCalendar(2021, Calendar.NOVEMBER, 28);
        System.out.println(cal);
        System.out.println(cal.toZonedDateTime().getDayOfMonth());
        System.out.println(cal.toZonedDateTime().getMonth());
        System.out.println(cal.toZonedDateTime().getYear());*/


        File out = new File("src/Pharmacy/out.dat");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(out);

            Drug d1 = new Drug("Thiosonide", "250 mg tablets", 2.49, "ColdFlu");
            Drug d2 = new Drug("Nutritriptan", "300 mg tablets", 5.49, "Digestion");
            Drug d3 = new Drug("Aeromara", "500 ml", 12.99, "Respiratory");

            ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutputStream);

            objectOutStream.writeObject(d1);
            objectOutStream.writeObject(d2);
            objectOutStream.writeObject(d3);

            fileOutputStream.close();
        } catch (FileNotFoundException fnfe) {
            fnfe.getStackTrace();
            JOptionPane.showMessageDialog(null,"File could not be found!",
                    "Problem Finding File!",JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            ioe.getStackTrace();
            JOptionPane.showMessageDialog(null,"File could not be written!",
                    "Problem Writing to File!",JOptionPane.ERROR_MESSAGE);
        }
    }
}

/*
 * Here I will write some fun facts. Yes, this is unnecessary to the project but I am putting it here anyway,
 * cuz why not ¯\_(ツ)_/¯
 *
 * Warm water with salt and sugar is very useful for sick people who lost fluids due to flu or diarrhea. It is also
 * known as Oral rehydration therapy.
 *
 * Plague doctors were cool, despite the costume not working. They believed certain smells carried the bubonic plague,
 * which is half-way correct. Bad smells can indicate bacteria/disease. They put sweet-smelling things like lavender and
 * spices in the "beak" to attempt to ward off disease. This failed, tragically.
 * Most plague doctors were volunteers or young doctors learning the ropes.
 * One guy was a fruit salesman before becoming a plague doctor. They say "an apple a day keeps the doctor away". I bet
 * some of them regret not buying more fruit.
 *
 * There are thin tubes that connect the corner of your eye to your nose. This drains tears into your nose.
 * If you cry, the amount of fluid going into your nose increases, which is why your nose runs when you cry.
 *
 * After you eat a large meal, the acid produced in your stomach in effect makes your blood slightly basic. This makes
 * your oxygen bond harder to your red blood cells so less oxygen gets released into your tissues.
 * The effect: tiredness after you eat.
 * */