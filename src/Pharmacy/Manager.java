package Pharmacy;

import java.util.ArrayList;
import java.util.GregorianCalendar;

// is member of staff. two managers that manage a different set of staff. staffManaged = arryalist
// use same gui but greyed out options are selectable or visible
public class Manager extends Employee {
    private ArrayList<Staff> staffManaged;

    public ArrayList<Staff> getStaffManaged() {
        return staffManaged;
    }

    public void setStaffManaged(ArrayList<Staff> staffManaged) {
        this.staffManaged = staffManaged;
    }

    public String toString() {
        StringBuilder staffManaged = new StringBuilder("Staff managed:\n");
        for (int i = 0; i < getStaffManaged().size(); i++) {
            staffManaged.append(getStaffManaged().get(i).getName()).append(", Staff ID: ").append(getStaffManaged().get(i)
                    .getStaffID()).append('\n');
        }

        return super.toString() + "\n" + staffManaged;
    }

    public Manager(String name, String eircode, String username, String password, GregorianCalendar dateOfBirth,
                   GregorianCalendar dateEmployed, ArrayList<Staff> staffManaged) {
        super(name, eircode, username, password, dateOfBirth, dateEmployed);
        setStaffManaged(staffManaged);
    }
}
